/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import org.junit.Test;

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
        String address = "asdsd 34";
        String address2 = "asdsd34";
        String address3 = "asdsd s 34";
        ValidationController instance = new ValidationController();
        boolean expResult = true;
        boolean expResult2 = false;
        boolean expResult3 = true;
        boolean result = instance.validateAddress(address);
        boolean result2 = instance.validateAddress(address2);
        boolean result3 = instance.validateAddress(address3);
        assertEquals(expResult, result);
        assertEquals(expResult2,result2);
        assertEquals(expResult3,result3);
       
    }
    
}
