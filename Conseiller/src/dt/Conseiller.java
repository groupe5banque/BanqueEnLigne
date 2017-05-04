package dt;

import java.util.Date;

import da.*;

/**
 * Classe Conseiller
 * @author SAMBA Yacine A.
 * @version 1.2
 * */

public class Conseiller {
	

	 /**
     * Civilite Conseiller
     */
    private String civiliteConseiller;
    /**
	 * adresse email
	 */
	private String emailConseiller;/** 
	 * Date of birth of the Conseiller 
	 */
	private String dateNaissanceConseiller;
	/**
	 * mot de passe Conseiller
	 */
	private String motDePasseConseiller;

    /**
	 *  Number
	 */
	private int telephoneConseiller;

	/** 
	 * Name 
	 */    
	private String nomConseiller;

	private String prenomConseiller;
	private int idConseiller;
	






	
		
	
	public Conseiller()
	{
		this.nomConseiller = null;
		this.prenomConseiller = null;
		this.civiliteConseiller = null;
		this.emailConseiller = null;
		this.dateNaissanceConseiller = null;
		this.motDePasseConseiller = null;
		this.telephoneConseiller = 0;

	}
	

	/**
	 * Constructeur
	 * @param idConseiller 
	 * @param  nomConseiller
	 * @param adresseConseiller
	 * @param nomContact NOM_CONTACT 
	 */
	public Conseiller(String nomConseiller,String prenomConseiller,String civiliteConseiller, String emailConseiller,String dateNaissanceConseiller,String motDePasseConseiller,int telephoneConseiller) {
		this.nomConseiller = nomConseiller;
		this.prenomConseiller = prenomConseiller;
		this.civiliteConseiller = civiliteConseiller;
		this.emailConseiller = emailConseiller;
		this.dateNaissanceConseiller = dateNaissanceConseiller;
		this.motDePasseConseiller = motDePasseConseiller;
		this.telephoneConseiller = telephoneConseiller;

		
	}
	public Conseiller(int idConseiller, String nomConseiller,String prenomConseiller,String civiliteConseiller, String emailConseiller,String dateNaissanceConseiller,String motDePasseConseiller,int telephoneConseiller) {
		this.idConseiller=idConseiller;
		this.nomConseiller = nomConseiller;
		this.prenomConseiller = prenomConseiller;
		this.civiliteConseiller = civiliteConseiller;
		this.emailConseiller = emailConseiller;
		this.dateNaissanceConseiller = dateNaissanceConseiller;
		this.motDePasseConseiller = motDePasseConseiller;
		this.telephoneConseiller = telephoneConseiller;
		
		
	}






	public String getCiviliteConseiller() {
		return civiliteConseiller;
	}







	public void setCiviliteConseiller(String civiliteConseiller) {
		this.civiliteConseiller = civiliteConseiller;
	}







	public String getEmailConseiller() {
		return emailConseiller;
	}







	public void setEmailConseiller(String emailConseiller) {
		this.emailConseiller = emailConseiller;
	}







	public String getDateNaissanceConseiller() {
		return dateNaissanceConseiller;
	}







	public void setDateNaissanceConseiller(String dateNaissanceConseiller) {
		this.dateNaissanceConseiller = dateNaissanceConseiller;
	}







	public String getMotDePasseConseiller() {
		return motDePasseConseiller;
	}







	public void setMotDePasseConseiller(String motDePasseConseiller) {
		this.motDePasseConseiller = motDePasseConseiller;
	}











	public int getTelephoneConseiller() {
		return telephoneConseiller;
	}







	public void setTelephoneConseiller(int telephoneConseiller) {
		this.telephoneConseiller = telephoneConseiller;
	}










	public String getNomConseiller() {
		return nomConseiller;
	}







	public void setNomConseiller(String nomConseiller) {
		this.nomConseiller = nomConseiller;
	}







	public String getPrenomConseiller() {
		return prenomConseiller;
	}


	public void setPrenomConseiller(String prenomConseiller) {
		this.prenomConseiller = prenomConseiller;
	}
	
	public int getIdConseiller() {
		return idConseiller;
	}


	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}


		

	

	/**
	 * Red finition de la m thode toString permettant de d finir la traduction de l'objet en String
	 * pour l'affichage par exemple
	 */
	public String toString() {
		return " [Conseiller: " +idConseiller  + " , " + nomConseiller
				+ ", " + emailConseiller+  " ]";
	}
}

