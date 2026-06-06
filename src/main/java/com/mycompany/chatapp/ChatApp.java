/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;

/**
 *
 * @author anele
 */
public class ChatApp {

    static Scanner scanner = new Scanner(System.in);
     static Login login = new Login();

     static int totalMessagesSent = 0;

    public static void main(String[] args) {

        System.out.println("      Welcome to QuickChat      ");

        // REGISTRATION
        
        System.out.print("Enter First Name: ");
        String FirstName= scanner.nextLine();
        
        System.out.print("Enter LastName: ");
        String LastName= scanner.nextLine();
         
        login.setFirstName(FirstName); 
        login.setLastName(LastName);
        
        System.out.print(
                "Enter a username (max 5 characters, must include _): "
        );

        String username =
                scanner.nextLine();

        while (!login.checkUserName(username)) {

            System.out.println(
                    "Username is not correctly formatted."
            );

            System.out.print(
                    "Enter username again: "
            );

            username =
                    scanner.nextLine();
        }

        System.out.print(
                "Enter a complex password: "
        );

        String password =
                scanner.nextLine();

        while (!login.checkPasswordComplexity(password)) {

            System.out.println(
                    "Password is not correctly formatted."
            );

            System.out.print(
                    "Enter password again: "
            );

            password =
                    scanner.nextLine();
        }

        System.out.print(
                "Enter your SA cell number (e.g. +27834567890): "
        );

        String cell =
                scanner.nextLine();

        while (!login.checkCellPhoneNumber(cell)) {

            System.out.println(
                    "Cell phone number incorrectly formatted."
            );

            System.out.print(
                    "Enter cellphone number again: "
            );

            cell =
                    scanner.nextLine();
        }

        login.registerUser(
                username,
                password,
                cell
        );

        System.out.println(
                "\nRegistration successful."
        );

        // LOGIN
        System.out.print(
                "\nLogin - Enter username: "
        );

        String user =
                scanner.nextLine();

        System.out.print(
                "Login - Enter password: "
        );

        String pass =
                scanner.nextLine();

        if (login.loginUser(user, pass)) {

            System.out.println(
                    login.returnLoginStatus()
            );

            menuLoop();

        } else {

            System.out.println(
                    "Username or password incorrect, please try again."
            );
        }
    }

    // MENU
    public static void menuLoop() {

        while (true) {

            System.out.println("\nMenu:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            System.out.print(
                    "Choose option: "
            );

            String choice =
                    scanner.nextLine();

            switch (choice) {

                case "1":

                    sendMessage();

                    break;

                case "2":

                    System.out.println(
                            "Coming Soon."
                    );

                    break;

                case "3":

                    System.out.println(
                            "Total messages sent: "
                            + totalMessagesSent
                    );

                    System.out.println(
                            "Goodbye, Thank you for using QuickChat."
                    );

                    System.exit(0);

                    break;

                default:

                    System.out.println(
                            "Invalid option. Try again."
                    );
            }
        }
    }

    // SEND MESSAGE
    public static void sendMessage() {

        System.out.print(
                "\nEnter message ID: "
        );

        String id =
                scanner.nextLine();

        System.out.print(
                "Enter recipient number: "
        );

        String recipient =
                scanner.nextLine();

        System.out.print(
                "Enter message: "
        );

        String text =
                scanner.nextLine();

        Message msg =
                new Message(
                        id,
                        recipient,
                        text,
                        totalMessagesSent + 1
                );

        if (!msg.checkRecipientCell()) {

            System.out.println(
                    "Cell phone number incorrectly formatted."
            );

            return;
        }

        System.out.println(
                "\nChoose Action"
        );

        String status =
                msg.sendMessageOption();

        System.out.println(
                "\nMessage Status: "
                + status
        );

        System.out.println(
                msg.display()
        );

        if (status.equals("Sent")) {

            totalMessagesSent++;
        }
    }
}