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
public class Buyer extends User 
{

    public Buyer(int id, String username, String password){super(id, username, password);}
    
    public void addProperty(String name,Double value,String image,String datePosted){};
    public void RemoveProperty(String name,Double value,String image,String datePosted){};
    public void checkBids(String name,Double value,String image,String datePosted){};
    public void approveBid(){};
    public void disapproveBid(){};
    
    
}
