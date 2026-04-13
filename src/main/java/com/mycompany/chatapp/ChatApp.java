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
        
        System.out.print("Enter firstname:");
       String firstname=input.nextLine();
        
       System.out.print("Enter lastname:");
       String lastname=input.nextLine();
        //username
        while(true){//https://chatgpt.com/
        System.out.print("Enter username:");
       String UserName=input.nextLine();
        if(Login.checkUserName(UserName)){
            System.out.println("Username successful captured.");
            break; //https://chatgpt.com/
        }else{
           System.out.println("Username must contain'_'and be no more than 5 characters.");
          
        }
        //password
        while(true){//https://chatgpt.com/
        System.out.print("Enter your password:");
        String password=input.nextLine();
        
        if(Login.checkPasswordComplexity(password)){
        Login.setPassword(password);
        System.out.println("Password successfully captured");
        break;// https://chatgpt.com/
    }else{
    System.out.println("Password must be 8+ characters, include a capital letter, number, and special character.");
      
    }
        
     
   //PhoneNumber
   while(true){//https://chatgpt.com/
   System.out.print("Enter SA cellphonr number with international code:");
   String phoneNumber=input.nextLine();
     
   if(Login.checkCellPhoneNumber(phoneNumber)){
       Login.setPhoneNumber(phoneNumber);
       System.out.println("Cell phone number successfully added.");
       break;//https://chatgpt.com/
   }else{
      System.out.println("Invalid phone Number formate.");
      

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


//class QuickChat {
    
        }
    }
}

    