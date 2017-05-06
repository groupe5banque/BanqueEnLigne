package dto;
import java.sql.Date;


public class Titre {

	private int idTitre;
	private double prix;
	private int idClient;
	private int idCompteTitre;
	private String nomTitre;
	private Date DateTitre;
	private int nombre;
	private String type;
	


/**Constructor
 * 
 * @param idTitre
 * @param sommeTitre
 * @param idClient
 * @param idCompteTitre
 * @param nomTitre
 * @param DateAchatTitre
 */
	public Titre(double prix, int idClient, int idCompteTitre, String nomTitre,  Date DateTitre,int nombre )
	{
		
	    this.prix=prix;
		this.idClient = idClient;
		this.idCompteTitre = idCompteTitre;
		this.nomTitre = nomTitre;
		this.DateTitre = DateTitre;
		this.nombre=nombre;
		
	}

public int getIdTitre() {
	return idTitre;
}

public void setIdTitre(int idTitre) {
	this.idTitre = idTitre;
}

public double getPrix() {
	return prix;
}

public void setPrix(double prix) {
	this.prix = prix;
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

public Date getDateTitre() {
	return DateTitre;
}

public void setDateTitre(Date dateTitre) {
	DateTitre = dateTitre;
}

public int getNombre() {
	return nombre;
}

public void setNombre(int nombre) {
	this.nombre = nombre;
}
	
	
}
