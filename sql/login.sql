-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Lug 30, 2018 alle 10:54
-- Versione del server: 10.1.34-MariaDB
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
  `ragione_sociale` varchar(100) NOT NULL,
  `indirizzo_sede_legale` varchar(100) NOT NULL,
  `cf_rappresentante` varchar(30) NOT NULL,
  `partita_iva_rappresentante` varchar(50) NOT NULL,
  `nome_cognome_rappresentante` varchar(30) NOT NULL,
  `nome_cognome_tirocini` varchar(60) NOT NULL,
  `telefono_tirocini` varchar(20) NOT NULL,
  `email_tirocini` varchar(40) NOT NULL,
  `foro_competente` varchar(50) NOT NULL,
  `provincia` varchar(255) NOT NULL,
  `abilitata` tinyint(1) NOT NULL,
  `descrizione` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `azienda`
--

INSERT INTO `azienda` (`azienda_id`, `email_login`, `password`, `ragione_sociale`, `indirizzo_sede_legale`, `cf_rappresentante`, `partita_iva_rappresentante`, `nome_cognome_rappresentante`, `nome_cognome_tirocini`, `telefono_tirocini`, `email_tirocini`, `foro_competente`, `provincia`, `abilitata`, `descrizione`) VALUES
(2, 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', '-- Select --', 0, ''),
(3, 'micron@outlook.it', 'micron12345', 'asdasd', 'asdasdasd', 'asdasda', 'asdasdas', 'asdasdasd', 'asdasdas', 'asdasdsa', 'adadasd', 'asdasdsad', 'AL', 0, ''),
(4, '545@gmail.com', 'paoluccio545', 'asdaaa', 'asdaaa', 'aaaaaa', 'aaaaaaa', 'asdaaa', 'asdaaa', 'aasdaa', 'aaaaaa', 'asdaaaa', 'AL', 0, ''),
(5, '545dev@gmail.com', '$2a$12$s.4Gcv0iScoQ/1GL7qR2luBoXDWNikVcrVK5O.lS859CM.Xubc.wi', 'aaaaaaaaaaa', 'aaaaaaaa', 'aaaaaaaaa', 'aaaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaa', 'aaaaaaaaaaaaa', 'aaaaaaaaaaaa', 'aaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaa', 'AN', 1, ''),
(6, 'microsoftitalia@outlook.it', '$2a$12$zvx3oL1Bh10T3R5bl1Gi.eRm/Vxpo6Hd62FG0Q59ie.eIZ1.RHiue', 'Microsoft', 'qualcos', 'adasdasd', 'asdasdasda', 'aaaaaa', 'aaaaaaaaa', 'aaaaaaaa', 'asdadasdas', 'aaaaaaaaaaa', 'AN', 0, ''),
(7, 'giovanni', '$2a$12$CEByeokJQzYo5CWmW.91U.SZWCDsDG/M/Q5NABKvTCXSn3/tZRyl.', 'studio del pene', 'asdasd', 'asdasdasd', 'asdasdasd', 'asdasdasd', 'asdasdasd', 'asdasdasd', 'davide.ubaldi@out.it', 'asdasdasd', 'AG', 0, '');

-- --------------------------------------------------------

--
-- Struttura della tabella `offerta_tirocinio`
--

CREATE TABLE `offerta_tirocinio` (
  `offerta_tirocinio_id` int(11) NOT NULL,
  `azienda_id` int(11) NOT NULL,
  `nome` varchar(111) NOT NULL,
  `dettagli` varchar(300) NOT NULL,
  `luogo` varchar(100) NOT NULL,
  `mesi` varchar(11) NOT NULL,
  `ore` varchar(100) NOT NULL,
  `orari` varchar(10) NOT NULL,
  `mese_iniziale` varchar(50) NOT NULL,
  `mese_finale` varchar(60) NOT NULL,
  `obiettivi` varchar(300) NOT NULL,
  `modalita` varchar(30) NOT NULL,
  `rimborsi_spese_facilitazioni_previste` varchar(600) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `offerta_tirocinio`
--

INSERT INTO `offerta_tirocinio` (`offerta_tirocinio_id`, `azienda_id`, `nome`, `dettagli`, `luogo`, `mesi`, `ore`, `orari`, `mese_iniziale`, `mese_finale`, `obiettivi`, `modalita`, `rimborsi_spese_facilitazioni_previste`) VALUES
(1, 3, '', '', 'casamuraglia', '0', '14 settembrice', '12', '', '', 'cacca', 'di merda', 'mai'),
(2, 4, '', '', 'stoa', '0', 'giovanni', '12', '', '', '66', '123123', 'certo che no'),
(9, 7, 'asdasads', '', 'asdasdasd', '0', '08:00 - 12:00', '10', '', '', 'asdasads', 'adsadsads', 'asdsdaads'),
(10, 7, 'scaccomaggio', '', 'asdasdasd', '0', '08:00 - 12:00', '10', '', '', 'asdasdasdsda', 'dffff', 'ccc'),
(11, 7, 'asfsaf', '', 'asfsfa', '0', '08:00 - 12:00', '10', '', '', 'asfasffaf', 'asfasfass', 'nessuna stronzo'),
(12, 7, 'asfsaf', '', 'asfsfa', '0', '08:00 - 12:00', '10', '', '', 'asfasffaf', 'asfasfass', 'nessuna stronzo'),
(13, 7, 'sccccc', '', 'scccaaaa', '0', '08:00 - 12:00', '10', '', '', 'ccccc', 'r44444', 'faffaaf'),
(34, 7, 'schiappozz', '', 'casamurana', '0', '08:00 - 12:00', '10', '', '', 'sdadd', 'ccacc', 'STO CAZ'),
(35, 7, 'cazziemazzi', '', 'asdasdasd', '0', '08:00 - 12:00', '10', '', '', 'asfaff', 'sfasfd', 'ffff'),
(36, 7, 'AAAAAAAAAAA', 'SSSSSSSSS', 'DDDDDDDDDD', '1', '08:00 - 12:00', '10', 'January', 'January', 'FFFFFFFFF', 'AAAAAAAAAAAA', 'DDDDDDDDDDD'),
(37, 7, 'GGGGGG', 'GGGGGGG', 'GGGGGG', '1', '08:00 - 12:00', '10', 'January', 'January', 'GGGGG', 'GGGGGGGG', 'GGGGGGGG');

-- --------------------------------------------------------

--
-- Struttura della tabella `password_reset`
--

CREATE TABLE `password_reset` (
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `expiration_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `password_reset`
--

INSERT INTO `password_reset` (`email`, `token`, `expiration_date`) VALUES
('mikesh07mail@gmail.com', 'c2d65b29-cab4-4ce0-87bd-f43fd3b83003', '2018-07-30 10:25:03');

-- --------------------------------------------------------

--
-- Struttura della tabella `richieste_tirocinio`
--

CREATE TABLE `richieste_tirocinio` (
  `richiesta_tirocinio_id` int(11) NOT NULL,
  `azienda_id` int(11) NOT NULL,
  `offerta_tirocinio_id` int(11) NOT NULL,
  `studente_id` int(11) NOT NULL,
  `accettata` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `richieste_tirocinio`
--

INSERT INTO `richieste_tirocinio` (`richiesta_tirocinio_id`, `azienda_id`, `offerta_tirocinio_id`, `studente_id`, `accettata`) VALUES
(1, 7, 1, 23, 0),
(2, 7, 13, 20, 0),
(3, 7, 13, 23, 0),
(4, 7, 13, 22, 1);

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
  `cod_fiscale` varchar(255) NOT NULL,
  `ruolo` varchar(255) NOT NULL,
  `luogo_nascita` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `studente`
--

INSERT INTO `studente` (`studente_id`, `nome`, `password`, `date`, `provincia`, `provincia_nascita`, `residenza`, `citta`, `CAP`, `telefono`, `corso`, `email`, `handicap`, `cognome`, `cod_fiscale`, `ruolo`, `luogo_nascita`) VALUES
(20, 'asdasdas', '$2a$12$6DcFXiwhxaeTgBXEzTkpquHCt8kfhmzEUlcUqiDox.toBxIdZfJgW', '2018-07-24', 'AL', 'AG', 'asdsad', 'asdasdasda', 3033, '123131', 'ascasdadsad', 'mikesh07mail@gmail.com', 1, 'asdsadsad', 'adasdadasd', 'admin', 'asdasdasd'),
(21, 'sdasdasd', '$2a$12$oozOXSluADkqa/8Hbn0h3uHJ1UwR8UxNUM7gVDCZ7XmPfITJFcxIO', '2018-07-24', 'AL', 'AG', 'asdsadasd', 'asdasdasd', 3033, '123213123', 'asdsadasd', 'asd@lo.com', 1, 'adasdasd', 'adadasd', '', ''),
(22, 'asdsadasd', '$2a$12$k49Go8woNy71FgC1vxv96./TJp07U4FxS2LUkDJT3klAI4lq0oweK', '2018-07-24', 'AG', 'AL', 'asdsadasd', 'asdasdasd', 5055, '12313', 'asdasdasd', 'asd@gmail.com', 1, 'asdsad', 'dasdsadad', '', ''),
(23, 'Gianni', '$2a$12$3aIx2slzORP9q/V3MPB.bOqU3Pg3maDEwyN34l1GuxMOJPRjSNDUu', '2018-07-15', 'AG', 'AL', 'aaa', 'aaa', 4444, '4444', '4444', 'davide.ubaldi17@gmail.com', 0, 'fasfasfasf', 'asdasdasd', 'empty', ''),
(24, 'catamarano', '$2a$12$TLo06N1XOkr8V2iJ07ERouT69C62y3E1Oth73ad8QmthL5P3.g4ii', '2018-09-07', 'AG', 'AL', 'aaa', 'ascccc', 4444, '11222', '1111', 'davide.ubaldi@outlook.it', 1, 'luzi', 'asdasdasd', 'user', 'asccc');

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
  ADD PRIMARY KEY (`offerta_tirocinio_id`),
  ADD KEY `azienda_id` (`azienda_id`);

--
-- Indici per le tabelle `richieste_tirocinio`
--
ALTER TABLE `richieste_tirocinio`
  ADD PRIMARY KEY (`richiesta_tirocinio_id`),
  ADD KEY `azienda_id` (`azienda_id`),
  ADD KEY `offerta_tirocinio_id` (`offerta_tirocinio_id`),
  ADD KEY `studente_id` (`studente_id`);

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
  MODIFY `azienda_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT per la tabella `offerta_tirocinio`
--
ALTER TABLE `offerta_tirocinio`
  MODIFY `offerta_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT per la tabella `richieste_tirocinio`
--
ALTER TABLE `richieste_tirocinio`
  MODIFY `richiesta_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `studente`
--
ALTER TABLE `studente`
  MODIFY `studente_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `offerta_tirocinio`
--
ALTER TABLE `offerta_tirocinio`
  ADD CONSTRAINT `offerta_tirocinio_ibfk_1` FOREIGN KEY (`azienda_id`) REFERENCES `azienda` (`azienda_id`);

--
-- Limiti per la tabella `richieste_tirocinio`
--
ALTER TABLE `richieste_tirocinio`
  ADD CONSTRAINT `richieste_tirocinio_ibfk_1` FOREIGN KEY (`azienda_id`) REFERENCES `azienda` (`azienda_id`),
  ADD CONSTRAINT `richieste_tirocinio_ibfk_2` FOREIGN KEY (`offerta_tirocinio_id`) REFERENCES `offerta_tirocinio` (`offerta_tirocinio_id`),
  ADD CONSTRAINT `richieste_tirocinio_ibfk_3` FOREIGN KEY (`studente_id`) REFERENCES `studente` (`studente_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
