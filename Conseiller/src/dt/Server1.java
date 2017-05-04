package dt;
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class Server1 {  
    public static void main(String[] args) throws Exception{  
        //服务端在20006端口监听客户端请求的TCP连接  
        ServerSocket server = new ServerSocket(20006);  
        Socket client = null;  
        boolean f = true;  
        while(f){  
            //等待客户端的连接，如果没有获取连接  
            client = server.accept();  
            System.out.println("Connextion réussi!");  
            //为每个客户端连接开启一个线程  
            new Thread(new SeverThread(client)).start();  
        }  
        server.close();  
    }  
}  