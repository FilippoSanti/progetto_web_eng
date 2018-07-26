-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Lug 16, 2018 alle 13:43
-- Versione del server: 10.2.16-MariaDB
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
  `descrizione` varchar(600) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `azienda`
--

INSERT INTO `azienda` (`azienda_id`, `email_login`, `password`, `ragione_sociale`, `indirizzo_sede_legale`, `cf_rappresentante`, `partita_iva_rappresentante`, `nome_cognome_rappresentante`, `nome_cognome_tirocini`, `telefono_tirocini`, `email_tirocini`, `foro_competente`, `provincia`, `abilitata`, `descrizione`) VALUES
(2, 'aa', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', '-- Select --', 0, ''),
(3, 'micron@outlook.it', 'micron12345', 'asdasd', 'asdasdasd', 'asdasda', 'asdasdas', 'asdasdasd', 'asdasdas', 'asdasdsa', 'adadasd', 'asdasdsad', 'AL', 0, ''),
(4, '545@gmail.com', 'paoluccio545', 'asdaaa', 'asdaaa', 'aaaaaa', 'aaaaaaa', 'asdaaa', 'asdaaa', 'aasdaa', 'aaaaaa', 'asdaaaa', 'AL', 0, ''),
(5, '545dev@gmail.com', '$2a$12$s.4Gcv0iScoQ/1GL7qR2luBoXDWNikVcrVK5O.lS859CM.Xubc.wi', 'aaaaaaaaaaa', 'aaaaaaaa', 'aaaaaaaaa', 'aaaaaaaaaaaaaaaaaaaa', 'aaaaaaaaaaaa', 'aaaaaaaaaaaaa', 'aaaaaaaaaaaa', 'aaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaa', 'AN', 1, ''),
(6, 'microsoftitalia@outlook.it', 'asd', 'Microsoft', 'qualcos', 'adasdasd', 'asdasdasda', 'aaaaaa', 'aaaaaaaaa', 'aaaaaaaa', 'asdadasdas', 'foro_competente', 'provincia', 1, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.'),
(7, 'giovanni', '$2a$12$CEByeokJQzYo5CWmW.91U.SZWCDsDG/M/Q5NABKvTCXSn3/tZRyl.', 'studio del pene', 'asdasd', 'asdasdasd', 'asdasdasd', 'asdasdasd', 'asdasdasd', 'asdasdasd', 'davide.ubaldi@out.it', 'asdasdasd', 'AG', 0, ''),
(8, 'apple@outlook.com', '$2a$12$AT3B7PnxFNyF9laxKSGlIOBsPb57plfyTXTpDNq0.GI3wR.NUmwM.', 'asdasdsad', 'asdasdasd', 'adasdasd', 'dio canguro', 'asdasdasd', 'asdasdasd', 'Coglione', 'adasdasd', 'asdf', 'dio serpente', 1, 'Ciao sono un azienda  di merda porco dio'),
(9, 'a', 'l', 'asdasdas', 'asdasdasd', 'asdasdad', 'adasdasd', 'asdasdasd', 'asdasdsad', 'asdasdsad', 'adasdsadsad', 'asdsadasd', 'AG', 1, 'Sonmo una merda di azienda dio porco sono proprio una merda dio schifosoooooooooooooooooooooooooooo'),
(10, 'dio@paradiso.com', '$2a$12$5VZaT2yujrzzwrgOzxZ8HubwbaaA4qOIpuTnogS1XXXZ3rXFjbEQe', 'asdadsad', 'sadasdsa', 'adadasd', 'asdsadsad', 'asdsadsad', 'asdsadsa', 'adsadsad', 'adasdasda', 'adasdasd', 'AG', 0, 'Description Sample'),
(11, 'alberto@stasi.co', '$2a$12$TgFuqRYfv66AN7h.gCJtTeljEkcBwpdNsTL5O2d4IA01RmZLFum.', 'aaaaaaa', 'aaaaaaaaaaa', 'aaaaaaaaaaaaa', 'aaaaaaaa', 'aaaaaaaaaa', 'aaaaaaaaaa', 'aaaaaaaaaaaaa', 'AAAAAAAAAAAAAA', 'AAAAAAAAAAAA', 'AG', 0, 'Description Sample'),
(12, 'dio@rapace.si', 'diomerda2', 'sadsadsd', 'asdasdasd', 'adasdsad', 'asdadad', 'asdasdasd', 'sadsadsad', 'adasdsad', 'dasdadasd', 'asdasdsadsa', 'AG', 0, 'Description Sample'),
(13, 'paolu@cc.io', '$2a$12$ll03b5oB8mVSTCYuRLbwPOUua7R.5Vwl5zM3huK.EcrRvKvwFmbhi', 'sasadasd', 'asdasdasd', 'sdasdasd', 'asdasdasd', 'asdasdasd', 'asdasdsad', 'asdasdsad', 'asdsadad', 'asdasdasd', 'AG', 0, 'Description Sample'),
(14, 'mikeshx@lol.com', '$2a$12$NjbdUwyEWa8MQdMqUrO16uusEhnuyXMWj69A892Cl1uJR2uYJ4NsC', 'sdsadsad', 'asdasdasd', 'asdasdasd', 'sadasdd', 'asdasdasd', 'asdasdasd', 'asdasdasd', 'aasdasdasd', 'adasdasdasd', 'AL', 1, 'merda'),
(15, 'diomerda@diocane.com', '$2a$12$N6Vhgyf/pmQWhq59MjFMT.tCMBhA41.mSGlxd82zm2x4cvqFz5JY.', 'asdasdsad', 'asdsadasd', 'asdasdasd', 'asdasdsad', 'asdasdsad', 'asdasdsad', 'dasdsadsad', 'asdasdsad', 'asdsadsad', 'AG', 1, 'Azienda di merda');

-- --------------------------------------------------------

--
-- Struttura della tabella `offerta_tirocinio`
--

CREATE TABLE `offerta_tirocinio` (
  `offerta_tirocinio_id` int(11) NOT NULL,
  `azienda_id` int(11) NOT NULL,
  `nome` varchar(111) NOT NULL,
  `descrizione` varchar(300) NOT NULL,
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

INSERT INTO `offerta_tirocinio` (`offerta_tirocinio_id`, `azienda_id`, `nome`, `descrizione`, `luogo`, `orari`, `ore`, `obiettivi`, `modalita`, `rimborsi_spese_facilitazioni_previste`) VALUES
(1, 3, '', '', 'casamuraglia', '14 settembrice', '12', 'cacca', 'di merda', 'mai'),
(2, 4, '', '', 'stoa', 'giovanni', '12', '66', '123123', 'certo che no');

-- --------------------------------------------------------

--
-- Struttura della tabella `richieste_tirocinio`
--

CREATE TABLE `richieste_tirocinio` (
  `richieste_tirocinio_id` int(11) NOT NULL,
  `azienda_id` int(11) NOT NULL,
  `offerta_tirocinio_id` int(11) NOT NULL,
  `studente_id` int(11) NOT NULL,
  `accettata` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
(20, 'asdasda', '$2a$12$hk8SDaw10vC9Z2h2JDyyremzsEbidT//LKJW/TaosLU6J6kFCR99', '2018-07-02', 'A', 'A', 'asdsa', 'asdasdasd', 303, '12313', 'ascasdadsa', 'mikesh07mail@gmail.c', 2, 'asdsadsa', 'adasdadas', 'admi', 'll'),
(21, 'sdasdasd', '$2a$12$oozOXSluADkqa/8Hbn0h3uHJ1UwR8UxNUM7gVDCZ7XmPfITJFcxIO', '2018-07-24', 'AL', 'AG', 'asdsadasd', 'asdasdasd', 3033, '123213123', 'asdsadasd', 'asd@lo.com', 1, 'adasdasd', 'adadasd', '', ''),
(22, 'asdsadasd', '$2a$12$k49Go8woNy71FgC1vxv96./TJp07U4FxS2LUkDJT3klAI4lq0oweK', '2018-07-24', 'AG', 'AL', 'asdsadasd', 'asdasdasd', 5055, '12313', 'asdasdasd', 'asd@gmail.com', 1, 'asdsad', 'dasdsadad', '', ''),
(23, 'Gianni', '$2a$12$3aIx2slzORP9q/V3MPB.bOqU3Pg3maDEwyN34l1GuxMOJPRjSNDUu', '2018-07-15', 'AG', 'AL', 'aaa', 'aaa', 4444, '4444', '4444', 'davide.ubaldi17@gmail.com', 0, 'fasfasfasf', 'asdasdasd', 'empty', ''),
(24, 'asdasdasd', '$2a$12$Rk1PzmxUXWA/uxGoa9sjteu175MFZFaeepkZRVqaq2R8JCHuu1L1K', '2019-03-07', 'PD', 'PD', 'asdasdasd', 'asdsad', 3033, '13123123', 'asdasdsad', 'asdasdasd', 1, 'asdasdasdsad', 'kkokokokok', 'user', 'asdasda');

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
  ADD PRIMARY KEY (`richieste_tirocinio_id`),
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
  MODIFY `azienda_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT per la tabella `offerta_tirocinio`
--
ALTER TABLE `offerta_tirocinio`
  MODIFY `offerta_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `richieste_tirocinio`
--
ALTER TABLE `richieste_tirocinio`
  MODIFY `richieste_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT;

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