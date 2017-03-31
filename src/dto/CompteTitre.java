package dto;
public class CompteTitre {

	private int idComtpeTitre;
	private double soldCompteTitre;
	private int idRIB;
	private int idClient;
	
	/**Constructor
	 * 
	 * @param idComtpeTitre
	 * @param soldCompteTitre
	 * @param idRIB
	 * @param idClient
	 */
	public CompteTitre(int idComtpeTitre, double soldCompteTitre, int idRIB, int idClient )
	{
		this.idComtpeTitre = idComtpeTitre;
		this.soldCompteTitre = soldCompteTitre;
		this.idRIB = idRIB;
		this.idClient = idClient;		
	}

	public int getIdComtpeTitre() {
		return idComtpeTitre;
	}

	public void setIdComtpeTitre(int idComtpeTitre) {
		this.idComtpeTitre = idComtpeTitre;
	}

	public double getSoldCompteTitre() {
		return soldCompteTitre;
	}

	public void setSoldCompteTitre(double soldCompteTitre) {
		this.soldCompteTitre = soldCompteTitre;
	}

	public int getIdRIB() {
		return idRIB;
	}

	public void setRIB(int idRIB) {
		idRIB = idRIB;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	
	
}
