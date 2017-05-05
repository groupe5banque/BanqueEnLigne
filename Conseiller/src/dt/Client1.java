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
		// �ͻ��������뱾����20006�˿ڽ���TCP����

		Socket client = new Socket("127.0.0.1", 20006);
		client.setSoTimeout(10000);
		// ��ȡSocket��������������������ݵ������
		PrintStream out = new PrintStream(client.getOutputStream());
		// ��ȡSocket�����������������մӷ���˷��͹���������
		ObjectInputStream get = new ObjectInputStream(client.getInputStream());

		out.println(message);
		if(message.equals("UnClient")||message.equals("ListCompteClient")||message.equals("ListHisClient"))
		{
			out.println(id);
		}
		Object object = get.readObject();

		if (client != null) {
			// ������캯�������������ӣ���ر��׽��֣����û�н��������ӣ���Ȼ���ùر�
			client.close(); // ֻ�ر�socket������������������Ҳ�ᱻ�ر�
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
		// �ͻ��������뱾����20006�˿ڽ���TCP����

		Socket client = new Socket("127.0.0.1", 20006);
		client.setSoTimeout(10000);
		// ��ȡSocket��������������������ݵ������
		PrintStream out = new PrintStream(client.getOutputStream());
		// ��ȡSocket�����������������մӷ���˷��͹���������
		ObjectInputStream get = new ObjectInputStream(client.getInputStream());

		out.println(message);
		if(message.equals("connexion"))
		{
			out.println(email);
			out.println(id);
		}
		Object object = get.readObject();

		if (client != null) {
			// ������캯�������������ӣ���ر��׽��֣����û�н��������ӣ���Ȼ���ùر�
			client.close(); // ֻ�ر�socket������������������Ҳ�ᱻ�ر�
		}
		return object;
	}


}
