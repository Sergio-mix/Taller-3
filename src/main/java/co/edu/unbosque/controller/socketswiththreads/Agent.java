package co.edu.unbosque.controller.socketswiththreads;

import co.edu.unbosque.controller.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Agent implements Runnable {

    private Socket socket;
    private Controller controller;

    public Agent(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        safePrintln("Connected: " + socket);

        try {

            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String text = "Bienvenidos a Ciudadanos de 4 Patas"+
                        "\nSeleccione:\n" +
                        "(1) Crear caso\n" +
                        "(2) Hablar con un agente";

                out.println(transform_jump(text));

                var message = in.nextLine();
                if (message.equals("1")) {
                    controller = new Controller();
                    String case_Of_Type = "";
                    out.println("Cual es el tipo de caso que desea reportar\n" +
                            "(1) Pérdida\n" +
                            "(2) Robo\n" +
                            "(3) Abandono\n" +
                            "(4) Animal peligroso\n" +
                            "(5) Manejo indebido en vía pública");
                    message = in.nextLine();
                    if (message.equals(("1"))) {
                        case_Of_Type = "Pérdida";
                    }
                    if (message.equals(("2"))) {
                        case_Of_Type = "Robo";
                    }
                    if (message.equals(("3"))) {
                        case_Of_Type = "Abandono";
                    }
                    if (message.equals(("4"))) {
                        case_Of_Type = "Animal peligroso";
                    }
                    if (message.equals(("5"))) {
                        case_Of_Type = "Manejo indebido en vía pública";
                    }

                    out.println("Ingrese la Especie");
                    String Especie = message;
                    out.println("Ingrese el Tamaño");
                    String Tamaño = message;
                    out.println("Ingrese la Localidad");
                    String Localidad = message;
                    out.println("Ingrese la Dirección");
                    String Dirección = message;
                    out.println("Nombre completo de la persona que reporta");
                    String nombre = message;
                    out.println("Teléfono de la persona que reporta");
                    String telefono = message;
                    out.println("Email de la persona que reporta");
                    String correo = message;
                    out.println("Comentarios generales\n");
                    String comentarios = message;

                    controller.register_Report(Especie, Tamaño, Localidad, Dirección, nombre, Integer.parseInt(telefono), correo, comentarios, case_Of_Type);
                    out.println("El caso ha sido creado");
                }
                else if (message.equals("2")) {
                    System.out.println("2");
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
    public String transform_jump(String text){
        text = text.replace("\n","&&");
        return text;
    }



}