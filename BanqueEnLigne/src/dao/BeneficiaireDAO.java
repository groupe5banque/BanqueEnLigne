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
 * Classe d'acc闁硷拷 aux donn闂佹唶 contenues dans la table client
 * 
 * @author Prisca-Ana鍗痵
 * @version 1.2
 * */
public class BeneficiaireDAO {

	/**
	 * Param闁碱槝es de connexion 閿燂拷 la base de donn闂佹唶 orac URL, LOGIN et PASS
	 * sont des constantes
	 */
	
	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root";  //exemple BDD1
	final static String PASS = "root";   //exemple BDD1

	
	/**
	 * Constructeur de la classe
	 * 
	 */
	public BeneficiaireDAO() {
		// chargement du pilote de bases de donn闂佹唶
		
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}

	/**
	 * Permet d'ajouter un client dans la table client Le mode est auto-commit
	 * par d闂佹妺ut : chaque insertion est valid闂侊拷
	 * 
	 * @param Client
	 *            Client 閿燂拷 ajouter
	 * @return retourne le nombre de lignes ajout闂佹唶 dans la table
	 */
	public int ajouter(Beneficiaire ben) {
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
			ps = con.prepareStatement("INSERT INTO beneficiaire (idClient,nomben,prenomben,ibanben) VALUES (?,?,?,?)");
			ps.setInt(1, ben.getIdClient());
			ps.setString(2, ben.getNomben());
			ps.setString(3, ben.getPrenomben());
			ps.setString(4, ben.getIbanben());
			
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
	
	public List<Beneficiaire> getListeBeneficiaire(int identifiant) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Beneficiaire> retour = new ArrayList<Beneficiaire>();

		// connexion 猫艗鈥毭┞┞疵┾劉鈥� la base de donn猫艗鈥γ┧喡ッ︹�櫬柯矫ββ�
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM beneficiaire WHERE  idClient= ?");
			ps.setInt(1, identifiant);
			// on ex猫艗鈥γ┧喡ッ︹�溾�灻︹�孤穟te la requ猫艗鈥γㄢ�斅疵λ喡甧
			rs = ps.executeQuery();
			// on parcourt les lignes du r猫艗鈥γ┧喡ッ︹�欌�犆╨tat
			while (rs.next())
				retour.add(new Beneficiaire(rs.getInt("idClient"), rs.getString("nomben"),rs
						.getString("prenomben"),rs.getString("ibanben")));

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

	
}
	