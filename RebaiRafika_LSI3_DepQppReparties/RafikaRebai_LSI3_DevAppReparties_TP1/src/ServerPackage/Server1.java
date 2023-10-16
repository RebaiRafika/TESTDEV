package ServerPackage;

	import java.io.*;
	import java.net.*;

	public class Server1{

	    public static void main(String[] args) {
	        try {
	        	 // Crée un serveur socket écoutant sur le port 12345
	            ServerSocket serverSocket = new ServerSocket(12345);//Socket
	            System.out.println("Attente de connexion...");
	            // Attend qu'un client se connecte.
	            Socket clientSocket = serverSocket.accept();
	            System.out.println("Client connecté.");
	         // Prépare des flux de communication avec le client.
	            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	         // Lire un entier envoyé par le client.
	            int x = Integer.parseInt(in.readLine());
	            int resultat = x * 5;
	         // Envoie le résultat au client.
	            out.println(resultat);

	            in.close();
	            out.close();
	            clientSocket.close();
	            serverSocket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}

