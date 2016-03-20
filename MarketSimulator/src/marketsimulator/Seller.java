/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator;

/**
 *
 * @author SoRa
 */
public class Seller extends User
{

    public Seller(int id, String username, String password) 
    {
        super(id, username, password);
    }
    
    
    public void checkHistory(){};
    public void placeBid(){};
    public void removeBid(){};
    
}
