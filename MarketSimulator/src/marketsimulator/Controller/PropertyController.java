/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import DAO.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marketsimulator.Model.Property;

/**
 *
 * @author SoRa
 */
public class PropertyController extends Database implements PropertyInterface  {
    
    
    @Override
    public boolean addProperty(Property property) 
    {
        Connection con = null;
        Statement stm = null;
        try
        {
            super.setClass();
            con = super.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "INSERT INTO " + super.getTALBE_PROPERTY()+ "(property_id,seller_id,name,value,date_posted,image) VALUES "
                    + "(" +property.getSeller_id()+  ",' " 
                    + property.getName()+"'," 
                    + "'"+property.getValue()+"'," 
                    + "'"+property.getDatePosted()+"'," 
                    + "'"+property.getImage_location() 
                    + "')";
           
            int response = stm.executeUpdate(sql);
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
            super.setClass();
            con = super.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "DELETE FROM " + super.getTALBE_PROPERTY() + "WHERE selled_id = '" + property.getSeller_id() + "' and name = '" + property.getName() + "'";
            
            int response =  stm.executeUpdate(sql);
             
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
            super.setClass();
            con = super.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "SELECT * FROM " + super.getTALBE_PROPERTY() + " ORDER BY date_posted DESC";
            
            ResultSet rs =  stm.executeQuery(sql);
             
            int i = 0;
            while(rs.next())
            {
                String property_id = String.valueOf( rs.getInt("property_id"));
                String seller_id   = String.valueOf(rs.getString("seller_id"));
                String name        = rs.getString("name");
                String value       = rs.getString("value");
                String date_posted = rs.getString("date_posted");
                String image       = rs.getString("image");
                
                list.add(new Property(property_id,seller_id,name,value,date_posted,image));
                
                System.out.println("iteration:"+i);
                i++;
            }
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return null;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
        
        if(list.isEmpty()) list.add(new Property("9","8","*m","8","7","6")); System.out.println("Tue List is empty");
        return list;
    }

}
