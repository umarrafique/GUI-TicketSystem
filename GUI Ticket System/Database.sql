-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.26-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table gui.tickets
CREATE TABLE IF NOT EXISTS `tickets` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(250) NOT NULL,
  `Type` varchar(50) NOT NULL,
  `Assigned to` varchar(50) NOT NULL,
  `Epoch Open` int(50) NOT NULL,
  `Epoch Close` int(50) DEFAULT NULL,
  `Cost` int(11) NOT NULL DEFAULT '50',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- Dumping data for table gui.tickets: ~15 rows (approximately)
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` (`Id`, `Description`, `Type`, `Assigned to`, `Epoch Open`, `Epoch Close`, `Cost`) VALUES
	(2, '', 'wec', '', 0, NULL, 50),
	(4, '', 'gc', '', 0, 77573, 50),
	(5, '', 'a', '', 0, 1512320038, 50),
	(6, '', '', '', 1512318004, 1512342696, 50),
	(8, '', '', '', 1512318412, 1512382751, 50),
	(10, '', 'Normal', '', 1512339468, 1512490575, 50),
	(11, '', 'Urgent', '', 1512339850, NULL, 50),
	(12, '', 'Urgent', '', 1512340030, NULL, 50),
	(14, '', 'Long Term', '', 1512340605, 1512341481, 50),
	(16, '', 'Urgent', 'John', 1512341938, NULL, 50),
	(17, 'very important ', 'Urgent', 'James', 1512493408, NULL, 50),
	(18, 'dsg', '', '', 0, NULL, 50),
	(19, 'fdjfdjkt', '', '', 0, NULL, 50),
	(20, 'fhkyt', '', '', 0, NULL, 50),
	(21, 'once more', '', '', 0, NULL, 50),
	(22, 'Got a new ticket', 'Normal', 'Johan', 1513367927, NULL, 50);
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;

-- Dumping structure for table gui.users
CREATE TABLE IF NOT EXISTS `users` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

-- Dumping data for table gui.users: ~24 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`Id`, `username`, `password`, `type`) VALUES
	(1, 'us', 'pw', 'manager'),
	(2, 'tech', 'tech', 'tech'),
	(3, 'system', 'system', 'admin'),
	(4, 'Umar', 'rafique', 'sa'),
	(5, 'Umar', 'no', 'ok'),
	(6, 'Umar', 'no', 'ok'),
	(7, 'Umar', 'no', 'ok'),
	(8, 'gilgw', 'cew,jbje', 'b,jbvev'),
	(9, 'Umar', '1234', 'ok'),
	(10, 'new', 'pass', ''),
	(11, 'NEW', 'PASS', ''),
	(12, '', '', ''),
	(13, 'New ', 'Pass', 'no'),
	(14, '', '', ''),
	(15, '', '', ''),
	(16, 'UMAR', 'PW', 'NEW'),
	(17, 'Umar', 'PASS', 'OK'),
	(18, 'vuyg', 'cwc', ''),
	(19, '', '', 'Admin'),
	(20, 'Admin', 'Admin', 'Admin'),
	(21, 'Tech', 'Tech', 'Tech Support'),
	(22, 'Manager', 'Manager', 'Manager'),
	(23, 'yvftfv', 'tfctfc', 'Manager'),
	(24, 'Gustavo', 'pass', 'Manager'),
	(25, 'Pedro1', 'pass', 'Admin'),
	(26, 'Mansoor', 'pass', 'Tech Support');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
