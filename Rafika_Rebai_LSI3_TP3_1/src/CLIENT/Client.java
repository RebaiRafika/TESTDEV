package CLIENT;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

public class Client implements Runnable {

    private Socket s;
    private int clientnumber;

    public Client(Socket s, int nbC) {
        this.s = s;
        this.clientnumber = nbC;
    }

    @Override
    public void run() {
        try {
            SocketAddress clientAddress = s.getRemoteSocketAddress();
            System.out.println("IP du Client " + clientnumber + ": " + clientAddress);

            OutputStream out = s.getOutputStream();
            PrintWriter pw = new PrintWriter(out);
            pw.println("Vous êtes le Client " + clientnumber);
            pw.flush(); // N'oubliez pas de vider le tampon
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   

        public static void main(String[] args) {
            try {
                Socket socket = new Socket("localhost", 1234); // Connectez-vous au serveur sur le port 1234
                int clientNumber = 1; // Choisissez un numéro de client
                Thread clientThread = new Thread(new Client(socket, clientNumber)); // Créez un thread client
                clientThread.start(); // Démarrez le thread client
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    


