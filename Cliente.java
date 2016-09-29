package sockets;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    final static String host = "localhost";
    final static int puerto = 3000;
    static Socket sock;
    static DataOutputStream mensaje;
    static String entrada;

    public static void main(String[] args) {
        iniciarClient();
    }

    public static void iniciarClient() {

        try {
            sock = new Socket(host, puerto);
            System.out.println("Ingrese mensaje: ");
            String msj = "";
            Scanner scan = new Scanner(System.in);
            msj = scan.nextLine();
            mensaje = new DataOutputStream(sock.getOutputStream());
            mensaje.writeUTF(msj);
            sock.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
