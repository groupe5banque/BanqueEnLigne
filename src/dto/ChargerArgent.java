package dto;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;

import dao.ClientDAO;
import dao.CompteDAO;
import dao.HistoriqueDAO;


/**
 * Servlet implementation class Home
 */
@WebServlet("/ChargerArgent")
public class ChargerArgent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String sql = "";
	CompteDAO cd = new CompteDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChargerArgent() {
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
		doGet(request, response);
		
	   
	    
	    
		//Recuperation des donnees
		
		HttpSession session = request.getSession();
		String montant = (String) request.getParameter("Montant");
		String typeC = request.getParameter("typeC");
		String numeroCompte;
		String soldeC;
		Double MontantS;
		String montantS;
		int t=0;
		int o=0;
		Double m;
		int idClient=(int)session.getAttribute("IdClient");
		HistoriqueDAO hd=new HistoriqueDAO();
		Date today;
	    today=new java.sql.Date(System.currentTimeMillis());
	    double montantD = Double.parseDouble(montant);
		
		try{
		
		m = Double.parseDouble(montant);
		o=1;
		}catch(Exception e){
			response.getWriter().write("Le montant doit etre un chiffre et ne peut pas etre null!");
			o=0;
		}
		
		if(o==1)
		{
		if(montant =="")
		{
			response.getWriter().write("Vous n'avez pas entre la montant!");
		}
		else
		{
		if(Double.parseDouble(montant)<=0)
		{
			 response.getWriter().write("La valeur de chargement ne peut pas egale ou inferieur a 0 !");
		}
	else
	{
	   switch(typeC)
	   {
	   case "Compte epargne":
			numeroCompte = request.getParameter("ceChoisi");
			soldeC = cd.getCompteNumero(numeroCompte).getSoldeBanque();
			MontantS = Double.parseDouble(soldeC) + Double.parseDouble(montant);
			montantS = MontantS.toString();
			t = cd.setSoldeCompte(numeroCompte, montantS);
						
			if(t==1)
			{		
			int IDCompte=cd.getIdCompte(numeroCompte);
					
			String nature = "Dépôt"+ cd.getCompteChoisi(IDCompte).getTypeCompte()+"N°"+numeroCompte;
			
			
			Historique his = new Historique(idClient,IDCompte,today,nature,montantD,0);
			hd.ajouter(his);
			
			System.out.println("Chargement réussi.");	 
			response.getWriter().write("Chargement reussi. \tSolde du compte "+numeroCompte+": "+MontantS);
			}
			else{
				response.getWriter().write("Echec de chargement.");
			}
		    break;
		    
	   case "Compte courant":
		    numeroCompte = request.getParameter("ccChoisi");
			soldeC = cd.getCompteNumero(numeroCompte).getSoldeBanque();
			MontantS = Double.parseDouble(soldeC) + Double.parseDouble(montant);
			montantS = MontantS.toString();
			t = cd.setSoldeCompte(numeroCompte, montantS);
			
			montantS = MontantS.toString();
			t = cd.setSoldeCompte(numeroCompte, montantS);
			
		    
		    if(t==1)
			{
		    	int IDCompte=cd.getIdCompte(numeroCompte);
				
				String nature = "Dépôt"+ cd.getCompteChoisi(IDCompte).getTypeCompte()+"N°"+numeroCompte;
				
				
				Historique his = new Historique(idClient,IDCompte,today,nature,montantD,0);
				hd.ajouter(his);
		   
			System.out.println("Chargement réussi.");
			
		    response.getWriter().write("Chargement reussi. \tSolde du compte "+numeroCompte+": "+montantS);
			}
			else{
				response.getWriter().write("Echec de chargement.");
			}
		    break;
		    
	   case "Compte titre":
		    numeroCompte = request.getParameter("ctChoisi");
			soldeC = cd.getCompteNumero(numeroCompte).getSoldeBanque();
		    MontantS = Double.parseDouble(soldeC) + Double.parseDouble(montant);
			montantS = MontantS.toString();
			t = cd.setSoldeCompte(numeroCompte, montantS);
			System.out.println("Chargement réussi.");
		    
		    if(t==1)
			{
		    	int IDCompte=cd.getIdCompte(numeroCompte);
				
				String nature = "Dépôt"+ cd.getCompteChoisi(IDCompte).getTypeCompte()+"N°"+numeroCompte;
				
				
				Historique his = new Historique(idClient,IDCompte,today,nature,montantD,0);
				hd.ajouter(his);
		    	
			System.out.println("Chargement réussi.");
		    response.getWriter().write("Chargement reussi. \tSolde du compte "+numeroCompte+": "+montantS);
			}
			else{
				response.getWriter().write("Echec de chargement.");
			}
		    break;
		   
	   }	
		}
		}
		}
		
		

		
       
		
		
		
		
		//this.getServletContext().getRequestDispatcher( "/ChargerArgent.jsp" ).forward( request, response);
		//this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);

	}

}
