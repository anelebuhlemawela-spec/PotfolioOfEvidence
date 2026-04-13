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

    public static void main(String[] args) {
       
            Login Login = new Login();
        Scanner input =new Scanner(System.in);
        
        
        //username
        System.out.print("Enter username:");
       String UserName=input.nextLine();
        if(Login.checkUserName(UserName)){
            System.out.println("Username successful captured.");
        }else{
           System.out.println("Username must contain'_'and be no more than 5 characters.");
          // return; 
        }
        //password
        System.out.print("Enter your password:");
        String password=input.nextLine();
        
        if(Login.checkPasswordComplexity(password)){
        Login.setPassword(password);
        System.out.println("Password successfully captured");
    }else{
    System.out.println("Password must be 8+ characters, include a capital letter, number, and special character.");
       // return;
    }
     
   //PhoneNumber
   System.out.print("Enter SA cellphonr number with international code:");
   String phoneNumber=input.nextLine();
     
   if(Login.checkCellPhoneNumber(phoneNumber)){
       Login.setPhoneNumber(phoneNumber);
       System.out.println("Cell phone number successfully added.");
   }else{
      System.out.println("Invalid phone Number formate.");
      return;
   }
   //Login
   System.out.print("Enter username to login:");
   String enteredUsername=input.nextLine();
   
   System.out.print("Enter password to login");
   String enteredPassword=input.nextLine();
   
    if(Login.loginUser(enteredUsername,enteredPassword)){
     System.out.print("Enter your first name");
     String firstName=input.nextLine();
     
     System.out.print("Emter your last name:");
     String lastName=input.nextLine();
     System.out.println("Welcome"+firstName+" "+lastName+" "+" it is great to see you again.");
     
     
     
    }else{
        System.out.println("Username or password is incorrect, please try again.");
    }
   }
}

//https://gemini.google.com/app
class QuickChat {
    static int totalMessagesSent = 0;
    static int messageLimit = 0;
    static int messagesEntered = 0;
    static String[] messages; // store messages

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to QuickChat.");

        // Get message limit
        while (true) {
            try {
                System.out.print("How many messages would you like to enter? ");
                messageLimit = Integer.parseInt(sc.nextLine());
                messages = new String[messageLimit]; // create array
                break;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        OUTER:
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1) Send Message");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Enter your choice (1-3): ");
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> {
                    if (messagesEntered >= messageLimit) {
                        System.out.println("You have already entered the maximum number of messages.");
                    } else {
                        System.out.print("Enter your message: ");
                        String msg = sc.nextLine();
                        
                        messages[messagesEntered] = msg; // store message
                        messagesEntered++;
                        totalMessagesSent++;
                        
                        System.out.println("Message sent!");
                    }
                }
                case "2" -> {
                    if (messagesEntered == 0) {
                        System.out.println("No messages sent yet.");
                    } else {
                        System.out.println("Messages:");
                        for (int i = 0; i < messagesEntered; i++) {
                            System.out.println((i + 1) + ". " + messages[i]);
                        }
                    }
                }
                case "3" -> {
                    break OUTER;
                }
                default -> System.out.println("Invalid choice. Please enter 1-3.");
            }
        }

        System.out.println("Total messages sent: " + totalMessagesSent);
    }
}