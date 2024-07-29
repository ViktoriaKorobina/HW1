package org.example;

import javax.swing.*;

public class ChatServer {
    public String text = "";
    public void messageExchange(ChatClient chatClient1, ChatClient chatClient2, ServerWindow serverWindow){
        while (serverWindow.isServerWorking()){
            if (chatClient1.isConnect() && serverWindow.isServerWorking()){
                text += chatClient1.getLoginField() + ":" + chatClient1.getMessageField() + "\n";
                serverWindow.setLog(text);
            }
            if (chatClient2.isConnect() && serverWindow.isServerWorking()){
                text += chatClient2.getLoginField() + ":" + chatClient2.getMessageField() + "\n";
                serverWindow.setLog(text);
            }
        }




    }
}
