package Assignment_1;

import javax.swing.*;

public class ChatApplication {
    private static Login loginManager;
    private static ChatHistory chatHistory;
    private static List<GroupChat> groupChats;
    private static String currentUser;
    private static String currentFirstName;
    private static String currentLastName;
    
    public static void main(String[] args) {
        loginManager = new Login();
        chatHistory = new ChatHistory();
        groupChats = new ArrayList<>();
        
        boolean registered = false;
        boolean loggedIn = false;
        
        // Registration and Login combined process
        while (!registered || !loggedIn) {
            int mainChoice = Integer.parseInt(JOptionPane.showInputDialog(
                "CHAT APPLICATION MENU\n" +
                "====================\n\n" +
                "1) New User Registration\n" +
                "2) Existing User Login\n" +
                "3) Exit\n\n" +
                "Enter your choice:"
            ));
            
            if (mainChoice == 1) {
                registered = registrationProcess();
                if (registered) {
                    JOptionPane.showMessageDialog(null, "Registration successful! Please login.");
                }
            } else if (mainChoice == 2) {
                loggedIn = loginProcess();
                if (loggedIn) {
                    showMainChatMenu();
                }
            } else if (mainChoice == 3) {
                JOptionPane.showMessageDialog(null, "Goodbye!");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }
    
    private static boolean registrationProcess() {
        String firstName = JOptionPane.showInputDialog(null, "Enter First Name:", "REGISTRATION", JOptionPane.INFORMATION_MESSAGE);
        String lastName = JOptionPane.showInputDialog(null, "Enter Last Name:", "REGISTRATION", JOptionPane.INFORMATION_MESSAGE);
        String username = JOptionPane.showInputDialog(null, "Enter Username (must contain _ and be <=5 chars):", "REGISTRATION", JOptionPane.INFORMATION_MESSAGE);
        String password = JOptionPane.showInputDialog(null, "Enter Password (min 8 chars, 1 capital, 1 number, 1 special):", "REGISTRATION", JOptionPane.INFORMATION_MESSAGE);
        String phone = JOptionPane.showInputDialog(null, "Enter Phone Number (+27xxxxxxxxx):", "REGISTRATION", JOptionPane.INFORMATION_MESSAGE);
        
        boolean validUsername = loginManager.checkUserName(username);
        boolean validPassword = loginManager.checkPasswordComplexity(password);
        boolean validPhone = loginManager.checkCellPhoneNumber(phone);
        
        String result = "";
        
        if (validUsername) {
            result += "Username successfully captured.\n";
        } else {
            result += "Username incorrectly formatted.\n";
        }
        
        if (validPassword) {
            result += "Password successfully captured.\n";
        } else {
            result += "Password incorrectly formatted.\n";
        }
        
        if (validPhone) {
            result += "Phone number successfully captured.\n";
        } else {
            result += "Phone number incorrectly formatted.\n";
        }
        
        JOptionPane.showMessageDialog(null, result);
        
        if (validUsername && validPassword && validPhone) {
            String registrationResult = loginManager.registerUser(username, password, phone, firstName, lastName);
            JOptionPane.showMessageDialog(null, registrationResult);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Registration failed.");
            return false;
        }
    }
    
    private static boolean loginProcess() {
        String enteredUsername = JOptionPane.showInputDialog(null, "Enter Username:", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
        String enteredPassword = JOptionPane.showInputDialog(null, "Enter Password:", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
        
        boolean loginStatus = loginManager.loginUser(
            loginManager.getStoredUsername(),
            loginManager.getStoredPassword(),
            enteredUsername,
            enteredPassword
        );
        
        String message = loginManager.returnLoginStatus(loginStatus, "User", "User");
        JOptionPane.showMessageDialog(null, message);
        
        if (loginStatus) {
            currentUser = enteredUsername;
            currentFirstName = "User";
            currentLastName = "";
            return true;
        }
        
        return false;
    }
    
    private static void showMainChatMenu() {
        boolean running = true;
        
        while (running) {
            String menu = "CHAT APPLICATION - Welcome " + currentUser + "\n" +
                         "================================\n\n" +
                         "1) Send Private Message\n" +
                         "2) Group Chat\n" +
                         "3) View Stored Messages\n" +
                         "4) View Chat History\n" +
                         "5) Clear History\n" +
                         "6) Create Group\n" +
                         "7) Join Group\n" +
                         "8) About\n" +
                         "9) Logout\n" +
                         "10) Quit\n\n" +
                         "Enter your choice:";
            
            int choice;
            try {
                choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                continue;
            }
            
            switch (choice) {
                case 1:
                    sendPrivateMessage();
                    break;
                case 2:
                    groupChatMenu();
                    break;
                case 3:
                    viewStoredMessages();
                    break;
                case 4:
                    viewChatHistory();
                    break;
                case 5:
                    clearHistory();
                    break;
                case 6:
                    createGroup();
                    break;
                case 7:
                    joinGroup();
                    break;
                case 8:
                    showAbout();
                    break;
                case 9:
                    running = false;
                    JOptionPane.showMessageDialog(null, "Logged out successfully.");
                    break;
                case 10:
                    JOptionPane.showMessageDialog(null, "Goodbye!");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }
    
    private static void sendPrivateMessage() {
        String recipient = JOptionPane.showInputDialog("Enter recipient username:");
        String messageText = JOptionPane.showInputDialog("Enter your message:");
        
        if (messageText != null && messageText.length() > 0) {
            if (messageText.length() > 500) {
                JOptionPane.showMessageDialog(null, "Message too long. Maximum 500 characters.");
                return;
            }
            
            ChatMessage message = new ChatMessage(currentUser, recipient, messageText);
            chatHistory.addMessage(message);
            
            // Also store as regular message
            Message msg = new Message(Message.returnTotalMessages() + 1, recipient, messageText);
            JOptionPane.showMessageDialog(null, "Message sent!\n" + msg.printMessages());
        }
    }
    
    private static void groupChatMenu() {
        if (groupChats.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No groups available. Create a group first.");
            return;
        }
        
        String[] groupNames = new String[groupChats.size()];
        for (int i = 0; i < groupChats.size(); i++) {
            groupNames[i] = groupChats.get(i).getGroupName();
        }
        
        String selectedGroup = (String) JOptionPane.showInputDialog(
            null,
            "Select a group:",
            "Group Chat",
            JOptionPane.QUESTION_MESSAGE,
            null,
            groupNames,
            groupNames[0]
        );
        
        if (selectedGroup != null) {
            for (GroupChat group : groupChats) {
                if (group.getGroupName().equals(selectedGroup)) {
                    if (!group.getMembers().contains(currentUser)) {
                        JOptionPane.showMessageDialog(null, "You are not a member of this group.");
                        return;
                    }
                    
                    String messageText = JOptionPane.showInputDialog("Enter group message:");
                    if (messageText != null && messageText.length() > 0) {
                        ChatMessage message = new ChatMessage(currentUser, selectedGroup, messageText, "GROUP");
                        group.addMessage(message);
                        chatHistory.addMessage(message);
                        JOptionPane.showMessageDialog(null, "Group message sent to " + selectedGroup);
                    }
                    
                    // Option to view group messages
                    int viewChoice = JOptionPane.showConfirmDialog(null, "View group messages?", "Group Chat", JOptionPane.YES_NO_OPTION);
                    if (viewChoice == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, group.displayGroupMessages());
                    }
                    break;
                }
            }
        }
    }
    
    private static void viewStoredMessages() {
        try {
            java.io.File file = new java.io.File("storedMessages.json");
            if (file.exists()) {
                java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file));
                StringBuilder content = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
                JOptionPane.showMessageDialog(null, "STORED MESSAGES:\n\n" + content.toString());
            } else {
                JOptionPane.showMessageDialog(null, "No stored messages found.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error reading stored messages: " + e.getMessage());
        }
    }
    
    private static void viewChatHistory() {
        String history = chatHistory.displayUserHistory(currentUser);
        JOptionPane.showMessageDialog(null, history);
    }
    
    private static void clearHistory() {
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to clear all chat history?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            chatHistory.clearHistory();
            JOptionPane.showMessageDialog(null, "Chat history cleared.");
        }
    }
    
    private static void createGroup() {
        String groupName = JOptionPane.showInputDialog("Enter group name:");
        if (groupName != null && groupName.length() > 0) {
            GroupChat newGroup = new GroupChat(groupName);
            newGroup.addMember(currentUser);
            groupChats.add(newGroup);
            JOptionPane.showMessageDialog(null, "Group '" + groupName + "' created successfully!");
        }
    }
    
    private static void joinGroup() {
        if (groupChats.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No groups available to join.");
            return;
        }
        
        String[] groupNames = new String[groupChats.size()];
        for (int i = 0; i < groupChats.size(); i++) {
            groupNames[i] = groupChats.get(i).getGroupName();
        }
        
        String selectedGroup = (String) JOptionPane.showInputDialog(
            null,
            "Select a group to join:",
            "Join Group",
            JOptionPane.QUESTION_MESSAGE,
            null,
            groupNames,
            groupNames[0]
        );
        
        if (selectedGroup != null) {
            for (GroupChat group : groupChats) {
                if (group.getGroupName().equals(selectedGroup)) {
                    group.addMember(currentUser);
                    JOptionPane.showMessageDialog(null, "You have joined '" + selectedGroup + "'!");
                    break;
                }
            }
        }
    }
    
    private static void showAbout() {
        String about = "CHAT APPLICATION\n" +
                      "================\n\n" +
                      "Version: 1.0\n" +
                      "Developer: Assignment 1 Team\n\n" +
                      "Features:\n" +
                      "- User Registration and Login\n" +
                      "- Private Messaging\n" +
                      "- Group Chat\n" +
                      "- Message Storage (JSON format)\n" +
                      "- Chat History Tracking\n" +
                      "- Message Validation\n\n" +
                      "Requirements:\n" +
                      "- Username: contains '_' and max 5 characters\n" +
                      "- Password: min 8 chars, 1 uppercase, 1 number, 1 special char\n" +
                      "- Phone: +27 followed by 9-10 digits\n" +
                      "- Message: max 250 characters for standard messages";
        
        JOptionPane.showMessageDialog(null, about);
    }
}