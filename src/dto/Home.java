package dto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDAO;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
		
		ClientDAO dao= new ClientDAO();
	    Client c1= new Client();
	    
	    
		//Recuperation des donnees
		
	    System.out.println(" TEST");
		String name = (String) request.getParameter("name");
		String surname = (String) request.getParameter("surname");
		String civilite = (String) request.getParameter("civilite");
		String mail = (String) request.getParameter("mail");
		String birthday = (String) request.getParameter("birthday");
		String mdp = (String) request.getParameter("mdp");
		String nationalite= (String) request.getParameter("nationalite");
		String type_compte = (String) request.getParameter("type_compte");
		String phone = (String) request.getParameter("phone");
		String adresse = (String) request.getParameter("adresse");
		String code_postal = (String) request.getParameter("code_postal");
		String ville = (String) request.getParameter("ville");
		String pays = (String) request.getParameter("pays");
		
		System.out.println(" TEST");
		

		int tel= Integer.parseInt(phone);
		int code= Integer.parseInt(code_postal);


		c1 = new Client( name,surname, civilite,mail,birthday,mdp,nationalite,type_compte,tel,adresse,code,ville,pays);
		
		try{
		int retour = dao.ajouter(c1);
		System.out.println(retour + " lignes ajoutes");
		}catch(Exception e)
		{
			System.out.print("error");
		}
		
		
		this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
		//this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);

	}

}
