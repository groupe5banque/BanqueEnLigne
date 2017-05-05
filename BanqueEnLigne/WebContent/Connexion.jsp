<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
   <%@ page import="dao.*"%>
   <%@ page import="dto.*"%>
   <%@page import= "java.util.ArrayList" %>
   <%@page import= "java.time.LocalDate" %>
<%@page import="java.time.ZoneId"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<%
	ClientDAO cd = new ClientDAO();

    ArrayList<Client> lc = cd.getListClient();
    request.setAttribute("lc", lc);

%>

<!DOCTYPE html>
<html>
<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Equipe5">

    <title>Connexion</title>

	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/custom.css">
    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


	<!-- Custom Fonts -->
	<link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
	<link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

	<!-- Theme CSS -->
	<link href="css/agency.min.css" rel="stylesheet">
	<link href="css/menu.css" rel="stylesheet">
	
	<style>
/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: yellow;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: yellow;
    text-decoration: none;
    cursor: pointer;
}


tr{
cursor:pointer;
}

</style>


</head>


 
<body id="page-top" class="index">

  <div class="content">
    <div class="wrap">
  <nav class="nav-bar navbar-inverse" role="navigation">
      <div id="top-menu" class="container-fluid active">
          <a class="navbar-brand text-center" href="#">CONNEXION A L'ESPACE MANAGERIAL</a>

      </div>      
  </nav>
  
   <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"
			integrity="sha384-mE6eXfrb8jxl0rzJDBRanYqgBxtJ6Unn4/1F7q4xRRyIw7Vdg9jP4ycT7x1iVsgb"
			crossorigin="anonymous"></script>
    <script src="js/menu.js"></script>
      
  <!--Body content-->
  

    <div class="top-bar">       
      <a href="#menu" class="side-menu-link burger"> 
        <span class='burger_inside' id='bgrOne'></span>
        <span class='burger_inside' id='bgrTwo'></span>
        <span class='burger_inside' id='bgrThree'></span>
      </a>      
    </div>
    
    <section class="content-inner">
    
    
    <div class="form-group">
        <br>
		<form id="form" method="POST"  action="./Connexion">	
		<input name="type" placeholder="manager" value="manager" style="visibility:hidden"> 
		<label>Email:&nbsp;</label>
		<input name="email" id="mail" placeholder="Email" class="form-control"  style ="display: inline-block; width: 200px;" type="text" required data-validation-required-message="Email de connexion svp ">
	
	<label>Mot de passe:&nbsp;</label>
		<input name="password" id="Mdp" placeholder="Mot de passe" class="form-control"  style ="display: inline-block; width: 200px;" type="text" required data-validation-required-message="Mot de passe svp ">
		<button id="bouton" type="submit"  class="btn btn-default" >Se connecter</button>
		<br>
        <label id="hint"></label>
		
  		</form>
   
       
	</div> 
    <!-- <script>
    $.post($form.attr("action"), $form.serialize(), function(responseText) {
    	if(responseText!="Identifiants manager incorrect!")
		{
        $("#hint").text(responseText);
		}
        else{
        	document.location.href="Connexion.jsp"; 
        }
    	
    	if(responseText!="Identifiants erronés!")
		{
        $("#hint").text(responseText);
		}
        else{
        	document.location.href="PageAccueilClient.jsp"; 
        }
    	
    
    });
	
    event.preventDefault(); // Important! Prevents submitting the form.
	 


});

    
    </script> -->
 
 	
    </section>
    
 
    
    </div>  
      
    </div>  
        
</body>
</html>
       