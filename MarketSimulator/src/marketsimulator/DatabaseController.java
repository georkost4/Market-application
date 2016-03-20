/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SoRa
 */
public class DatabaseController 
{
     // JDBC driver name and database URL
   private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   private static final String DB_URL = "jdbc:mysql://localhost:3306/MarketDB?zeroDateTimeBehavior=convertToNull";
   
   //  Database credentials
   private static final String USER = "root";
   private static final String PASS = "";
   
   private static Connection conn = null;
   private Statement stmt = null;
   
   public ArrayList<User> getUsers()
   {
       ArrayList<User> tempList = new ArrayList<User>();
       try 
       {
           //Register JDBC driver
           Class.forName(JDBC_DRIVER);
           
           //Open a connection
           conn = DriverManager.getConnection(DB_URL,USER,PASS);
           
           // Execute a query
           stmt = conn.createStatement();
           String sql;
           sql = "SELECT * FROM users";
           ResultSet rs = stmt.executeQuery(sql);
           
           // Extract data from result set
           while(rs.next())
           {
               //Retrieve by column name
               int id  = rs.getInt("user_id");
               String username = rs.getString("username");
               String password = rs.getString("password");
               
               tempList.add(new User(id,username,password));
               
           }
           // Clean-up environment
           rs.close();
           stmt.close();
           conn.close();
       } 
       catch (ClassNotFoundException ex) {ex.printStackTrace(); } 
       catch (SQLException ex)           {ex.printStackTrace(); }
       
       return tempList;
   }
   
   public boolean register(User user){return false;};
   public boolean login(User user){return false;};
    
}
