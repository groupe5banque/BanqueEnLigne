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
	    
	     
	    c1=cldao.connexionClient(mail,mdp);
	    
	    if (c1==null){
	    	System.out.println("Identifiants erronés");
	    }
	    else {

	    	  HttpSession session = request.getSession();
	    	 session.setAttribute( "client",c1 );
	    	
	    	this.getServletContext().getRequestDispatcher( "/PageAccueilClient.jsp" ).forward( request, response);
	    }
	    
	}

}
