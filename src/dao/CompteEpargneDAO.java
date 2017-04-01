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


public class CompteEpargneDAO extends DAO{

	public CompteEpargneDAO()
	{
		super();
	}
	
	public CompteEpargne getCompteE(int idClientT,int idRIB)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;
		String sql;
		CompteEpargne compteE = null;
		
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			System.out.println("Connected database successfully...");
			
			System.out.println("Creating statement...");
			sql = "SELECT idCompteEpargne, soldeCompteEpargne , idRIB, idClient FROM compteepargne WHERE idClient = ? AND idRIB = ?";
		    ps = con.prepareStatement(sql);
		    
		   
		    ps.setInt(1, idClientT);
		    ps.setInt(2, idRIB);
		    rs = ps.executeQuery();
		    	    
		    if(rs.next()){
		    	compteE = new CompteEpargne(rs.getInt("idCompteEpargne"),
		    											  rs.getDouble("soldeCompteEpargne"),
		    											  rs.getInt("idRIB"),
		    											  idClientT);
		    	System.out.print("idCompteE:"+rs.getString("idCompteEpargne")+" solde:"+rs.getDouble("soldeCompteEpargne")+" RIB:"+rs.getInt("idRIB")+" idClient:"+ rs.getInt("idClient"));
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
		return compteE;

	}
	
	public ArrayList<CompteEpargne> getListCompteEpargne(int idClientT)
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int retour = 0;
		String sql;
		CompteEpargne compteE = null;
		ArrayList<CompteEpargne> ALCompteE = new ArrayList<CompteEpargne>();
		
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			System.out.println("Connected database successfully...");
			
			System.out.println("Creating statement...");
			sql = "SELECT idCompteEpargne, soldeCompteEpargne , idRIB, idClient FROM compteepargne WHERE idClient = ?";
		    ps = con.prepareStatement(sql);
		    
		   
		    ps.setInt(1, idClientT);
		    rs = ps.executeQuery();
		    	    
		    while(rs.next()){
		    	compteE = new CompteEpargne(rs.getInt("idCompteEpargne"),
		    											  rs.getDouble("soldeCompteEpargne"),
		    											  rs.getInt("idRIB"),
		    											  idClientT);
		    	ALCompteE.add(compteE);
		    	
		    	//System.out.print("idCompteC:"+compteC.getIdCompteCourant()+" solde:"+compteC.getSoldeCompteCourant()+" RIB:"+rs.getInt("idRIB")+" idClient:"+ rs.getInt("idClient")+"\n");
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
		return ALCompteE;

	}
	
	
	public static void main(String[] args) throws SQLException{
		CompteEpargneDAO cd = new CompteEpargneDAO();
		System.out.print(cd.getListCompteEpargne(1).get(0).getSoldCompteEpargne()+"\n"+cd.getListCompteEpargne(1).get(1).getSoldCompteEpargne());
	}

	
}
