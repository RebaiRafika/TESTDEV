package CLIENT;

	import java.io.*;
	import java.net.*;

	public class Client {
	    public static void main(String[] args) {
	        try {
	            Socket socket = new Socket("localhost", 12345);
	            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

	            // Envoi de l'opération au serveur
	            String operation = "34 * 55";
	            out.println(operation);

	            // Lecture de la réponse du serveur
	            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	            String resultat = in.readLine();
	            System.out.println("Résultat : " + resultat);

	            // Fermeture des flux et de la connexion
	            in.close();
	            out.close();
	            socket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
