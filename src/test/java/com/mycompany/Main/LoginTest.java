/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author south
 */
public class LoginTest {
    @Test
    public void testCheckUserName() {
        Login login = new Login();
        assertTrue(login.checkUserName("abc_1")); // Valid username
        assertFalse(login.checkUserName("abc")); // Missing underscore
        assertFalse(login.checkUserName("abcdef_")); // Too long
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Abc@1234")); // Valid password
        assertFalse(login.checkPasswordComplexity("abc1234")); // Missing capital letter and special character
        assertFalse(login.checkPasswordComplexity("ABC@123")); // Less than 8 characters
    }

    @Test
    public void testRegisterUser() {
        Login login = new Login();
        assertEquals("User successfully registered!", 
                     login.registerUser("abc_1", "Abc@1234", "John", "Doe")); // Valid registration
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", 
                     login.registerUser("abc", "Abc@1234", "John", "Doe")); // Invalid username
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", 
                     login.registerUser("abc_1", "abc1234", "John", "Doe")); // Invalid password
    }

    @Test
    public void testLoginUser() {
        Login login = new Login();
        login.registerUser("abc_1", "Abc@1234", "John", "Doe");

        assertTrue(login.loginUser("abc_1", "Abc@1234")); // Valid login
        assertFalse(login.loginUser("abc_1", "wrongPass")); // Invalid password
        assertFalse(login.loginUser("wrongUser", "Abc@1234")); // Invalid username
    }

    @Test
    public void testReturnLoginStatus() {
        Login login = new Login();
        login.registerUser("abc_1", "Abc@1234", "John", "Doe");

        assertEquals("Welcome John Doe, it is great to see you again.", 
                     login.returnLoginStatus("abc_1", "Abc@1234")); // Successful login message
        assertEquals("Username or password incorrect, please try again.", 
                     login.returnLoginStatus("wrongUser", "Abc@1234")); // Failed login message
    }
}
