package client;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

public class BasicTCPClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 12345);
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            Date dateNow = (Date)input.readObject();
            System.out.println("Data recebida do servidor: " + dateNow.toString());
            input.close();
            System.out.println("Conexão encerrada");
        }
        catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
