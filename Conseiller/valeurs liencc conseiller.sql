--
-- Déchargement des données de la table `conseiller`
--

INSERT INTO `conseiller` (`idConseiller`, `nomConseiller`, `prenomConseiller`, `civiliteConseiller`, `emailConseiller`, `dateNaissanceConseiller`, `motDePasseConseiller`, `telephoneConseiller`) VALUES
(1, 'Samba', 'Yacine', 'Mlle', 'yacine@banques8.fr', '1988-11-08', 'samba', 0975458990),
(2, 'Song', 'Yuzhou', 'Mlle', 'yuzhou@banques8.fr','1980-05-09', 'song', 0275336990) ;



--
-- Déchargement des données de la table `liencc`
--

INSERT INTO `liencc` (`idClient`,`idConseiller`) VALUES
(1, 2),
(2, 1) ;


