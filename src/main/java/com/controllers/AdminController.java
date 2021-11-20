package com.controllers;

import com.models.AdminModel;

import java.sql.SQLException;

public class AdminController {
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
}
