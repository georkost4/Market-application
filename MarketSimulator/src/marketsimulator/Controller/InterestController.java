/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import marketsimulator.Model.DatabaseController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marketsimulator.Model.Property;
import marketsimulator.Model.User;

/**
 *
 * @author SoRa
 */
public class InterestController implements InterestInterface {
    DatabaseController database_controller = new DatabaseController();
   

    @Override
    public boolean acceptInterest(String property_id,String user_id) {
       Connection conn = null;
       Statement stm = null;
       try
       {
           conn = database_controller.getConnection();
           stm = conn.createStatement();
           database_controller.setClass();
           String sql = "UPDATE  " + database_controller.getTABLE_BIDS() + " SET approved = 1 where user_id = '" + user_id + "' and property_id = '" + property_id + "'";
                  
           
           int rs = stm.executeUpdate(sql);
           
           System.out.println(String.valueOf(rs));
       } 
       catch (SQLException ex) {ex.printStackTrace(); return false; } 
       catch (ClassNotFoundException ex) { ex.printStackTrace();}
       
       return true;
    }

    @Override
    public boolean declineInterest(String property_id,String user_id) {
       Connection conn = null;
       Statement stm = null;
       try
       {
           conn = database_controller.getConnection();
           stm = conn.createStatement();
           database_controller.setClass();
           String sql = "UPDATE  " + database_controller.getTABLE_BIDS() + " SET approved = 0 where user_id = " + user_id + " and property_id = " + property_id;
                  
           
           int rs = stm.executeUpdate(sql);
           
           System.out.println(String.valueOf(rs));
           
       } 
       catch (SQLException ex) {ex.printStackTrace(); return false; } 
       catch (ClassNotFoundException ex) { ex.printStackTrace();}
       
       return true;
    }

    @Override
    public boolean makeInterest(String property_id, String user_id) {
       //Implement database calls to make Interest on a property
       Connection conn = null;
       Statement stm = null;
       try
       {
           conn = database_controller.getConnection();
           stm = conn.createStatement();
           database_controller.setClass();
           String sql = "INSERT INTO " + database_controller.getTABLE_BIDS() + "(bid_id,property_id,user_id,approved) VALUES "
                   + "("
                   + "0," 
                   + property_id + " ,"
                   + user_id + " ,"
                   + " ' -1 ' "
                   + " ) " ;
           
           int rs = stm.executeUpdate(sql);
           
           System.out.println(String.valueOf(rs));
       } 
       catch (SQLException ex) {ex.printStackTrace(); return false; } 
       catch (ClassNotFoundException ex) { ex.printStackTrace();}
       
       return true;
    }

    @Override
    public ArrayList<Property> getMyInterests(String user_id) {
        Connection conn = null;
        Statement stm = null;
        ArrayList<Property> list = new ArrayList<Property>();
        try
        {
            conn = database_controller.getConnection();
            stm = conn.createStatement();
            database_controller.setClass();
            String sql ="SELECT onsale.property_id,seller_id,on_sale,value,city,image,date_posted,address FROM onsale,bids where bids.property_id = onsale.property_id and bids.user_id = " + user_id;
            
            ResultSet rs = stm.executeQuery(sql);
            
            int i = 0;
            while(rs.next())
            {
                String id = rs.getString("property_id");
                String seller_id = rs.getString("seller_id");
                String on_sale = rs.getString("on_sale");
                String value = rs.getString("value");
                String city = rs.getString("city");
                String date = rs.getString("date_posted");
                String image = rs.getString("image");
                String address = rs.getString("address");
                
                list.add(new Property(id,seller_id,on_sale,value,city,address,date,image));
                
                System.out.println(list.get(i));
                i++;
            }
        } 
        catch (SQLException ex) {ex.printStackTrace(); } 
        catch (ClassNotFoundException ex) {ex.printStackTrace();}
        
        return list;
    }

    @Override
    public ArrayList<Property> getMyListings(String user_id) 
    {
        ArrayList<Property> list = new ArrayList<Property>();
        Connection con = null;
        Statement stm = null;
        try
        {
            database_controller.setClass();
            con = database_controller.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "SELECT * FROM " + database_controller.getTABLE_PROPERTY() + " WHERE seller_id = " + user_id + " ORDER BY date_posted DESC";
            
            ResultSet rs =  stm.executeQuery(sql);
             
            while(rs.next())
            {
                String property_id = String.valueOf( rs.getInt("property_id"));
                String seller_id   = String.valueOf(rs.getString("seller_id"));
                String on_sale        = rs.getString("on_sale");
                String value       = rs.getString("value");
                String city        = rs.getString("city");
                String address     = rs.getString("address");
                String date_posted = rs.getString("date_posted");
                String image       = rs.getString("image");
                
                list.add(new Property(property_id,seller_id,on_sale,value,city,address,date_posted,image));
                
            }
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return null;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
        
        return list;
    }

    @Override
    public String getSellerName(String seller_id) {
        String tmp = null;
        Connection con = null;
        Statement stm = null;
        try
        {
            database_controller.setClass();
            con = database_controller.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "SELECT * FROM " + database_controller.getTABLE_PROPERTY() + ", " + database_controller.getTABLE_USERS() + " WHERE seller_id =  user_id and seller_id = " + seller_id;
            
            ResultSet rs =  stm.executeQuery(sql);
             
            while(rs.next())
            {
                String first_name = rs.getString("firstname");
                String last_name = rs.getString("lastname");
                
                tmp = first_name + "  " + last_name;
                
            }
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return null;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
        
        return tmp;
    }

    @Override
    public ArrayList<User> getUsersThatAreInterestedInMyListings(String property_id) {
        ArrayList<User> users = new ArrayList<User>();
        Connection con = null;
        Statement stm = null;
        try
        {
            database_controller.setClass();
            con = database_controller.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "select * from users where user_id in ( SELECT user_id from bids where property_id = " + property_id + " and user_id != " + new UserController().getLoggedUser().getId() + " )";
            
            ResultSet rs =  stm.executeQuery(sql);
            
            System.out.println("BeforeResultSet");
            int i = 0;
            while(rs.next())
            {
                String user_id = rs.getString("user_id");
                String first_name = rs.getString("firstname");
                String last_name = rs.getString("lastname");
                String city = rs.getString("city");
                String number = rs.getString("number");
                System.out.println("InsideResultSet");
                users.add(new User(Integer.parseInt(user_id),first_name,last_name,null,null,city,number));
                System.out.println(users.get(i).toString());
                i++;
                
            }
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return null;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
        
        return users;
    }
    
    @Override
    public int getPropertyState(String property_id) 
    {
       Connection conn = null;
       Statement stm = null;
       int state = -2;
       try
       {
           conn = database_controller.getConnection();
           stm = conn.createStatement();
           database_controller.setClass();
           String sql = "SELECT approved from " + database_controller.getTABLE_BIDS() + " where user_id = " + new UserController().getLoggedUser().getId() + " and property_id = " + property_id;
                  
           
           ResultSet rs =  stm.executeQuery(sql);
           rs.next();
           state = Integer.parseInt(rs.getString("approved"));
           
           System.out.println(String.valueOf(state));
           
       } 
       catch (SQLException ex) {ex.printStackTrace(); return state; } 
       catch (ClassNotFoundException ex) { ex.printStackTrace();}
       
       return state;
       
    }
    
}
