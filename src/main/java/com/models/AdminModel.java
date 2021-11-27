package com.models;

import com.controllers.AdminController;
import com.controllers.CashierController;
import com.libraries.Database;

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
        return res.next();
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

    public Integer getAdminID(String username, String password) throws  SQLException{
        db = new Database();
        db.query("SELECT * from admin where username = ? and password = ?");
        db.bindString(1,username);
        db.bindString(2,password);
        res = db.executeQuery();
        Integer ad_id = res.getInt("id");
        return ad_id;
    }

    public AdminController getInfo(Integer ad_id) throws SQLException {
        db = new Database();
        db.query("SELECT * from admin where id = ?");
        db.bindInt(1,ad_id);
        res = db.executeQuery();
        AdminController ac = new AdminController();
        if(res.next()){
            ac.setUsername(res.getString("username"));
            ac.setMobile(res.getString("phone"));
        }
        return ac;
    }
}
