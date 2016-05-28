/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

 
/**
 * Class for describing a user
 * in the application . Contains methods
 * for setting and getting a user's details
 * such as name , username, city , number and
 * others .
 * @author SoRa
 */
public  class User implements Serializable
{
    private int id;
    private String firstname,lastname,username , password , city , number , personal_details ;
    
    /**
     * Constructor for creating a User object.
     * @param id Id of the user.
     * @param firstname First name of the user.
     * @param lastname Last name of the user.
     * @param username Username of the user.
     * @param password Password of the user.
     * @param city City of the user.
     * @param number Phone number of the user.
     */
    public  User(int id,String firstname,String lastname,String username,String password,String city,String number)
    {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
        this.city = city;
        this.number = number;
    }
    
    /**
     * Constructor for creating a user
     * object without the user_id attribute.
     * @param firstname First name of the user.
     * @param lastname Last name of the user.
     * @param username Username of the user.
     * @param password Password of the user.
     * @param city City of the user.
     * @param number Phone number of the user.
     */
    public  User(String firstname,String lastname,String username,String password,String city,String number)
    {
   
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
        this.city = city;
        this.number = number;
    }

    /**
     * Getter  user's personal 
     * statement.
     * @return <b>String</b> containing user's details.
     */
    public String getPersonal_details() {
        return personal_details;
    }

    /**
     * Setter for user personal statement.
     * @param personal_details
     */
    public void setPersonal_details(String personal_details) {
        this.personal_details = personal_details;
    }
     
    
    
    @Override
    public String toString() 
    {
        return "User id: "+this.id+"\nFirst Name:"+firstname+"\n Last Name:"+lastname+"\n Usernane:"+username+"\n Password:"+password+"\n City:"+city+"\n Number:"+number+"\n";
    }

    /**
     * Getter for user's id.
     * @return <b>int</b> containing the id of the user.
     */
    public int getId() {
        return id;
    }

    /**
     * Getter of user's First name.
     * @return <b>String</b> containing user's First name.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Getter of user's Last name.
     * @return <b>String</b> containing user's Last name.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Getter of user's Username.
     * @return <b>String</b> containing user's Username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getter of user's password.
     * @return <b>String</b> containing user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter of user's City.
     * @return <b>String</b> containing user's City.
     */
    public String getCity() {
        return city;
    }

    /**
     * Getter of user's phone number.
     * @return <b>String</b> containing user's phone number.
     */
    public String getNumber() {
        return number;
    }

   
}
