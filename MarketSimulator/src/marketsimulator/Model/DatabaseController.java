/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller for getting a connection
 * to the database and also the table names
 * @author SoRa
 */
public class DatabaseController implements DAO
{
   private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   private static final String DB_URL = "jdbc:mysql://192.168.1.2/MarketDB";
   public static final String SERVER_URL = "http://192.168.1.2/image_handler.php";
   public static final String SERVER_IMAGE_LOCATION = "http://192.168.1.2/";
   private static final String USER = "guest";
   private static final String PASS = "";
   
   private static String TABLE_USERS = "users" ;
   private static String TABLE_PROPERTY = "onsale";
   private static String TABLE_BIDS = "bids";
   
   private static final String CREATE_DATABASE = "CREATE DATABASE marketdb;";
      
   private static final String CREATE_TABLE_BIDS = " "
           + " CREATE TABLE bids "
           + "("
           + "`bid_id` int(11) NOT NULL,"
           + "`property_id` int(15) NOT NULL,"
           + "`user_id` int(15) NOT NULL,"
           + "`approved` int(1) NOT NULL"
           + ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";

   private static final String CREATE_TABLE_ONSALE ="CREATE TABLE `onsale` (\n" +
         "  `property_id` int(11) NOT NULL,\n" +
         "  `seller_id` int(4) NOT NULL,\n" +
         "  `on_sale` varchar(1) NOT NULL,\n" +
         "  `value` varchar(10) NOT NULL,\n" +
         "  `city` varchar(30) NOT NULL,\n" +
         "  `address` varchar(15) NOT NULL,\n" +
         "  `date_posted` varchar(100) NOT NULL,\n" +
         "  `image` varchar(300) NOT NULL\n" +
         ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";

   private static final String CREATE_TABLE_USERS = "CREATE TABLE `users` (\n" +
         "  `user_id` int(11) NOT NULL,\n" +
         "  `firstname` varchar(15) NOT NULL,\n" +
         "  `lastname` varchar(15) NOT NULL,\n" +
         "  `username` varchar(15) NOT NULL,\n" +
         "  `password` varchar(15) NOT NULL,\n" +
         "  `city` varchar(30) NOT NULL,\n" +
         "  `number` varchar(10) NOT NULL\n" +
         ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";

   private static final String CREATE_TABLE_PERSONAL_INFO = "CREATE TABLE `user_personal_information` (\n" +
         "  `information_id` int(11) NOT NULL,\n" +
         "  `user_id` int(11) NOT NULL,\n" +
         "  `information` varchar(300) NOT NULL\n" +
         ") ENGINE=InnoDB DEFAULT CHARSET=latin1;";

   private static final String ALTER_TABLE_BIDS = "ALTER TABLE `bids`\n" +
         "  ADD PRIMARY KEY (`bid_id`),\n" +
         "  ADD KEY `property_id` (`property_id`),\n" +
         "  ADD KEY `user_id` (`user_id`);";
   
   private static final String ALTER_TABLE_ONSALE = "ALTER TABLE `onsale`\n" +
        "  ADD PRIMARY KEY (`property_id`),\n" +
        "  ADD KEY `seller_id` (`seller_id`);";
   
   private static final String ALTER_TABLE_USERS ="ALTER TABLE `users`\n" +
        "  ADD PRIMARY KEY (`user_id`),\n" +
        "  ADD UNIQUE KEY `username` (`username`);";
   

   private static final String ALTER_TABLE_PERONAL_INFO ="ALTER TABLE `user_personal_information`\n" +
         "  ADD PRIMARY KEY (`information_id`),\n" +
         "  ADD UNIQUE KEY `user_id_2` (`user_id`),\n" +
         "  ADD KEY `user_id` (`user_id`);";

   private static final String ALTER_TABLE_BIDS_2 = "ALTER TABLE `bids`\n" +
         "  MODIFY `bid_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;";
   
   private static final String ALTER_TABLE_ONSALE_2 = "ALTER TABLE `onsale`\n" +
        "  MODIFY `property_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;";
   
   private static final String ALTER_TABLE_USERS_2 = "ALTER TABLE `users`\n" +
        "  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;";
   
   private static final String ALTER_TABLE_PERSONAL_INFO_2 = "ALTER TABLE `user_personal_information`\n" +
        "  MODIFY `information_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;";
  
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
    
    /**
     * Method for creating the database on local server.
     * @return <b>True</b> for success.
     */
    public boolean createDatabase()
    {
       try 
       {
           // Get a connection.
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
           Class.forName("com.mysql.jdbc.Driver");
           
           Statement stm = con.createStatement();
           
           stm.executeUpdate(CREATE_DATABASE);
           
           System.out.println("GG");
           
           
           
       } 
       catch (ClassNotFoundException ex) {ex.printStackTrace();}
       catch (SQLException ex) { ex.printStackTrace(); }
       catch(Exception e){return false;}
       
       return true;
    }
    
    /**
     * Method for creating tables in the local database.
     * @return <b>True</b> for success.
     */
    public boolean createTables()
    {
       try 
       {
           // Get a connection.
           Connection con = this.getConnection();
           this.setClass();
           
           Statement stm = con.createStatement();
           
           stm.executeUpdate(CREATE_TABLE_BIDS);
           stm.executeUpdate(CREATE_TABLE_ONSALE);
           stm.executeUpdate(CREATE_TABLE_USERS);
           stm.executeUpdate(CREATE_TABLE_PERSONAL_INFO);
           
           stm.executeUpdate(ALTER_TABLE_BIDS);
           stm.executeUpdate(ALTER_TABLE_ONSALE);
           stm.executeUpdate(ALTER_TABLE_USERS);
           stm.executeUpdate(ALTER_TABLE_PERONAL_INFO);
           
           stm.executeUpdate(ALTER_TABLE_BIDS_2);
           stm.executeUpdate(ALTER_TABLE_ONSALE_2);
           stm.executeUpdate(ALTER_TABLE_USERS_2);
           stm.executeUpdate(ALTER_TABLE_PERSONAL_INFO_2);
           
           
           System.out.println("GG");
           
           
           
       } 
       catch (ClassNotFoundException ex) {ex.printStackTrace();}
       catch (SQLException ex) { ex.printStackTrace(); }
       catch(Exception e){return false;}
       
       return true;
    }

    /**
     *  Method for checking if database needs to be created
     * or it already exists.
     * @return <b>True</b> if database already exists.
     */
    public boolean checkIfDatabaseExists() {
       try 
       {
           this.getConnection();
       } 
       catch (SQLException ex) 
       {
          return false;
       }
       return true;
    }
   
   
    
}
