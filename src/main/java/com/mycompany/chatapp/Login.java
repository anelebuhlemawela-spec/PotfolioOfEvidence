/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

/**
 *
 * @author anele
 */
public class Login {
        private String firstname;
        private String lastname;
        private String username;
         private String password;
          private String phoneNumber;
     
          // Setter
       public void setUsername(String username){  
           this.username=username;
       }
           public void setPassword(String password){  
           this.password=password;
            } 
           public void setPhoneNumber(String phoneNumber){  
           this.phoneNumber=phoneNumber;
    }
    //getters
           public String getUsername(){
               return username;
           }
            public String getPassword(){
               return password;
            }
    public String getPhoneNumber(){
               return phoneNumber;  
    }
    //Check methods
    public boolean checkUserName(String username){
        return username.contains("_")&& username.length() <=5;
       }
    // https://gemini.google.com/app
   public boolean checkPasswordComplexity(String password){
      return password.length() >= 8 &&
               password.matches(".[A-Z].") &&
               password.matches(".[0-9].") &&
               password.matches(".[!@#$%^&(),.?\":{}|<>].*");
                
    }
   public boolean checkCellPhoneNumber(String phone) {
    return phone.matches("^\\+27[0-9]{9}$");
}
  
   
   // https://chatgpt.com/c/69c50866-03ac-832e-bfc0-763964dab793
   
   public boolean loginUser(String enteredUsername, String enteredPassword) {
    return enteredUsername != null && enteredPassword != null &&
           enteredUsername.equals(this.username) &&
           enteredPassword.equals(this.password);
}
public String returnLoginStatus(String username, String password) {
    if (loginUser(username, password)) {
        return "Login successful,Welcome";
    } else {
        return "Username or password incorrect, please try again.";
    }
}
    }


