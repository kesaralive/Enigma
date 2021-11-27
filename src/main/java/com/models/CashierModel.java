package com.models;

import com.libraries.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CashierModel {
    private static Database db;
    private static ResultSet res;
    private static PreparedStatement stmt;
    //create customer
    public static Boolean createCustomer(String[] customer) throws SQLException {
        db = new Database();
        db.query("INSERT INTO customer (name, mobile, address) VALUES(?,?,?)");
        db.bindString(1,customer[0]);
        db.bindString(2,customer[1]);
        db.bindString(3,customer[2]);
        if(db.executeUpdate()>0){
            return  true;
        }else {
            return  false;
        }
    }
}