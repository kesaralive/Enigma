package com.models;

import com.controllers.ProductController;
import com.libraries.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {
    private static Database db;
    private static ResultSet res;
    private static PreparedStatement stmt;

    public ProductModel() {
        db = new Database();
    }

    //view all cashiers
    public List<ProductController> getProducts() throws SQLException {
        db.query("SELECT * FROM product");
        res = db.executeQuery();
        List<ProductController> list = new ArrayList<ProductController>();
        while(res.next()){
            ProductController pc = new ProductController();
            pc.setId(res.getString("product_id"));
            pc.setName(res.getString("name"));
            pc.setPrice(res.getString("price"));
            list.add(pc);
        }
        return list;
    }
}
