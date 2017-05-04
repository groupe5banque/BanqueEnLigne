package dto;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CompteDAO;
import dao.HistoriqueDAO;
import dao.*;
import dto.Compte;
import dto.Historique;
/**
 * Servlet implementation class AchatActions
 */
@WebServlet("/AchatActions")
public class AchatActions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AchatActions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//System.out.println("test0");
		int o =0;
		
		int nombre1=0;
		
		TitreDAO titredao= new TitreDAO();
		
		Titre titre = null;
		
		HistoriqueDAO histdao= new  HistoriqueDAO();
		
		Historique hist= null;
		
        ElementBourseDAO elemdao= new ElementBourseDAO();
        
        ElementBourse elem= null;
        
        CompteDAO comptedao= new CompteDAO();
        
        Compte compte=null;
        
        ClientDAO clientdao= new ClientDAO();
        
        Client client=null;
       
        
		     //date du jour
			Date df;
			
			  df=new java.sql.Date(System.currentTimeMillis());	
			    
			    // récupération du paramètre saisi
			  
			   String nombre = (String) request.getParameter("nombreAction");
			   
			   // récupération de la session
			   
			   HttpSession session = request.getSession();
			   
			   String nomAction= (String)session.getAttribute("action");
			   
			   // récupération du montant du titre concerné
			   
			   elem=elemdao.getElement(nomAction);
			   
			   String mont= elem.getActuel();
			   
			   double montant= Double.parseDouble(mont);
			   
			   // récupération du solde du compte titre associé
			   
			   String numero= (String)session.getAttribute("comptetitre");
			   
			   compte=comptedao.getCompteNumero(numero);
			   
			   String solde=compte.getSoldeBanque();
			   
			   double soldeCompte=Double.parseDouble(solde);
			   
			   //récupération du client connecté
			   
			   client= (Client)session.getAttribute("client");
			   
			   String Email= client.getEmailClient();
			   
			   int identifiant= clientdao.getIdClient(Email);
			   //System.out.println("test1");
		try{
	  		
			   nombre1= Integer.parseInt(nombre);
			 
			   o=1;
	  		
	  			
	  		}catch(Exception e){
	  			//System.out.println("test2");
	  			//response.getWriter().append("Le nombre ne doit pas avoir de lettres ").append(request.getContextPath());
	  			this.getServletContext().getRequestDispatcher( "/ErreurNombreSaisi.jsp" ).forward( request, response);
	  			o=0;
	  		}
	  		
	  		if(o==1)
	  		{
	  		if(nombre ==""){
	  			//System.out.println("test3");
	  			//response.getWriter().append("Le nombre ne doit pas être nul ").append(request.getContextPath());
	  			this.getServletContext().getRequestDispatcher( "/ErreurNombreSaisi.jsp" ).forward( request, response);
	  		}
	  		else
	  		{
	  		if(Double.parseDouble(nombre)<= 0)
	  			
	  		{
	  			//System.out.println("test4");
	  			//response.getWriter().append("Le nombre ne doit pas être négatif ").append(request.getContextPath());
	  			this.getServletContext().getRequestDispatcher( "/ErreurNombreSaisi.jsp" ).forward( request, response);
	  		}
			  		

	  		if (nombre1>500){
	  			//System.out.println("test5");
	  			//response.getWriter().append("Le nombre ne doit pas être supérieur à 500 ").append(request.getContextPath());
	  			this.getServletContext().getRequestDispatcher( "/ErreurNombreSuperieur.jsp" ).forward( request, response);
	  		}
	  		else {
	  			
	  			double montantTotal= montant*nombre1;
	  			if( montantTotal > soldeCompte) {
	  				//System.out.println("test6");
	  				//response.getWriter().append("Le solde de votre compte est insuffisant ").append(request.getContextPath());
	  				this.getServletContext().getRequestDispatcher( "/ErreurMontantInsuffisant.jsp" ).forward( request, response);
	  			}
	  			
	  			if(montantTotal <= soldeCompte) {
	  					  				int retour=0;
	  				// Recherche pour voir si le titre existe déjà
	  				
	  				titre=titredao.getTitre(nomAction, identifiant, comptedao.getCompteId(compte.getNumeroDeCompte()));
	  				retour=titredao.getIdTitre(nomAction, identifiant,comptedao.getCompteId(compte.getNumeroDeCompte()));
	  				//System.out.println(retour);
	  				
	  				if(titre == null) {
	  					
	  				// ajout des actions achetées dans la table titre de la bdd si le titre n'existe pas déjà
	  				
	  				titre=new Titre(montant,identifiant,comptedao.getCompteId(compte.getNumeroDeCompte()),elem.getNom(),(java.sql.Date)df,nombre1);
	  				
	  				titredao.ajouter(titre);
	  				//System.out.println("test 2");
	  				}
	  				
	  				else {
	  					// on actualise le nombre
	  					
	  					int nveauNombre= titre.getNombre() + nombre1;
	  					titredao.setSoldeNombre(retour, nveauNombre);
	  					//System.out.println("test 1");
	  				}
	  				// Actualisation du solde du compte
	  				
	  				double solde1=soldeCompte-montantTotal;
	  				
	  				String nveauSolde=Double.toString(solde1);
	  				
	  				comptedao.setSoldeCompte( compte.getNumeroDeCompte(), nveauSolde);
	  				
	  				// Ajout de l'opération dans l'historique du compte
	  				
	  				String nature= "Achat de " + nombre + " actions de " + elem.getNom() ;
	  				
	  				hist=new Historique (identifiant,comptedao.getCompteId(compte.getNumeroDeCompte()),(java.sql.Date)df,nature,0,montantTotal);
	  				
	  				histdao.ajouter(hist);
	  				
	  				// redirection sur la page avec affichage du portefeuille actuel
	  				//response.getWriter().append("Achat réussi ").append(request.getContextPath());
	  				this.getServletContext().getRequestDispatcher( "/AffichagePortefeuille.jsp" ).forward( request, response);
	  			}
	  		}
	}
	  		}
}
}
