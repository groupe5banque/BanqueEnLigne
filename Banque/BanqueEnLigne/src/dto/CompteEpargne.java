
public class CompteEpargne {

	private int idCompteEpargne;
	private double soldCompteEpargne;
	private int idClient;
	private String RIB;

	/**constructor
	 * 
	 * @param idCompteEpargne
	 * @param soldCompteEpargne
	 * @param RIB
	 * @param idClient
	 */
	public CompteEpargne(int idCompteEpargne,double soldCompteEpargne,String RIB,int idClient)
	{
		this.idCompteEpargne = idCompteEpargne;
		this.soldCompteEpargne = soldCompteEpargne;
		this.RIB = RIB;
		this.idClient = idClient;
	}

	public int getIdCompteEpargne() {
		return idCompteEpargne;
	}

	public void setIdCompteEpargne(int idCompteEpargne) {
		this.idCompteEpargne = idCompteEpargne;
	}

	public double getSoldCompteEpargne() {
		return soldCompteEpargne;
	}

	public void setSoldCompteEpargne(double soldCompteEpargne) {
		this.soldCompteEpargne = soldCompteEpargne;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getRIB() {
		return RIB;
	}

	public void setRIB(String rIB) {
		RIB = rIB;
	}
	
	
}
