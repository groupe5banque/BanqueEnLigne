package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dt.Historique;
import dto.Releve;

public class CsvReleveDAO implements ReleveDao{

	
	/**
	 * Parametres de connexion a la base de donnees oracle URL, LOGIN et PASS
	 * sont des constantes
	 */
	
	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root";  
	final static String PASS = "root";   
	
	
	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public CsvReleveDAO() {
		// chargement du pilote de bases de donné—�æ†‡
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}
	
	@Override
	public List<Releve> FindReleveDuMois(int idClient,int idCompte, int mois) {
		
		List<Releve> Releves = new ArrayList <Releve>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT historique.idClient, historique.idCompte,CAST(compte.soldeBanque as DECIMAL(9,2))soldeBanque,historique.date, historique.nature, historique.debit, historique.credit FROM historique INNER JOIN compte ON historique.idCompte = compte.idCompte WHERE historique.idClient= ? AND historique.idCompte = ? AND month(historique.date)=? ORDER BY date ASC");
			ps.setInt(1, idClient);
			ps.setInt(2, idCompte);
			ps.setInt(3, mois);
			
			// on execute la requete
			rs = ps.executeQuery();
			// on recupere le resultat
			
			while(rs.next())
				Releves.add(new Releve(rs.getBigDecimal("soldeBanque").floatValue(),rs.getInt("idClient"), rs.getInt("idCompte"),rs
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
		return Releves;
	}

	/*public static void main(String[] args)throws SQLException{
		
		CsvReleveDAO dao1 = new CsvReleveDAO();
		
		List<Releve> releves = dao1.FindReleveDuMois(1,2,4);
		
		for(Releve tr: releves){
			
		
		if (releves != null)
		{
				String solde= Float.toString(tr.getSoldeClient_Releve());
				
				System.out.println(solde);
				
				String credit= Integer.toString(tr.getCredit());
				
				System.out.println(credit);
				
				String debit= Integer.toString(tr.getDebit());
				
				System.out.println(debit);
			
				String idClient_Releve= Integer.toString(tr.getIdClient_Releve());
				
				System.out.println(idClient_Releve);
				
				String idCompte_Releve= Integer.toString(tr.getIdCompte_Releve());
				
				System.out.println(idCompte_Releve);
				
				System.out.println(tr.getNature());
				
				
				if (tr.getDate() != null)
				{
					DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
					String birth = date.format(tr.getDate());

					System.out.println(birth);
				}
		
		}
			
		}
		
	}
	*/
}
