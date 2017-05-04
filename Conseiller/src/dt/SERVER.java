package dt;
import da.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;



public class SERVER {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
 ServerSocket socketserver ;
 Socket client;
 final BufferedReader in;
 final BufferedWriter pp;
 final PrintWriter out;
 final PrintWriter ou;
 ArrayList <String> con= new ArrayList <String> ();
ConseillerDAO cd = new ConseillerDAO();
 
 final Scanner sc = new Scanner (System.in);// Pour lire ï¿½ partir du clavier 
 

 try {
	 // Creer un socket serveur avec un numero de port 5000
	socketserver = new ServerSocket(5000);
	 // ecoutes pour une connexion a apporter a ce socket et l'accepte
	 client = socketserver.accept();
	 System.out.println (" Connection au serveur acceptée... "); 
	 
	 // Flux pour envoyer 
	 out = new PrintWriter(client.getOutputStream());
	 ou = new PrintWriter(client.getOutputStream());
	
	 in = new BufferedReader(new InputStreamReader(client.getInputStream()));
	 pp = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
	 
	 ObjectInputStream Pr = new ObjectInputStream(client.getInputStream());
	 
	ObjectOutputStream OUT = new ObjectOutputStream(client.getOutputStream());
	
	 System.out.println (" Connection Client effectuée... "); 
	 
	 /*
	  * Il faut creer deux processus (threads) parce que l'envoi et la reception se font simultanemant cela nous permet d'envoyer 
	  * et de recevoir des messages em meme temps
	  */
	
Thread envoyer = new Thread (new Runnable(){
  String msg ;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true){
			msg = sc.next();
			out.println(msg);
			out.flush();
		}
	}
	
});

envoyer.start();

Thread recevoir = new Thread (new Runnable(){
	
	  Object obj;
	  List s;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Conseiller c = new Conseiller();
			
			try {
				
				obj = Pr.readObject();
				s = (List) obj;
			
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			 System.out.println ("Client" +" "+s.get(0)+" "+"connecté  ... \n ");
			 
				c= cd.getConseillerByEmail((String)s.get(0));

				if(c != null){
			
				if((!(c.getMotDePasseConseiller().equals((String)s.get(1))))){
					System.out.println("Identifiants erronés ...");
					
					out.println("Identifiants erronés");
					out.flush();
				}
				
				else if((c.getMotDePasseConseiller().equals((String)s.get(1)))){
					System.out.println("Identifiants corrects ...");
					out.println("Identifiants corrects");
					out.flush();
				}
				}
				
				else {System.out.println("Identifiants erronés ...");
				
				out.println("Identifiants erronés");
				out.flush();}

				
				 String message;
				 
				try {
					
							
					message = in.readLine();
					System.out.println(message);
					
					String id;
		            switch(message){
		            
		            case "ListClient": ClientDAO cd1 = new ClientDAO();
		                               OUT.writeObject(cd1.getListClient());
		                               System.out.println("sent");
		                               break;
		            case "ListCompte": CompteDAO comd = new CompteDAO();
		                               OUT.writeObject(comd.getTousTCompte());
		                               System.out.println("sent");
		            case "ListHis": HistoriqueDAO ch = new HistoriqueDAO();
		                            OUT.writeObject(ch.getTousHistorique());
		                            break;     
		            case "UnClient": ClientDAO cd3 = new ClientDAO();
		            				 id = in.readLine();
		                             OUT.writeObject(cd3.getClient(Integer.parseInt(id)));
		                             break;
		            case "ListCompteClient": CompteDAO comd1 = new CompteDAO();
		            						id = in.readLine();
		                                    OUT.writeObject(comd1.getTousCompte(Integer.parseInt(id)));
		                                    break;
		            case "ListHisClient": HistoriqueDAO ch1 = new HistoriqueDAO();
		                                  id = in.readLine();
		                                 OUT.writeObject(ch1.getHistoriqueClient(Integer.parseInt(id)));
		                                  break;
		}
					 
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				 
		}
		
	});
recevoir.start();

	

} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

 System.out.println (" Serveur stoppé  ... \n ");
 
	}

}
