package rmiServer;
	import rmiService.Banquempl;
	import rmiService.IBanque;
	import java.rmi.Naming;
	import java.rmi.registry.LocateRegistry;

	public class BanqueServer {

	    public static void main(String[] args) {
	        try {
	            IBanque banqueService = new Banquempl();
	            LocateRegistry.createRegistry(1099);
	            Naming.rebind("rmi://localhost/BanqueService", banqueService);
	            System.out.println("Serveur prêt.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


