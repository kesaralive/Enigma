package com.controllers;

import com.models.CashierModel;
import com.models.CustomerModel;

import java.sql.SQLException;
import java.util.List;

public class CustomerController {
    private Integer id;
    private String name;
    private String mobile;
    private String address;
    private Integer points;

    //Getters
    public Integer getId(){return id;}
    public String getName(){return name;}
    public String getMobile(){return mobile;}
    public String getAddress(){return address;}
    public Integer getPoints(){return points;}

    //Setters
    public void setId(Integer id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setMobile(String mobile){this.mobile = mobile;}
    public void setAddress(String address){this.address = address;}
    public void setPoints(Integer points){this.points = points;}

    public Boolean createCustomer() throws SQLException{
        String[] customer = {this.name, this.mobile, this.address};
        CashierModel cm = new CashierModel();
        return cm.createCustomer(customer);
    }

    public static List<CustomerController> viewCustomers() throws SQLException{
        CustomerModel cm = new CustomerModel();
        List<CustomerController> customers = cm.getCustomers();
        return customers;
    }

    public CustomerController searchCustomer(String mobile) throws SQLException {
        CustomerModel cm = new CustomerModel();
        CustomerController cc = cm.searchCustomer(mobile);
        return cc;
    }
    
    public boolean customerExists(String cusMobile) throws Exception {
        CustomerModel cm = new CustomerModel();
        if(cm.customerExists(cusMobile)) {
            return true;
        } else {
            return false;
        }
    }
    
    public static CustomerController getCustomerPoints(String cusMobileNo) throws Exception {
        CustomerModel cm = new CustomerModel();
        CustomerController cc = new CustomerController();
        cc = cm.getCustomerPoints(cusMobileNo);
        return cc;
    }
    
    public boolean deductPoints(int balancePoints, String cusMobileNo) throws SQLException {
        CustomerModel cm = new CustomerModel();
        if(cm.deductPoints(balancePoints, cusMobileNo)) {
            return true;
        } else {
            return false;
        }
    }
}