/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

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
 * Controller for declaring,declining,accept interests in properties 
 * and also providing general informations.
 * @author SoRa
 */
public class InterestController implements InterestInterface {
    DatabaseController database_controller = new DatabaseController();
   
    /**
     * Method for completing the sell operation of the house.
     * @param property_id The property_id of the house you sold.
     * @param user_id The user_id of the user you sell the house to.
     * @return <b>true</b> if all went good.
     */
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
           
           conn.close();
           stm.close();
           
           System.out.println(String.valueOf(rs));
       } 
       catch (SQLException ex) {ex.printStackTrace(); return false; } 
       catch (ClassNotFoundException ex) { ex.printStackTrace();}
       
       return true;
    }

    /**
     * Method for turning down a users interest in your property.
     * @param property_id property_id of your property.
     * @param user_id user_id of the user to turn down.
     * @return <b>true</b> if all went right.
     */
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
           
           conn.close();
           stm.close();
           
           System.out.println(String.valueOf(rs));
           
       } 
       catch (SQLException ex) {ex.printStackTrace(); return false; } 
       catch (ClassNotFoundException ex) { ex.printStackTrace();}
       
       return true;
    }

    /**
     * Method to declare interest on a specific property.
     * @param property_id The property that you want to declare interest to.
     * @param user_id Logged user id.
     * @return <b>true</b> for success.
     */
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
           
           conn.close();
           stm.close();
           
           System.out.println(String.valueOf(rs));
       } 
       catch (SQLException ex) {ex.printStackTrace(); return false; } 
       catch (ClassNotFoundException ex) { ex.printStackTrace();}
       
       return true;
    }

    /**
     * Method for getting a list of the properties that I'm interested in .
     * @param user_id Desired user's properties interests.
     * @return  ArrayList of the  properties I'm interested in.
     */
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
                
                System.out.println("getMyInterests:"+list.get(i).toString());
                i++;
            }
            
            conn.close();
            stm.close();
        } 
        catch (SQLException ex) {ex.printStackTrace(); } 
        catch (ClassNotFoundException ex) {ex.printStackTrace();}
        
        return list;
    }

    /**
     * Method for getting the properties that the user want to sell.
     * @param user_id The user_id of the user to get his listings.
     * @return  ArrayList of the properties.
     */
    @Override
    public ArrayList<Property> getMyListings(String user_id) 
    {
        ArrayList<Property> list = new ArrayList<Property>();
        Connection con = null;
        Statement stm = null;
        int i = 0;
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
                
                System.out.println("getMyListings:"+list.get(i).toString());
                i++;
                
            }
            
            con.close();
            stm.close();
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return null;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
        return list;
    }

    /**
     * Method for getting a user's name by his id.
     * @param seller_id The desired user_id.
     * @return String of his name.
     */
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
            
            con.close();
            stm.close();
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return null;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
        
        return tmp;
    }

    /**
     * Method for getting all users that are interested in some property.
     * @param property_id The property that you want.
     * @return ArrayList of users .
     */
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
            sql = "select * from users where user_id in ( SELECT user_id from bids where property_id = " + property_id + " and approved = -1 and user_id != " + new UserController().getLoggedUser().getId() + " )";
            
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
            con.close();
            stm.close();
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return null;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
        
        return users;
    }
    
    /**
     * Method for getting the state of some user interest on a property.
     * @param property_id The property to get the state.
     * @return <b>-1</b> if the seller hasn't seen the interest yet
     * <b>0</b> if the seller declined the user.
     * <b>1</b> if the seller sold the property to the user.
     */
    @Override
    public int getPropertyState(String property_id) 
    {
       Connection conn = null;
       Statement stm = null;
       int state = -1;
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
           
           conn.close();
           stm.close();
           
       } 
       catch (SQLException ex) {ex.printStackTrace(); return state; } 
       catch (ClassNotFoundException ex) { ex.printStackTrace();}
       
       return state;
       
    }

    /**
     * Method for automatically declining all users except the one you sold the property.
     * @param property_id The property sold.
     * @param user_id The user sold the property to.
     * @return <b>true</b> if successful.
     */
    @Override
    public boolean DeclineAllOtherUsers(String property_id,String user_id) {
       Connection conn = null;
       Statement stm = null;
       int val = -1;
       try
       {
           conn = database_controller.getConnection();
           stm = conn.createStatement();
           database_controller.setClass();
           String sql = "UPDATE " + database_controller.getTABLE_BIDS() + " set approved = 0 where property_id = " + property_id + " and user_id != " + user_id;
                  
           val = stm.executeUpdate(sql);
          
           
           System.out.println(String.valueOf(val));
           
           conn.close();
           stm.close();
           
       } 
       catch (SQLException ex) {ex.printStackTrace(); return false; } 
       catch (ClassNotFoundException ex) { ex.printStackTrace(); return false;}
       
       if(val == 1) return true;
       return false;
    }

    /**
     * Method for checking if the user declared interest in a specific property.
     * @param property_id The property id that you want to check.
     * @return <b> True</b> if you are already interested.
     */
    @Override
    public boolean checkIfAlreadyInterested(String property_id) {
       Connection conn = null;
       Statement stm = null;
       int i = 0;
       
       try
       {
           conn = database_controller.getConnection();
           stm = conn.createStatement();
           database_controller.setClass();
          
           
           String sql = "SELECT approved from " + database_controller.getTABLE_BIDS() + " where user_id = " + new UserController().getLoggedUser().getId() + " and property_id = '" + property_id + "'";
                  
           ResultSet rs = stm.executeQuery(sql);
           while(rs.next())
           {
               i++;
           }
           
           
           System.out.println(String.valueOf(i));
           
           conn.close();
           stm.close();
          
       } 
       catch (SQLException ex) {ex.printStackTrace(); return false; } 
       catch (ClassNotFoundException ex) { ex.printStackTrace(); return false;}
       
       if(i == 1) return true;
       return false;
    }
    
}
