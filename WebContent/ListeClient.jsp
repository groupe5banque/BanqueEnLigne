<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
   <%@ page import="dao.*"%>
   <%@ page import="dto.*"%>
   <%@page import= "java.util.ArrayList" %>
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

    <title>Liste des Clients</title>

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

    <div class="wrap">
  <nav class="nav-bar navbar-inverse" role="navigation">
      <div id="top-menu" class="container-fluid active">
          <a class="navbar-brand" href="#">BIENVENUE SUR VOTRE ESPACE MANAGERIAL</a>
          <ul class="nav navbar-nav">        
              <li>
                        <a href="#portfolio">Actualités</a>
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
					<i class="fa fa-lg fa-user"></i>Clients<i class="fa fa-chevron-down"></i>
				</div>
            <ul class="submenu">
              <li><a href="ListeClient.jsp">Generer des reportings</a></li>  
              <li><a href="">Consulter somme des depots</a></li>  
              
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
    
    
    <div class="text-right form-group">

				
		<input name="NOM" id="NOM" placeholder="Nom du Client" class="form-control"  style ="display: inline-block; width: 200px;" type="text" required data-validation-required-message="Nom du client svp ">
	
		<button id="bouton" type="submit" style ="display: inline-block;">Generer Reporting</button>
  		
	</div> 
	
        <br>


        <h4 class="text-center"> Liste des clients </h4>     


    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
       <div id="table_div"></div>
    


<!-- Modal Reportings-->

    
<div id="reporting" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    
             <P id= "titre" class="text-center"> REPORTING </P>
           
           <br>
           
           <p class = "element"> NOM:   </p>
           <textarea id="textarea.nom" name="nom" disabled="disabled"></textarea>
           <p class = "element"> PRENOM :   </p>
           <textarea id="textarea.prenom" name="nom" disabled="disabled"></textarea>
           <p class = "element"> CIVILITE :  </p> 
           <textarea id="textarea.civilite" name="nom" disabled="disabled"></textarea>
           <p class = "element"> EMAIL :  </p> 
           <textarea id="textarea.email" name="nom" disabled="disabled"></textarea>
           <p class = "element"> DATE DE NAISSANCE :  </p> 
           <textarea id="textarea.dateNaissance" name="nom" disabled="disabled"></textarea>
            <p class = "element"> MOT DE PASSE :  </p> 
           <textarea id="textarea.motDePasse" name="nom" disabled="disabled"></textarea>
            <p class = "element"> NATIONALITE :  </p> 
           <textarea id="textarea.nationalite" name="nom" disabled="disabled"></textarea>
           <p class = "element"> TYPE DE COMPTE :  </p> 
           <textarea id="textarea.typeCompte" name="nom" disabled="disabled"></textarea>
           <p class = "element"> TELEPHONE :  </p> 
           <textarea id="textarea.telephone" name="nom" disabled="disabled"></textarea>
           <p class = "element"> ADRESSE :  </p> 
           <textarea id="textarea.adresse" name="nom" disabled="disabled"></textarea>
           <p class = "element"> CODE POSTAL :  </p> 
           <textarea id="textarea.codePostal" name="nom" disabled="disabled"></textarea>
           <p class = "element"> VILLE :  </p> 
           <textarea id="textarea.ville" name="nom" disabled="disabled"></textarea>
           <p class = "element"> PAYS :  </p> 
           <textarea id="textarea.pays" name="nom" disabled="disabled"></textarea>
  </div>

</div>

    	<div class="container" >

     
  <table class="table table-bordered" id="t1">
    <thead>
      <tr>
        <th>Nom</th>
        <th>Prenom</th>
        <th>Civilite</th>
        <th>Email</th>
        <th>Date de naissance</th>
        <th>Mot de passe</th>
        <th>Nationalite</th>
        <th>Type de Compte</th>
        <th>Telephone</th>
        <th>Adresse</th>
        <th>Codepostal</th>
        <th>Ville</th>
        <th>Pays</th>
      </tr>
    </thead>
    <tbody>
    <%for (Client sujet: lc){ %>
      <tr >

        <td id="NomR">   <%=sujet.getNomClient() %> </td>
        <td>   <%=sujet.getPrenomClient() %> </td>
        <td>   <%=sujet.getCiviliteClient() %></td>
        <td>   <%=sujet.getEmailClient() %></td>
        <td>   <%=sujet.getDateNaissanceClient() %></td>
        <td>   <%=sujet.getMotDePasseClient() %></td>
        <td>   <%=sujet.getNationaliteClient() %></td>
        <td>   <%=sujet.getTypeCompte() %></td>
        <td>   <%=sujet.getTelephoneClient() %></td>
        <td>   <%=sujet.getAdresseClient() %></td>
        <td>   <%=sujet.getCodepostalClient() %></td>
        <td>   <%=sujet.getVilleClient() %></td>
        <td>   <%=sujet.getPaysClient() %></td>
        
      </tr>
      <%} %>
    </tbody>
  </table>
</div>

   <script type="text/javascript">  
   
   window.onload = addRowHandlers;
   
   function addRowHandlers() {
	    var table = document.getElementById("t1");
	    var rows = table.getElementsByTagName("tr");
	    for (i = 0; i < rows.length; i++) {
	        var currentRow = table.rows[i];
	        var createClickHandler = 
	        	
	            function(row) 
	            {
	                return function() {  	modal.style.display = "block";
	                
	                                        var cell0 = row.getElementsByTagName("td")[0];
	                                        var cell1 = row.getElementsByTagName("td")[1];
	                                        var cell2 = row.getElementsByTagName("td")[2];
	                                        var cell3 = row.getElementsByTagName("td")[3];
	                                        var cell4 = row.getElementsByTagName("td")[4];
	                                        var cell5 = row.getElementsByTagName("td")[5];
	                                        var cell6 = row.getElementsByTagName("td")[6];
	                                        var cell7 = row.getElementsByTagName("td")[7];
	                                        var cell8 = row.getElementsByTagName("td")[8];
	                                        var cell9 = row.getElementsByTagName("td")[9];
	                                        var cell10 = row.getElementsByTagName("td")[10];
	                                        var cell11 = row.getElementsByTagName("td")[11];
	                                        var cell12 = row.getElementsByTagName("td")[12];
	                                        
	                                        var id0 = cell0.innerHTML;
	                                        var id1 = cell1.innerHTML;
	                                        var id2 = cell2.innerHTML;
	                                        var id3 = cell3.innerHTML;
	                                        var id4 = cell4.innerHTML;
	                                        var id5 = cell5.innerHTML;
	                                        var id6 = cell6.innerHTML;
	                                        var id7 = cell7.innerHTML;
	                                        var id8 = cell8.innerHTML;
	                                        var id9 = cell9.innerHTML;
	                                        var id10 = cell10.innerHTML;
	                                        var id11 = cell11.innerHTML;
	                                        var id12 = cell12.innerHTML;
	                                        
	                                        document.getElementById('textarea.nom').innerHTML = id0;
	                                        document.getElementById('textarea.prenom').innerHTML = id1;
	                                        document.getElementById('textarea.civilite').innerHTML = id2;
	                                        document.getElementById('textarea.email').innerHTML = id3;
	                                        document.getElementById('textarea.dateNaissance').innerHTML = id4;
	                                        document.getElementById('textarea.motDePasse').innerHTML = id5;
	                                        document.getElementById('textarea.nationalite').innerHTML = id6;
	                                        document.getElementById('textarea.typeCompte').innerHTML = id7;
	                                        document.getElementById('textarea.telephone').innerHTML = id8;
	                                        document.getElementById('textarea.adresse').innerHTML = id9;
	                                        document.getElementById('textarea.codePostal').innerHTML = id10;
	                                        document.getElementById('textarea.ville').innerHTML = id11;
	                                        document.getElementById('textarea.pays').innerHTML = id12;
	                                        
	                                        
	                                        //alert("Client:" + id);
	                                 };
	            };

	        currentRow.onclick = createClickHandler(currentRow);
	    }
	}
   
   
   
   
   // Get the modal
   var modal = document.getElementById("reporting");

   // Get the link that opens the modal
  // var link = document.getElementById("bouton");

   // Get the <span> element that closes the modal
   var span = document.getElementsByClassName("close")[0];

   // Ouvre le modal quand on appuie sur le bouton
   //link.onclick = function() {
    //  modal.style.display = "block";
   //}

   // Ferme le modal quand on appuie sur <X>
   span.onclick = function() {
       modal.style.display = "none";
   }

   // Ferme le modal quand on appuie en dehors de celui-ci
   window.onclick = function(event) {
       if (event.target == modal) {
           modal.style.display = "none";
       }
   }
   
   
   </script>
 	
    </section>
    
 
    
    </div>  
      
    </div>  
        
</body>
</html>
       