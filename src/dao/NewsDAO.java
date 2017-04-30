package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			ps = con.prepareStatement("SELECT * FROM news");
			

			// on execute la requete
			// rs contient un pointeur situé juste avant la première ligne
			// retournée
			rs = ps.executeQuery();
			// passe à la première (et unique) ligne retournée
			while (rs.next())
			{
				AllNews.add(new News(rs.getString("titre"),
						rs.getString("contenu"), rs.getTimestamp("timestamp"),rs.getInt("idimg")));
				
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
}
