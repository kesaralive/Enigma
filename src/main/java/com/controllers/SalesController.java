package com.controllers;

import com.models.SalesModel;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class SalesController {
    private String id;
    private String cusMobile;
    private String discount;
    private String grossTotal;
    private String points;
    private Date date;


    public static void main(String[] args) throws SQLException {
    }

    public static String[][] getProducts() throws SQLException {
        List<ProductController> pc = (List<ProductController>) new ProductController().viewProducts();
        String[][] products = new String[pc.size()][2];
        int i = 0;
        for(ProductController product : pc){
            products[i][0] = product.getName();
            products[i][1] = product.getPrice();
            i++;
        }
        return products;
    }

    List<SalesController> viewSales() throws SQLException {
        SalesModel sm = new SalesModel();
        List<SalesController> sales = sm.getSales();
        return sales;
    }

    //Getters
    public String getId() {
        return this.id;
    }
    
    public String getCusMobile(){
        return cusMobile;
    }

    public String getDiscount(){
        return discount;
    }

    public String getGrossTotal(){
        return grossTotal;
    }

    public String getPoints(){
        return points;
    }

    //Setters
    public void setId(String idcashier) {
        this.id = idcashier;
    }
    
    public void setCusMobile(String cusMobile){
        this.cusMobile = cusMobile;
    }

    public void setDiscount(String discount){
        this.discount = discount;
    }

    public void setGrossTotal(String grossTotal){
        this.grossTotal = grossTotal;
    }

    public void setPoints(String points){
        this.points = points;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
