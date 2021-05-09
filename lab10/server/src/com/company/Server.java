package com.company;


import org.jgrapht.graph.DefaultEdge;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

//imports for generating the html document
import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.nio.*;
import org.jgrapht.nio.dot.*;
import org.jgrapht.traverse.*;

public class Server {
    public final static int PORT = 8100;
    public volatile ArrayList<User> users = new ArrayList<User>();



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

    //for now this funcin is generating a GraphViz object (transform to html)
    public void getHTMLDoc(){
        Graph<URI, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
        try{
            for (User u: users
            ) {
                URI userURIaux = new URI(u.getName());
                g.addVertex(userURIaux);
                for (Object friend: u.getFriends()
                ) {
                    URI edgeURIaux  = new URI(friend.toString());
                    g.addEdge(userURIaux,edgeURIaux);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        DOTExporter<URI, DefaultEdge> exporter =
                new DOTExporter<>(v -> v.getHost().replace('.', '_'));
        exporter.setVertexAttributeProvider((v) -> {
            Map<String, Attribute> map = new LinkedHashMap<>();
            map.put("label", DefaultAttribute.createAttribute(v.toString()));
            return map;
        });
        Writer writer = new StringWriter();
        exporter.exportGraph(g, writer);
        System.out.println(writer.toString());
    }
}
