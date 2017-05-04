package dt;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import dt.*;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
public class Essaie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket;
		 final BufferedReader in;
		 final PrintWriter out;
		 final PrintWriter out1;
		 final Scanner sc = new Scanner (System.in);// Pour lire à partir du clavier 
		
		 try {
			 /*
			  * Contenant les informations du serveur (port et adresse IP ou nom d'hote)
			  * 127.0.0.1 address local
			  */
			
			
			 socket = new Socket("127.0.0.1", 5000);
			 
			
			 
			 // Flux pour envoyer 
			 out = new PrintWriter(socket.getOutputStream());
			 out1 = new PrintWriter(socket.getOutputStream());
			 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 ObjectOutputStream ou = new ObjectOutputStream(socket.getOutputStream());
	
			 /*
			  * Il faut creer deux processus (threads) parce que l'envoi et la reception se font simultanemant cela nous permet d'envoyer 
			  * et de recevoir des messages em meme temps
			  */
		Thread envoyer = new Thread (new Runnable(){
		  String msg ;
		  String msg1 ;
		  Client c;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				
				c= new  Client("ASSOGBA","Prisca","Femme", "prisca.assogba@yahoo.fr","septembre","Prisca","Beninoise","Compte epargne",234,"30 rue",12,"Roune","France");
				
				try {
					ou.writeObject(c);
					ou.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
					try {
						socket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			
				/*out.println(c);	
					out.flush();*/
				
			}
			
		});

		envoyer.start();
		Thread recevoir = new Thread (new Runnable(){
			  String msg ;
				@Override
				public void run() {
					// TODO Auto-generated method stub
					while (true){
						try {
							msg = in.readLine();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("Serveur :  "+msg);
						
					}
				}
				
			});
		recevoir.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
