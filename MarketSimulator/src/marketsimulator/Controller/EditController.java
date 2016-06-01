/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import marketsimulator.Controller.DatabaseController;

/**
 * Controler for editing user's personal info.
 * @author Nikos
 */
public class EditController {
    
    DatabaseController dbcontroller = new DatabaseController();
 
    /**
    * Method that gets the typed new data from EditView
    * and updates the database.
    */
    
    public void EditedData(String firstname,String lastname,String city,String number) throws SQLException{
         

        Connection conn = null;
        Statement stm = null;
        

         try
         {
  
            conn = dbcontroller.getConnection();
            String sql = null;
            stm = conn.createStatement();
            UserController uc = new UserController();           
            
            PreparedStatement ps = conn.prepareStatement("UPDATE users SET firstname='"+ firstname +"',lastname='"+ lastname +"',city='"+ city +"',number='"+ number +"'  WHERE  username= '" + uc.getLoggedUser().getUsername()+ "' ");
            
             ps.executeUpdate();
             ps.close();
             
          }
        catch (SQLException se)
         {

           throw se;
         }
    
        }
    }
