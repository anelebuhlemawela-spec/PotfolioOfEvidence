/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MessageManager {

    private final ArrayList<Message> sent = new ArrayList<>();
    private final ArrayList<Message> discarded = new ArrayList<>();
    private final ArrayList<Message> stored = new ArrayList<>();

    private int total = 0;

    private final Scanner scanner = new Scanner(System.in);

    // SEND MESSAGES
    public void sendMessages(int count) {

        for (int i = 0; i < count; i++) {

            System.out.println("\n==============================");
            System.out.println("Message " + (i + 1));
            System.out.println("==============================");

            String id =
                    String.valueOf(
                            (long) (Math.random()
                            * 10000000000L));

            System.out.print(
                    "Enter recipient number: ");

            String recipient =
                    scanner.nextLine();

            System.out.print(
                    "Enter message (max 250 characters): ");

            String msg =
                    scanner.nextLine();

            if (msg.length() > 250) {

                System.out.println(
                        "Message exceeds 250 characters by "
                        + (msg.length() - 250));

                i--;
                continue;
            }

            Message message =
                    new Message(
                            id,
                            recipient,
                            msg,
                            total + 1);

            if (!message.checkRecipientCell()) {

                System.out.println(
                        "Cell phone number incorrectly formatted.");

                i--;
                continue;
            }

            String status =
                    message.sendMessageOption();

            switch (status) {

                case "Sent":

                    sent.add(message);
                    total++;

                    System.out.println(
                            "\nMessage successfully sent.");

                    break;

                case "Discarded":

                    discarded.add(message);

                    System.out.println(
                            "\nMessage discarded.");

                    break;

                case "Stored":

                    stored.add(message);

                    System.out.println(
                            "\nMessage stored.");

                    break;
            }

            System.out.println(
                    "\n" + message.display());
        }
    }

    // TOTAL SENT
    public int returnTotalMessages() {

        return total;
    }

    // SAVE STORED MESSAGES
    public void saveStoredMessages() {

        try (PrintWriter writer =
                new PrintWriter(
                        new FileWriter(
                                "storedMessages.json"))) {

            for (Message m : stored) {

                writer.println(
                        m.toJson());
            }

            System.out.println(
                    "Stored messages saved.");

        } catch (IOException e) {

            System.out.println(
                    "Failed to save messages.");
        }
    }

    // LOAD STORED MESSAGES
    public void loadStoredMessages() {

        try (BufferedReader reader =
                new BufferedReader(
                        new FileReader(
                                "storedMessages.json"))) {

            String line;

            while ((line =
                    reader.readLine()) != null) {

                stored.add(
                        Message.fromJson(line));
            }

        } catch (IOException e) {

            // File may not exist on first run
        }
    }

    // DISPLAY SENT
    public void displaySentMessages() {

        System.out.println(
                "\n===== SENT MESSAGES =====");

        if (sent.isEmpty()) {

            System.out.println(
                    "No sent messages.");

            return;
        }

        for (Message m : sent) {

            System.out.println(
                    m.display());

            System.out.println(
                    "--------------------");
        }
    }

    // DISPLAY DISCARDED
    public void displayDiscardedMessages() {

        System.out.println(
                "\n===== DISCARDED MESSAGES =====");

        if (discarded.isEmpty()) {

            System.out.println(
                    "No discarded messages.");

            return;
        }

        for (Message m : discarded) {

            System.out.println(
                    m.display());

            System.out.println(
                    "--------------------");
        }
    }

    // DISPLAY STORED
    public void displayStoredMessages() {

        System.out.println(
                "\n===== STORED MESSAGES =====");

        if (stored.isEmpty()) {

            System.out.println(
                    "No stored messages.");

            return;
        }

        for (Message m : stored) {

            System.out.println(
                    m.display());

            System.out.println(
                    "--------------------");
        }
    }

    // LONGEST MESSAGE
    public void findLongestMessage() {

        Message longest = null;
        int maxLength = 0;

        ArrayList<Message> allMessages =
                new ArrayList<>();

        allMessages.addAll(sent);
        allMessages.addAll(discarded);
        allMessages.addAll(stored);

        for (Message m : allMessages) {

            if (m.getMessage().length()
                    > maxLength) {

                longest = m;
                maxLength =
                        m.getMessage().length();
            }
        }

        if (longest != null) {

            System.out.println(
                    "\n===== LONGEST MESSAGE =====");

            System.out.println(
                    longest.display());

        } else {

            System.out.println(
                    "No messages found.");
        }
    }

    // SEARCH BY RECIPIENT
    public void searchMessagesByRecipient() {

        System.out.print(
                "\nEnter recipient number: ");

        String target =
                scanner.nextLine();

        boolean found = false;

        for (Message m : sent) {

            if (m.getRecipient()
                    .equals(target)) {

                System.out.println(
                        "\n" + m.display());

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No messages found.");
        }
    }

    // DELETE BY HASH
    public void deleteMessageByHash(String whereasked) {

        System.out.print(
                "\nEnter hash to delete: ");

        String targetHash =
                scanner.nextLine();

        Iterator<Message> iterator =
                sent.iterator();

        boolean found = false;

        while (iterator.hasNext()) {

            Message m =
                    iterator.next();

            if (m.getHash()
                    .equals(targetHash)) {

                iterator.remove();

                total--;

                found = true;

                System.out.println(
                        "Message deleted successfully.");

                break;
            }
        }

        if (!found) {

            System.out.println(
                    "Message hash not found.");
        }
    }

    // MESSAGE REPORT
    public void displayMessageReport() {

        System.out.println(
                "\n===== MESSAGE REPORT =====");

        if (sent.isEmpty()) {

            System.out.println(
                    "No sent messages.");

            return;
        }

        for (Message m : sent) {

            System.out.println(
                    m.messageReport());

            System.out.println(
                    "--------------------");
        }
    }

    Object findLongestStoredMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}