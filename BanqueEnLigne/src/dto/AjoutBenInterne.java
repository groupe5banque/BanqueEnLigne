package dto;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BeneficiaireDAO;
import dao.ClientDAO;
import dao.CompteDAO;

/**
 * Servlet implementation class AjoutBenInterne
 */
@WebServlet("/AjoutBenInterne")
public class AjoutBenInterne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutBenInterne() {
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
		//doGet(request, response);
		HttpSession session = request.getSession();	
		
		 Client client=null;
		
		 ClientDAO cdao=new ClientDAO();
		 
	     client= (Client)session.getAttribute("client");
	     
	     int identifiant=0; 
	     
	     String mail= client.getEmailClient();
	     
	     identifiant=cdao.getIdClient(mail); // identifiant client connect�
		  	
		
		 String email = (String) request.getParameter("mail");
		 
		 int iden= 0;
		 
		 iden=cdao.getIdClient(email); // identifiant b�n�ficiaire
		 
		 Client cl= null;
		 
		 cl=cdao.getClient(iden);
		 
		 BeneficiaireDAO bendao= new BeneficiaireDAO();
		 
		 if(cl==null) {
			 response.sendRedirect( "ClientIntrouvable.jsp" );
		 }
		 
		 else {
			 
			//r�cup�ration du compte courant associ� au b�n�ficiaire
			 
		     CompteDAO comptedao= new CompteDAO();
		     
		     Compte compte=comptedao.getCompte(iden);
		     
          // On v�rifie que le b�n�ficiaire n'est pas d�j� ajout�
		     
			 Beneficiaire ben=null;
			 
			 ben=bendao.getBeneficiaire(compte.getNumeroDeCompte());
			 
			 if(ben==null) {
			 
			 //Ajout dans la base de donn�es
			 
			    ben= new Beneficiaire(identifiant,cl.getNomClient(),cl.getPrenomClient(),compte.getNumeroDeCompte());
				
				bendao.ajouter(ben);
				
				response.sendRedirect( "SuccesAjoutBeneficiaire.jsp" );
				
			 } else {
				 
				 response.sendRedirect( "ErreurBenInterneExistant.jsp" );
			 }
				 
		 }
		   
	}

}
