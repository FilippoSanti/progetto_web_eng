-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Set 09, 2018 alle 12:27
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
(2, 'a', 'a', 'a', 'a', 'a', '', 'a', 'a', 'a', 'a', '-- Select --', 1, ''),
(3, 'micron@outlook.it', 'micron12345', 'asdasd', 'asdasdasd', 'asdasda', '', 'asdasdas', 'asdasdsa', 'adadasd', 'asdasdsad', 'AL', 1, ''),
(4, '545@gmail.com', 'paoluccio545', 'asdaaa', 'asdaaa', 'aaaaaa', '', 'asdaaa', 'aasdaa', 'aaaaaa', 'asdaaaa', 'AL', 1, ''),
(5, '545dev@gmail.com', '$2a$12$s.4Gcv0iScoQ/1GL7qR2luBoXDWNikVcrVK5O.lS859CM.Xubc.wi', 'aaaaaaaaaaa', 'aaaaaaaa', 'aaaaaaaaa', '', 'aaaaaaaaaaaaa', 'aaaaaaaaaaaa', 'aaaaaaaaaaaaaaa', 'aaaaaaaaaaaaaaaa', 'AN', 1, ''),
(6, 'microsoftitalia@outlook.it', '$2a$12$zvx3oL1Bh10T3R5bl1Gi.eRm/Vxpo6Hd62FG0Q59ie.eIZ1.RHiue', 'Microsoft', 'qualcos', 'adasdasd', '', 'aaaaaaaaa', 'aaaaaaaa', 'asdadasdas', 'aaaaaaaaaaa', 'AN', 1, ''),
(7, 'giovanni', '$2a$12$CEByeokJQzYo5CWmW.91U.SZWCDsDG/M/Q5NABKvTCXSn3/tZRyl.', 'studio del pene', 'asdasd', 'asdasdasd', '', 'asdasdasd', 'asdasdasd', 'davide.ubaldi@out.it', 'asdasdasd', 'AG', 1, ''),
(8, 'azz@hotmail.it', '$2a$12$wmczSrZxtTCGCKCFZDj2kudT5lfsigRIO/gCi0v7hPYqAs1Rp8odO', 'azz', 'sffffffffff', 'afffffffffffffffffffff', '', 'sfffffffff', '5555555555555', 'rrrrrrrrrrrrrrrrrrr', 'ffffffff', 'AG', 1, 'Description Sample'),
(9, 'asdasdasdas@asd.asd', '$2a$12$FBFPvF4Zfcy8ej5m8rsXxOGEwhshcueo/VeM28CLwLulVV.EA0SwC', 'asdasdasd', 'asdasdasd', 'xf34535345', 'asdasdas', 'asdasdasd', 'asdasdasd', 'asdasdasdasd', 'asdasdasd', 'AL', 1, 'Description Sample'),
(10, 'dioca@n.eee', '$2a$12$egBMkE3U8dOYkNkqrj54NO1jGVs0shEMhsYJw7pzkNShUGR9yXbze', 'Apple inc.', 'adasdasdasd', 'asdasdasdasd', 'asdasdsadasd', 'adasdasdas', 'dadasdadad', 'asdasdsadasd', 'sadsadsadas', 'AN', 1, 'Description Sample'),
(11, 'ddd@ddd.d', '$2a$12$G2IT3rrXHXRAzq88pIZM2.MFnypoaJ0QrA6I7Nb1rfofNqIMTzTdu', 'asdasdasd', 'dasdasdsad', 'asdasdasdas', 'adasdasd', 'asdadasd', 'asdasdasd', 'asdasdadasd', 'asdasdasda', 'AL', 1, 'Description Sample'),
(12, 'azzzienda@sd.asd', '$2a$12$LLoE/qsS1BjAqehSXBN64uQv7I9.AgmDxsKzEe2vmJwyShVBss1Sm', 'asdasdas', 'asdasdasdas', 'dasdadasd', 'asdasdasd', 'asdasdas', 'dasdasdasd', 'asdasdasd', 'asdasdasda', 'BR', 1, 'Description Sample');

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
(7, 58, 9, 'asdasdasd wants to join');

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
  `settore` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `offerta_tirocinio`
--

INSERT INTO `offerta_tirocinio` (`offerta_tirocinio_id`, `azienda_id`, `nome`, `dettagli`, `luogo`, `mesi`, `ore`, `orari`, `mese_iniziale`, `mese_finale`, `obiettivi`, `modalita`, `rimborsi_spese_facilitazioni_previste`, `company_headquarters`, `remote_connection`, `refound_of_expenses`, `company_refactory`, `training_aid`, `nothing`, `settore`) VALUES
(48, 10, 'campeggio in australia', 'ma che cazzo ne so io ', '', '1', '08:00 - 12:00', '10', '01/09/2018', '01/11/2018', 'asdasdasd', 'asdasdasd', '', 0, 1, 1, 1, 1, 1, 'boh'),
(49, 12, 'Stage presso kingston inc.', 'Un cazzo', '', '3', '12:00 - 16:00', '80', '01/09/2018', '01/11/2018', 'laureandi', 'al pc', 'a cojoni', 1, 1, 1, 1, 1, 1, 'Informatica'),
(50, 12, 'asdasdasd', 'asdasdad', '', '1', '08:00 - 12:00', '10', '17/09/2018', '22/10/2018', 'asdasd', 'asdasdas', 'asdasdasd', 1, 1, 1, 1, 1, 1, 'asd'),
(52, 12, 'asdda', 'asdasdasd', '', '1', '08:00 - 12:00', '10', '07/09/2018', '10/09/2018', 'adasd', 'asdasdasd', 'asdasdasd', 1, 1, 1, 1, 1, 1, 'dio'),
(54, 12, 'yoyoyooy', 'asdasdasd', '', '1', '10', '08:00 - 12:00', '10/09/2018', '20/09/2018', 'asdasd', 'asdasd', 'asdasdsad', 1, 1, 1, 1, 1, 1, 'asdasd'),
(55, 12, 'nonlosacc', 'asd', '', '1', '10', '08:00 - 12:00', '08/09/2018', '08/09/2018', 'sdfsdf', 'sdfsdfsdf', 'sdfdsfsf', 1, 1, 1, 1, 1, 1, 'merda');

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
  `tutor_email` varchar(88) NOT NULL,
  `valutazione` varchar(170) NOT NULL,
  `attivita_svolta` varchar(235) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `richieste_tirocinio`
--

INSERT INTO `richieste_tirocinio` (`richiesta_tirocinio_id`, `azienda_id`, `offerta_tirocinio_id`, `studente_id`, `accettata`, `cfu`, `tutor_name`, `tutor_surname`, `tutor_email`, `valutazione`, `attivita_svolta`) VALUES
(38, 10, 48, 20, 1, '3', 'asd', 'asd', 'asd@sd.asdasd', 'empty', ''),
(39, 12, 49, 20, 1, '3', 'h', 'h', 'gh@f.f', 'empty', ''),
(40, 12, 50, 20, 1, '3', 'asdsad', 'asdasdasd', 'asdasdasd@sd.asd', 'empty', ''),
(41, 12, 54, 20, 1, '12', 'asdsad', 'asdasdasd', 'adasdad@ad.asd', 'empty', ''),
(42, 12, 55, 20, 1, '3', 'asdasdas', 'dasdasda', 'sdasdasdasd@sd.asd', 'empty', 'empty');

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
(20, 'Micron', '$2a$12$6DcFXiwhxaeTgBXEzTkpquHCt8kfhmzEUlcUqiDox.toBxIdZfJgW', '2018-07-24', 'AL', 'AG', 'asdsad', 'asdasdasda', 3033, '123131', 'ascasdadsad', 'mikesh07mail@gmail.com', 1, 'asdsadsad', 'adasdadasd', 'user', 'asdasdasd'),
(21, 'sdasdasd', '$2a$12$oozOXSluADkqa/8Hbn0h3uHJ1UwR8UxNUM7gVDCZ7XmPfITJFcxIO', '2018-07-24', 'AL', 'AG', 'asdsadasd', 'asdasdasd', 3033, '123213123', 'asdsadasd', 'asd@lo.com', 1, 'adasdasd', 'adadasd', '', ''),
(22, 'asdsadasd', '$2a$12$k49Go8woNy71FgC1vxv96./TJp07U4FxS2LUkDJT3klAI4lq0oweK', '2018-07-24', 'AG', 'AL', 'asdsadasd', 'asdasdasd', 5055, '12313', 'asdasdasd', 'asd@gmail.com', 1, 'asdsad', 'dasdsadad', '', ''),
(23, 'Gianni', '$2a$12$3aIx2slzORP9q/V3MPB.bOqU3Pg3maDEwyN34l1GuxMOJPRjSNDUu', '2018-07-15', 'AG', 'AL', 'aaa', 'aaa', 4444, '4444', '4444', 'davide.ubaldi17@gmail.com', 0, 'fasfasfasf', 'asdasdasd', 'empty', ''),
(24, 'catamarano', '$2a$12$TLo06N1XOkr8V2iJ07ERouT69C62y3E1Oth73ad8QmthL5P3.g4ii', '2018-09-07', 'AG', 'AL', 'aaa', 'ascccc', 4444, '11222', '1111', 'davide.ubaldi@outlook.it', 1, 'luzi', 'asdasdasd', 'user', 'asccc'),
(56, 'giacomo', '$2a$12$tpC0d.OsoUwzvyqmXlmWx.hOwL4t97cDz7MZZjhDIRkEYXIVHz.uq', '08/08/2018', 'AL', 'AL', 'asd', 'asdasd', 44444, '2222222', 'asd', 'azz@hotmail.it', 0, 'cacaca', 'asdasd', 'user', 'asddd'),
(57, 'Elisa', '$2a$12$8eJApav/TqV/JGLZ28aU9eTzCZ1FpsufyGfMYM7p/Mck.UclqllY6', '13/08/2018', 'AL', 'AG', ' ia dddddd', 'dasdasdasd', 63100, '32736964649', 'nesssuno', 'a@hotmail.it', 1, 'Giovanni', 'AgagagFAGAGA', 'user', 'fffff'),
(58, 'asdasdasd', '$2a$12$Ct10cZwpb/mnXVK6pb.tyOTos8o64YNe1IavaLfIXmokQayQFtU8y', '28/08/2018', 'AL', 'AL', 'asdasdasd', 'asdasdsadsa', 9077, '123123123', 'asdasdasdasd', 'dioc@a.ro', 1, 'asdasdasdas', 'asdasdasd', 'admin', 'asdasdad'),
(59, 'asdasdasd', '$2a$12$lRMAO3LCRiUiHmvqOGHKeuxltZVnZsyVDZToHhfn1dEyH.ZEORw.m', '06/09/2018', 'AG', 'AG', 'dasdasda', 'dasdasd', 45645, '123123123', 'asdasdasd', 'asdasdasd@asd.asd', 1, 'adasdas', 'dasdasdas', 'user', 'adasdasd'),
(60, 'Stefano', '$2a$12$UbEPL1S2aRU.M22nEVOSBOeCV69Z8TiFzj/1aP4xaxK9qlVKYEmR6', '26/07/1995', '-- Select --', '-- Select --', 'Via rondinella ', 'Arpino', 3033, '3343037176', 'Informatica', 'paoluccio545@gmail.com', 0, 'De Ciantis', 'dcnsfn95', 'user', 'Roma'),
(61, 'asdasdasd', '$2a$12$OO.DkTN1Sc1X8XhtvCx9OuSNmyAYYvg52w.ZD2qNZHC1XgFx4Npsy', '11/09/2018', 'AG', 'AG', 'dasdasd', 'adasdasd', 8088, '2342342', 'figa', 'adasd@loll.lol', 0, 'adasdas', 'asdasdas', 'user', 'asdasd'),
(62, 'asdasd', '$2a$12$KwijeTi4kWKmVabAbdU9QebCAq3BGBXovxHeID27YEllwmYpeK7JW', '12/09/2018', 'AL', 'AG', 'asdadas', 'dasdasd', 9866, '1212312312', 'asdasd', 'asdasdddd@asd.asd', 0, 'dasdad', 'adasdasd', 'user', 'asdasdas');

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
  MODIFY `azienda_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT per la tabella `notifica`
--
ALTER TABLE `notifica`
  MODIFY `id_notifica` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT per la tabella `offerta_tirocinio`
--
ALTER TABLE `offerta_tirocinio`
  MODIFY `offerta_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT per la tabella `richieste_tirocinio`
--
ALTER TABLE `richieste_tirocinio`
  MODIFY `richiesta_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT per la tabella `studente`
--
ALTER TABLE `studente`
  MODIFY `studente_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

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
