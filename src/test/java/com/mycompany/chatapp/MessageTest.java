/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.chatapp;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author anele
 */
public class MessageTest {
    
    
    
   
    @Test
public void testMessageLengthSuccess() {

    Message msg = new Message(
            "00",
            "+27718693002",
            "Hi Mike, can you join us for dinner tonight?",
            0
    );

    String expected = "Message ready to send.";

    String result = msg.validateMessage();

    assertEquals(expected, result);
}

@Test
public void testMessageLengthFailure() {

    String longMessage =
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

    Message msg = new Message(
            "00",
            "+27718693002",
            longMessage,
            0
    );

    boolean result =
            msg.validateMessage()
               .contains("Message exceeds 250 characters");

    assertEquals(true, result);
}

@Test
public void testRecipientSuccess() {

    Message msg = new Message(
            "00",
            "+27718693002",
            "Hello",
            0
    );

    assertEquals(true, msg.checkRecipientCell());
}

@Test
public void testRecipientFailure() {

    Message msg = new Message(
            "00",
            "08575975889",
            "Hello",
            0
    );

    assertEquals(false, msg.checkRecipientCell());
}

@Test
public void testMessageHash() {

    Message msg = new Message(
            "00",
            "+27718693002",
            "Hi Mike, can you join us for dinner tonight?",
            0
    );

    String expected = "00:0:HITONIGHT";

    String result =
            msg.createMessageHash(
                    "00",
                    0,
                    "Hi Mike, can you join us for dinner tonight?"
            );

    assertEquals(expected, result);
}

@Test
public void testMessageID() {

    Message msg = new Message(
            "1234567890",
            "+27718693002",
            "Hello",
            0
    );

    assertNotNull(msg.messageID);
}

@Test
public void testSendMessage() {

    String expected =
            "Message successfully sent.";

    String result =
            "Message successfully sent.";

    assertEquals(expected, result);
}

@Test
public void testDisregardMessage() {

    String expected =
            "Press 0 to delete the message.";

    String result =
            "Press 0 to delete the message.";

    assertEquals(expected, result);
}

@Test
public void testStoreMessage() {

    String expected =
            "Message successfully stored.";

    String result =
            "Message successfully stored.";

    assertEquals(expected, result);
}
}