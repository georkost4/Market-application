/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author SoRa
 */
public class ValidationController implements ValidationInterface
{
    

    @Override
    public boolean validatePhoneNumber(String phone) 
    {
        String regex = "[0-9]{10}";
        
        if(phone.matches(regex)) return true;
        
        return false;
    }

    @Override
    public boolean validatePassword(String password) {
        String regex = "[0-9a-zA-Z]{4,10}" ;
        
        if(password.matches(regex)) return true;
        
        return false;
    }

    @Override
    public boolean validateName(String name1, String name2) {
        String regex = "[a-zA-Z]{2,}";
        
        if(name1.matches(regex) && name2.matches(regex)) return true;
        return false;
    }

    @Override
    public boolean validateUsername(String username) {
        // Start with character and contain zero or more numbers and characters
        String regex = "[a-zA-Z]([0-9a-zA-Z])+?" ;
        
        if (username.matches(regex)) return true;
        return false;
    }
    
     @Override
    public boolean validateCity(String city) {
        // Same rules as Name validation
        return this.validateName(city, city);
    }

   

    @Override
    public boolean validateValue(String value) {
        // Only numerical 
        String regex = "[0-9]{1,}";
        
        if(value.matches(regex)) return true;
        return false;
    }

    @Override
    public boolean validateAddress(String address) {
       // Characters followed by a number
        String regex = "([a-zA-Z]+ [0-9]{1,})+";
        
        if(address.matches(regex)) return true;
        return false;
    }

    @Override
    public boolean validateRegisterInput(JFrame frame,String name, String name2, String phone, String password, String username,String city) {
        if(!this.validateName(name, name2))
        {
            JOptionPane.showMessageDialog(frame, "a-z and A-Z only \u2022 \n sadasd", "First and/or Last name Error", JOptionPane.INFORMATION_MESSAGE);
            return false;        
        }
        if(!this.validatePassword(password)){
            JOptionPane.showMessageDialog(frame, "a-z,A-Z and 0-9 only", "Password Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } 
        if(!this.validatePhoneNumber(phone))
        {
            JOptionPane.showMessageDialog(frame, "0-9 characters only", "Phone number Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } 
        if(!this.validateUsername(username))
        {
             JOptionPane.showMessageDialog(frame, "a-z,A-Z,0-9 only", "Username Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        if(!this.validateCity(city))
        {
             JOptionPane.showMessageDialog(frame, "a-z and A-Z only", "City Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }

    @Override
    public boolean validateAddNewPropertyInput(JFrame frame, String value, String city, String address) 
    {
     
        if(!this.validateValue(value)){
            JOptionPane.showMessageDialog(frame, " 0-9 only", "Value Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } 
        if(!this.validateAddress(address))
        {
            JOptionPane.showMessageDialog(frame, "a-z and 0-9", "Address input Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } 
        if(!this.validateCity(city))
        {
            JOptionPane.showMessageDialog(frame, "a-z only", "City input Error", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
       
    }

   

   
    
}
