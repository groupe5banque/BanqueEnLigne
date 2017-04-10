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
 * Classe d'acc茅鈥樎� aux donn茅鈥撯�榮 contenues dans la table client
 * 
 * @author Anais
 * @version 1.2
 * */
public class VirementDAO {

	/**
	 * Param茅鈥樎es de connexion 茂驴陆 la base de donn茅鈥撯�榮 oracle URL, LOGIN et PASS
	 * sont des constantes
	 */
	
	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root";  //exemple BDD1
	final static String PASS = "root";   //exemple BDD1

	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public VirementDAO() {
		// chargement du pilote de bases de donn茅鈥撯�榮
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un client dans la table client Le mode est auto-commit
	 * par d茅鈥撯�檃ut : chaque insertion est valid茅鈥撯��
	 * 
	 * @param Client
	 *            Client 茂驴陆 ajouter
	 * @return retourne le nombre de lignes ajout茅鈥撯�榮 dans la table
	 */
	public int ajouter(Virement virement) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion 茂驴陆 la base de donn茅鈥撯�榮
		try {
				
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pr茅鈥撆揳ration de l'instruction SQL, chaque ? repr茅鈥撆竐nte une valeur
			// 茂驴陆 communiquer dans l'insertion
			// les getters permettent de r茅鈥擄拷up茅鈥撆緀r les valeurs des attributs
			// souhait茅鈥撆�
			ps = con.prepareStatement("INSERT INTO virement (idClient,compteEmetteur,compteBeneficiaire,montantVirement,dateVirement,motifVirement) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, virement.getIdClient());
			ps.setString(2, virement.getCompteEmetteur());
			ps.setString(3, virement.getCompteBeneficiaire());
			ps.setInt(4, virement.getMontant());
			ps.setDate(5, (java.sql.Date) virement.getDate());
			ps.setString(6, virement.getMotif());
			
			
			// Ex茅鈥擄拷ution de la requ茅藴戮e
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
		
		// connexion 脙聽 la base de donn脙漏es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on ex脙漏cute la requ脙陋te
			// rs contient un pointeur situ脙漏 juste avant la premi脙篓re ligne
			// retourn脙漏e
			rs = ps.executeQuery();
			// passe 脙聽 la premi脙篓re (et unique) ligne retourn脙漏e
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
	
	public Client connexionClient(String mail,String mdp) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client cl = null;
		
		// connexion 脙聽 la base de donn脙漏es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE emailClient = ? AND motDePasseClient=? ");
			ps.setString(1, mail);
			ps.setString(2,mdp);

			// on ex脙漏cute la requ脙陋te
			// rs contient un pointeur situ脙漏 juste avant la premi脙篓re ligne
			// retourn脙漏e
			rs = ps.executeQuery();
			// passe 脙聽 la premi脙篓re (et unique) ligne retourn脙漏e
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
	 * Permet de r茅鈥擄拷up茅鈥撆緀r un client 茂驴陆 partir de son identifiant
	 * 
	 * @param idClient
	 *            le numero du client   r cup rer 
	 * @return 	le client  trouv茂驴陆;
	 * 			null si aucun client ne correspond 茂驴陆 cet identifiant
	 */
/*	public Client getClient(int idClient) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client retour = null;

		// connexion 茂驴陆 la base de donn茅鈥撯�榮
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE IdClient = ?");
			ps.setInt(1, idClient);

			// on ex茅鈥擄拷ute la requ茅藴戮e
			// rs contient un pointeur situ茂驴陆 juste avant la premi茅鈥樎 ligne
			// retourn茅鈥撯��
			rs = ps.executeQuery();
			// passe 茂驴陆 la premi茅鈥樎 (et unique) ligne retourn茅鈥撯��
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

		// connexion 茂驴陆 la base de donn茅鈥撯�榮
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE  FROM Client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on ex茅鈥擄拷ute la requ茅藴戮e
			// rs contient un pointeur situ茂驴陆 juste avant la premi茅鈥樎 ligne
			// retourn茅鈥撯��
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

			// on ex茅鈥擄拷ute la requ茅藴戮e
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥撆竨ltat
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
	 * Permet de r茅鈥擄拷up茅鈥撆緀r tous les clients stock茅鈥撆� dans la table client
	 * 
	 * @return une ArrayList de clients
	 */
	/*public List<Client> getListeClient() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Client> retour = new ArrayList<Client>();

		// connexion 茂驴陆 la base de donn茅鈥撯�榮
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client");

			// on ex茅鈥擄拷ute la requ茅藴戮e
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥撆竨ltat
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
		// test de la m茅鈥撀爃ode ajouter
	    // Client c1 = new Client( "nom", "prenom","civi","email","DateN","mdp","nation","typeC",12345678,"adC",76100,"ville","paysC");
		//int retour = clientDAO.ajouter(c1);
		Client c1= null;
		c1=clientDAO.connexionClient("anaistchamani@yahoo.fr","anais");
		if (c1==null){
			System.out.println("Connexion rat脙漏e");
		} else {
			System.out.println("Connexion r脙漏ussie");
		}
		//System.out.println(retour + " lignes ajout茅鈥撯�榮");
		
		// test de la m茅鈥撀爃ode deleteClient
			//int r  = clientDAO.deleteClient(4);
			//System.out.println(r);
		  // ArrayList bbbb =new ArrayList<Integer>();
		//  System.out.println(bbbb=clientDAO.idClient());
			// test de la m茅鈥撀爃ode getListeArticles
			/*List<Article> liste = articleDAO.getListeArticles();
			// affichage des articles
			for (Article art : liste) {
				System.out.println(art.toString());
			}*/
	//}
}


	


