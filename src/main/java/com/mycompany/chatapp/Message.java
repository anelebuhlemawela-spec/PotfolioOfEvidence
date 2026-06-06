/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author anele
 */
class Message {

    String messageID;
    String recipient;
    String message;
    String hash;
    String status;


    
     public Message(
            String messageID,
            String recipient,
            String message,
            int messageNum
    ) {

        this.messageID = messageID;
        this.recipient = recipient;
        this.message = message;

        this.hash =
                createMessageHash(
                        messageID,
                        messageNum,
                        message
                );
    }
     public String getMessageID() {
    return messageID;
}

public String getRecipient() {
    return recipient;
}

public String getMessage() {
    return message;
}

public String getHash() {
    return hash;
}

public String getStatus() {
    return status;
}

    // VALIDATE MESSAGE
    public String validateMessage() {

        if (message.length() <= 250) {

            return "Message ready to send.";

        } else {

            return "Message exceeds 250 characters by "
                    + (message.length() - 250)
                    + ", please reduce size.";
        }
    }

    // CHECK RECIPIENT NUMBER
    public boolean checkRecipientCell() {

        return recipient.matches("\\+27\\d{9}");
    }

    // CREATE HASH
    public String createMessageHash(
            String id,
            int num,
            String msg
    ) {

        String[] words =
                msg.trim().split(" ");

        String first =
                words[0].toUpperCase();

        String last =
                words[words.length - 1]
                        .toUpperCase();

        return id.substring(0, 2)
                + ":"
                + num
                + ":"
                + first
                + last;
    }

    // SEND MESSAGE OPTION
    public String sendMessageOption() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nChoose Action");
        System.out.println("1. Send");
        System.out.println("2. Discard");
        System.out.println("3. Store");
        System.out.println("4. Report");

        System.out.print("Enter choice: ");

        int choice =
                Integer.parseInt(
                        input.nextLine()
                );

        switch (choice) {

            case 1:
                status = "Message successfully sent.";
                break;

            case 2:
                status = "Message disregarded.";
                break;

            case 3:
                status = "Message successfully stored.";
                break;

            default:
                status = "Invalid option.";
        }

        return status;
    }

    // DISPLAY MESSAGE
    public String display() {

        return "\nMessage ID: "
                + messageID
                + "\nMessage Hash: "
                + hash
                + "\nRecipient: "
                + recipient
                + "\nMessage: "
                + message
                + "\nStatus: "
                + status;
    }

    // JSON FORMAT
    public String toJson() {

        return "{"
                + "\"messageID\":\""
                + messageID
                + "\","
                + "\"recipient\":\""
                + recipient
                + "\","
                + "\"message\":\""
                + message
                + "\","
                + "\"hash\":\""
                + hash
                + "\","
                + "\"status\":\""
                + status
                + "\"}";
    }

    // FROM JSON
    public static Message fromJson(String json) {

        String[] parts =
                json.replace("{", "")
                        .replace("}", "")
                        .split(",\\s*");

        Map<String, String> map =
                new HashMap<>();

        for (String part : parts) {

            String[] kv =
                    part.split(":");

            String key =
                    kv[0]
                            .replace("\"", "")
                            .trim();

            String val =
                    kv[1]
                            .replace("\"", "")
                            .trim();

            map.put(key, val);
        }

        Message m =
                new Message(
                        map.get("messageID"),
                        map.get("recipient"),
                        map.get("message"),
                        0
                );

        m.hash = map.get("hash");
        m.status = map.get("status");

        return m;
    }

    String getStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getMessageID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getRecipient() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object getHash() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean messageReport() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
