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
import marketsimulator.Model.DatabaseController;

/**
 *
 * @author Nikos
 */
public class EditController {
    
    DatabaseController db_controller = new DatabaseController();
 
    public void EditedData(String firstname,String lastname,String city,String number){
    
        Connection con = null;
        Statement stm = null;
        
                try
        {
  
            db_controller.setClass();
            con = db_controller.getConnection();
            String sql = null;
            stm = con.createStatement();
            UserController uc = new UserController();           
            
            sql = "UPDATE users SET firstname='"+ firstname +"',lastname='"+ lastname +"',city='"+ city +"',number='"+ number +"'  WHERE  username= '" + uc.getLoggedUser().getUsername()+ "' ";
            
            ResultSet rs =  stm.executeQuery(sql);
        }
        catch (SQLException ex) {ex.printStackTrace(); } 
        catch (ClassNotFoundException ex) {ex.printStackTrace(); 
        
        }   
    
    }
    
}
