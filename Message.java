package Assignment_1;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Message {
    private static int totalMessages = 0;
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String message;
    private String messageHash;

    // Constructor
    public Message(int messageNumber, String recipient, String message) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    // Generate random ID
    private String generateMessageID() {
        Random random = new Random();
        long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);
        return String.valueOf(number);
    }

    // Check message ID
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }

    // Check recipient
    public String checkRecipientCell() {
        if (recipient != null && recipient.length() <= 12 && recipient.startsWith("+27")) {
            String cleaned = recipient.replaceAll("\\s+", "");
            if (cleaned.length() >= 10 && cleaned.length() <= 12) {
                return "Cell phone number successfully captured.";
            }
        }
        return "Cell phone number incorrectly formatted or does not contain international code.";
    }

    // Create hash
    public String createMessageHash() {
        if (message == null || message.trim().isEmpty()) {
            return (messageID.substring(0, 2) + ":" + messageNumber + ":EMPTY").toUpperCase();
        }
        
        String[] words = message.split(" ");
        if (words.length == 0) {
            return (messageID.substring(0, 2) + ":" + messageNumber + ":EMPTY").toUpperCase();
        }
        
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        return (messageID.substring(0, 2) + ":" + messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }

    // Send message
    public String sentMessage() {
        String[] options = {"Send Message", "Disregard Message", "Store Message"};
        
        int choice = JOptionPane.showOptionDialog(
                null,
                "Choose an option",
                "Message Options",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );
        
        switch (choice) {
            case 0:
                totalMessages++;
                return "Message successfully sent.";
            case 1:
                return "Message disregarded.";
            case 2:
                storeMessage();
                return "Message successfully stored.";
            default:
                return "No option selected.";
        }
    }

    // Print message
    public String printMessages() {
        return "Message ID: " + messageID +
               "\nMessage Hash: " + messageHash +
               "\nRecipient: " + recipient +
               "\nMessage: " + message;
    }

    // Return total messages
    public static int returnTotalMessages() {
        return totalMessages;
    }
    
    public static void resetTotalMessages() {
        totalMessages = 0;
    }

    // Store JSON
    public void storeMessage() {
        try {
            FileWriter writer = new FileWriter("storedMessages.json", true);
            writer.write("{\n");
            writer.write("\"MessageID\":\"" + messageID + "\",\n");
            writer.write("\"MessageHash\":\"" + messageHash + "\",\n");
            writer.write("\"Recipient\":\"" + recipient + "\",\n");
            writer.write("\"Message\":\"" + message + "\"\n");
            writer.write("}\n");
            writer.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error storing message: " + e.getMessage());
        }
    }
}