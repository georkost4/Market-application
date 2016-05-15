/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Controller that manages input-validation related code .
 * For example when adding new property the value field must
 * be validated for a number input or the city field must be
 * validated for a string input .
 * @author SoRa
 */
public class ValidationController implements ValidationInterface
{
    
    /**
     * Method that check if the input phone is only 10 numerical chars .
     * @param phone Phone input to be validated.
     * @return <true> for validation otherwise <b>false</b> .
     */
    @Override
    public boolean validatePhoneNumber(String phone) 
    {
        String regex = "[0-9]{10}";
        
        if(phone.matches(regex)) return true;
        
        return false;
    }

    /**
     * Method for validating password input. Must be at least 4 chars long , maximum 10
     * and must contain only alphanumerical values .
     * @param password Input to validate .
     * @return <b>true</b> if validation succeeds.
     */
    @Override
    public boolean validatePassword(String password) {
        String regex = "[0-9a-zA-Z]{4,10}" ;
        
        if(password.matches(regex)) return true;
        
        return false;
    }

    /**
     * Method for validating first name and last name fields .
     * Name fields must be at least 2 char long and contain only
     * a-z,A-Z characters.
     * @param name1 First name input .
     * @param name2 Last name input . 
     * @return <b>true</b> if validation succeeds .
     */
    @Override
    public boolean validateName(String name1, String name2) {
        String regex = "[a-zA-Z]{2,}";
        
        if(name1.matches(regex) && name2.matches(regex)) return true;
        return false;
    }

    /**
     * Method for validating username field.
     * Must start with a-z or A-Z and can contain one or more
     * alphanumerical value .
     * @param username Username input .
     * @return <b>true</b> if validation succeeds .
     */
    @Override
    public boolean validateUsername(String username) {
        // Start with character and contain zero or more numbers and characters
        String regex = "[a-zA-Z]([0-9a-zA-Z])+?" ;
        
        if (username.matches(regex)) return true;
        return false;
    }
    
    /**
     * Method for validating City field . The same
     * rules as Name fields apply here as well.
     * @param city City input.
     * @return <b>true</b> if validation succeeds .
     */
    @Override
    public boolean validateCity(String city) {
        // Same rules as Name validation
        return this.validateName(city, city);
    }

    /**
     * Method for validating Price field .
     * Must be at least one char long and can 
     * contain only numerical values .
     * @param value Price input .
     * @return <b>true</b> if validation succeeds .
     */
    @Override
    public boolean validateValue(String value) {
        // Only numerical 
        String regex = "[0-9]{1,}";
        
        if(value.matches(regex)) return true;
        return false;
    }

    /**
     * Method for validating address field .
     * Must start with a-zA-Z only and must end with
     * a space and a number. e.g "Andreou 23" .
     * @param address Address input .
     * @return <b>true</b> if validation succeeds .
     */
    @Override
    public boolean validateAddress(String address) {
       // Characters followed by a number
        String regex = "([a-zA-Z]+ [0-9]{1,})+";
        
        if(address.matches(regex)) return true;
        return false;
    }

    /**
     * Method that validates user Registration and outputs the corresponding error
     * message.
     * @param frame The frame to output the error message.
     * @param name First name input.
     * @param name2 Last name input.
     * @param phone Phone number input.
     * @param password Password input.
     * @param username Username input.
     * @param city City input.
     * @return <b>true</b> if each validation test succeeds .
     */
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

    /**
     * Method that call each validation method and outputs corresponding 
     * error messages.
     * @param frame The frame to output the messages.
     * @param value Value input.
     * @param city City input.
     * @param address Address input.
     * @return <b>true</b> if each validation method succeeds .
     */
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
