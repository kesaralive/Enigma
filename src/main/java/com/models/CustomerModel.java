package com.models;

import com.controllers.CustomerController;
import com.libraries.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
    private static Database db;
    private static ResultSet res;

    public List<CustomerController> getCustomers() throws SQLException {
        db = new Database();
        db.query("SELECT * FROM customer");
        res = db.executeQuery();
        List<CustomerController> list = new ArrayList<CustomerController>();
        while(res.next()){
            CustomerController cc = new CustomerController();
            cc.setId(res.getInt("cus_id"));
            cc.setName(res.getString("name"));
            cc.setMobile(res.getString("mobile"));
            cc.setAddress(res.getString("address"));
            cc.setPoints(res.getInt("points"));
            list.add(cc);
        }
        return list;
    }

    public static void main(String[] args) throws SQLException {

    }

    public CustomerController searchCustomer(String mobile) throws SQLException {
        db = new Database();
        db.query("SELECT * FROM customer where mobile = ?");
        db.bindString(1, mobile);
        res = db.executeQuery();
        CustomerController cc = new CustomerController();
        if(res.next()){
            cc.setId(res.getInt(("cus_id")));
            cc.setName(res.getString("name"));
            cc.setMobile(res.getString("mobile"));
            cc.setAddress(res.getString("address"));
            cc.setPoints(res.getInt("points"));
        }
        return cc;
    }
    
    public boolean customerExists(String cusMobile) throws Exception {
        db = new Database();
        db.query("SELECT * FROM customer where mobile = ?");
        db.bindString(1, cusMobile);
        res = db.executeQuery();
        if(res.next()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static CustomerController getCustomerPoints(String cusMobileNo) throws Exception {
        db = new Database();
        db.query("SELECT * FROM customer where mobile = ?");
        db.bindString(1, cusMobileNo);
        res = db.executeQuery();
        
        CustomerController cc = new CustomerController();
        
        if(res.next()) {
            cc.setPoints(res.getInt("points"));
        }
        return cc;
    }
    
    public boolean deductPoints(int balancePoints, String cusMobileNo) throws SQLException {
        db = new Database();
        db.query("UPDATE customer SET points = ? WHERE mobile = ?");
        db.bindString(1,String.valueOf(balancePoints));
        db.bindString(2,cusMobileNo);
        
        if(db.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }
}