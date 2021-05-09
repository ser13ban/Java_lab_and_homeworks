package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread {
    private Socket socket = null;
    private Boolean quit = false;
    private ArrayList<User> users;
    public ClientThread (Socket socket, ArrayList<User> users) { this.socket = socket ; this.users = users;}
    public void getHTML(){
        // I think this is where I want to obtain the html doc for my users.
    }
    public void run(){
        try {
            String currentUserName="";
            String response="";
            while (!quit){
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                String[] requestSplit = request.split(" ");

                switch (requestSplit[0]){
                    case "exit":
                        quit = true;
                        response= "The connection with the server was closed";
                        PrintWriter exitOut = new PrintWriter(socket.getOutputStream());
                        exitOut.println(response);
                        try {
                            socket.close();
                        }catch (IOException e){
                            System.err.println(e);
                        }
                        break;
                    case "register":
                        Boolean ok=true;
                        for (User u: this.users
                        ) {
                            if (u.getName().equals(requestSplit[1])){
                                ok = false;
                            }
                        }
                        if (!ok){
                            response = "I'm sorry, this username already exists";
                        }else{
                            User newUser = new User(requestSplit[1]);
                            this.users.add(newUser);
                            response = "Registration completed succesfully, the user " + newUser.getName() +" was created!";
                        }
                        break;
                    case "login":
                        response="We don't have this user";
                        for (User u: this.users
                             ) {
                            if (u.getName().equals(requestSplit[1])){
                                response+=("\t\t\t"+u.getName());
                                currentUserName = u.getName();
                                response = "Welcome "+ currentUserName + ", you are now logged in!\n";
                            }
                        }
                        break;
                    case "friend":
                        if (currentUserName.equals("")){
                            response="please log in or register";
                        }else{
                            for (User u: users
                                 ) {
                                if (u.getName().equals(currentUserName)){
                                    //we add all of the friends to his freinds list
                                    List friends = new ArrayList<String>();
                                    for (int i = 1; i < requestSplit.length; i++) {
                                        friends.add(requestSplit[i]);
                                    }
                                    u.setFriends(friends);
                                    response = "We have added"+ u.getFriends().toString() +"to your friends list";
                                }
                            }
                        }
                        break;
                    case "send":
                        if (currentUserName.equals("")){
                            response="please log in or register";
                        }else{
                            String message="";
                            for (int i = 1; i < requestSplit.length; i++) {
                                message+=(requestSplit[i]+" ");
                            }
                            for (User u: this.users
                            ) {
                                //we need to seend the messages only to the friends
                                if (u.isFriend(currentUserName)){
                                    u.addMessage(currentUserName,message);
                                }
                            }
                            response = "The message was sent!";
                        }
                        break;
                    case "read":
                        if (currentUserName.equals("")){
                            response="please log in or register";
                        }else{
                            for (User u: this.users
                                 ) {
                                if (u.getName() == currentUserName){
                                    response = u.readMessage();
                                }
                            }
                        }
                        break;
                }

                //sending the response to the cilent
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                out.println(response);
                out.flush();
            }

        }catch (IOException e){
            System.err.println("Comunication error... " + e);
        }
    }
}
