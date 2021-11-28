/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraries;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class Session {
    private static Database db;
    private static ResultSet res;
    private static Session session;
    private static int id;
    private static String type;
    private Session(int id,String type)  {

    this.id = id;
    this.type=type;

    }
    
    public static Session getSession(int id,String type) throws SQLException {
        if (session == null){
            session = new Session(id,type);
        }
        return session;
    }
    
    public static int getID() {
        return id;
    }
    
    public static String getType() {
        return type;
    }
}