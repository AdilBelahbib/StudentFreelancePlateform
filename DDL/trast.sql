-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 05, 2016 at 01:09 PM
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
(22, 'Mon Adresse N 3', 'Ville 3', 'Pays 3', 3);

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
(1, '2015-12-01 00:00:00', '2015-12-25 00:00:00', b'1', 'ENCOURS', 4),
(17, '2016-01-24 21:33:01', '2016-01-24 00:33:00', b'0', 'ENCOURS', 4);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=7 ;

--
-- Dumping data for table `badge`
--

INSERT INTO `badge` (`id`, `intitule`, `idFichier`) VALUES
(6, 'Badge 1 parfait', 41);

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
(1, 'Sujet cahier des charge 1', '2015-12-02', '2015-12-16', 1, NULL),
(2, 'Sujet cahier des charge 2', '2015-12-04', '2015-12-23', NULL, NULL),
(3, 'Sujet cahier des charge 3', '2015-05-12', '2016-05-11', NULL, NULL),
(4, 'Sujet cahier des charge 4', '2015-04-02', '2015-08-10', NULL, NULL),
(16, 'test', '2016-01-24', '2016-01-24', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `competence`
--

CREATE TABLE IF NOT EXISTS `competence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `intitule` (`intitule`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `competence`
--

INSERT INTO `competence` (`id`, `intitule`) VALUES
(3, 'Anglais'),
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=2 ;

--
-- Dumping data for table `contre_proposition`
--

INSERT INTO `contre_proposition` (`id`, `enchere`, `idEtudiant`, `idAppelOffre`, `idFichier`) VALUES
(1, 1000, 3, 1, NULL);

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
(4, 'TRAST ModifiÃ©', 'Plateforme de gestion des appels d''offre ModifiÃ??Ã?Â©', 'ACTIVE'),
(27, 'aaaa', 'ssss', 'EN_ATTENTE');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

--
-- Dumping data for table `entretien`
--

INSERT INTO `entretien` (`id`, `dateEntretien`, `termine`, `idContreProposition`) VALUES
(1, '2016-01-05 03:00:00', b'0', 1);

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
(3, 5, 0, 0);

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
(3, 6);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Dumping data for table `etudiant_competence`
--

INSERT INTO `etudiant_competence` (`id`, `idEtudiant`, `idCompetence`, `maitrise`) VALUES
(7, 3, 2, 16),
(8, 3, 4, 11),
(9, 3, 1, 5),
(10, 3, 5, 2),
(11, 3, 3, 3);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=9 ;

--
-- Dumping data for table `evenement_badge`
--

INSERT INTO `evenement_badge` (`id`, `sourceEvenement`, `valeur`, `idBadge`) VALUES
(8, 'SCOREPARFAIT', 1, 6);

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
(65, 'Resp2', 'type2', 'structure2', 'Sujet 2', 321),
(73, 'Resp 3', 'Type 3', 'Structure 3', 'Sujet 3', NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=46 ;

--
-- Dumping data for table `fichier`
--

INSERT INTO `fichier` (`id`, `titre`, `chemin`, `idUtilisateur`, `idCahierDesCharges`, `idQualification`) VALUES
(40, 'avatar.png', '/admin/1', NULL, NULL, NULL),
(41, 'a.png', '/badges', NULL, NULL, NULL),
(45, 'avatar.png', '/etudiant/3', NULL, NULL, NULL);

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
(63, 'InititulÃ© formation 3', 'Etablissement 3');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `note`
--

CREATE TABLE IF NOT EXISTS `note` (
  `note` text COLLATE utf8_bin NOT NULL,
  `idEntretien` int(11) NOT NULL,
  KEY `idEntretien` (`idEntretien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `note`
--

INSERT INTO `note` (`note`, `idEntretien`) VALUES
('qsdqsd', 1),
('tototo', 1),
('tototo\nsdqsdq', 1);

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
(1, 'nomAdmin', 'prenomAdmin', '2015-12-15'),
(3, 'nomEtudiantModifie', 'prenomEtudiantModifie', '2015-12-10');

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
(1, 12, '', 'ENCOURS', 1, 3, 4);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=74 ;

--
-- Dumping data for table `qualification`
--

INSERT INTO `qualification` (`id`, `dateDebut`, `dateFin`, `idEtudiant`, `idAppelOffre`) VALUES
(63, '2015-12-20', '2015-12-24', 3, NULL),
(65, '2015-12-11', '2015-12-23', 3, NULL),
(73, '2015-12-24', '2015-12-24', 3, NULL);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`id`, `question`, `coefficient`, `idTest`) VALUES
(1, 'Question A Lorem ipsum dolor sit amet, consectetur adipiscing e', 2, 1),
(2, 'Question B Lorem ipsum dolor sit amet, consectetur adipiscing e', 1, 1),
(3, 'Question C Lorem ipsum dolor sit amet, consectetur adipiscing e', 2, 1),
(4, 'Question D Lorem ipsum dolor sit amet, consectetur adipiscing e', 3, 2),
(5, 'Question E Lorem ipsum dolor sit amet, consectetur adipiscing e', 2, 2),
(6, 'Question F Lorem ipsum dolor sit amet, consectetur adipiscing e', 1, 2),
(7, 'Question G Lorem ipsum dolor sit amet, consectetur adipiscing e', 2, 3),
(8, 'Question H Lorem ipsum dolor sit amet, consectetur adipiscing e', 2, 3),
(9, 'Question I Lorem ipsum dolor sit amet, consectetur adipiscing e', 1, 3),
(10, 'Question J Lorem ipsum dolor sit amet, consectetur adipiscing e', 2, 3),
(11, 'ttere', 2, 4);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

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
('Reponse 1 fausse 1', 1),
('Reponse 2 fausse 1', 1),
('Reponse 1 fausse 2', 2),
('Reponse 2 fausse 2', 2),
('Reponse 3 fausse 2', 2),
('Reponse 1 fausse 3', 3),
('Reponse 2 fausse 3', 3),
('Reponse 1 fausse 4', 4),
('Reponse 2 fausse 4', 4),
('Reponse 3 fausse 4', 4),
('Reponse 1 fausse 5', 5),
('Reponse 1 fausse 6', 6),
('Reponse 2 fausse 6', 6),
('Reponse 1 fausse 7', 7),
('Reponse 2 fausse 7', 7),
('Reponse 1 fausse 8', 8),
('Reponse 2 fausse 8', 8),
('Reponse 1 fausse 9', 9),
('Reponse 1 fausse 10', 10),
('Reponse 2 fausse 10', 10),
('ddff', 11);

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
('Juste Lorem 1', 1),
('Juste Lorem 2', 2),
('Juste Lorem 3', 3),
('Juste Lorem 4', 4),
('Juste2 Lorem 4', 4),
('Juste Lorem 5', 5),
('Juste Lorem 6', 6),
('Juste Lorem 7', 7),
('Juste 2 Lorem 8', 8),
('Juste Lorem 8', 8),
('Juste Lorem 9', 9),
('Juste Lorem 10', 10),
('dd', 11);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=19 ;

--
-- Dumping data for table `resultat_test`
--

INSERT INTO `resultat_test` (`id`, `score`, `nombrePassage`, `dateDernierPassage`, `idEtudiant`, `idTest`) VALUES
(16, 100, 1, '2016-01-31 16:30:55', 3, 1),
(17, 0, 1, '2016-02-05 11:38:30', 3, 2),
(18, 100, 1, '2016-02-05 11:39:13', 3, 3);

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
('Secteur A', 4),
('Secteur B', 4),
('Secteur Z', 27);

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `titre`, `duree`, `nombrePassage`, `idEntreprise`, `idBadge`) VALUES
(1, 'Test Numéro 1', 20, 11, NULL, NULL),
(2, 'Test Numéro 2', 30, 5, NULL, NULL),
(3, 'Test Numéro 3', 25, 7, 4, NULL),
(4, 'Test 4', 20, 0, 4, NULL);

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
(2, 1),
(3, 1),
(1, 2),
(2, 2),
(3, 2),
(3, 3),
(1, 4),
(2, 5);

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
(1, 'admin@mail.com', '00d70c561892a94980befd12a400e26aeb4b8599', 'ADM', 1, 40),
(3, 'etudiant@mail.com', '00d70c561892a94980befd12a400e26aeb4b8599', 'ETU', 2, 45),
(4, 'entreprise@mail.com', '00d70c561892a94980befd12a400e26aeb4b8599', 'ENT', 3, NULL),
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
