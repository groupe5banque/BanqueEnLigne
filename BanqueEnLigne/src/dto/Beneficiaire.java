package dto;

public class Beneficiaire {

	
	public int getIdClient() {
		return idClient;
	}



	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}



	public String getNomben() {
		return nomben;
	}



	public void setNomben(String nomben) {
		this.nomben = nomben;
	}



	public String getPrenomben() {
		return prenomben;
	}



	public void setPrenomben(String prenomben) {
		this.prenomben = prenomben;
	}



	public String getIbanben() {
		return ibanben;
	}



	public void setIbanben(String ibanben) {
		this.ibanben = ibanben;
	}



	/**
	 * identifiant du client
	 */
	private int idClient;
	
	/**
	 * nom du bénéficiaire
	 */
	
	private String nomben;
	
	/**
	 * prénom du bénéficiaire
	 */
	
	private String prenomben;
	
	/**
	 * IBAN du bénéficiaire
	 */
	private String ibanben;
	
	
	
	/**
	 * 
	 * @param idClient
	 * @param nomben
	 * @param prenomben
	 * @param ibanben
	 */
	public Beneficiaire(int idClient, String nomben, String prenomben,String ibanben){
		
		this.idClient=idClient;
		this.nomben=nomben;
		this.prenomben=prenomben;
		this.ibanben=ibanben;
	}
}
