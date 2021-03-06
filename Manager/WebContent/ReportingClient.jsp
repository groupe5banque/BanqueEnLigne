<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="dao.*"%>
<%@ page import="dto.*"%>
<%@ page import="java.util.ArrayList"%>
<%@page import= "java.time.LocalDate" %>"WebContent/ReportingClient.jsp"
<%@page import="java.time.ZoneId"%>

 <%ManagerDAO dao= new ManagerDAO();
    Manager ml= null;
 
     ml=(Manager)session.getAttribute("manager");
     session.setAttribute( "manager",ml );
     if (ml == null)
     {
    	 this.getServletContext().getRequestDispatcher( "/Connexion.jsp" ).forward( request, response);
    	 session.removeAttribute("manager");
     }
    %>

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
      <div id ="top-menu" class="container-fluid active">
          <a class="navbar-brand" href="#">BIENVENUE SUR VOTRE ESPACE MANAGERIAL</a>
          <ul class="nav navbar-nav">        
              <li class="dropdown movable">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="caret"></span><span class="fa fa-3x fa-child"></span></a>
                  <ul class="dropdown-menu" role="menu">
                      <li> <a ><span class="fa fa-user"></span> Bienvenue ${sessionScope.manager.nomManager} </a></li>
                      <li class="divider"></li>
                      <li><a data-toggle="modal" data-target="#myModal"><span class="fa fa-power-off"></span> D�connexion</a></li>
                  </ul>
              </li>
              
          </ul>
      </div>      
  </nav>
 <aside id="side-menu" class="aside" role="navigation">            
        <ul class="nav nav-list accordion">   
                         
          <li class="nav-header">
            <div class="link"><i class="fa fa-lg fa-user"></i>Clients<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
              <li><a href="ListeClient.jsp"> Voir la liste client</a></li>   
              <li><a href="ChoixListeHistorique.jsp"> Voir le reporting totale</a></li> 
              
            </ul>
          </li>
          
                    <li class="nav-header">
            <div class="link"><i class="fa fa-lg fa-user"></i>Actualit�s<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
              <li><a href=""> Ajouter / Modifier</a></li>   
              <li><a href="index.jsp#portfolio"> Consulter</a></li> 
              
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
    
        <div class="container">
     <form name=""  action="Deconnexion" method="post" id="" novalidate>        
            <!-- Modal -->
             <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">�</span></button>
                    <h4 class="modal-title" id="myModalLabel">D�connexion</h4>
                  </div>
                  <div class="modal-body">
                    �tes-vous s�r de vouloir vous d�connecter ?
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
                    <button type="submit"  class="btn btn-primary">Se Deconnecter</button>
                  </div>
                </div>
              </div>
            </div>
            </form>
            </div>
    
   
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
         <label>Choisir la liste historique � afficher:&nbsp</label>
         <select id="typeH" name="typeH">
         <option id="3moisP">Les historique 3 mois pr�c�dents</option>
         <option id="6moisP">Les historiques 6 mois pr�c�dents</option>
         
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
         <button class="btn btn-default" Onclick="window.location.href='ConsultationManager.jsp'">Voir tous les comptes</button>
       
        
         
         
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