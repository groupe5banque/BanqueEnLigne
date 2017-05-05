package dt;
import java.io.BufferedInputStream;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
//import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;

import dt.Client;
import dt.Compte;
import dt.Historique;

public class Client1 {
	public static Object client1(String message, String id) throws UnknownHostException, IOException, ClassNotFoundException {
		// 客户端请求与本机在20006端口建立TCP连接

		Socket client = new Socket("127.0.0.1", 20006);
		client.setSoTimeout(10000);
		// 获取Socket的输出流，用来发送数据到服务端
		PrintStream out = new PrintStream(client.getOutputStream());
		// 获取Socket的输入流，用来接收从服务端发送过来的数据
		ObjectInputStream get = new ObjectInputStream(client.getInputStream());

		out.println(message);
		if(message.equals("UnClient")||message.equals("ListCompteClient")||message.equals("ListHisClient"))
		{
			out.println(id);
		}
		Object object = get.readObject();

		if (client != null) {
			// 如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，自然不用关闭
			client.close(); // 只关闭socket，其关联的输入输出流也会被关闭
		}
		return object;
	}

	public static void main(String[] args) {
		try {
			ArrayList<Historique> listC = (ArrayList<Historique>) client1("ListHisClient","1");
			System.out.println(listC.get(2).getNature());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Probleme");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	
	public static Object client2(String message, String email, String id) throws UnknownHostException, IOException, ClassNotFoundException {
		// 客户端请求与本机在20006端口建立TCP连接

		Socket client = new Socket("127.0.0.1", 20006);
		client.setSoTimeout(10000);
		// 获取Socket的输出流，用来发送数据到服务端
		PrintStream out = new PrintStream(client.getOutputStream());
		// 获取Socket的输入流，用来接收从服务端发送过来的数据
		ObjectInputStream get = new ObjectInputStream(client.getInputStream());

		out.println(message);
		if(message.equals("connexion"))
		{
			out.println(email);
			out.println(id);
		}
		Object object = get.readObject();

		if (client != null) {
			// 如果构造函数建立起了连接，则关闭套接字，如果没有建立起连接，自然不用关闭
			client.close(); // 只关闭socket，其关联的输入输出流也会被关闭
		}
		return object;
	}


}
