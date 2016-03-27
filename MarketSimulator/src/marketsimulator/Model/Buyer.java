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
public class Buyer extends User 
{
    public Buyer(int id, String firstname, String lastname, String username, String password, String city, String number) {
        super(id, firstname, lastname, username, password, city, number);
    }
     public Buyer(String firstname, String lastname, String username, String password, String city, String number) {
        super(firstname, lastname, username, password, city, number);
    }
}
