/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import javax.swing.JFrame;
import marketsimulator.Model.User;

/**
 *
 * @author SoRa
 */
public interface UserInterface 
{
    public boolean userRegister(User user);
    public boolean userLogin(String username,String password);
    public User getUser(String given_username,JFrame framee);
    public User getLoggedUser();
    public boolean setLoggedUser(User user);
}
