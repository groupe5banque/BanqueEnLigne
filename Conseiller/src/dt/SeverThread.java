package dt;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;  
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;  
import java.net.Socket;  
import da.ClientDAO;
import da.CompteDAO;
import da.ConseillerDAO;
import da.HistoriqueDAO;
  
/** 
 * ¸ÃÀàÎª¶àÏß³ÌÀà£¬ÓÃÓÚ·þÎñ¶Ë 
 */  
public class SeverThread implements Runnable {  
  
    private Socket client = null;  
    public SeverThread(Socket client){  
        this.client = client;  
    }  
      
    @Override  
    public void run() {  
        try{  
            //»ñÈ¡SocketµÄÊä³öÁ÷£¬ÓÃÀ´Ïò¿Í»§¶Ë·¢ËÍÊý¾Ý  
        	ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());  
            //»ñÈ¡SocketµÄÊäÈëÁ÷£¬ÓÃÀ´½ÓÊÕ´Ó¿Í»§¶Ë·¢ËÍ¹ýÀ´µÄÊý¾Ý  
            BufferedReader get = new BufferedReader(new InputStreamReader(client.getInputStream())); 
            
            String message = get.readLine();
            System.out.println(message);
            //boolean flag =true;  
            /*while(flag){  
                //½ÓÊÕ´Ó¿Í»§¶Ë·¢ËÍ¹ýÀ´µÄÊý¾Ý  
                String str =  message.readLine();  
                if(str == null || "".equals(str)){  
                    flag = false;  
                }else{  
                    if("bye".equals(str)){  
                        flag = false;  
                    }else{  
                        //½«½ÓÊÕµ½µÄ×Ö·û´®Ç°Ãæ¼ÓÉÏecho£¬·¢ËÍµ½¶ÔÓ¦µÄ¿Í»§¶Ë  
                        out.println("echo:" + str);  
                    }  
                }  
            	
            }  */
            String id;
            String mail;
            String mdp;
            
            switch(message){
            
            case "ListClient": ClientDAO cd1 = new ClientDAO();
                               out.writeObject(cd1.getListClient());
                               System.out.println("sent");
                               break;
            case "ListCompte": CompteDAO comd = new CompteDAO();
                               out.writeObject(comd.getTousTCompte());
                               System.out.println("sent");
                               break;
            case "ListHis": HistoriqueDAO ch = new HistoriqueDAO();
                            out.writeObject(ch.getTousHistorique());
                            break;     
            case "UnClient": ClientDAO cd3 = new ClientDAO();
            				 id = get.readLine();
                             out.writeObject(cd3.getClient(Integer.parseInt(id)));
                             break;
            case "ListCompteClient": CompteDAO comd1 = new CompteDAO();
            						id = get.readLine();
                                    out.writeObject(comd1.getTousCompte(Integer.parseInt(id)));
                                    break;
            case "ListHisClient": HistoriqueDAO ch1 = new HistoriqueDAO();
                                  id = get.readLine();
                                  out.writeObject(ch1.getHistoriqueClient(Integer.parseInt(id)));
                                  break;
            case "connexion":   ConseillerDAO cd = new ConseillerDAO();
            					Conseiller c = new Conseiller();
					            mail = get.readLine();
					            mdp = get.readLine();
					            
					   		 System.out.println ("Client" +" "+mail+" "+"connecté  ... \n ");
							 
								c= cd.getConseillerByEmail(mail);
								if(c != null){
									
									if((!(c.getMotDePasseConseiller().equals(mdp)))){
										System.out.println("Identifiants erronés ...");
										
										out.writeObject("Identifiants erronés");
										out.flush();
									}
									
									else if((c.getMotDePasseConseiller().equals(mdp))){
										System.out.println("Identifiants corrects ...");
										out.writeObject("Identifiants corrects");
										out.flush();
									}
									}
									
									else {
									
									System.out.println("Identifiants erronés ...");
									
									out.writeObject("Identifiants erronés"); 
									out.flush();
									}
					            break;
                                 
                               
          /*  case "ListUnClient": ClientDAO cd2 = new ClientDAO();
                                BufferedReader id = new BufferedReader(new InputStreamReader(client.getInputStream())); 
            					out.writeObject(cd2.getListClient(Integer.id));
            					break;*/
            					                        
           
            }
            out.close();  
            System.out.println (" Serveur stoppé  ... \n ");
            client.close();  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
  
}  