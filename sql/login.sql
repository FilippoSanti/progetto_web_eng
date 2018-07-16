-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2018 at 10:28 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

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
-- Table structure for table `azienda`
--

CREATE TABLE `azienda` (
  `azienda_id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `nome` varchar(30) NOT NULL,
  `ragione sociale` varchar(100) NOT NULL,
  `indirizzo_sede_legale` varchar(100) NOT NULL,
  `cf_rappresentante` varchar(30) NOT NULL,
  `partita_iva_rappresentante` varchar(50) NOT NULL,
  `nome_cognome_rappresentante` varchar(30) NOT NULL,
  `nome_cognome_Rtirocini` varchar(60) NOT NULL,
  `telefono_RTirocini` varchar(20) NOT NULL,
  `email_RTirocini` varchar(40) NOT NULL,
  `foro_competente` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `azienda`
--

INSERT INTO `azienda` (`azienda_id`, `username`, `nome`, `ragione sociale`, `indirizzo_sede_legale`, `cf_rappresentante`, `partita_iva_rappresentante`, `nome_cognome_rappresentante`, `nome_cognome_Rtirocini`, `telefono_RTirocini`, `email_RTirocini`, `foro_competente`) VALUES
(1, 'davideub', 'Gianni', 'studio del pene', 'la mecca', 'no', 'si', 'giNNI LUZI', 'Gianni Luzi', 'Gianni Luzi', 'Gianni Luzi email', 'roma');

-- --------------------------------------------------------

--
-- Table structure for table `offerta_tirocinio`
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
-- Dumping data for table `offerta_tirocinio`
--

INSERT INTO `offerta_tirocinio` (`offerta_tirocinio_id`, `luogo`, `orari`, `ore`, `obiettivi`, `modalita`, `rimborsi_spese_facilitazioni_previste`) VALUES
(1, 'casa di peppe', '12-14 20-22', '55', 'succhiare', 'seduti', 'nessuna stronzo'),
(2, 'casa di peppe', '12-14 20-22', '55', 'succhiare', 'seduti', 'nessuna stronzo'),
(3, 'casa di peppe', '12-14 20-22', '55', 'succhiare', 'seduti', 'nessuna stronzo');

-- --------------------------------------------------------

--
-- Table structure for table `studente`
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
  `handicap` varchar(30) NOT NULL,
  `cognome` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `studente`
--

INSERT INTO `studente` (`studente_id`, `nome`, `password`, `date`, `provincia`, `provincia_nascita`, `residenza`, `citta`, `CAP`, `telefono`, `corso`, `email`, `handicap`, `cognome`) VALUES
(1, 'test', 'test', '0000-00-00', '', '', '', '', 0, '0', '', '', '0', ''),
(2, 'test2', '$2a$10$NSce6Pd5dhuI7PHE/g8HXeQ9e4w.G5CsCU7juAt0XHq1w0sLpX1SG', '0000-00-00', '', '', '', '', 0, '0', '', '', '0', ''),
(3, 'test4', 'test5', '0000-00-00', '', '', '', '', 0, '0', '', '', '0', ''),
(4, 'asd', 'asd1', '0000-00-00', '', '', '', '', 0, '0', '', '', '0', ''),
(5, 'lol1', '$2a$12$V7uykaw0sOzwJ38Y9t5xf.srCS2xIe6fit1MDfmjIWA8upj7WEjo2', '0000-00-00', '', '', '', '', 0, '0', '', '', '0', ''),
(6, 'cane', '$2a$12$9wvYSc.XmkvTEaZIGGU/euZBRaaJ.IGTBy.hf.Cun5Icfpbu89LWi', '1911-11-11', '', '', '', '', 0, '0', '', '', '0', ''),
(7, 'giovanni', '$2a$12$nfZbebzwzph7zk/E3xIERuthJKWERkluoxAnVBOwpdBz2OF5PipDO', '1911-11-11', 'Ascoli Piceno', 'Ascoli Piceno', 'Ascoli Piceno', 'Ascoli Piceno', 63100, '3273233232', 'ingegneria dello stefano', 'laurettats545@gmail.com', '0', 'Jhonny'),
(8, 'giacomo', '$2a$12$XMccg2Epq3RLditk6OPK6OHStTeasr9uayP0WyUNA7/4pfdD.YV2e', '1122-11-11', 'giacomo', 'giacomo', 'giacomo', 'giacomo', 64444, '64444', 'giacomo', 'giacomo', '0', 'giacomo'),
(9, 'Gianni', '$2a$12$I2/YScE2pNZ9Sve0jxrgQ.CpZysvHlwHxrlxRxp8ZHr.rmLLkfXTK', '1111-11-11', 'aaa', 'aaa', 'aaa', 'aaa', 4444, '4444', '4444', '4444', '0', 'luzi'),
(11, '2', '3', '0000-00-00', '5', '6', '7', '8', 9, '10', '11', '12', '13', '14'),
(12, '2', '3', '0000-00-00', '5', '6', '7', '8', 9, '10', '11', '12', '13', '14'),
(13, 'Gianni', '$2a$12$zqOaBy67ddQWDGSTJQ4umOZdXHRG7o37UuikhMD7.rsElCp146Ecy', '1111-11-11', 'asd', 'asd', 'asd', 'asd', 4444, '4444', '4444', 'davide.ubaldi@outlook.it', 'si', 'luzi');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `azienda`
--
ALTER TABLE `azienda`
  ADD PRIMARY KEY (`azienda_id`);

--
-- Indexes for table `offerta_tirocinio`
--
ALTER TABLE `offerta_tirocinio`
  ADD PRIMARY KEY (`offerta_tirocinio_id`);

--
-- Indexes for table `studente`
--
ALTER TABLE `studente`
  ADD PRIMARY KEY (`studente_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `azienda`
--
ALTER TABLE `azienda`
  MODIFY `azienda_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `offerta_tirocinio`
--
ALTER TABLE `offerta_tirocinio`
  MODIFY `offerta_tirocinio_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `studente`
--
ALTER TABLE `studente`
  MODIFY `studente_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
