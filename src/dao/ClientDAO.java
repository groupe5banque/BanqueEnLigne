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
 * Classe d'acc鑣 aux donn閑s contenues dans la table client
 * 
 * @author Prisca - Hornela
 * @version 1.2
 * */
public class ClientDAO {

	/**
	 * Param鑤res de connexion � la base de donn閑s oracle URL, LOGIN et PASS
	 * sont des constantes
	 */
	
	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root";  //exemple BDD1
	final static String PASS = "root";   //exemple BDD1

	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public ClientDAO() {
		// chargement du pilote de bases de donn閑s
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un client dans la table client Le mode est auto-commit
	 * par d閒aut : chaque insertion est valid閑
	 * 
	 * @param Client
	 *            Client � ajouter
	 * @return retourne le nombre de lignes ajout閑s dans la table
	 */
	public int ajouter(Client client) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion � la base de donn閑s
		try {
			
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pr閜aration de l'instruction SQL, chaque ? repr閟ente une valeur
			// � communiquer dans l'insertion
			// les getters permettent de r閏up閞er les valeurs des attributs
			// souhait閟
			ps = con.prepareStatement("INSERT INTO client (nomClient,prenomClient,civiliteClient,emailClient,dateNaissanceClient,motDePasseClient,nationaliteClient,typeCompte,telephoneClient,adresseClient,codepostalClient,villeClient,paysClient) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, client.getNomClient());
			ps.setString(2, client.getPrenomClient());
			ps.setString(3, client.getCiviliteClient());
			ps.setString(4, client.getEmailClient());
			ps.setString(5, client.getDateNaissanceClient());
			ps.setString(6, client.getMotDePasseClient());
			ps.setString(7, client.getNationaliteClient());
			ps.setString(8, client.getTypeCompte());
			ps.setInt(9, client.getTelephoneClient());
			ps.setString(10, client.getAdresseClient());
			ps.setInt(11, client.getCodepostalClient());
			ps.setString(12, client.getVilleClient());
			ps.setString(13, client.getPaysClient());
			
			// Ex閏ution de la requ阾e
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
	
	public Client getClient(int idClient) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client cl = null;
		
		// connexion à la base de données
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on exécute la requête
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
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

	}

	/**
	 * Permet de r閏up閞er un client � partir de son identifiant
	 * 
	 * @param idClient
	 *            le numero du client   r cup rer 
	 * @return 	le client  trouv�;
	 * 			null si aucun client ne correspond � cet identifiant
	 */
/*	public Client getClient(int idClient) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client retour = null;

		// connexion � la base de donn閑s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE IdClient = ?");
			ps.setInt(1, idClient);

			// on ex閏ute la requ阾e
			// rs contient un pointeur situ� juste avant la premi鑢e ligne
			// retourn閑
			rs = ps.executeQuery();
			// passe � la premi鑢e (et unique) ligne retourn閑
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

		// connexion � la base de donn閑s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE  FROM Client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on ex閏ute la requ阾e
			// rs contient un pointeur situ� juste avant la premi鑢e ligne
			// retourn閑
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

			// on ex閏ute la requ阾e
			rs = ps.executeQuery();
			// on parcourt les lignes du r閟ultat
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
	 * Permet de r閏up閞er tous les clients stock閟 dans la table client
	 * 
	 * @return une ArrayList de clients
	 */
	/*public List<Client> getListeClient() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Client> retour = new ArrayList<Client>();

		// connexion � la base de donn閑s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client");

			// on ex閏ute la requ阾e
			rs = ps.executeQuery();
			// on parcourt les lignes du r閟ultat
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
		// test de la m閠hode ajouter
	     Client c1 = new Client( "nom", "prenom","civi","email","DateN","mdp","nation","typeC",12345678,"adC",76100,"ville","paysC");
		int retour = clientDAO.ajouter(c1);

		System.out.println(retour + " lignes ajout閑s");
		
		// test de la m閠hode deleteClient
			//int r  = clientDAO.deleteClient(4);
			//System.out.println(r);
		  // ArrayList bbbb =new ArrayList<Integer>();
		//  System.out.println(bbbb=clientDAO.idClient());
			// test de la m閠hode getListeArticles
			/*List<Article> liste = articleDAO.getListeArticles();
			// affichage des articles
			for (Article art : liste) {
				System.out.println(art.toString());
			}
	}*/	
}


	

