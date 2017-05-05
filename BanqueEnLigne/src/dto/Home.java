
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
		
		this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		ClientDAO dao= new ClientDAO();
	    Client c1= new Client();
	    ClientDAO dao1= new ClientDAO();
	    Client cL= new Client();
	    int r =0;
	   
	    
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
		 r= dao1.getIdClient(mail);
	if (r==0)
	{
		int tel= Integer.parseInt(phone);
		int codePos= Integer.parseInt(code_postal);
       c1 = new Client( name,surname, civilite,mail,birthday,mdp,nationalite,type_compte,tel,adresse,codePos,ville,pays);
		
		try{
		int retour = dao.ajouter(c1);
		System.out.println(retour + " lignes ajoutes");
		}catch(Exception e)
		{
			System.out.print("error");
		}
		
		/**Génération de compte automatique**/
		
		 CompteDAO compteDAO= new CompteDAO();
		 Rib r1= new Rib();
		 CodeDAO coDao= new CodeDAO();
	     Code co= null;
	     NumeroDeCompte num = new NumeroDeCompte();
	     String Pays = (String) request.getParameter("pays");
	     Compte compte= new Compte();
	 	
	 	try{
	 		 co= coDao.getCode(Pays);
	 		  int codeGuichet= Integer.parseInt(co.getCodeGuichet());
	 	     int codeBanque = Integer.parseInt(co.getCodeGuichet());
	 			int clefRIB= Integer.parseInt(co.getClefRib());
	 		   Compte test = null;
	 		  String numero= null;
	 		  int idClient=0;
	 			do
	 			{
	 				numero=num.getNumeroDeCompte();
	 				 test= compteDAO.getCompteNumero(numero);
	 			}while(test!=null);
	 			try{
	 				idClient = dao.getIdClient(mail);
	 				
	 				}catch(Exception e)
	 				{
	 					System.out.print("error");
	 				} 
			compte= new Compte(idClient,codeGuichet,numero,clefRIB,codeBanque,"0","compte courant");
			try{
				int retour = compteDAO.ajouter(compte);
				System.out.println(retour + " lignes ajoutes");
				}catch(Exception e)
				{
					System.out.print("error");
				}
			}catch(Exception e)
			{
				System.out.print("error");
			}
	    
        
	   
	 	/**Contact form**/
		String statut=request.getParameter("sendContact");
		
		String message = null;
		String status = null;
		
		if(statut!= null){
			
			JavaEmail javaEmail = new JavaEmail();
			javaEmail.setMailServerProperties();
			String emailSubject = "Formulaire de contact de la plateforme Banque En Ligne S8-5";
			
			String emailBody = "";
			
			if (request.getParameter("name") != null) {
				emailBody = "Sender Name: " + request.getParameter("name")
						+ "<br>";
			}
			if (request.getParameter("email") != null) {
				emailBody = emailBody + "Sender Email: "
						+ request.getParameter("email") + "<br>";
			}
			if (request.getParameter("tel") != null) {
				emailBody = emailBody + "Sender Phone: "
						+ request.getParameter("tel") + "<br>";
			}
			if (request.getParameter("message") != null) {
				emailBody = emailBody + "Message: " + request.getParameter("message")
						+ "<br>";
			}
			
			try {
				javaEmail.createEmailMessage(emailSubject, emailBody);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				javaEmail.sendEmail();
				status = "success";
				message = "Email sent Successfully!";

				
			} catch (MessagingException me) {
				status = "error";
				message = "Error in Sending Email!";
			}
			
			
			request.setAttribute("statut", status);
			request.setAttribute("reponse", message);
			
		}

	
		this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
		//this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
		
	}
		
	else {
		this.getServletContext().getRequestDispatcher( "/pageUnicitMotsPasse.jsp" ).forward( request, response);
	}
		

	}

}
