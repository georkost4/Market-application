/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import marketsimulator.Model.DatabaseController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
 * Controller for managing user-related operations such as
 * login,register,getUser and more.
 * @author SoRa
 */
public class UserController  implements UserInterface
{
    DatabaseController db_controller = new DatabaseController();
   
    /**
     * Method for getting a user object given a username .
     * @param given_username The user's username.
     * @return <b>User</b> object . 
     */
    @Override
    public User getUser(String given_username) 
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
           
           while(rs.next())
           {
                int id  = rs.getInt("user_id");
                String firstname  = rs.getString("firstname");
                String lastname   = rs.getString("lastname");
                String username   = rs.getString("username");
                String password   = rs.getString("password");
                String city       = rs.getString("city");
                String number     = rs.getString("number");

                tempUser = new User(id,firstname,lastname,username,password,city,number);
                System.out.println("Here-1");
           }
           rs.close();
           stmt.close();
           conn.close();
           System.out.println("Here");
           if(tempUser == null) System.out.println("true");
       } 
       catch (SQLException ex) {ex.printStackTrace(); return null;} 
       catch (ClassNotFoundException ex) {ex.printStackTrace(); return null; }
       return tempUser;
    } 

    /**
     * Method for registering a new user to the application.
     * @param user The User object to register.
     * @return <b>true</b> for success.
     */
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

    /**
     * Method for a logging in a user.
     * @param username The users username.
     * @param password The users password.
     * @return <b>true</b> if the credentials are correct otherwise returns <b>false</b> .
     */
    @Override
    public boolean userLogin(String username, String password) 
    {
       User tmpUser = null;
       tmpUser = getUser(username);
       if(tmpUser == null) return false;
       if(tmpUser.getPassword().equals(password)) return true;
       return false;
    }

    /**
     * Method for getting the logged in user .
     * @return <b>User</b> object .
     */
    @Override
    public User getLoggedUser() {
        User tmp = null;
        try
        {
		FileInputStream fin = new FileInputStream(System.getProperty("user.home")+"\\user.ser");
		ObjectInputStream oos = new ObjectInputStream(fin);   
		tmp = (User) oos.readObject();
		oos.close();	   
	}
        catch(Exception ex){  ex.printStackTrace();return null;}
        
        return tmp;
    }

    /**
     * Method for saving logged User object in hard drive.
     * @param user User object to save.
     * @return <b>true</b> if saving was successful.
     */
    @Override
    public boolean setLoggedUser(User user) 
    {
        try
        {
            File file = new File(System.getProperty("user.home")+"\\user.ser");
           
            File file_remember_me = new File(System.getProperty("user.home")+"\\remember.ser");
            if(!file_remember_me.exists()) file.deleteOnExit();
            
            FileOutputStream fout = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fout);   
            oos.writeObject(user);
            oos.close();
	}
        catch(Exception ex){  ex.printStackTrace();return false;}
        
        return true;
    }
    
    /**
     * Method for setting logged user personal info .
     * @param text Personal info text .
     * @return <b>true</b> if saving was successful.
     */
    @Override
    public boolean addUserPersonalInfo(String text) 
    {
        
       User tmp = this.getLoggedUser();
       tmp.setPersonal_details(text);
       if(this.setLoggedUser(tmp)) System.out.print("done");
       Connection conn = null;
       Statement stmt = null;
       try 
       {
           db_controller.setClass();
           conn = db_controller.getConnection();
           stmt = conn.createStatement();
           String sql;
          
           sql = "INSERT INTO user_personal_information (user_id,information) VALUES ( " + this.getLoggedUser().getId() + " , '" + text + "')";
                 
           int result = stmt.executeUpdate(sql);
           
           stmt.close();
           conn.close();
           if(result == 1) return true;
           else return false;
       }  
        catch (SQLException ex) { ex.printStackTrace(); return false;} 
        catch (ClassNotFoundException ex) { ex.printStackTrace(); return false;} 
       
    }
    
    /**
     * Method for retrieving logged user personal info .
     * @param user_id Logged user id .
     * @return <b>String</b> containing users personal info .
     */
    @Override
    public String getUserPersonalInfo(String user_id)
    {
       String returnVal = null; 
       Connection conn = null;
       Statement stmt = null;
       try 
       {
           db_controller.setClass();
           conn = db_controller.getConnection();
           stmt = conn.createStatement();
           String sql;
          
           sql = "SELECT information from user_personal_information where user_id = '" + user_id + "'";
                      
           ResultSet rs = stmt.executeQuery(sql);
           
          
           while(rs.next())
           {
               returnVal = rs.getString("information");
           }
           
           stmt.close();
           conn.close();
          
       }  
        catch (SQLException ex) { ex.printStackTrace(); return null;} 
        catch (ClassNotFoundException ex) { ex.printStackTrace(); return null;} 
        return returnVal;
    }

    /**
     * Method for updating the personal info of the logged user.
     * @param text Updated personal info text.
     * @return <b>true</b> for success.
     */
    @Override
    public boolean updateUserPersonalInfo(String text) {
       User tmp = this.getLoggedUser();
       tmp.setPersonal_details(text);
       if(this.setLoggedUser(tmp)) System.out.print("done");
       Connection conn = null;
       Statement stmt = null;
       try 
       {
           db_controller.setClass();
           conn = db_controller.getConnection();
           stmt = conn.createStatement();
           String sql;
          
           sql = "UPDATE user_personal_information set information = + '" + text + "' where user_id = " + this.getLoggedUser().getId();
                 
           int result = stmt.executeUpdate(sql);
           
           stmt.close();
           conn.close();
           if(result == 1) return true;
           else return false;
       }  
        catch (SQLException ex) { ex.printStackTrace(); return false;} 
        catch (ClassNotFoundException ex) { ex.printStackTrace(); return false;} 
       
    }
    
    /**
     * Method for checking if any user is logged to the application.
     * @return <b>true</b> if  someone is logged in otherwise <b>false</b> .
     */
    public boolean checkIfLoggedIn() 
     {
        if(this.getLoggedUser() != null)
        {
            return true;
        }
        return false;
    }
    
    /**
     * Method for creating remember me(keep me logged in) file in hard drive.
     * @return <b>true</b> if operation is successful.
     */
    public boolean setRememberMe()
    {
         try 
            {
                File file = new File(System.getProperty("user.home")+"\\remember.ser");
                FileOutputStream fout = new FileOutputStream(file);
                fout.write(1);
                fout.close();
            }
            catch (IOException ex) {ex.printStackTrace();  return false; }
         return true;
    }
    
    /**
     * Method for checking if remember me(keep me logged in) file exists .
     * @return <b>true</b> if exists.
     */
    public boolean checkIfRememberFileExists()
    {
        File file = new File(System.getProperty("user.home")+"\\remember.ser");
        if (file.exists()) return true;
        return false;   
    }
    
}
