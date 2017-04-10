package dto;

public class Compte {
	 /**
     * identifiant du client
     */
    private int idClient;
   
	/**
     * Type de compte
     */
    private String typeCompte;
    /**
     * numero du compte
     */
    private String numeroDeCompte; 
    /**
     * code Guichet
     */
    private int codeGuichet;
    /**
     * clef RIB
     */
  
    private int clefRIB;
    /**
     * code de la Banque 
     */
    private int codeBanque;
    
    /**
     * solde du compte 
     */
    private String soldeBanque;
    public Compte()
    {
    	this.idClient = 0;
    	this.codeGuichet = 0;
    	this.numeroDeCompte = null;
    	this.clefRIB = 0;
    	this.codeBanque = 0;
    	this.soldeBanque = null;
    	this.typeCompte = null;
    	
    }
     public  Compte(int idClient, int codeGuichet, String numeroDeCompte,int clefRIB, int codeBanque, String soldeBanque, String typeCompte)
     {
    	 this.idClient = idClient;
     	this.codeGuichet = codeGuichet;
     	this.numeroDeCompte = numeroDeCompte;
     	this.clefRIB = clefRIB;
     	this.codeBanque = codeBanque;
     	this.soldeBanque = soldeBanque;
     	this.typeCompte = typeCompte;
    	 
     }
      
     public int getIdClient() {
 		return idClient;
 	}
 	public void setIdClient(int idClient) {
 		this.idClient = idClient;
 	}
 	public String getTypeCompte() {
 		return typeCompte;
 	}
 	public void setTypeCompte(String typeCompte) {
 		this.typeCompte = typeCompte;
 	}
 	public String getNumeroDeCompte() {
 		return numeroDeCompte;
 	}
 	public void setNumeroDeCompte(String numeroDeCompte) {
 		this.numeroDeCompte = numeroDeCompte;
 	}
 	public int getCodeGuichet() {
 		return codeGuichet;
 	}
 	public void setCodeGuichet(int codeGuichet) {
 		this.codeGuichet = codeGuichet;
 	}
 	public int getClefRIB() {
 		return clefRIB;
 	}
 	public void setClefRIB(int clefRIB) {
 		this.clefRIB = clefRIB;
 	}
 	public int getCodeBanque() {
 		return codeBanque;
 	}
 	public void setCodeBanque(int codeBanque) {
 		this.codeBanque = codeBanque;
 	}
 	public String getSoldeBanque() {
 		return soldeBanque;
 	}
 	public void setSoldeBanque(String soldeBanque) {
 		this.soldeBanque = soldeBanque;
 	}
    
}
