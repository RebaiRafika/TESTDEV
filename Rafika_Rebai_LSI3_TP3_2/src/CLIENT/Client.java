package CLIENT;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1745);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            int operation = 1; // Pour l'addition (vous pouvez utiliser d'autres valeurs pour les autres opérations)
            int a = 10;
            int b = 20;

            out.writeInt(operation);
            out.writeInt(a);
            out.writeInt(b);
            out.flush();

            int resultat = in.readInt();
            System.out.println("Résultat de l'addition : " + resultat);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
