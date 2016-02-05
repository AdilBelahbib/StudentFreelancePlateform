-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 05, 2016 at 09:35 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `trast`
--

-- --------------------------------------------------------

--
-- Table structure for table `adresse`
--

CREATE TABLE IF NOT EXISTS `adresse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `corps` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `ville` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `pays` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `idUtilisateur` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUtilisateur` (`idUtilisateur`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=23 ;

--
-- Dumping data for table `adresse`
--

INSERT INTO `adresse` (`id`, `corps`, `ville`, `pays`, `idUtilisateur`) VALUES
(1, 'Rue Al-khatawat, Imm. 8, Appar. 5, Agdal', 'Rabat', 'Maroc', 4),
(2, 'Avenue Al-mokawama, Imm 11A, Appart. 12', 'Mohammedia', 'Maroc', 1),
(22, 'Rue baraka, N° 8, Mediouna', 'Casablanca', 'Rabat', 3);

-- --------------------------------------------------------

--
-- Table structure for table `appel_offre`
--

CREATE TABLE IF NOT EXISTS `appel_offre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebut` datetime NOT NULL,
  `dateExpiration` datetime NOT NULL,
  `entretien` bit(1) NOT NULL DEFAULT b'0',
  `statut` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `idEntreprise` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idEntreprise` (`idEntreprise`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=18 ;

--
-- Dumping data for table `appel_offre`
--

INSERT INTO `appel_offre` (`id`, `dateDebut`, `dateExpiration`, `entretien`, `statut`, `idEntreprise`) VALUES
(1, '2016-02-01 00:00:00', '2016-02-29 00:00:00', b'1', 'ENCOURS', 4),
(2, '2016-01-01 00:00:00', '2016-02-24 00:00:00', b'0', 'ARCHIVE', 4),
(3, '2015-12-02 00:00:00', '2016-01-28 00:00:00', b'1', 'ARCHIVE', 4);

-- --------------------------------------------------------

--
-- Table structure for table `appel_offre_competence`
--

CREATE TABLE IF NOT EXISTS `appel_offre_competence` (
  `idCompetence` int(11) NOT NULL,
  `idAppelOffre` int(11) NOT NULL,
  PRIMARY KEY (`idCompetence`,`idAppelOffre`),
  KEY `idAppelOffre` (`idAppelOffre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `appel_offre_competence`
--

INSERT INTO `appel_offre_competence` (`idCompetence`, `idAppelOffre`) VALUES
(1, 1),
(3, 1),
(4, 1),
(7, 1),
(1, 2),
(5, 2),
(7, 2),
(3, 3),
(5, 3),
(7, 3);

-- --------------------------------------------------------

--
-- Table structure for table `badge`
--

CREATE TABLE IF NOT EXISTS `badge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(64) COLLATE utf8_bin NOT NULL,
  `idFichier` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idFichier` (`idFichier`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=13 ;

--
-- Dumping data for table `badge`
--

INSERT INTO `badge` (`id`, `intitule`, `idFichier`) VALUES
(7, 'Badge de Java', 5),
(8, 'Badge d''anglais', 4),
(9, '15 Tests réussis', 8),
(10, '10 scores parfaits', 6),
(11, '5 projets réalisés', 7),
(12, 'Avoir 20 avis positifs', 52);

-- --------------------------------------------------------

--
-- Table structure for table `cahier_des_charges`
--

CREATE TABLE IF NOT EXISTS `cahier_des_charges` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sujet` text COLLATE utf8_unicode_ci NOT NULL,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `idAppelOffre` int(11) DEFAULT NULL,
  `idProjet` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idAppelOffre` (`idAppelOffre`),
  KEY `idProjet` (`idProjet`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=17 ;

--
-- Dumping data for table `cahier_des_charges`
--

INSERT INTO `cahier_des_charges` (`id`, `sujet`, `dateDebut`, `dateFin`, `idAppelOffre`, `idProjet`) VALUES
(1, 'Lorem ipsum dolor sit amet, vel augue explicari corrumpit et. Legendos aliquando mea te, per ea saepe possit feugiat. Ne accusamus reformidans ius, ipsum erant invenire eu nam, no viris civibus mei. Cum in quando oportere. Te deleniti copiosae cum. Mei ea alii sumo evertitur, quo clita saperet atomorum ei. Habeo ubique usu no.\r\n\r\nVeritus intellegat eu sea, ullum possit eum et, duo odio adhuc ad. Decore nominati consequat duo ad, offendit reformidans qui ut. Mundi dicant sententiae eu mei. Duo facete vocibus et. Usu eu simul dolorem docendi. Cu vide munere his, eos ei mentitum dignissim.\r\n\r\nDelectus fabellas elaboraret mea eu. Sea integre tibique moderatius et, vim at hinc veniam. Solum graeci postulant an sed, id prodesset dissentias mel, mei assum virtute persecuti ad. Animal aperiri interpretaris te eos, has ea idque cetero tibique, id oporteat philosophia nec.', '2016-01-20', '2016-03-31', 1, NULL),
(2, 'Ubique legere fierent mei ea, usu agam tantas antiopam ad, per ad iusto mollis. Sit at melius animal eruditi, ut graeci admodum vim. Ignota evertitur vix ad. Est ut ignota accusam singulis.\r\n\r\nAdhuc iusto ornatus mei ut. Eu harum patrioque vix. Ei pri dolorem delectus, an vix cibo omnes voluptatibus, integre euripidis has te. Accusata inciderint referrentur has ea, ea esse alienum electram vis. Eu qui simul cotidieque eloquentiam, qui stet wisi in, vis sumo hinc facilis ad. At enim liber tamquam eum.\r\n\r\nAt quem diam soleat sit, in qui decore omittantur, an amet magna mei. Ex eos nostrum forensibus persequeris. Cu vel cetero deleniti euripidis, ei ipsum oporteat vix. Ex postulant expetenda prodesset vim, alii atomorum an eos.', '2016-01-26', '2016-03-30', 2, NULL),
(3, 'Eos et suas reque mentitum, modo omnesque invidunt qui eu, qui ad praesent accusamus intellegebat. Mel te eruditi omittam posidonium. At nam sale utinam, ut consequat elaboraret sea. Legere dolorem delectus mel ei. Eam ex populo fierent molestiae.\r\n\r\nEum quodsi viderer recusabo ad, quando scriptorem consequuntur eu vix, utamur tincidunt interesset nam ea. Eu mel suscipit petentium dissentias. Corrumpit repudiandae vel eu, eu nec mutat ludus animal, vix inimicus intellegat suscipiantur eu. Quo modus scripta in, cu sea labitur pertinax antiopam. Mea no decore aperiri labitur, ei legendos electram corrumpit est.\r\n\r\nNe pro aperiri epicuri voluptua, in mucius periculis scribentur sea. Eius apeirian vituperata cum id, et dicam convenire vix. Eam aliquando dissentiunt reprehendunt et. Ius te virtute ancillae contentiones. Et sea mundi altera disputationi, et cum sonet aeterno quaerendum. Vim ei tota possim, te per quando nominati iracundia. Quo no vocent euripidis definitionem, cum deserunt lobortis contentiones ne, inani solet pri in.', '2015-12-26', '2016-03-26', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `competence`
--

CREATE TABLE IF NOT EXISTS `competence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `intitule` (`intitule`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10 ;

--
-- Dumping data for table `competence`
--

INSERT INTO `competence` (`id`, `intitule`) VALUES
(3, 'Anglais'),
(9, 'C'),
(7, 'C#'),
(2, 'C++'),
(8, 'F#'),
(4, 'Français'),
(1, 'Java'),
(6, 'Java EE'),
(5, 'Marketing');

-- --------------------------------------------------------

--
-- Table structure for table `contre_proposition`
--

CREATE TABLE IF NOT EXISTS `contre_proposition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enchere` double NOT NULL,
  `idEtudiant` int(11) DEFAULT NULL,
  `idAppelOffre` int(11) NOT NULL,
  `idFichier` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idEtudiant` (`idEtudiant`),
  KEY `idAppelOffre` (`idAppelOffre`),
  KEY `idFichier` (`idFichier`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `contre_proposition`
--

INSERT INTO `contre_proposition` (`id`, `enchere`, `idEtudiant`, `idAppelOffre`, `idFichier`) VALUES
(2, 2300, 3, 1, NULL),
(3, 1400, 3, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `entreprise`
--

CREATE TABLE IF NOT EXISTS `entreprise` (
  `id` int(11) NOT NULL,
  `sigle` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `apercu` varchar(2048) COLLATE utf8_unicode_ci NOT NULL,
  `etatCompte` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `entreprise`
--

INSERT INTO `entreprise` (`id`, `sigle`, `apercu`, `etatCompte`) VALUES
(4, 'Ribatis corporation', 'Entreprise spécialisée dans le développement informatique et l''installation des ERPs', 'ACTIVE'),
(27, 'Opus Network', 'La conception et l''impression des éléments graphiques: Infographie, Web design, etc.', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `entretien`
--

CREATE TABLE IF NOT EXISTS `entretien` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateEntretien` datetime NOT NULL,
  `termine` bit(1) NOT NULL DEFAULT b'0',
  `idContreProposition` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idContreProposition` (`idContreProposition`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Dumping data for table `entretien`
--

INSERT INTO `entretien` (`id`, `dateEntretien`, `termine`, `idContreProposition`) VALUES
(2, '2016-02-05 20:30:00', b'0', 2);

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` int(11) NOT NULL,
  `nombreBids` int(11) NOT NULL,
  `avisPositifs` int(11) NOT NULL DEFAULT '0',
  `avisNegatifs` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`id`, `nombreBids`, `avisPositifs`, `avisNegatifs`) VALUES
(3, 3, 8, 2);

-- --------------------------------------------------------

--
-- Table structure for table `etudiant_badge`
--

CREATE TABLE IF NOT EXISTS `etudiant_badge` (
  `idEtudiant` int(11) NOT NULL,
  `idBadge` int(11) NOT NULL,
  PRIMARY KEY (`idEtudiant`,`idBadge`),
  KEY `idBadge` (`idBadge`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `etudiant_badge`
--

INSERT INTO `etudiant_badge` (`idEtudiant`, `idBadge`) VALUES
(3, 7),
(3, 8);

-- --------------------------------------------------------

--
-- Table structure for table `etudiant_competence`
--

CREATE TABLE IF NOT EXISTS `etudiant_competence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idEtudiant` int(11) NOT NULL,
  `idCompetence` int(11) NOT NULL,
  `maitrise` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idEtudiant` (`idEtudiant`,`idCompetence`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=14 ;

--
-- Dumping data for table `etudiant_competence`
--

INSERT INTO `etudiant_competence` (`id`, `idEtudiant`, `idCompetence`, `maitrise`) VALUES
(7, 3, 2, 16),
(8, 3, 4, 11),
(11, 3, 3, 3),
(12, 3, 1, 1),
(13, 3, 6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `evenement_badge`
--

CREATE TABLE IF NOT EXISTS `evenement_badge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sourceEvenement` varchar(64) COLLATE utf8_bin NOT NULL,
  `valeur` double NOT NULL,
  `idBadge` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idBadge` (`idBadge`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=13 ;

--
-- Dumping data for table `evenement_badge`
--

INSERT INTO `evenement_badge` (`id`, `sourceEvenement`, `valeur`, `idBadge`) VALUES
(9, 'PROJET', 5, 11),
(10, 'SCOREPARFAIT', 10, 10),
(11, 'TEST', 15, 9),
(12, 'AVISPOSITIF', 20, 12);

-- --------------------------------------------------------

--
-- Table structure for table `experience`
--

CREATE TABLE IF NOT EXISTS `experience` (
  `id` int(11) NOT NULL,
  `responsabilite` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `typeExperience` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `structureAccueil` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `sujet` text COLLATE utf8_unicode_ci NOT NULL,
  `salaire` double DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `experience`
--

INSERT INTO `experience` (`id`, `responsabilite`, `typeExperience`, `structureAccueil`, `sujet`, `salaire`) VALUES
(3, 'Concepteur / Développeur', 'Stage cadre', 'FST Mohammedia', 'La conception et le développement d''une application web de l''e-Orientation', 0);

-- --------------------------------------------------------

--
-- Table structure for table `fichier`
--

CREATE TABLE IF NOT EXISTS `fichier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `chemin` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `idUtilisateur` int(11) DEFAULT NULL,
  `idCahierDesCharges` int(11) DEFAULT NULL,
  `idQualification` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUtilisateur` (`idUtilisateur`),
  KEY `idCahierDesCharges` (`idCahierDesCharges`),
  KEY `idQualification` (`idQualification`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=53 ;

--
-- Dumping data for table `fichier`
--

INSERT INTO `fichier` (`id`, `titre`, `chemin`, `idUtilisateur`, `idCahierDesCharges`, `idQualification`) VALUES
(1, 'avatar.jpg', '/admin/1', NULL, NULL, NULL),
(2, 'avatar.jpg', '/etudiant/3', NULL, NULL, NULL),
(3, 'avatar.jpg', '/entreprise/4', NULL, NULL, NULL),
(4, 'anglaisbadge.png', '/badges', NULL, NULL, NULL),
(5, 'javabadge.jpg', '/badges', NULL, NULL, NULL),
(6, 'parfaitbadge.png', '/badges', NULL, NULL, NULL),
(7, 'projetbadge.png', '/badges', NULL, NULL, NULL),
(8, 'testbadge.jpg', '/badges', NULL, NULL, NULL),
(52, 'Avoir 20 avis positifs1.png', '/badges', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `formation`
--

CREATE TABLE IF NOT EXISTS `formation` (
  `id` int(11) NOT NULL,
  `intituleFormation` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `etablissement` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `intituleFormationId` (`intituleFormation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `formation`
--

INSERT INTO `formation` (`id`, `intituleFormation`, `etablissement`) VALUES
(1, 'DEUG', 'Faculté des Sciences - Ben M''Sik'),
(2, 'Cycle d''Ingénieur d''état', 'Faculté des Sciences et Techniques - Mohammedia'),
(74, 'Formation dans les technologies .NET', 'Centre de Formation de l''entreprise');

-- --------------------------------------------------------

--
-- Table structure for table `livrable`
--

CREATE TABLE IF NOT EXISTS `livrable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateLivraison` datetime NOT NULL,
  `pourcentageAvancement` double NOT NULL,
  `valide` bit(1) NOT NULL,
  `remarqueEntreprise` text COLLATE utf8_bin NOT NULL,
  `idProjet` int(11) NOT NULL,
  `idFichier` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idProjet` (`idProjet`),
  KEY `idFichier` (`idFichier`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

--
-- Dumping data for table `livrable`
--

INSERT INTO `livrable` (`id`, `dateLivraison`, `pourcentageAvancement`, `valide`, `remarqueEntreprise`, `idProjet`, `idFichier`) VALUES
(1, '2016-02-02 00:00:00', 15, b'1', '', 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `note`
--

CREATE TABLE IF NOT EXISTS `note` (
  `note` text COLLATE utf8_bin NOT NULL,
  `idEntretien` int(11) NOT NULL,
  KEY `idEntretien` (`idEntretien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `particulier`
--

CREATE TABLE IF NOT EXISTS `particulier` (
  `id` int(11) NOT NULL,
  `nom` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `dateNaissance` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `particulier`
--

INSERT INTO `particulier` (`id`, `nom`, `prenom`, `dateNaissance`) VALUES
(1, 'Alami', 'Ahmed', '1978-12-15'),
(3, 'Silami', 'Rochdi', '1994-12-10');

-- --------------------------------------------------------

--
-- Table structure for table `projet`
--

CREATE TABLE IF NOT EXISTS `projet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cout` double NOT NULL,
  `devise` varchar(16) COLLATE utf8_unicode_ci NOT NULL,
  `statut` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `idCahierDesCharges` int(11) NOT NULL,
  `idEtudiant` int(11) NOT NULL,
  `idEntreprise` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCahierDesCharges` (`idCahierDesCharges`),
  KEY `idEtudiant` (`idEtudiant`),
  KEY `idEntreprise` (`idEntreprise`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `projet`
--

INSERT INTO `projet` (`id`, `cout`, `devise`, `statut`, `idCahierDesCharges`, `idEtudiant`, `idEntreprise`) VALUES
(1, 1500, 'MAD', 'ENCOURS', 3, 3, 4);

-- --------------------------------------------------------

--
-- Table structure for table `qualification`
--

CREATE TABLE IF NOT EXISTS `qualification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebut` date NOT NULL,
  `dateFin` date NOT NULL,
  `idEtudiant` int(11) DEFAULT NULL,
  `idAppelOffre` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idEtudiant` (`idEtudiant`),
  KEY `idAppelOffre` (`idAppelOffre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=75 ;

--
-- Dumping data for table `qualification`
--

INSERT INTO `qualification` (`id`, `dateDebut`, `dateFin`, `idEtudiant`, `idAppelOffre`) VALUES
(1, '2011-09-15', '2013-06-15', 3, NULL),
(2, '2013-09-15', '2016-06-15', 3, NULL),
(3, '2015-04-15', '2015-06-12', 3, NULL),
(74, '2016-02-16', '2016-02-23', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE IF NOT EXISTS `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(128) NOT NULL,
  `coefficient` double NOT NULL,
  `idTest` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idTest` (`idTest`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `question`, `coefficient`, `idTest`) VALUES
(22, 'Lorem ipsum dolor sit amet, tortor elementum. Praesent libero, sem velit. Vitae mauris, vestibulum urna nullam, a etiam etiam ?', 1, 1),
(23, 'Tortor sit. Leo vestibulum aenean, phasellus ut. Dignissim imperdiet, augue id, orci vestibulum ?', 1, 1),
(24, 'Tincidunt aptent laoreet. Hymenaeos ut, praesent tincidunt, dui elit lorem. Elit velit amet, mi purus tincidun.', 1, 1),
(25, 'Pinteger turpis eleifend. Nonummy bibendum vitae. Eleifend diam maecenas. A luctus, ultricies sed, nullam in nullam ?', 1, 1),
(26, 'Scelerisque nulla, commodi at. Ac justo lacus, neque sed nullam ?', 1, 2),
(27, 'Vitae vestibulum a. Nec metus mauris, vivamus nibh, mauris per hendrerit. Purus nec, nam magna justo, vivamus cras neque.', 1, 2),
(28, 'Leo donec dictum, pretium quam, eleifend erat. Volutpat aenean, vestibulum iaculis, orci ut dui.', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `remuneration`
--

CREATE TABLE IF NOT EXISTS `remuneration` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `somme` double NOT NULL,
  `intitule` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `devise` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idAppelOffre` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idAppelOffre` (`idAppelOffre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `remuneration`
--

INSERT INTO `remuneration` (`id`, `somme`, `intitule`, `devise`, `idAppelOffre`) VALUES
(1, 1500, 'Prix de la réalisation du projet', 'MAD', 1),
(2, 500, 'Bonus au cas où les délais/fonctionnalités sont respectés', 'MAD', 1),
(3, 2300, 'Prix de la réalisation du projet', 'MAD', 2),
(4, 3000, 'Prix de la réalisation du projet', 'MAD', 3);

-- --------------------------------------------------------

--
-- Table structure for table `reponse_fausse`
--

CREATE TABLE IF NOT EXISTS `reponse_fausse` (
  `reponse` varchar(128) NOT NULL,
  `idQuestion` int(11) NOT NULL,
  PRIMARY KEY (`reponse`,`idQuestion`),
  KEY `idQuestion` (`idQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reponse_fausse`
--

INSERT INTO `reponse_fausse` (`reponse`, `idQuestion`) VALUES
('Elit etiam ultrices, vel lectus ligula, sodales in.', 22),
('Lorem ipsum dolor sit amet, et wisi et.', 22),
('Pharetra minima, nec eget.', 23),
('Blandit ligula.', 24),
('Quis aenean nunc, hac odio vulputate.', 24),
('Cras convallis.', 25),
('Ipsum ac facilisi, tristique eu, ante proin.', 25),
('Massa vestibulum, facilisi nonummy nibh.', 25),
('Pede et proin.', 26),
('Pharetra libero nunc, nisl sodales, vitae animi.', 26),
('Vel lorem, proin auctor, vestibulum mauris tempus.', 27),
('Convallis eget pretium, amet elit id, vel convallis.', 28),
('Leo duis mattis, quam maecenas donec, donec suspendisse in.', 28);

-- --------------------------------------------------------

--
-- Table structure for table `reponse_juste`
--

CREATE TABLE IF NOT EXISTS `reponse_juste` (
  `reponse` varchar(128) NOT NULL,
  `idQuestion` int(11) NOT NULL,
  PRIMARY KEY (`reponse`,`idQuestion`),
  KEY `idQuestion` (`idQuestion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reponse_juste`
--

INSERT INTO `reponse_juste` (`reponse`, `idQuestion`) VALUES
('Lacus congue, similique mi nunc (V)', 22),
('Massa sollicitudin. (V)', 23),
('Tortor class. (V)', 23),
('Ante massa et. (V)', 24),
('Phasellus aliquam a. (V)', 25),
('Ut donec. (V)', 26),
('Neque libero, metus enim, donec condimentum eget. (V)', 27),
('Ut ut malesuada, sapien risus aperiam, in quam integer. (V)', 27),
('Illum vel fringilla. (V)', 28);

-- --------------------------------------------------------

--
-- Table structure for table `resultat_test`
--

CREATE TABLE IF NOT EXISTS `resultat_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `score` double NOT NULL,
  `nombrePassage` int(11) NOT NULL,
  `dateDernierPassage` datetime NOT NULL,
  `idEtudiant` int(11) NOT NULL,
  `idTest` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idEtudiant` (`idEtudiant`),
  KEY `idTest` (`idTest`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `resultat_test`
--

INSERT INTO `resultat_test` (`id`, `score`, `nombrePassage`, `dateDernierPassage`, `idEtudiant`, `idTest`) VALUES
(19, 100, 2, '2016-02-05 18:01:42', 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `role_utilisateur`
--

CREATE TABLE IF NOT EXISTS `role_utilisateur` (
  `id` int(11) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role_utilisateur`
--

INSERT INTO `role_utilisateur` (`id`, `role`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_ETUDIANT'),
(3, 'ROLE_ENTREPRISE');

-- --------------------------------------------------------

--
-- Table structure for table `secteur_activite`
--

CREATE TABLE IF NOT EXISTS `secteur_activite` (
  `secteur` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `idEntreprise` int(11) NOT NULL,
  PRIMARY KEY (`secteur`,`idEntreprise`),
  KEY `idEntreprise` (`idEntreprise`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `secteur_activite`
--

INSERT INTO `secteur_activite` (`secteur`, `idEntreprise`) VALUES
('Développement informatique', 4),
('Installation ERP', 4),
('Infographie', 27);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(128) NOT NULL,
  `duree` double NOT NULL,
  `nombrePassage` int(11) NOT NULL,
  `idEntreprise` int(11) DEFAULT NULL,
  `idBadge` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idEntreprise` (`idEntreprise`),
  KEY `idBadge` (`idBadge`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `titre`, `duree`, `nombrePassage`, `idEntreprise`, `idBadge`) VALUES
(1, 'Test Java', 10, 2, 4, 7),
(2, 'Test Anglais', 15, 0, NULL, 8);

-- --------------------------------------------------------

--
-- Table structure for table `test_competence`
--

CREATE TABLE IF NOT EXISTS `test_competence` (
  `idTest` int(11) NOT NULL,
  `idCompetence` int(11) NOT NULL,
  PRIMARY KEY (`idTest`,`idCompetence`),
  KEY `idCompetence` (`idCompetence`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test_competence`
--

INSERT INTO `test_competence` (`idTest`, `idCompetence`) VALUES
(1, 1),
(2, 3),
(2, 4),
(2, 5),
(1, 6);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `motDePasse` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `typeUtilisateur` varchar(4) COLLATE utf8_unicode_ci NOT NULL,
  `idRole` int(11) DEFAULT NULL,
  `avatar` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `fk_role` (`idRole`),
  KEY `avatar` (`avatar`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=28 ;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `motDePasse`, `typeUtilisateur`, `idRole`, `avatar`) VALUES
(1, 'admin@mail.com', '00d70c561892a94980befd12a400e26aeb4b8599', 'ADM', 1, 1),
(3, 'etudiant@mail.com', '00d70c561892a94980befd12a400e26aeb4b8599', 'ETU', 2, 2),
(4, 'entreprise@mail.com', '00d70c561892a94980befd12a400e26aeb4b8599', 'ENT', 3, 3),
(27, 'entreprise2@mail.com', '00d70c561892a94980befd12a400e26aeb4b8599', 'ENT', 3, NULL);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `adresse`
--
ALTER TABLE `adresse`
  ADD CONSTRAINT `adresse_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `appel_offre`
--
ALTER TABLE `appel_offre`
  ADD CONSTRAINT `appel_offre_ibfk_1` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `appel_offre_competence`
--
ALTER TABLE `appel_offre_competence`
  ADD CONSTRAINT `appel_offre_competence_ibfk_1` FOREIGN KEY (`idCompetence`) REFERENCES `competence` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `appel_offre_competence_ibfk_2` FOREIGN KEY (`idAppelOffre`) REFERENCES `appel_offre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `badge`
--
ALTER TABLE `badge`
  ADD CONSTRAINT `badge_ibfk_1` FOREIGN KEY (`idFichier`) REFERENCES `fichier` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `cahier_des_charges`
--
ALTER TABLE `cahier_des_charges`
  ADD CONSTRAINT `cahier_des_charges_ibfk_1` FOREIGN KEY (`idAppelOffre`) REFERENCES `appel_offre` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `cahier_des_charges_ibfk_2` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `contre_proposition`
--
ALTER TABLE `contre_proposition`
  ADD CONSTRAINT `contre_proposition_ibfk_1` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contre_proposition_ibfk_2` FOREIGN KEY (`idAppelOffre`) REFERENCES `appel_offre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `contre_proposition_ibfk_3` FOREIGN KEY (`idFichier`) REFERENCES `fichier` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `entreprise`
--
ALTER TABLE `entreprise`
  ADD CONSTRAINT `entreprise_ibfk_1` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `entretien`
--
ALTER TABLE `entretien`
  ADD CONSTRAINT `entretien_ibfk_1` FOREIGN KEY (`idContreProposition`) REFERENCES `contre_proposition` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`id`) REFERENCES `particulier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `etudiant_badge`
--
ALTER TABLE `etudiant_badge`
  ADD CONSTRAINT `etudiant_badge_ibfk_1` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `etudiant_badge_ibfk_2` FOREIGN KEY (`idBadge`) REFERENCES `badge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `evenement_badge`
--
ALTER TABLE `evenement_badge`
  ADD CONSTRAINT `evenement_badge_ibfk_1` FOREIGN KEY (`idBadge`) REFERENCES `badge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `experience`
--
ALTER TABLE `experience`
  ADD CONSTRAINT `experience_ibfk_1` FOREIGN KEY (`id`) REFERENCES `qualification` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `fichier`
--
ALTER TABLE `fichier`
  ADD CONSTRAINT `fichier_ibfk_1` FOREIGN KEY (`idUtilisateur`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fichier_ibfk_2` FOREIGN KEY (`idCahierDesCharges`) REFERENCES `cahier_des_charges` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fichier_ibfk_3` FOREIGN KEY (`idQualification`) REFERENCES `qualification` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `formation_ibfk_1` FOREIGN KEY (`id`) REFERENCES `qualification` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `livrable`
--
ALTER TABLE `livrable`
  ADD CONSTRAINT `livrable_ibfk_1` FOREIGN KEY (`idProjet`) REFERENCES `projet` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `livrable_ibfk_2` FOREIGN KEY (`idFichier`) REFERENCES `fichier` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `note_ibfk_1` FOREIGN KEY (`idEntretien`) REFERENCES `entretien` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `particulier`
--
ALTER TABLE `particulier`
  ADD CONSTRAINT `particulier_ibfk_1` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `projet_ibfk_1` FOREIGN KEY (`idCahierDesCharges`) REFERENCES `cahier_des_charges` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `projet_ibfk_2` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `projet_ibfk_3` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `qualification`
--
ALTER TABLE `qualification`
  ADD CONSTRAINT `qualification_ibfk_1` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `qualification_ibfk_2` FOREIGN KEY (`idAppelOffre`) REFERENCES `appel_offre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `question`
--
ALTER TABLE `question`
  ADD CONSTRAINT `question_ibfk_1` FOREIGN KEY (`idTest`) REFERENCES `test` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `remuneration`
--
ALTER TABLE `remuneration`
  ADD CONSTRAINT `remuneration_ibfk_1` FOREIGN KEY (`idAppelOffre`) REFERENCES `appel_offre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reponse_fausse`
--
ALTER TABLE `reponse_fausse`
  ADD CONSTRAINT `reponse_fausse_ibfk_1` FOREIGN KEY (`idQuestion`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reponse_juste`
--
ALTER TABLE `reponse_juste`
  ADD CONSTRAINT `reponse_juste_ibfk_1` FOREIGN KEY (`idQuestion`) REFERENCES `question` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `resultat_test`
--
ALTER TABLE `resultat_test`
  ADD CONSTRAINT `resultat_test_ibfk_1` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `resultat_test_ibfk_2` FOREIGN KEY (`idTest`) REFERENCES `test` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `secteur_activite`
--
ALTER TABLE `secteur_activite`
  ADD CONSTRAINT `secteur_activite_ibfk_1` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `test`
--
ALTER TABLE `test`
  ADD CONSTRAINT `test_ibfk_1` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `test_ibfk_2` FOREIGN KEY (`idBadge`) REFERENCES `badge` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `test_competence`
--
ALTER TABLE `test_competence`
  ADD CONSTRAINT `test_competence_ibfk_1` FOREIGN KEY (`idTest`) REFERENCES `test` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `test_competence_ibfk_2` FOREIGN KEY (`idCompetence`) REFERENCES `competence` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `fk_role` FOREIGN KEY (`idRole`) REFERENCES `role_utilisateur` (`id`) ON DELETE SET NULL ON UPDATE SET NULL,
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`avatar`) REFERENCES `fichier` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
