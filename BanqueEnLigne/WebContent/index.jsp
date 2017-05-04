<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="dao.*" %>
    <%@ page import="dto.*" %>
    <%@ page import="java.util.ArrayList" %>
 	<%@ page import="javax.mail.MessagingException" %>
 	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<%
		NewsDAO nd=new NewsDAO();
	
	
	ArrayList <News> vide = new ArrayList<News>();
	
	//affichage simple
	    ArrayList<News> PrintNews = nd.getAllNews();
	//affichage par thème de news
	 	String themeNews = (String) request.getAttribute("themeAttr");
	 	ArrayList<News> actu = nd.getActuByTheme(themeNews);
	%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bank 8-5 Of ESIGELEC</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Theme CSS -->
    <link href="css/agency.css" rel="stylesheet">

	<style type="text/css">
        .news h1, h3
        {
            text-align:center;
        }
        .news h3
        {
            background-color:black;
            color:white;
            font-size:0.9em;
            margin-bottom:0px;
        }
        .news p
        {
            background-color:#CCCCCC;
            margin-top:0px;
        }
        .news
        {
            width:650px;
            margin:auto;
        }
        </style>
</head>

<body id="page-top" class="index">

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-custom navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="index.jsp">LOGO BANQUE</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">Services</a>
					</li>
                    <li>
                        <a class="page-scroll" href="#portfolio">Actualités</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">Souscrire</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#team">Se connecter</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>		

    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
                <div class="intro-lead-in">
                	<p> Welcome to our new online bank website </p>
                </div>
                <div class="intro-heading">Bank 8-5 of ESIGELEC</div>
                <a href="#services" class="page-scroll btn btn-xl">Poursuivez vers le bas</a>
            </div>
        </div>
    </header>

    <!-- SERVICES Section -->
    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Services</h2>
                    <h3 class="section-subheading1 text-muted">Voici les services que nous vous proposons et qui sont entièrement sécurisés.</h3>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-3">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-institution fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Créer un compte courant</h4>
                    <p class="text-muted">Créer un compte courant dans notre banque vous permettra de réaliser des dépots d'argent sur votre compte, d'effectuer des transactions, gérer votre argent. <u>(Requiert une inscription sur notre site)</u></p>
                </div>
                <div class="col-md-3">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-book fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Créer un compte épargne</h4>
                    <p class="text-muted">La création d'un compte épargne vous permettra de réaliser des dépots d'argent sans plafond, en prévision de vos dépenses futures. <u>(Requiert une inscription sur notre site)</u></p>
                </div>
                <div class="col-md-3">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-briefcase fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Créer un compte titre</h4>
                    <p class="text-muted">La création d'un compte titre vous permettra de détenir des titres et des valeurs mobilières. Ce compte est rattaché à votre compte courant pour vous permettre de réaliser des achats et des ventes. <u>(Requiert une inscription sur notre site)</u></p>
                </div>
				<div class="col-md-3">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <a href="#"><i class="fa fa-area-chart fa-stack-1x fa-inverse"></i></a>
                    </span>
                    <h4 class="service-heading">Voir le cours de la bourse</h4>
                    <p class="text-muted">Vous pouvez voir le cours de la bourse en cliquant sur l'icône ci-dessus. <u>(Possible en tant que visiteur)</u></p>
                </div>
            </div>
        </div>
    </section>
    
    
    
    <!-- ACTUALITES Section -->
    <section id="portfolio" class="bg-light-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Actualités</h2>
                    <h3 class="section-subheading1 text-muted">Vous trouverez dans cette section toute l'actualité concernant notre banque</h3>
                  
                  <!-- COPIER A PARTIR D'ICI... -->  
                    <form method="post" action="Home#portfolio" id="" class="well form-horizontal">
  						<label for="theme">Vous pouvez chercher des news par thème :</label>
						<input type="text" id="theme" name="theme" placeholder="Entrer le thème de votre choix" title="Entrer le thème de votre choix" size="25">
						<button class="btn btn-l" type="submit" name="boutontheme">Envoyer</button> 
                   </form>
               </div>
           </div>     
<br>
            <div class="row">
                <% if(request.getParameter("boutontheme") == null){
                for(int i =0; i< PrintNews.size();i++){
                	vide.add(PrintNews.get(i));
                	}
                }
                else if(request.getParameter("boutontheme") != null){
                    for(int i =0; i< actu.size();i++){
                    	vide.add(actu.get(i));
                    }
                }
                	for(int i =0; i< vide.size();i++) {%>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <div class ="portfolio-caption">
                    	<% int indice= vide.get(i).getidimg(); %>
                        <img src="./img/actualites/<%= indice %>.jpg" class="img-responsive" alt="">
                        <h4><%= PrintNews.get(i).getTitre() %></h4>
                        	<p>Thème oui : <%= vide.get(i).getTheme() %></p>
		                    <em><%= vide.get(i).gettimestamp() %></em>
		                
		                <br>
                        <p class="text-muted"><%= vide.get(i).getContenu() %></p>
                    </div>
                </div>     
	             <% }
	             %>
	            </div>
	            
	            <!--  ...JUSQUE LA ET COLLER SUR LA VERSION FINALE -->
	     </div>
    </section>

    <!-- SOUSCRIPTION Section -->
    <section id="about">
        <div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Souscrire</h2>
					<h3 class="section-subheading1 text-muted">Vous pouvez vous créer un compte sur notre site en cliquant sur l'icône suivant.</h3>
				</div>
			</div>
            <div class="row text-center">
                <div class="col-md-4">
				</div> 
				<div class="col-md-4">
					<a href="#souscription" class="portfolio-link" data-toggle="modal">
					<div class="portfolio-hover">
                        <div class="portfolio-hover-content">
							<span class="fa-stack fa-4x">
								<i class="fa fa-circle fa-stack-2x text-primary"></i>
								<i class="fa fa-user-plus fa-stack-1x fa-inverse"></i>
							</span>
						</div>
                    </div>
					</a>
                    <h4 class="service-heading">Créer un compte avec un profil personnel</h4>
                    <p class="text-muted">La création d'un compte sur notre site vous permettra d'accéder à toutes les fonctionnalités possibles citées dans la partie "Service". (voir le cours de la bourse vous ait possible en tant que visiteur)</p>
                </div>
				<div class="col-md-4">
				</div>
            </div>
        </div>
    </section>

    <!-- CONNEXION Section -->
    <section id="team" class="bg-light-gray">
        <div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">Se connecter</h2>
					<h3 class="section-subheading1 text-muted">Vous pouvez vous vous connectez sur notre site en cliquant sur l'icône suivant.</h3>
				</div>
			</div>
            <div class="row text-center">
                <div class="col-md-4">
				</div>
				<div class="col-md-4">
					<a href="#connexion" class="portfolio-link" data-toggle="modal">
					<div class="portfolio-hover">
                        <div class="portfolio-hover-content">
							<span class="fa-stack fa-4x">
								<i class="fa fa-circle fa-stack-2x text-primary"></i>
								<i class="fa fa-user fa-stack-1x fa-inverse"></i>
							</span>
						</div>
                    </div>
					</a>
                    <h4 class="service-heading">Connexion avec un profil existant</h4>
                    <p class="text-muted">La connexion à votre compte vous permettre d'accéder à toutes les fonctionnalités du site ainsi que voir toutes vos informations personnelles</p>
                </div>
				<div class="col-md-4">
				</div>
            </div>
        </div>
    </section>

     <!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Contactez-nous !</h2>
                    <h3 class="section-subheading text-muted"> Si vous avez des questions ou que vous avez besoin d'informations, n'hésitez pas à nous contacter à l'aide du formulaire suivant.</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                
                <%!	String message = null;
	String status = null; %>
           
           <%  		
	if (request.getParameter("sendContact") != null) {
		JavaEmail javaEmail = new JavaEmail();
		javaEmail.setMailServerProperties();
		String emailSubject = "Formulaire de contact de la plateforme Banque S8-5";
		String emailBody = "";
		if (request.getParameter("name") != null) {
			emailBody = "Sender Name: " + request.getParameter("name")
					+ "<br>";
		}
		if (request.getParameter("email") != null) {
			emailBody = emailBody + "Sender Email: "
					+ request.getParameter("email") + "<br>";
		}
		if (request.getParameter("phone") != null) {
			emailBody = emailBody + "Sender Phone: "
					+ request.getParameter("phone") + "<br>";
		}
		if (request.getParameter("message") != null) {
			emailBody = emailBody + "Message: " + request.getParameter("message")
					+ "<br>";
		}
		javaEmail.createEmailMessage(emailSubject, emailBody);
		try {
			javaEmail.sendEmail();
			status = "success";
			message = "Email sent Successfully!";
		} catch (MessagingException me) {
			status = "error";
			message = "Error in Sending Email!";
		}
	}
%>

                    <form action="" method="POST" id="" novalidate="novalidate">
                    
					                   <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
						<input type="text" id="pp-name"  class="form-control" name="name"
							placeholder="enter your name here" title="Please enter your name"
							class="required" aria-required="true" required>
							 <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
					
						<input type="email" class="form-control" id="pp-email" name="email"
							placeholder="enter your email address here"
							title="Please enter your email address" class="required email"
							aria-required="true" required>
							
					<p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
                                
						<input type="tel" id="pp-phone" name="phone"
							placeholder="enter your phone number here"
							 class="form-control" title="Please enter your phone number" class="required phone"
							aria-required="true" required>
							
					<p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                
						<textarea id="about-project" name="message"
							 class="form-control" placeholder="enter your message here"></textarea>
					 <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <div class="col-lg-12 text-center">
                                <div id="success"></div>
                                
                              <a class="btn btn-xl" type="submit"  name="sendContact"  href="#Resultat2" data-toggle="modal" data-dismiss="modal">Envoyer</a>       
                          
                            </div>
                        </div>
					

					
                    </form>
                </div>
            </div>
        </div>
    </section>


    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <span class="copyright">Copyright &copy; Bank 8-5 2017</span>
                </div>
				<div class="col-md-6">
                    <span class="copyright">Bank website for a project at ESIGELEC</span>
                </div>
            </div>
        </div>
    </footer>


                <%!	String rep = null;
					String stat = null; %>
           
           <%  		
	if (request.getParameter("sendNew") != null) {
		
		MailSend mailSend = new MailSend();
		mailSend.setMailServerProperties();
		
		String emailSubject = "Confirmation de creation d'un nouveau compte en ligne sur la plateforme Banque S8-5";
		String emailBody = " Bonjour nous vous confirmons la creation d'un compte bancaire sur le site officiel de la Banque en Ligne S8-5 . \n\n Vos informations personnelles enregistrees sont les suivantes:";
		
		if (request.getParameter("nom") != null) {
			emailBody = "Nom: " + request.getParameter("nom")
					+ "<br>";
		}
		if (request.getParameter("surname") != null) {
			emailBody =  emailBody +"Prenom: " + request.getParameter("surname")
					+ "<br>";
		}
		if (request.getParameter("Civilite") != null) {
			emailBody =  emailBody +"Civilite: " + request.getParameter("Civilite")
					+ "<br>";
		}
		if (request.getParameter("mail") != null) {
			emailBody = emailBody + " Email: "
					+ request.getParameter("mail") + "<br>";
		}
		if (request.getParameter("birthday") != null) {
			emailBody =  emailBody +"Date de naissance: " + request.getParameter("birthday")
					+ "<br>";
		}
		if (request.getParameter("nationalite") != null) {
			emailBody =  emailBody +"Nationalite: " + request.getParameter("nationalite")
					+ "<br>";
		}
		if (request.getParameter("type_compte") != null) {
			emailBody =  emailBody +"Type de compte:"  + request.getParameter("type_compte")
					+ "<br>";
		}
		if (request.getParameter("phone") != null) {
			emailBody = emailBody + "Telephone: "
					+ request.getParameter("phone") + "<br>";
		}
		if (request.getParameter("adresse") != null) {
			emailBody = emailBody + "Adresse: " + request.getParameter("adresse")
					+ "<br>";
		}
		if (request.getParameter("code_postal") != null) {
			emailBody = "Code Postal: " + request.getParameter("code_postal")
					+ "<br>";
		}
		if (request.getParameter("ville") != null) {
			emailBody =  emailBody + "Ville: " + request.getParameter("ville")
					+ "<br>";
		}
		if (request.getParameter("pays") != null) {
			emailBody =  emailBody +"Pays: " + request.getParameter("pays")
					+ "<br>";
		}
		
		emailBody = "<br> En cas d'erreur, connectez sur notre site et modifier les informations correspondantes. Le lien vers notre site est le suivant: <a href='#connexion'> </a>";
		mailSend.createEmailMessage(emailSubject, emailBody, request.getParameter("mail"));
		
		try {
			mailSend.sendEmail();
			stat = "success";
			rep = "Email sent Successfully!";
		} catch (MessagingException me) {
			stat = "error";
			rep = "Error in Sending Email!";
		}
	}
%>

	<!-- SOUSCRIPTION --> <!-- ATTENTION AU JSP ICI FORMULAIRE A MODIFIER--> 
		<div class="portfolio-modal modal fade" id="souscription" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="close-modal" data-dismiss="modal">
						<div class="lr">
							<div class="rl">
							</div>
						</div>
					</div>
					<div class="container">
						<div class="row">
							<div class="col-lg-12 text-center">
								<h2 class="section-heading1">Souscription</h2>
								<h3 class="section-subheading1 text-muted"> Les champs suivants vous permettront de vous enregistrer et d'accéder à toutes les fonctionnalités de notre banque.</h3>
							</div> 
						</div>
						
								<form name="" method="post" action="Home" id="" class="well form-horizontal">
								
  <div class="form-group">
  <label class="col-md-4 control-label">Nom </label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input  placeholder="Votre nom" name="name"  class="form-control"  type="text" required data-validation-required-message="Please enter ">
  <p> </p>
    </div>
  </div>
</div>
											<div class="form-group">
  <label class="col-md-4 control-label" >Prénom</label> 
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
  <input name="surname" placeholder="Votre prénom" class="form-control"  type="text" required data-validation-required-message="Please enter ">
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
													  <input name="mail" id="mail" placeholder="E-Mail Address" class="form-control"  type="email" required data-validation-required-message="Entrez votre adresse mail svp ">
													    </div>
  											</div>
									</div>

											<div class="form-group">
  <label class="col-md-4 control-label">Date de naissance</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
  <input name="birthday" placeholder="Date de naissance" class="form-control"  type="date" required data-validation-required-message="Please enter ">
    </div>
  </div>
</div>
											<div class="form-group">
  <label class="col-md-4 control-label">Mot de passe</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-asterisk"></i></span>
  <input name="mdp" placeholder="Mot de passe" class="form-control"  type="password" required data-validation-required-message="Please enter ">
    </div>
  </div>
</div>
											<div class="form-group"> 
  <label class="col-md-4 control-label">Pays d'origine</label>
    <div class="col-md-4 selectContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
    <select name="nationalite" class="form-control selectpicker" >
<option value="Afghanistan">Afghanistan </option>	
 <option value="Albanie"> Albanie	</option>
<option value="Algérie">Algérie	</option>
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
<option value="Afghanistan">Afghanistan </option>	
 <option value="Albanie"> Albanie	</option>
<option value="Algérie">Algérie	</option>
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
  <input name="phone" placeholder="0750501023" class="form-control" type="tel" required data-validation-required-message="Please enter ">
    </div>
  </div>
</div>

											
											<div class="form-group">
  <label class="col-md-4 control-label">Adresse</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="adresse" placeholder="Adresse" class="form-control"  type="text" required data-validation-required-message="Please enter ">
    </div>
</div>
</div>
											
										
					<div class="form-group">
											
  										<label class="col-md-4 control-label">Code postal </label>  
    									
    											<div class="col-md-4 inputGroupContainer">
													    <div class="input-group">
													        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
													  		<input name="code_postal" pattern="[0-9]{5}" placeholder="Code postal" class="form-control"  type="number" required data-validation-required-message="Entrez votre code postal svp ">
													    </div>
												</div>
											</div>


											<div class="form-group">
  <label class="col-md-4 control-label"> Ville</label>  
    <div class="col-md-4 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input name="ville" placeholder="ville" class="form-control"  type="text" required data-validation-required-message="Please enter ">
    </div>
</div>
</div>

										<div class="form-group">
  <label class="col-md-4 control-label"></label>
  <div class="col-md-4">
  
  <a class="btn btn-xl" type="submit"  name="sendNew"  href="#Resultat3" data-toggle="modal" data-dismiss="modal">Souscrire</a>       
  
    
  </div>
</div>

								
									
								</form>
							</div>
						</div>
					</div>
				</div>

			
	
	<!-- CONNEXION --> <!-- ATTENTION AU JSP ICI FORMULAIRE A MODIFIER-->
		<div class="portfolio-modal modal fade" id="connexion" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="close-modal" data-dismiss="modal">
						<div class="lr">
							<div class="rl">
							</div>
						</div>
					</div>
					<div class="container">
						<div class="row">
							<div class="col-lg-12 text-center">
								<h2 class="section-heading1">Connexion</h2>
								<h3 class="section-subheading1 text-muted"> Veuillez vous connecter pour accéder à toutes les fonctionnalités de notre banque.</h3>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">
								<form name=""  action="Connexion" method="post" id="" novalidate>
									<div class="row">
										<div class="col-md-4"></div>
										<div class="col-md-4">
											<div class="form-group">
												<input type="email" class="form-control" placeholder="Your mail *" name="email" required data-validation-required-message="Please enter your mail.">
												<p class="help-block text-danger"></p>
												
												<div class="password">
                                                  <input type="password" class="form-control" id="passwordfield"  name="password" placeholder=" Your password *">
                                                 <span class="glyphicon glyphicon-eye-open"></span>
                                               
											</div>
											</div>
										</div>
										<div class="col-md-4"></div>
										<div class="clearfix"></div>
										<div class="col-lg-12 text-center">
											<div id="success"></div>
											<button type="submit" class="btn btn-xl">Se connecter</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


<!--  Resultat formulaire souscription-->
		
		<div class="portfolio-modal modal fade" id="Resultat3" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="close-modal" data-dismiss="modal">
						<div class="lr">
							<div class="rl">
							</div>
						</div>
					</div>
					<div class="container">
						<div class="row">
							<div class="col-lg-12 text-center">
								<h2 class="section-heading1">Formulaire de creation de compte </h2>					
				
				<% String Res= (String) request.getAttribute("Res");%>
				
					<p>  <%=Res%></p>
				
									 <br>
									 <br>
				<a href="#connexion" data-toggle="modal" data-dismiss="modal"> Vous connecter</a>
					 <br>
									 <br>
					<a href="#page-top" data-dismiss="modal"> Page d'Acceuil </a>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		
		<!--  Resultat formulaire contact-->
		
		<div class="portfolio-modal modal fade" id="Resultat2" tabindex="-1" role="dialog" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="close-modal" data-dismiss="modal">
						<div class="lr">
							<div class="rl">
							</div>
						</div>
					</div>
					<div class="container">
						<div class="row">
							<div class="col-lg-12 text-center">
								<h2 class="section-heading1">Formulaire de contact </h2>					
								
					<%
						//if (null != message) { %>
						
							<div  class="section-subheading1 text-muted" class="<%=status %>" >
									<%=message %>
									
									</div>
									 
						<% //} %>
					
					
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
		
		
    <!-- jQuery -->
    <script src="vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js" integrity="sha384-mE6eXfrb8jxl0rzJDBRanYqgBxtJ6Unn4/1F7q4xRRyIw7Vdg9jP4ycT7x1iVsgb" crossorigin="anonymous"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="js/agency.min.js"></script>
    
    <!-- Voir le mot de passe -->
     <script src="js/Motdepasse.js"></script>


</body>

</html>
    