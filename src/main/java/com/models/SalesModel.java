package com.models;


import com.controllers.SalesController;
import com.libraries.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class SalesModel {
    private static Database db;
    private static ResultSet res;

    public SalesModel() {
        Database db = new Database();
    }

    //view all sales
    public static List<SalesController> getSales() throws SQLException {
        Database db = new Database();
        db.query("SELECT * FROM sales");
        res = db.executeQuery();
        List<SalesController> list = new ArrayList<SalesController>();
        while(res.next()){
            SalesController sc = new SalesController();

            sc.setId(res.getString("order_id"));
            sc.setCusMobile(res.getString("cus_mobile"));
            sc.setGrossTotal(res.getString("gross_total"));
            sc.setPoints(res.getString("points"));
            sc.setDate(res.getDate("date"));

            list.add(sc);
        }
        return list;
    }
    
    public boolean addSale(String cusMobileNo, String points, String total) throws SQLException {
        db = new Database();
        db.query("INSERT INTO sales (cus_mobile, gross_total, points, date) VALUES(?,?,?,?)");
        LocalDate lt = LocalDate.now();
        db.bindString(1,cusMobileNo);
        db.bindString(2,total);
        db.bindString(3,points);
        db.bindDate(4, lt);
        
        if(db.executeUpdate()>0){
            return  true;
        }else {
            return  false;
        }
    }
 }