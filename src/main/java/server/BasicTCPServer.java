package server;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class BasicTCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Servidor ouvindo a porta 12345");

            while(true){
                Socket client = server.accept();
                System.out.println("Cliente conectado: " + client.getInetAddress().getHostAddress());

                ObjectOutputStream exit = new ObjectOutputStream(client.getOutputStream());

                exit.flush();
                exit.writeObject(new Date());
                exit.close();

                client.close();
            }
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
