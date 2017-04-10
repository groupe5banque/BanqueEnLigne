package dto;

import dao.*;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDAO;

/**
 * Servlet implementation class TraitementVirement
 */
@WebServlet("/TraitementVirement")
public class TraitementVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int retour;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraitementVirement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		VirementDAO virdao= new VirementDAO();
		CompteDAO cdao= new CompteDAO();
		HistoriqueDAO histDAO= new HistoriqueDAO();
			
	    Virement vir= null;
	    Client client = null;
	    Compte compteEm=null;
	    Compte compteBe=null;
	    Historique histEm=null;
	    Historique histBen=null;
	    
	    int identifiant=0;
		int identCompteEm=0;
		int identCompteBen=0;
		String natureEm="";
		String natureBen="";
		//date du jour
		Date df;
	    df=new java.sql.Date(System.currentTimeMillis());	
		
		// récupération des paramètres choisis et saisis
	    String compteEmetteur = request.getParameter("compteEmetteur");
	    String compteBeneficiaire = request.getParameter("compteBeneficiaire");
	    String mont = request.getParameter("montant");
	    String motif = request.getParameter("motif");
	    int montant = Integer.parseInt(mont);
	    
	    
	    HttpSession session = request.getSession();
	    
	   client= (Client)session.getAttribute("client");
	   
	   // récupération des comptes
	   compteEm=cdao.getCompteNumero(compteEmetteur);
	   compteBe=cdao.getCompteNumero(compteBeneficiaire);
	   
	   // récupération des identifiants du clients et des comptes concernés
	   identifiant= client.getIdClient();
	   identCompteEm= cdao.getIdCompte(compteEmetteur);
	   identCompteBen=cdao.getIdCompte(compteBeneficiaire);
	    
	   //System.out.println(identCompteEm);
	   //System.out.println(identCompteBen);
	   
	   
	   // nature de la transaction
	   natureEm= "Virement émis pour le "+ compteEm.getTypeCompte() +" N° " +compteEm.getNumeroDeCompte()+ "\n Motif:" + motif;
	   natureBen= "Virement reçu du "+ compteBe.getTypeCompte() +" N° "+ compteBe.getNumeroDeCompte()+ "\n Motif:" + motif;
	   
	  int montantEm = Integer.parseInt(compteEm.getSoldeBanque());
	 int montantBe= Integer.parseInt(compteBe.getSoldeBanque());
	   //Ajout dans ma table historique	   
      histEm= new Historique(identifiant,identCompteEm,df,natureEm,0,montant);
      histBen= new Historique(identifiant,identCompteBen,df,natureBen,montant,0);
	  
	  // System.out.println(natureEm);
	  // System.out.println(natureBen);
	  //System.out.println( compteEmetteur);
	  // System.out.println( compteBeneficiaire);
	   
    

      
	 if ( compteEmetteur.equals(compteBeneficiaire)==true){
		// System.out.println("Virement impossible entre deux comptes identiques");
		 this.getServletContext().getRequestDispatcher( "/ErreurComptesIdentiques.jsp" ).forward( request, response);
	 }
	 if ( compteEmetteur.equals(compteBeneficiaire)==false){
		 //System.out.println("Virement possible");
		 if (montantEm < montant){
			// System.out.println("Virement impossible car le montant du virement est supérieur au solde du compte émetteur ");
			 this.getServletContext().getRequestDispatcher( "/ErreurSoldeInferieur.jsp" ).forward( request, response);
		 
		 }
		 if (montantEm >= montant){
			  
			 
			// Actualisation du solde des deux comptes
			int montantActEm=montantEm -montant;
			int montantActBen=montantBe + montant;
			
			String montant1 =Integer.toString(montantActEm);
			String montant2 =Integer.toString(montantActBen);
			
		     cdao.setSoldeCompte( compteEmetteur, montant1);
		     cdao.setSoldeCompte( compteBeneficiaire, montant2);
			
			 // Ajout virement et historiques
			    vir=new Virement(identifiant,compteEmetteur,compteBeneficiaire,montant,df,motif);
			    retour= virdao.ajouter(vir);
			    retour=histDAO.ajouter(histEm);
			    retour=histDAO.ajouter(histBen);
			    
			 this.getServletContext().getRequestDispatcher( "/SuccesVirement.jsp" ).forward( request, response);
		 }
		   
	 
	
	 }    
	 

	}

}
