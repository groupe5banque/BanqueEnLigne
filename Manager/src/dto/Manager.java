package dto;

import java.util.Date;

import dao.*;

/**
 * Classe Manager
 * @author SAMBA Yacine A.
 * @version 1.2
 * */

public class Manager {
	

	 /**
     * Civilite Manager
     */
    private String civiliteManager;
    /**
	 * adresse email
	 */
	private String emailManager;/** 
	 * Date of birth of the Manager 
	 */
	private String dateNaissanceManager;
	/**
	 * mot de passe Manager
	 */
	private String motDePasseManager;

    /**
	 *  Number
	 */
	private int telephoneManager;

	/** 
	 * Name 
	 */    
	private String nomManager;

	private String prenomManager;
	private int idManager;
	






	
		
	
	public Manager()
	{
		this.nomManager = null;
		this.prenomManager = null;
		this.civiliteManager = null;
		this.emailManager = null;
		this.dateNaissanceManager = null;
		this.motDePasseManager = null;
		this.telephoneManager = 0;

	}
	

	/**
	 * Constructeur
	 * @param idManager 
	 * @param  nomManager
	 * @param adresseManager
	 * @param nomContact NOM_CONTACT 
	 */
	public Manager(String nomManager,String prenomManager,String civiliteManager, String emailManager,String dateNaissanceManager,String motDePasseManager,int telephoneManager) {
		this.nomManager = nomManager;
		this.prenomManager = prenomManager;
		this.civiliteManager = civiliteManager;
		this.emailManager = emailManager;
		this.dateNaissanceManager = dateNaissanceManager;
		this.motDePasseManager = motDePasseManager;
		this.telephoneManager = telephoneManager;

		
	}
	public Manager(int idManager, String nomManager,String prenomManager,String civiliteManager, String emailManager,String dateNaissanceManager,String motDePasseManager,int telephoneManager) {
		this.idManager=idManager;
		this.nomManager = nomManager;
		this.prenomManager = prenomManager;
		this.civiliteManager = civiliteManager;
		this.emailManager = emailManager;
		this.dateNaissanceManager = dateNaissanceManager;
		this.motDePasseManager = motDePasseManager;
		this.telephoneManager = telephoneManager;
		
		
	}






	public String getCiviliteManager() {
		return civiliteManager;
	}







	public void setCiviliteManager(String civiliteManager) {
		this.civiliteManager = civiliteManager;
	}







	public String getEmailManager() {
		return emailManager;
	}







	public void setEmailManager(String emailManager) {
		this.emailManager = emailManager;
	}







	public String getDateNaissanceManager() {
		return dateNaissanceManager;
	}







	public void setDateNaissanceManager(String dateNaissanceManager) {
		this.dateNaissanceManager = dateNaissanceManager;
	}







	public String getMotDePasseManager() {
		return motDePasseManager;
	}







	public void setMotDePasseManager(String motDePasseManager) {
		this.motDePasseManager = motDePasseManager;
	}











	public int getTelephoneManager() {
		return telephoneManager;
	}







	public void setTelephoneManager(int telephoneManager) {
		this.telephoneManager = telephoneManager;
	}










	public String getNomManager() {
		return nomManager;
	}







	public void setNomManager(String nomManager) {
		this.nomManager = nomManager;
	}







	public String getPrenomManager() {
		return prenomManager;
	}


	public void setPrenomManager(String prenomManager) {
		this.prenomManager = prenomManager;
	}
	
	public int getIdManager() {
		return idManager;
	}


	public void setIdManager(int idManager) {
		this.idManager = idManager;
	}


		

	

	/**
	 * Red finition de la m thode toString permettant de d finir la traduction de l'objet en String
	 * pour l'affichage par exemple
	 */
	public String toString() {
		return " [Manager: " +idManager  + " , " + nomManager
				+ ", " + emailManager+  " ]";
	}
}

