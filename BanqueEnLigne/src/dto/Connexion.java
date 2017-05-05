package dto;
import dao.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDAO;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String attribut_session = "sessionUtilisateur";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("ok");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ClientDAO cldao= new ClientDAO();
	    Client c1= null;
	    
	    String mail = request.getParameter("email");
	    String mdp = request.getParameter("password");
	    String type = request.getParameter("type");
	     
	    c1=cldao.connexionClient(mail,mdp);
	    
	    if(type.equals("manager")){
	    	
	    if(mail.equals("manager@banques8.fr")&&mdp.equals("manager"))
	    {
	    	
	  	    	
	  	    	this.getServletContext().getRequestDispatcher( "/ListeClient.jsp" ).forward( request, response);
	  	    
		    
	    }
	    
	    else {
	    	response.getWriter().println("<H1 class='text-center'> Identifiants manager incorrect! </H1>");
	    	response.getWriter().println("<BR> ");
	    	response.getWriter().println("<H2> Veuillez réessayer</H2>");
	    	response.getWriter().println("<BR> ");
	    	response.getWriter().println("<a href='Connexion.jsp'> Connexion</a>");
	    }
	    
	    }
	    
	    else{
	    
	    if (c1==null){
	    	//System.out.println("Identifiants erronés");
	    	response.getWriter().println("<H1 class='text-center'> Identifiants erronés! </H1>");
	    	response.getWriter().println("<BR> ");
	    	response.getWriter().println("<H2> Veuillez réessayer</H2>");
	    	response.getWriter().println("<BR> ");
	    	response.getWriter().println("<a href='index.jsp'> Connexion</a>");
	    }
	    else {

	    	  HttpSession session = request.getSession();
	    	 session.setAttribute( "client",c1 );
	    	
	    	this.getServletContext().getRequestDispatcher( "/PageAccueilClient.jsp" ).forward( request, response);
	    }
	    }
	}

}
