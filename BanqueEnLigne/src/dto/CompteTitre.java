package dto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import da.CompteDAO;
import dt.Compte;

/**
 * Servlet implementation class compteTitre
 */
@WebServlet("/compteTitre")
public class CompteTitre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompteTitre() {
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
 		  HttpSession session = request.getSession();
 		 
 	   
 	    Client cl= null;
 	    
 	    cl=(Client)session.getAttribute("client");
 	    
 		//Recuperation des donnees
 		
 		
 		 CompteDAO compteDAO= new CompteDAO();
 	     NumeroDeCompte num = new NumeroDeCompte();
 	     int retour=0;
 	     Compte compte= new Compte();
 	     Compte cT = null;
 	 	
 	 	try{
 	 		 compte= compteDAO.getCompte(cl.getIdClient());
 	 		  int codeGuichet= compte.getCodeGuichet();
 	 	     int codeBanque = compte.getCodeBanque();
 	 			int clefRIB= compte.getClefRIB();
 	 		   Compte test = null;
 	 		  String numero= null;
 	 		
 	 			do
 	 			{
 	 				numero=num.getNumeroDeCompte();
 	 				 test= compteDAO.getCompteNumero(numero);
 	 			}while(test!=null);
 	 			
 			cT= new Compte(cl.getIdClient(),codeGuichet,numero,clefRIB,codeBanque,"0","compte titre");
 			try{
 				retour = compteDAO.ajouter(cT);
 				System.out.println(retour + " lignes ajoutes");
 				}catch(Exception e)
 				{
 					System.out.print("error");
 				}
 			}catch(Exception e)
 			{
 				System.out.print("error");
 			}
 	    
        if(retour==1)
        {
     	   HttpSession compteTitre = request.getSession();
   	 	 compteTitre.setAttribute( "comptetitre",cT );
   		
   			
   		this.getServletContext().getRequestDispatcher( "/InformationCompteTitre.jsp" ).forward( request, response);
   		//this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
     	   
        }
 	 	 

 	}

 }
