<html>	 
	 <head>
       <title>Bienvenue sur mon site</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <style type="text/css">
        h1, h3
        {
            text-align:center;
        }
        h3
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
    
    <body>
		<h1>Bienvenue sur mon site !</h1>
		<p>Voici les derni�res news :</p>
		 
		<?php
		// On r�cup�re les cinq derni�res news.
		$req = "SELECT * FROM news ORDER BY id DESC LIMIT 0, 5";
		$retour = mysqli_query($conn, $req);
		while ($donnees = mysqli_fetch_array($retour))
		{
		?>
		<div class="news" align="center">
			<h3>
				<?php echo $donnees['titre']; ?>
				<em>le <?php echo ($donnees['timestamp']); ?></em>
			</h3>
			<div align="center">
				<?php
					$sql = "SELECT * FROM news WHERE idimg=" .$donnees['idimg'];
					$res = mysqli_query($conn, $sql);
					while($image = mysqli_fetch_assoc($res)){
						echo "<img src=\"".$donnees['idimg'].".jpg\""." alt=\"PASTROUVE\" />";
					}
				?>
			</div>		
			<p>
			<?php
			// On enl�ve les �ventuels antislashs, PUIS on cr�e les entr�es en HTML (<br />).
			$contenu = nl2br(stripslashes($donnees['contenu']));
			echo $contenu;
			?>
			</p>
		</div>
		<?php
		} // Fin de la boucle des <italique>news</italique>.
		?>
</body>
</html>
