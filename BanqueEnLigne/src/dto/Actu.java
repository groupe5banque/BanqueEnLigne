
package dto;

import java.io.IOException;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDAO;
import dao.CodeDAO;
import dao.CompteDAO;
import dao.RibDAO;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Actu")
public class Actu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Actu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);


		//Actualites
		String themeAttr=(String)request.getParameter("theme");
	 	request.setAttribute("themeAttr", themeAttr);
		
			
		this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
		//this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
		

		

	}

}
