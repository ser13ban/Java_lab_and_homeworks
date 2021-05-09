package com.company;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public final static int PORT = 8100;
    public volatile ArrayList<User> users = new ArrayList<User>();
    public void getHTMLDoc(){
        for (User u: users
             ) {
            System.out.println(u.getName()+"\t,");
        }
    }
    public Server() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                //seting the timeout for the new connections
                socket.setSoTimeout(180000);
                // Execute the client's request in a new thread
                new ClientThread(socket, users).start();
            }
        } catch (IOException e) {
            System.err.println("Something went wrong... " + e);
        }
    }
}
