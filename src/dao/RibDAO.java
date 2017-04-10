package dao;

import dto.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
public class RibDAO {

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
	public RibDAO() {
		// chargement du pilote de bases de donn闁憇
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un client dans la table client Le mode est auto-commit
	 * par d闁抋ut : chaque insertion est valid闁�
	 * 
	 * @param Client
	 *            Client 锟� ajouter
	 * @return retourne le nombre de lignes ajout闁憇 dans la table
	 */
	public int ajouter(Rib rib) {
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
			ps = con.prepareStatement("INSERT INTO rib (codeGuichet,numeroDeCompte,cleRIB,codeBanque) VALUES (?,?,?,?)");
			ps.setInt(1, rib.getCodeGuichet());
			ps.setString(2, rib.getNumeroDeCompte());
			ps.setInt(3, rib.getClefRIB());
			ps.setInt(4, rib.getCodeBanque());
			
			
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
	
	/*public Rib getRib(int idClient) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client cl = null;
		
		// connexion 脿 la base de donn茅es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on ex茅cute la requ锚te
			// rs contient un pointeur situ茅 juste avant la premi猫re ligne
			// retourn茅e
			rs = ps.executeQuery();
			// passe 脿 la premi猫re (et unique) ligne retourn茅e
			if (rs.next())
				cl = new Client(rs.getString("nomClient"),
						rs.getString("prenomClient"),rs.getString("civiliteClient"),rs.getString("emailClient"),rs.getString("dateNaissanceClient"),rs.getString("motDePasseClient"),rs.getString("nationaliteClient"),rs.getString("typeCompte"),rs.getInt("telephoneClient"),rs.getString("adresseClient"),rs.getInt("codepostalClient"),rs.getString("villeClient"),rs.getString("paysClient"));

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
		return cl;

	}*/

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

		ClientDAO clientDAO = new ClientDAO();
		// test de la m闁爃ode ajouter
	     Client c1 = new Client( "nom", "prenom","civi","email","DateN","mdp","nation","typeC",12345678,"adC",76100,"ville","paysC");
		int retour = clientDAO.ajouter(c1);

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
}

