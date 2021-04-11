package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import java.util.Scanner;

public class Agent_Logic implements Runnable {

    private Socket socket;
    public Agent_Logic(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        safePrintln("Connected: " + socket);
        try {
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            var scanner = new Scanner(System.in);

            out.println("sasfafasf");

            while (in.hasNextLine()) {
                var message = in.nextLine();
                safePrintln("Cliente: " + message);;
                String send = scanner.nextLine();
                out.println(send);

            }



        } catch (Exception e) {
            safePrintln("Error:" + socket);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
            safePrintln("Closed: " + socket);
        }
    }
    public void safePrintln(String s) {
        synchronized (System.out) {
            System.out.println(s);
        }
    }

    }

