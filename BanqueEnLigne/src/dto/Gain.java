package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ElementBourseDAO;
import dao.TitreDAO;

public class Gain {

	
	public double calculGain(int idClient,int idCompte){
		
		double gain=0;
		TitreDAO titredao= new TitreDAO();
		List<Titre> titres = new ArrayList<Titre>();
		ElementBourseDAO elem= new ElementBourseDAO();
		
		titres= titredao.getListeTitre(idClient, idCompte);
		for (int i =0 ; i<titres.size();i++){
			double montant= titres.get(i).getNombre()*titres.get(i).getPrix();
			double actuel= titres.get(i).getNombre()* Double.parseDouble(elem.getElement(titres.get(i).getNomTitre()).getActuel());
			//gain=(titres.get(i).getNombre()* Double.parseDouble(elem.getElement(titres.get(i).getNomTitre()).getActuel()) -titres.get(i).getNombre()*titres.get(i).getPrix());
			gain=gain+(actuel-montant);
			//System.out.println(montant);
			//System.out.println(actuel);
		}
	return gain;
				
	}
	
	
public double calculValeur(int idClient,int idCompte){
		
		double gain=0;
		TitreDAO titredao= new TitreDAO();
		List<Titre> titres = new ArrayList<Titre>();
		ElementBourseDAO elem= new ElementBourseDAO();
		double valeur=0;
		
		titres= titredao.getListeTitre(idClient, idCompte);
		for (int i =0 ; i<titres.size();i++){
			
			double actuel= titres.get(i).getNombre()* Double.parseDouble(elem.getElement(titres.get(i).getNomTitre()).getActuel());
			
			//gain=(titres.get(i).getNombre()* Double.parseDouble(elem.getElement(titres.get(i).getNomTitre()).getActuel()) -titres.get(i).getNombre()*titres.get(i).getPrix());
			
			valeur=valeur+actuel;
			//System.out.println(montant);
			//System.out.println(actuel);
		}
	return valeur;
				
	}
	
	
	// main permettant de tester la classe
		/*public static void main(String[] args) throws SQLException{
	     
			Gain g= new Gain();
			double gain=0;
			gain= g.calculValeur(1,19);

			System.out.println(gain);
			
			
		}
*/}
