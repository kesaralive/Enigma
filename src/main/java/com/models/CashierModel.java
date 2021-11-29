package com.models;

import com.controllers.CashierController;
import com.libraries.Database;
import com.libraries.Session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CashierModel {
    private static Database db;
    private static ResultSet res;
    private static PreparedStatement stmt;

    public static void main(String[] args) throws SQLException {
  
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

    public static boolean login(String username, String password) throws SQLException {
        db = new Database();
        db.query("SELECT * from cashier where username = ? and password = ?");
        db.bindString(1,username);
        db.bindString(2,password);
        res = db.executeQuery();
        ResultSet temp=res;
        int flag=0;
        while(temp.next()){
            flag=1;
            Session.getSession(res.getInt("idcashier"),"CASHIER"); 
        }

        System.out.println(Session.getID());
        return (flag==1);
    }
    
    public static CashierController getAccountInfo() throws SQLException {
        db = new Database();
        String id = String.valueOf(Session.getID());
        
        db.query("SELECT * from cashier where idcashier = ?");
        db.bindString(1,id);
        res = db.executeQuery();
        
        CashierController cc = new CashierController();

        if(res.next()){
            cc.setName(res.getString("name"));
            cc.setMobile(res.getString("mobile"));
            cc.setPassword(res.getString("password"));
            cc.setAddress(res.getString("address"));
        }
        
        return cc;
    }
    
    public boolean updateAccountInfo(String newName, String newAddress, String newMobile) throws SQLException {
        db = new Database();
        String id = String.valueOf(Session.getID());
        
        db.query("UPDATE cashier SET name = ?, mobile = ?, address = ? WHERE idcashier = ?");
        db.bindString(1,newName);
        db.bindString(2,newMobile);
        db.bindString(3,newAddress);
        db.bindString(4,id);
        
        if(db.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean changePassword(String newPsd) throws SQLException {
        db = new Database();
        String id = String.valueOf(Session.getID());
        
        db.query("UPDATE cashier SET password = ? WHERE idcashier = ?");
        db.bindString(1,newPsd);
        db.bindString(2,id);
        
        if(db.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }
}