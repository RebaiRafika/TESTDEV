package SERVER;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import CLIENT.Client;

public class Server {

    @SuppressWarnings("resource")
	public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Serveur démarré. En attente de connexions...");

            int clientNumber = 1;

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Thread clientThread = new Thread(new Client(clientSocket, clientNumber));
                clientThread.start();
                clientNumber++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}