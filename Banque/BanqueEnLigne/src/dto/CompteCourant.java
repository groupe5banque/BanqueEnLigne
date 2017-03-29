
public class CompteCourant {
	
	private int idCompteCourant;
	private double soldCompteCourant;
	private String RIB;
	private int idClient;
	
	/**Constructor
	 * 
	 * @param idCompteCourant
	 * @param soldCompteCourant
	 * @param RIB
	 * @param idClient
	 */
	public CompteCourant(int idCompteCourant, double soldCompteCourant, String RIB, int idClient)
	{
		this.idCompteCourant = idCompteCourant;
		this.soldCompteCourant = soldCompteCourant;
		this.RIB = RIB;
		this.idClient = idClient;
	}

	public int getIdCompteCourant() {
		return idCompteCourant;
	}

	public void setIdCompteCourant(int idCompteCourant) {
		this.idCompteCourant = idCompteCourant;
	}

	public double getSoldCompteCourant() {
		return soldCompteCourant;
	}

	public void setSoldCompteCourant(double soldCompteCourant) {
		this.soldCompteCourant = soldCompteCourant;
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
