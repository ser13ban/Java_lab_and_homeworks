package com.company;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public final static int PORT = 8100;
    public Server() throws IOException {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                 new ClientThread(socket).start();
            }
        }catch (IOException e){
            System.err.println("Something went wrong... " + e);
        }finally {
            serverSocket.close();
        }
    }
}
