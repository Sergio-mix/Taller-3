package edu.unbosque.controller;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws Exception {

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

                    try (var socket2 = new Socket("127.0.0.1", 8201)) {
                        scanner = new Scanner(System.in);
                        var in2 = new Scanner(socket2.getInputStream());
                        var out2 = new PrintWriter(socket2.getOutputStream(), true);
                        String solicitud = "Solicitud de aceptacion agente: "+
                                "\n (1) Aceptar"+
                                "\n (2) Denegar";
                        out2.println(transform_jump2(solicitud));
                        while (in.hasNextLine()) {

                            text = "";
                            text = "Agente: "+in2.nextLine();
                            System.out.println(text);
                            out2.println(scanner.nextLine());

                        }
                    }


                }
            }
        }
    }

    public static String transform_jump(String text) {
        text = text.replace("&&", "\n");
        return text;
    }
    public static String transform_jump2(String text) {
        text = text.replace("\n", "&&");
        return text;
    }


}