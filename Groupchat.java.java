package Assignment_1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GroupChat {
    private String groupName;
    private List<String> members;
    private List<ChatMessage> groupMessages;
    
    public GroupChat(String groupName) {
        this.groupName = groupName;
        this.members = new ArrayList<>();
        this.groupMessages = new ArrayList<>();
    }
    
    public void addMember(String username) {
        if (!members.contains(username)) {
            members.add(username);
        }
    }
    
    public void removeMember(String username) {
        members.remove(username);
    }
    
    public List<String> getMembers() {
        return new ArrayList<>(members);
    }
    
    public String getGroupName() {
        return groupName;
    }
    
    public void addMessage(ChatMessage message) {
        groupMessages.add(message);
    }
    
    public List<ChatMessage> getGroupMessages() {
        return new ArrayList<>(groupMessages);
    }
    
    public String displayGroupMessages() {
        if (groupMessages.isEmpty()) {
            return "No messages in group " + groupName;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("GROUP: ").append(groupName.toUpperCase()).append("\n");
        sb.append("============\n\n");
        
        for (ChatMessage msg : groupMessages) {
            sb.append(msg.formatMessage()).append("\n");
        }
        
        return sb.toString();
    }
    
    public int getMemberCount() {
        return members.size();
    }
}