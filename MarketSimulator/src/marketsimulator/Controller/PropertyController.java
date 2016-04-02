/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import DAO.DatabaseController;
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
            sql = "INSERT INTO " + db_controller.getTALBE_PROPERTY()+ "(property_id,seller_id,name,value,city,address,date_posted,image) VALUES "
                    + "(0," +property.getSeller_id() +  ",' " 
                    + property.getName() + "'," 
                    + "'"+property.getValue() + "',"
                    + "'"+property.getCity() + "'," 
                    + "'"+property.getAddress() + "',"
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
            db_controller.setClass();
            con = db_controller.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "DELETE FROM " + db_controller.getTALBE_PROPERTY() + "WHERE selled_id = '" + property.getSeller_id() + "' and name = '" + property.getName() + "'";
            
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
            db_controller.setClass();
            con = db_controller.getConnection();
            String sql;
            stm = con.createStatement();
            sql = "SELECT * FROM " + db_controller.getTALBE_PROPERTY() + " ORDER BY date_posted DESC";
            
            ResultSet rs =  stm.executeQuery(sql);
             
            while(rs.next())
            {
                String property_id = String.valueOf( rs.getInt("property_id"));
                String seller_id   = String.valueOf(rs.getString("seller_id"));
                String name        = rs.getString("name");
                String value       = rs.getString("value");
                String city        = rs.getString("city");
                String address     = rs.getString("address");
                String date_posted = rs.getString("date_posted");
                String image       = rs.getString("image");
                
                list.add(new Property(property_id,seller_id,name,value,city,address,date_posted,image));
                
            }
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return null;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
        
        return list;
    }

}
