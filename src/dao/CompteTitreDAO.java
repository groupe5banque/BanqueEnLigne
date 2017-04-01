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
 * DAO pour r¨¦cup¨¦rer les donn¨¦es du Compte epargne
 * @author AdeleSONG
 *
 */


public class CompteTitreDAO extends DAO{

	public CompteTitreDAO()
	{
		super();
	}
	
	public CompteTitre getCompteT(int idClientT, int idRIB)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;
		String sql;
		CompteTitre compteT = null;
		
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			System.out.println("Connected database successfully...");
			
			System.out.println("Creating statement...");
			sql = "SELECT idCompteTitre, soldeCompteTitre , idRIB, idClient FROM comptetitre WHERE idClient = ? AND idRIB = ?";
		    ps = con.prepareStatement(sql);
		    
		   
		    ps.setInt(1, idClientT);
		    ps.setInt(2, idRIB);
		    rs = ps.executeQuery();
		    	    
		    if(rs.next()){
		    	compteT = new CompteTitre(rs.getInt("idCompteTitre"),
		    											  rs.getDouble("soldeCompteTitre"),
		    											  rs.getInt("idRIB"),
		    											  idClientT);
		    	System.out.print("idCompteC:"+compteT.getIdComtpeTitre()+" solde:"+compteT.getSoldCompteTitre()+" RIB:"+rs.getInt("idRIB")+" idClient:"+ rs.getInt("idClient"));
		    }else
		    {
		    	System.out.print("No compte found.");
		    }
		}catch (Exception ee) {
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
		return compteT;

	}
	
	public ArrayList<CompteTitre> getListCompteTitre(int idClientT)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;
		String sql;
		CompteTitre compteT = null;
		ArrayList<CompteTitre> ALCompteT = new ArrayList<CompteTitre>();
		
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			System.out.println("Connected database successfully...");
			
			System.out.println("Creating statement...");
			sql = "SELECT idCompteTitre, soldeCompteTitre , idRIB, idClient FROM comptetitre WHERE idClient = ?";
		    ps = con.prepareStatement(sql);
		    
		   
		    ps.setInt(1, idClientT);
		    rs = ps.executeQuery();
		    	    
		    while(rs.next()){
		    	compteT = new CompteTitre(rs.getInt("idCompteTitre"),
		    											  rs.getDouble("soldeCompteTitre"),
		    											  rs.getInt("idRIB"),
		    											  idClientT);
		    	ALCompteT.add(compteT);
		    	
		    	//System.out.print("idCompteT:"+compteT.getIdCompteTitre()+" solde:"+compteT.getSoldeCompteTitre()+" RIB:"+rs.getInt("idRIB")+" idClient:"+ rs.getInt("idClient")+"\n");
		    }
		}catch (Exception ee) {
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
		return ALCompteT;

	}
	
	public static void main(String[] args) throws SQLException{
		CompteTitreDAO cd = new CompteTitreDAO();
		System.out.print(cd.getListCompteTitre(1).get(0).getSoldCompteTitre()+"\n"+cd.getListCompteTitre(1).get(1).getSoldCompteTitre());
	}

	
}
