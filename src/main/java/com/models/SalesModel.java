package com.models;


import com.controllers.SalesController;
import com.libraries.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            sc.setDiscount(res.getString("discount"));
            sc.setGrossTotal(res.getString("gross_total"));
            sc.setPoints(res.getString("points"));
            sc.setDate(res.getDate("date"));

            list.add(sc);
        }
        return list;
    }
}