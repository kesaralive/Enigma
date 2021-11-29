package com.controllers;

import com.models.AdminModel;

import java.sql.SQLException;

public class AdminController {
    
    private String username;
    private String mobile;
    private String password;
    
    public boolean adminLogin(String username, String password) throws SQLException {
        AdminModel adminmodel = new AdminModel();
        if(adminmodel.login(username,password)){
            return true;
        }else{
            return false;
        }
    }
    
    public AdminController getAccountInfo() throws SQLException {
        AdminModel am = new AdminModel();
        AdminController ac = new AdminController();
        ac = am.getAccountInfo();
        return ac;
    }
    
    public boolean updateAccountInfo(String newName, String newMobile) throws SQLException {
        AdminModel am = new AdminModel();
        if(am.updateAccountInfo(newName, newMobile)){
           return true;
        } else {
            return false;
        }
    }
    
    public boolean changePassword(String currentPsd, String newPsd) throws SQLException {
        AdminModel am = new AdminModel();
        AdminController ac = new AdminController().getAccountInfo();
        if(currentPsd.equals(ac.getPassword()) && am.changePassword(newPsd)) {
            return true;
        } else {
            return false;
        }
    }
    
    public String getUsername(){
        return this.username;
    }

    public String getMobile(){
        return mobile;
    }

    public String getPassword(){
        return password;
    }

    //Setters
    public void setUsername(String username){
        this.username = username;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
