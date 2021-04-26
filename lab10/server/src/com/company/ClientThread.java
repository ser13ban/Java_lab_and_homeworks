package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private Boolean quit = false;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run(){
        try {
            while (!quit){
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                //proccessing the user input

                if (request == "exit"){
                    quit = true;
                    try {
                        socket.close();
                    }catch (IOException e){
                        System.err.println(e);
                    }
                }

                //sending the response to the cilent
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns = "The server recieved the command " + request + "!";
                out.println(raspuns);
                out.flush();
            }

        }catch (IOException e){
            System.err.println("Comunication error... " + e);
        }
    }
}
