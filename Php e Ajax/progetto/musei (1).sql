-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 26, 2020 alle 14:52
-- Versione del server: 10.4.8-MariaDB
-- Versione PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `musei`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `contattaci`
--

CREATE TABLE `contattaci` (
  `id_richiesta` int(10) NOT NULL,
  `mail` text NOT NULL,
  `messaggio` text NOT NULL,
  `data` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Struttura della tabella `musei`
--

CREATE TABLE `musei` (
  `id_museo` int(10) NOT NULL,
  `nome` text NOT NULL,
  `descrizione` text NOT NULL,
  `costo` float NOT NULL,
  `apertura` text NOT NULL,
  `chiusura` text NOT NULL,
  `immagine` text NOT NULL,
  `attivo` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `musei`
--

INSERT INTO `musei` (`id_museo`, `nome`, `descrizione`, `costo`, `apertura`, `chiusura`, `immagine`, `attivo`) VALUES
(1, 'Duomo di Milano', 'Il Duomo di Milano è la cattedrale dell\'arcidiocesi di Milano. Simbolo del capoluogo lombardo, e situato nell\'omonima piazza al centro della metropoli, è dedicata a Santa Maria Nascente. È la chiesa più grande d\'Italia, la quarta nel mondo per superficie, la sesta per volume. ', 6.9, '10:00', '18:00', 'duomo.jpg', 't'),
(2, 'Castello Sforzesco', 'Il Castello Sforzesco è un grande complesso fortificato che sorge a Milano poco fuori il centro storico della città. Fu eretto nel XV secolo da Francesco Sforza, divenuto da poco Duca di Milano, sui resti di una precedente fortificazione medievale del XIV secolo nota come Castello di Porta Giovia.', 4.9, '7:00', '19:30', 'castello_sforzesco.jpg', 't'),
(3, 'Teatro alla Scala', 'Il Teatro alla Scala, citato solitamente in maniera informale come la Scala, è il principale teatro d\'opera di Milano. Considerato tra i più prestigiosi teatri al mondo, ospita da 242 anni i principali artisti nel campo internazionale dell\'opera, e, più in generale, della musica classica.', 14.9, '15:00', '23:00', 'la_scala.jpg', 't'),
(4, 'Parco Sempione', 'Il Parco Sempione è una zona verde della città di Milano. Realizzato a fine Ottocento sull\'area già occupata dalla Piazza d\'armi, occupa un\'area di 386 000 m², completamente cintata e videosorvegliata. Il nome deriva dal corso Sempione, il monumentale asse stradale realizzato in età napoleonica sul tracciato della storica via del Seprio, con la nuova porta Sempione erede dell\'antica porta Giovia.', 3, '6:30', '21:00', 'parco_sempione.jpg', 't'),
(5, 'Museo della scienza ', 'Il Museo nazionale della scienza e della tecnologia \"Leonardo da Vinci\" ha sede a Milano; aperto nel 1953, con i suoi 50.000m² complessivi è il più ampio museo tecnico-scientifico in Italia e uno dei maggiori in Europa. Possiede la più grande collezione al mondo di modelli di macchine realizzati a partire da disegni di Leonardo da Vinci. È visitato da 500.000 persone all\'anno.\r\n\r\nLe collezioni contano 16.000 beni storici e includono testimonianze rappresentative della storia della scienza, della tecnologia e dell\'industria italiane dal XIX secolo ai giorni nostri. Nei suoi 13 laboratori interattivi si svolgono attività che seguono il metodo educativo basato sull\'educazione informale.\r\n\r\nIl museo è dal 2000 una fondazione di diritto privato, i cui soci fondatori sono il Ministero dell\'istruzione, dell\'università e della ricerca e il Ministero dei beni e delle attività culturali e del turismo; i partecipanti sostenitori sono Regione Lombardia, Comune di Milano, Camera di commercio, industria, artigianato e agricoltura di Milano; le principali università milanesi fanno parte del consiglio scientifico.\r\n\r\nIl museo è collocato in via San Vittore 21 nell\'antico monastero di San Vittore al Corpo, a fianco alla chiesa omonima, nelle vicinanze del luogo dove Leonardo possedeva alcuni terreni coltivati a vigna, all\'epoca appena fuori le mura cittadine. È anche non lontano dalla chiesa di Santa Maria delle Grazie, dove si trova il celebre Cenacolo, e dalla Basilica di Sant\'Ambrogio.', 7, '9:30', '18:00', 'museo_scienza.jpeg', 't'),
(6, 'Basilica di Sant\'Ambrogio', 'La basilica di Sant\'Ambrogio, il cui nome completo è basilica romana minore collegiata abbaziale prepositurale di Sant\'Ambrogio (nome originario paleocristiano basilica martyrum), è una delle più antiche chiese di Milano e si trova in piazza Sant\'Ambrogio. Essa rappresenta ad oggi non solo un monumento dell\'epoca paleocristiana e medievale, ma anche un punto fondamentale della storia milanese e della Chiesa ambrosiana. Essa è tradizionalmente considerata la seconda chiesa per importanza della città di Milano.', 2, '7:00', '22:00', 'sant_ambrogio.jpg', 't');

-- --------------------------------------------------------

--
-- Struttura della tabella `recensioni`
--

CREATE TABLE `recensioni` (
  `id_recensione` int(10) NOT NULL,
  `mail` text NOT NULL,
  `nome` text NOT NULL,
  `museo` text NOT NULL,
  `recensione` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `recensioni`
--

INSERT INTO `recensioni` (`id_recensione`, `mail`, `nome`, `museo`, `recensione`) VALUES
(1, 'rubentenderini@gmail.com', 'admin', 'scala', 'werwefefsdwfwers'),
(2, 'rubentenderini@gmail.com', 'admin', 'scala', 'asdasdasdad'),
(3, 'rubentenderini@gmail.com', 'Coppia di pneumatici cross', 'scala', 'asdasdasdfdfgfeefdacscee'),
(4, 'rubentenderini@gmail.com', 'scarico scalvini 125-250', 'asdadadsasd', 'asdasdasda'),
(5, 'asdasddasdaq@awaas.k', 'Rub', 'asdasdasd', 'asdasdasdasdfwfgwefw'),
(6, 'rubentenderini@gmail.com', 'Coppia di pneumatici enduro', 'scala', 'asddasdasdasdfvvvv'),
(7, 'www.gabbo@gmail.com', 'gabboy', 'scala', 'ossososos'),
(8, 'rubentenderini@gmail.com', 'Ruben', 'scala', 'asdasdasdasda'),
(9, 'rubentenderini@gmail.com', 'Ruben', 'Duomo', 'Guida gentile, costo non troppo elevato, struttura magnifica. Consigliato'),
(10, 'asdasddasdaq@awaas.k', 'admin', 'scala', 'asdasdasdasdasdafdfcsdfcvrfvebv'),
(11, 'www.gabbo@gmail.com', 'Vale', 'Duomo', 'Ciao è stato');

-- --------------------------------------------------------

--
-- Struttura della tabella `tickets`
--

CREATE TABLE `tickets` (
  `id_ticket` int(255) NOT NULL,
  `id_user` int(255) DEFAULT NULL,
  `id_museo` int(10) NOT NULL,
  `codice` text NOT NULL,
  `data_acquisto` date NOT NULL,
  `convalidato` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `tickets`
--

INSERT INTO `tickets` (`id_ticket`, `id_user`, `id_museo`, `codice`, `data_acquisto`, `convalidato`) VALUES
(2, 1, 1, 'abcde', '0000-00-00', 't'),
(3, 2, 1, 'jukvE', '0000-00-00', 't'),
(4, 2, 1, 'e8UhP', '2020-01-16', 'f'),
(5, 2, 1, 'aw5Qg', '2020-01-16', 't'),
(6, 2, 1, 'qFgBB', '2020-01-17', 'f'),
(18, 2, 1, 'mGaNx', '2020-01-26', 'f');

-- --------------------------------------------------------

--
-- Struttura della tabella `users`
--

CREATE TABLE `users` (
  `id_user` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dump dei dati per la tabella `users`
--

INSERT INTO `users` (`id_user`, `nome`, `cognome`, `mail`, `password`) VALUES
(2, 'Ruben', 'Tenderini', 'rubentenderini@gmail.com', '$2y$10$Ln9j36JTRpTEo/fwME78BeV6bvUN1ZcV6Kf1wsV0o2VLWON6vhveW'),
(1, 'gabbuz', 'ciao', 'rubentenderini@gailÃ².lo', '$2y$10$GjLLkNNkOv/zw8/wffq7ZORu81nDBDmMoPNAdfhLfv.F.Pxei8yhq');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `musei`
--
ALTER TABLE `musei`
  ADD PRIMARY KEY (`id_museo`);

--
-- Indici per le tabelle `recensioni`
--
ALTER TABLE `recensioni`
  ADD PRIMARY KEY (`id_recensione`);

--
-- Indici per le tabelle `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id_ticket`),
  ADD KEY `user` (`id_user`),
  ADD KEY `MUSEO` (`id_museo`);

--
-- Indici per le tabelle `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `recensioni`
--
ALTER TABLE `recensioni`
  MODIFY `id_recensione` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT per la tabella `tickets`
--
ALTER TABLE `tickets`
  MODIFY `id_ticket` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT per la tabella `users`
--
ALTER TABLE `users`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
