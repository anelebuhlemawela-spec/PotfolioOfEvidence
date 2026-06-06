/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author anele
 */
public class MessageManager {
   
      
}



    private ArrayList<Message> sentMessages;
    private ArrayList<Message> storedMessages;
    private ArrayList<Message> disregardedMessages;

    private int totalMessagesSent;

    public MessageManager() {

        sentMessages = new ArrayList<>();
        storedMessages = new ArrayList<>();
        disregardedMessages = new ArrayList<>();

        totalMessagesSent = 0;

        loadStoredMessages();
    }

    // ==========================
    // ADD MESSAGE
    // ==========================

    public void addMessage(Message message) {

        String status = message.getStatus();

        if (status.equals("Sent")) {

            sentMessages.add(message);
            totalMessagesSent++;

        } else if (status.equals("Stored")) {

            storedMessages.add(message);
            saveStoredMessage(message);

        } else {

            disregardedMessages.add(message);
        }
    }

    public int getTotalMessagesSent() {

        return totalMessagesSent;
    }

   
    private void saveStoredMessage(
            Message message) {

        try {

            FileWriter writer =
                    new FileWriter(
                            "storedMessages.json",
                            true);

            writer.write(
                    message.toJson());

            writer.write(
                    System.lineSeparator());

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error saving message.");
        }
    }

   

    public void loadStoredMessages() {

        File file =
                new File(
                        "storedMessages.json");

        if (!file.exists()) {
            return;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file));

            String line;

            while ((line =
                    reader.readLine()) != null) {

                storedMessages.add(
                        Message.fromJson(line));
            }

            reader.close();

        } catch (IOException e) {

            System.out.println(
                    "Error loading messages.");
        }
    }

    // ==========================
    // DISPLAY SENT
    // ==========================

    public void displaySentMessages() {

        if (sentMessages.isEmpty()) {

            System.out.println(
                    "No sent messages.");

            return;
        }

        for (Message msg :
                sentMessages) {

            System.out.println(
                    msg.display());

            System.out.println(
                    "--------------------");
        }
    }

   

    public void displayStoredMessages() {

        if (storedMessages.isEmpty()) {

            System.out.println(
                    "No stored messages.");

            return;
        }

        for (Message msg :
                storedMessages) {

            System.out.println(
                    msg.display());

            System.out.println(
                    "--------------------");
        }
    }


    public void displayDisregardedMessages() {

        if (disregardedMessages.isEmpty()) {

            System.out.println(
                    "No disregarded messages.");

            return;
        }

        for (Message msg :
                disregardedMessages) {

            System.out.println(
                    msg.display());

            System.out.println(
                    "--------------------");
        }
    }

   
    public void displayLongestMessage() {

        if (storedMessages.isEmpty()) {

            System.out.println(
                    "No stored messages.");

            return;
        }

        Message longest =
                storedMessages.get(0);

        for (Message msg :
                storedMessages) {

            if (msg.getMessage().length()
                    > longest.getMessage().length()) {

                longest = msg;
            }
        }

        System.out.println(
                "\nLongest Message:");

        System.out.println(
                longest.getMessage());
    }


    public void searchMessageID(
            String id) {

        for (Message msg :
                storedMessages) {

            if (msg.getMessageID()
                    .equals(id)) {

                System.out.println(
                        "\nRecipient: "
                                + msg.getRecipient());

                System.out.println(
                        "Message: "
                                + msg.getMessage());

                return;
            }
        }

        System.out.println(
                "Message ID not found.");
    }

 

    public void searchRecipient(
            String recipient) {

        boolean found = false;

        for (Message msg :
                storedMessages) {

            if (msg.getRecipient()
                    .equals(recipient)) {

                System.out.println(
                        msg.getMessage());

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No messages found.");
        }
    }

   

    public void deleteMessageByHash(
            String hash) {

        Iterator<Message> iterator =
                storedMessages.iterator();

        while (iterator.hasNext()) {

            Message msg =
                    iterator.next();

            if (msg.getHash()
                    .equals(hash)) {

                iterator.remove();

                System.out.println(
                        "Message deleted successfully.");

                return;
            }
        }

        System.out.println(
                "Hash not found.");
    }

    

    public void displayReport() {

        if (sentMessages.isEmpty()) {

            System.out.println(
                    "No sent messages.");

            return;
        }

        System.out.println(
                "\n===== MESSAGE REPORT =====");

        for (Message msg :
                sentMessages) {

            System.out.println(
                    msg.messageReport());

            System.out.println(
                    "--------------------");
        }
    }

    

    public ArrayList<Message>
    getSentMessages() {

        return sentMessages;
    }

    public ArrayList<Message>
    getStoredMessages() {

        return storedMessages;
    }

    public ArrayList<Message>
    getDisregardedMessages() {

        return disregardedMessages;
    }
