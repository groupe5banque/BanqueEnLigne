package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import dto.*;

public class HistoriqueDAO {

	/**
	 * Param猫艗鈥γ┧喡ッβㄅ矫溗渆s de connexion 猫艗鈥毭┞┞疵┾劉鈥� la base de donn猫艗鈥γ┧喡ッ︹�櫬柯矫ββ� oracle URL, LOGIN et PASS
	 * sont des constantes
	 */
	
	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root";  //exemple BDD1
	final static String PASS = "Mmdpne1995";   //exemple BDD1

	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public HistoriqueDAO() {
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
	public int ajouter(Historique historique) {
		Connection con = null;
		PreparedStatement ps = null;
		int retour = 0;

		// connexion 猫艗鈥毭┞┞疵┾劉鈥� la base de donn猫艗鈥γ┧喡ッ︹�櫬柯矫ββ�
		try {
			
			//DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			
			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// pr猫艗鈥γ┧喡ッ︹�欌�犆︼拷鲁ration de l'instruction SQL, chaque ? repr猫艗鈥γ┧喡ッ︹�欌�犆拷nte une valeur
			// 猫艗鈥毭┞┞疵┾劉鈥� communiquer dans l'insertion
			// les getters permettent de r猫艗鈥γ┧喡ッ︹�溾�灻︹�孤穟p猫艗鈥γ┧喡ッ︹�欌�犆封偓r les valeurs des attributs
			// souhait猫艗鈥γ┧喡ッ︹�欌�犆柯�
			ps = con.prepareStatement("INSERT INTO historique (idClient,idCompte,date,nature,debit,credit) VALUES (?,?,?,?,?,?)");
			ps.setInt(1, historique.getIdClient_historique());
			ps.setInt(2, historique.getIdCompte_historique());
			ps.setDate(3, (Date) historique.getDate());
			ps.setString(4, historique.getNature());
			ps.setDouble(5, historique.getDebit());
			ps.setDouble(6, historique.getCredit());
			
			
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
	
	// retourne une liste d'historique en fonction de l'identifiant du client et du compte s猫鈥炩劉忙录锟絣ectionn猫鈥炩劉忙录锟�
	
	public List<Historique> getListeCompte( int identClient,int identCompte) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Historique> retour = new ArrayList<Historique>();

		// connexion 猫鈥炩劉莽鈥氣�懊ㄢ�炩�斆┞┞疵ㄢ�炩�斆┾劉鈥� la base de donn猫鈥炩劉忙录锟矫ㄅ犫�櫭┧喡捖矫柯矫β猴拷芒鈥樎┟ワ拷鈥溍ㄢ�斅磗
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM historique WHERE  idClient= ? AND idCompte = ? ORDER BY date ASC");
			ps.setInt(1, identClient);
			ps.setInt(2, identCompte);
			// on ex猫鈥炩劉忙录锟矫ㄅ犫�櫭┧喡捖矫柯矫β猴拷卯鈥÷访ε嘎德瑃e la requ猫鈥炩劉忙录锟矫ㄢ�灺Ｃㄢ�扳劉猫鈥炩�斆λ喡甧
			rs = ps.executeQuery();
			// on parcourt les lignes du r猫鈥炩劉忙录锟矫ㄅ犫�櫭┧喡捖矫柯矫β猴拷氓锟铰⒚╨tat
			while (rs.next())
				retour.add(new Historique(rs.getInt("idClient"), rs.getInt("idCompte"),rs
						.getDate("date"),rs.getString("nature"),rs.getDouble("credit"),rs.getDouble("debit")));

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
	
	/**
	 * 
	 * @param nombreMois
	 * @return ArrayList des historiques nombreMois précédents
	 */
	public ArrayList<Historique> getMoisHistorique(int nombreMois, int idClient) {
        
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Historique> retour = new ArrayList<Historique>();
		ZoneId z = ZoneId.systemDefault();
		LocalDate today = LocalDate.now( z );
		LocalDate ThreeMonthBefore = today.minusMonths(nombreMois);
		Date datebefore = Date.valueOf(ThreeMonthBefore);
		
		System.out.println(ThreeMonthBefore);
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(df.format(ThreeMonthBefore));
		
		
		// connexion 脙炉脗驴脗陆 la base de donn脙漏芒鈧�溍⑩偓藴s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			if(idClient==0)
			{
			ps = con.prepareStatement("SELECT * FROM historique WHERE date > ?");
			ps.setDate(1, datebefore);				
			} 
			else
			{
				ps = con.prepareStatement("SELECT * FROM historique WHERE date > ? AND idClient = ?");
				ps.setDate(1, datebefore);	
				ps.setInt(2, idClient);
			}
			
			rs = ps.executeQuery();
			// on parcourt les lignes du r脙漏芒鈧�溍吢竨ltat
			while (rs.next()){
				retour.add(new Historique(rs.getInt("idClient"), rs.getInt("idCompte"),rs.getDate("date"),rs.getString("nature"),rs.getInt("credit"),rs.getInt("debit")));
				System.out.println(rs.getDate("date").toString());
			}
			
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

	/**
	 * 
	 * @param nombreMois
	 * @return ArrayList des historiques nombreMois précédents
	 */
	public ArrayList<Historique> getAnneeHistorique(int annee, int idClient) {
        
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Historique> retour = new ArrayList<Historique>();
		
		
		
		//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		//System.out.println(df.format(ThreeMonthBefore));
		
		// connexion 脙炉脗驴脗陆 la base de donn脙漏芒鈧�溍⑩偓藴s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			if(idClient==0)
		{	
			ps = con.prepareStatement("SELECT * FROM historique WHERE YEAR(date) = ?");
			ps.setInt(1, annee);
			
		}else{
			ps = con.prepareStatement("SELECT * FROM historique WHERE YEAR(date) = ? AND idClient = ?");
			ps.setInt(1, annee);
			ps.setInt(2, idClient);
			
		}
			rs = ps.executeQuery();
			// on parcourt les lignes du r脙漏芒鈧�溍吢竨ltat
			while (rs.next()){
				retour.add(new Historique(rs.getInt("idClient"), rs.getInt("idCompte"),rs.getDate("date"),rs.getString("nature"),rs.getInt("credit"),rs.getInt("debit")));
				System.out.println(rs.getDate("date").toString());
			}
			
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
			//test de la m猫艗鈥γ┧喡ッ︹�欌偓莽藛茠ode 
		     
    List<Historique> retour = new ArrayList<Historique>();
	retour=historiqueDAO.getListeCompte(2,1);
			for (int i=0; i<retour.size();i++){
				System.out.println(retour.get(i).getNature());
			}
			
		}*/
	
	
}
	