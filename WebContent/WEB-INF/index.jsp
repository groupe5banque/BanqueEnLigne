<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="dao.*" %>
    <%@ page import="dto.*" %>

<% //ClientDAO dao= new ClientDAO();
//Client c1= new Client(); %>
    
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
    <link href="css/agency.min.css" rel="stylesheet">

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
                <a class="navbar-brand page-scroll" href="#page-top">LOGO BANQUE</a>
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
                <div class="intro-lead-in">Bienvenue sur notre nouveau website de banque en ligne!</div>
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
                </div>
            </div>
			<br>
            <div class="row">
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal1" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/bank1.jpg" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>Banque en ligne</h4>
                        <p class="text-muted">BanqueLigne</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/bank2.jpg" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>L'Euro/L'argent</h4>
                        <p class="text-muted">La monnaie</p>
                    </div>
                </div>
                <div class="col-md-4 col-sm-6 portfolio-item">
                    <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/bank3.jpg" class="img-responsive" alt="">
                    </a>
                    <div class="portfolio-caption">
                        <h4>Nouveau système en ligne</h4>
                        <p class="text-muted">Système</p>
                    </div>
                </div>
            </div>
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
                    <form name="sentMessage" id="contactForm" novalidate>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Your Name *" id="name" required data-validation-required-message="Please enter your name.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" placeholder="Your Email *" id="email" required data-validation-required-message="Please enter your email address.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="form-group">
                                    <input type="tel" class="form-control" placeholder="Your Phone *" id="phone" required data-validation-required-message="Please enter your phone number.">
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <textarea class="form-control" placeholder="Your Message *" id="message" required data-validation-required-message="Please enter a message."></textarea>
                                    <p class="help-block text-danger"></p>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                            <div class="col-lg-12 text-center">
                                <div id="success"></div>
                                <button type="submit" class="btn btn-xl">Envoyer</button>
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

    <!-- ACTUALITES -->
    <!-- Use the modals below to showcase details about your portfolio projects! -->

    <!-- ACTUALITE 1 -->
    <div class="portfolio-modal modal fade" id="portfolioModal1" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <div class="col-lg-8 col-lg-offset-2">
                            <div class="modal-body">
                                <!-- Project Details Go Here -->
                                <h2>Banque en ligne</h2>
                                <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                                <img class="img-responsive img-centered" src="img/portfolio/treehouse-preview.png" alt="">
                                <p>Lorem ipsum dolor sit amet consectetur.. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est blanditiis dolorem culpa incidunt minus dignissimos deserunt repellat aperiam quasi sunt officia expedita beatae cupiditate, maiores repudiandae, nostrum, reiciendis facere nemo!</p>
                                <p>
                                    <strong>Lorem ipsum dolor sit amet consectetur.</strong>Lorem ipsum dolor sit amet consectetur.</p>
                                <ul class="list-inline">
                                    <li>Lorem ipsum dolor sit amet consectetur.</li>
                                    <li>Lorem ipsum dolor sit amet consectetur.</li>
                                    <li>Lorem ipsum dolor sit amet consectetur.</li>
                                </ul>
                                <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Fermer news</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- ACTUALITE 2 -->
    <div class="portfolio-modal modal fade" id="portfolioModal2" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <div class="col-lg-8 col-lg-offset-2">
                            <div class="modal-body">
                                <h2>L'Euro/L'argent</h2>
                                <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                                <img class="img-responsive img-centered" src="img/portfolio/treehouse-preview.png" alt="">
                                <p>Lorem ipsum dolor sit amet consectetur. Lorem ipsum dolor sit amet consectetur.Lorem ipsum dolor sit amet consectetur.Lorem ipsum dolor sit amet consectetur.Lorem ipsum dolor sit amet consectetur.</p>
                                <p>Lorem ipsum dolor sit amet consectetur.</p>
                                <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Fermer news</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- ACTUALITE 3 -->
    <div class="portfolio-modal modal fade" id="portfolioModal3" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <div class="col-lg-8 col-lg-offset-2">
                            <div class="modal-body">
                                <!-- Project Details Go Here -->
                                <h2>Nouveau système en ligne</h2>
                                <p class="item-intro text-muted">Lorem ipsum dolor sit amet consectetur.</p>
                                <img class="img-responsive img-centered" src="img/portfolio/treehouse-preview.png" alt="">
                                <p>Lorem ipsum dolor sit amet consectetur. This is bright and spacious design perfect for people or startup companies looking to showcase their apps or other projects.</p>
                                <p>Lorem ipsum dolor sit amet consectetur.Lorem ipsum dolor sit amet consectetur.Lorem ipsum dolor sit amet consectetur.Lorem ipsum dolor sit amet consectetur.</p>
                                <button type="button" class="btn btn-primary" data-dismiss="modal"><i class="fa fa-times"></i> Fermer news</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

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
						<div class="row">
							<div class="col-lg-12">
								<form name="sentMessage" method="post" action="Home" id="contactForm" >
									<div class="row">
										<div class="col-md-4"></div>
										<div class="col-md-4">
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Nom *"  name="name" required data-validation-required-message="Please enter ">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Prénom*"  name="surname" required data-validation-required-message="Please enter">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Civilite*"  name="civilite" required data-validation-required-message="Please enter ">  
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="email" class="form-control" placeholder="Email*" name="mail" required data-validation-required-message="Please enter ">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Date de naissance*" name="birthday" required data-validation-required-message="Please enter ">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="password" class="form-control" placeholder="Mot de passe *" name="mdp" required data-validation-required-message="Please enter "> <!-- ATTENTION AU JSP ICI FORMULAIRE A MODIFIER -->  
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="text" class="form-control" placeholder="nationalite *" name="nationalite" required data-validation-required-message="Please enter ">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Type de compte*" name="type_compte" required data-validation-required-message="Please enter .">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="tel" class="form-control" placeholder="Téléphone*" name="phone" required data-validation-required-message="Please enter "> <!-- ATTENTION AU JSP ICI FORMULAIRE A MODIFIER -->  
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Adresse*" name="adresse" required data-validation-required-message="Please enter ">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Code Postal *" name="code_postal" required data-validation-required-message="Please enter ">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Ville *" name="ville" required data-validation-required-message="Please enter "> <!-- ATTENTION AU JSP ICI FORMULAIRE A MODIFIER -->  
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Pays *" name="pays" required data-validation-required-message="Please enter"> <!-- ATTENTION AU JSP ICI FORMULAIRE A MODIFIER -->  
												<p class="help-block text-danger"></p>
											</div>
										</div>
										<div class="col-md-4"></div>
										<div class="clearfix"></div>
										<div class="col-lg-12 text-center">
											<div id="success"></div>
											<button type="submit" class="btn btn-xl" value="ok">Souscrire</button>
										</div>
									</div>
																				<button type="submit" class="btn btn-xl" value="ok">Souscrire</button>
									
								</form>
							</div>
						</div>
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
								<form name="sentMessage" id="contactForm" novalidate>
									<div class="row">
										<div class="col-md-4"></div>
										<div class="col-md-4">
											<div class="form-group">
												<input type="text" class="form-control" placeholder="Your Name *" id="name" required data-validation-required-message="Please enter your name.">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="password" class="form-control" placeholder="Your Password *" id="password" required data-validation-required-message="Please enter your email address."> <!-- ATTENTION AU JSP ICI FORMULAIRE A MODIFIER -->  
												<p class="help-block text-danger"></p>
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
    		
<% String name = (String) request.getParameter("name");
System.out.println(name);%>

</body>

</html>
    