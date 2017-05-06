package dto;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CompteDAO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.ClientDAO;

/**
 * Servlet implementation class Home
 */
@WebServlet("/ChoixListeHistorique")
public class ChoixListeHistorique extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChoixListeHistorique() {
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
		String TypeH = request.getParameter("typeH");
	    String IdClient = (String)session.getAttribute("IdClient");	
		session.setAttribute("IdClient",IdClient);
		
		System.out.println(TypeH);
		if(TypeH.equals("Les historique 3 mois précédents")||TypeH.equals("Les historiques 6 mois précédents"))
	{
		if(TypeH.equals("Les historique 3 mois précédents"))
		{
		    System.out.print("000000");
			response.sendRedirect( "ListeHistorique3mois.jsp" );
		}
		
		if(TypeH.equals("Les historiques 6 mois précédents"))
		{
			response.sendRedirect( "ListeHistorique6mois.jsp" );
		}
	}
else{
			System.out.println(TypeH);
	   	    session.setAttribute( "TypeH",TypeH );
	   	    response.sendRedirect( "ListeHistorique.jsp" );
			
	}
		
		
       
		
		
		
		
		

	}

}

