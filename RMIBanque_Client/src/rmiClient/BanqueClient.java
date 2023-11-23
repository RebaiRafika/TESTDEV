package rmiClient;


import rmiService.IBanque;
import metier.Compte;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            // Se connecter au registre RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099); // Mettez l'adresse IP ou le nom d'hôte du serveur

            // Chercher l'objet distant enregistré avec le nom spécifié dans le registre
            IBanque banque = (IBanque) registry.lookup("BanqueService");

            // Exemple : Créer un compte
            Compte nouveauCompte = new Compte(123, 1000.0, new Date());
            String resultatCreation = ((IBanque) banque).creerCompte(nouveauCompte);
            System.out.println("Résultat de la création du compte : " + resultatCreation);

            // Exemple : Obtenir des informations sur un compte
            int codeCompte = 123; // Code du compte à rechercher
            String infoCompte = banque.getInfoCompte(codeCompte);
            System.out.println("Informations sur le compte " + codeCompte + " : " + infoCompte);

            // Autres opérations avec le serveur RMI...

        } catch (Exception e) {
            System.err.println("Erreur client : " + e.toString());
            e.printStackTrace();
        }
    }

    }



