/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.part1;

/**
 *
 * @author twnxu
 */
public class Login {
 
     // Stored registration details
    private String registeredUsername;
    private String registeredPassword;
    private String registeredCellPhoneNumber;
    private String firstName;
    private String lastName;

    // Tracks the outcome of the last loginUser() call
    private boolean loginSuccessful = false;

    public Login() {
    }

    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Ensures that the username contains an underscore and is no more than five
     * characters long.
     */
    public boolean checkUserName(String username) {
        if (username == null) {
            return false;
        }
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Ensures the password is at least eight characters long and contains a
     * capital letter, a number and a special character.
     */
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        return hasCapital && hasNumber && hasSpecial;
    }

    /**
     * Ensures the cell phone number contains the international country code and
     * is no more than ten characters long after the code.
     */
    public boolean checkCellPhoneNumber(String cellPhoneNumber) {
        if (cellPhoneNumber == null) {
            return false;
        }
        return cellPhoneNumber.matches("^\\+27\\d{1,9}$");
    }

    /**
     * Registers the user and returns the appropriate registration message.
     */
    public String registerUser(String username, String password, String cellPhoneNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.registeredUsername = username;
        this.registeredPassword = password;
        this.registeredCellPhoneNumber = cellPhoneNumber;

        return "Welcome " + (firstName == null ? "" : firstName) + ", "
                + (lastName == null ? "" : lastName)
                + " it is great to see you.";
    }

    /**
     * Verifies that the login details entered match the details stored at
     * registration.
     */
    public boolean loginUser(String username, String password) {
        loginSuccessful = registeredUsername != null
                && registeredUsername.equals(username)
                && registeredPassword != null
                && registeredPassword.equals(password);
        return loginSuccessful;
    }

    /**
     * Returns the messaging for a successful or a failed login.
     */
    public String returnLoginStatus() {
        if (loginSuccessful) {
            return "Welcome " + (firstName == null ? "" : firstName) + ", "
                    + (lastName == null ? "" : lastName)
                    + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }

    // Getters and setters
    public String getRegisteredUsername() {
        return registeredUsername;
    }

    public String getRegisteredPassword() {
        return registeredPassword;
    }

    public String getRegisteredCellPhoneNumber() {
        return registeredCellPhoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
