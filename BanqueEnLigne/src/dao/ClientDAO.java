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
 * Classe d'acc闁硷拷 aux donn闂佹唶 contenues dans la table client
 * 
 * @author Prisca-Ana鍗痵
 * @version 1.2
 * */
public class ClientDAO {

	/**
	 * Param闁碱槝es de connexion 閿燂拷 la base de donn闂佹唶 oracle URL, LOGIN et PASS
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
		// chargement du pilote de bases de donn闂佹唶
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un client dans la table client Le mode est auto-commit
	 * par d闂佹妺ut : chaque insertion est valid闂侊拷
	 * 
	 * @param Client
	 *            Client 閿燂拷 ajouter
	 * @return retourne le nombre de lignes ajout闂佹唶 dans la table
	 */
	public int ajouter(Client client) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion 脿 la base de donn茅e
		try {
			
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pr闂佹竵ration de l'instruction SQL, chaque ? repr闂佺剳nte une valeur
			// 閿燂拷 communiquer dans l'insertion
			// les getters permettent de r闂佸紪p闂佺�峳 les valeurs des attributs
			// souhait闂侊拷
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
			
			// Ex闂佸紪tion de la requ闂冪穩
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
		
		// connexion 鑴� la base de donn鑼卐s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on ex鑼卌ute la requ閿歵e
			// rs contient un pointeur situ鑼� juste avant la premi鐚玶e ligne
			// retourn鑼卐
			rs = ps.executeQuery();
			// passe 鑴� la premi鐚玶e (et unique) ligne retourn鑼卐
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
		
		// connexion 鑴� la base de donn鑼卐s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE nomClient = ?");
			ps.setString(1, nom);

			// on ex鑼卌ute la requ閿歵e
			// rs contient un pointeur situ鑼� juste avant la premi鐚玶e ligne
			// retourn鑼卐
			rs = ps.executeQuery();
			// passe 鑴� la premi鐚玶e (et unique) ligne retourn鑼卐
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
		
		// connexion 脿 la base de donn茅es
				try {

					con = DriverManager.getConnection(URL, LOGIN, PASS);
					ps = con.prepareStatement("SELECT * FROM client");
					

					// on ex茅cute la requ锚te
					// rs contient un pointeur situ茅 juste avant la premi猫re ligne
					// retourn茅e
					rs = ps.executeQuery();
					// passe 脿 la premi猫re (et unique) ligne retourn茅e
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
		
		// connexion 鑴欒伣 la base de donn鑴欐紡es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE emailClient = ? AND motDePasseClient=? ");
			ps.setString(1, mail);
			ps.setString(2,mdp);

			// on ex鑴欐紡cute la requ鑴欓檵te
			// rs contient un pointeur situ鑴欐紡 juste avant la premi鑴欑瘬re ligne
			// retourn鑴欐紡e
			rs = ps.executeQuery();
			// passe 鑴欒伣 la premi鑴欑瘬re (et unique) ligne retourn鑴欐紡e
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

		// connexion 鑴� la base de donn鑼卐s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idClient FROM client  WHERE emailClient = ? ");
			ps.setString(1,Email );
			
            
			// on ex鑴欐紡cute la requ閿歵e
			// rs contient un pointeur situ鑴欐紡 juste avant la premi鐚玶e ligne
			// retourn鑼�
			rs = ps.executeQuery();
			// passe 鑴欒伣 la premi鑴欑瘬re (et unique) ligne retourn鑴欐紡e
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

		// connexion 閿燂拷 la base de donn闂佹唶
		try {
			
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pr闂佹竵ration de l'instruction SQL, chaque ? repr闂佺剳nte une valeur
			// 閿燂拷 communiquer dans l'insertion
			// les getters permettent de r闂佸紪p闂佺�峳 les valeurs des attributs
			// souhait闂侊拷
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
			// Ex闂佸紪tion de la requ闂冪穩
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
	 * Permet de r闂佸紪p闂佺�峳 un client 閿燂拷 partir de son identifiant
	 * 
	 * @param idClient
	 *            le numero du client   r cup rer 
	 * @return 	le client  trouv閿燂拷;
	 * 			null si aucun client ne correspond 閿燂拷 cet identifiant
	 */
/*	public Client getClient(int idClient) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client retour = null;

		// connexion 閿燂拷 la base de donn闂佹唶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE IdClient = ?");
			ps.setInt(1, idClient);

			// on ex闂佸紪te la requ闂冪穩
			// rs contient un pointeur situ閿燂拷 juste avant la premi闁碱晪 ligne
			// retourn闂侊拷
			rs = ps.executeQuery();
			// passe 閿燂拷 la premi闁碱晪 (et unique) ligne retourn闂侊拷
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

		// connexion 閿燂拷 la base de donn闂佹唶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE  FROM Client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on ex闂佸紪te la requ闂冪穩
			// rs contient un pointeur situ閿燂拷 juste avant la premi闁碱晪 ligne
			// retourn闂侊拷
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

			// on ex闂佸紪te la requ闂冪穩
			rs = ps.executeQuery();
			// on parcourt les lignes du r闂佺劏ltat
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
	 * Permet de r闂佸紪p闂佺�峳 tous les clients stock闂侊拷 dans la table client
	 * 
	 * @return une ArrayList de clients
	 */
	/*public List<Client> getListeClient() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Client> retour = new ArrayList<Client>();

		// connexion 閿燂拷 la base de donn闂佹唶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client");

			// on ex闂佸紪te la requ闂冪穩
			rs = ps.executeQuery();
			// on parcourt les lignes du r闂佺劏ltat
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
		// test de la m闂佺垉ode ajouter
	     Client c1 = new Client( "nom", "prenom","civi","email","DateN","mdp","nation","typeC",12345678,"adC",76100,"ville","paysC");
		int retour = clientDAO.modifierClient(c1,i);

		System.out.println(retour + " lignes modifi鑼卐s");
		
		// test de la m闂佺垉ode deleteClient
			//int r  = clientDAO.deleteClient(4);
			//System.out.println(r);
		  // ArrayList bbbb =new ArrayList<Integer>();
		//  System.out.println(bbbb=clientDAO.idClient());
			// test de la m闂佺垉ode getListeArticles
			/*List<Article> liste = articleDAO.getListeArticles();
			// affichage des articles
			for (Article art : liste) {
				System.out.println(art.toString());
			}
	}*/
}


	

