package CLIENT;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Client {
    private static final int PORT = 13333234;

    public static void main(String[] args) {
        new Client().startClient();
    }

    @SuppressWarnings("resource")
	private void startClient() {
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez votre nom d'utilisateur : ");
            String username = scanner.nextLine();

            while (true) {
                System.out.print("Message à envoyer (ou 'exit' pour quitter) : ");
                String message = scanner.nextLine();

                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }

                String fullMessage = "[" + username + "]: " + message;

                byte[] buffer = fullMessage.getBytes();
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), PORT);
                socket.send(packet);
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
