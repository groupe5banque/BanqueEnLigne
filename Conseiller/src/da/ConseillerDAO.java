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
 * Classe d'acc�s aux donn�es contenues dans la table Conseiller
 * 
 * @author SAMBA Yacine A.
 * @version 1.2
 * */
public class ConseillerDAO {

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
	public ConseillerDAO() {
		// chargement du pilote de bases de donn闂佹唶
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un Conseiller dans la table Conseiller Le mode est auto-commit
	 * par d闂佹妺ut : chaque insertion est valid闂侊拷
	 * 
	 * @param Conseiller
	 *            Conseiller 閿燂拷 ajouter
	 * @return retourne le nombre de lignes ajout闂佹唶 dans la table
	 */
	public int ajouter(Conseiller Conseiller) {
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
			ps = con.prepareStatement("INSERT INTO conseiller (nomConseiller,prenomConseiller,civiliteConseiller,emailConseiller,dateNaissanceConseiller,motDePasseConseiller,telephoneConseiller) VALUES (?,?,?,?,?,?,?)");
			ps.setString(1, Conseiller.getNomConseiller());
			ps.setString(2, Conseiller.getPrenomConseiller());
			ps.setString(3, Conseiller.getCiviliteConseiller());
			ps.setString(4, Conseiller.getEmailConseiller());
			ps.setString(5, Conseiller.getDateNaissanceConseiller());
			ps.setString(6, Conseiller.getMotDePasseConseiller());
			ps.setInt(7, Conseiller.getTelephoneConseiller());
			
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
	
	public Conseiller getConseiller(int idConseiller) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conseiller cl = null;
		
		// connexion 鑴� la base de donn鑼�??s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM conseiller WHERE idConseiller = ?");
			ps.setInt(1, idConseiller);

			// on ex鑼�?�ute la requ閿歵e
			// rs contient un pointeur situ鑼� juste avant la premi�?�玶e ligne
			// retourn鑼�??
			rs = ps.executeQuery();
			// passe 鑴� la premi�?�玶e (et unique) ligne retourn鑼�??
			if (rs.next())
				cl = new Conseiller(rs.getInt("idConseiller"),rs.getString("nomConseiller"),
						rs.getString("prenomConseiller"),rs.getString("civiliteConseiller"),rs.getString("emailConseiller"),rs.getString("dateNaissanceConseiller"),rs.getString("motDePasseConseiller"),rs.getInt("telephoneConseiller"));

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
	
	
	public Conseiller getConseillerByName(String nom) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conseiller cl = null;
		
		// connexion 鑴� la base de donn鑼�??s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Conseiller WHERE nomConseiller = ?");
			ps.setString(1, nom);

			// on ex鑼�?�ute la requ閿歵e
			// rs contient un pointeur situ鑼� juste avant la premi�?�玶e ligne
			// retourn鑼�??
			rs = ps.executeQuery();
			// passe 鑴� la premi�?�玶e (et unique) ligne retourn鑼�??
			if (rs.next())
				cl = new Conseiller(rs.getInt("idConseiller"),rs.getString("nomConseiller"),
						rs.getString("prenomConseiller"),rs.getString("civiliteConseiller"),rs.getString("emailConseiller"),rs.getString("dateNaissanceConseiller"),rs.getString("motDePasseConseiller"),rs.getInt("telephoneConseiller"));

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
	

	public Conseiller getConseillerByEmail(String email) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conseiller cl = null;
		
		// connexion 鑴� la base de donn鑼�??s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM conseiller WHERE emailConseiller = ?");
			ps.setString(1, email);

			// on ex鑼�?�ute la requ閿歵e
			// rs contient un pointeur situ鑼� juste avant la premi�?�玶e ligne
			// retourn鑼�??
			rs = ps.executeQuery();
			// passe 鑴� la premi�?�玶e (et unique) ligne retourn鑼�??
			if (rs.next())
				cl = new Conseiller(rs.getInt("idConseiller"),rs.getString("nomConseiller"),
						rs.getString("prenomConseiller"),rs.getString("civiliteConseiller"),rs.getString("emailConseiller"),rs.getString("dateNaissanceConseiller"),rs.getString("motDePasseConseiller"),rs.getInt("telephoneConseiller"));

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
	
	
	public ArrayList<Conseiller> getListConseiller() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conseiller cl = null;
		ArrayList<Conseiller> ListConseiller = new ArrayList<Conseiller>();
		
		// connexion 脿 la base de donn茅es
				try {

					con = DriverManager.getConnection(URL, LOGIN, PASS);
					ps = con.prepareStatement("SELECT * FROM Conseiller");
					

					// on ex茅cute la requ锚te
					// rs contient un pointeur situ茅 juste avant la premi猫re ligne
					// retourn茅e
					rs = ps.executeQuery();
					// passe 脿 la premi猫re (et unique) ligne retourn茅e
					while (rs.next())
					{
						cl = new Conseiller(rs.getInt("idConseiller"),rs.getString("nomConseiller"),
								rs.getString("prenomConseiller"),rs.getString("civiliteConseiller"),rs.getString("emailConseiller"),rs.getString("dateNaissanceConseiller"),rs.getString("motDePasseConseiller"),rs.getInt("telephoneConseiller"));
                        ListConseiller.add(cl);
                       // System.out.print(rs.getString("prenomConseiller"));
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
				return ListConseiller;				
	}
	
	
	public Conseiller connexionConseiller(String mail,String mdp) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conseiller cl = null;
		
		// connexion 鑴欒伣 la base de donn鑴�?紡es
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM conseiller WHERE emailConseiller = ? AND motDePasseConseiller=? ");
			ps.setString(1, mail);
			ps.setString(2,mdp);

			// on ex鑴�?紡cute la requ鑴欓檵te
			// rs contient un pointeur situ鑴�?紡 juste avant la premi鑴欑瘬re ligne
			// retourn鑴�?紡e
			rs = ps.executeQuery();
			// passe 鑴欒伣 la premi鑴欑瘬re (et unique) ligne retourn鑴�?紡e
			if (rs.next())
				cl = new Conseiller(rs.getInt("idConseiller"),rs.getString("nomConseiller"),
						rs.getString("prenomConseiller"),rs.getString("civiliteConseiller"),rs.getString("emailConseiller"),rs.getString("dateNaissanceConseiller"),rs.getString("motDePasseConseiller"),rs.getInt("telephoneConseiller"));

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
	
	public int getIdConseiller(String Email){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		// connexion 鑴� la base de donn鑼�??s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idConseiller FROM conseiller  WHERE emailConseiller = ? ");
			ps.setString(1,Email );
			
            
			// on ex鑴�?紡cute la requ閿歵e
			// rs contient un pointeur situ鑴�?紡 juste avant la premi�?�玶e ligne
			// retourn鑼�
			rs = ps.executeQuery();
			// passe 鑴欒伣 la premi鑴欑瘬re (et unique) ligne retourn鑴�?紡e
			if (rs.next())
				retour =rs.getInt("idConseiller");

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
	public int modifierConseiller(Conseiller cl, int idConseiller ) {
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
			ps = con.prepareStatement("UPDATE conseiller SET nomConseiller = ? ,prenomConseiller = ?,civiliteConseiller=?,emailConseiller=?,dateNaissanceConseiller=?,motDePasseConseiller=?,nationaliteConseiller=?,typeCompte=?,telephoneConseiller=?,adresseConseiller=?,codepostalConseiller=?,villeConseiller=?,paysConseiller=?   WHERE idConseiller = ? ");
			ps.setString(1, cl.getNomConseiller());
			ps.setString(2, cl.getPrenomConseiller());
			ps.setString(3, cl.getCiviliteConseiller());
			ps.setString(4, cl.getEmailConseiller());
			ps.setString(5, cl.getDateNaissanceConseiller());
			ps.setString(6, cl.getMotDePasseConseiller());
			ps.setInt(7, cl.getTelephoneConseiller());
			ps.setInt(8, idConseiller);
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
	 * Permet de r闂佸紪p闂佺�峳 un Conseiller 閿燂拷 partir de son identifiant
	 * 
	 * @param idConseiller
	 *            le numero du Conseiller   r cup rer 
	 * @return 	le Conseiller  trouv閿燂拷;
	 * 			null si aucun Conseiller ne correspond 閿燂拷 cet identifiant
	 */
/*	public Conseiller getConseiller(int idConseiller) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Conseiller retour = null;

		// connexion 閿燂拷 la base de donn闂佹唶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Conseiller WHERE IdConseiller = ?");
			ps.setInt(1, idConseiller);

			// on ex闂佸紪te la requ闂冪穩
			// rs contient un pointeur situ閿燂拷 juste avant la premi�?碱晪 ligne
			// retourn闂侊拷
			rs = ps.executeQuery();
			// passe 閿燂拷 la premi�?碱晪 (et unique) ligne retourn闂侊拷
			if (rs.next())
				retour = new Conseiller(rs.getInt("idConseiller"),
						rs.getString("civiliteConseiller"),
						rs.getString("dateNaissanceConseiller"));

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
	/*public int deleteConseiller(int idConseiller) {

		Connection con = null;
		PreparedStatement ps = null;
		
		int  retour = 0;

		// connexion 閿燂拷 la base de donn闂佹唶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE  FROM Conseiller WHERE idConseiller = ?");
			ps.setInt(1, idConseiller);

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
	 * permet d'alligner les identifiants pr sents dans la table Conseillers 
	 * 	
	 */
	/*public ArrayList idConseiller(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList retour = new ArrayList<Integer>();
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT IdConseiller FROM Conseiller");

			// on ex闂佸紪te la requ闂冪穩
			rs = ps.executeQuery();
			// on parcourt les lignes du r闂佺�?ltat
			while (rs.next())
				retour.add( rs.getInt("IdConseiller"));

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
	 * Permet de r闂佸紪p闂佺�峳 tous les Conseillers stock闂侊拷 dans la table Conseiller
	 * 
	 * @return une ArrayList de Conseillers
	 */
	/*public List<Conseiller> getListeConseiller() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Conseiller> retour = new ArrayList<Conseiller>();

		// connexion 閿燂拷 la base de donn闂佹唶
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Conseiller");

			// on ex闂佸紪te la requ闂冪穩
			rs = ps.executeQuery();
			// on parcourt les lignes du r闂佺�?ltat
			while (rs.next())
				retour.add(new Conseiller(rs.getInt("IdConseiller"), rs
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
	//	ConseillerDAO cd = new ConseillerDAO();
	
		
		//Conseiller f = new Conseiller("JIOO","HB","HB","IHO","1988-11-08","B",666679);
		
		//cd.ajouter(f);
		//Conseiller c=cd.connexionConseiller("yacine@banques8.fr","samba");
	
		//Conseiller c=cd.getConseillerByEmail("yacine@banques8.fr");
		
	//	System.out.println(c);
	//}
	
}


	

