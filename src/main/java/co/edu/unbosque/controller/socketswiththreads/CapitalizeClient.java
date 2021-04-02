package co.edu.unbosque.controller.socketswiththreads;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CapitalizeClient {

    public static void main(String[] args) throws Exception {

        try (var socket = new Socket("127.0.0.1", 5000)) {

            System.out.println("Connected: " + socket);
            System.out.println("Enter the message to be capitalized...");

            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);


            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
                out.println(scanner.nextLine());


            }

        }

    }

}