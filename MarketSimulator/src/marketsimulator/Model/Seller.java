/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Model;

/**
 *
 * @author SoRa
 */
public class Seller extends User
{
    public Seller(int id, String firstname, String lastname, String username, String password, String city, String number) 
    {
        super(id, firstname, lastname, username, password, city, number);
    } 
     public Seller(String firstname, String lastname, String username, String password, String city, String number) 
    {
        super(firstname, lastname, username, password, city, number);
    }   
}
