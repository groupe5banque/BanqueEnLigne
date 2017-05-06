package dto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ClientDAO;

/**
 * Servlet implementation class TraitementR
 */
@WebServlet("/TraitementR")
public class TraitementR extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraitementR() {
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
		
		String IdClientGet= (String)request.getParameter("IdClient");
		int IdClient=0;
		int o=0;
		
			try{			
			IdClient = Integer.parseInt(IdClientGet);
			o=1;
			}catch(Exception e){		
			o=0;
			response.getWriter().write("Vous devez entrer un chiffre.");
			}
			
		if(o==1)
		{
			ClientDAO cd = new ClientDAO();
			int nc=cd.getListClient().size();
			
			
			if(IdClient > nc)
			{
				response.getWriter().write("Ce id n'existe pas.");
			}
			if(IdClient<=0)
			{
				response.getWriter().write("Id client doit être un chiffre positive non null");
			}
			
			if(IdClient>0&&IdClient<=nc)
			{
				HttpSession session = request.getSession();
		   	    session.setAttribute( "IdClient", IdClientGet);
		   	    response.getWriter().write("error");
		   	    //response.sendRedirect( "ReportingClient.jsp" );
			}
		}
		
	}

}
