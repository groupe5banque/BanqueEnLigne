package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.*;

public class HistoriqueDAO {

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
	public HistoriqueDAO() {
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
	public int ajouter(Historique historique) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion 茂驴陆 la base de donn茅鈥撯�榮
		try {
			
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pr茅鈥撆揳ration de l'instruction SQL, chaque ? repr茅鈥撆竐nte une valeur
			// 茂驴陆 communiquer dans l'insertion
			// les getters permettent de r茅鈥擄拷up茅鈥撆緀r les valeurs des attributs
			// souhait茅鈥撆�
			ps = con.prepareStatement("INSERT INTO historique (idClient,idCompte,date,nature,debit,credit) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, historique.getIdClient_historique());
			ps.setInt(2, historique.getIdCompte_historique());
			ps.setDate(3, (Date) historique.getDate());
			ps.setString(4, historique.getNature());
			ps.setInt(5, historique.getDebit());
			ps.setInt(6, historique.getCredit());
			
			
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
	
	// retourne une liste d'historique en fonction de l'identifiant du client et du compte s脙漏lectionn脙漏
	
	public List<Historique> getListeCompte( int identClient,int identCompte) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Historique> retour = new ArrayList<Historique>();

		// connexion 脙炉脗驴脗陆 la base de donn脙漏芒鈧�溍⑩偓藴s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM historique WHERE  idClient= ? AND idCompte = ? ORDER BY date ASC");
			ps.setInt(1, identClient);
			ps.setInt(2, identCompte);
			// on ex脙漏芒鈧�溍柯絬te la requ脙漏脣艙脗戮e
			rs = ps.executeQuery();
			// on parcourt les lignes du r脙漏芒鈧�溍吢竨ltat
			while (rs.next())
				retour.add(new Historique(rs.getInt("idClient"), rs.getInt("idCompte"),rs
						.getDate("date"),rs.getString("nature"),rs.getInt("credit"),rs.getInt("debit")));

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
	// main permettant de tester la classe
		/*public static void main(String[] args)  {
	     
			HistoriqueDAO historiqueDAO = new HistoriqueDAO();
			//test de la m茅鈥撀爃ode 
		     
    List<Historique> retour = new ArrayList<Historique>();
	retour=historiqueDAO.getListeCompte(2,1);
			for (int i=0; i<retour.size();i++){
				System.out.println(retour.get(i).getNature());
			}
			
		}*/
	
	
}
	