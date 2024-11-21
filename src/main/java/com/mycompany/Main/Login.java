/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Main;
/**
 *
 * @author south
 */
public class Login {
    // Private variables to store user details
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // Method to check if the username is valid
    public boolean checkUserName(String username) {
        // Ensures the username contains an underscore (_) and is no more than 5 characters long
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if the password is complex enough
    public boolean checkPasswordComplexity(String password) {
        // Ensures the password meets the following requirements:
        // - At least 8 characters long
        // - Contains at least one uppercase letter
        // - Contains at least one number
        // - Contains at least one special character (!@#$%^&*())
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&  // Contains an uppercase letter
               password.matches(".*[0-9].*") && // Contains a number
               password.matches(".*[!@#$%^&*()].*"); // Contains a special character
    }

    // Method to register a user
    public String registerUser(String username, String password, String firstName, String lastName) {
        // Check if the username is valid
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }
        // Check if the password is valid
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.";
        }
        // Save the user's details if both username and password are valid
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        return "User successfully registered!";
    }

    // Method to log in a user
    public boolean loginUser(String username, String password) {
        // Check if the provided username and password match the registered user's details
        return this.username != null && this.username.equals(username) && this.password.equals(password);
    }

    // Method to return a login status message
    public String returnLoginStatus(String username, String password) {
        // If the login is successful, return a welcome message
        if (loginUser(username, password)) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
            // If the login fails, return an error message
            return "Username or password incorrect, please try again.";
        }
    }
}
