package dto;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListeClient
 */
@WebServlet("/ListeClient")
public class ListeClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeClient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//this.getServletContext().getRequestDispatcher("/ListeClient.jsp" ).forward( request, response );
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		String nom= (String) request.getParameter("NOM");
		
		request.setAttribute("NOM", nom);
		
		
	   	 request.setAttribute("b", request.getParameter("b"));
	   	 

		 String csv_string = request.getParameter("csv_data");
		String file_name = request.getParameter("file_name");
		//if(request.getParameter("C") == null){

		this.getServletContext().getRequestDispatcher("ListeClient.jsp" ).forward( request, response );
		
	}

}
