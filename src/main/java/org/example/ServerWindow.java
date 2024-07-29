package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ServerWindow extends JFrame {
    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private JTextArea log = new JTextArea();

    boolean isServerWorking;



    ServerWindow() {
        isServerWorking = false;
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    log.append("Server is not running\n");
                } else {
                    isServerWorking = false;
                    log.append("Server stopped\n");
                }

            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    log.append("Server is already running\n");

                } else {
                    isServerWorking = true;
                    log.append("Server started\n");
                }
            }

        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setAlwaysOnTop(true);
        setLayout(new GridLayout(1, 2));
        add(btnStart);
        add(btnStop);
        add(new JScrollPane(log), BorderLayout.CENTER);
        setVisible(true);
    }

    public boolean isServerWorking() {
        return isServerWorking;
    }

    public void setLog(String text) {
        this.log.setText(text);
    }
}

