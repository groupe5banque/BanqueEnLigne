package dt;
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class Server1 {  
    public static void main(String[] args) throws Exception{  
        //�������20006�˿ڼ����ͻ��������TCP����  
        ServerSocket server = new ServerSocket(20006);  
        Socket client = null;  
        boolean f = true;  
        while(f){  
            //�ȴ��ͻ��˵����ӣ����û�л�ȡ����  
            client = server.accept();  
            System.out.println("Connextion r��ussi!");  
            //Ϊÿ���ͻ������ӿ���һ���߳�  
            new Thread(new SeverThread(client)).start();  
        }  
        server.close();  
    }  
}  