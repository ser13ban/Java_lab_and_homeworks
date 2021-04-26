package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        Boolean quit = false;
        try (
                Socket socket = new Socket(serverAddress,PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader ( new InputStreamReader(socket.getInputStream()));
                BufferedReader commandIn = new BufferedReader( new InputStreamReader(System.in));
            )
            {
                while(!quit) {
                    System.out.println(
                                "Hi user, you can type one of the following commands:\n" +
                                "register <name> -- will add this name to the social network\n" +
                                "login <name>    -- an connection will be established with the server\n" +
                                "friend <name1> <name2> ... -- will add all of the names to your firnds list\n" +
                                "send <message>  -- will send a message to all of your friends\n" +
                                "read -- reads the messages from the server\n" +
                                "exit -- ends the connection with the server and closes the application\n\n"
                            );
                    String command = commandIn.readLine();
                    String[] commandSplit = command.split(" ");
                    String request = commandSplit[0];

                    switch (commandSplit[0]){
                        case "register":
                            request =request+" " + commandSplit[1];
                            break;
                        case "login":
                            request =request+" " + commandSplit[1];
                            break;
                        case "freind":
                            request =request+" " + commandSplit[1];
                            break;
                        case "send":
                            request =request+" " + commandSplit[1];
                            break;
                        case "read":
                            request =request+" " + commandSplit[1];
                            break;
                        case "exit":
                            quit = true;
                            break;
                        default:
                            System.out.println("This is not a recognized command");
                    }



                    out.println(request);

                    String response = in.readLine();
                    System.out.println(response);

                }
            }catch (UnknownHostException e){
            System.err.println("Oops, no server is listening... " + e);
        }
    }
}
