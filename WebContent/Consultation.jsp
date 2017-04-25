<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     
  <%@ page import="dao.*"%>
   <%@ page import="dto.*"%>
   <%@page import= "java.util.ArrayList" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%  
   %>
    
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
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Equipe5">

    <title>Consultation</title>

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
          <a class="navbar-brand" href="#">BIENVENUE SUR VOTRE ESPACE CLIENT</a>
          <ul class="nav navbar-nav">        
              <li>
                        <a  href="#portfolio">Actualitualités</a>
                    </li>
                    <li>
                        <a  href="#contact"> Nous Contacter  </a>
                    </li>
                    
              <li class="dropdown movable">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span class="caret"></span><span class="fa fa-3x fa-child"></span></a>
                  <ul class="dropdown-menu" role="menu">
                      <li> <a ><span class="fa fa-user"></span> Bienvenue ${sessionScope.client.nomClient} </a></li>
                      <li class="divider"></li>
                      <li><a data-toggle="modal" data-target="#myModal"><span class="fa fa-power-off"></span> Déconnexion</a></li>
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
              <li><a href="InfosPersonnellesClient.jsp"> Voir mes informations personnelles</a></li>  
              <li><a href="PageModInfPer.jsp">Modifier mes informations</a></li>  
              
            </ul>
          </li>
          
          <li class="nav-header">
            <div class="link"><i class="fa fa-lg fa-users"></i>Comptes<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
              <li><a data-toggle="modal" data-target="#myModal1" >Créer un compte Acompargne</a></li>
              <li><a data-toggle="modal" data-target="#myModal3">Créer un compte titre</a></li>
              <li><a href="#">Gérer mes comptes</a></li>
               <li><a href="Consultation.jsp">Consulter les soldes de mes comptes</a></li>
            </ul>
          </li>
          
          <li class="nav-header">
            <div class="link"><i class="fa fa-cloud"></i>Transactions<i class="fa fa-chevron-down"></i></div>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js" integrity="sha384-mE6eXfrb8jxl0rzJDBRanYqgBxtJ6Unn4/1F7q4xRRyIw7Vdg9jP4ycT7x1iVsgb" crossorigin="anonymous"></script>
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
    
    
         <div>
    
         <P>-----------------------------------INFORMATIONS DES COMPTES--------------------------------</P> 
         <p class="compte">SITUATION GLOBALE:</p>
         <table>
  				<tr>
    			<th>Type de compte&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				<th>Nombre de compte&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				<th>Solde total</th>			 
 				 </tr>
 				 <td>Tous type de compte&nbsp;&nbsp;</td>
   				 <td><%=cd.getTousCompte(id).size()%></td>
   				 <td><%=cd.soldeTotal(Acc)+" EUR"%></td>
 				 </tr>
 				<td>Compte epargne</td>
   				<td><%=cd.getCompteEpargne(id).size()%></td>
   				<td><%=cd.soldeTotal(ce)+" EUR"%></td>
   				</tr>
   				<td>Compte courant</td>
   				<td><%=cd.getCompteCourant(id).size()%></td>
   				<td><%=cd.soldeTotal(cc)+" EUR" %></td>
   				</tr>
   				<td>Compte titre</td>
   				<td><%=cd.getCompteTitre(id).size()%></td>
   				<td><%=cd.soldeTotal(ct)+" EUR" %></td>
   				</tr>
   		</table>
         <br>
        
         
         
        
         
         	
      
         <p class="compte">=============================== Compte epargne =============================</p>
         
            
    		<table>
  				<tr>
    			<th>Numero de Compte&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Code guichet&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Clé rib&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Code Banque&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Solde Banque&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Type Compte&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>   				 
 				 </tr>
 				 <c:forEach var = "compteE" items = "${ce}">
 				 <tr>
   				 <td><c:out value="${compteE.getNumeroDeCompte()}"/></td>
   				 <td><c:out value="${compteE.getCodeGuichet()}"/></td>
   				 <td><c:out value="${compteE.getClefRIB()}"/></td>
   				 <td><c:out value="${compteE.getCodeBanque()}"/></td>
   				 <td><c:out value="${compteE.getSoldeBanque()}"/> EUR</td>
   				 <td><c:out value="${compteE.getTypeCompte()}"/></td>
 				 </tr>
 				 </c:forEach>
			</table>
    		
    		
         
         <p><br><br><br></p>
         <p class="compte">=============================== Compte courant =============================</p>
         
          	
          	<table>
  				<tr>
    			<th>Numero de Compte&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Code guichet&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Clé rib&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Code Banque&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Solde Banque&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Type Compte&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>   				 
 				 </tr>
 				 
 				 <c:forEach var = "compteC" items = "${cc}">
 				 <tr>
   				 <td><c:out value="${compteC.getNumeroDeCompte()}"/></td>
   				 <td><c:out value="${compteC.getCodeGuichet()}"/></td>
   				 <td><c:out value="${compteC.getClefRIB()}"/></td>
   				 <td><c:out value="${compteC.getCodeBanque()}"/></td>
   				 <td><c:out value="${compteC.getSoldeBanque()}"/> EUR</td>
   				 <td><c:out value="${compteC.getTypeCompte()}"/></td>
 				 </tr>
 				 </c:forEach>
			</table>		
    		
         <p><br><br><br></p>
         <p class="compte">================================ Compte titre ===============================</p>
         
           
    		<table>
  				<tr>
    			<th>Numero de Compte&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Code guichet&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Clé rib&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Code Banque&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Solde Banque&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
   				 <th>Type Compte&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>   				 
 				 </tr>
 				 
 				 <c:forEach var = "compteT" items = "${ct}">
 				 <tr>
   				 <td><c:out value="${compteT.getNumeroDeCompte()}"/></td>
   				 <td><c:out value="${compteT.getCodeGuichet()}"/></td>
   				 <td><c:out value="${compteT.getClefRIB()}"/></td>
   				 <td><c:out value="${compteT.getCodeBanque()}"/></td>
   				 <td><c:out value="${compteT.getSoldeBanque()}"/> EUR</td>
   				 <td><c:out value="${compteT.getTypeCompte()}"/></td>
 				 </tr>
 				 </c:forEach>
			</table>		
    		
    		<br>
         
          
         </div>
         </div>
   
   
   
    
     	</section>
     	</div>


    
   
   
     
</body>
</html>