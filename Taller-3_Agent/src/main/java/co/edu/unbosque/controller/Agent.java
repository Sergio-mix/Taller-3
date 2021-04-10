package co.edu.unbosque.controller;

import co.edu.unbosque.view.Agent_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Class Agent
 */
public class Agent implements ActionListener {
    private static Agent_View agent_view;

    public static void main(String[] args) throws Exception {

        agent_view = new Agent_View();

        try (var socket = new Socket("127.0.0.1", 7200)) {
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            out.println("agente");
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
                    agent_view.setVisible(true);
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
        if (e.getSource() == agent_view.jButton) {

        }
    }
}
