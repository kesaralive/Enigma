package com.controllers;

import java.sql.SQLException;
import java.util.List;

public class SalesController {


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
}
