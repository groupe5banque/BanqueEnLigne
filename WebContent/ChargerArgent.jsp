<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="dao.*"%>
<%@ page import="dto.*"%>
<%@ page import="java.util.ArrayList"%>

<%
	ClientDAO cdao = new ClientDAO();
	Client cl = (Client) session.getAttribute("client");
	String email = cl.getEmailClient();
	int id = cdao.getIdClient(email);
	System.out.println(id);
	CompteDAO cd = new CompteDAO();
	ArrayList<Compte> Acc = cd.getTousCompte(id);
	ArrayList<Compte> cc = cd.getCompteCourant(id);
	System.out.println(cc.get(0).getNumeroDeCompte());
	ArrayList<Compte> ce = cd.getCompteEpargne(id);
	ArrayList<Compte> ct = cd.getCompteTitre(id);
	request.setAttribute("ce", ce);
	request.setAttribute("ct", ct);
	request.setAttribute("cc", cc);
	String SoldeCompte;
	Double solde;
%>

<!DOCTYPE html>
<html>
<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Equipe5">

    <title>ChargerArgent</title>

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
          <a class="navbar-brand" href="#">BIENVENUE SUR VOTRE ESPACE CLIENT</a>
          <ul class="nav navbar-nav">        
              <li>
                        <a href="#portfolio">Actualités</a>
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
								class="fa fa-power-off"></span> Déconnexion</a></li>
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
          
           <li class="nav-header">
            <div class="link"><i class="glyphicon glyphicon-list-alt"></i>Services<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
              <li><a href="Releves.jsp">Releves de comptes</a></li>
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
    
   
    
        	
        <br> 
      
        <form id="form" method="POST"  action="./ChargerArgent">
        
         <p>Choisir le type de compte à charger:</p>
         <select id="typeC" name="typeC" onchange="show(this);">
         <option id="CompteE">Compte epargne</option>
         <option id="CompteC">Compte courant</option>
         <option id="CompteT">Compte titre</option>   
         </select>
         <br>
         <br>
         <p>Choisir le compte à charger:</p>
        
       
        <div id = "ce" >
         Compte epargne:&nbsp;&nbsp;
        <select id="typeCE" name = "ceChoisi">
     	<c:forEach var = "compteE" items = "${ce}">
    	<option value = "${compteE.getNumeroDeCompte()}"><c:out value="${compteE.getNumeroDeCompte()}"/>&nbsp;&nbsp;Solde:<c:out value=" ${compteE.getSoldeBanque()}"/></option>   	
     	</c:forEach>   
     	</select>
    	</div>
        
    	<div id = "cc"  style="visibility:hidden">
    	 Compte courant: &nbsp;&nbsp;
     	<select id="typeCC" name="ccChoisi">
     	<c:forEach var = "compteC" items = "${cc}">
     	<option value = "${compteC.getNumeroDeCompte()}"><c:out value="${compteC.getNumeroDeCompte()}"/>&nbsp;&nbsp;Solde:<c:out value=" ${compteC.getSoldeBanque()}"/></option>
     	</c:forEach>  
     	</select> 
    	</div>
       
       
    	<div id = "ct"  style="visibility:hidden">
    	Compte titre:  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     	<select id="typeCC" name="ctChoisi">
     	
     	<c:forEach var = "compteT" items = "${ct}">
     	<option value = "${compteT.getNumeroDeCompte()}"><c:out value="${compteT.getNumeroDeCompte()}"/>&nbsp;&nbsp;Solde:<c:out value=" ${compteT.getSoldeBanque()}"/></option>
     	</c:forEach>
     	
      	</select> 
    	</div>
        <br>
         <p>Montant à charger:&nbsp;<input type="text" value="" name = "Montant"></p>
         <input type="submit" value="Confirme" />
         <br>
         <br>
         <label id="hint"></label>
        
        </form>
      
       
        
         <script>
         function show(element)
         {
        	 var idx = element.selectedIndex;
        	 var choix = element.options[idx].value;
        	 if(choix == "Compte epargne")
        	 {
        		 document.getElementById('cc').style.visibility = "hidden";
            	 document.getElementById('ct').style.visibility = "hidden";
            	 document.getElementById('ce').style.visibility = "visible";
        	 }
        	 if(choix == "Compte courant")
        	{
        		 document.getElementById('ct').style.visibility = "hidden";
            	 document.getElementById('ce').style.visibility = "hidden";
            	 document.getElementById('cc').style.visibility = "visible";
        	}
        	 if(choix == "Compte titre")
            {
        		 document.getElementById('cc').style.visibility = "hidden";
            	 document.getElementById('ce').style.visibility ="hidden";
             	 document.getElementById('ct').style.visibility = "visible";
        	}
         }
         
         function showthis(element)
         {
        	 var i = element.selectedIndex;
        	 var c = element.options[i].value;
        	 alert(choix);
         }
         
       
       
         
         $(document).on("submit", "#form", function() {
        	 
             var $form = $(this);
             $.post($form.attr("action"), $form.serialize(), function(responseText) {
                 $("#hint").text(responseText);
             });
             event.preventDefault(); // Important! Prevents submitting the form.
        	
         });
         
        

       
                  
         </script>
         
         
         
        
         
         
         
		 

 


    
    
    
     	</section>
     	</div>
</div>

    
   
   
     
</body>
</html>