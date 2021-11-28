package com.controllers;

import com.models.AdminModel;

import java.sql.SQLException;
import java.util.List;

public class AdminController {
    private String id;
    private String username;
    private String mobile;
    private String password;
    
    public static void main(String[] args) throws SQLException {
    }

    public boolean adminLogin(String username, String password) throws SQLException {
        AdminModel adminmodel = new AdminModel();
        if(adminmodel.login(username,password)){
            return true;
        }else{
            return false;
        }
    }

    public Integer getAdminID(String username, String password) throws SQLException {
        AdminModel adminmodel = new AdminModel();
        Integer ad_id = adminmodel.getAdminID(username,password);
        return ad_id;
    }
    
    public AdminController geInfo(Integer ad_id) throws SQLException {
        AdminModel am = new AdminModel();
        AdminController ac = am.getInfo(ad_id);
        return ac;
    }

    //Getters
    public String getUsername(){
        return username;
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
