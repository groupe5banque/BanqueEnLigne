package dto;
import java.util.Date;
import java.util.Date;
public class Historique {

		/**
		 * identifiant du client 
		 */
		
	   private int idClient_historique;
		/**
		 * identifiant du compte associé
		 */
		private int idCompte_historique;
		
		/**
		 * date de la transaction
		 */

	  private Date date;
	   
	     /**
	      * nature de la transaction
	      */

	 private String nature;
	 
	 /**
	  *montant de  crédit de la transaction
	  */
	 private int credit;
	 
	 /**
	  * montant de débit de la transaction
	  */
	 
	 private int debit;
	 
	 public Historique(int idClient_historique,int idCompte_historique,Date date,String nature,int credit,int debit ){
		 
		 this.credit=credit;
		 this.date=date;
		 this.debit=debit;
		 this.idClient_historique=idClient_historique;
		 this.idCompte_historique= idCompte_historique;
		 this.nature=nature;
	 }
	 
	
		
		public int getIdClient_historique() {
			return idClient_historique;
		}

		public void setIdClient_historique(int idClient_historique) {
			this.idClient_historique = idClient_historique;
		}

		public int getIdCompte_historique() {
			return idCompte_historique;
		}

		public void setIdCompte_historique(int idCompte_historique) {
			this.idCompte_historique = idCompte_historique;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getNature() {
			return nature;
		}

		public void setNature(String nature) {
			this.nature = nature;
		}

		public int getCredit() {
			return credit;
		}

		public void setCredit(int credit) {
			this.credit = credit;
		}

		public int getDebit() {
			return debit;
		}

		public void setDebit(int debit) {
			this.debit = debit;
		}
	}

	


