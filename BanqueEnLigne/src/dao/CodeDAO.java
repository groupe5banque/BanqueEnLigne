package dao;



import dto.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.Box;

import java.util.List;
import java.util.Date;

/**
 * Classe d'acc茅鈥撀济柯� aux donn茅鈥旓拷忙鈥犫�� contenues dans la table client
 * 
 * @author Prisca - Hornela
 * @version 1.2
 * */
public class CodeDAO {

	/**
	 * Param茅鈥撀济溗渆s de connexion 茅鈥澟该柯� la base de donn茅鈥旓拷忙鈥犫�� oracle URL, LOGIN et PASS
	 * sont des constantes
	 */
	
	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root";  //exemple BDD1
	final static String PASS = "root";   //exemple BDD1

	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public CodeDAO() {
		// chargement du pilote de bases de donn茅鈥旓拷忙鈥犫��
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un client dans la table client Le mode est auto-commit
	 * par d茅鈥旓拷忙艩鈥箄t : chaque insertion est valid茅鈥旓拷茂驴陆
	 * 
	 * @param Client
	 *            Client 茅鈥澟该柯� ajouter
	 * @return retourne le nombre de lignes ajout茅鈥旓拷忙鈥犫�� dans la table
	 */
	public int ajouter(Code code) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion 茅鈥澟该柯� la base de donn茅鈥旓拷忙鈥犫��
		try {
			
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pr茅鈥旓拷忙赂锟絩ation de l'instruction SQL, chaque ? repr茅鈥旓拷莽鈥炩�榥te une valeur
			// 茅鈥澟该柯� communiquer dans l'insertion
			// les getters permettent de r茅鈥旓拷氓录鈥損茅鈥旓拷莽鈧拷r les valeurs des attributs
			// souhait茅鈥旓拷茂驴陆
			ps = con.prepareStatement("INSERT INTO code (pays,codeGuichet, clefRib) VALUES (?,?,?)");
			ps.setString(1, code.getPays());
			ps.setString(2, code.getCodeGuichet());
			ps.setString(3, code.getClefRib());
			// Ex茅鈥旓拷氓录鈥搕ion de la requ茅鈥斊捗封偓
			retour = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}
	
	public Code getCode(String pays) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Code co = null;
		
		// connexion 猫鈥灺� la base de donn猫艗鈥s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM code WHERE pays = ?");
			ps.setString(1, pays);

			// on ex猫艗鈥ute la requ茅鈥澟e
			// rs contient un pointeur situ猫艗鈥� juste avant la premi莽艗芦re ligne
			// retourn猫艗鈥
			rs = ps.executeQuery();
			// passe 猫鈥灺� la premi莽艗芦re (et unique) ligne retourn猫艗鈥
			if (rs.next())
				co = new Code(rs.getString("pays"),
						rs.getString("codeGuichet"),rs.getString("clefRib"));

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return co;

	}

	/**
	 * Permet de r茅鈥旓拷氓录鈥損茅鈥旓拷莽鈧拷r un client 茅鈥澟该柯� partir de son identifiant
	 * 
	 * @param idClient
	 *            le numero du client   r cup rer 
	 * @return 	le client  trouv茅鈥澟该柯�;
	 * 			null si aucun client ne correspond 茅鈥澟该柯� cet identifiant
	 */
/*	public Client getClient(int idClient) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client retour = null;

		// connexion 茅鈥澟该柯� la base de donn茅鈥旓拷忙鈥犫��
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE IdClient = ?");
			ps.setInt(1, idClient);

			// on ex茅鈥旓拷氓录鈥搕e la requ茅鈥斊捗封偓
			// rs contient un pointeur situ茅鈥澟该柯� juste avant la premi茅鈥撀济�⑩�� ligne
			// retourn茅鈥旓拷茂驴陆
			rs = ps.executeQuery();
			// passe 茅鈥澟该柯� la premi茅鈥撀济�⑩�� (et unique) ligne retourn茅鈥旓拷茂驴陆
			if (rs.next())
				retour = new Client(rs.getInt("idClient"),
						rs.getString("civiliteClient"),
						rs.getString("dateNaissanceClient"));

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}*/
	/*public int deleteClient(int idClient) {

		Connection con = null;
		PreparedStatement ps = null;
		
		int  retour = 0;

		// connexion 茅鈥澟该柯� la base de donn茅鈥旓拷忙鈥犫��
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE  FROM Client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on ex茅鈥旓拷氓录鈥搕e la requ茅鈥斊捗封偓
			// rs contient un pointeur situ茅鈥澟该柯� juste avant la premi茅鈥撀济�⑩�� ligne
			// retourn茅鈥旓拷茂驴陆
			retour = ps.executeUpdate();
			

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}*/
	/**
	 * 
	 * 
	 * permet d'alligner les identifiants pr sents dans la table clients 
	 * 	
	 */
	/*public ArrayList idClient(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList retour = new ArrayList<Integer>();
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT IdClient FROM client");

			// on ex茅鈥旓拷氓录鈥搕e la requ茅鈥斊捗封偓
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥旓拷莽鈥灺╨tat
			while (rs.next())
				retour.add( rs.getInt("IdClient"));

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}
	*/
	/**
	 * Permet de r茅鈥旓拷氓录鈥損茅鈥旓拷莽鈧拷r tous les clients stock茅鈥旓拷茂驴陆 dans la table client
	 * 
	 * @return une ArrayList de clients
	 */
	/*public List<Client> getListeClient() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Client> retour = new ArrayList<Client>();

		// connexion 茅鈥澟该柯� la base de donn茅鈥旓拷忙鈥犫��
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client");

			// on ex茅鈥旓拷氓录鈥搕e la requ茅鈥斊捗封偓
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥旓拷莽鈥灺╨tat
			while (rs.next())
				retour.add(new Client(rs.getInt("IdClient"), rs
						.getString("Civilite"), rs
						.getString("Nom")));

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return retour;

	}*/

	
	// main permettant de tester la classe
	/*public static void main(String[] args) throws SQLException{
		String[] array = new String[]{"1","2","3","4","5","6","7","8","9"};
		Random rand = new Random();
		String NumeroCompte = null;
		String clef = null;
		 for (int i =1; i <6; i++)
		 {
			
			 
		
			if (i !=1)
			{
				NumeroCompte=NumeroCompte+array[rand.nextInt(array.length)];
			}
			else 
				NumeroCompte=array[rand.nextInt(array.length)];
			 
		 }
		 for (int i =1; i <3; i++)
		 {
			
			 
		
			if (i !=1)
			{
				clef=clef+array[rand.nextInt(array.length)];
			}
			else 
				clef=array[rand.nextInt(array.length)];
			 
		 }
		CodeDAO codeDAO = new CodeDAO();
		// test de la m茅鈥旓拷莽藛茠ode ajouter
	     Code c1 = new Code( "Venezuela", NumeroCompte,clef);
		int retour = codeDAO.ajouter(c1);

		System.out.println(retour + " lignes ajout茅鈥旓拷忙鈥犫��");
		
		// test de la m茅鈥旓拷莽藛茠ode deleteClient
			//int r  = clientDAO.deleteClient(4);
			//System.out.println(r);
		  // ArrayList bbbb =new ArrayList<Integer>();
		//  System.out.println(bbbb=clientDAO.idClient());
			// test de la m茅鈥旓拷莽藛茠ode getListeArticles
			/*List<Article> liste = articleDAO.getListeArticles();
			// affichage des articles
		for (Article art : liste) {
				System.out.println(art.toString());
			}
	}*/
}
