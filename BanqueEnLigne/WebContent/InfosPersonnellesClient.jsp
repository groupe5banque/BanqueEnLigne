<%@ page import="dao.*"%>
    <%@ page import="dto.*"%>
   
     <%ClientDAO dao= new ClientDAO();
    Client cl= null;
 
     cl=(Client)session.getAttribute("client");
     
     if (cl == null)
     {
    	 this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
    	 session.removeAttribute("client");
     }
    %>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Equipe5">

    <title>Bank 8-5 Of ESIGELEC</title>

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



</head>

<body>

<body id="page-top" class="index">

    <div class="wrap">
  <nav class="nav-bar navbar-inverse" role="navigation">
      <div id ="top-menu" class="container-fluid active">
          <a class="navbar-brand" href="#"> BIENVENUE SUR VOTRE ESPACE CLIENT</a>
          <ul class="nav navbar-nav">        
              <li>
                        <a  href="#portfolio">Actualités</a>
                    </li>
                    <li>
                        <a  href="#contact"> Nous Contacter  </a>
                    </li>
                    
              <li class="dropdown movable">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="caret"></span><span class="fa fa-3x fa-child"></span></a>
                  <ul class="dropdown-menu" role="menu">
                      <li> <a ><span class="fa fa-user"></span> Bienvenue ${sessionScope.client.nomClient}</a></li>
                      <li class="divider"></li>
                      <li><a data-toggle="modal" data-target="#myModal"><span class="fa fa-power-off"></span>Déconnexion</a></li>
                  </ul>
              </li>
              
          </ul>
      </div>      
  </nav>
  <aside id="side-menu" class="aside" role="navigation">            
        <ul class="nav nav-list accordion">                    
          <li class="nav-header">
            <div class="link"><i class="fa fa-lg fa-user"></i>Profil<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
              <li><a href="InfosPersonnellesClient.jsp">Voir mes informations personnelles</a></li>  
              <li><a href="PageModInfPer.jsp">Modifier mes informations</a></li>  
              
            </ul>
          </li>
          
          <li class="nav-header">
            <div class="link"><i class="fa fa-lg fa-users"></i>Comptes<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
              <li><a  href="CreerCompteEpargne.jsp"" >Créer un compte épargne</a></li>
              <li><a  href="CreerCompteTitre.jsp">Créer un compte titre</a></li>
              <li><a href="#">Gérer mes comptes</a></li>
               <li><a href="Consultation.jsp">Consulter les soldes de mes comptes</a></li>
            </ul>
          </li>
          
          <li class="nav-header">
            <div class="link"><i class="fa fa-cloud"></i>Transactions<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
              <li><a href="PageVirement.jsp">Effectuer un virement</a></li>
              <li><a href="ChargerArgent.jsp">Alimenter mes comptes</a></li>
              <li><a href="ChoixCompteTitre.jsp">Acheter des actions </a></li>
                <li><a href="ChoixCompteTitreVente.jsp">Vendre des actions</a></li>
              <li><a href="HistoriqueSelection.jsp">Consulter l'historique de mes transactions</a></li>
            </ul>
          </li>  
          				         <li class="nav-header">
            <div class="link"><i class="glyphicon glyphicon-list-alt"></i>Services<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
              <li><a href="Releves.jsp">Releves de comptes</a></li>
            </ul>
          </li>
      </ul>
  </aside>
  
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
     	 <div class="col-sm-9 col-md-9" >
            <div class="well">
           <P id= "titre"> VOS INFORMATIONS PERSONNELLES </P>
           <p class = "element"> NOM:  ${sessionScope.client.nomClient} </p>
           <p class = "element"> PRENOM :  ${sessionScope.client.prenomClient} </p>
           <p class = "element"> CIVILITE :  ${sessionScope.client.civiliteClient} </p>
           <p class = "element"> EMAIL :  ${sessionScope.client.emailClient} </p>
           <p class = "element"> NATIONALITE :  ${sessionScope.client.nationaliteClient} </p>
           <p class = "element"> PAYS DE RESIDENCE :  ${sessionScope.client.paysClient} </p>
           <p class = "element"> DATE DE NAISSANCE :  ${sessionScope.client.dateNaissanceClient} </p>
           <p class = "element"> TYPE DE COMPTE:  ${sessionScope.client.typeCompte} </p>
           <p class = "element"> TELEPHONE:  ${sessionScope.client.telephoneClient} </p>   
           <p class = "element"> ADRESSE:  ${sessionScope.client.adresseClient} </p>   
           <p class = "element"> CODE POSTAL:  ${sessionScope.client.codepostalClient} </p>   
           <p class = "element"> VILLE:  ${sessionScope.client.villeClient} </p>   
                           
            </div>
        </div>
 
								
								
           
     <form name=""  action="Deconnexion" method="post" id="" novalidate>        
            <!-- Modal -->
             <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel">Déconnexion</h4>
                  </div>
                  <div class="modal-body">
                    Êtes-vous sûr de vouloir vous déconnecter ?
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

    </section>
  </div>  
  
</div>

    
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js" integrity="sha384-mE6eXfrb8jxl0rzJDBRanYqgBxtJ6Unn4/1F7q4xRRyIw7Vdg9jP4ycT7x1iVsgb" crossorigin="anonymous"></script>
    <script src="js/menu.js"></script>
    


</body>
</html>

































