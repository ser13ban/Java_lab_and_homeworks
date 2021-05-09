package com.company;

import java.util.*;

public class User {
    private String name;
    private List friends = new ArrayList<String>();
    private Hashtable<String,String> messages = new Hashtable<String,String>();

    public void setName(String name) {
        this.name = name;
    }

    public List getFriends() {
        return friends;
    }

    public void setFriends(List friends) {
        this.friends = friends;
    }

    public Hashtable<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Hashtable<String, String> messages) {
        this.messages = messages;
    }

    public User(String name){
        this.name = name;
        this.friends = new ArrayList<String>();
        this.messages = new Hashtable<String,String>();
    }

    public String getName() {
        return name;
    }

    public void addMessage(String username, String message){
        this.messages.put(username,message);
    }

    public String readMessage(){
        String response="";
        //this.messages.forEach((username,message) -> response+="Message from user: " + username +"is: " + message + "\n");
        Iterator it = messages.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            response+=("Message from user: " + pair.getKey() +"is: " + pair.getValue() + "\n");
            it.remove(); // avoids a ConcurrentModificationException
        }
        return response;
    }
    public Boolean isFriend(String name){
        for (var s: friends
             ) {
            if (s.equals(name))
                return true;
        }
        return false;
    }
}
