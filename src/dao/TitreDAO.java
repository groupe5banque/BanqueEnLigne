package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.*;


public class TitreDAO {


	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root";  //exemple BDD1
	final static String PASS = "Mmdpne1995";   //exemple BDD1
	
	public TitreDAO() {
		// chargement du pilote de bases de donn闂佹唶
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}
	
	public int ajouter(Titre titre) {
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
			ps = con.prepareStatement("INSERT INTO titre (nomTitre,prix,date,nombre,idClient,idCompte) VALUES (?,?,?,?,?,?)");
			ps.setString(1, titre.getNomTitre());
			ps.setDouble(2, titre.getPrix());
			ps.setDate(3, titre.getDateTitre());
			ps.setInt(4, titre.getNombre());
			ps.setInt(5, titre.getIdClient());
			ps.setInt(6, titre.getIdCompteTitre());
		
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
	 * 
	 * @param identClient
	 * @param identCompte
	 * @return
	 * Donne la liste des titres d'un compte titre associ茅 脿 un client
	 */
	
	public List<Titre> getListeTitre( int identClient,int identCompte) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Titre> retour = new ArrayList<Titre>();

		// connexion 猫鈥炩劉莽鈥氣�懊ㄢ�炩�斆┞┞疵ㄢ�炩�斆┾劉鈥� la base de donn猫鈥炩劉忙录锟矫ㄅ犫�櫭┧喡捖矫柯矫β猴拷芒鈥樎┟ワ拷鈥溍ㄢ�斅磗
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM titre WHERE  idClient= ? AND idCompte = ?");
			ps.setInt(1, identClient);
			ps.setInt(2, identCompte);
			// on ex猫鈥炩劉忙录锟矫ㄅ犫�櫭┧喡捖矫柯矫β猴拷卯鈥÷访ε嘎德瑃e la requ猫鈥炩劉忙录锟矫ㄢ�灺Ｃㄢ�扳劉猫鈥炩�斆λ喡甧
			rs = ps.executeQuery();
			// on parcourt les lignes du r猫鈥炩劉忙录锟矫ㄅ犫�櫭┧喡捖矫柯矫β猴拷氓锟铰⒚╨tat
			while (rs.next())
				retour.add(new Titre (rs.getDouble("prix"), rs.getInt("idClient"),rs
						.getInt("idCompte"),rs.getString("nomTitre"),rs.getDate("date"),rs.getInt("nombre")));

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
	
	// permet de modifier le nombre
	public int setSoldeNombre( int idTitre,int nombre)
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
					ps = con.prepareStatement("UPDATE titre SET nombre = ? WHERE idtitre = ? ");
					ps.setInt(1, nombre);
					ps.setInt(2, idTitre);
					
					
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
	public Titre getTitre(String nomTitre, int idClient, int idCompte) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Titre titre = null;
		
		// connexion 猫鈥灺� la base de donn猫艗鈥s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM titre WHERE nomTitre = ?  AND idClient=? AND idCompte=?");
			ps.setString(1, nomTitre);
			ps.setInt(2, idClient);
			ps.setInt(3, idCompte);

			// on ex猫艗鈥ute la requ茅鈥澟e
			// rs contient un pointeur situ猫艗鈥� juste avant la premi莽艗芦re ligne
			// retourn猫艗鈥
			rs = ps.executeQuery();
			// passe 猫鈥灺� la premi莽艗芦re (et unique) ligne retourn猫艗鈥
			if (rs.next())
				titre = new Titre (rs.getDouble("prix"),rs.getInt("idClient"),
						rs.getInt("idCompte"),rs.getString("nomTitre"),rs.getDate("date"),
						rs.getInt("nombre"));

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
		return titre;

	}
	
	public int getIdTitre(String nomTitre,int idClient, int idCompte){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		// connexion 猫鈥灺� la base de donn猫艗鈥s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idtitre FROM titre WHERE nomTitre = ?  AND idClient=? AND idCompte=? ");
			ps.setString(1,nomTitre );
			ps.setInt(2,idClient);
			ps.setInt(3,idCompte);
			
            
			// on ex猫鈥炩劉忙录锟絚ute la requ茅鈥澟e
			// rs contient un pointeur situ猫鈥炩劉忙录锟� juste avant la premi莽艗芦re ligne
			// retourn猫艗鈥�
			rs = ps.executeQuery();
			// passe 猫鈥炩劉猫锟铰� la premi猫鈥炩劉莽炉鈥渞e (et unique) ligne retourn猫鈥炩劉忙录锟絜
			if (rs.next())
				retour =rs.getInt("idtitre");

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
	
	public int getNombreTitre(String nomTitre){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;

		// connexion 猫鈥灺� la base de donn猫艗鈥s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT nombre FROM titre WHERE nomTitre = ?  ");
			ps.setString(1,nomTitre );
			
			
            
			// on ex猫鈥炩劉忙录锟絚ute la requ茅鈥澟e
			// rs contient un pointeur situ猫鈥炩劉忙录锟� juste avant la premi莽艗芦re ligne
			// retourn猫艗鈥�
			rs = ps.executeQuery();
			// passe 猫鈥炩劉猫锟铰� la premi猫鈥炩劉莽炉鈥渞e (et unique) ligne retourn猫鈥炩劉忙录锟絜
			if (rs.next())
				retour =rs.getInt("nombre");

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
}
