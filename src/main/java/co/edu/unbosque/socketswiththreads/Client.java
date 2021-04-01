package co.edu.unbosque.socketswiththreads;


import java.net.Socket;
import java.util.Scanner;
import java.io.PrintWriter;

public class Client {

    public static void main(String[] args) throws Exception {

        try (var socket = new Socket("127.0.0.1", 59897)) {

            System.out.println("Connected: " + socket);
            System.out.println("Enter the message to be capitalized...");

            var scanner = new Scanner(System.in);
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);

            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
                System.out.println("Transformed message: " + in.nextLine());
            }

        }

    }

}