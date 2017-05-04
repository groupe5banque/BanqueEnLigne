package dto;

public class DonneeHistoriqueCAC {

	

	/**
    * Date Donnée
    */
   private String Date;
   /**
	 * Derniere valeur avant 
	 */
	private String DerniereValeur;
	/** 
	 * Variation 
	 */
	private String Variation;
	/**
	 * La plus grande valeur
	 */
	private String Haut;
	/**
	 * la plus faible valeur
	 */
	private String Bas;
	/**
	 * La valeur à l'ouverture
	 */
   private String Ouverture;
   /**
	 * Volume de l'action
	 */
	private String Volume;
	/**
	 * Id donnee
	 */
	private int id;
	

	 public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}


	public String getDerniereValeur() {
		return DerniereValeur;
	}


	public void setDerniereValeur(String derniereValeur) {
		DerniereValeur = derniereValeur;
	}


	public String getVariation() {
		return Variation;
	}


	public void setVariation(String variation) {
		Variation = variation;
	}


	public String getHaut() {
		return Haut;
	}


	public void setHaut(String haut) {
		Haut = haut;
	}


	public String getBas() {
		return Bas;
	}


	public void setBas(String bas) {
		Bas = bas;
	}


	public String getOuverture() {
		return Ouverture;
	}


	public void setOuverture(String ouverture) {
		Ouverture = ouverture;
	}


	public String getVolume() {
		return Volume;
	}


	public void setVolume(String volume) {
		Volume = volume;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public DonneeHistoriqueCAC()
	{
		this.Date = null;
		this.DerniereValeur = null;
		this.Variation = null;
		this.Haut = null;
		this.Bas = null;
		this.Ouverture= null;
		this.Volume= null;
		
	}
	

	/**
	 * Constructeur
	 * @param idClient 
	 * @param  nomClient
	 * @param adresseClient
	 * @param nomContact NOM_CONTACT 
	 */
	public DonneeHistoriqueCAC(String Date,String DerniereValeur,String Variation, String Haut,String Bas,String Ouverture,String Volume) {
		this.Date = Date;
		this.DerniereValeur = DerniereValeur;
		this.Variation = Variation;
		this.Haut = Haut;
		this.Bas = Bas;
		this.Ouverture = Ouverture;
		this.Volume = Volume;
		
		
		
	}
	public DonneeHistoriqueCAC(int id,String Date,String DerniereValeur,String Variation, String Haut,String Bas,String Ouverture,String Volume) {
		this.id = id;
		this.Date = Date;
		this.DerniereValeur = DerniereValeur;
		this.Variation = Variation;
		this.Haut = Haut;
		this.Bas = Bas;
		this.Ouverture = Ouverture;
		this.Volume = Volume;
		
		
		
	}


	

}
