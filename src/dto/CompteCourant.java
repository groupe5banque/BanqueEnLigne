package dto;

public class CompteCourant {
	private int idCompteCourant;
	private double soldeCompteCourant;
	private int idClient;
	private int idRIB;
	
	public CompteCourant(int idCompteCourant, double soldeCompteCourant,int idClient,int idRIB)
	{
		this.idCompteCourant = idCompteCourant;
		this.soldeCompteCourant = soldeCompteCourant;
		this.idClient = idClient;
		this.idRIB = idRIB;
	}

	public int getIdCompteCourant() {
		return idCompteCourant;
	}

	public void setIdCompteCourant(int idCompteCourant) {
		this.idCompteCourant = idCompteCourant;
	}

	public double getSoldeCompteCourant() {
		return soldeCompteCourant;
	}

	public void setSoldeCompteCourant(double soldeCompteCourant) {
		this.soldeCompteCourant = soldeCompteCourant;
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

	public void setIdRIB(int idRIB) {
		this.idRIB = idRIB;
	}
	
       
}
