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
	//	doGet(request, response);
		
		BeneficiaireDAO bendao= new BeneficiaireDAO();
		
		Beneficiaire ben=null;
		
		//récupération des éléments saisis
		
		 String nom = (String) request.getParameter("nom");
		
		 String prenom = (String) request.getParameter("prenom");
			
		 HttpSession session = request.getSession();	
		
		 Client client=null;
		
		 ClientDAO cdao=new ClientDAO();
		 
	     client= (Client)session.getAttribute("client");
	     
	     int identifiant=0; 
	     
	     String mail= client.getEmailClient();
	     
	     identifiant=cdao.getIdClient(mail);
		  
	     
	     
try {
	// Test de l'iban
	String iban = (String) request.getParameter("iban");
	    
	TestIban t= new TestIban();
	    
	// Ajout du bénéficiaire  dans la bdd si IBAN correct
	
	if(t.test(iban)){
		
		
		ben= new Beneficiaire(identifiant,nom,prenom,iban);
		
		bendao.ajouter(ben);
		
		// redirection vers la page de succès
		
		response.sendRedirect( "SuccesAjoutBeneficiaire.jsp" );
	} 
	
	else {
		
		// redirection vers la page d'erreur
		
		response.sendRedirect( "ErreurIban.jsp" );
		
	}
	
		    
} catch (Exception e) {
	e.printStackTrace();
}
	 	

}

}