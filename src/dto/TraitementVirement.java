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
	    int o=0;
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
	  	 double montantd=0;
	    
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
	   
	  double montantEm = Double.parseDouble(compteEm.getSoldeBanque());
	 double montantBe= Double.parseDouble(compteBe.getSoldeBanque());
	  
	  
	  // System.out.println(natureEm);
	  // System.out.println(natureBen);
	  //System.out.println( compteEmetteur);
	  // System.out.println( compteBeneficiaire);
	   
      
      
      try{
  		
  		montantd = Double.parseDouble(mont);
  		o=1;
  		}catch(Exception e){
  			this.getServletContext().getRequestDispatcher( "/ErreurMontant.jsp" ).forward( request, response);
  			o=0;
  		}
  		
  		if(o==1)
  		{
  		if(mont =="")
  		{
  			this.getServletContext().getRequestDispatcher( "/ErreurMontant.jsp" ).forward( request, response);
  		}
  		else
  		{
  		if(Double.parseDouble(mont)<=0)
  		{
  			this.getServletContext().getRequestDispatcher( "/ErreurMontant.jsp" ).forward( request, response);
  		}
    

      
	 if ( compteEmetteur.equals(compteBeneficiaire)==true){
		// System.out.println("Virement impossible entre deux comptes identiques");
		 this.getServletContext().getRequestDispatcher( "/ErreurComptesIdentiques.jsp" ).forward( request, response);
	 }
	 if ( compteEmetteur.equals(compteBeneficiaire)==false){
		 //System.out.println("Virement possible");
		 if (montantEm < montantd){
			// System.out.println("Virement impossible car le montant du virement est supérieur au solde du compte émetteur ");
			 this.getServletContext().getRequestDispatcher( "/ErreurSoldeInferieur.jsp" ).forward( request, response);
		 
		 }
		 if (montantEm >= montantd){
			  
			 
			// Actualisation du solde des deux comptes
			double montantActEm=montantEm -montantd;
			double montantActBen=montantBe + montantd;
			
			String montant1 =Double.toString(montantActEm);
			String montant2 =Double.toString(montantActBen);
			
		     cdao.setSoldeCompte( compteEmetteur, montant1);
		     cdao.setSoldeCompte( compteBeneficiaire, montant2);
			
			 // Ajout virement et historiques
		     //Ajout dans ma table historique	   
		      histEm= new Historique(identifiant,identCompteEm,df,natureEm,0,montantd);
		      histBen= new Historique(identifiant,identCompteBen,df,natureBen,montantd,0);
			    vir=new Virement(identifiant,compteEmetteur,compteBeneficiaire,montantd,df,motif);
			    retour= virdao.ajouter(vir);
			    retour=histDAO.ajouter(histEm);
			    retour=histDAO.ajouter(histBen);
			    
			 this.getServletContext().getRequestDispatcher( "/SuccesVirement.jsp" ).forward( request, response);
		 }
		   
	 
	
	 }    
	 

	}

  	}
	}
	}
