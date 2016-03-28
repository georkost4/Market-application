/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import DAO.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import marketsimulator.Model.User;

/**
 *
 * @author SoRa
 */
public class UserController extends Database implements UserInterface
{
   
    @Override
    public User getUser(String given_username) 
    {
        User tempUser = null;
        Connection conn = null;
        Statement stmt = null;
       try 
       {
           super.setClass();
           conn = super.getConnection();
           stmt = conn.createStatement();
           String sql;
          
           sql = "SELECT * FROM users where username = '"+given_username+"'";
           ResultSet rs = stmt.executeQuery(sql);
           
           rs.next();
            
           int id  = rs.getInt("user_id");
           String firstname  = rs.getString("firstname");
           String lastname   = rs.getString("lastname");
           String username   = rs.getString("username");
           String password   = rs.getString("password");
           String city       = rs.getString("city");
           String number     = rs.getString("number");

           tempUser = new User(id,firstname,lastname,username,password,city,number);

           System.out.println(tempUser);
           
           rs.close();
           stmt.close();
           conn.close();
       } 
       catch (SQLException ex) {ex.printStackTrace(); return null;} 
       catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
       return tempUser;
    } 

    @Override
    public boolean userRegister(User user) 
    {  
       Connection conn = null;
       Statement stmt = null;
       try 
       {
           super.setClass();
           conn = super.getConnection();
           stmt = conn.createStatement();
           String sql;
          
           sql = "INSERT INTO users (firstname,lastname,username,password,city,number) "
                   + "values ('"+ user.getFirstname()+"'," 
                   + "'" + user.getLastname() + "'," 
                   + "'" + user.getUsername() + "'," 
                   + "'" + user.getPassword() + "'," 
                   + "'" + user.getCity() + "',"
                   + "'" + user.getNumber() + "')";
           int result = stmt.executeUpdate(sql);
           
           System.out.println(String.valueOf(result));
           stmt.close();
           conn.close();
           if(result == 1) return true;
           else return false;
        }  
        catch (SQLException ex) { ex.printStackTrace(); return false;} 
        catch (ClassNotFoundException ex) { ex.printStackTrace(); return false;} 
    }

    @Override
    public boolean userLogin(String username, String password) 
    {
       User tmpUser = getUser(username);
       if(tmpUser == null) return false;
       if(tmpUser.getPassword().equals(password)) return true;
       else return false;
    }
    
    
   
}
