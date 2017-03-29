
public class CompteTitre {

	private int idComtpeTitre;
	private double soldCompteTitre;
	private String RIB;
	private int idClient;
	
	/**Constructor
	 * 
	 * @param idComtpeTitre
	 * @param soldCompteTitre
	 * @param RIB
	 * @param idClient
	 */
	public CompteTitre(int idComtpeTitre, double soldCompteTitre, String RIB, int idClient )
	{
		this.idComtpeTitre = idComtpeTitre;
		this.soldCompteTitre = soldCompteTitre;
		this.RIB = RIB;
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

	public String getRIB() {
		return RIB;
	}

	public void setRIB(String rIB) {
		RIB = rIB;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	
	
}
