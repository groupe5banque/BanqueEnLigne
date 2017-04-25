package dao;
import dto.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ElementBourseDAO {
	
	/**
	 * Param茅鈥撀济溗渆s de connexion 茅鈥澟该柯� la base de donn茅鈥旓拷忙鈥犫�� oracle URL, LOGIN et PASS
	 * sont des constantes
	 */
	
	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root";  //exemple BDD1
	final static String PASS = "root";   //exemple BDD1

	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public ElementBourseDAO(){

		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}

	/**
	 * 
	 * 
	 * Permet de avoir la list de tous les comptes courant d'un client.
	 * 	
	 */
	public ArrayList<ElementBourse> getListeActions(){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList actions = new ArrayList<ElementBourse>();
		ElementBourse elem = null;
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			
			ps = con.prepareStatement("SELECT * FROM bourse ");
			// on ex茅鈥旓拷氓录鈥搕e la requ茅鈥斊捗封偓
			rs = ps.executeQuery();
			// on parcourt les lignes du r茅鈥旓拷莽鈥灺╨tat
			while (rs.next())
			{
			elem = new ElementBourse(rs.getString("nomEnt"),rs.getString("ouverture"),rs.getString("haut"),rs.getString("bas"),rs.getString("volume"),rs.getString("veille"),rs.getString("actuel"),rs.getString("variation"));	
            actions.add(elem);}
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
		return actions;

	}
	
	public ElementBourse getElement(String nom) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ElementBourse elem = null;
		
		// connexion 猫鈥灺� la base de donn猫艗鈥s
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM bourse WHERE nomEnt = ?");
			ps.setString(1, nom);

			// on ex猫艗鈥ute la requ茅鈥澟e
			// rs contient un pointeur situ猫艗鈥� juste avant la premi莽艗芦re ligne
			// retourn猫艗鈥
			rs = ps.executeQuery();
			// passe 猫鈥灺� la premi莽艗芦re (et unique) ligne retourn猫艗鈥
			if (rs.next())
				elem = new ElementBourse(rs.getString("nomEnt"),rs.getString("ouverture"),
						rs.getString("haut"),rs.getString("bas"),rs.getString("volume"),
						rs.getString("veille"),rs.getString("actuel"),rs.getString("variation"));

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
		return elem;

	}
}
