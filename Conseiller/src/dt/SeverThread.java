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
import da.HistoriqueDAO;
  
/** 
 * 该类为多线程类，用于服务端 
 */  
public class SeverThread implements Runnable {  
  
    private Socket client = null;  
    public SeverThread(Socket client){  
        this.client = client;  
    }  
      
    @Override  
    public void run() {  
        try{  
            //获取Socket的输出流，用来向客户端发送数据  
        	ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());  
            //获取Socket的输入流，用来接收从客户端发送过来的数据  
            BufferedReader get = new BufferedReader(new InputStreamReader(client.getInputStream())); 
            
            String message = get.readLine();
            System.out.println(message);
            //boolean flag =true;  
            /*while(flag){  
                //接收从客户端发送过来的数据  
                String str =  message.readLine();  
                if(str == null || "".equals(str)){  
                    flag = false;  
                }else{  
                    if("bye".equals(str)){  
                        flag = false;  
                    }else{  
                        //将接收到的字符串前面加上echo，发送到对应的客户端  
                        out.println("echo:" + str);  
                    }  
                }  
            	
            }  */
            String id;
            switch(message){
            
            case "ListClient": ClientDAO cd1 = new ClientDAO();
                               out.writeObject(cd1.getListClient());
                               System.out.println("sent");
                               break;
            case "ListCompte": CompteDAO comd = new CompteDAO();
                               out.writeObject(comd.getTousTCompte());
                               System.out.println("sent");
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
            
                                 
                               
          /*  case "ListUnClient": ClientDAO cd2 = new ClientDAO();
                                BufferedReader id = new BufferedReader(new InputStreamReader(client.getInputStream())); 
            					out.writeObject(cd2.getListClient(Integer.id));
            					break;*/
            					
            
                                 
           
            }
            out.close();  
            client.close();  
        }catch(Exception e){  
            e.printStackTrace();  
        }  
    }  
  
}  