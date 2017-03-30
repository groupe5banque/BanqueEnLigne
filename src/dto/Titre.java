package dto;
import java.sql.Date;


public class Titre {

	private int idTitre;
	private double sommeTitre;
	private int idClient;
	private int idCompteTitre;
	private String nomTitre;
	private Date DateAchatTitre;
	
/**Constructor
 * 
 * @param idTitre
 * @param sommeTitre
 * @param idClient
 * @param idCompteTitre
 * @param nomTitre
 * @param DateAchatTitre
 */
	public Titre(int idTitre, double sommeTitre, int idClient, int idCompteTitre, String nomTitre,  Date DateAchatTitre )
	{
		this.idTitre = idTitre;
		this.sommeTitre = sommeTitre;
		this.idClient = idClient;
		this.idCompteTitre = idCompteTitre;
		this.nomTitre = nomTitre;
		this.DateAchatTitre = DateAchatTitre;
	}

public int getIdTitre() {
	return idTitre;
}

public void setIdTitre(int idTitre) {
	this.idTitre = idTitre;
}

public double getSommeTitre() {
	return sommeTitre;
}

public void setSommeTitre(double sommeTitre) {
	this.sommeTitre = sommeTitre;
}

public int getIdClient() {
	return idClient;
}

public void setIdClient(int idClient) {
	this.idClient = idClient;
}

public int getIdCompteTitre() {
	return idCompteTitre;
}

public void setIdCompteTitre(int idCompteTitre) {
	this.idCompteTitre = idCompteTitre;
}

public String getNomTitre() {
	return nomTitre;
}

public void setNomTitre(String nomTitre) {
	this.nomTitre = nomTitre;
}

public Date getDateAchatTitre() {
	return DateAchatTitre;
}

public void setDateAchatTitre(Date dateAchatTitre) {
	DateAchatTitre = dateAchatTitre;
}
	
	
}
