package Assignment_1;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChatHistory {
    private static final String HISTORY_FILE = "chat_history.ser";
    private List<ChatMessage> messages;
    
    public ChatHistory() {
        messages = new ArrayList<>();
        loadHistory();
    }
    
    public void addMessage(ChatMessage message) {
        messages.add(message);
        saveHistory();
    }
    
    public List<ChatMessage> getMessages() {
        return new ArrayList<>(messages);
    }
    
    public List<ChatMessage> getMessagesByUser(String username) {
        List<ChatMessage> userMessages = new ArrayList<>();
        for (ChatMessage msg : messages) {
            if (msg.getSender().equals(username) || msg.getRecipient().equals(username)) {
                userMessages.add(msg);
            }
        }
        return userMessages;
    }
    
    public void clearHistory() {
        messages.clear();
        saveHistory();
    }
    
    private void saveHistory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(HISTORY_FILE))) {
            oos.writeObject(messages);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving chat history: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    private void loadHistory() {
        File file = new File(HISTORY_FILE);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                messages = (List<ChatMessage>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Error loading chat history: " + e.getMessage());
            }
        }
    }
    
    public String displayHistory() {
        if (messages.isEmpty()) {
            return "No messages in chat history.";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("CHAT HISTORY\n");
        sb.append("============\n\n");
        
        for (ChatMessage msg : messages) {
            sb.append(msg.formatMessage()).append("\n");
        }
        
        return sb.toString();
    }
    
    public String displayUserHistory(String username) {
        List<ChatMessage> userMessages = getMessagesByUser(username);
        
        if (userMessages.isEmpty()) {
            return "No messages found for user: " + username;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("CHAT HISTORY FOR ").append(username.toUpperCase()).append("\n");
        sb.append("================================\n\n");
        
        for (ChatMessage msg : userMessages) {
            sb.append(msg.formatMessage()).append("\n");
        }
        
        return sb.toString();
    }
}