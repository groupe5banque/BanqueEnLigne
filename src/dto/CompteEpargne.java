package dto;

public class CompteEpargne {

	private int idCompteEpargne;
	private double soldCompteEpargne;
	private int idClient;
	private int idRIB;

	/**constructor
	 * 
	 * @param idCompteEpargne
	 * @param soldCompteEpargne
	 * @param idRIB
	 * @param idClient
	 */
	public CompteEpargne(int idCompteEpargne,double soldCompteEpargne,int idRIB,int idClient)
	{
		this.idCompteEpargne = idCompteEpargne;
		this.soldCompteEpargne = soldCompteEpargne;
		this.idRIB = idRIB;
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

	public int getIdRIB() {
		return idRIB;
	}

	public void setRIB(int idRIB) {
		idRIB = idRIB;
	}
	
	
}
