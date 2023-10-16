package ClientPackage;


	import java.io.*;

	import java.net.*;
	public class Client1 {

	    public static void main(String[] args) {
	        try {
	            Socket socket = new Socket("localhost", 12345); // Établir une connexion au serveur sur "localhost".
	            // Préparer des flux de communication avec le serveur.
	            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));// Lecture des entrées de l'utilisateur.
	            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Envoi de données au serveur.

	            System.out.print("Entrez un entier : ");
	            int x = Integer.parseInt(in.readLine());
	            // Envoyer l'entier au serveur.
	            out.println(x);

	            BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            int resultat = Integer.parseInt(serverIn.readLine());

	            System.out.println("Résultat reçu : " + resultat);
	         // Fermer les flux et la socket.
	            in.close();
	            out.close();
	            serverIn.close();
	            socket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


