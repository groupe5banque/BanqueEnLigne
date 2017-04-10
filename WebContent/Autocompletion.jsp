<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.5.1.min.js"></script>
<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery.ui/1.8.10/jquery-ui.js"></script>
<script type="text/javascript">
			var cache = {};
			$(function ()
			{
				$("#cp, #ville").autocomplete({
					source: function (request, response)
					{
						//Si la réponse est dans le cache
						if (('FR' + '-' + request.term) in cache)
						{
							response($.map(cache['FR' + '-' + request.term], function (item)
							{

								return {
									label: item.CodePostal + ", " + item.Ville,
									value: function ()
									{
										if ($(this).attr('id') == 'cp')
										{
											$('#ville').val(item.Ville);
											return item.CodePostal;
										}
										else
										{
											$('#cp').val(item.CodePostal);
											return item.Ville;
										}
									}
								}
							}));
						}
						//Sinon -> Requete Ajax
						else
						{
							var objData = {};
							if ($(this.element).attr('id') == 'cp')
							{
								objData = { codePostal: request.term, pays: 'FR', maxRows: 10 };
							}
							else
							{
								objData = { ville: request.term, pays: 'FR', maxRows: 10 };
							}
							$.ajax({
								url: "./AutoCompletion.php",
								dataType: "json",
								data: objData,
								type: 'POST',
								success: function (data)
								{
									//Ajout de reponse dans le cache
									cache[('FR' + '-' + request.term)] = data;
									response($.map(data, function (item)
									{

										return {
											label: item.CodePostal + ", " + item.Ville,
											value: function ()
											{
												if ($(this).attr('id') == 'cp')
												{
													$('#ville').val(item.Ville);
													return item.CodePostal;
												}
												else
												{
													$('#cp').val(item.CodePostal);
													return item.Ville;
												}
											}
										}
									}));
								}
							});
						}
					},
					minLength: 3,
					delay: 600
				});
			});
		</script>
<link rel="Stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css" />

<title>Insert title here</title>
</head>
<body>
<form action="#">
			CP :<input type="text" id="cp" size="6"/>
			Ville : <input type="text" id="ville" />
		</form>
</body>
</html>

