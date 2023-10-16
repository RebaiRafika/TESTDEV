package ClientPackage;

 import java.io.*;

import java.net.Socket;
import java.net.ServerSocket;
public class Client {
 public static void  main(String[] args)
{
try {
System.out.println("je suis un client encore connecte");  // Création d'un socket pour se connecter au serveur .
Socket socket1=new Socket("localhost",1234);// Création d'un socket pour se connecter au serveur .

OutputStream OTS=socket1.getOutputStream();      // Obtient un flux de sortie pour envoyer des données au serveur.
System.out.println("je suis un client  connecte");
int myNumber=23;// Déclarationd d'une variable myNumber.
}catch (IOException e)
{
e.printStackTrace();
}}}



