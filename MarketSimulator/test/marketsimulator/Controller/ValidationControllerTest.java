/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SoRa
 */
public class ValidationControllerTest {
    
    public ValidationControllerTest() {}
    
   
    @Test
    public void testValidatePhoneNumber() {
        System.out.println("validatePhoneNumber");
        String phone = "0123456789";
        ValidationController instance = new ValidationController();
        boolean expResult = true;
        boolean result = instance.validatePhoneNumber(phone);
        assertEquals(expResult, result);
    }

    @Test
    public void testValidatePassword() {
        System.out.println("validatePassword");
        String password = "1234dA";
        ValidationController instance = new ValidationController();
        boolean expResult = true;
        boolean result = instance.validatePassword(password);
        assertEquals(expResult, result);
        
    }

  
    @Test
    public void testValidateName() {
        System.out.println("validateName");
        String name1 = "ss";
        String name2 = "ds";
        ValidationController instance = new ValidationController();
        boolean expResult = true;
        boolean result = instance.validateName(name1, name2);
        assertEquals(expResult, result);
    }

    
    @Test
    public void testValidateUsername() {
        System.out.println("validateUsername");
        String username = "sdsssssss2ss";
        ValidationController instance = new ValidationController();
        boolean expResult = true;
        boolean result = instance.validateUsername(username);
        assertEquals(expResult, result);
       
    }

    @Test
    public void testValidateValue() {
        System.out.println("validateValue");
        String value = "79";
        ValidationController instance = new ValidationController();
        boolean expResult = true;
        boolean result = instance.validateValue(value);
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testValidateAddress() {
        System.out.println("validateAddress");
        String address = "asdsd 3";
        ValidationController instance = new ValidationController();
        boolean expResult = true;
        boolean result = instance.validateAddress(address);
        assertEquals(expResult, result);
       
    }
    
}
