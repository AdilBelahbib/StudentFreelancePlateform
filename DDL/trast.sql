-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 25, 2015 at 09:00 PM
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=29 ;

--
-- Dumping data for table `adresse`
--

INSERT INTO `adresse` (`id`, `corps`, `ville`, `pays`, `idUtilisateur`) VALUES
(22, 'Mon Adresse N 3', 'Ville 3', 'Pays 3', 3),
(23, 'aaaaaaaaaaa', 'vvvvvvvvvv', 'pppppppppppppp', 3),
(24, 'sssssss', 'xxxxxxxxx', 'wwwwwwww', 3),
(28, 'ffffffff', 'uuuuuuuuu', 'xxxxxxxxxx', 4);

-- --------------------------------------------------------

--
-- Table structure for table `appel_offre`
--

CREATE TABLE IF NOT EXISTS `appel_offre` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateDebut` datetime NOT NULL,
  `dateExpiration` datetime NOT NULL,
  `statut` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `idEntreprise` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idEntreprise` (`idEntreprise`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `appel_offre`
--

INSERT INTO `appel_offre` (`id`, `dateDebut`, `dateExpiration`, `statut`, `idEntreprise`) VALUES
(1, '2015-12-01 00:00:00', '2015-12-25 00:00:00', 'ENCOURS', 4),
(2, '2015-12-23 00:00:00', '2015-12-10 00:00:00', 'ENCOURS', 4),
(3, '2015-12-10 00:00:00', '2015-12-22 00:00:00', 'ENCOURS', 26),
(4, '2015-12-09 00:00:00', '2015-12-23 00:00:00', 'ENCOURS', 4),
(5, '2015-12-25 14:48:12', '2015-01-25 00:48:00', 'PREPARE', 4);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `cahier_des_charges`
--

INSERT INTO `cahier_des_charges` (`id`, `sujet`, `dateDebut`, `dateFin`, `idAppelOffre`, `idProjet`) VALUES
(1, 'Sujet cahier des charge 1', '2015-12-02', '2015-12-16', 1, NULL),
(2, 'Sujet cahier des charge 2', '2015-12-04', '2015-12-23', 2, NULL),
(3, 'Sujet cahier des charge 3', '2015-05-12', '2016-05-11', 3, NULL),
(4, 'Sujet cahier des charge 4', '2015-04-02', '2015-08-10', 4, NULL),
(5, '', '2015-12-25', '2015-12-25', 5, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `competence`
--

CREATE TABLE IF NOT EXISTS `competence` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `intitule` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `intitule` (`intitule`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `contre_proposition`
--

CREATE TABLE IF NOT EXISTS `contre_proposition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enchere` double NOT NULL,
  `idEtudiant` int(11) DEFAULT NULL,
  `idAppelOffre` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idEtudiant` (`idEtudiant`),
  KEY `idAppelOffre` (`idAppelOffre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `contre_proposition`
--

INSERT INTO `contre_proposition` (`id`, `enchere`, `idEtudiant`, `idAppelOffre`) VALUES
(1, 12, 3, 1),
(4, 120, 3, 4);

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
(4, 'TRAST ModifiÃ?Â©', 'Plateforme de gestion des appels d''offre ModifiÃ?Â©', 'EN_ATTENTE'),
(26, 'TRAST2', 'Plateforme de gestion des appels d''offre', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` int(11) NOT NULL,
  `nombreBids` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`id`, `nombreBids`) VALUES
(3, 4);

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

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
  `idContreProposition` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUtilisateur` (`idUtilisateur`),
  KEY `idCahierDesCharges` (`idCahierDesCharges`),
  KEY `idQualification` (`idQualification`),
  KEY `idContreProposition` (`idContreProposition`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=54 ;

--
-- Dumping data for table `fichier`
--

INSERT INTO `fichier` (`id`, `titre`, `chemin`, `idUtilisateur`, `idCahierDesCharges`, `idQualification`, `idContreProposition`) VALUES
(46, 'fichier', 'chemin', NULL, NULL, NULL, NULL),
(52, 'fichier', 'chemin', NULL, NULL, NULL, NULL),
(53, 'fichier', 'chemin', NULL, NULL, NULL, NULL);

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
  `idEntreprise` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCahierDesCharges` (`idCahierDesCharges`),
  KEY `idEtudiant` (`idEtudiant`),
  KEY `idEntreprise` (`idEntreprise`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

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
('Secteur C', 4);

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
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  KEY `fk_role` (`idRole`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=27 ;

--
-- Dumping data for table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `motDePasse`, `typeUtilisateur`, `idRole`) VALUES
(1, 'admin@mail.com', 'mdp', 'ADM', 1),
(3, 'etudiant@mail.com', 'mdp', 'ETU', 2),
(4, 'entreprise@mail.com', 'mdp', 'ENT', 3),
(26, 'entreprise2@mail.com', 'mdpEntr', 'ENT', 3);

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
  ADD CONSTRAINT `contre_proposition_ibfk_2` FOREIGN KEY (`idAppelOffre`) REFERENCES `appel_offre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `entreprise`
--
ALTER TABLE `entreprise`
  ADD CONSTRAINT `entreprise_ibfk_1` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`id`) REFERENCES `particulier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

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
  ADD CONSTRAINT `fichier_ibfk_3` FOREIGN KEY (`idQualification`) REFERENCES `qualification` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fichier_ibfk_4` FOREIGN KEY (`idContreProposition`) REFERENCES `contre_proposition` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `formation_ibfk_1` FOREIGN KEY (`id`) REFERENCES `qualification` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `particulier`
--
ALTER TABLE `particulier`
  ADD CONSTRAINT `particulier_ibfk_1` FOREIGN KEY (`id`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `projet`
--
ALTER TABLE `projet`
  ADD CONSTRAINT `projet_ibfk_3` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `projet_ibfk_1` FOREIGN KEY (`idCahierDesCharges`) REFERENCES `cahier_des_charges` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `projet_ibfk_2` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `qualification`
--
ALTER TABLE `qualification`
  ADD CONSTRAINT `qualification_ibfk_1` FOREIGN KEY (`idEtudiant`) REFERENCES `etudiant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `qualification_ibfk_2` FOREIGN KEY (`idAppelOffre`) REFERENCES `appel_offre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `remuneration`
--
ALTER TABLE `remuneration`
  ADD CONSTRAINT `remuneration_ibfk_1` FOREIGN KEY (`idAppelOffre`) REFERENCES `appel_offre` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `secteur_activite`
--
ALTER TABLE `secteur_activite`
  ADD CONSTRAINT `secteur_activite_ibfk_1` FOREIGN KEY (`idEntreprise`) REFERENCES `entreprise` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `fk_role` FOREIGN KEY (`idRole`) REFERENCES `role_utilisateur` (`id`) ON DELETE SET NULL ON UPDATE SET NULL;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
