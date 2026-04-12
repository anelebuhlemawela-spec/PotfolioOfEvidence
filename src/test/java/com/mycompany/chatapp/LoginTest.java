/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anele
 */
public class LoginTest {
    
    public LoginTest() {
    }



    /**
     * Test of checkUserName method, of class Login.
     */
    @Test
    public void testCheckUserNameTrue() {
        System.out.println("Username is correctly formatted");
        String username = "kyl_1";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckUserNameFalse() {
        System.out.println("checkUserName");
        String username = "kyle!!!!!!!!!";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkPasswordComplexity method, of class Login.
     */
    @Test
    public void testCheckPasswordComplexityTrue() {
        System.out.println("checkPasswordComplexity");
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheckPasswordComplexityFalse() {
        System.out.println("checkPasswordComplexity");
        String password = "password";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        
    }
  
    /**
     * Test of checkCellPhoneNumber method, of class Login.
     */
    @Test
    public void testCheckCellPhoneNumberTrue() {
        System.out.println("checkCellPhoneNumber");
        String phone = "+27838968976 ";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.checkCellPhoneNumber(phone);
        assertEquals(expResult, result);
        
    }
@Test
    public void testCheckCellPhoneNumberFalse() {
        System.out.println("checkCellPhoneNumber");
        String phone = "08966553";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.checkCellPhoneNumber(phone);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUserTrue() {
        System.out.println("loginUser");
        String enteredUsername = "kyl_1";
        String enteredPassword = "Ch&&sec@ke99!";
        Login instance = new Login();
        boolean expResult = true;
        boolean result = instance.loginUser(enteredUsername, enteredPassword);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testLoginUserFalse() {
        System.out.println("loginUser");
        String enteredUsername = "kyle!!!!!!!!!";
        String enteredPassword = "password";
        Login instance = new Login();
        boolean expResult = false;
        boolean result = instance.loginUser(enteredUsername, enteredPassword);
        assertEquals(expResult, result);
    }
    /**
     * Test of returnLoginStatus method, of class Login.
     */
    @Test
    public void testReturnLoginStatusFalse() {
        System.out.println("returnLoginStatus");
        String username = "kyle!!!!!!!!!";
        String password = "password";
        Login instance = new Login();
        String expResult = "wrong,123";
        String result = instance.returnLoginStatus(username, password);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testReturnLoginStatusTrue() {
        System.out.println("returnLoginStatus");
        String username = "kyl_1";
        String password = "Ch&&sec@ke99!";
        Login instance = new Login();
        String expResult = "Welcome, you have successfully logged in.\"; ";
        String result = instance.returnLoginStatus(username, password);
        assertEquals(expResult, result);
    }
}
