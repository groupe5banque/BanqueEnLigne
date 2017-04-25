<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="dao.*"%>
<%@ page import="dto.*"%>
<%@ page import="java.util.ArrayList"%>
<%@page import= "java.time.LocalDate" %>
<%@page import="java.time.ZoneId"%>



<!DOCTYPE html>
<html>
<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Equipe5">

    <title>Consulter un client</title>

	<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/custom.css">
    <!-- Bootstrap Core CSS --><link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">


<!-- Custom Fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Theme CSS -->
<link href="css/agency.min.css" rel="stylesheet">
<link href="css/menu.css" rel="stylesheet">



</head>



<body>


<body id="page-top" class="index">

    <div class="wrap">
  <nav class="nav-bar navbar-inverse" role="navigation">
      <div id="top-menu" class="container-fluid active">
          <a class="navbar-brand" href="#">BIENVENUE SUR VOTRE ESPACE MANAGER</a>
          <ul class="nav navbar-nav">        
              <li>
                        <a href="#portfolio">ActualitÃ©s</a>
                    </li>
                    <li>
                        <a href="#contact"> Nous Contacter  </a>
                    </li>
                    
              <li class="dropdown movable">
                  <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><span class="caret"></span><span
						class="fa fa-3x fa-child"></span></a>
                  <ul class="dropdown-menu" role="menu">
                      <li> <a><span class="fa fa-user"></span> Bienvenue ${sessionScope.client.nomClient} </a></li>
                      <li class="divider"></li>
                      <li><a href="#"><span
								class="fa fa-power-off"></span> DÃ©connexion</a></li>
                  </ul>
              </li>
              
          </ul>
      </div>      
  </nav>
  <aside id="side-menu" class="aside" role="navigation">            
        <ul class="nav nav-list accordion">                    
          <li class="nav-header">
            <div class="link">
					<i class="fa fa-lg fa-user"></i>Profil<i class="fa fa-chevron-down"></i>
				</div>
            <ul class="submenu">
              <li><a href="InfosPersonnellesClient.jsp"> Voir mes informations personnelles</a></li>  
              <li><a href="PageModInfPer.jsp">Modifier mes informations</a></li>  
              
            </ul>
          </li>
          
          <li class="nav-header">
            <div class="link">
					<i class="fa fa-lg fa-users"></i>Comptes<i
						class="fa fa-chevron-down"></i>
				</div>
            <ul class="submenu">
              <li><a href="#">Créer un compte épargne</a></li>
              <li><a href="#">Créer un compte titre</a></li>
              <li><a href="#">Gérer mes comptes</a></li>
               <li><a href="Consultation.jsp">Consulter les soldes de mes comptes</a></li>
            </ul>
          </li>
          
          <li class="nav-header">
            <div class="link">
					<i class="fa fa-cloud"></i>Transactions<i
						class="fa fa-chevron-down"></i>
				</div>
            <ul class="submenu">
              <li><a href="PageVirement.jsp">Effectuer un virement</a></li>
              <li><a href="ChargerArgent.jsp">Alimenter mes comptes</a></li>
              <li><a href="HistoriqueSelection.jsp">Consulter l'historique de mes transactions</a></li>
            </ul>
          </li>  
          
      </ul>
  </aside>
  
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
  <div class="content">
    <div class="top-bar">       
      <a href="#menu" class="side-menu-link burger"> 
        <span class='burger_inside' id='bgrOne'></span>
        <span class='burger_inside' id='bgrTwo'></span>
        <span class='burger_inside' id='bgrThree'></span>
      </a>      
    </div>
    <section class="content-inner">
    
    
   
        <%
        ClientDAO cdao=new ClientDAO();
        ZoneId z = ZoneId.systemDefault();
    	LocalDate today = LocalDate.now( z );
    	int thisYear=today.getYear();
    	String IdClient = (String)session.getAttribute("IdClient");
    	session.setAttribute( "IdClient",IdClient );
    	%>    
        <br>
        <label>Vous avez choisi <%=cdao.getClient(Integer.parseInt(IdClient)).getPrenomClient() %>&nbsp;<%=cdao.getClient(Integer.parseInt(IdClient)).getNomClient()%>.</label>	
        <br> 
        <br>
        <form id="form" method="POST"  action="./ChoixListeHistorique">
        <div class="form-group">
         <label>Choisir la liste historique à afficher:&nbsp</label>
         <select id="typeH" name="typeH">
         <option id="3moisP">Les historique 3 mois précédents</option>
         <option id="6moisP">Les historiques 6 mois précédents</option>
         
         <c:forEach var="annee" begin="2010" end="<%=thisYear%>">       
         <option id="Annee" Value="${annee}">Les historique de &nbsp;<c:out value="${annee}"/></option> 
         </c:forEach>  
         </select>
         <br>
         <br>
         
         
         <button type="submit" class="btn btn-default"  style ="display: inline-block">Consulter</button>
         <br>
         </div>
        
         <br>
         <br>
         <label id="hint"></label>
        
        </form>
         <button class="btn btn-default" Onclick="window.location.href='Consultation.jsp'">Voir tous les comptes</button>
       
        
         
         
        <!--  $(document).on("submit", "#form", function() {
        	 
             var $form = $(this);
             $.post($form.attr("action"), $form.serialize(), function(responseText) {
                 $("#hint").text(responseText);
             });
             event.preventDefault(); // Important! Prevents submitting the form.
        	
         });
          -->
        

       

         
         
         
        
         
         
         
		 

 


    
    
    
     	</section>
     	</div>
</div>

    
   
   
     
</body>
</html>