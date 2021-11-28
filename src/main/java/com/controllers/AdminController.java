package com.controllers;

import com.models.AdminModel;

import java.sql.SQLException;

public class AdminController {
    public boolean adminLogin(String username, String password) throws SQLException {
        AdminModel adminmodel = new AdminModel();
        if(adminmodel.login(username,password)){
            return true;
        }else{
            return false;
        }
    }
}
