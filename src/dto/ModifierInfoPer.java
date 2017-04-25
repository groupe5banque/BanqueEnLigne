
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
 * Servlet implementation class ModifierInfoPer
 */
@WebServlet("/ModifierInfoPer")
public class ModifierInfoPer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierInfoPer() {
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
		ClientDAO dao= new ClientDAO();
	    Client c1= new Client();
	    Client C2= new Client();
	    Client cl= null;
	    
	    cl=(Client)session.getAttribute("client");
	    int a = 0;
	    a = cl.getIdClient();
		//Recuperation des donnees
		
	    System.out.println(" TEST");
		String name = (String) request.getParameter("name");
		String surname = (String) request.getParameter("surname");
		
		String adresse = (String) request.getParameter("adresse");
		String code_postal = (String) request.getParameter("code_postal");
		String ville = (String) request.getParameter("ville");
		String pays = (String) request.getParameter("pays");
		
		System.out.println(" TEST");
		

		
		int codePos= Integer.parseInt(code_postal);
       c1 = new Client( name,surname, cl.getCiviliteClient(),cl.getEmailClient(),cl.getDateNaissanceClient(),cl.getMotDePasseClient(),cl.getNationaliteClient(),cl.getTypeCompte(),cl.getTelephoneClient(),adresse,codePos,ville,pays);
		int retour=0;
		try{
		 retour = dao.modifierClient(c1,cl.getIdClient());
		System.out.println(retour + " ligne modifiée");
		
		}catch(Exception e)
		{
			System.out.print("error");
		}
		
		/**Génération de compte automatique**/
		
		  if(retour==1)
	       {
	    	  
			 
			 C2=new Client(a, name,surname, cl.getCiviliteClient(),cl.getEmailClient(),cl.getDateNaissanceClient(),cl.getMotDePasseClient(),cl.getNationaliteClient(),cl.getTypeCompte(),cl.getTelephoneClient(),adresse,codePos,ville,pays);
		     session.setAttribute( "client",C2);
	  			
	  		this.getServletContext().getRequestDispatcher( "/InfosPersonnellesClient.jsp" ).forward( request, response);
	  		//this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
	    	   
	       }
        
	   
		
		
			
		this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
		//this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);

	}

}