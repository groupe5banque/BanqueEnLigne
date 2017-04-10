<!DOCTYPE html>

<html lang="fr">
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
                        <a class="page-scroll" href="#services">Informations navigation</a>
					</li>
                    <li>
                        <a class="page-scroll" href="#portfolio">Actualités</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="Client.jsp">Se déconnecter</a> <!-- ETABLIR LE LIEN AVEC LA PAGE DE CONFIRMATION DE DECONNEXION -->
                    </li>
                    <li>
                        <a class="page-scroll"> Bienvenue "Username" </a>
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
                <div class="intro-lead-in">Bank 8-5 of ESIGELEC</div>
                <div class="intro-heading">Bienvenue chère/cher client(e) !</div>
                <a href="#services" class="page-scroll btn btn-xl">Poursuivez vers le bas</a>
            </div>
        </div>
    </header>


	<!-- MENU SIDEBAR -->
	
	<div class="nav-side-menu">
    <div class="brand">Navigation Menu</div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>
  
        <div class="menu-list">
  
            <ul id="menu-content" class="menu-content collapse out">

                <li  data-toggle="collapse" data-target="#products" class="collapsed active">
                  <a href="#"><i class="fa fa-gift fa-lg"></i>Mes informations<span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="products">
                    <li class="active"><a href="#">Voir informations</a></li>
                    <li><a href="#">Modifier informations</a></li>
                </ul>


                <li data-toggle="collapse" data-target="#service" class="collapsed">
                  <a href="#"><i class="fa fa-globe fa-lg"></i> Comptes <span class="arrow"></span></a>
                </li>  
                <ul class="sub-menu collapse" id="service">
                  <li><a href="#">Créer compte titre</a></li>
                  <li><a href="#">Créer compte épargne</a></li>
                  <li><a href="#">Gérer comptes</a></li>
                  <li><a href="Consultation.jsp">Consulter soldes</a></li>
                  <li><a href="ChargerArgent.jsp">Alimenter comptes</a></li>
                </ul>


                <li data-toggle="collapse" data-target="#new" class="collapsed">
                  <a href="#"><i class="fa fa-car fa-lg"></i> Virements <span class="arrow"></span></a>
                </li>
                <ul class="sub-menu collapse" id="new">
                  <li><a href="#">Virement interne</a></li>
                  <li><a href="#">Virement externe</a></li>
                  <li><a href="#">Historique transactions</a></li>
                </ul>
            </ul>
	     </div>
	</div>

    <!-- SERVICES Section -->
    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Informations de navigation</h2>
                    <h3 class="section-subheading1 text-muted">Voici les diverses informations pour la navigation sur notre site web.</h3>
                </div>
            </div>
            <div class="row text-center">
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-align-left fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Menu sidebar</h4>
                    <p class="text-muted">Sur votre gauche se trouve un menu qui vous permet d'effectuer toutes les actions opérationnelles pour un client de notre banque.</u></p>
                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-book fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Formulaire de contact</h4>
                    <p class="text-muted"> Un question à nous poser ? Une suggestion ? Vous avez accès à notre formulaire de contact en bas de page.</p>
                </div>
                <div class="col-md-4">
                    <span class="fa-stack fa-4x">
                        <i class="fa fa-circle fa-stack-2x text-primary"></i>
                        <i class="fa fa-area-chart fa-stack-1x fa-inverse"></i>
                    </span>
                    <h4 class="service-heading">Cours de la bourse</h4>
                    <p class="text-muted">Vous êtes intéressé par la bourse ? Dans le menu sidebar se trouve le lien qui vous guidera vers l'espace réservé les cours de la bourse.</p>
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

    <!-- Contact Section -->
    <section id="contact">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2 class="section-heading">Contactez-nous !</h2>
                    <h3 class="section-subheading text-muted"> Si vous avez des questions ou que vous avez besoin d'informations, n'hésitez pas Ã  nous contacter Ã  l'aide du formulaire suivant.</h3>
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
								<h3 class="section-subheading1 text-muted"> Les champs suivants vous permettront de vous enregistrer et d'accéder Ã  toutes les fonctionnalités de notre banque.</h3>
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
												<input type="email" class="form-control" placeholder="Your Email *" id="email" required data-validation-required-message="Please enter your email address.">
												<p class="help-block text-danger"></p>
											</div>
											<div class="form-group">
												<input type="tel" class="form-control" placeholder="Your Phone *" id="phone" required data-validation-required-message="Please enter your phone number."> <!-- ATTENTION AU JSP ICI FORMULAIRE A MODIFIER -->  
												<p class="help-block text-danger"></p>
											</div>
										</div>
										<div class="col-md-4"></div>
										<div class="clearfix"></div>
										<div class="col-lg-12 text-center">
											<div id="success"></div>
											<button type="submit" class="btn btn-xl">Souscrire</button>
										</div>
									</div>
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
								<h3 class="section-subheading1 text-muted"> Veuillez vous connecter pour accéder Ã  toutes les fonctionnalités de notre banque.</h3>
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

</body>

</html>
