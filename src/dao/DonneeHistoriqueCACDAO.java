package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.*;

public class DonneeHistoriqueCACDAO {

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
	public DonneeHistoriqueCACDAO() {
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
	public int ajouter(DonneeHistoriqueCAC donneeHis) {
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
			ps = con.prepareStatement("INSERT INTO DonneeHistoriqueCAC (Date,DerniereValeur,Variation,Haut,Bas,Ouverture,Volume) VALUES (?,?,?,?,?,?)");
			ps.setString(1, donneeHis.getDate());
			ps.setString(2, donneeHis.getDerniereValeur());
			ps.setString(3, donneeHis.getVariation());
			ps.setString(4,donneeHis.getHaut());
			ps.setString(5, donneeHis.getBas());
			ps.setString(6, donneeHis.getOuverture());
			ps.setString(6, donneeHis.getVolume());
			
			
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
	
	public List<DonneeHistoriqueCAC> getListeDonneHis() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<DonneeHistoriqueCAC> retour = new ArrayList<DonneeHistoriqueCAC>();

		// connexion 猫鈥炩劉莽鈥氣�懊ㄢ�炩�斆┞┞疵ㄢ�炩�斆┾劉鈥� la base de donn猫鈥炩劉忙录锟矫ㄅ犫�櫭┧喡捖矫柯矫β猴拷芒鈥樎┟ワ拷鈥溍ㄢ�斅磗
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM DonneeHistorique");
			
			// on ex猫鈥炩劉忙录锟矫ㄅ犫�櫭┧喡捖矫柯矫β猴拷卯鈥÷访ε嘎德瑃e la requ猫鈥炩劉忙录锟矫ㄢ�灺Ｃㄢ�扳劉猫鈥炩�斆λ喡甧
			rs = ps.executeQuery();
			// on parcourt les lignes du r猫鈥炩劉忙录锟矫ㄅ犫�櫭┧喡捖矫柯矫β猴拷氓锟铰⒚╨tat
			while (rs.next())
				retour.add(new DonneeHistoriqueCAC(rs.getString("Date"), rs.getString("DerniereValeur"),rs
						.getString("Variation"),rs.getString("Haut"),rs.getString("Bas"),rs.getString("Ouverture"),rs.getString("Volume")));

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