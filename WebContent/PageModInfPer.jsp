<%@ page import="dao.*"%>
    <%@ page import="dto.*"%>
    <%ClientDAO dao= new ClientDAO();
    Client cl= null;
 
     cl=(Client)session.getAttribute("client");
     
     if (cl.getEmailClient() == null)
     {
    	 response.sendRedirect("index.jsp");
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
     	<form name="" method="post" action="ModifierInfoPer" id=""class="well form-horizontal">
			 <div class="form-group">
  <label class="col-md-4 control-label">Nom </label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  placeholder="Votre nom" name="name"  class="form-control"  type="text" required data-validation-required-message="Please enter " value ="<%=cl.getNomClient()%>">
  <p> </p>
    </div>
  </div>
</div>
											<div class="form-group">
  <label class="col-md-4 control-label" >Prénom</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="surname" placeholder="Votre prénom" class="form-control"  type="text" required data-validation-required-message="Please enter" value ="<%=cl.getPrenomClient()%>">
  <p> </p>
    </div>
  </div>
</div>
											<div class="form-group"> 
  <label class="col-md-4 control-label">Civilité</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="Civilite" class="form-control selectpicker" >
												<option value= "monsieur" selected> M </option>
												<option value= "madame"> Mme </option>
												<option value= "mademoiselle"> Mlle </option>
												</select>
												
											</div>
											</div>
											</div>
											<!-- Text input-->
       <div class="form-group">
  <label class="col-md-4 control-label">E-Mail</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
  <input name="mail" placeholder="E-Mail Address" class="form-control"  type="text" required data-validation-required-message="Please enter "value ="<%=cl.getEmailClient()%>">
    </div>
  </div>
</div>

											<div class="form-group">
  <label class="col-md-4 control-label">Date de naissance</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
  <input name="birthday" placeholder="Date de naissance" class="form-control"  type="date" required data-validation-required-message="Please enter" value ="<%=cl.getDateNaissanceClient()%>">
    </div>
  </div>
</div>
											<div class="form-group">
  <label class="col-md-4 control-label">Mot de passe</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span>
  <input name="mdp" placeholder="Mot de passe" class="form-control"  type="password" required data-validation-required-message="Please enter " value ="<%=cl.getMotDePasseClient()%>">
    </div>
  </div>
</div>
											<div class="form-group"> 
  <label class="col-md-4 control-label">Pays d'origine</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="nationalite" class="form-control selectpicker" >
<option name="Afghanistan">Afghanistan </option>	
 <option name="Albanie"> Albanie	</option>
<option name="Algérie">Algérie	</option>
<option value="Allemagne">Allemagne	</option>
<option value="Andorre">Andorre	 </option>
<option value="Angola">Angola	</option>
<option value="Antigua-et-Barbuda">Antigua-et-Barbuda	</option>
<option value="Arabie Saoudite">Arabie Saoudite	 </option>
<option value="Argentine">Argentine	</option>
<option value="Armenie">Arménie	</option>
<option value="Australie">Australie</option>	
<option value="Autriche">Autriche	</option>
<option value="Azerbaidjan">Azerbaïdjan	</option>
<option value="Bahamas">Bahamas	</option>
<option value="Bahrein">Bahreïn	</option>
<option value="Bangladesh">Bangladesh	</option>
<option value="Barbade">Barbade	</option>
<option value="Belgique">Belgique </option>
<option value="Belize">Belize	</option>
<option value="Benin">Bénin	</option>
<option value="Bhoutan">Bhoutan	 </option>
<option value="Bielorussie">Biélorussie	</option>
<option value="Birmanie">Birmanie	</option>
<option value="Bolivie">Bolivie	</option>
<option value="Bosnie-Herzegovine">Bosnie-Herzégovine	</option>
<option value="Botswana">Botswana	</option>
<option value="Bresil">Brésil	</option>
<option value="Brunei">Brunei	</option>
<option value="Bulgarie">Bulgarie	</option>
<option value="Burkina Faso">Burkina Faso </option>	
<option value="Buundi">Burundi	 </option>
<option value="Cambodge">Cambodge	</option>
<option value="Cameroun">Cameroun	</option>
<option value="Canada">Canada	</option>
<option value="Cap vert">Cap-Vert	</option>
<option value="Chili">Chili	</option>
<option value="Chine">Chine	</option>
<option value="Chypre">Chypre	</option>
<option value="Colombie">Colombie </option>
<option value="Corée du Nord">Corée du Nord	</option>
<option value="Corée du  sud">Corée du Sud	</option>
<option value="Costa Rica">Costa Rica	</option>
<option value="Côte d’Ivoire">Côte d’Ivoire	 </option>
<option value="Croatie">Croatie	</option>
<option value="Cuba">Cuba	 </option>
<option value="Danemark">Danemark	</option>
<option value="Djibouti">Djibouti	</option>
<option value="Dominique">Dominique	</option>
<option value="Égypte">Égypte	</option>
<option value="Émirats arabes unis">Émirats arabes unis	</option>
<option value="Équateur">Équateur	</option>
<option value="Érythrée">Érythrée	</option>
<option value="Espagne">Espagne	</option>
<option value="Estonie">Estonie	</option>
<option value="États-Unis">États-Unis	</option>
<option value="Éthiopie">Éthiopie</option>	
<option value="Fidji">Fidji	</option>
<option value="Finlande">Finlande	</option>
<option value="France"  selected>France	</option>
<option value="Gabon">Gabon	</option>
<option value="Gambie"> Gambie	</option>
<option value="Géorgie"> Géorgie	</option>
<option value="Ghana"> Ghana	</option>
<option value="Grèce">Grèce	</option>
<option value="Grenade">Grenade	 </option>
<option value="Guatemala">Guatemala	</option>
<option value="Guinée Conakry">Guinée	Conakry </option>
<option value="Guinée équatoriale">Guinée équatoriale	</option>
<option value="Guinée-Bissau">Guinée-Bissau	</option>
<option value="Guyana">Guyana	</option>
<option value="Haïti">Haïti	</option>
<option value="Honduras">Honduras	</option>
<option value="Hongrie">Hongrie	</option>
<option value="Îles Cook">Îles Cook	</option>
<option value="Îles Marshall">Îles Marshall	</option>
<option value="Inde">Inde	</option>
<option value="Indonésie">Indonésie</option>
<option value="Irak">Irak	</option>
<option value="Iran">Iran	</option>
<option value="Irlande">Irlande	</option>
<option value="Islande">Islande	</option>
<option value="Israël">Israël	</option>
<option value="Italie">Italie	</option>
<option value="Jamaïque">Jamaïque </option>	
<option value="Japon">Japon	</option>
<option value="Jordanie">Jordanie	</option>
<option value="Kazakhstan">Kazakhstan	</option>
<option value="Kenya">Kenya	</option>
<option value="Kirghizistan">Kirghizistan</option>	
<option value="Kiribati">Kiribati	</option>
<option value="Kosovo">Kosovo	</option>
<option value="koweit">Koweït	</option>
<option value="Laos">Laos	</option>
<option value="Lesotho">Lesotho	</option>
<option value="Lettonie">Lettonie	</option>
<option value="Liban">Liban	</option>
<option value="Liberia">Liberia	</option>
<option value="Libye">Libye	</option>
<option value="Liechtenstein">Liechtenstein </option>	
<option value="Lituanie">Lituanie	</option>
<option value="Luxembourg">Luxembourg	</option>
<option value="Macédoine">Macédoine	</option>
<option value="Madagascar">Madagascar	</option>
<option value="Malaisie">Malaisie	</option>
<option value="Malawi">Malawi	</option>
<option value="Maldives">Maldives	</option>
<option value="Mali">Mali	</option>
<option value="Malte">Malte	</option>
<option value="Maroc">Maroc	</option>
<option value="Maurice">Maurice	</option>
<option value="Mauritanie">Mauritanie	</option>
<option value="Mexique">Mexique	 </option>
<option value="Micronésie">Micronésie	</option>
<option value="Moldavie">Moldavie	</option>
<option value="Monaco">Monaco	</option>
<option value="Mongolie">Mongolie	</option>
<option value="Monténégro">Monténégro	</option>
<option value="Mozambique">Mozambique	</option>
<option value="Namibie">Namibie	</option>
<option value="Nauru">Nauru	</option>
<option value="Népal">Népal	</option>
<option value="Nicaragua">Nicaragua </option>
<option value="Niger">Niger	</option>
<option value="Nigeria">Nigeria	</option>
<option value="Niue">Niue	</option>
<option value="Norvège">Norvège	</option>
<option value="Nouvelle-Zélande">Nouvelle-Zélande	</option>
<option value="Oman">Oman	</option>
<option value="Ouganda">Ouganda </option>
<option value="Ouzbékistan">Ouzbékistan	</option>
<option value="Pakistan">Pakistan</option>
<option value="Palaos">Palaos	</option>
<option value="Palestine">Palestine	</option>
<option value="Panama">Panama	</option>
<option value="Papouasie-Nouvelle-Guinée">Papouasie-Nouvelle-Guinée	</option>
<option value="Paraguay">Paraguay	</option>
<option value="Pays-Bas">Pays-Bas	</option>
<option value="Pérou">Pérou	</option>
<option value="Pologne">Pologne	</option>
<option value="Portugal">Portugal	</option>
<option value="Qatar">Qatar	</option>
<option value="République centrafricaine">République centrafricaine	</option>
<option value="République démocratique du Congo">République démocratique du Congo	</option>
<option value="République Dominicaine">République Dominicaine	</option>
<option value="République du Congo">République du Congo	</option>
<option value="République tchèque">République tchèque	</option>
<option value="Roumanie">Roumanie	</option>
<option value="Royaume-Uni">Royaume-Uni </option>
<option value="Russie">Russie	</option>
<option value="Rwanda">Rwanda	</option>
<option value="Saint-Kitts-et-Nevis">Saint-Kitts-et-Nevis	 </option>
<option value="Saint-Vincent-et-les-Grenadines">Saint-Vincent-et-les-Grenadines	</option>
<option value="Sainte-Lucie">Sainte-Lucie	</option>
<option value="Salomon">Salomon	 </option>
<option value="Salvador">Salvador	</option>
<option value="Samoa">Samoa	</option>
<option value="São Tomé-et-Principe">São Tomé-et-Principe	</option>
<option value="Sénégal">Sénégal	</option>
<option value="Serbie">Serbie	</option>
<option value="Seychelles">Seychelles	</option>
<option value="Sierra Leone">Sierra Leone	</option>
<option value="Singapour">Singapour	</option>
<option value="Slovaquie">Slovaquie	</option>
<option value="Slovénie">Slovénie	</option>
<option value="Somalie">Somalie	</option>
<option value="Soudan">Soudan	</option>
<option value="Soudan du Sud">Soudan du Sud	</option>
<option value="Sri Lanka">Sri Lanka </option>
<option value="Suède">Suède	</option>
<option value="Suisse">Suisse	</option>
<option value="Surivalue">Surivalue	</option>
<option value="Swaziland">Swaziland</option>
<option value="Syrie">Syrie	 </option>
<option value="Tadjikistan">Tadjikistan	</option>
<option value="Tanzanie">Tanzanie	</option>
<option value="Tchad">Tchad	</option>
<option value="Thaïlande">Thaïlande	</option>
<option value="Timor oriental">Timor oriental	</option>
<option value="Togo">Togo	</option>
<option value="Tonga">Tonga	</option>
<option value="Trinité-et-Tobago">Trinité-et-Tobago	</option>
<option value="Tunisie">Tunisie	</option>
<option value="Turkménistan">Turkménistan	</option>
<option value="Turquie">Turquie</option>
<option value="Tuvalu">Tuvalu	</option>
<option value="Uruguay">Uruguay	</option>
<option value="Vatican">Vatican	</option>
<option value="Venezuela">Venezuela	</option>
<option value="Viêt Nam">Viêt Nam   </option>
<option value="Yémen">Yémen	</option>
<option value="Zambie">Zambie	</option>
<option value="Zimbabwe">Zimbabwe	</option>
</select>
</div>

												
											</div>
											</div>
											<div class="form-group"> 
  <label class="col-md-4 control-label">Type de compte</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="type_compte" class="form-control selectpicker" >
												<option value= "Compte individuel"> Compte individuel </option>
												<option value= "compte joint"> Compte joint </option>
												</select>
												</div>
												
											</div>
											</div>
											<div class="form-group"> 
  <label class="col-md-4 control-label">Pays de résidence</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="pays" class="form-control selectpicker" > <!-- ATTENTION AU JSP ICI FORMULAIRE A MODIFIER -->  
<option name="Afghanistan">Afghanistan </option>	
 <option name="Albanie"> Albanie	</option>
<option name="Algérie">Algérie	</option>
<option value="Allemagne">Allemagne	</option>
<option value="Andorre">Andorre	 </option>
<option value="Angola">Angola	</option>
<option value="Antigua-et-Barbuda">Antigua-et-Barbuda	</option>
<option value="Arabie Saoudite">Arabie Saoudite	 </option>
<option value="Argentine">Argentine	</option>
<option value="Armenie">Arménie	</option>
<option value="Australie">Australie</option>	
<option value="Autriche">Autriche	</option>
<option value="Azerbaidjan">Azerbaïdjan	</option>
<option value="Bahamas">Bahamas	</option>
<option value="Bahrein">Bahreïn	</option>
<option value="Bangladesh">Bangladesh	</option>
<option value="Barbade">Barbade	</option>
<option value="Belgique">Belgique </option>
<option value="Belize">Belize	</option>
<option value="Benin">Bénin	</option>
<option value="Bhoutan">Bhoutan	 </option>
<option value="Bielorussie">Biélorussie	</option>
<option value="Birmanie">Birmanie	</option>
<option value="Bolivie">Bolivie	</option>
<option value="Bosnie-Herzegovine">Bosnie-Herzégovine	</option>
<option value="Botswana">Botswana	</option>
<option value="Bresil">Brésil	</option>
<option value="Brunei">Brunei	</option>
<option value="Bulgarie">Bulgarie	</option>
<option value="Burkina Faso">Burkina Faso </option>	
<option value="Buundi">Burundi	 </option>
<option value="Cambodge">Cambodge	</option>
<option value="Cameroun">Cameroun	</option>
<option value="Canada">Canada	</option>
<option value="Cap vert">Cap-Vert	</option>
<option value="Chili">Chili	</option>
<option value="Chine">Chine	</option>
<option value="Chypre">Chypre	</option>
<option value="Colombie">Colombie </option>
<option value="Corée du Nord">Corée du Nord	</option>
<option value="Corée du  sud">Corée du Sud	</option>
<option value="Costa Rica">Costa Rica	</option>
<option value="Côte d’Ivoire">Côte d’Ivoire	 </option>
<option value="Croatie">Croatie	</option>
<option value="Cuba">Cuba	 </option>
<option value="Danemark">Danemark	</option>
<option value="Djibouti">Djibouti	</option>
<option value="Dominique">Dominique	</option>
<option value="Égypte">Égypte	</option>
<option value="Émirats arabes unis">Émirats arabes unis	</option>
<option value="Équateur">Équateur	</option>
<option value="Érythrée">Érythrée	</option>
<option value="Espagne">Espagne	</option>
<option value="Estonie">Estonie	</option>
<option value="États-Unis">États-Unis	</option>
<option value="Éthiopie">Éthiopie</option>	
<option value="Fidji">Fidji	</option>
<option value="Finlande">Finlande	</option>
<option value="France"  selected>France	</option>
<option value="Gabon">Gabon	</option>
<option value="Gambie"> Gambie	</option>
<option value="Géorgie"> Géorgie	</option>
<option value="Ghana"> Ghana	</option>
<option value="Grèce">Grèce	</option>
<option value="Grenade">Grenade	 </option>
<option value="Guatemala">Guatemala	</option>
<option value="Guinée Conakry">Guinée	Conakry </option>
<option value="Guinée équatoriale">Guinée équatoriale	</option>
<option value="Guinée-Bissau">Guinée-Bissau	</option>
<option value="Guyana">Guyana	</option>
<option value="Haïti">Haïti	</option>
<option value="Honduras">Honduras	</option>
<option value="Hongrie">Hongrie	</option>
<option value="Îles Cook">Îles Cook	</option>
<option value="Îles Marshall">Îles Marshall	</option>
<option value="Inde">Inde	</option>
<option value="Indonésie">Indonésie</option>
<option value="Irak">Irak	</option>
<option value="Iran">Iran	</option>
<option value="Irlande">Irlande	</option>
<option value="Islande">Islande	</option>
<option value="Israël">Israël	</option>
<option value="Italie">Italie	</option>
<option value="Jamaïque">Jamaïque </option>	
<option value="Japon">Japon	</option>
<option value="Jordanie">Jordanie	</option>
<option value="Kazakhstan">Kazakhstan	</option>
<option value="Kenya">Kenya	</option>
<option value="Kirghizistan">Kirghizistan</option>	
<option value="Kiribati">Kiribati	</option>
<option value="Kosovo">Kosovo	</option>
<option value="koweit">Koweït	</option>
<option value="Laos">Laos	</option>
<option value="Lesotho">Lesotho	</option>
<option value="Lettonie">Lettonie	</option>
<option value="Liban">Liban	</option>
<option value="Liberia">Liberia	</option>
<option value="Libye">Libye	</option>
<option value="Liechtenstein">Liechtenstein </option>	
<option value="Lituanie">Lituanie	</option>
<option value="Luxembourg">Luxembourg	</option>
<option value="Macédoine">Macédoine	</option>
<option value="Madagascar">Madagascar	</option>
<option value="Malaisie">Malaisie	</option>
<option value="Malawi">Malawi	</option>
<option value="Maldives">Maldives	</option>
<option value="Mali">Mali	</option>
<option value="Malte">Malte	</option>
<option value="Maroc">Maroc	</option>
<option value="Maurice">Maurice	</option>
<option value="Mauritanie">Mauritanie	</option>
<option value="Mexique">Mexique	 </option>
<option value="Micronésie">Micronésie	</option>
<option value="Moldavie">Moldavie	</option>
<option value="Monaco">Monaco	</option>
<option value="Mongolie">Mongolie	</option>
<option value="Monténégro">Monténégro	</option>
<option value="Mozambique">Mozambique	</option>
<option value="Namibie">Namibie	</option>
<option value="Nauru">Nauru	</option>
<option value="Népal">Népal	</option>
<option value="Nicaragua">Nicaragua </option>
<option value="Niger">Niger	</option>
<option value="Nigeria">Nigeria	</option>
<option value="Niue">Niue	</option>
<option value="Norvège">Norvège	</option>
<option value="Nouvelle-Zélande">Nouvelle-Zélande	</option>
<option value="Oman">Oman	</option>
<option value="Ouganda">Ouganda </option>
<option value="Ouzbékistan">Ouzbékistan	</option>
<option value="Pakistan">Pakistan</option>
<option value="Palaos">Palaos	</option>
<option value="Palestine">Palestine	</option>
<option value="Panama">Panama	</option>
<option value="Papouasie-Nouvelle-Guinée">Papouasie-Nouvelle-Guinée	</option>
<option value="Paraguay">Paraguay	</option>
<option value="Pays-Bas">Pays-Bas	</option>
<option value="Pérou">Pérou	</option>
<option value="Pologne">Pologne	</option>
<option value="Portugal">Portugal	</option>
<option value="Qatar">Qatar	</option>
<option value="République centrafricaine">République centrafricaine	</option>
<option value="République démocratique du Congo">République démocratique du Congo	</option>
<option value="République Dominicaine">République Dominicaine	</option>
<option value="République du Congo">République du Congo	</option>
<option value="République tchèque">République tchèque	</option>
<option value="Roumanie">Roumanie	</option>
<option value="Royaume-Uni">Royaume-Uni </option>
<option value="Russie">Russie	</option>
<option value="Rwanda">Rwanda	</option>
<option value="Saint-Kitts-et-Nevis">Saint-Kitts-et-Nevis	 </option>
<option value="Saint-Vincent-et-les-Grenadines">Saint-Vincent-et-les-Grenadines	</option>
<option value="Sainte-Lucie">Sainte-Lucie	</option>
<option value="Salomon">Salomon	 </option>
<option value="Salvador">Salvador	</option>
<option value="Samoa">Samoa	</option>
<option value="São Tomé-et-Principe">São Tomé-et-Principe	</option>
<option value="Sénégal">Sénégal	</option>
<option value="Serbie">Serbie	</option>
<option value="Seychelles">Seychelles	</option>
<option value="Sierra Leone">Sierra Leone	</option>
<option value="Singapour">Singapour	</option>
<option value="Slovaquie">Slovaquie	</option>
<option value="Slovénie">Slovénie	</option>
<option value="Somalie">Somalie	</option>
<option value="Soudan">Soudan	</option>
<option value="Soudan du Sud">Soudan du Sud	</option>
<option value="Sri Lanka">Sri Lanka </option>
<option value="Suède">Suède	</option>
<option value="Suisse">Suisse	</option>
<option value="Surivalue">Surivalue	</option>
<option value="Swaziland">Swaziland</option>
<option value="Syrie">Syrie	 </option>
<option value="Tadjikistan">Tadjikistan	</option>
<option value="Tanzanie">Tanzanie	</option>
<option value="Tchad">Tchad	</option>
<option value="Thaïlande">Thaïlande	</option>
<option value="Timor oriental">Timor oriental	</option>
<option value="Togo">Togo	</option>
<option value="Tonga">Tonga	</option>
<option value="Trinité-et-Tobago">Trinité-et-Tobago	</option>
<option value="Tunisie">Tunisie	</option>
<option value="Turkménistan">Turkménistan	</option>
<option value="Turquie">Turquie</option>
<option value="Tuvalu">Tuvalu	</option>
<option value="Uruguay">Uruguay	</option>
<option value="Vatican">Vatican	</option>
<option value="Venezuela">Venezuela	</option>
<option value="Viêt Nam">Viêt Nam   </option>
<option value="Yémen">Yémen	</option>
<option value="Zambie">Zambie	</option>
<option value="Zimbabwe">Zimbabwe	</option>
</select>
</div>

 
												
											</div>
											</div>
											<div class="form-group">
  <label class="col-md-4 control-label"> Téléphone </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
  <input name="phone" placeholder="0750501023" class="form-control" type="tel" required data-validation-required-message="Please enter" value ="<%=cl.getTelephoneClient()%>">
    </div>
  </div>
</div>

											
											<div class="form-group">
  <label class="col-md-4 control-label">Adresse</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="adresse" placeholder="Adresse" class="form-control"  type="text" required data-validation-required-message="Please enter " value ="<%=cl.getAdresseClient()%>">
    </div>
</div>
</div>
											
										
											<div class="form-group">
  <label class="col-md-4 control-label">Code postal </label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="code_postal" placeholder="Adresse" class="form-control"  type="text" required data-validation-required-message="Please enter"value ="<%=cl.getCodepostalClient()%>">
    </div>
</div>
</div>


											<div class="form-group">
  <label class="col-md-4 control-label"> Ville</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="ville" placeholder="ville" class="form-control"  type="text" required data-validation-required-message="Please enter "value ="<%=cl.getVilleClient()%>">
    </div>
</div>
</div>

										<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
    <button  type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2" > Modifier </button>
  </div>
</div>

									</div>
									
				<!-- Modal -->
             <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
              <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h4 class="modal-title" id="myModalLabel">MODIFICATION</h4>
                  </div>
                  <div class="modal-body">
                    Êtes-vous sûr de vouloir modifier vos données ?
                  </div>
                  <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
                    <button type="submit"  class="btn btn-primary">Valider</button>
                  </div>
                </div>
              </div>
            </div>					
									
									
									
									
									

			</form>
     	
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









