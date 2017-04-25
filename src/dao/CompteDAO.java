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
 * Classe d'acc閼� aux donn闁憇 contenues dans la table client
 * 
 * @author Prisca - Hornela
 * @version 1.2
 * */
public class CompteDAO {

	/**
	 * Param閼es de connexion 锟� la base de donn闁憇 oracle URL, LOGIN et PASS
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
		// chargement du pilote de bases de donn闁憇
		
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
			// on ex闁弖te la requ闃緀
			rs = ps.executeQuery();
			// on parcourt les lignes du r闁焨ltat
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
	 * Permet de avoir la list de tous les comptes 茅pargne d'un client.
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
			// on ex闁弖te la requ闃緀
			rs = ps.executeQuery();
			// on parcourt les lignes du r闁焨ltat
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
	 * Permet de avoir la list de tous les comptes 茅pargne d'un client.
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
			// on ex闁弖te la requ闃緀
			rs = ps.executeQuery();
			// on parcourt les lignes du r闁焨ltat
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
	
	/**
	 * 
	 * 
	 * Permet de avoir la list de tous les comptes 茅pargne d'un client.
	 * 	
	 */
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
			// on ex闁弖te la requ闃緀
			rs = ps.executeQuery();
			// on parcourt les lignes du r闁焨ltat
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
			// on ex闁弖te la requ闃緀
			rs = ps.executeQuery();
			// on parcourt les lignes du r闁焨ltat
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
			// on ex闁弖te la requ闃緀
			rs = ps.executeQuery();
			// on parcourt les lignes du r闁焨ltat
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
	 
		
	
	

	/**
	 * Permet d'ajouter un client dans la table client Le mode est auto-commit
	 * par d闁抋ut : chaque insertion est valid闁�
	 * 
	 * @param Client
	 *            Client 锟� ajouter
	 * @return retourne le nombre de lignes ajout闁憇 dans la table
	 */
	public int ajouter(Compte compte) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion 锟� la base de donn闁憇
		try {
			
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pr闁渁ration de l'instruction SQL, chaque ? repr闁焑nte une valeur
			// 锟� communiquer dans l'insertion
			// les getters permettent de r闁弖p闁瀍r les valeurs des attributs
			// souhait闁�
			ps = con.prepareStatement("INSERT INTO compte ( idClient_Compte, codeGuichet,numeroDeCompte,clefRIB,codeBanque, soldeBanque,typeCompte) VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, compte.getIdClient());
			ps.setInt(2, compte.getCodeGuichet());
			ps.setString(3, compte.getNumeroDeCompte());
			ps.setInt(4,compte.getClefRIB());
			ps.setInt(5, compte.getCodeBanque());
			ps.setString(6, compte.getSoldeBanque());
			ps.setString(7, compte.getTypeCompte());
			// Ex闁弖tion de la requ闃緀
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

		// connexion 茂驴陆 la base de donn茅鈥撯�榮
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM compte WHERE  idClient_Compte= ?");
			ps.setInt(1, identifiant);
			// on ex茅鈥擄拷ute la requ茅藴戮e
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥撆竨ltat
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

		// connexion 脿 la base de donn茅es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idCompte FROM compte  WHERE numeroDeCompte = ? ");
			ps.setString(1,numero );
			
            
			// on ex脙漏cute la requ锚te
			// rs contient un pointeur situ脙漏 juste avant la premi猫re ligne
			// retourn茅
			rs = ps.executeQuery();
			// passe 脙聽 la premi脙篓re (et unique) ligne retourn脙漏e
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

		// connexion 脿 la base de donn茅es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idCompte FROM compte  WHERE numeroDeCompte = ? ");
			ps.setString(1,numero );
			
            
			// on ex脙漏cute la requ锚te
			// rs contient un pointeur situ脙漏 juste avant la premi猫re ligne
			// retourn茅
			rs = ps.executeQuery();
			// passe 脙聽 la premi脙篓re (et unique) ligne retourn脙漏e
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

				// connexion 锟� la base de donn闁憇
				try {
					
					//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
					
					// tentative de connexion
					con = DriverManager.getConnection(URL, LOGIN, PASS);
					// pr闁渁ration de l'instruction SQL, chaque ? repr闁焑nte une valeur
					// 锟� communiquer dans l'insertion
					// les getters permettent de r闁弖p闁瀍r les valeurs des attributs
					// souhait闁�
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
		
		// connexion 脿 la base de donn茅es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM compte WHERE numeroDeCompte = ?");
			ps.setString(1, numeroDeCompte);

			// on ex茅cute la requ锚te
			// rs contient un pointeur situ茅 juste avant la premi猫re ligne
			// retourn茅e
			rs = ps.executeQuery();
			// passe 脿 la premi猫re (et unique) ligne retourn茅e
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
		
		// connexion 脿 la base de donn茅es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM compte WHERE idClient_Compte = ?");
			ps.setInt(1, idClient);

			// on ex茅cute la requ锚te
			// rs contient un pointeur situ茅 juste avant la premi猫re ligne
			// retourn茅e
			rs = ps.executeQuery();
			// passe 脿 la premi猫re (et unique) ligne retourn茅e
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
	 * Permet de r闁弖p闁瀍r un client 锟� partir de son identifiant
	 * 
	 * @param idClient
	 *            le numero du client   r cup rer 
	 * @return 	le client  trouv锟�;
	 * 			null si aucun client ne correspond 锟� cet identifiant
	 */
/*	public Client getClient(int idClient) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client retour = null;

		// connexion 锟� la base de donn闁憇
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE IdClient = ?");
			ps.setInt(1, idClient);

			// on ex闁弖te la requ闃緀
			// rs contient un pointeur situ锟� juste avant la premi閼 ligne
			// retourn闁�
			rs = ps.executeQuery();
			// passe 锟� la premi閼 (et unique) ligne retourn闁�
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

		// connexion 锟� la base de donn闁憇
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE  FROM Client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on ex闁弖te la requ闃緀
			// rs contient un pointeur situ锟� juste avant la premi閼 ligne
			// retourn闁�
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

			// on ex闁弖te la requ闃緀
			rs = ps.executeQuery();
			// on parcourt les lignes du r闁焨ltat
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
	 * Permet de r闁弖p闁瀍r tous les clients stock闁� dans la table client
	 * 
	 * @return une ArrayList de clients
	 */
	/*public List<Client> getListeClient() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Client> retour = new ArrayList<Client>();

		// connexion 锟� la base de donn闁憇
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client");

			// on ex闁弖te la requ闃緀
			rs = ps.executeQuery();
			// on parcourt les lignes du r闁焨ltat
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
		// test de la m闁爃ode ajouter
	     Code c1 = new Code( "Venezuela", NumeroCompte,clef);
		int retour = codeDAO.ajouter(c1);

		System.out.println(retour + " lignes ajout闁憇");
		
		// test de la m闁爃ode deleteClient
			//int r  = clientDAO.deleteClient(4);
			//System.out.println(r);
		  // ArrayList bbbb =new ArrayList<Integer>();
		//  System.out.println(bbbb=clientDAO.idClient());
			// test de la m闁爃ode getListeArticles
			/*List<Article> liste = articleDAO.getListeArticles();
			// affichage des articles
		for (Article art : liste) {
				System.out.println(art.toString());
			}
	}*/
	/*public static void main(String[] args){
		CompteDAO cd = new CompteDAO();
		System.out.print(cd.getCompteChoisi(1).getNumeroDeCompte());
		
		
	}*/
}
