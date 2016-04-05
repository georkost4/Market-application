/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import DAO.DatabaseController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import marketsimulator.Model.User;

/**
 *
 * @author SoRa
 */
public class UserController  implements UserInterface
{
    DatabaseController db_controller = new DatabaseController();
   
    @Override
    public User getUser(String given_username,JFrame frame) 
    {
        User tempUser = null;
        Connection conn = null;
        Statement stmt = null;
        try 
        {
           db_controller.setClass();
           conn = db_controller.getConnection();
           stmt = conn.createStatement();
           String sql;
          
           sql = "SELECT * FROM users where username = '" + given_username + "'";
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
           
           rs.close();
           stmt.close();
           conn.close();
       } 
       catch (SQLException ex) {ex.printStackTrace(); JOptionPane.showMessageDialog(frame,"Could not establish connection to the database.");  return null;} 
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
           db_controller.setClass();
           conn = db_controller.getConnection();
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
       User tmpUser = getUser(username,null);
       if(tmpUser == null) return false;
       if(tmpUser.getPassword().equals(password)) return true;
       return false;
    }

    @Override
    public User getLoggedUser() {
        User tmp = null;
        try
        {
		FileInputStream fin = new FileInputStream(System.getProperty("user.home")+"\\Documents\\user.ser");
		ObjectInputStream oos = new ObjectInputStream(fin);   
		tmp = (User) oos.readObject();
		oos.close();	   
	}
        catch(Exception ex){  ex.printStackTrace();return null;}
        
        return tmp;
    }

    @Override
    public boolean setLoggedUser(User user) 
    {
        try
        {
		File file = new File(System.getProperty("user.home")+"\\Documents\\user.ser");
                file.deleteOnExit();
		FileOutputStream fout = new FileOutputStream(System.getProperty("user.home")+"\\Documents\\user.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fout);   
		oos.writeObject(user);
		oos.close();
	}
        catch(Exception ex){  ex.printStackTrace();return false;}
        
        return true;
    }
    
}
