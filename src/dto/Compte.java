package dto;

import dao.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Compte
 */
@WebServlet("/MonCompte")
public class Compte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Compte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		this.getServletContext().getRequestDispatcher( "/CreerCompte.jsp" ).forward( request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		Map<String, String> erreurs = new HashMap<String, String>();
		
		// R閏up閞ation des donn閑s
		String NameEntered = (String) request.getParameter("username");
		String SurnameEntered = (String) request.getParameter("usersurname");
		String DobEntered = (String) request.getParameter("userdob");
		String MailEntered = (String) request.getParameter("usermail");
		String MailConfEntered = (String) request.getParameter("usernmailConf");
		String MdpEntered = (String) request.getParameter("mdp");
		String MdpConfEntered = (String) request.getParameter("mdpConf");
		
		//Validation des donn閑s
        try {
        	
            MailValide(MailEntered);

        } catch (Exception e) {
            
        	erreurs.put("usermail", e.getMessage());
        }
        
        try {
        	ConfMail(MailEntered,MailConfEntered);
        	
        } catch (Exception e) {
        	
        	erreurs.put("usermailConf", e.getMessage());
        }
        
        try {
        	ConfMotsDePasse(MdpEntered,MdpConfEntered);
        	
        } catch (Exception e) {
        	
        	erreurs.put("mdp", e.getMessage());
        }
        
        try {
        	validationNom(NameEntered);
        	
        } catch (Exception e) {
        	
        	erreurs.put("username", e.getMessage());
        }
        
		
		//D閒initions des attributs 
		request.setAttribute("name", NameEntered);
		request.setAttribute("surname", SurnameEntered);
		request.setAttribute("birthday", DobEntered);
		request.setAttribute("mail", MailEntered);
		request.setAttribute("mailConf", MailConfEntered);
		request.setAttribute("mdp", MdpEntered);
		request.setAttribute("mdpConf", MdpConfEntered);
		
		// Redirection vers la jsp
		this.getServletContext().getRequestDispatcher( "/CreerCompte.jsp" ).forward( request, response);
		
		// Traitement des donn閑s - Ajout dans la base de donn閑s
		
			String nom;
			String prenom;
			String dateN;
			String mail;
			String mailConf;
			String mdp;
			String mdpConf;
		
		   nom = (String) request.getAttribute("name");
		   prenom = (String) request.getAttribute("surname");
		   dateN = (String) request.getAttribute("birthday");

		   
		   mail = (String) request.getAttribute("mail");
		   mailConf = (String) request.getAttribute("mailConf");
		   mdp = (String) request.getAttribute("mdp");
		   mdpConf = (String) request.getAttribute("mdpConf");
		   
		   ClientDAO clientDAO = new ClientDAO();
		   
		   /*Client c1 = new Client(nom, prenom, dateN,mail,mdp);*/
		  // int retour = clientDAO.ajouter(c1);

			//System.out.println(retour + " lignes ajout閑s");
		
			 
		
	}

	
	/**
	 * Validation de la saisie de l'adresse mail
	 */
	private void MailValide(String email) throws Exception {
	
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "L'adresse email n'est pas valide. Merci de les saisir � nouveau!" );
	        }
	     
	} 
	
	/**
	 * V閞ification la coh閞ence des adresses mail saisis.
	 */
	private void ConfMail(String mail, String confirmation ) throws Exception{
	    
	        if (!mail.equals(confirmation)) {
	            throw new Exception("Les adresses mail ne correspondent pas. Merci de les saisir � nouveau! ");
	            
	        } 
	}


	/**
	 * V閞ification la coh閞ence des mots de passe saisis.
	 */
	private void ConfMotsDePasse(String motDePasse, String confirmation ) throws Exception{
	    
	        if (!motDePasse.equals(confirmation)) {
	            throw new Exception("Les mots de passe ne correspondent pas. Merci de les saisir � nouveau! ");
	            
	        } else if (motDePasse.trim().length() < 8) {
	            throw new Exception("Les mots de passe doivent contenir au moins 8 caract鑢es.");
	        }
	    
	}

	/**
	 * Validation de la saisie du nom
	 */
	private void validationNom (String nom ) throws Exception {
		
	    if (  nom.trim().length() < 4 ) {
	        throw new Exception( "Le nom d'utilisateur doit contenir au moins 4 caract鑢es." );
	    }
	}
    
}
