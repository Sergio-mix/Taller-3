package co.edu.unbosque.controller;

import co.edu.unbosque.view.Agent_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;

/**
 * Class Agent
 */
public class Agent implements ActionListener {
    private static Agent_View agent_view;

    public static void main(String[] args) throws Exception {


//        agent_view = new Agent_View();

        try (var socket = new Socket("127.0.0.1", 7200)) {
            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            out.println("agente");

            try (var listener = new ServerSocket(8201)) {

                System.out.println("Esperando cliente...");
                var pool = Executors.newFixedThreadPool(20);
                while (true) {
                    pool.execute(new Agent_Logic(listener.accept()));
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
