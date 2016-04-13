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
import marketsimulator.Model.Property;

/**
 *
 * @author SoRa
 */
public class PropertyController  implements PropertyInterface  {
    DatabaseController db_controller = new DatabaseController();
    
    @Override
    public boolean addProperty(Property property) 
    {
        Connection con = null;
        Statement stm = null;
        try
        {
            db_controller.setClass();
            con = db_controller.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "INSERT INTO " + db_controller.getTABLE_PROPERTY()+ "(property_id,seller_id,on_sale,value,city,address,date_posted,image) VALUES "
                    + "(0," +property.getSeller_id() +  "," 
                    + "'1',"   
                    + "'"+property.getValue() + "',"
                    + "'"+property.getCity() + "'," 
                    + "'"+property.getAddress() + "',"
                    + "'"+property.getDatePosted()+"'," 
                    + "'"+property.getImage_location() 
                    + "')";
           
            int response = stm.executeUpdate(sql);
            
            con.close();
            stm.close();
            
            if(response == 1) return true;
            else return false;
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return false;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return false; }
    }

    @Override
    public boolean removeProperty(Property property) 
    {
        Connection con = null;
        Statement stm = null;
        try
        {
            db_controller.setClass();
            con = db_controller.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "DELETE FROM " + db_controller.getTABLE_PROPERTY() + "WHERE property_id = " + property.getProperty_id();
            
            int response =  stm.executeUpdate(sql);
            
            con.close();
            stm.close();
            
            if(response == 1) return true;
            else return false;
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return false;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return false; }
    }

    @Override
    public ArrayList<Property> getProperties()
    {
        ArrayList<Property> list = new ArrayList<Property>();
        Connection con = null;
        Statement stm = null;
        try
        {
            db_controller.setClass();
            con = db_controller.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "SELECT * FROM " + db_controller.getTABLE_PROPERTY() + " where seller_id != " + new UserController().getLoggedUser().getId() + " AND on_sale = 1 ORDER BY date_posted DESC";
            
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
            
            con.close();
            stm.close();
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return null;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
        
        return list;
    }
    
    @Override
    public int getOnSaleState(String property_id)
    {
        int returnVal = -10;
        Connection con = null;
        Statement stm = null;
        try
        {
            db_controller.setClass();
            con = db_controller.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "SELECT on_sale FROM " + db_controller.getTABLE_PROPERTY() + " where property_id = " + property_id;
            
            ResultSet rs =  stm.executeQuery(sql);
             
            while(rs.next())
            {
               returnVal = Integer.parseInt(rs.getString("on_sale"));           
            }
            
            con.close();
            stm.close();
                        
        }
        catch (SQLException ex) {ex.printStackTrace(); return -1;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return -1; }
        
        return returnVal;
    }

    @Override
    public boolean removePropertyFromSale(String property_id) 
    {
        int returnVal = -1;
        Connection con = null;
        Statement stm = null;
        try
        {
            db_controller.setClass();
            con = db_controller.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "UPDATE " + db_controller.getTABLE_PROPERTY() + " set on_sale = 0 where property_id = " + property_id;
            
            returnVal = stm.executeUpdate(sql);
                
            con.close();
            stm.close();
            
            
        }
        catch (SQLException ex) {ex.printStackTrace(); return false;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return false; }
     
        if(returnVal == 1) return true;
        return false;
    }

}
