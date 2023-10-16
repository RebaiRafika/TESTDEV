package ServerPackage;
import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	
		public static void main(String[] args)
				{
			try {
				// Crée un serveur socket qui écoute sur le port 1234.
				ServerSocket ss= new ServerSocket(1234);
			System.out.println("je suis un serveur");
			// Attends une connexion entrante. Le programme se bloque ici jusqu'à ce qu'un client se connecte.
			Socket s=ss.accept();
		      // Obtient des flux d'entrée et de sortie pour communiquer avec le client
			InputStream is=s.getInputStream();
			OutputStream os=s.getOutputStream();
			}catch (IOException e){
				e.printStackTrace();
			}}}
				

	



