package org.example;

public class Main {
    public static void main(String[] args) {

        ChatServer chatServer = new ChatServer();
        chatServer.messageExchange(new ChatClient(), new ChatClient(), new ServerWindow());


    }
}
