package com.models;

import com.libraries.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CashierModel {
    private static Database db;
    private static ResultSet res;
    private static PreparedStatement stmt;

    public static void main(String[] args) throws SQLException {
        if(login("hello","oqwer")>0){
            System.out.println("IN");
        }else{
            System.out.println("OUT");
        }
    }
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

    public static Integer login(String username, String password) throws SQLException {
        db = new Database();
        db.query("SELECT * from cashier where username = ? and password = ?");
        db.bindString(1,username);
        db.bindString(2,password);
        res = db.executeQuery();
        if(res.next()){
            return res.getInt("idcashier");
        }
        return 0;
    }
}