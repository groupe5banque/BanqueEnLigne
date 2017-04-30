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
import java.sql.Timestamp;
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
 * DAO pour 脙漏tablir la connection
 * @author AdeleSONG
 *
 */
public class DAO {

	/**
	 * Param茅鈥樎es de connexion 茂驴陆 la base de donn茅鈥撯�榮 oracle URL, LOGIN et PASS
	 * sont des constantes
	 */
	
	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root";  //exemple BDD1
	final static String PASS = "Mmdpne1995";   //exemple BDD1

	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public DAO() {
		
		
		// chargement du pilote de bases de donn茅鈥撯�榮
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}
	
	
	public ArrayList<News> getNews() {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ArrayList<News>	news = new ArrayList<News>();	
		
		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM news ORDER BY id DESC LIMIT 0, 5");
			

			// on execute la requete
			// rs contient un pointeur situ茅 juste avant la premi猫re ligne
			// retourn茅e
			rs = ps.executeQuery();
			// passe 脿 la premi猫re (et unique) ligne retourn茅e
			if (rs.next())
				news.add(new News(rs.getString("titre"), rs.getString("contenu"), rs.getTimestamp("timestamp"),rs.getInt("idimgNews")));

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
		
		
	
			
		return news;

	}
}
