package com.models;

import com.libraries.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModel {
    private static Database db;
    private static ResultSet res;
    private static PreparedStatement stmt;

    public AdminModel() {
        db = new Database();
    }

    public static Boolean login(String username, String password) throws SQLException {
        db = new Database();
        db.query("SELECT * from admin where username = ? and password = ?");
        db.bindString(1,username);
        db.bindString(2,password);
        res = db.executeQuery();
        return res.next();
    }

}
