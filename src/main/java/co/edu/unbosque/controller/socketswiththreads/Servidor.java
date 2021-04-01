package co.edu.unbosque.controller.socketswiththreads;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Servidor {

    private Socket miServicio;
    private ServerSocket socketServicio;

    private OutputStream outputStream;
    private InputStream inputStream;

    private DataOutputStream salidaDatos;
    private DataInputStream entradaDatos;

    private boolean opcion = true;
    private Scanner scanner;
    private String esctribir;

    /**
     *
     * @param numeroPuerto
     */
    public void conexion(int numeroPuerto) {
        try {
            socketServicio = new ServerSocket(numeroPuerto);
            miServicio = socketServicio.accept();
            Thread hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (opcion) {
                        System.out.print("SERVIDOR: ");
                        recibirDatos();
                    }
                }
            });
            hilo.start();
            while (opcion) {
                scanner = new Scanner(System.in);
                esctribir = scanner.nextLine();
                if (!esctribir.equals("CLIENTE: fin")) {
                    enviarDatos("SERVIDOR: " + esctribir);
                } else {
                    opcion = false;
                }
            }
            miServicio.close();
        } catch (Exception ex) {
            System.out.println("Error al abrir los sockets");
        }
    }

    /**
     *
     * @param datos
     */
    public void enviarDatos(String datos) {
        try {
            outputStream = miServicio.getOutputStream();
            salidaDatos = new DataOutputStream(outputStream);
            salidaDatos.writeUTF(datos);
            salidaDatos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     */
    public void recibirDatos() {
        try {
            inputStream = miServicio.getInputStream();
            entradaDatos = new DataInputStream(inputStream);
            System.out.println(entradaDatos.readUTF());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Servidor serv = new Servidor();
        serv.conexion(5555);
    }
}
