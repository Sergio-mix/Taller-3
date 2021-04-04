package co.edu.unbosque.controller.socketswiththreads;

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

                String text ="";
                text =in.nextLine();
                System.out.println(transform_jump(text));
                if(transform_jump(text).equals("Close")){
                    System.exit(0);
                }else{
                    out.println(scanner.next());
                }


            }
        }
    }
    public static String transform_jump(String text){
        text = text.replace("&&","\n");
        return text;
    }
}