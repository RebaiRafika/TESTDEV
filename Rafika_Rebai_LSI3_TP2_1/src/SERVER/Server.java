package SERVER;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Serveur en attente de connexion...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Lecture de l'opération envoyée par le client
            String operation = in.readLine();
            System.out.println("Opération reçue : " + operation);

            // Évaluation de l'opération
            String[] elements = operation.split(" ");
            int operand1 = Integer.parseInt(elements[0]);
            char operator = elements[1].charAt(0);
            int operand2 = Integer.parseInt(elements[2]);
            int resultat = 0;

            switch (operator) {
                case '+':
                    resultat = operand1 + operand2;
                    break;
                case '-':
                    resultat = operand1 - operand2;
                    break;
                case '*':
                    resultat = operand1 * operand2;
                    break;
                case '/':
                    resultat = operand1 / operand2;
                    break;
            }

            // Envoi du résultat au client
            out.println(resultat);

            // Fermeture des flux et de la connexion
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

