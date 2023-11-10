package SERVER;

	
	import java.io.*;
	import java.net.*;
	import Calculatrice.Calculatrice;
	public class Server {
	    public static void main(String[] args) {
	        try (ServerSocket serverSocket = new ServerSocket(1745)) {
	            System.out.println("Serveur en attente de connexions...");

	            while (true) {
	                Socket clientSocket = serverSocket.accept();
	                System.out.println("Nouveau client connecté : " + clientSocket);

	                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
	                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());

	                Calculatrice calculatrice = new Calculatrice();

	                try {
	                    int operation = in.readInt();
	                    int a = in.readInt();
	                    int b = in.readInt();

	                    int resultat;

	                    switch (operation) {
	                        case 1:
	                            resultat = calculatrice.addition(a, b);
	                            break;
	                        // Ajoutez d'autres cas pour les opérations supplémentaires ici
	                        default:
	                            throw new IllegalArgumentException("Opération non prise en charge : " + operation);
	                    }

	                    out.writeInt(resultat);
	                    out.flush();

	                } catch (IOException e) {
	                    e.printStackTrace();
	                }

	                in.close();
	                out.close();
	                clientSocket.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



