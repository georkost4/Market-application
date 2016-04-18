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
    public User getUser(String given_username);
    public User getLoggedUser();
    public boolean setLoggedUser(User user);
    public String getUserPersonalInfo(String user_id);
    public boolean addUserPersonalInfo(String text);
    public boolean updateUserPersonalInfo(String text);
    public boolean checkIfLoggedIn(); 
    public boolean setRememberMe();
    public boolean checkIfRememberFileExists();
}
