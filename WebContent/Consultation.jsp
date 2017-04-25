
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    
     
  <%@ page import="dao.*"%>
   <%@ page import="dto.*"%>
   <%@page import= "java.util.ArrayList" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%  
   %>
    
    
    
     <%ClientDAO cdao= new ClientDAO();
       Client cl1= null;
       String nom=null;
   	   String prenom=null;
   	   int id=0;
      CompteDAO cd = new CompteDAO();
	  ArrayList<Compte> Acc = new ArrayList<Compte>();
	  ArrayList<Compte> cc = new ArrayList<Compte>();
	  ArrayList<Compte> ce=new ArrayList<Compte>();
	  ArrayList<Compte> ct=new ArrayList<Compte>();
	  
     cl1=(Client)session.getAttribute("client");
     
     if (cl1 == null)
     {
    	 this.getServletContext().getRequestDispatcher( "/index.jsp" ).forward( request, response);
    	 session.removeAttribute("client");
     }
     else{
    
    String email;
	
	
	Client cl = cl1;
	
    email = cl.getEmailClient();
	id = cdao.getIdClient(email);
	
	
		
	
	nom=cl.getNomClient();
	prenom=cl.getPrenomClient();
	
	System.out.println(id);
     
	cd = new CompteDAO();
	Acc = cd.getTousCompte(id);
	cc = cd.getCompteCourant(id);
	System.out.println(cc.get(0).getNumeroDeCompte());
	ce = cd.getCompteEpargne(id);
	cc = cd.getCompteCourant(id);
	ct = cd.getCompteTitre(id);
	request.setAttribute("ce", ce);
	request.setAttribute("ct", ct);
	request.setAttribute("cc", cc);
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
         
         <h1> INFORMATIONS DES COMPTES DE&nbsp;<%=prenom%>&nbsp;<%=nom %> : </h1> 
         <br>
         <h4 class="text-center">SITUATION GLOBALE:</h4>
         
         <br>
       <!--Table and divs that hold the pie charts-->
    <table class="columns">
      <tr>
        <%if(cc.size()!=0||ce.size()!=0||ct.size()!=0){ %>
        <td><div id="TN_chart_div" style="title:'Répartition de nombre de compte',width:550, height:800"></div></td>
        <%}else{ %>
        <td><h4>Répartition de nombre de compte: 0 compte.</h4></td>
        <%} %>
        <%if(cd.soldeTotal(ce)!=0||cd.soldeTotal(cc)!=0||cd.soldeTotal(ct)!=0){ %>
        <td><div id="TM_chart_div" style="title:'Répartition de solde de compte',width:550, height:800"></div></td>
        <%}else{ %>
        <td><h4>Répartition de solde de compte: 0 solde.</h4></td>
        <%} %>
      </tr>
    </table>
    <br>
          <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
          
          <div id="table_div"></div>
   
     <script>    
      google.charts.load('current', {'packages':['corechart', 'table']});
      google.charts.setOnLoadCallback(drawTable);

      function drawTable() {
        var data = new google.visualization.DataTable();
 
        data.addColumn('string', 'Type de compte');
        data.addColumn('string', 'Nombre de compte');
        data.addColumn('string', 'Solde totale');
        
        data.addRows([
            ['Tous type de compte', '<%=cd.getTousCompte(id).size()%>' , '<%=cd.soldeTotal(Acc)+" EUR"%>'],
            ['Compte epargne', '<%=cd.getCompteEpargne(id).size()%>' , '<%=cd.soldeTotal(ce)+" EUR"%>'],
            ['Compte courant', '<%=cd.getCompteCourant(id).size()%>' , '<%=cd.soldeTotal(cc)+" EUR"%>'],
            ['Compte titre', '<%=cd.getCompteTitre(id).size()%>' , '<%=cd.soldeTotal(ct)+" EUR"%>'],
          ]);

        var table = new google.visualization.Table(document.getElementById('table_div'));

        table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
      }
      
      
      google.charts.setOnLoadCallback(drawTNChart);
      function drawTNChart() {

          // Create the data table for Sarah's pizza.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
        	['Compte épargne', <%=ce.size()%>],  
            ['Compte courant', <%=cc.size()%>],
            ['Compte titre', <%=ct.size()%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'Répartition de nombre de compte', width:550,height:400};

          // Instantiate and draw the chart for Sarah's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('TN_chart_div'));
          chart.draw(data, options);
        }
      
      google.charts.setOnLoadCallback(drawTMChart);
      function drawTMChart() {

          // Create the data table for Sarah's pizza.
          var data = new google.visualization.DataTable();
          data.addColumn('string', 'Topping');
          data.addColumn('number', 'Slices');
          data.addRows([
        	['Compte épargne', <%=cd.soldeTotal(ce)%>],  
            ['Compte courant', <%=cd.soldeTotal(cc)%>],
            ['Compte titre', <%=cd.soldeTotal(ct)%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'Répartition de solde de compte (EUR)', width:550,height:400};

          // Instantiate and draw the chart for Sarah's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('TM_chart_div'));
          chart.draw(data, options);
        }
      </script>
         
        
         <br>
               	
      
         <h4 class="text-center"> Compte épargne </h4>
         <%if(ce.size()!=0){ %>
          <div id="table_div1"></div>
         <%}else{ %>
          <div style="text-align: center">0 compte épargne.</div>
          <%} %>
          
         <script> 
         google.charts.load('current', {'packages':['table']});
         google.charts.setOnLoadCallback(drawTable);

         function drawTable() {
           var data = new google.visualization.DataTable();
           data.addColumn('string', 'Numero de compte');
           data.addColumn('string', 'Code guichet');
           data.addColumn('string', 'Clé rib');
           data.addColumn('string', 'Code banque');
           data.addColumn('string', 'Solde banque');
           data.addColumn('string', 'Type Compte');
           
           <c:forEach var = "compteE" items = "${ce}">
           data.addRows([
             ['<c:out value="${compteE.getNumeroDeCompte()}"/>', '<c:out value="${compteE.getCodeGuichet()}"/>' , '<c:out value="${compteE.getClefRIB()}"/>','<c:out value="${compteE.getCodeBanque()}"/>','<c:out value="${compteE.getSoldeBanque()}"/> EUR','<c:out value="${compteE.getTypeCompte()}"/>']
           
           ]);
           </c:forEach>
           var table = new google.visualization.Table(document.getElementById('table_div1'));

           table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
         }
         
         
         </script>
    		
    		
    		
         
         <br>
         <h4 class="text-center"> Compte courant </h4>
          <%if(cc.size()!=0){ %>
          <div id="table_div2"></div>
          <%}else{ %>
          <div style="text-align: center">0 compte courant.</div>
          <%} %>	
          <script>
          google.charts.load('current', {'packages':['table']});
          google.charts.setOnLoadCallback(drawTable);

          function drawTable() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Numero de compte');
            data.addColumn('string', 'Code guichet');
            data.addColumn('string', 'Clé rib');
            data.addColumn('string', 'Code banque');
            data.addColumn('string', 'Solde banque');
            data.addColumn('string', 'Type Compte');
            
            <c:forEach var = "compteC" items = "${cc}">
            data.addRows([
              ['<c:out value="${compteC.getNumeroDeCompte()}"/>', '<c:out value="${compteC.getCodeGuichet()}"/>' , '<c:out value="${compteC.getClefRIB()}"/>','<c:out value="${compteC.getCodeBanque()}"/>','<c:out value="${compteC.getSoldeBanque()}"/> EUR','<c:out value="${compteC.getTypeCompte()}"/>']
            
            ]);
            </c:forEach>
            var table = new google.visualization.Table(document.getElementById('table_div2'));

            table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
          }
          </script>
          	
    		
         <br>
         <h4 class="text-center"> Compte titre </h4>
          <%if(ct.size()!=0){ %>
          <div id="table_div3"></div>
          <%}else{ %>
          <div style="text-align: center">0 compte titre.</div>
          <%} %>
          <script>
          google.charts.load('current', {'packages':['table']});
          google.charts.setOnLoadCallback(drawTable);

          function drawTable() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Numero de compte');
            data.addColumn('string', 'Code guichet');
            data.addColumn('string', 'Clé rib');
            data.addColumn('string', 'Code banque');
            data.addColumn('string', 'Solde banque');
            data.addColumn('string', 'Type Compte');
            
            <c:forEach var = "compteT" items = "${ct}">
            data.addRows([
              ['<c:out value="${compteT.getNumeroDeCompte()}"/>', '<c:out value="${compteT.getCodeGuichet()}"/>' , '<c:out value="${compteT.getClefRIB()}"/>','<c:out value="${compteT.getCodeBanque()}"/>','<c:out value="${compteT.getSoldeBanque()}"/> EUR','<c:out value="${compteT.getTypeCompte()}"/>']
            
            ]);
            </c:forEach>
            var table = new google.visualization.Table(document.getElementById('table_div3'));

            table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
          }
          </script> 
    	
    		
    		<br>
         
          
         </div>
        
   
   
   
    
     	</section>
     	</div>
     	</div>


    
   
   
     
</body>
</html>