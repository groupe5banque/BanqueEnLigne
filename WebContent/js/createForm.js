// Souscription Form Scripts

$(function() {

    $("#souscriptionForm input").ControleSaisie({
        preventSubmit: true,
        submitError: function($form, event, errors) {
            // additional error messages or events
        },
        submitSuccess: function($form, event) {
            event.preventDefault(); // prevent default submit behaviour
            // get values from FORM
            var nom = $("input#nom").val();
            var surname = $("input#surname").val();
            var civilite = $("input#Civilite").val();
            var mail = $("input#mail").val();
            var birthday = $("input#birthday").val();
            var mdp = $("input#mdp").val();
            var nationalite = $("input#nationalite").val();
            var type_compte = $("input#type_compte").val();
            var phone = $("input#phone").val();
            var adresse = $("input#adresse").val();
            var code_postal = $("input#code_postal").val();
            var ville = $("input#ville").val();
            var pays = $("input#pays").val();
            		
   
            var firstName = nom; // For Success/Failure Message
            // Check for white space in name for Success/Fail message
            if (firstName.indexOf(' ') >= 0) {
                firstName = nom.split(' ').slice(0, -1).join(' ');
            }
            $.ajax({
                url: "././mail/souscription.php",
                type: "POST",
                data: {
                    nom: nom,
                    surname: surname,
                    civilite: civilite,
                    mail: mail,
                    birthday: birthday,
                    mdp: mdp,
                    nationalite: nationalite,
                    type_compte: type_compte,
                    phone: phone,
                    adresse: adresse,
                    code_postal: code_postal,
                    ville: ville,
                    pays: pays,
                },
                cache: false,
                success: function() {
                    // Success message
                    $('#success').html("<div class='alert alert-success'>");
                    $('#success > .alert-success').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                        .append("</button>");
                    $('#success > .alert-success')
                        .append("<strong> L'opération s'est faite avec succès. </strong>");
                    $('#success > .alert-success')
                        .append('</div>');

                    //clear all fields
                    $('#souscriptionForm').trigger("reset");
                },
                error: function() {
                    // Fail message
                    $('#success').html("<div class='alert alert-danger'>");
                    $('#success > .alert-danger').html("<button type='button' class='close' data-dismiss='alert' aria-hidden='true'>&times;")
                        .append("</button>");
                    $('#success > .alert-danger').append($("<strong>").text("Nous sommes désolés" + firstName + ", il semble y avoir un problème sur le serveur. Veuillez réessayer plus tard!"));
                    $('#success > .alert-danger').append('</div>');
                    //clear all fields
                    $('#souscriptionForm').trigger("reset");
                },
            });
        },
        filter: function() {
            return $(this).is(":visible");
        },
    });

    $("a[data-toggle=\"tab\"]").click(function(e) {
        e.preventDefault();
        $(this).tab("show");
    });
});


/*When clicking on Full hide fail/success boxes */
$('#nom').focus(function() {
    $('#success').html('');
});
