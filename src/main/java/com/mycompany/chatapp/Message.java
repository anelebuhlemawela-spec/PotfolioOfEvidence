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
public class Message {

    
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

    // CHECK RECIPIENT
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

    // SEND OPTION
    public String sendMessageOption() {

        Scanner input = new Scanner(System.in);

        System.out.println("\nChoose Action");
        System.out.println("1. Send");
        System.out.println("2. Discard");
        System.out.println("3. Store");

        System.out.print("Enter choice: ");

        int choice =
                Integer.parseInt(
                        input.nextLine()
                );

        switch (choice) {

            case 1:
                status = "Sent";
                break;

            case 2:
                status = "Discarded";
                break;

            case 3:
                status = "Stored";
                break;

            default:
                status = "Invalid";
        }

        return status;
    }

    // DISPLAY
    public String display() {

        return "MessageID: "
                + messageID
                + "\nHash: "
                + hash
                + "\nTo: "
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
                + message.replace("\"", "'")
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

    String validateMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String validateMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String validateMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String validateMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String LengthSuccess() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String LengthSuccess() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object validateMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    Object validateMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}