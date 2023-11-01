package PackageClient;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client1 {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // Crée un objet Socket pour se connecter au serveur localhost sur le port 1234.
        Socket s = new Socket("localhost", 1234);
        System.out.println("Je suis un client connecté !");

        // Crée un objet Scanner pour lire l'entrée utilisateur depuis la console.
        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur de fournir le premier entier.
        System.out.print("Entrez le premier entier : ");
        int a = scanner.nextInt();

        // Demande à l'utilisateur de fournir le deuxième entier.
        System.out.print("Entrez le deuxième entier : ");
        int b = scanner.nextInt();

        // Demande à l'utilisateur de choisir une opération (1 pour addition, 2 pour soustraction, 3 pour multiplication, 4 pour division).
        System.out.println("Choisissez l'une des opérations :");
        System.out.println("1) Addition (+)");
        System.out.println("2) Soustraction (-)23");
        System.out.println("3) Multiplication (*)");
        System.out.println("4) Division (/)");
        int op = scanner.nextInt();
        System.out.println("Vous avez choisi l'opération : " + op);

        // Récupère le flux de sortie du socket pour envoyer les données au serveur.
        OutputStream out = s.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        // Envoie les deux entiers (a et b) et le code d'opération (op) au serveur.
        dos.writeInt(a);
        dos.writeInt(b);
        dos.writeInt(op);

        // Récupère le flux d'entrée du socket pour recevoir la réponse du serveur.
        InputStream is = s.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        int res = dis.readInt(); // Lit la réponse du serveur.

        // Affiche la réponse reçue du serveur.
        System.out.println("Le résultat retourné par le serveur est : " + res);

        // Ferme la connexion avec le serveur en fermant le socket.
        s.close();
    }
}

