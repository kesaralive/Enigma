/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.models;
import com.libraries.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author BiGDoGKD
 */
public class userModel {
    private static Database db;
    private static ResultSet res;

    public static void main(String[] args) throws SQLException {
        db = new Database();

        //Example Insert Query
        db.query("INSERT INTO user (name) VALUES(?)");
        db.bindString(1,"sandun");
        System.out.println(db.executeUpdate());

        //Example Select Query
        db.query("SELECT * from user");
        ResultSet res = db.executeQuery();
        while(res.next()){
            System.out.println(res.getString("name"));
        }
    }  
}
