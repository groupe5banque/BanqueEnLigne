package dto;

import java.util.Date;

import dao.*;

/**
 * Classe CLIENT
 * @author Prisca -Hornela
 * @version 1.2
 * */

public class Client {
	

	 /**
     * Civilite client
     */
    private String civiliteClient;
    /**
	 * adresse email
	 */
	private String emailClient;/** 
	 * Date of birth of the client 
	 */
	private String dateNaissanceClient;
	/**
	 * mot de passe Client
	 */
	private String motDePasseClient;
	/**
	 * Type of nationality
	 */
	private String nationaliteClient;
	/**
	 * Type of compte
	 */
    private String typeCompte;
    /**
	 * Type of Number
	 */
	private int telephoneClient;
	/**
	 * Type of adresse 
	 */
	private String adresseClient;
	/**
	 * Code Postal of client
	 */
	private int codepostalClient;
	/**
	 * City of client
	 */
	private String villeClient;
	/**
	 * Country of client
	 */
	private String paysClient;	
	/** 
	 * Name of the client 
	 */    
	private String nomClient;
	/** 
	 * Surname of the client 
	 */
	private String prenomClient;
	
	
		
	
	public Client()
	{
		this.nomClient = null;
		this.prenomClient = null;
		this.civiliteClient = null;
		this.emailClient = null;
		this.dateNaissanceClient = null;
		this.motDePasseClient = null;
		this.nationaliteClient = null;
		this.typeCompte = null;
		this.telephoneClient = 0;
		this.adresseClient = null;
		this.codepostalClient = 0;
		this.villeClient = null;
		this.paysClient = null;
	}
	

	/**
	 * Constructeur
	 * @param idClient 
	 * @param  nomClient
	 * @param adresseClient
	 * @param nomContact NOM_CONTACT 
	 */
	public Client(String nomClient,String prenomClient,String civiliteClient, String emailClient,String dateNaissanceClient,String motDePasseClient,String nationaliteClient,String typeCompte,int telephoneClient,String adresseClient,int codepostalClient,String villeClient,String paysClient) {
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.civiliteClient = civiliteClient;
		this.emailClient = emailClient;
		this.dateNaissanceClient = dateNaissanceClient;
		this.motDePasseClient = motDePasseClient;
		this.nationaliteClient = nationaliteClient;
		this.typeCompte = typeCompte;
		this.telephoneClient = telephoneClient;
		this.adresseClient = adresseClient;
		this.codepostalClient = codepostalClient;
		this.villeClient = villeClient;
		this.paysClient = paysClient;
		
		
	}







	public String getCiviliteClient() {
		return civiliteClient;
	}







	public void setCiviliteClient(String civiliteClient) {
		this.civiliteClient = civiliteClient;
	}







	public String getEmailClient() {
		return emailClient;
	}







	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}







	public String getDateNaissanceClient() {
		return dateNaissanceClient;
	}







	public void setDateNaissanceClient(String dateNaissanceClient) {
		this.dateNaissanceClient = dateNaissanceClient;
	}







	public String getMotDePasseClient() {
		return motDePasseClient;
	}







	public void setMotDePasseClient(String motDePasseClient) {
		this.motDePasseClient = motDePasseClient;
	}







	public String getNationaliteClient() {
		return nationaliteClient;
	}







	public void setNationaliteClient(String nationaliteClient) {
		this.nationaliteClient = nationaliteClient;
	}







	public String getTypeCompte() {
		return typeCompte;
	}







	public void setTypeCompte(String typeCompte) {
		this.typeCompte = typeCompte;
	}







	public int getTelephoneClient() {
		return telephoneClient;
	}







	public void setTelephoneClient(int telephoneClient) {
		this.telephoneClient = telephoneClient;
	}







	public String getAdresseClient() {
		return adresseClient;
	}







	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}







	public int getCodepostalClient() {
		return codepostalClient;
	}







	public void setCodepostalClient(int codePostalClient) {
		this.codepostalClient = codePostalClient;
	}







	public String getVilleClient() {
		return villeClient;
	}







	public void setVilleClient(String villeClient) {
		this.villeClient = villeClient;
	}







	public String getPaysClient() {
		return paysClient;
	}







	public void setPaysClient(String paysClient) {
		this.paysClient = paysClient;
	}







	public String getNomClient() {
		return nomClient;
	}







	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}







	public String getPrenomClient() {
		return prenomClient;
	}







	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	


		

	

	/**
	 * Red finition de la m thode toString permettant de d finir la traduction de l'objet en String
	 * pour l'affichage par exemple
	 */
/*	public String toString() {
		return " [Client: " +idClient  + " , " + nomClient
				+ ", " + adresseClient+  " ]";
	}*/
}

