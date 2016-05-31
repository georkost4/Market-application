/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.Files;
import marketsimulator.Model.DatabaseController;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import marketsimulator.Model.Property;

/**
 * Controller for managing with property related code
 * like adding,removing,getState  of some property
 * @author SoRa
 */
public class PropertyController  implements PropertyInterface  {
    DatabaseController db_controller = new DatabaseController();
    
    /**
     * Method for adding new property on sale.
     * @param property The property object to put on sale.
     * @return <b>true</b> for success.
     */
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

    /**
     * Method for removing a property you put from the application.
     * @param property The property object to remove.
     * @return <b>true</b> for success.
     */
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

    /**
     * Method for getting the list of properties on sale to display on main view.
     * @return ArrayList with property objects .
     */
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
    
    /**
     * Method for getting the state(on sale or not on sale) of a specific property.
     * @param property_id The property you want to get the state.
     * @return <b>1</b> if the property is on sale.
     * <b>0</b> if the property is sold.
     * <b>-1</b> if error occurs .
     */
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

    /**
     * Method for changing a specific property state.
     * @param property_id The property you want to change its state;
     * @return <b>true</b> for success.
     */
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
    
    
     /**
     * Method for uploading the image to the server.
     * @param File The file containing the image of the property.
     * @return <b>true</b> for success.
     */
    public void uploadImageToServer(File file) 
    {

        try {
           
            
            byte [] arr = Files.readAllBytes(file.toPath());
            
            String base64 = Base64.encode(arr);
         
            URL url = new URL(DatabaseController.SERVER_URL);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            String toSend = URLEncoder.encode("image","UTF-8") + "=" + URLEncoder.encode(base64,"UTF-8");
            toSend += "&" +URLEncoder.encode("name","UTF-8") + "=" + URLEncoder.encode(file.getName(),"UTF-8");
            toSend += "&" + URLEncoder.encode("id","UTF-8") + "=" + URLEncoder.encode(String.valueOf((new UserController().getLoggedUser().getId())),"UTF-8");
            
            out.write(toSend);
            out.close();
            
            BufferedReader in = new BufferedReader( new InputStreamReader( connection.getInputStream()));
            String response;
            while ((response = in.readLine()) != null) 
            {
                System.out.println(response);
            }
            in.close();
        } 
        catch (MalformedURLException ex) {ex.printStackTrace();} catch (IOException ex) { ex.printStackTrace();}
    }

}
