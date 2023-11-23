package rmiService;

import metier.Compte;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Banquempl extends UnicastRemoteObject implements IBanque {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Banquempl() throws RemoteException {
        super();
    }

    @SuppressWarnings("exports")
	@Override
    public String creerCompte(Compte c) throws RemoteException {
        // Logique pour créer un compte
        return "Compte créé avec succès!";
    }

    @Override
    public String getInfoCompte(int code) throws RemoteException {
        // Logique pour obtenir les informations d'un compte
        return "Informations du compte " + code;
    }
}



