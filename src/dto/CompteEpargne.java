package dto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDAO;
import dao.CodeDAO;
import dao.CompteDAO;

/**
 * Servlet implementation class CompteEpargne
 */
@WebServlet("/CompteEpargne")
public class CompteEpargne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteEpargne() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		  HttpSession session = request.getSession();
		 
	   
	    Client cl= null;
	    
	    cl=(Client)session.getAttribute("client");
	    
		//Recuperation des donnees
		
		
		 CompteDAO compteDAO= new CompteDAO();
	     NumeroDeCompte num = new NumeroDeCompte();
	     int retour=0;
	     Compte compte= new Compte();
	     Compte cE = null;
	 	
	 	try{
	 		 compte= compteDAO.getCompte(cl.getIdClient());
	 		  int codeGuichet= compte.getCodeGuichet();
	 	     int codeBanque = compte.getCodeBanque();
	 			int clefRIB= compte.getClefRIB();
	 		   Compte test = null;
	 		  String numero= null;
	 		  int idClient=0;
	 			do
	 			{
	 				numero=num.getNumeroDeCompte();
	 				 test= compteDAO.getCompteNumero(numero);
	 			}while(test!=null);
	 			
			cE= new Compte(cl.getIdClient(),codeGuichet,numero,clefRIB,codeBanque,"0","compte epargne");
			try{
				retour = compteDAO.ajouter(cE);
				System.out.println(retour + " lignes ajoutes");
				}catch(Exception e)
				{
					System.out.print("ajout refusé");
				}
			}catch(Exception e)
			{
				System.out.print("aucune chose na marché");
			}
	    
       if(retour==1)
       {
    	   HttpSession compteEpargne = request.getSession();
  	 	 compteEpargne.setAttribute( "compte",cE );
  		
  			
  		this.getServletContext().getRequestDispatcher( "/InformationCompteEpargne.jsp" ).forward( request, response);
  		//this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
    	   
       }
	 	 

	}

}
