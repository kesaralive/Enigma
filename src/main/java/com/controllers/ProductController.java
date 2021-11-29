package com.controllers;

import com.models.AdminModel;
import com.models.ProductModel;

import java.sql.SQLException;
import java.util.List;

public class ProductController {
    private String id;
    private String name;
    private String price;

    //CRUD Methods
    public Boolean createProduct() throws SQLException {
        String[] product = {this.name, this.price};
        AdminModel am = new AdminModel();
        return am.createProduct(product);
    }

    public static List<ProductController> viewProducts() throws SQLException{
        ProductModel pm = new ProductModel();
        List<ProductController> products = pm.getProducts();
        return products;
    }

    //Getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPrice() {
        return price;
    }

    //Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
//    public static String[][] getProducts() throws SQLException {
//        List<ProductController> pc = (List<ProductController>) new ProductController().viewProducts();
//        String[][] products = new String[pc.size()][2];
//        int i = 0;
//        for(ProductController product : pc){
//            products[i][0] = product.getName();
//            products[i][1] = product.getPrice();
//            i++;
//        }
//        return products;
//    }