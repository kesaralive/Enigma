package com.models;

import com.controllers.AdminController;
import com.controllers.CashierController;
import com.libraries.Database;
import com.libraries.Session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdminModel {
    private static Database db;
    private static ResultSet res;
    private static PreparedStatement stmt;

    public AdminModel() {
        db = new Database();
    }

    public static void main(String[] args) throws SQLException {
    }

    public static boolean login(String username, String password) throws SQLException {
        db = new Database();
        db.query("SELECT * from admin where username = ? and password = ?");
        db.bindString(1,username);
        db.bindString(2,password);
        res = db.executeQuery();
        ResultSet temp=res;
        int flag=0;
        while(temp.next()){
            flag=1;
            Session.getSession(res.getInt("id"),"ADMIN"); 
        }

        return (flag==1);
    }


    //create cashier
    public static Boolean createCashier(String[] cashier) throws SQLException {
        db = new Database();
        db.query("INSERT INTO cashier (username, name, mobile, address, password, joined_date) VALUES(?,?,?,?,?,?)");
        LocalDate lt = LocalDate.now();
        db.bindString(1,cashier[0]);
        db.bindString(2,cashier[1]);
        db.bindString(3,cashier[2]);
        db.bindString(4,cashier[3]);
        db.bindString(5,cashier[4]);
        db.bindDate(6, lt);
        if(db.executeUpdate()>0){
            return  true;
        }else {
            return  false;
        }
    }

    //create product
    public static Boolean createProduct(String[] product) throws  SQLException{
        db = new Database();
        db.query("INSERT INTO product (name, price) VALUES(?,?)");
        db.bindString(1,product[0]);
        db.bindString(2,product[1]);
        if(db.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }

    //view all cashiers
    public List<CashierController> getCashiers() throws SQLException {
        db = new Database();
        db.query("SELECT * FROM cashier");
        res = db.executeQuery();
        List<CashierController> list = new ArrayList<CashierController>();
        while(res.next()){
            CashierController cc = new CashierController();
            cc.setId(res.getString("idcashier"));
            cc.setUsername(res.getString("username"));
            cc.setName(res.getString("name"));
            cc.setAddress(res.getString("address"));
            cc.setMobile(res.getString("mobile"));
            cc.setDate(res.getString("joined_date"));
            list.add(cc);
        }
        return list;
    }
    
    public static AdminController getAccountInfo() throws SQLException {
        db = new Database();
        String id = String.valueOf(Session.getID());
        
        db.query("SELECT * from admin where id = ?");
        db.bindString(1,id);
        res = db.executeQuery();
        
        AdminController ac = new AdminController();

        if(res.next()){
            ac.setUsername(res.getString("username"));
            ac.setMobile(res.getString("phone"));
            ac.setPassword(res.getString("password"));
        }
        
        return ac;
    }
    
    public boolean updateAccountInfo(String newName, String newMobile) throws SQLException {
        db = new Database();
        String id = String.valueOf(Session.getID());
        
        db.query("UPDATE admin SET username = ?, phone = ? WHERE id = ?");
        db.bindString(1,newName);
        db.bindString(2,newMobile);
        db.bindString(3,id);
        
        if(db.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean changePassword(String newPsd) throws SQLException {
        db = new Database();
        String id = String.valueOf(Session.getID());
        
        db.query("UPDATE admin SET password = ? WHERE id = ?");
        db.bindString(1,newPsd);
        db.bindString(2,id);
        
        if(db.executeUpdate()>0){
            return true;
        }else{
            return false;
        }
    }
}