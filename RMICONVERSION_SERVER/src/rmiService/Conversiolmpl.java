package rmiService;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

    @SuppressWarnings("serial")
    public  class Conversiolmpl extends UnicastRemoteObject   implements IConversion{




        public Conversiolmpl() throws RemoteException {
            super();
            // TODO Auto-generated constructor stub
        }

        public double convertirMontant(double mt) throws RemoteException {
            double tauxConversion = 0.85;
            return mt * tauxConversion;

        }

    }


