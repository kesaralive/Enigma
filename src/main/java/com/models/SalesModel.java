package com.models;

import com.controllers.SalesController;
import com.libraries.Database;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SalesModel {
    private static Database db;
    private static ResultSet res;
    
    public SalesModel() {
        Database db = new Database();
    }
    public static void main(String[] args) {
    }
    
    public List<SalesController> getSales() throws SQLException {
        db = new Database();
        db.query("SELECT * FROM sales");
        res = db.executeQuery();
        List<SalesController> list = new ArrayList<SalesController>();
        while(res.next()){
            SalesController cc = new SalesController();
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
}
