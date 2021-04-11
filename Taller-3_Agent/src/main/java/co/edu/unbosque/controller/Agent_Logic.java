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
            String send = "";
            String messege="";
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);
            var scanner = new Scanner(System.in);
            String solicitud = "Solicitud de aceptacion agente: " +
                    "\n (1) Aceptar" +
                    "\n (2) Denegar";
            messege = transform_jump(in.nextLine());
            if (messege.equals(solicitud)){
                safePrintln(messege);
                send = scanner.nextLine();
                if (send.equals("1")) {
                    out.println("Hola! en que puedo ayudar?");
                    while (in.hasNextLine()) {
                        var message = in.nextLine();
                        safePrintln("Cliente: " + message);

                        send = scanner.nextLine();
                        out.println(send);

                    }
                } else if (send.equals("2")) {
                    out.println("su solicitud fue rechazada");
                    out.println("Close");
                }

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
    public static String transform_jump(String text) {
        text = text.replace("&&", "\n");
        return text;
    }

    }

