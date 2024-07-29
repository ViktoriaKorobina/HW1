package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JTextField loginField = new JTextField();
    private final JTextField passwordField = new JTextField();
    private final JTextField ipField = new JTextField();
    private final JTextField portField = new JTextField();
    private final JTextArea chatArea = new JTextArea();
    private final JTextField messageField = new JTextField();
    private final JButton sendButton = new JButton("Send");
    private final JButton connectButton = new JButton("Connect");
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    private boolean connect = false;
    private boolean sent = false;



    ChatClient() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat Client");
        setAlwaysOnTop(true);
        setLayout(new BorderLayout());

        JPanel serverPanel = new JPanel(new GridLayout(4, 2));
        serverPanel.add(new JLabel("Login:"));
        serverPanel.add(loginField);
        serverPanel.add(new JLabel("Password:"));
        serverPanel.add(passwordField);
        serverPanel.add(new JLabel("IP Address:"));
        serverPanel.add(ipField);
        serverPanel.add(new JLabel("Port:"));
        serverPanel.add(portField);
        add(serverPanel, BorderLayout.NORTH);

        JPanel messagePanel = new JPanel(new BorderLayout());

        messagePanel.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        messagePanel.add(inputPanel, BorderLayout.SOUTH);
        add(messagePanel, BorderLayout.CENTER);

        JPanel connectPanel = new JPanel(new GridLayout(1, 1));
        connectPanel.add(connectButton);
        add(connectPanel, BorderLayout.SOUTH);

        sendButton.addActionListener(e -> {
            sent = true;
            sendMessage();
        });

        messageField.addActionListener(e -> {
            sendMessage();
        });

        connectButton.addActionListener(e -> connectToServer());

        setVisible(true);
    }

    private void connectToServer() {

        connect = true;
        chatArea.setText("You are connected");
    }

    private void sendMessage() {
        if (connect && messageField.getText() != null) {
            //out.println(messageField.getText());
            messageField.setText("");
        } else {
            chatArea.append("Not connected to server\n");
        }
    }



    public String getLoginField() {
        return loginField.getText();
    }

    public String getMessageField() {
        return messageField.getText();
    }

    public boolean isConnect() {
        return connect;
    }

    public boolean isSent() {
        return sent;
    }
}
