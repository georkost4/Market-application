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
    private String firstname,lastname,username , password , city , number ;
    
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
    
     public  User(String firstname,String lastname,String username,String password,String city,String number)
    {
   
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
        this.city = city;
        this.number = number;
    }
    
    
    @Override
    public String toString() 
    {
        return "User id: "+this.id+"\nFirst Name:"+firstname+"\n Last Name:"+lastname+"\n Usernane:"+username+"\n Password:"+password+"\n City:"+city+"\n Number:"+number+"\n";
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCity() {
        return city;
    }

    public String getNumber() {
        return number;
    }

   
}
