/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraries;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class Session {
    private static Database db;
    private static ResultSet res;
    private static Session session;
    private static int id;
    
    private Session(int id)  {
//        try {
            // create session: get user id
//            db = new Database();
//            db.query("SELECT * from admin where username = ? and password = ?");
//            db.bindString(1,username);
//            db.bindString(2,password);
//            res = db.executeQuery();
//            System.out.println(res);
//            AdminController ac = new AdminControlller;
//            if(res.next()) {
//                ac.
//            }
//        setId(res.getInt("id"));
setId(id);
//        } catch (SQLException ex) {
//            Logger.getLogger(AdminSession.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println(ex);
//        }
    }
    
    public static Session getSession(int id) throws SQLException {
        if (session == null){
            session = new Session(id);
        }
        return session;
    }
    
    public static int getID() {
        return id;
    }
    
    private void setId(Integer id) {
        this.id = id;
    }
    
}