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
 * Classe d'acc猫艗鈥γ┧喡ッβㄅ矫柯� aux donn猫艗鈥γ┧喡ッ︹�櫬柯矫ββ� contenues dans la table client
 * 
 * @author Anais
 * @version 1.2
 * */
public class VirementDAO {

	/**
	 * Param猫艗鈥γ┧喡ッβㄅ矫溗渆s de connexion 猫艗鈥毭┞┞疵┾劉鈥� la base de donn猫艗鈥γ┧喡ッ︹�櫬柯矫ββ� oracle URL, LOGIN et PASS
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
		// chargement du pilote de bases de donn猫艗鈥γ┧喡ッ︹�櫬柯矫ββ�
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un client dans la table client Le mode est auto-commit
	 * par d猫艗鈥γ┧喡ッ︹�櫬柯矫β抲t : chaque insertion est valid猫艗鈥γ┧喡ッ︹�櫬柯矫柯�
	 * 
	 * @param Client
	 *            Client 猫艗鈥毭┞┞疵┾劉鈥� ajouter
	 * @return retourne le nombre de lignes ajout猫艗鈥γ┧喡ッ︹�櫬柯矫ββ� dans la table
	 */
	public int ajouter(Virement virement) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion 猫艗鈥毭┞┞疵┾劉鈥� la base de donn猫艗鈥γ┧喡ッ︹�櫬柯矫ββ�
		try {
				
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pr猫艗鈥γ┧喡ッ︹�欌�犆︼拷鲁ration de l'instruction SQL, chaque ? repr猫艗鈥γ┧喡ッ︹�欌�犆拷nte une valeur
			// 猫艗鈥毭┞┞疵┾劉鈥� communiquer dans l'insertion
			// les getters permettent de r猫艗鈥γ┧喡ッ︹�溾�灻︹�孤穟p猫艗鈥γ┧喡ッ︹�欌�犆封偓r les valeurs des attributs
			// souhait猫艗鈥γ┧喡ッ︹�欌�犆柯�
			ps = con.prepareStatement("INSERT INTO virement (idClient,compteEmetteur,compteBeneficiaire,montantVirement,dateVirement,motifVirement) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, virement.getIdClient());
			ps.setString(2, virement.getCompteEmetteur());
			ps.setString(3, virement.getCompteBeneficiaire());
			ps.setDouble(4, virement.getMontant());
			ps.setDate(5, (java.sql.Date) virement.getDate());
			ps.setString(6, virement.getMotif());
			
			
			// Ex猫艗鈥γ┧喡ッ︹�溾�灻︹�孤穟tion de la requ猫艗鈥γㄢ�斅疵λ喡甧
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
		
		// connexion 猫鈥炩劉猫锟铰� la base de donn猫鈥炩劉忙录锟絜s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on ex猫鈥炩劉忙录锟絚ute la requ猫鈥炩劉茅鈩⑩�箃e
			// rs contient un pointeur situ猫鈥炩劉忙录锟� juste avant la premi猫鈥炩劉莽炉鈥渞e ligne
			// retourn猫鈥炩劉忙录锟絜
			rs = ps.executeQuery();
			// passe 猫鈥炩劉猫锟铰� la premi猫鈥炩劉莽炉鈥渞e (et unique) ligne retourn猫鈥炩劉忙录锟絜
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
		
		// connexion 猫鈥炩劉猫锟铰� la base de donn猫鈥炩劉忙录锟絜s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE emailClient = ? AND motDePasseClient=? ");
			ps.setString(1, mail);
			ps.setString(2,mdp);

			// on ex猫鈥炩劉忙录锟絚ute la requ猫鈥炩劉茅鈩⑩�箃e
			// rs contient un pointeur situ猫鈥炩劉忙录锟� juste avant la premi猫鈥炩劉莽炉鈥渞e ligne
			// retourn猫鈥炩劉忙录锟絜
			rs = ps.executeQuery();
			// passe 猫鈥炩劉猫锟铰� la premi猫鈥炩劉莽炉鈥渞e (et unique) ligne retourn猫鈥炩劉忙录锟絜
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
	 * Permet de r猫艗鈥γ┧喡ッ︹�溾�灻︹�孤穟p猫艗鈥γ┧喡ッ︹�欌�犆封偓r un client 猫艗鈥毭┞┞疵┾劉鈥� partir de son identifiant
	 * 
	 * @param idClient
	 *            le numero du client   r cup rer 
	 * @return 	le client  trouv猫艗鈥毭┞┞疵┾劉鈥�;
	 * 			null si aucun client ne correspond 猫艗鈥毭┞┞疵┾劉鈥� cet identifiant
	 */
/*	public Client getClient(int idClient) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Client retour = null;

		// connexion 猫艗鈥毭┞┞疵┾劉鈥� la base de donn猫艗鈥γ┧喡ッ︹�櫬柯矫ββ�
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client WHERE IdClient = ?");
			ps.setInt(1, idClient);

			// on ex猫艗鈥γ┧喡ッ︹�溾�灻︹�孤穟te la requ猫艗鈥γㄢ�斅疵λ喡甧
			// rs contient un pointeur situ猫艗鈥毭┞┞疵┾劉鈥� juste avant la premi猫艗鈥γ┧喡ッβㄅ矫�⑩�� ligne
			// retourn猫艗鈥γ┧喡ッ︹�櫬柯矫柯�
			rs = ps.executeQuery();
			// passe 猫艗鈥毭┞┞疵┾劉鈥� la premi猫艗鈥γ┧喡ッβㄅ矫�⑩�� (et unique) ligne retourn猫艗鈥γ┧喡ッ︹�櫬柯矫柯�
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

		// connexion 猫艗鈥毭┞┞疵┾劉鈥� la base de donn猫艗鈥γ┧喡ッ︹�櫬柯矫ββ�
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE  FROM Client WHERE idClient = ?");
			ps.setInt(1, idClient);

			// on ex猫艗鈥γ┧喡ッ︹�溾�灻︹�孤穟te la requ猫艗鈥γㄢ�斅疵λ喡甧
			// rs contient un pointeur situ猫艗鈥毭┞┞疵┾劉鈥� juste avant la premi猫艗鈥γ┧喡ッβㄅ矫�⑩�� ligne
			// retourn猫艗鈥γ┧喡ッ︹�櫬柯矫柯�
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

			// on ex猫艗鈥γ┧喡ッ︹�溾�灻︹�孤穟te la requ猫艗鈥γㄢ�斅疵λ喡甧
			rs = ps.executeQuery();
			// on parcourt les lignes du r猫艗鈥γ┧喡ッ︹�欌�犆╨tat
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
	 * Permet de r猫艗鈥γ┧喡ッ︹�溾�灻︹�孤穟p猫艗鈥γ┧喡ッ︹�欌�犆封偓r tous les clients stock猫艗鈥γ┧喡ッ︹�欌�犆柯� dans la table client
	 * 
	 * @return une ArrayList de clients
	 */
	/*public List<Client> getListeClient() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Client> retour = new ArrayList<Client>();

		// connexion 猫艗鈥毭┞┞疵┾劉鈥� la base de donn猫艗鈥γ┧喡ッ︹�櫬柯矫ββ�
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM client");

			// on ex猫艗鈥γ┧喡ッ︹�溾�灻︹�孤穟te la requ猫艗鈥γㄢ�斅疵λ喡甧
			rs = ps.executeQuery();
			// on parcourt les lignes du r猫艗鈥γ┧喡ッ︹�欌�犆╨tat
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
		// test de la m猫艗鈥γ┧喡ッ︹�欌偓莽藛茠ode ajouter
	    // Client c1 = new Client( "nom", "prenom","civi","email","DateN","mdp","nation","typeC",12345678,"adC",76100,"ville","paysC");
		//int retour = clientDAO.ajouter(c1);
		Client c1= null;
		c1=clientDAO.connexionClient("anaistchamani@yahoo.fr","anais");
		if (c1==null){
			System.out.println("Connexion rat猫鈥炩劉忙录锟絜");
		} else {
			System.out.println("Connexion r猫鈥炩劉忙录锟絬ssie");
		}
		//System.out.println(retour + " lignes ajout猫艗鈥γ┧喡ッ︹�櫬柯矫ββ�");
		
		// test de la m猫艗鈥γ┧喡ッ︹�欌偓莽藛茠ode deleteClient
			//int r  = clientDAO.deleteClient(4);
			//System.out.println(r);
		  // ArrayList bbbb =new ArrayList<Integer>();
		//  System.out.println(bbbb=clientDAO.idClient());
			// test de la m猫艗鈥γ┧喡ッ︹�欌偓莽藛茠ode getListeArticles
			/*List<Article> liste = articleDAO.getListeArticles();
			// affichage des articles
			for (Article art : liste) {
				System.out.println(art.toString());
			}*/
	//}
}


	


