/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Controller for getting a connection
 * to the database and also the table names
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
   
    /**
     * Use this method to get a connection link to database.
     * @return Connection object
     * @throws SQLException
     */
    @Override
   public Connection getConnection() throws SQLException 
   {
       return DriverManager.getConnection(DB_URL,USER,PASS);
   }
   
    /**
     * Sets the class which JDBC driver is in .
     * @throws ClassNotFoundException
     */
    @Override
   public void setClass() throws ClassNotFoundException 
   {
       Class.forName(JDBC_DRIVER);
   }

    /**
     * Gets the name of table USERS .
     * @return <b>String</b> of the table name .
     */
    public  String getTABLE_USERS() { return TABLE_USERS;}

    /**
     * Gets the name of table PROPERTY .
     * @return <b>String</b> of the table name .
     */
    public  String getTABLE_PROPERTY() {return TABLE_PROPERTY;}

    /**
     * Gets the name of table BIDS .
     * @return <b>String</b> of the table name .
     */ 
    public  String getTABLE_BIDS() {return TABLE_BIDS; }
   
   
    
}
