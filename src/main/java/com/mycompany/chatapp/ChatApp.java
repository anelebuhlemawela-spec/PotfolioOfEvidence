/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;

public class ChatApp {

    static Scanner scanner = new Scanner(System.in);
    static Login login = new Login();
    static MessageManager manager = new MessageManager();

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println("      WELCOME TO QUICKCHAT       ");
        System.out.println("=================================");

        // REGISTRATION
  System.out.print("Enter First Name: ");
    String firstName = scanner.nextLine();

    System.out.print("Enter Last Name: ");
    String lastName = scanner.nextLine();

    login.setfirstname(firstName);
    login.setlastname(lastName);

    System.out.print("Enter Username: ");
    String username = scanner.nextLine();

    System.out.print("Enter Password: ");
    String password = scanner.nextLine();

      

        System.out.print("Enter Cell Number (+27xxxxxxxxx): ");
        String cell = scanner.nextLine();

        String registrationResult =
                login.registerUser(
                        username,
                        password,
                        cell);

        System.out.println("\n" + registrationResult);

        if (!registrationResult.equals("Registration successful.")) {
            System.out.println("Registration failed.");
            return;
        }

        // LOGIN

        System.out.println("\n========== LOGIN ==========");

        System.out.print("Username: ");
        String user = scanner.nextLine();

        System.out.print("Password: ");
        String pass = scanner.nextLine();

        if (login.loginUser(user, pass)) {

            System.out.println(
                    "\n" + login.returnLoginStatus());

            manager.loadStoredMessages();

            menuLoop();

        } else {

            System.out.println(
                    "\nUsername or password incorrect.");
        }
    }

    public static void menuLoop() {

        while (true) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Send Messages");
            System.out.println("2. Show Recently Sent Messages");
            System.out.println("3. Quit");
            System.out.println("4. Reports");
            System.out.print("Choose option: ");

            String choice =
                    scanner.nextLine();

            switch (choice) {

                case "1":

                    System.out.print(
                            "How many messages would you like to send? ");

                    int num =
                            Integer.parseInt(
                                    scanner.nextLine());

                    manager.sendMessages(num);

                    break;

                case "2":

                    System.out.println(
                            "Coming Soon.");

                    break;

                case "3":

                    manager.saveStoredMessages();

                    System.out.println(
                            "\nTotal Messages Sent: "
                            + manager.returnTotalMessages());

                    System.out.println(
                            "Thank you for using QuickChat.");

                    System.exit(0);

                    break;

                case "4":

                    reportMenu();

                    break;

                default:

                    System.out.println(
                            "Invalid option.");
            }
        }
    }

    public static void reportMenu() {

        while (true) {

            System.out.println("\n========== REPORT MENU ==========");
            System.out.println("1. View Sent Messages");
            System.out.println("2. View Discarded Messages");
            System.out.println("3. View Stored Messages");
            System.out.println("4. View Total Messages Sent");
            System.out.println("5. View Longest Message");
            System.out.println("6. Search Messages By Recipient");
            System.out.println("7. Delete Message By Hash");
            System.out.println("8. Back");

            System.out.print("Choose option: ");

            String option = 
                    scanner.nextLine();

            switch (option) {

                case "1":

                    manager.displaySentMessages();

                    break;

                case "2":

                    manager.displayDiscardedMessages();

                    break;

                case "3":

                    manager.displayStoredMessages();

                    break;

                case "4":

                    System.out.println(
                            "Total Messages Sent: "
                            + manager.returnTotalMessages());

                    break;

                case "5":

                    manager.findLongestMessage();

                    break;

                case "6":

                    manager.searchMessagesByRecipient();

                    break;

                case "7":

                    manager.deleteMessageByHash("10:2:WHEREASKED");

                    break;

                case "8":

                    return;

                default:

                    System.out.println(
                            "Invalid option.");
            }
        }
    }
}

