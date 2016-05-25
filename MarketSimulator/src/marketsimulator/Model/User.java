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
 *
 * @author SoRa
 */
public  class User implements Serializable
{
    private int id;
    private String firstname,lastname,username , password , city , number , personal_details ;
    
    /**
     *
     * @param id
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @param city
     * @param number
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
     *
     * @param firstname
     * @param lastname
     * @param username
     * @param password
     * @param city
     * @param number
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
     *
     * @return
     */
    public String getPersonal_details() {
        return personal_details;
    }

    /**
     *
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
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @return
     */
    public String getNumber() {
        return number;
    }

   
}
