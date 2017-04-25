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
public class CompteDAO {

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
	public CompteDAO() {
		// chargement du pilote de bases de donn茅鈥旓拷忙鈥犫��
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}
	
	/**
	 * 
	 * 
	 * Permet de avoir la list de tous les comptes courant d'un client.
	 * 	
	 */
	public ArrayList<Compte> getCompteCourant(int IdClient){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList c = new ArrayList<Integer>();
		Compte compte = new Compte();
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			ps = con.prepareStatement("SELECT * FROM compte WHERE idClient_Compte = ? AND typeCompte = ?");
            
			ps.setInt(1, IdClient);
			ps.setString(2, "compte courant" );
			// on ex茅鈥旓拷氓录鈥搕e la requ茅鈥斊捗封偓
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥旓拷莽鈥灺╨tat
			while (rs.next())
			{
			compte = new Compte(rs.getInt("IdClient_Compte"),rs.getInt("codeGuichet"),rs.getString("numeroDeCompte"),rs.getInt("clefRib"),rs.getInt("codeBanque"),rs.getString("soldeBanque"),rs.getString("typeCompte"));	
            c.add(compte);}
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
		return c;

	}
	
	/**
	 * 
	 * 
	 * Permet de avoir la list de tous les comptes 猫艗鈥argne d'un client.
	 * 	
	 */
	public ArrayList<Compte> getCompteEpargne(int IdClient){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList c = new ArrayList<Integer>();
		Compte compte = new Compte();
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			ps = con.prepareStatement("SELECT * FROM compte WHERE idClient_Compte = ? AND typeCompte = ?");
            
			ps.setInt(1, IdClient);
			ps.setString(2, "compte epargne" );
			// on ex茅鈥旓拷氓录鈥搕e la requ茅鈥斊捗封偓
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥旓拷莽鈥灺╨tat
			while (rs.next())
			{
			compte = new Compte(rs.getInt("IdClient_Compte"),rs.getInt("codeGuichet"),rs.getString("numeroDeCompte"),rs.getInt("clefRib"),rs.getInt("codeBanque"),rs.getString("soldeBanque"),rs.getString("typeCompte"));	
            c.add(compte);
			}
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
		return c;

	}
	
	/**
	 * 
	 * 
	 * Permet de avoir la list de tous les comptes 猫艗鈥argne d'un client.
	 * 	
	 */
	public ArrayList<Compte> getCompteTitre(int IdClient){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList c = new ArrayList<Integer>();
		Compte compte = null;
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			ps = con.prepareStatement("SELECT * FROM compte WHERE idClient_Compte = ? AND typeCompte = ?");
            
			ps.setInt(1, IdClient);
			ps.setString(2, "compte titre" );
			// on ex茅鈥旓拷氓录鈥搕e la requ茅鈥斊捗封偓
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥旓拷莽鈥灺╨tat
			while (rs.next())
			{compte = new Compte(rs.getInt("IdClient_Compte"),rs.getInt("codeGuichet"),rs.getString("numeroDeCompte"),rs.getInt("clefRib"),rs.getInt("codeBanque"),rs.getString("soldeBanque"),rs.getString("typeCompte"));	
            c.add(compte);
			}
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
		return c;

	}
	
	public Double soldeTotalCompte(int IdClient)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		double soldeT = 0;
		Compte compte = new Compte();
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			System.out.println("Connected database successfully...");
			ps = con.prepareStatement("SELECT * FROM compte WHERE idClient_Compte = ?");
            
			ps.setInt(1, IdClient);
			// on ex茅鈥旓拷氓录鈥搕e la requ茅鈥斊捗封偓
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥旓拷莽鈥灺╨tat
			while (rs.next())
			{
				
				soldeT = soldeT+ Double.parseDouble(rs.getString("soldeBanque"));
			}
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
		return soldeT;
	}
	
	/**
	 * 
	 * 
	 * Permet de avoir la list de tous les comptes d'un client.
	 * 	
	 */
	public ArrayList<Compte> getTousCompte(int IdClient){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList c = new ArrayList<Integer>();
		Compte compte = new Compte();
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM compte WHERE idClient_Compte = ?");
            
			ps.setInt(1, IdClient);
			// on ex茅鈥旓拷氓录鈥搕e la requ茅鈥斊捗封偓
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥旓拷莽鈥灺╨tat
			while (rs.next())
			{
				compte = new Compte(rs.getInt("IdClient_Compte"),rs.getInt("codeGuichet"),rs.getString("numeroDeCompte"),rs.getInt("clefRib"),rs.getInt("codeBanque"),rs.getString("soldeBanque"),rs.getString("typeCompte"));	
				c.add(compte);
			}
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
		return c;

	}
	
	public Double soldeTotalCompteC(int IdClient)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		double soldeT = 0;
		Compte compte = new Compte();
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			System.out.println("Connected database successfully...");
			ps = con.prepareStatement("SELECT * FROM compte WHERE idClient_Compte = ? AND typeCompte = ?");
            
			ps.setInt(1, IdClient);
			ps.setString(2, "courant");
			// on ex茅鈥旓拷氓录鈥搕e la requ茅鈥斊捗封偓
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥旓拷莽鈥灺╨tat
			while (rs.next())
			{				
				soldeT = soldeT+ Double.parseDouble(rs.getString("soldeBanque"));
			}
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
		return soldeT;
	}
	/**
	 * fonction pour calculer le solde total d'un type de compte
	 * @param c
	 * @return solde totale
	 */
	 public double soldeTotal(ArrayList<Compte> c)
	 {
		double totalCompte = 0;
	    for (int i=0; i<c.size(); i++)
	    {           
	        double soldeCompte = Double.parseDouble(c.get(i).getSoldeBanque());
	        totalCompte = totalCompte + soldeCompte;          
	    }
	    return totalCompte;
	  }
	 
		
	 public Compte getCompteChoisi(int IdCompte){
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Compte c = null;
			Compte compte = new Compte();
			try {

				con = DriverManager.getConnection(URL, LOGIN, PASS);
				
				ps = con.prepareStatement("SELECT * FROM compte WHERE idCompte = ?");
	            
				ps.setInt(1, IdCompte);
				
				// on ex闁弖te la requ闃緀
				rs = ps.executeQuery();
				// on parcourt les lignes du r闁焨ltat
				if (rs.next())
				{
				    c = new Compte(rs.getInt("idClient_Compte"), rs.getInt("codeGuichet"), rs.getString("numeroDeCompte"), rs.getInt("clefRIB"), rs.getInt("codeBanque"), rs.getString("soldeBanque"),rs.getString("typeCompte"));
				}
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
			return c;

		}
	

	/**
	 * Permet d'ajouter un client dans la table client Le mode est auto-commit
	 * par d茅鈥旓拷忙艩鈥箄t : chaque insertion est valid茅鈥旓拷茂驴陆
	 * 
	 * @param Client
	 *            Client 茅鈥澟该柯� ajouter
	 * @return retourne le nombre de lignes ajout茅鈥旓拷忙鈥犫�� dans la table
	 */
	public int ajouter(Compte compte) {
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
			ps = con.prepareStatement("INSERT INTO compte ( idClient_Compte, codeGuichet,numeroDeCompte,clefRIB,codeBanque, soldeBanque,typeCompte) VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, compte.getIdClient());
			ps.setInt(2, compte.getCodeGuichet());
			ps.setString(3, compte.getNumeroDeCompte());
			ps.setInt(4,compte.getClefRIB());
			ps.setInt(5, compte.getCodeBanque());
			ps.setString(6, compte.getSoldeBanque());
			ps.setString(7, compte.getTypeCompte());
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
	public List<Compte> getListeCompte(int identifiant) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Compte> retour = new ArrayList<Compte>();

		// connexion 猫艗鈥毭┞┞疵┾劉鈥� la base de donn猫艗鈥γ┧喡ッ︹�櫬柯矫ββ�
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM compte WHERE  idClient_Compte= ?");
			ps.setInt(1, identifiant);
			// on ex猫艗鈥γ┧喡ッ︹�溾�灻︹�孤穟te la requ猫艗鈥γㄢ�斅疵λ喡甧
			rs = ps.executeQuery();
			// on parcourt les lignes du r猫艗鈥γ┧喡ッ︹�欌�犆╨tat
			while (rs.next())
				retour.add(new Compte(rs.getInt("idClient_Compte"), rs.getInt("codeGuichet"),rs
						.getString("numeroDeCompte"),rs.getInt("clefRIB"),rs.getInt("codeBanque"),rs.getString("soldeBanque"),rs.getString("typeCompte")));

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

	public int getCompteId(String numero){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		// connexion 猫鈥灺� la base de donn猫艗鈥s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idCompte FROM compte  WHERE numeroDeCompte = ? ");
			ps.setString(1,numero );
			
            
			// on ex猫鈥炩劉忙录锟絚ute la requ茅鈥澟e
			// rs contient un pointeur situ猫鈥炩劉忙录锟� juste avant la premi莽艗芦re ligne
			// retourn猫艗鈥�
			rs = ps.executeQuery();
			// passe 猫鈥炩劉猫锟铰� la premi猫鈥炩劉莽炉鈥渞e (et unique) ligne retourn猫鈥炩劉忙录锟絜
			if (rs.next())
				retour =rs.getInt("idCompte");

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

		
	}

	public int getIdCompte(String numero){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		// connexion 猫鈥灺� la base de donn猫艗鈥s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idCompte FROM compte  WHERE numeroDeCompte = ? ");
			ps.setString(1,numero );
			
            
			// on ex猫鈥炩劉忙录锟絚ute la requ茅鈥澟e
			// rs contient un pointeur situ猫鈥炩劉忙录锟� juste avant la premi莽艗芦re ligne
			// retourn猫艗鈥�
			rs = ps.executeQuery();
			// passe 猫鈥炩劉猫锟铰� la premi猫鈥炩劉莽炉鈥渞e (et unique) ligne retourn猫鈥炩劉忙录锟絜
			if (rs.next())
				retour =rs.getInt("idCompte");

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

		
	}
	public int setSoldeCompte( String numeroCompte, String montantS)
	 {
		
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
					ps = con.prepareStatement("UPDATE compte SET soldeBanque = ? WHERE numeroDeCompte = ? ");
					ps.setString(1, montantS);
					ps.setString(2, numeroCompte);
					
					
				retour = ps.executeUpdate();
               retour = 1;
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
	
	public Compte getCompteNumero(String numeroDeCompte) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Compte compte = null;
		
		// connexion 猫鈥灺� la base de donn猫艗鈥s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM compte WHERE numeroDeCompte = ?");
			ps.setString(1, numeroDeCompte);

			// on ex猫艗鈥ute la requ茅鈥澟e
			// rs contient un pointeur situ猫艗鈥� juste avant la premi莽艗芦re ligne
			// retourn猫艗鈥
			rs = ps.executeQuery();
			// passe 猫鈥灺� la premi莽艗芦re (et unique) ligne retourn猫艗鈥
			if (rs.next())
				compte = new Compte(rs.getInt("idClient_Compte"),rs.getInt("codeGuichet"),
						rs.getString("numeroDeCompte"),rs.getInt("clefRib"),rs.getInt("codeBanque"),
						rs.getString("soldeBanque"),rs.getString("typeCompte"));

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
		return compte;

	}
	public Compte getCompte(int idClient) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Compte compte = null;
		
		// connexion 猫鈥灺� la base de donn猫艗鈥s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM compte WHERE idClient_Compte = ?");
			ps.setInt(1, idClient);

			// on ex猫艗鈥ute la requ茅鈥澟e
			// rs contient un pointeur situ猫艗鈥� juste avant la premi莽艗芦re ligne
			// retourn猫艗鈥
			rs = ps.executeQuery();
			// passe 猫鈥灺� la premi莽艗芦re (et unique) ligne retourn猫艗鈥
			if (rs.next())
				compte = new Compte(rs.getInt("idClient_Compte"),rs.getInt("codeGuichet"),
						rs.getString("numeroDeCompte"),rs.getInt("clefRib"),rs.getInt("codeBanque"),
						rs.getString("soldeBanque"),rs.getString("typeCompte"));

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
		return compte;

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
