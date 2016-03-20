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
public  class User 
{
    private int id;
    private String username , password , city , number ;
    
    public  User(int id,String username,String password)
    {
        this.id = id;
        this.password = password;
        this.username = username;
    }
    
    public void userLogin(){};
    public void userRegister(){};
    public void userChangePassword(){};
    
    
    @Override
    public String toString() 
    {
        return "User id: "+this.id+"\n Usernane:"+username+"\n Password:"+password+"\n";
    }
    
    
}
