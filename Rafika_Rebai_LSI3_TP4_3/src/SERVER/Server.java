package SERVER;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static final int PORT = 1234;
	private static final InetSocketAddress clientAddress = null;
    private List<InetSocketAddress> clients = new ArrayList<>();
	private String message;

    public static void main(String[] args) {
        new Server().startServer();
    }

    private void startServer() {
        try {
            @SuppressWarnings({ "resource", "unused" })
			DatagramSocket socket = new DatagramSocket(PORT);

            System.out.println("Serveur en attente sur le port " + PORT);

            while (true) {
                byte[] buffer = new byte[1024];
                @SuppressWarnings("unused")
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);


                // Diffuser le message à tous les clients
                broadcastMessage(message, clientAddress);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void broadcastMessage(String message, InetSocketAddress senderAddress) {
        for (InetSocketAddress client : clients) {
            // Ne pas envoyer le message à l'expéditeur
            if (!client.equals(senderAddress)) {
                sendMessage(message, client);
            }
        }
    }

    private void sendMessage(String message, InetSocketAddress client) {
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] buffer = message.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, client.getAddress(), client.getPort());
            socket.send(packet);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
