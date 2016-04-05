/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SoRa
 */
public class DatabaseController implements DAO
{
   private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   private static final String DB_URL = "jdbc:mysql://localhost:3306/MarketDB?zeroDateTimeBehavior=convertToNull";
   private static final String USER = "root";
   private static final String PASS = "";
   
   private static String TABLE_USERS = "users" ;
   private static String TABLE_PROPERTY = "onsale";
   private static String TABLE_BIDS = "bids";
   
   @Override
   public Connection getConnection() throws SQLException 
   {
       return DriverManager.getConnection(DB_URL,USER,PASS);
   }
   
   @Override
   public void setClass() throws ClassNotFoundException 
   {
       Class.forName(JDBC_DRIVER);
   }

    public  String getTABLE_USERS() { return TABLE_USERS;}

    public  String getTABLE_PROPERTY() {return TABLE_PROPERTY;}

    public  String getTABLE_BIDS() {return TABLE_BIDS; }
   
   
    
}
