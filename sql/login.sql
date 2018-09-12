-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Set 12, 2018 alle 22:39
-- Versione del server: 10.1.29-MariaDB
-- Versione PHP: 7.1.12

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
  `cf_iva` varchar(30) NOT NULL,
  `nome_cognome_rappresentante` varchar(255) NOT NULL,
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

INSERT INTO `azienda` (`azienda_id`, `email_login`, `password`, `ragione_sociale`, `indirizzo_sede_legale`, `cf_iva`, `nome_cognome_rappresentante`, `nome_cognome_tirocini`, `telefono_tirocini`, `email_tirocini`, `foro_competente`, `provincia`, `abilitata`, `descrizione`) VALUES
(1, 'compagnia1@hotmail.it', '$2a$12$SAgB.K.p7JZiaVg2M6N4C.DwMUi1dLSzJ/7Gau8qDrU1ijjdv4/7y', 'Compagnia 1', 'Via delle primule 22', 'SGSG4V4436EGSDSD', 'Gianni Luzi', 'Sandro Luzi', '23141424', 'aaa@hotmail.it', 'a a a a', 'AP', 1, 'Description Sample'),
(2, 'compagnia2@gmail.it', '$2a$12$y4iUAH2YZglitQ1DPF.Ry.3Jxms4ifnHxe.ryr1Y1ze8VeExW3NKK', 'Compagnia A', 'Via delle viole 22', 'SGSG4V4436EGSDSD', 'Gianni Luzi', 'Sandro Luzi', '23141424', 'bbb@hotmail.it', 'a a a a', 'AP', 1, 'Description Sample');

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
  `orari` varchar(20) NOT NULL,
  `mese_iniziale` varchar(50) NOT NULL,
  `mese_finale` varchar(60) NOT NULL,
  `obiettivi` varchar(235) NOT NULL,
  `modalita` varchar(235) NOT NULL,
  `rimborsi_spese_facilitazioni_previste` varchar(600) NOT NULL,
  `company_headquarters` tinyint(4) NOT NULL,
  `remote_connection` tinyint(4) NOT NULL,
  `refound_of_expenses` tinyint(4) NOT NULL,
  `company_refactory` tinyint(4) NOT NULL,
  `training_aid` tinyint(4) NOT NULL,
  `nothing` tinyint(4) NOT NULL,
  `settore` varchar(20) NOT NULL,
  `invisibile` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `offerta_tirocinio`
--

INSERT INTO `offerta_tirocinio` (`offerta_tirocinio_id`, `azienda_id`, `nome`, `dettagli`, `luogo`, `mesi`, `ore`, `orari`, `mese_iniziale`, `mese_finale`, `obiettivi`, `modalita`, `rimborsi_spese_facilitazioni_previste`, `company_headquarters`, `remote_connection`, `refound_of_expenses`, `company_refactory`, `training_aid`, `nothing`, `settore`, `invisibile`) VALUES
(1, 1, 'Gestione sicurezza', 'Questa offerta ________ _______________ _________ __________ _____________ __________', '', '2', '60', '14:00 - 18:00', '03/09/2018', '24/10/2018', '@@@@@ @@@@@ @@@@@@ @@@@@@ @@@@@@ @@@@@@ @@@@@@ @@@@@@@@ @@@@@ @@@@@@@@@@@@ @@@@@@@@@@@@@@@@@@@@ @@@@@@@@@@@@@@@@', '@@@@@@@ @@@@@@@@ @@@@@@@@@@@ @@@@@@@@@@@ @@@@@@@@@@@ @@@@@@@@@@@ @@@@@@@@@@@ @@@@@@@@@@@ @@@@@@@@@@ @@@@@@@@@@@', '', 1, 0, 1, 1, 1, 1, 'Informatica', 0),
(2, 1, 'Energia elettrica', 'energia elettrica', '', '5', '100', '14:00 - 18:00', '15/08/2018', '04/09/2018', '@@@@@@@ @@@@@@@@ @@@@@@@@ @@@@@@@@ @@@@@@@@ @@@@@@@@ @@@@@@@@ @@@@@@@@@@@ @@@@@@@@@@@ @@@@@@@@@@@ @@@@@@@@@@@@@@', '@@@@@@@@@ @@@@@@@@@ @@@@@@@@@@@@@@ @@@@@@@@@@@@@@ @@@@@@@@@@@@@@ @@@@@@@@@@@@@@ @@@@@@@@@@@@@@ @@@@@@@@@@@@@@', '', 1, 1, 1, 1, 1, 1, 'Ambiente', 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `password_reset`
--

CREATE TABLE `password_reset` (
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `expiration_date` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `tutor_email` varchar(88) NOT NULL,
  `valutazione` varchar(170) NOT NULL,
  `attivita_svolta` varchar(235) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `richieste_tirocinio`
--

INSERT INTO `richieste_tirocinio` (`richiesta_tirocinio_id`, `azienda_id`, `offerta_tirocinio_id`, `studente_id`, `accettata`, `cfu`, `tutor_name`, `tutor_surname`, `tutor_email`, `valutazione`, `attivita_svolta`) VALUES
(1, 1, 2, 1, 1, '3', 'Salvatore', 'Rossi', 'salvatore@hotmail.it', '30/30', '-'),
(2, 1, 2, 2, 0, '3', 'Mario', 'Mario', 'mario@mario.it', 'empty', 'empty');

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
  `residenza` varchar(50) NOT NULL,
  `citta` varchar(30) NOT NULL,
  `CAP` int(5) NOT NULL,
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
(1, 'Mario', '$2a$12$fEPKqtobEQs7XcfKmGilhe05wL1U7OhLAeU3lLbP5otWsBoa6dnVC', '17/09/2018', 'AP', 'AP', 'Via delle Primule', 'Ascoli Piceno', 63100, '3278635352', 'informatica', 'mario@hotmail.it', 0, 'Rossi', 'MARIOROSSI95R11AR3', 'user', 'Ascoli Piceno'),
(2, 'Giovanni', '$2a$12$FyfosCpbOhCrxS0W6ViZfe3uxZEG2hFox6YiMW19MCr6y/5XncfKi', '10/04/2018', 'AP', 'AP', 'Via delle Genziane', 'Ascoli Piceno', 63100, '3278635352', 'Scienze politiche', 'giovanni@hotmail.it', 0, 'Bianchi', 'GIOVANNIOSSI95R11AR3', 'user', 'Ascoli Piceno');

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
  MODIFY `azienda_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `notifica`
--
ALTER TABLE `notifica`
  MODIFY `id_notifica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `offerta_tirocinio`
--
ALTER TABLE `offerta_tirocinio`
  MODIFY `offerta_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `richieste_tirocinio`
--
ALTER TABLE `richieste_tirocinio`
  MODIFY `richiesta_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT per la tabella `studente`
--
ALTER TABLE `studente`
  MODIFY `studente_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `offerta_tirocinio`
--
ALTER TABLE `offerta_tirocinio`
  ADD CONSTRAINT `offerta_tirocinio_ibfk_1` FOREIGN KEY (`azienda_id`) REFERENCES `azienda` (`azienda_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `richieste_tirocinio`
--
ALTER TABLE `richieste_tirocinio`
  ADD CONSTRAINT `richieste_tirocinio_ibfk_1` FOREIGN KEY (`azienda_id`) REFERENCES `azienda` (`azienda_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `richieste_tirocinio_ibfk_2` FOREIGN KEY (`offerta_tirocinio_id`) REFERENCES `offerta_tirocinio` (`offerta_tirocinio_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `richieste_tirocinio_ibfk_3` FOREIGN KEY (`studente_id`) REFERENCES `studente` (`studente_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
