package co.edu.unbosque.controller.socketswiththreads;

import co.edu.unbosque.controller.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server_Logic implements Runnable {

    private Socket socket;
    private Controller controller;
    private List agents;

    public Server_Logic(Socket socket) {
        this.socket = socket;
        controller = new Controller();
        agents = new ArrayList<>();
    }

    String especie = "";
    String tamaño = "";
    String localidad = "";
    String direccion = "";
    String nombre = "";
    String telefono = "";
    String correo = "";
    String comentarios = "";

    @Override
    public void run() {
        safePrintln("Connected: " + socket);


        try {
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);


            while (true) {
                boolean agentG = false;
                var entrar = in.nextLine();
                if (entrar.equals("agente")) {
                    agentG = true;
                    for (int i = 0; i < agents.size(); i++) {
                        if (!socket.equals(agents.get(i))) {
                            agents.add(socket);
                        }
                    }

                }
                if (!agentG) {
                    String text = "Bienvenidos a Ciudadanos de 4 Patas" +
                            "\nSeleccione:\n" +
                            "(1) Crear caso\n" +
                            "(2) Hablar con un agente\n" +
                            "(3) Salir";

                    out.println(transform_jump(text));

                    var message = in.nextLine();


                    if (message.equals("1")) {


                        text = "Cual es el tipo de caso que desea reportar\n" +
                                "(1) Pérdida\n" +
                                "(2) Robo\n" +
                                "(3) Abandono\n" +
                                "(4) Animal peligroso\n" +
                                "(5) Manejo indebido en vía pública";
                        out.println(transform_jump(text));


                        var message2 = in.nextLine();
                        String case_Of_Types = case_Of_Type(message2);
                        if (message.equals("1") || message.equals("2") || message.equals("3") || message.equals("4") || message.equals("5")) {


                            text = "Cual es la especie \n" +
                                    "(1) Canino\n" +
                                    "(2) Felino";
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
                                    "(2) Pequeño";
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
                            out.println("Comentarios generales");
                            message2 = in.nextLine();
                            comentarios = message2;
                            controller.register_Report(especie, tamaño, localidad, direccion, nombre, telefono, correo, comentarios, case_Of_Types);
                            out.println("El caso ha sido creado");
                        }


                    }
                    if (message.equals("2")) {
                        boolean c = false;
                        Socket b = null;
                        for (int i = 0; i < agents.size(); i++) {

                            Socket a = (Socket) agents.get(i);
                            var inAgent = new Scanner(a.getInputStream());
                            var outAgent = new PrintWriter(a.getOutputStream(), true);
                            outAgent.println("(1)Aceptar\n" +
                                    "(2)Denegar");
                            var messegeAgent = inAgent.nextLine();
                            if (messegeAgent.equals("1")) {
                                b = a;
                                c = true;
                                break;
                            }
                        }
                        System.out.println("Puede comentar las inquietudes al agente");
                        var message11 = in.nextLine();
                        if (c) {
                            client_Agent(message11, b);
                        }


                    }
                    if (message.equals("3")) {
                        out.println("Close");

                    } else {
                        out.println("Por favor ingrese los datos correctos ");
                    }
                } else {
                    out.println("Espera un cliente");
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

    public void client_Agent(String message, Socket agent) throws IOException {
        Socket a = new Socket();

        var out = new PrintWriter(a.getOutputStream(), true);

        var outAgent = new PrintWriter(agent.getOutputStream(), true);

        outAgent.println(message);

        out.println(message);


    }

    public String case_Of_Type(String number) {
        String case_Of_Type = "";
        if (number.equals("1")) {
            case_Of_Type = "Perdida";
        }
        if (number.equals("2")) {
            case_Of_Type = "Robo";
        }
        if (number.equals("3")) {
            case_Of_Type = "Abandono";
        }
        if (number.equals("4")) {
            case_Of_Type = "Animal peligroso";
        }
        if (number.equals("5")) {
            case_Of_Type = "Manejo indebido en vía pública";
        }
        return case_Of_Type;

    }


}