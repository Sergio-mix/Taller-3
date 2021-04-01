package co.edu.unbosque.controller.socketswiththreads;

import java.lang.invoke.SwitchPoint;
import java.net.ServerSocket;
import java.util.Scanner;
import java.util.concurrent.Executors;

/**
 * Example from: https://cs.lmu.edu/~ray/notes/javanetexamples/
 *
 * A server program which accepts requests from clients to capitalize strings.
 * When a client connects, a new thread is started to handle it. Receiving
 * client data, capitalizing it, and sending the response back is all done on
 * the thread, allowing much greater throughput because more clients can be
 * handled concurrently.
 */
public class Server {


    /**
     * Runs the server. When a client connects, the server spawns a new thread to do
     * the servicing and immediately returns to listening. The application limits
     * the number of threads via a thread pool (otherwise millions of clients could
     * cause the server to run out of resources by allocating too many threads).
     */
    public static void main(String[] args) throws Exception {
        Scanner scanner ;
        scanner = new Scanner(System.in);

        try (var listener = new ServerSocket(59897)) {

            System.out.println("Bienvenido a Ciudadanos de 4 patas ");
            System.out.println("Por favor indique la accion a realizar"+
                    "\n(1) Crear caso"+"\n(2) Hablar con un agente");
            int opcion = scanner.nextInt();

            switch (opcion){
                case 1:

                case 2:
            }

            var pool = Executors.newFixedThreadPool(20);

            while (true) {
                pool.execute(new Capitalizer(listener.accept()));
            }

        }

    }

}
