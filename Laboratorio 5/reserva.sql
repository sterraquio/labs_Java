-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2024 at 05:50 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.1.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `reservaequipos`
--

-- --------------------------------------------------------

--
-- Table structure for table `reserva`
--

CREATE TABLE `reserva` (
  `consecutivo` int(11) NOT NULL,
  `fechaReserva` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `docenteCedula` int(11) NOT NULL,
  `numeroEquipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reserva`
--

INSERT INTO `reserva` (`consecutivo`, `fechaReserva`, `docenteCedula`, `numeroEquipo`) VALUES
(1, '2024-05-18 03:24:07', 1, 0),
(2, '2024-05-18 03:45:59', 1, 1),
(5, '2024-05-18 03:49:42', 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`consecutivo`),
  ADD KEY `fk_docenteCedula` (`docenteCedula`),
  ADD KEY `fk_numeroEquipo` (`numeroEquipo`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `reserva`
--
ALTER TABLE `reserva`
  ADD CONSTRAINT `fk_docenteCedula` FOREIGN KEY (`docenteCedula`) REFERENCES `docente` (`cedula`),
  ADD CONSTRAINT `fk_numeroEquipo` FOREIGN KEY (`numeroEquipo`) REFERENCES `equipocomputo` (`numeroInventario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
