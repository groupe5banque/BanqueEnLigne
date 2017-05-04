package da;

import dt.*;
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
 * Classe d'accé—?ç¡·æ‹· aux donné—‚ä½¹å”¶ contenues dans la table client
 * 
 * @author Prisca-Anaé?—ç—µ
 * @version 1.2
 * */
public class ClientDAO {

	/**
	 * Paramé—?ç¢±æ§?es de connexion é–¿ç‡‚æ‹· la base de donné—‚ä½¹å”¶ oracle URL, LOGIN et PASS
	 * sont des constantes
	 */
	
	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root";  
	final static String PASS = "root";   

	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public ClientDAO() {
		// chargement du pilote de bases de donné—‚ä½¹å”¶
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un client dans la table client Le mode est auto-commit
	 * par dé—‚ä½¹å¦ºut : chaque insertion est validé—‚ä¾Šæ‹·
	 * 
	 * @param Client
	 *            Client é–¿ç‡‚æ‹· ajouter
	 * @return retourne le nombre de lignes ajouté—‚ä½¹å”¶ dans la table
	 */
	public int ajouter(Client client) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion è„¿ la base de donnèŒ…e
		try {
			
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pré—‚ä½¹ç«µration de l'instruction SQL, chaque ? repré—‚ä½ºå‰³nte une valeur
			// é–¿ç‡‚æ‹· communiquer dans l'insertion
			// les getters permettent de ré—‚ä½¸ç´ªpé—‚ä½ºï¿½å³³ les valeurs des attributs
			// souhaité—‚ä¾Šæ‹·
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
			
			// Exé—‚ä½¸ç´ªtion de la requé—‚å†ªç©©
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
		
		// connexion é‘´ï¿½ la base de donné‘¼å??s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on exé‘¼å?Œute la requé–¿æ­µe
			// rs contient un pointeur situé‘¼ï¿½ juste avant la premié?šçŽ¶e ligne
			// retourné‘¼å??
			rs = ps.executeQuery();
			// passe é‘´ï¿½ la premié?šçŽ¶e (et unique) ligne retourné‘¼å??
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
	
	
	public Client getClientByName(String nom) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client cl = null;
		
		// connexion é‘´ï¿½ la base de donné‘¼å??s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE nomClient = ?");
			ps.setString(1, nom);

			// on exé‘¼å?Œute la requé–¿æ­µe
			// rs contient un pointeur situé‘¼ï¿½ juste avant la premié?šçŽ¶e ligne
			// retourné‘¼å??
			rs = ps.executeQuery();
			// passe é‘´ï¿½ la premié?šçŽ¶e (et unique) ligne retourné‘¼å??
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

	
	public ArrayList<Client> getListClient() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client cl = null;
		ArrayList<Client> ListClient = new ArrayList<Client>();
		
		// connexion è„¿ la base de donnèŒ…es
				try {

					con = DriverManager.getConnection(URL, LOGIN, PASS);
					ps = con.prepareStatement("SELECT * FROM client");
					

					// on exèŒ…cute la requé”šte
					// rs contient un pointeur situèŒ… juste avant la premiçŒ«re ligne
					// retournèŒ…e
					rs = ps.executeQuery();
					// passe è„¿ la premiçŒ«re (et unique) ligne retournèŒ…e
					while (rs.next())
					{
						cl = new Client(rs.getInt("idClient"),rs.getString("nomClient"),
								rs.getString("prenomClient"),rs.getString("civiliteClient"),rs.getString("emailClient"),rs.getString("dateNaissanceClient"),rs.getString("motDePasseClient"),rs.getString("nationaliteClient"),rs.getString("typeCompte"),rs.getInt("telephoneClient"),rs.getString("adresseClient"),rs.getInt("codepostalClient"),rs.getString("villeClient"),rs.getString("paysClient"));
                        ListClient.add(cl);
                       // System.out.print(rs.getString("prenomClient"));
					}   
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
				return ListClient;				
	}
	
	
	public Client connexionClient(String mail,String mdp) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client cl = null;
		
		// connexion é‘´æ¬’ä¼£ la base de donné‘´æ¬?ç´¡es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE emailClient = ? AND motDePasseClient=? ");
			ps.setString(1, mail);
			ps.setString(2,mdp);

			// on exé‘´æ¬?ç´¡cute la requé‘´æ¬“æªµte
			// rs contient un pointeur situé‘´æ¬?ç´¡ juste avant la premié‘´æ¬‘ç˜¬re ligne
			// retourné‘´æ¬?ç´¡e
			rs = ps.executeQuery();
			// passe é‘´æ¬’ä¼£ la premié‘´æ¬‘ç˜¬re (et unique) ligne retourné‘´æ¬?ç´¡e
			if (rs.next())
				cl = new Client(rs.getInt("idClient"),rs.getString("nomClient"),
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
	
	public int getIdClient(String Email){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		// connexion é‘´ï¿½ la base de donné‘¼å??s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idClient FROM client  WHERE emailClient = ? ");
			ps.setString(1,Email );
			
            
			// on exé‘´æ¬?ç´¡cute la requé–¿æ­µe
			// rs contient un pointeur situé‘´æ¬?ç´¡ juste avant la premié?šçŽ¶e ligne
			// retourné‘¼ï¿½
			rs = ps.executeQuery();
			// passe é‘´æ¬’ä¼£ la premié‘´æ¬‘ç˜¬re (et unique) ligne retourné‘´æ¬?ç´¡e
			if (rs.next())
				retour =rs.getInt("idClient");

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
	/**
	 * 
	 */
	public int modifierClient(Client cl, int idClient ) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion é–¿ç‡‚æ‹· la base de donné—‚ä½¹å”¶
		try {
			
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pré—‚ä½¹ç«µration de l'instruction SQL, chaque ? repré—‚ä½ºå‰³nte une valeur
			// é–¿ç‡‚æ‹· communiquer dans l'insertion
			// les getters permettent de ré—‚ä½¸ç´ªpé—‚ä½ºï¿½å³³ les valeurs des attributs
			// souhaité—‚ä¾Šæ‹·
			ps = con.prepareStatement("UPDATE client SET nomClient = ? ,prenomClient = ?,civiliteClient=?,emailClient=?,dateNaissanceClient=?,motDePasseClient=?,nationaliteClient=?,typeCompte=?,telephoneClient=?,adresseClient=?,codepostalClient=?,villeClient=?,paysClient=?   WHERE idClient = ? ");
			ps.setString(1, cl.getNomClient());
			ps.setString(2, cl.getPrenomClient());
			ps.setString(3, cl.getCiviliteClient());
			ps.setString(4, cl.getEmailClient());
			ps.setString(5, cl.getDateNaissanceClient());
			ps.setString(6, cl.getMotDePasseClient());
			ps.setString(7, cl.getNationaliteClient());
			ps.setString(8, cl.getTypeCompte());
			ps.setInt(9, cl.getTelephoneClient());
			ps.setString(10, cl.getAdresseClient());
			ps.setInt(11, cl.getCodepostalClient());
			ps.setString(12, cl.getVilleClient());
			ps.setString(13, cl.getPaysClient());
			ps.setInt(14, idClient);
			// Exé—‚ä½¸ç´ªtion de la requé—‚å†ªç©©
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
	
	/**
	 * Permet de ré—‚ä½¸ç´ªpé—‚ä½ºï¿½å³³ un client é–¿ç‡‚æ‹· partir de son identifiant
	 * 
	 * @param idClient
	 *            le numero du client   r cup rer 
	 * @return 	le client  trouvé–¿ç‡‚æ‹·;
	 * 			null si aucun client ne correspond é–¿ç‡‚æ‹· cet identifiant
	 */
/*	public Client getClient(int idClient) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client retour = null;

		// connexion é–¿ç‡‚æ‹· la base de donné—‚ä½¹å”¶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE IdClient = ?");
			ps.setInt(1, idClient);

			// on exé—‚ä½¸ç´ªte la requé—‚å†ªç©©
			// rs contient un pointeur situé–¿ç‡‚æ‹· juste avant la premié—?ç¢±æ™ª ligne
			// retourné—‚ä¾Šæ‹·
			rs = ps.executeQuery();
			// passe é–¿ç‡‚æ‹· la premié—?ç¢±æ™ª (et unique) ligne retourné—‚ä¾Šæ‹·
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

		// connexion é–¿ç‡‚æ‹· la base de donné—‚ä½¹å”¶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE  FROM Client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on exé—‚ä½¸ç´ªte la requé—‚å†ªç©©
			// rs contient un pointeur situé–¿ç‡‚æ‹· juste avant la premié—?ç¢±æ™ª ligne
			// retourné—‚ä¾Šæ‹·
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

			// on exé—‚ä½¸ç´ªte la requé—‚å†ªç©©
			rs = ps.executeQuery();
			// on parcourt les lignes du ré—‚ä½ºåŠ?ltat
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
	 * Permet de ré—‚ä½¸ç´ªpé—‚ä½ºï¿½å³³ tous les clients stocké—‚ä¾Šæ‹· dans la table client
	 * 
	 * @return une ArrayList de clients
	 */
	/*public List<Client> getListeClient() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Client> retour = new ArrayList<Client>();

		// connexion é–¿ç‡‚æ‹· la base de donné—‚ä½¹å”¶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client");

			// on exé—‚ä½¸ç´ªte la requé—‚å†ªç©©
			rs = ps.executeQuery();
			// on parcourt les lignes du ré—‚ä½ºåŠ?ltat
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
     int i=16;
		ClientDAO clientDAO = new ClientDAO();
		// test de la mé—‚ä½ºåž‰ode ajouter
	     Client c1 = new Client( "nom", "prenom","civi","email","DateN","mdp","nation","typeC",12345678,"adC",76100,"ville","paysC");
		int retour = clientDAO.modifierClient(c1,i);

		System.out.println(retour + " lignes modifié‘¼å??s");
		
		// test de la mé—‚ä½ºåž‰ode deleteClient
			//int r  = clientDAO.deleteClient(4);
			//System.out.println(r);
		  // ArrayList bbbb =new ArrayList<Integer>();
		//  System.out.println(bbbb=clientDAO.idClient());
			// test de la mé—‚ä½ºåž‰ode getListeArticles
			/*List<Article> liste = articleDAO.getListeArticles();
			// affichage des articles
			for (Article art : liste) {
				System.out.println(art.toString());
			}
	}*/
}


	

