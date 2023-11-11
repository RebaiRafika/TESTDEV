
	package rmiClient;
	import java.net.MalformedURLException;
	import java.rmi.Naming;
	import java.rmi.NotBoundException;
	import java.rmi.RemoteException;

	import rmiService.IConversion;

	    public class ConversionClient {

	        public static void main(String[] args) throws MalformedURLException,RemoteException,NotBoundException {
	            try {
	                IConversion stub = (IConversion) Naming.lookup("rmi://localhost:1099/objectdistant");
	                System.out.println(stub.convertirMontant(700.00));
	                System.out.println( stub.convertirMontant(1500.00));

	            }catch(Exception e) {
	                e.printStackTrace();
	            }
	        }

	    }





