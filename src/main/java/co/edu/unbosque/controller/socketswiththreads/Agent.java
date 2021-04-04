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
                String text = "Bienvenidos a Ciudadanos de 4 Patas" +
                        "\nSeleccione:\n" +
                        "(1) Crear caso\n" +
                        "(2) Hablar con un agente";

                out.println(transform_jump(text));
                String especie="";
                String tamaño = "";
                String localidad = "";
                String direccion = "";
                String nombre = "";
                String telefono = "";
                String correo = "";
                String comentarios = "";
                var message = in.nextLine();

                String case_Of_Type = "";
                if (message.equals("1")) {


                    text = "Cual es el tipo de caso que desea reportar\n" +
                            "(1) Pérdida\n" +
                            "(2) Robo\n" +
                            "(3) Abandono\n" +
                            "(4) Animal peligroso\n" +
                            "(5) Manejo indebido en vía pública";
                    out.println(transform_jump(text));


                    var message2 = in.nextLine();


                    if (message.equals(("1"))) {
                        case_Of_Type = "Perdida";
                        text = "Cual es la especie \n" +
                                "(1) Canino\n" +
                                "(2) Felino\n";
                        out.println(transform_jump(text));
                        message2 = in.nextLine();
                        if (message2.equals("1")) {
                             especie = "canino";

                        } else if (message2.equals("2")) {
                             especie = "felino";

                        } else {
                            out.println("Ingrese un valor correcto");
                        }
                        text = "Cual es el tamaño \n" +
                                "(1) Grande\n" +
                                "(2) Pequeño\n";
                        out.println(transform_jump(text));
                        message2 = in.nextLine();
                        if (message2.equals("1")) {
                             tamaño = "grande";

                        } else if (message2.equals("2")) {
                             tamaño = "pequeño";

                        } else {
                            out.println("Ingrese un valor correcto");
                        }
                        out.println("Ingrese la Localidad");
                        message2 = in.nextLine();
                         localidad = message2;
                        out.println("Ingrese la Dirección");
                        message2 = in.nextLine();
                         direccion = message2;
                        out.println("Nombre completo de la persona que reporta");
                        message2 = in.nextLine();
                         nombre = message2;
                        out.println("Teléfono de la persona que reporta");
                        message2 = in.nextLine();
                         telefono = message2;
                        out.println("Email de la persona que reporta");
                        message2 = in.nextLine();
                         correo = message2;
                        out.println("Comentarios generales\n");
                        message2 = in.nextLine();
                         comentarios = message2;
                        controller.register_Report(especie,tamaño, localidad,direccion,nombre,telefono,correo,comentarios,case_Of_Type);
                    }

                    var message3 = in.nextLine();
                    if (message.equals(("2"))) {
                        case_Of_Type = "Robo";
                        text = "Cual es la especie \n" +
                                "(1) Canino\n" +
                                "(2) Felino\n";
                        out.println(transform_jump(text));
                        message2 = in.nextLine();
                        if (message2.equals("1")) {
                            especie = "canino";

                        } else if (message2.equals("2")) {
                            especie = "felino";

                        } else {
                            out.println("Ingrese un valor correcto");
                        }
                        text = "Cual es el tamaño \n" +
                                "(1) Grande\n" +
                                "(2) Pequeño\n";
                        out.println(transform_jump(text));
                        message2 = in.nextLine();
                        if (message2.equals("1")) {
                            tamaño = "grande";

                        } else if (message2.equals("2")) {
                            tamaño = "pequeño";

                        } else {
                            out.println("Ingrese un valor correcto");
                        }
                        out.println("Ingrese la Localidad");
                        message2 = in.nextLine();
                        localidad = message2;
                        out.println("Ingrese la Dirección");
                        message2 = in.nextLine();
                        direccion = message2;
                        out.println("Nombre completo de la persona que reporta");
                        message2 = in.nextLine();
                        nombre = message2;
                        out.println("Teléfono de la persona que reporta");
                        message2 = in.nextLine();
                        telefono = message2;
                        out.println("Email de la persona que reporta");
                        message2 = in.nextLine();
                        correo = message2;
                        out.println("Comentarios generales\n");
                        message2 = in.nextLine();
                        comentarios = message2;
                        controller.register_Report(especie,tamaño, localidad,direccion,nombre,telefono,correo,comentarios,case_Of_Type);
                    }
                    var message4 = in.nextLine();
                    if (message.equals(("3"))) {
                        case_Of_Type = "Abandono";
                        text = "Cual es la especie \n" +
                                "(1) Canino\n" +
                                "(2) Felino\n";
                        out.println(transform_jump(text));
                        message2 = in.nextLine();
                        if (message2.equals("1")) {
                            especie = "canino";

                        } else if (message2.equals("2")) {
                            especie = "felino";

                        } else {
                            out.println("Ingrese un valor correcto");
                        }
                        text = "Cual es el tamaño \n" +
                                "(1) Grande\n" +
                                "(2) Pequeño\n";
                        out.println(transform_jump(text));
                        message2 = in.nextLine();
                        if (message2.equals("1")) {
                            tamaño = "grande";

                        } else if (message2.equals("2")) {
                            tamaño = "pequeño";

                        } else {
                            out.println("Ingrese un valor correcto");
                        }
                        out.println("Ingrese la Localidad");
                        message2 = in.nextLine();
                        localidad = message2;
                        out.println("Ingrese la Dirección");
                        message2 = in.nextLine();
                        direccion = message2;
                        out.println("Nombre completo de la persona que reporta");
                        message2 = in.nextLine();
                        nombre = message2;
                        out.println("Teléfono de la persona que reporta");
                        message2 = in.nextLine();
                        telefono = message2;
                        out.println("Email de la persona que reporta");
                        message2 = in.nextLine();
                        correo = message2;
                        out.println("Comentarios generales\n");
                        message2 = in.nextLine();
                        comentarios = message2;
                        controller.register_Report(especie,tamaño, localidad,direccion,nombre,telefono,correo,comentarios,case_Of_Type);
                    }
                    var message5 = in.nextLine();
                    if (message.equals(("4"))) {
                        case_Of_Type = "Animal peligroso";
                        text = "Cual es la especie \n" +
                                "(1) Canino\n" +
                                "(2) Felino\n";
                        out.println(transform_jump(text));
                        message2 = in.nextLine();
                        if (message2.equals("1")) {
                            especie = "canino";

                        } else if (message2.equals("2")) {
                            especie = "felino";

                        } else {
                            out.println("Ingrese un valor correcto");
                        }
                        text = "Cual es el tamaño \n" +
                                "(1) Grande\n" +
                                "(2) Pequeño\n";
                        out.println(transform_jump(text));
                        message2 = in.nextLine();
                        if (message2.equals("1")) {
                            tamaño = "grande";

                        } else if (message2.equals("2")) {
                            tamaño = "pequeño";

                        } else {
                            out.println("Ingrese un valor correcto");
                        }
                        out.println("Ingrese la Localidad");
                        message2 = in.nextLine();
                        localidad = message2;
                        out.println("Ingrese la Dirección");
                        message2 = in.nextLine();
                        direccion = message2;
                        out.println("Nombre completo de la persona que reporta");
                        message2 = in.nextLine();
                        nombre = message2;
                        out.println("Teléfono de la persona que reporta");
                        message2 = in.nextLine();
                        telefono = message2;
                        out.println("Email de la persona que reporta");
                        message2 = in.nextLine();
                        correo = message2;
                        out.println("Comentarios generales\n");
                        message2 = in.nextLine();
                        comentarios = message2;
                        controller.register_Report(especie,tamaño, localidad,direccion,nombre,telefono,correo,comentarios,case_Of_Type);
                    }
                    var message6 = in.nextLine();
                    if (message.equals(("5"))) {
                        case_Of_Type = "Manejo indebido en vía pública";
                        text = "Cual es la especie \n" +
                                "(1) Canino\n" +
                                "(2) Felino\n";
                        out.println(transform_jump(text));
                        message2 = in.nextLine();
                        if (message2.equals("1")) {
                            especie = "canino";

                        } else if (message2.equals("2")) {
                            especie = "felino";

                        } else {
                            out.println("Ingrese un valor correcto");
                        }
                        text = "Cual es el tamaño \n" +
                                "(1) Grande\n" +
                                "(2) Pequeño\n";
                        out.println(transform_jump(text));
                        message2 = in.nextLine();
                        if (message2.equals("1")) {
                            tamaño = "grande";

                        } else if (message2.equals("2")) {
                            tamaño = "pequeño";

                        } else {
                            out.println("Ingrese un valor correcto");
                        }
                        out.println("Ingrese la Localidad");
                        message2 = in.nextLine();
                        localidad = message2;
                        out.println("Ingrese la Dirección");
                        message2 = in.nextLine();
                        direccion = message2;
                        out.println("Nombre completo de la persona que reporta");
                        message2 = in.nextLine();
                        nombre = message2;
                        out.println("Teléfono de la persona que reporta");
                        message2 = in.nextLine();
                        telefono = message2;
                        out.println("Email de la persona que reporta");
                        message2 = in.nextLine();
                        correo = message2;
                        out.println("Comentarios generales\n");
                        message2 = in.nextLine();
                        comentarios = message2;
                        controller.register_Report(especie,tamaño, localidad,direccion,nombre,telefono,correo,comentarios,case_Of_Type);
                    }

                }
                out.println("El caso ha sido creado");
                if (message.equals("2")) {
                    out.println("2");
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

    public String transform_jump(String text) {
        text = text.replace("\n", "&&");
        return text;
    }


}