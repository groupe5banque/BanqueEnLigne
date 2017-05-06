package dto;

public class Rib {

private int codeGuichet;
private String numeroDeCompte; 
private int clefRIB;
private int codeBanque;
public Rib()
{
	this.codeGuichet = 0;
	this.numeroDeCompte = null;
	this.clefRIB = 0;
	this.codeBanque = 0;
	
}
 public Rib (int codeBanque, int codeGuichet, String numeroDeCompte, int clefRIB)
 {
	 this.codeBanque=codeBanque;
	 this.codeGuichet = codeGuichet;
	 this.numeroDeCompte = numeroDeCompte;
	 this.clefRIB = clefRIB;
	 
 }
 
 public int getCodeBanque() {
 	return codeBanque;
 }
 public void setCodeBanque(int codeBanque) {
 	this.codeBanque = codeBanque;
 }
 public int getCodeGuichet() {
 	return codeGuichet;
 }
 public void setCodeGuichet(int codeGuichet) {
 	this.codeGuichet = codeGuichet;
 }
 public String getNumeroDeCompte() {
 	return numeroDeCompte;
 }
 public void setNumeroDeCompte(String numeroDeCompte) {
 	this.numeroDeCompte = numeroDeCompte;
 }
 public int getClefRIB() {
 	return clefRIB;
 }
 public void setClefRIB(int clefRIB) {
 	this.clefRIB = clefRIB;
 }
}
