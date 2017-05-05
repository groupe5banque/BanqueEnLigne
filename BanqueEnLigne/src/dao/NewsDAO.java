package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Client;
import dto.News;

public class NewsDAO extends DAO{
	public NewsDAO(){
		super();
	}
	
	public ArrayList<News> getAllNews() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<News>	AllNews = new ArrayList<News>();	
		
		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM news LIMIT 0,6");
			

			// on execute la requete
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			while (rs.next())
			{
				AllNews.add(new News(rs.getString("titre"),
						rs.getString("contenu"), rs.getString("theme"), rs.getTimestamp("timestamp"),rs.getInt("idimg")));
				
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
		return AllNews;
	}
	
	public ArrayList<News> getActuByTheme(String theme) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList <News> th = new ArrayList<News>();
		
		// connexion 脿 la base de donn茅es
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM news WHERE theme = ?");
			ps.setString(1, theme);

			// on ex茅cute la requ锚te
			// rs contient un pointeur situ茅 juste avant la premi猫re ligne
			// retourn茅e
			rs = ps.executeQuery();
			// passe 脿 la premi猫re (et unique) ligne retourn茅e
			while (rs.next())
				th.add(new News(rs.getString("titre"),
						rs.getString("contenu"), rs.getString("theme"), rs.getTimestamp("timestamp"),rs.getInt("idimg")));

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
		return th;

	}
	
/*	public static void main(String[] args)  {
		NewsDAO nd= new NewsDAO();
	 ArrayList<News> actu = nd.getActuByTheme("Nouvelles");
	 
	 System.out.println(actu);
	 
		}*/
		
}
