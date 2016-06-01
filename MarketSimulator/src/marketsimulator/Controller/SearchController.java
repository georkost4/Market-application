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
import marketsimulator.Model.Property;

/**
 *
 * @author Nikos
 */
public class SearchController {
    
    DatabaseController db_controller = new DatabaseController();
    

    public ArrayList<Property> findProperties(String textToSearch,String choice)
    {
        ArrayList<Property> searchList = new ArrayList<Property>();
        Connection con = null;
        Statement stm = null;
        
        String cityChoice= "city";
       
        try
        {
            db_controller.setClass();
            con = db_controller.getConnection();
            String sql = null;
            stm = con.createStatement();
            UserController uc = new UserController();
            
            if (choice.equals(cityChoice)){
                sql = "SELECT * FROM " + db_controller.getTABLE_PROPERTY() + " WHERE seller_id != '" + uc.getLoggedUser().getId()+ "' AND city Like'" + textToSearch + "%' ORDER BY date_posted DESC";
                
            }
            else
            {
                int value;
                value = Integer.parseInt(textToSearch);
                sql = "SELECT * FROM " + db_controller.getTABLE_PROPERTY() + " WHERE seller_id != '" + uc.getLoggedUser().getId()+ "' AND ( value='" + value + "' or value<'"+ value +"' )  ORDER BY date_posted DESC";
            }
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
                
                searchList.add(new Property(property_id,seller_id,on_sale,value,city,address,date_posted,image));
                
            }
            
        } 
        catch (SQLException ex) {ex.printStackTrace(); return null;} 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
        
        return searchList;
    }

}
