
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="dao.*" %>
    <%@ page import="java.io.*" %>
    <%@ page import="javax.servlet.*" %>
	<%@ page import="javax.servlet.http.*" %>	
	<%@ page import="dto.*" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="java.util.List" %>
	<%@ page import="java.util.Date" %>
	

	 <%ClientDAO dao= new ClientDAO();
    Client cl= null;
 
     cl=(Client)session.getAttribute("client");
     
     if (cl.getEmailClient() == null)
     {
    	 response.sendRedirect("index.jsp");
    	 session.removeAttribute("client");
     }
    %>
	
     <%  
     
	     Date df=new java.sql.Date(System.currentTimeMillis());
     
         CsvReleveDAO re= new CsvReleveDAO(); 
         CompteDAO comptedao= new CompteDAO();
        Compte compte=null;
        Client client=null;
        client= (Client)session.getAttribute("client");
      
   	    int identifiant= client.getIdClient();      
   	    

   	    String nomC = client.getNomClient();
   	 	String prenomC = client.getPrenomClient();
 
   	   String moisR= (String)session.getAttribute("mois");  
   	 
   	   int mois = Integer.parseInt(moisR);
   	   
       String cmp= (String)session.getAttribute("selection");        
               int idCompte=comptedao.getCompteId(cmp);    
               
        List<Releve> releves = null;
        
        releves= re.FindReleveDuMois(identifiant, idCompte, mois);
        compte=comptedao.getCompteNumero(cmp);
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
    <link href="css/Infos.css" rel="stylesheet">
	
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
	
			<script type="text/javascript">
			
			 // Get the bouton
			   var b = document.getElementById("b");
			 
			$(document).ready(function(){
				b.onclick = function(event) {
					event.preventDefault();
					var csv_data1 = jQuery("#csv_data1").val();
					//var csv_data2 = jQuery("#csv_data2").val();
					var file_name = jQuery("#file_name").val();
					jQuery.post( "csv.jsp", {
						csv_data1: csv_data1,
						//csv_data2: csv_data2,
						file_name: file_name
					})
				}
			
				
				
			})
	      
   
		</script>


</head>

<body>



<body id="page-top" class="index">

    <div class="wrap">
  <nav class="nav-bar navbar-inverse" role="navigation">
      <div id ="top-menu" class="container-fluid active">
          <a class="navbar-brand" href="#">BIENVENUE SUR VOTRE ESPACE CLIENT</a>
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
                      <li> <a ><span class="fa fa-user"></span> Bienvenue ${sessionScope.client.nomClient} </a></li>
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
            <div class="link"><i class="fa fa-lg fa-users"></i>Comptes <i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
               <li><a data-toggle="modal" data-target="#myModal1" >Créer un compte épargne</a></li>
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
              <li><a href="HistoriqueSelection.jsp">Consulter l'historique de mes releves</a></li>
            </ul>
          </li>  
          
           <li class="nav-header">
            <div class="link"><i class="glyphicon glyphicon-list-alt"></i>Services<i class="fa fa-chevron-down"></i></div>
            <ul class="submenu">
              <li><a href="">Releves de comptes</a></li>
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
 <form name=""  action="CompteEpargne" method="post" id="" novalidate>
									
  <!-- Modal -->
             <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel">CONFIRMATION</h4>
                  </div>
                  <div class="modal-body">
                    Êtes-vous sûr de vouloir créer un compte épargne ?
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
                    <button type="submit"  class="btn btn-primary">Valider</button>
                  </div>
                </div>
              </div>
            </div>
										
								</form>
								
								<div class="container">
	
          <div class="container">
 <form name=""  action="compteTitre" method="post" id="" novalidate>
									
  <!-- Modal -->
             <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel">CONFIRMATION</h4>
                  </div>
                  <div class="modal-body">
                    Êtes-vous sûr de vouloir créer un compte Titre ?
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
                    <button type="submit"  class="btn btn-primary">Valider</button>
                  </div>
                </div>
              </div>
            </div>
										
								</form>
								
								<div class="container">
	 
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
</div>
	</div>
	<div class="container">
	

	
	  <form name="csv_form" method="post" action="ChoixM">

			<br>
			    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="mois" class="form-control selectpicker" >
												<option value= "1" selected> Janvier </option>
												<option value= "2"> Fevrier</option>
												<option value= "3"> Mars </option>
												<option value= "4" selected> Avril </option>
												<option value= "5"> Mai</option>
												<option value= "6"> Juin </option>
												<option value= "7" selected> Juillet </option>
												<option value= "8"> Aout </option>
												<option value= "9"> Septembre </option>
												<option value= "10" selected> Octobre </option>
												<option value= "11"> Novembre </option>
												<option value= "12"> Decembre </option>
												</select>
												
											</div>
			<br>
			<input type="submit"  value="Releve de ce mois"> 
		</form>
		
		<br>
		<br>
	
	  <% 
    if(releves.size()!=0){  %>
    		
  <h2 id="Historique">Relevés du compte </h2>
    <% }
  
  %>
  <% 
    if(releves.size()==0){  %>
    	
    	 <h1 >Il n'ya pas de relevés  pour ce mois</h1>
   <% }
  
  %>
  
  <% 
    if(releves.size()!=0){  %>
    	
      <p id="s"> Solde au  <%= df %> : <%= compte.getSoldeBanque() %> Euros   </p>      
      <p id="s"> Nom du client: <%= nomC %> <%= prenomC %> </p>   
      <p id="s"> Numero de compte : <%= compte.getNumeroDeCompte() %>  </p>      
  <table class="table table-bordered" id="t">
    <thead>
      <tr>
        
        <th>Date</th>
        <th>Nature de l'operation</th>
        <th>Débit</th>
        <th>Crédit</th>
      </tr>
    </thead>
    <tbody>
    <%for (int i =0; i<releves.size(); i++){ %>
      <tr>
        <td>   <%=releves.get(i).getDate() %></td>
        <td>   <%=releves.get(i).getNature() %> </td>
        <td>   <%=releves.get(i).getDebit() %></td>
        <td>   <%=releves.get(i).getCredit() %></td>
      </tr>
      <%} %>
    </tbody>
  </table>
  
  <% }
  
  %>
    
  <%
    if(releves.size()!=0){  %>
	  <form name="csv_form" method="post" action="csv.jsp">

			<br>
			Nom du fichier:<input type="text" name="file_name" value="Releves.csv"/>
			<br>
			<input type="submit" name="b" id="b" value="Extraire Releve (csv)"> 
		</form>
	
	  <% }
  
  %>
		
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