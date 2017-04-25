package dto;
import dao.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AjoutBeneficiaire
 */
@WebServlet("/AjoutBeneficiaire")
public class AjoutBeneficiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutBeneficiaire() {
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
		
		BeneficiaireDAO bendao= new BeneficiaireDAO();
		Beneficiaire ben=null;
		//récupération des éléments saisis
		String nom = (String) request.getParameter("nom");
		String prenom = (String) request.getParameter("prenom");
		String iban = (String) request.getParameter("iban");
	
		HttpSession session = request.getSession();
		
		Client client=null;
		
		 ClientDAO cdao=new ClientDAO();
	     client= (Client)session.getAttribute("client");
	     int identifiant=0; 
	     String mail= client.getEmailClient();
	     identifiant=cdao.getIdClient(mail);
		
		try{
			
			ben= new Beneficiaire(identifiant,nom,prenom,iban);
			int retour = bendao.ajouter(ben);
			
			}catch(Exception e)
			{
				System.out.print("error");
			}
			
	}

}
