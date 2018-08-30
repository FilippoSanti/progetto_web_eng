-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Ago 30, 2018 alle 15:22
-- Versione del server: 10.1.34-MariaDB
-- Versione PHP: 7.2.8

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
(7, 'giovanni', '$2a$12$CEByeokJQzYo5CWmW.91U.SZWCDsDG/M/Q5NABKvTCXSn3/tZRyl.', 'studio del pene', 'asdasd', 'asdasdasd', 'asdasdasd', 'asdasdasd', 'asdasdasd', 'asdasdasd', 'davide.ubaldi@out.it', 'asdasdasd', 'AG', 1, ''),
(8, 'azz@hotmail.it', '$2a$12$wmczSrZxtTCGCKCFZDj2kudT5lfsigRIO/gCi0v7hPYqAs1Rp8odO', 'azz', 'sffffffffff', 'afffffffffffffffffffff', 'fffffffffff', 'sssssssssss', 'sfffffffff', '5555555555555', 'rrrrrrrrrrrrrrrrrrr', 'ffffffff', 'AG', 0, 'Description Sample');

-- --------------------------------------------------------

--
-- Struttura della tabella `notifica`
--

CREATE TABLE `notifica` (
  `id_notifica` int(11) NOT NULL,
  `id_utente` int(11) NOT NULL,
  `id_azienda` int(11) DEFAULT NULL,
  `testo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `notifica`
--

INSERT INTO `notifica` (`id_notifica`, `id_utente`, `id_azienda`, `testo`) VALUES
(1, 1, NULL, 'asdasdad'),
(3, 0, 9, 'asdadasd wants to join'),
(4, 0, 10, 'asdasdasda wants to join'),
(5, 20, 1, 'sadfasdasd');

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
  `rimborsi_spese_facilitazioni_previste` varchar(600) NOT NULL,
  `company_headquarters` tinyint(4) NOT NULL,
  `remote_connection` tinyint(4) NOT NULL,
  `refound_of_expenses` tinyint(4) NOT NULL,
  `company_refactory` tinyint(4) NOT NULL,
  `training_aid` tinyint(4) NOT NULL,
  `nothing` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `offerta_tirocinio`
--

INSERT INTO `offerta_tirocinio` (`offerta_tirocinio_id`, `azienda_id`, `nome`, `dettagli`, `luogo`, `mesi`, `ore`, `orari`, `mese_iniziale`, `mese_finale`, `obiettivi`, `modalita`, `rimborsi_spese_facilitazioni_previste`, `company_headquarters`, `remote_connection`, `refound_of_expenses`, `company_refactory`, `training_aid`, `nothing`) VALUES
(1, 3, '', '', 'casamuraglia', '0', '14 settembrice', '12', '', '', 'cacca', 'di merda', 'mai', 0, 0, 0, 0, 0, 0),
(2, 4, '', '', 'stoa', '0', 'giovanni', '12', '', '', '66', '123123', 'certo che no', 0, 0, 0, 0, 0, 0),
(9, 7, 'asdasads', '', 'asdasdasd', '0', '08:00 - 12:00', '10', '', '', 'asdasads', 'adsadsads', 'asdsdaads', 0, 0, 0, 0, 0, 0),
(10, 7, 'scaccomaggio', '', 'asdasdasd', '0', '08:00 - 12:00', '10', '', '', 'asdasdasdsda', 'dffff', 'ccc', 0, 0, 0, 0, 0, 0),
(11, 7, 'asfsaf', '', 'asfsfa', '0', '08:00 - 12:00', '10', '', '', 'asfasffaf', 'asfasfass', 'nessuna stronzo', 0, 0, 0, 0, 0, 0),
(12, 7, 'asfsaf', '', 'asfsfa', '0', '08:00 - 12:00', '10', '', '', 'asfasffaf', 'asfasfass', 'nessuna stronzo', 0, 0, 0, 0, 0, 0),
(13, 7, 'sccccc', '', 'scccaaaa', '0', '08:00 - 12:00', '10', '', '', 'ccccc', 'r44444', 'faffaaf', 0, 0, 0, 0, 0, 0),
(34, 7, 'schiappozz', '', 'casamurana', '0', '08:00 - 12:00', '10', '', '', 'sdadd', 'ccacc', 'STO CAZ', 0, 0, 0, 0, 0, 0),
(35, 7, 'cazziemazzi', '', 'asdasdasd', '0', '08:00 - 12:00', '10', '', '', 'asfaff', 'sfasfd', 'ffff', 0, 0, 0, 0, 0, 0),
(36, 7, 'AAAAAAAAAAA', 'SSSSSSSSS', 'DDDDDDDDDD', '1', '08:00 - 12:00', '10', 'January', 'January', 'FFFFFFFFF', 'AAAAAAAAAAAA', 'DDDDDDDDDDD', 0, 0, 0, 0, 0, 0),
(37, 7, 'GGGGGG', 'GGGGGGG', 'GGGGGG', '1', '08:00 - 12:00', '10', 'January', 'January', 'GGGGG', 'GGGGGGGG', 'GGGGGGGG', 0, 0, 0, 0, 0, 0),
(38, 7, 'cazzzzzzooooooooooo', 'dddddddddddddddddddddddddddddd', 'oh che palle', '1', '08:00 - 12:00', '10', 'January', 'January', 'ddddddddddssssss', 'dddddddddsssssssssssss', 'ccccccccccccccccccccc', 0, 0, 0, 0, 0, 0),
(39, 7, 'cazzzzzzooooooooooo', 'DIOCA', 'CAAAZZZZ', '1', '08:00 - 12:00', '10', 'January', 'January', 'CAZZZZZZ', 'CAZZ', 'NA MARDA', 0, 0, 0, 0, 0, 0),
(40, 7, 'ohmerdsccccccccccc', 'aaaaaaaaaaaaaaaa', 'AAAAAAAAAAAAAAAAAAAAAAA', '1', '08:00 - 12:00', '10', 'January', 'January', 'AAAAAAAAAAAA', 'AAAAAAAAAAA', 'AAAAAAAAA', 0, 0, 0, 0, 0, 0),
(41, 7, 'carloaaaaaaaaaaaaaadddddd', 'ddddddddddddddddddd', 'hhhhhhh', '1', '08:00 - 12:00', '10', 'January', 'January', 'aaaaaaaaaa', 'aadddddddddddddd', 'fffffffffffff', 0, 0, 0, 0, 0, 0),
(42, 7, 'cazzzzzzooooooooooo', 'cccccccccccccccccccccccccccccccccccccccccccccc', 'oh che palle', '1', '08:00 - 12:00', '10', 'January', 'January', 'ccccccssssssss', 'sddddddddaaaaaaaa', 'ccccccccccccc', 0, 0, 0, 0, 0, 0),
(43, 7, 'cazzzzzzooooooooooo', 'cccccccc', 'hhhhhhh', '1', '08:00 - 12:00', '10', 'January', 'January', 'ccccc', 'ccccccc', 'ccccc', 0, 0, 0, 0, 0, 0),
(44, 7, 'carloaaaaaaaaaaaaaadddddd', 'ccccccccc', 'ccccccccccccccc', '1', '08:00 - 12:00', '10', 'January', 'January', 'ssssssssssssss', 'cccccccccccc', '', 0, 0, 0, 0, 0, 0),
(45, 7, 'cazzzzzzooooooooooo', 'cccccc', 'ccccccc', '1', '08:00 - 12:00', '10', 'January', 'January', 'cccccc', 'ssssssss', '', 0, 0, 0, 0, 0, 0),
(46, 7, 'cazzzzzzooooooooooo', 'dddddddddddddddd', 'CAAAZZZZ', '1', '08:00 - 12:00', '10', 'January', 'January', 'ddddddddddd', 'ssssssssss', '', 0, 0, 0, 0, 0, 0),
(47, 7, 'carloaaaaaaaaaaaaaadddddd', 'ccccccccccc', 'ccccccccccc', '1', '08:00 - 12:00', '10', 'February', 'January', 'cccccc', 'cccc', 'cccccccc', 1, 0, 1, 0, 1, 1);

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
  `accettata` tinyint(1) NOT NULL,
  `cfu` varchar(88) NOT NULL,
  `tutor_name` varchar(88) NOT NULL,
  `tutor_surname` varchar(88) NOT NULL,
  `tutor_email` varchar(88) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `richieste_tirocinio`
--

INSERT INTO `richieste_tirocinio` (`richiesta_tirocinio_id`, `azienda_id`, `offerta_tirocinio_id`, `studente_id`, `accettata`, `cfu`, `tutor_name`, `tutor_surname`, `tutor_email`) VALUES
(17, 2, 34, 56, 0, '', '', '', ''),
(18, 2, 44, 56, 0, '', '', '', ''),
(19, 2, 35, 56, 0, '', '', '', ''),
(20, 2, 35, 56, 0, '', '', '', ''),
(21, 7, 35, 24, 1, '', '', '', ''),
(22, 2, 12, 57, 0, '', '', '', ''),
(23, 2, 12, 56, 0, '', '', '', ''),
(24, 2, 12, 56, 0, '', '', '', ''),
(25, 2, 36, 56, 0, '', '', '', ''),
(27, 2, 41, 56, 0, '', '', '', ''),
(28, 2, 37, 56, 0, '', '', '', ''),
(29, 2, 37, 56, 0, '', '', '', ''),
(30, 2, 36, 56, 0, '', '', '', ''),
(31, 2, 36, 56, 0, '', '', '', ''),
(32, 7, 36, 56, 0, '3', 'aaaaaaaaaaaaa', 'dddddddddddd', 'cazzo@cazzo.it'),
(33, 7, 36, 56, 0, '3', 'cazz', 'cazz', 'cazzo@cazzo.it'),
(34, 7, 36, 56, 0, '3', 'cazz', 'cazz', 'cazzo@cazzo.it'),
(35, 7, 40, 56, 0, '3', 'cazz', 'dddddddddddd', 'cazzo@cazzo.it');

-- --------------------------------------------------------

--
-- Struttura della tabella `studente`
--

CREATE TABLE `studente` (
  `studente_id` int(11) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `password` varchar(255) NOT NULL,
  `date` varchar(44) NOT NULL,
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
(24, 'catamarano', '$2a$12$TLo06N1XOkr8V2iJ07ERouT69C62y3E1Oth73ad8QmthL5P3.g4ii', '2018-09-07', 'AG', 'AL', 'aaa', 'ascccc', 4444, '11222', '1111', 'davide.ubaldi@outlook.it', 1, 'luzi', 'asdasdasd', 'user', 'asccc'),
(55, 'asd', 'asd', '0000-00-00', 'asd', 'asd', 'asd', 'asd', 22, 'asd', 'asd', 'asd', 1, 'asd', 'asd', 'asd', 'asd'),
(56, 'giacomo', '$2a$12$tpC0d.OsoUwzvyqmXlmWx.hOwL4t97cDz7MZZjhDIRkEYXIVHz.uq', '08/08/2018', 'AL', 'AL', 'asd', 'asdasd', 44444, '2222222', 'asd', 'azz@hotmail.it', 0, 'cacaca', 'asdasd', 'user', 'asddd'),
(57, 'Elisa', '$2a$12$8eJApav/TqV/JGLZ28aU9eTzCZ1FpsufyGfMYM7p/Mck.UclqllY6', '13/08/2018', 'AL', 'AG', ' ia dddddd', 'dasdasdasd', 63100, '32736964649', 'nesssuno', 'a@hotmail.it', 1, 'Giovanni', 'AgagagFAGAGA', 'user', 'fffff');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `azienda`
--
ALTER TABLE `azienda`
  ADD PRIMARY KEY (`azienda_id`);

--
-- Indici per le tabelle `notifica`
--
ALTER TABLE `notifica`
  ADD PRIMARY KEY (`id_notifica`);

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
  MODIFY `azienda_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT per la tabella `notifica`
--
ALTER TABLE `notifica`
  MODIFY `id_notifica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT per la tabella `offerta_tirocinio`
--
ALTER TABLE `offerta_tirocinio`
  MODIFY `offerta_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT per la tabella `richieste_tirocinio`
--
ALTER TABLE `richieste_tirocinio`
  MODIFY `richiesta_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT per la tabella `studente`
--
ALTER TABLE `studente`
  MODIFY `studente_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

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
