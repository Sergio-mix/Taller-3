package edu.unbosque.controller;

import edu.unbosque.view.Client_View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements ActionListener {
    private static Client_View client_view;

    public static void main(String[] args) throws Exception {
        client_view = new Client_View();
        try (var socket = new Socket("127.0.0.1", 7200)) {
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Cliente");
            while (in.hasNextLine()) {

                String text = "";
                text = in.nextLine();
                System.out.println(transform_jump(text));
                if (transform_jump(text).equals("Close")) {
                    System.exit(0);
                } else {
                    out.println(scanner.next());
                }
                if (transform_jump(text).equals("chat")) {
                    client_view.setVisible(true);
                } else {
                    out.println(scanner.next());
                }
            }
        }
    }

    public static String transform_jump(String text) {
        text = text.replace("&&", "\n");
        return text;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == client_view.jButton) {

        }
    }
}