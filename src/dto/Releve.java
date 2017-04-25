package dto;
import java.util.Date;
public class Releve {

	
	/**
	 * Solde du client 
	 */
	
      private float SoldeClient_Releve;

		/**
		 * identifiant du client 
		 */
		
	   private int idClient_Releve;
		/**
		 * identifiant du compte associé
		 */
		private int idCompte_Releve;
		
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
	 
	 public Releve(float SoldeClient_Releve, int idClient_Releve,int idCompte_Releve,Date date,String nature,int credit,int debit ){
		 
		 this.SoldeClient_Releve= SoldeClient_Releve;
		 this.credit=credit;
		 this.date=date;
		 this.debit=debit;
		 this.idClient_Releve=idClient_Releve;
		 this.idCompte_Releve= idCompte_Releve;
		 this.nature=nature;
	 }
	 
	 public float getSoldeClient_Releve() {
			return SoldeClient_Releve;
		}



		public void setSoldeClient_Releve(float soldeClient_Releve) {
			SoldeClient_Releve = soldeClient_Releve;
		}
		
		
		public int getIdClient_Releve() {
			return idClient_Releve;
		}

		public void setIdClient_Releve(int idClient_Releve) {
			this.idClient_Releve = idClient_Releve;
		}

		public int getIdCompte_Releve() {
			return idCompte_Releve;
		}

		public void setIdCompte_Releve(int idCompte_Releve) {
			this.idCompte_Releve = idCompte_Releve;
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

	


