/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.util.Random;

/**
 *
 * @author anele
 */
public class Message {
  private final String messageId;
    private static int messageCounter = 0;

    private final String recipient;
    private final String messageText;
    private final String messageHash;

    public Message(String recipient, String messageText) {

        this.messageId = generateMessageId();

        messageCounter++;

        this.recipient = recipient;
        this.messageText = messageText;

        this.messageHash = generateMessageHash();
    }

    // GENERATE MESSAGE ID
    private String generateMessageId() {

        Random rand = new Random();

        long id =10 + (long)(rand.nextDouble() * 10);
               

        return String.valueOf(id);
    }

    // CHECK MESSAGE ID
    public boolean checkMessageID() {

        return messageId.length() <= 10;
    }

    // CHECK RECIPIENT NUMBER
    public boolean checkRecipientCell() {

        return recipient.matches("^\\+27\\d{9}$");
    }

    // VALIDATE MESSAGE LENGTH
    public String validateMessage() {

        if (messageText.length() <= 250) {

            return "Message ready to send.";

        } else {

            int excess =
                    messageText.length() - 250;

            return
                    "Message exceeds 250 characters by "
                    + excess;
        }
    }

    // CREATE MESSAGE HASH
    public String createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return (
                messageId.substring(0, 2)
                + ":"
                + messageCounter
                + ":"
                + firstWord
                + lastWord
        ).toUpperCase();
    }

    // SEND MESSAGE
    public String sentMessage(int option) {

        switch (option) {

            case 1:
                return "Message successfully sent.";

            case 2:
                return "Message disregarded.";

            case 3:
                return "Message successfully stored.";

            default:
                return "Invalid option.";
        }
    }

    // PRINT MESSAGE
    public String printMessages() {

        return
                "\nMessage ID: " + messageId +
                "\nMessage Hash: " + messageHash +
                "\nRecipient: " + recipient +
                "\nMessage: " + messageText;
    }

    // TOTAL MESSAGES
    public static int returnTotalMessages() {

        return messageCounter;
    }

    // GETTERS
    public String getMessageId() {
        return messageId;
    }

    public String getMessageHash() {
        return messageHash;
    }  
    
    public String getRecipient() {
        return recipient;
    }

    public String getMessageText() {
        return messageText;
    }

     public static int getMessageCounter() {
        return messageCounter;
    }

    public String toTextFileFormat() {
        return messageId + "," + messageHash + "," + recipient + "," + messageText;
    }
}
