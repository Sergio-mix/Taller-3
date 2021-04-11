package co.edu.unbosque.controller.socket;

import co.edu.unbosque.controller.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class server Logic
 */
public class Server_Logic implements Runnable {
    //Hacemos las instancias de las clases que vamos a necesitar
    private Socket socket;
    private Controller controller;
    private List agents;

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // constructor
    public Server_Logic(Socket socket) {
        this.socket = socket;
        controller = new Controller();
        agents = new ArrayList<>();
    }

    // variables para el menu
    String especie = "";
    String tamaño = "";
    String localidad = "";
    String direccion = "";
    String nombre = "";
    String telefono = "";
    String correo = "";
    String comentarios = "";

    @Override
    //se corre el socket
    public void run() {
        safePrintln("Connected: " + socket);


        try {
            var in = new Scanner(socket.getInputStream());
            var out = new PrintWriter(socket.getOutputStream(), true);

//validacion para añadir un socket al agente
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
                // Este es el menu que aparece al ejecutar el cliente
                if (!agentG) {
                    String text;
                    String text1 = ANSI_GREEN + "Bienvenidos a Ciudadanos de 4 Patas" +
                            "\nSeleccione:\n" +
                            "(1) Crear caso\n" +
                            "(2) Hablar con un agente\n" +
                            "(3) Salir";

                    out.println(transform_jump(text1));

                    var message = in.nextLine();


                    if (message.equals("1")) {


                        text = ANSI_CYAN + "Cual es el tipo de caso que desea reportar\n" +
                                "(1) Pérdida\n" +
                                "(2) Robo\n" +
                                "(3) Abandono\n" +
                                "(4) Animal peligroso\n" +
                                "(5) Manejo indebido en vía pública";
                        out.println(transform_jump(text));


                        var message2 = in.nextLine();
                        String case_Of_Types = case_Of_Type(message2);
                        //Validacion para la opcion digitada
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
                            // se envian los datos registrados al constructor del controlador
                            controller.register_Report(especie, tamaño, localidad, direccion, nombre, telefono, correo, comentarios, case_Of_Types);
                            out.println("El caso ha sido creado");
                        }


                    }
                    if (message.equals("2")) {
                        out.println("chat");
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
// metodo para remplazarlos /n
    public String transform_jump(String text) {
        text = text.replace("\n", "&&");
        return text;
    }
// recibe el mensaje emitido por el agente
    public void client_Agent(String message, Socket agent) throws IOException {
        Socket a = new Socket();

        var out = new PrintWriter(a.getOutputStream(), true);

        var outAgent = new PrintWriter(agent.getOutputStream(), true);

        outAgent.println(message);

        out.println(message);


    }
// metodo para determinar el tipo de caso dependiendo la opcion que se haya digitalizado
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