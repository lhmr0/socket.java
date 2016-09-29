package sockets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {

    final static int puerto = 3000;
    static ServerSocket svsock;
    static Socket sock;
    static String msjRec;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        iniciarServer();

    }

    public static void iniciarServer() {

        BufferedReader entrada;

        try {

            svsock = new ServerSocket(puerto);
            sock = new Socket();
            System.out.println("A la espera de cliente");
            sock = svsock.accept();
            System.out.println("Se ha conectado un cliente");
            entrada = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            msjRec = entrada.readLine();
            System.out.println("mensaje recibido:" + msjRec);
            System.out.println("Cerrando la conexión con el servidor");
            svsock.close();
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

    }
}
