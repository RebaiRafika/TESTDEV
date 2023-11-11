package rmiSERVER;


import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import rmiService.IConversion;
    public class ConversionServer {
        public static void main (String[] args) throws RemoteException, RemoteException, NotBoundException{
            try {
                IConversion stub = (IConversion) Naming.lookup("rmi://localhost:1090/objectdistant");
                System.out.println(stub.convertirMontant(400.00));
                System.out.println( stub.convertirMontant(1200.00));

            }catch(Exception e) {
                e.printStackTrace();
            }

        }
    }



