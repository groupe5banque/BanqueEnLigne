<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
   
    <%@ page import="dto.*" %>
    <%@ page import="dao.*" %>
     <%@ page import="java.text.DateFormat" %>
     <%@ page import="java.text.SimpleDateFormat" %>
     <%@ page import="java.util.Date" %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title> Créer un compte - Banque en Ligne</title>

</head>

<body>



<form name="Inscription"  action="MonCompte" method='POST'>

	<fieldset>
	
	<legend> Inscription </legend>

   Nom :<br>
  <input type="text" name="username" required><br>
  <span class="erreur"> ${erreurs["username"]}</span>
  
   Prénom :<br>
  <input type="text" name="usersurname" required><br>
  
   Date de naissance :<br>
  <input type="text" name="userdob"required><br>
  
   Adresse mail :<br>
  <input type="text" name="usermail"required><br>
  <span class="erreur">${erreurs["usermail"]}</span>
  
  Confirmer adresse mail :<br>
  <input type="text" name="usermailConf"required><br>
  <span class="erreur">${erreurs["usermailConf"]}</span>
  
    Mot de passe :<br>
  <input type="text" name="pwd"required><br>
  <span class="erreur">${erreurs["mdp"]}</span>
  
   Confirmer mot de passe :<br>
  <input type="text" name="pwdConf" required><br>
  <span class="erreur">${erreurs["mdpConf"]}</span>
  
  <input type="submit" value="Submit">


	</fieldset>
	
</form>

<%			String nom = (String) request.getAttribute("name");
			String prenom = (String) request.getAttribute("surname");
			
			String message="Félicitations "+ prenom + " "+nom+"! Votre compte vient d'être créé. Une confirmation vous sera envoyée par email";

			if (!request.getParameterMap().isEmpty()){  

             out.println(message);

} %>
</body>


</html>