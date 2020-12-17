-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 17 déc. 2020 à 16:04
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.5
CREATE DATABASE IF NOT EXISTS yc_gotalent;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `yc_gotalent`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrator`
--

CREATE TABLE `administrator` (
  `id_user` bigint(20) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `administrator`
--

INSERT INTO `administrator` (`id_user`, `password`) VALUES
(15970010, '123');

-- --------------------------------------------------------

--
-- Structure de la table `adminsession`
--

CREATE TABLE `adminsession` (
  `id` bigint(20) NOT NULL,
  `id_administrator` bigint(20) DEFAULT NULL,
  `is_connected` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `adminsession`
--

INSERT INTO `adminsession` (`id`, `id_administrator`, `is_connected`) VALUES
(3, 15970010, 1);

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'La dance'),
(2, 'En chantant'),
(3, 'La scène'),
(4, 'La Comédie'),
(22, 'Calcul mental\r\n'),
(422, 'Le cube de Rubik');

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `id_user` bigint(20) NOT NULL,
  `id_category` bigint(20) NOT NULL,
  `description` varchar(50) NOT NULL,
  `show_start_time` timestamp NULL DEFAULT NULL,
  `show_end_time` timestamp NULL DEFAULT NULL,
  `attached_file` varchar(100) DEFAULT NULL,
  `is_accepted` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `participation`
--

INSERT INTO `participation` (`id_user`, `id_category`, `description`, `show_start_time`, `show_end_time`, `attached_file`, `is_accepted`) VALUES
(15970010, 1, 'Description', '2020-12-16 17:10:44', '2020-12-15 17:10:44', 'text.text', 1);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `first_name`, `last_name`, `email`, `phone`) VALUES
(232323, 'user', 'user', 'user@user.com', '+09911111889'),
(1597122, 'Admin', 'Admin', 'admin@admin.com', '+0998877889'),
(15970010, 'Ahmed', 'Mahmoud', 'ahmed.mahmoud.admin@gmail.com', '+212 6 00 00 00 00'),
(534691317, 'HIMM', 'BRAAA', 'ZSZSSZ', 'SZZSZ');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`id_user`);

--
-- Index pour la table `adminsession`
--
ALTER TABLE `adminsession`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_administrator` (`id_administrator`);

--
-- Index pour la table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`id_user`,`id_category`),
  ADD KEY `id_category` (`id_category`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `administrator`
--
ALTER TABLE `administrator`
  ADD CONSTRAINT `administrator_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`);

--
-- Contraintes pour la table `adminsession`
--
ALTER TABLE `adminsession`
  ADD CONSTRAINT `adminsession_ibfk_1` FOREIGN KEY (`id_administrator`) REFERENCES `administrator` (`id_user`);

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `participation_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `participation_ibfk_2` FOREIGN KEY (`id_category`) REFERENCES `category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
