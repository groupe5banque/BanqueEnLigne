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
 * Classe d'acc�s aux donn�es contenues dans la table Manager
 * 
 * @author SAMBA Yacine A.
 * @version 1.2
 * */
public class ManagerDAO {

	/**
	 * Param�?碱�?es de connexion 閿燂拷 la base de donn闂佹唶 oracle URL, LOGIN et PASS
	 * sont des constantes
	 */
	
	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root"; 
	final static String PASS = "root";   

	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public ManagerDAO() {
		// chargement du pilote de bases de donn闂佹唶
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un Manager dans la table Manager Le mode est auto-commit
	 * par d闂佹妺ut : chaque insertion est valid闂侊拷
	 * 
	 * @param Manager
	 *            Manager 閿燂拷 ajouter
	 * @return retourne le nombre de lignes ajout闂佹唶 dans la table
	 */
	public int ajouter(Manager Manager) {
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
			ps = con.prepareStatement("INSERT INTO Manager (nomManager,prenomManager,civiliteManager,emailManager,dateNaissanceManager,motDePasseManager,telephoneManager) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, Manager.getNomManager());
			ps.setString(2, Manager.getPrenomManager());
			ps.setString(3, Manager.getCiviliteManager());
			ps.setString(4, Manager.getEmailManager());
			ps.setString(5, Manager.getDateNaissanceManager());
			ps.setString(6, Manager.getMotDePasseManager());
			ps.setInt(7, Manager.getTelephoneManager());
			
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
	
	public Manager getManager(int idManager) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Manager cl = null;
		
		// connexion 鑴� la base de donn鑼�??s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Manager WHERE idManager = ?");
			ps.setInt(1, idManager);

			// on ex鑼�?�ute la requ閿歵e
			// rs contient un pointeur situ鑼� juste avant la premi�?�玶e ligne
			// retourn鑼�??
			rs = ps.executeQuery();
			// passe 鑴� la premi�?�玶e (et unique) ligne retourn鑼�??
			if (rs.next())
				cl = new Manager(rs.getInt("idManager"),rs.getString("nomManager"),
						rs.getString("prenomManager"),rs.getString("civiliteManager"),rs.getString("emailManager"),rs.getString("dateNaissanceManager"),rs.getString("motDePasseManager"),rs.getInt("telephoneManager"));

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
	
	
	public Manager getManagerByName(String nom) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Manager cl = null;
		
		// connexion 鑴� la base de donn鑼�??s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Manager WHERE nomManager = ?");
			ps.setString(1, nom);

			// on ex鑼�?�ute la requ閿歵e
			// rs contient un pointeur situ鑼� juste avant la premi�?�玶e ligne
			// retourn鑼�??
			rs = ps.executeQuery();
			// passe 鑴� la premi�?�玶e (et unique) ligne retourn鑼�??
			if (rs.next())
				cl = new Manager(rs.getInt("idManager"),rs.getString("nomManager"),
						rs.getString("prenomManager"),rs.getString("civiliteManager"),rs.getString("emailManager"),rs.getString("dateNaissanceManager"),rs.getString("motDePasseManager"),rs.getInt("telephoneManager"));

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
	

	public Manager getManagerByEmail(String email) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Manager cl = null;
		
		// connexion 鑴� la base de donn鑼�??s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Manager WHERE emailManager = ?");
			ps.setString(1, email);

			// on ex鑼�?�ute la requ閿歵e
			// rs contient un pointeur situ鑼� juste avant la premi�?�玶e ligne
			// retourn鑼�??
			rs = ps.executeQuery();
			// passe 鑴� la premi�?�玶e (et unique) ligne retourn鑼�??
			if (rs.next())
				cl = new Manager(rs.getInt("idManager"),rs.getString("nomManager"),
						rs.getString("prenomManager"),rs.getString("civiliteManager"),rs.getString("emailManager"),rs.getString("dateNaissanceManager"),rs.getString("motDePasseManager"),rs.getInt("telephoneManager"));

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
	
	
	public ArrayList<Manager> getListManager() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Manager cl = null;
		ArrayList<Manager> ListManager = new ArrayList<Manager>();
		
		// connexion 脿 la base de donn茅es
				try {

					con = DriverManager.getConnection(URL, LOGIN, PASS);
					ps = con.prepareStatement("SELECT * FROM Manager");
					

					// on ex茅cute la requ锚te
					// rs contient un pointeur situ茅 juste avant la premi猫re ligne
					// retourn茅e
					rs = ps.executeQuery();
					// passe 脿 la premi猫re (et unique) ligne retourn茅e
					while (rs.next())
					{
						cl = new Manager(rs.getInt("idManager"),rs.getString("nomManager"),
								rs.getString("prenomManager"),rs.getString("civiliteManager"),rs.getString("emailManager"),rs.getString("dateNaissanceManager"),rs.getString("motDePasseManager"),rs.getInt("telephoneManager"));
                        ListManager.add(cl);
                       // System.out.print(rs.getString("prenomManager"));
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
				return ListManager;				
	}
	
	
	public Manager connexionManager(String mail,String mdp) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Manager cl = null;
		
		// connexion 鑴欒伣 la base de donn鑴�?紡es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Manager WHERE emailManager = ? AND motDePasseManager=? ");
			ps.setString(1, mail);
			ps.setString(2,mdp);

			// on ex鑴�?紡cute la requ鑴欓檵te
			// rs contient un pointeur situ鑴�?紡 juste avant la premi鑴欑瘬re ligne
			// retourn鑴�?紡e
			rs = ps.executeQuery();
			// passe 鑴欒伣 la premi鑴欑瘬re (et unique) ligne retourn鑴�?紡e
			if (rs.next())
				cl = new Manager(rs.getInt("idManager"),rs.getString("nomManager"),
						rs.getString("prenomManager"),rs.getString("civiliteManager"),rs.getString("emailManager"),rs.getString("dateNaissanceManager"),rs.getString("motDePasseManager"),rs.getInt("telephoneManager"));

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
	
	public int getIdManager(String Email){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		// connexion 鑴� la base de donn鑼�??s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idManager FROM Manager  WHERE emailManager = ? ");
			ps.setString(1,Email );
			
            
			// on ex鑴�?紡cute la requ閿歵e
			// rs contient un pointeur situ鑴�?紡 juste avant la premi�?�玶e ligne
			// retourn鑼�
			rs = ps.executeQuery();
			// passe 鑴欒伣 la premi鑴欑瘬re (et unique) ligne retourn鑴�?紡e
			if (rs.next())
				retour =rs.getInt("idManager");

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
	public int modifierManager(Manager cl, int idManager ) {
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
			ps = con.prepareStatement("UPDATE Manager SET nomManager = ? ,prenomManager = ?,civiliteManager=?,emailManager=?,dateNaissanceManager=?,motDePasseManager=?,nationaliteManager=?,typeCompte=?,telephoneManager=?,adresseManager=?,codepostalManager=?,villeManager=?,paysManager=?   WHERE idManager = ? ");
			ps.setString(1, cl.getNomManager());
			ps.setString(2, cl.getPrenomManager());
			ps.setString(3, cl.getCiviliteManager());
			ps.setString(4, cl.getEmailManager());
			ps.setString(5, cl.getDateNaissanceManager());
			ps.setString(6, cl.getMotDePasseManager());
			ps.setInt(7, cl.getTelephoneManager());
			ps.setInt(8, idManager);
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
	 * Permet de r闂佸紪p闂佺�峳 un Manager 閿燂拷 partir de son identifiant
	 * 
	 * @param idManager
	 *            le numero du Manager   r cup rer 
	 * @return 	le Manager  trouv閿燂拷;
	 * 			null si aucun Manager ne correspond 閿燂拷 cet identifiant
	 */
/*	public Manager getManager(int idManager) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Manager retour = null;

		// connexion 閿燂拷 la base de donn闂佹唶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Manager WHERE IdManager = ?");
			ps.setInt(1, idManager);

			// on ex闂佸紪te la requ闂冪穩
			// rs contient un pointeur situ閿燂拷 juste avant la premi�?碱晪 ligne
			// retourn闂侊拷
			rs = ps.executeQuery();
			// passe 閿燂拷 la premi�?碱晪 (et unique) ligne retourn闂侊拷
			if (rs.next())
				retour = new Manager(rs.getInt("idManager"),
						rs.getString("civiliteManager"),
						rs.getString("dateNaissanceManager"));

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
	/*public int deleteManager(int idManager) {

		Connection con = null;
		PreparedStatement ps = null;
		
		int  retour = 0;

		// connexion 閿燂拷 la base de donn闂佹唶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE  FROM Manager WHERE idManager = ?");
			ps.setInt(1, idManager);

			// on ex闂佸紪te la requ闂冪穩
			// rs contient un pointeur situ閿燂拷 juste avant la premi�?碱晪 ligne
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
	 * permet d'alligner les identifiants pr sents dans la table Managers 
	 * 	
	 */
	/*public ArrayList idManager(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList retour = new ArrayList<Integer>();
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT IdManager FROM Manager");

			// on ex闂佸紪te la requ闂冪穩
			rs = ps.executeQuery();
			// on parcourt les lignes du r闂佺�?ltat
			while (rs.next())
				retour.add( rs.getInt("IdManager"));

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
	 * Permet de r闂佸紪p闂佺�峳 tous les Managers stock闂侊拷 dans la table Manager
	 * 
	 * @return une ArrayList de Managers
	 */
	/*public List<Manager> getListeManager() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Manager> retour = new ArrayList<Manager>();

		// connexion 閿燂拷 la base de donn闂佹唶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Manager");

			// on ex闂佸紪te la requ闂冪穩
			rs = ps.executeQuery();
			// on parcourt les lignes du r闂佺�?ltat
			while (rs.next())
				retour.add(new Manager(rs.getInt("IdManager"), rs
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
	//public static void main(String[] args) throws SQLException{
	//	ManagerDAO cd = new ManagerDAO();
	
		
		//Manager f = new Manager("JIOO","HB","HB","IHO","1988-11-08","B",666679);
		
		//cd.ajouter(f);
		//Manager c=cd.connexionManager("manager@banques8.fr","manager");
	
		//Manager c=cd.getManagerByEmail("manager@banques8.fr");
		
	//	System.out.println(c);
	//}
	
}


	

