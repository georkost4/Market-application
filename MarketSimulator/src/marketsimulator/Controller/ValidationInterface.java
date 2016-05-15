/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import javax.swing.JFrame;
import marketsimulator.Model.Property;

/**
 * Interface for declaring the methods that
 * ValidationController implements .
 * @author SoRa
 */
public interface ValidationInterface 
{
    public boolean validatePhoneNumber(String  phone);
    public boolean validatePassword(String password);
    public boolean validateName(String name1,String name2);
    public boolean validateUsername(String username);
    public boolean validateCity(String city);
    
    public boolean validateRegisterInput(JFrame frame,String name,String name2,String phone,String password,String username,String city);
    public boolean validateAddNewPropertyInput(JFrame frame,String value,String city,String address);
    
    public boolean validateValue(String value);
    public boolean validateAddress(String address);
    
}
