package com.controllers;

import com.models.AdminModel;
import com.models.CashierModel;

import java.sql.SQLException;
import java.util.List;

public class CashierController {
    private String id;
    private String username;
    private String name;
    private String mobile;
    private String address;
    private String password;
    private String date;

    public CashierController(){

    }

    public static void main(String[] args) throws SQLException {
    }

    public boolean cashierLogin(String username, String password) throws SQLException{
        CashierModel cm = new CashierModel();
        if(cm.login(username, password)){
            return true;
        }else{
            return false;
        }
    }
    
    public CashierController getAccountInfo() throws SQLException {
        CashierModel cm = new CashierModel();
        CashierController cc = new CashierController();
        cc = cm.getAccountInfo();
        return cc;
    }
    
    public Boolean createCashier() throws SQLException {
        String[] cashier = {this.username, this.name, this.mobile, this.address, this.password};
        AdminModel am = new AdminModel();
        return am.createCashier(cashier);
    }

    public static List<CashierController> viewCashiers() throws SQLException{
        AdminModel am = new AdminModel();
        List<CashierController> cashiers = am.getCashiers();
        return cashiers;
    }
    
    public boolean updateAccountInfo(String newName, String newAddress, String newMobile) throws SQLException {
        CashierModel cm = new CashierModel();
        if(cm.updateAccountInfo(newName, newAddress, newMobile)){
           return true;
        } else {
            return false;
        }
    }
    
    public boolean changePassword(String currentPsd, String newPsd) throws SQLException {
        CashierModel cm = new CashierModel();
        CashierController cc = new CashierController().getAccountInfo();
        if(currentPsd.equals(cc.getPassword()) && cm.changePassword(newPsd)) {
            return true;
        } else {
            return false;
        }
    }

    public String getId() {
        return this.id;
    }

    public void setId(String idcashier) {
        this.id = idcashier;
    }

    //Getters
    public String getUsername(){
        return username;
    }

    public String getName(){
        return name;
    }

    public String getMobile(){
        return mobile;
    }

    public String getAddress(){
        return address;
    }

    public String getPassword(){
        return password;
    }

    //Setters
    public void setUsername(String username){
        this.username = username;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setDate(String joined_date) {
        this.date = joined_date;
    }

    public String getDate() {
        return date;
    }
}
