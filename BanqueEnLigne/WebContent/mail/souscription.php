<?php

// Cases vides - verification
if(empty($_POST['nom'])      ||
   empty($_POST['surname'])      ||
   empty($_POST['Civilite'])      ||
   empty($_POST['mail'])     ||
   empty($_POST['birthday'])      ||
   empty($_POST['mdp'])      ||
   empty($_POST['nationalite'])      ||
   empty($_POST['type_compte'])      ||
   empty($_POST['phone'])     ||
   empty($_POST['adresse'])      ||
   empty($_POST['code_postal'])      ||
   empty($_POST['ville'])      ||
   empty($_POST['pays'])   ||
   
   !filter_var($_POST['mail'],FILTER_VALIDATE_EMAIL))
   {
   echo "Une adresse email valide n'est pas fournie!";
   return false;
   }
   
   
//Declaration

$nom = strip_tags(htmlspecialchars($_POST['nom']));   
$surname = strip_tags(htmlspecialchars($_POST['surname']));
$Civilite = strip_tags(htmlspecialchars($_POST['Civilite']));
$mail_address = strip_tags(htmlspecialchars($_POST['mail']));
$birthday = strip_tags(htmlspecialchars($_POST['birthday']));
$mdp = strip_tags(htmlspecialchars($_POST['mdp']));
$nationalite = strip_tags(htmlspecialchars($_POST['nationalite']));
$type_compte = strip_tags(htmlspecialchars($_POST['type_compte']));
$phone = strip_tags(htmlspecialchars($_POST['phone']));
$adresse = strip_tags(htmlspecialchars($_POST['adresse']));
$code_postal = strip_tags(htmlspecialchars($_POST['code_postal']));
$ville = strip_tags(htmlspecialchars($_POST['ville']));
$pays = strip_tags(htmlspecialchars($_POST['pays']));
   
   
// Creation de l'email et envoi

$to = $mail_address; // Adresse mail vers lequel le mail va etre envoye
$email_subject = "Confirmation de votre souscription sur le site Banque S8 - 5 ESIGELEC !";
$email_body = "Nous vous confirmons votre souscription sur notre site internet\n\n"." Un compte bancaire vient de vous etre cree ainsi que des identifiants qui vous permettront de naviguer sur notre site\n\n"."Veuillez verifier les informations fournies et utiliser le formulaire contact pour un retour en cas de problemes:\n\nNom: $nom\n\n Prenom: $surname \n\n Civilite: $Civilite \n\n Email: $mail_address\n\n Date de naissance: $birthday \n\n Nationalite: $nationalite \n\n Type de compte: $type_compte \n\n Telephone: $phone\n\n  Adresse:$adresse \n\n Code postal: $code_postal \n\n Ville: $ville \n\n Pays: $pays ";
$headers = "From: r.glazfr@gmail.com \n"; // Adresse mail de l'admin du site
$headers .= "Reply-To: $mail_address";   
mail($to,$email_subject,$email_body,$headers);
return true;         
?>
