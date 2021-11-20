/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.libraries;

import java.sql.*;
import static com.config.Config.*;

/**
 *
 * @author BiGDoGKD
 */
public class Database {

    private static Connection conn = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;
    private static String query = null;
    private static int rowsUpdated;

    static
    {
        try {
            //Load database driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        }
        catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    //returns connection
    public static Connection getConn(){
        return conn;
    }

    //preparing the query
    public void query(String q) throws SQLException {
        query = q;
        statement = conn.prepareStatement(query);
    }

    //to bind String values to the parameterized SQL query
    public void bindString(int id, String value) throws SQLException {
        statement.setString(id,value);
    }

    //to bind Integer values to the parameterized SQL query
    public void bindInt(int id, int value) throws SQLException {
        statement.setInt(id,value);
    }

    //to bind Boolean values to the parameterized SQL query
    public void bindBoolean(int id, boolean value) throws SQLException {
        statement.setBoolean(id,value);
    }

    //method to execute general queries (returns true or false)
    public Boolean execute() throws SQLException {
        return statement.execute();
    }

    //method to execute SELECT query (returns a resultSet)
    public ResultSet executeQuery() throws SQLException{
        resultSet = statement.executeQuery();
        return resultSet;
    }

    //method to execute INSERT, UPDATE or DELETE query
    public int executeUpdate() throws SQLException{
        rowsUpdated = statement.executeUpdate();
        return rowsUpdated;
    }

    //returns the prepared Statement for usage of other JDBC methods
    public PreparedStatement getStatement() throws  SQLException{
        return statement;
    }    
}
