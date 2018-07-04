-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Lug 04, 2018 alle 08:54
-- Versione del server: 10.2.15-MariaDB
-- Versione PHP: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `login`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `azienda`
--

CREATE TABLE `azienda` (
  `azienda_id` int(11) NOT NULL,
  `email_login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `ragione sociale` varchar(100) NOT NULL,
  `indirizzo_sede_legale` varchar(100) NOT NULL,
  `cf_rappresentante` varchar(30) NOT NULL,
  `partita_iva_rappresentante` varchar(50) NOT NULL,
  `nome_cognome_rappresentante` varchar(30) NOT NULL,
  `nome_cognome_tirocini` varchar(60) NOT NULL,
  `telefono_tirocini` varchar(20) NOT NULL,
  `email_tirocini` varchar(40) NOT NULL,
  `foro_competente` varchar(50) NOT NULL,
  `provincia` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `azienda`
--

INSERT INTO `azienda` (`azienda_id`, `email_login`, `password`, `ragione sociale`, `indirizzo_sede_legale`, `cf_rappresentante`, `partita_iva_rappresentante`, `nome_cognome_rappresentante`, `nome_cognome_tirocini`, `telefono_tirocini`, `email_tirocini`, `foro_competente`, `provincia`) VALUES
(2, 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', '-- Select --'),
(3, 'micron@outlook.it', 'micron12345', 'asdasd', 'asdasdasd', 'asdasda', 'asdasdas', 'asdasdasd', 'asdasdas', 'asdasdsa', 'adadasd', 'asdasdsad', 'AL'),
(4, '545@gmail.com', 'paoluccio545', 'asdaaa', 'asdaaa', 'aaaaaa', 'aaaaaaa', 'asdaaa', 'asdaaa', 'aasdaa', 'aaaaaa', 'asdaaaa', 'AL'),
(5, '545dev@gmail.com', '$2a$12$s.4Gcv0iScoQ/1GL7qR2luBoXDWNikVcrVK5O.lS859CM.Xubc.wi', 'aaaaaaaaaaa', 'aaaaaaaa', 'aaaaaaaaa', 'aaaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaa', 'aaaaaaaaaaaaa', 'aaaaaaaaaaaa', 'aaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaa', 'AN');

-- --------------------------------------------------------

--
-- Struttura della tabella `offerta_tirocinio`
--

CREATE TABLE `offerta_tirocinio` (
  `offerta_tirocinio_id` int(11) NOT NULL,
  `luogo` varchar(100) NOT NULL,
  `orari` varchar(100) NOT NULL,
  `ore` varchar(10) NOT NULL,
  `obiettivi` varchar(300) NOT NULL,
  `modalita` varchar(30) NOT NULL,
  `rimborsi_spese_facilitazioni_previste` varchar(600) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `offerta_tirocinio`
--

INSERT INTO `offerta_tirocinio` (`offerta_tirocinio_id`, `luogo`, `orari`, `ore`, `obiettivi`, `modalita`, `rimborsi_spese_facilitazioni_previste`) VALUES
(1, 'casa di peppe', '12-14 20-22', '55', 'succhiare', 'seduti', 'nessuna stronzo'),
(2, 'casa di peppe', '12-14 20-22', '55', 'succhiare', 'seduti', 'nessuna stronzo'),
(3, 'casa di peppe', '12-14 20-22', '55', 'succhiare', 'seduti', 'nessuna stronzo');

-- --------------------------------------------------------

--
-- Struttura della tabella `studente`
--

CREATE TABLE `studente` (
  `studente_id` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `provincia` varchar(30) NOT NULL,
  `provincia_nascita` varchar(30) NOT NULL,
  `residenza` varchar(30) NOT NULL,
  `citta` varchar(30) NOT NULL,
  `CAP` int(11) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `corso` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `handicap` tinyint(1) NOT NULL,
  `cognome` varchar(30) NOT NULL,
  `cod_fiscale` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `studente`
--

INSERT INTO `studente` (`studente_id`, `nome`, `password`, `date`, `provincia`, `provincia_nascita`, `residenza`, `citta`, `CAP`, `telefono`, `corso`, `email`, `handicap`, `cognome`, `cod_fiscale`) VALUES
(14, 'Stefano', '$2a$12$bQbYedV0jlY4km8IKsAH.uCt5lO1dsnLXKfckKuTOmkg9P55NXnTe', '1995-07-26', 'FR', 'FR', 'Via Rondinella', 'Arpino', 3033, '3343037176', 'Informatica', 'mikesh07mail@gmail.com', 0, 'De Ciantis', 'dcnfsfa'),
(15, 'Sterano', '$2a$12$bh5gHxbb2M17hAKMPoM9bOKt7fTy3RMhiKXn4eyeOdHo3RmZFesf6', '1992-07-03', 'AL', 'AL', 'via rindinella', 'vaffanculo', 3033, '3383637382', 'iNFORMATICA', 'dio@po.rco', 1, 'de ciantis', 'dcndgd'),
(16, 'sad', '$2a$12$1iYQdgFWEDuKTikVTFE0G.TWBOeN6wvoQgnPtD9onDrsDYYrkbtAq', '2018-07-11', 'AG', 'AG', 'asdasd', 'asdsadsad', 3033, '3333333', 'iNFORMATICA', 'asd@lol.com', 1, 'de ciantis', 'asdsadas'),
(17, 'asd', '$2a$12$wpTnw7k.MZOTD0ekZ.QOMez7fZvTRSiCdtbPe49baPkFfv6UKp98a', '2018-07-17', 'AG', 'AG', 'asdasd', 'asdasdasd', 4044, '213123213', 'iNFORMATICA', 'dio@ca.ne', 0, 'asdad', 'asdasdasd');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `azienda`
--
ALTER TABLE `azienda`
  ADD PRIMARY KEY (`azienda_id`);

--
-- Indici per le tabelle `offerta_tirocinio`
--
ALTER TABLE `offerta_tirocinio`
  ADD PRIMARY KEY (`offerta_tirocinio_id`);

--
-- Indici per le tabelle `studente`
--
ALTER TABLE `studente`
  ADD PRIMARY KEY (`studente_id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `azienda`
--
ALTER TABLE `azienda`
  MODIFY `azienda_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `offerta_tirocinio`
--
ALTER TABLE `offerta_tirocinio`
  MODIFY `offerta_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `studente`
--
ALTER TABLE `studente`
  MODIFY `studente_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
