package com.company;
//this is the server project
public class Main {

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.getHTMLDoc();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
