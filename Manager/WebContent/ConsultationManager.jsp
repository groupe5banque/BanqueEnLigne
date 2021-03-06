<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    
     
  <%@ page import="dao.*"%>
   <%@ page import="dto.*"%>
   <%@page import= "java.util.ArrayList" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%  
   %>
    
  <%
  
  ManagerDAO dao= new ManagerDAO();
  Manager ml= null;

   ml=(Manager)session.getAttribute("manager");
   session.setAttribute( "manager",ml );
   if (ml == null)
   {
  	 this.getServletContext().getRequestDispatcher( "/Connexion.jsp" ).forward( request, response);
  	 session.removeAttribute("manager");
   }
   
    int id;
    String email;
	ClientDAO cdao = new ClientDAO();
	String nom;
	String prenom;
	Client cl = null;
	
		String ID=(String)session.getAttribute("IdClient");
		id=Integer.parseInt(ID);
		cl=cdao.getClient(id);
	
	nom=cl.getNomClient();
	prenom=cl.getPrenomClient();
	
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
    
         <div>
         
         <h1> INFORMATIONS DES COMPTES DE&nbsp;<%=prenom%>&nbsp;<%=nom %> : </h1> 
         <br>
         <h4 class="text-center">SITUATION GLOBALE:</h4>
         
         <br>
       <!--Table and divs that hold the pie charts-->
    <table class="columns">
      <tr>
        <%if(cc.size()!=0||ce.size()!=0||ct.size()!=0){ %>
        <td><div id="TN_chart_div" ></div></td>
        <%}else{ %>
        <td><h4>R�partition de nombre de compte: 0 compte.</h4></td>
        <%} %>
        <%if(cd.soldeTotal(ce)!=0||cd.soldeTotal(cc)!=0||cd.soldeTotal(ct)!=0){ %>
        <td><div id="TM_chart_div" ></div></td>
        <%}else{ %>
        <td><h4>R�partition de solde de compte: 0 solde.</h4></td>
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
        	['Compte �pargne', <%=ce.size()%>],  
            ['Compte courant', <%=cc.size()%>],
            ['Compte titre', <%=ct.size()%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'R�partition de nombre de compte', width:550,height:400};

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
        	['Compte �pargne', <%=cd.soldeTotal(ce)%>],  
            ['Compte courant', <%=cd.soldeTotal(cc)%>],
            ['Compte titre', <%=cd.soldeTotal(ct)%>]
          ]);

          // Set options for Sarah's pie chart.
          var options = {title:'R�partition de solde de compte (EUR)', width:550,height:400};

          // Instantiate and draw the chart for Sarah's pizza.
          var chart = new google.visualization.PieChart(document.getElementById('TM_chart_div'));
          chart.draw(data, options);
        }
      </script>
         
        
         <br>
               	
      
         <h4 class="text-center"> Compte �pargne </h4>
         <% int a=0;
         if(ce.size()!=0){ %>
          <div id="table_div1"></div>
         <%}else{ %>
          <div style="text-align: center">0 compte �pargne.</div>
          <%} %>
          
         <script> 
         
         google.charts.setOnLoadCallback(drawTableE);

         function drawTableE() {
           var data = new google.visualization.DataTable();
           data.addColumn('string', 'Numero de compte');
           data.addColumn('string', 'Code guichet');
           data.addColumn('string', 'Cl� rib');
           data.addColumn('string', 'Code banque');
           data.addColumn('string', 'Solde banque');
           data.addColumn('string', 'Type Compte');
           
           <c:forEach var = "compteE" items = "${ce}">
           data.addRows([
             ['<c:out value="${compteE.getNumeroDeCompte()}"/>', '<c:out value="${compteE.getCodeGuichet()}"/>' , '<c:out value="${compteE.getClefRIB()}"/>','<c:out value="${compteE.getCodeBanque()}"/>','<c:out value="${compteE.getSoldeBanque()}"/> EUR','<c:out value="${compteE.getTypeCompte()}"/>']
           
           ]);
           <%System.out.println("Compte �pargne solde:"+ce.get(a).getSoldeBanque());
           a++;%>
           </c:forEach>
           var table = new google.visualization.Table(document.getElementById('table_div1'));

           table.draw(data, {showRowNumber: true, width: '100%', height: '100%'});
         }
         
         
         </script>
    		
    		
    		
         
         <br>
         <h4 class="text-center"> Compte courant </h4>
          <%if(cc.size()!=0){ %>
          <%System.out.println("taille cc:"+cc.size());%>
          <div id="table_div2"></div>
          <%}else{ %>
          <div style="text-align: center">0 compte courant.</div>        
          <%
          } %>
          	
          <script>
          
          google.charts.setOnLoadCallback(drawTableC);

          function drawTableC() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Numero de compte');
            data.addColumn('string', 'Code guichet');
            data.addColumn('string', 'Cl� rib');
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
          
          google.charts.setOnLoadCallback(drawTableT);

          function drawTableT() {
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Numero de compte');
            data.addColumn('string', 'Code guichet');
            data.addColumn('string', 'Cl� rib');
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