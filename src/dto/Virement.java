package dto;

import java.util.Date;

public class Virement {

	/**
	 * identifiant du client qui veut faire son virement
	 */
	private int idClient;
	/**
	 * numéro du compte émetteur
	 */
	private  String compteEmetteur;
	/**
	 * numéro du compte beneficiaire
	 */
	
	private String compteBeneficiaire;
	
	/**
	 * montant du virement
	 */
	
	private int montant;
	
	/**
	 * date du virement
	 */
	
	private Date date;
	
	/**
	 * motif du virement
	 */
	
	private String motif;
	
	
	public Virement(int idClient, String compteEmetteur,String compteBeneficiaire,int montant,Date date,String motif){
		
		this.idClient=idClient;
		this.compteEmetteur= compteEmetteur;
		this.compteBeneficiaire=compteBeneficiaire;
		this.montant = montant;
		this.date= date;
		this.motif= motif;
	}
	
	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}


	public String getCompteEmetteur() {
		return compteEmetteur;
	}


	public void setCompteEmetteur(String compteEmetteur) {
		this.compteEmetteur = compteEmetteur;
	}


	public String getCompteBeneficiaire() {
		return compteBeneficiaire;
	}


	public void setCompteBeneficiaire(String compteBeneficiaire) {
		this.compteBeneficiaire = compteBeneficiaire;
	}


	public int getMontant() {
		return montant;
	}


	public void setMontant(int montant) {
		this.montant = montant;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getMotif() {
		return motif;
	}


	public void setMotif(String motif) {
		this.motif = motif;
	}

	
}
