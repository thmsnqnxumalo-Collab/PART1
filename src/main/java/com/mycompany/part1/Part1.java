/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part1;
import java.util.Scanner;
/**
 *
 * @author twnxu
 */
public class Part1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=====================================");
        System.out.println("   Registration & Login");
        System.out.println("=====================================");

        System.out.print("Enter your first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = input.nextLine();

        Login login = new Login(firstName, lastName);

        // ----- REGISTRATION -----
        String username;
        while (true) {
            System.out.print("Enter a username (must contain an underscore and be no more than 5 characters): ");
            username = input.nextLine();
            if (login.checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            }
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.");
        }

        String password;
        while (true) {
            System.out.print("Enter a password (8+ characters, a capital letter, a number and a special character): ");
            password = input.nextLine();
            if (login.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            }
            System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
        }

        String cellPhoneNumber;
        while (true) {
            System.out.print("Enter your South African cell phone number (e.g. +27838968976): ");
            cellPhoneNumber = input.nextLine();
            if (login.checkCellPhoneNumber(cellPhoneNumber)) {
                System.out.println("Cell phone number successfully added.");
                break;
            }
            System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
        }

        System.out.println();
        System.out.println(login.registerUser(username, password, cellPhoneNumber));

        // ----- LOGIN -----
        System.out.println();
        System.out.println("--- Please log in ---");

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Username: ");
            String loginUsername = input.nextLine();

            System.out.print("Password: ");
            String loginPassword = input.nextLine();

            loggedIn = login.loginUser(loginUsername, loginPassword);
            System.out.println(login.returnLoginStatus());
        }

        System.out.println();
        System.out.println("You are now logged in. Goodbye!");
        input.close();
    }
}
