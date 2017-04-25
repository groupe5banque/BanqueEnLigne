package dto;

public class ElementBourse {

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getOuv() {
		return ouv;
	}


	public void setOuv(String ouv) {
		this.ouv = ouv;
	}


	public String getHaut() {
		return haut;
	}


	public void setHaut(String haut) {
		this.haut = haut;
	}


	public String getBas() {
		return bas;
	}


	public void setBas(String bas) {
		this.bas = bas;
	}


	public String getVolume() {
		return volume;
	}


	public void setVolume(String volume) {
		this.volume = volume;
	}


	public String getVeille() {
		return veille;
	}


	public void setVeille(String veille) {
		this.veille = veille;
	}


	public String getActuel() {
		return actuel;
	}


	public void setActuel(String actuel) {
		this.actuel = actuel;
	}


	public String getVar() {
		return var;
	}


	public void setVar(String var) {
		this.var = var;
	}


	/**
	 * nom de l'entreprise
	 */
	
	private String nom;
	
	/**
	 * prix à l'ouverture
	 */
	
	private String ouv;
	
	/**
	 * prix le plus haut
	 */
	private String haut;
	
	/**
	 * prix le plus bas
	 */
	
	private String bas;
	/**
	 * volume d'actions
	 */
	private String volume;
		
	/**
	 * prix de la veille
	 */
	private String veille;
	
	/**
	 * prix actuel
	 */
	private String actuel;
	
	/**
	 * variation
	 */
	private String var;
	
	
	public  ElementBourse(String nom,String ouv,String haut,String bas,String volume,String veille,String actuel,String var){
		this.nom=nom;
		this.ouv=ouv;
		this.haut=haut;
		this.bas=bas;
	    this.volume=volume;
	    this.veille=veille;
	    this.actuel=actuel;
	    this.var=var;
				
	}
}
