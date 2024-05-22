-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2024 at 07:50 PM
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
-- Table structure for table `docente`
--

CREATE TABLE `docente` (
  `cedula` int(11) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `profesion` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `docente`
--

INSERT INTO `docente` (`cedula`, `nombres`, `apellidos`, `profesion`) VALUES
(1, 'andrick', 'buitrago', 'profe'),
(2, 'asdas', 'asdas', 'asdas'),
(3, 'zoila', 'zoila', 'zoila'),
(4, 'camila', 'camila', 'camila');

-- --------------------------------------------------------

--
-- Table structure for table `equipocomputo`
--

CREATE TABLE `equipocomputo` (
  `numeroInventario` int(11) NOT NULL,
  `marca` varchar(45) NOT NULL,
  `capacidadDisco` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `equipocomputo`
--

INSERT INTO `equipocomputo` (`numeroInventario`, `marca`, `capacidadDisco`) VALUES
(0, 'hp', '512 GB'),
(1, 'asda', '512GB'),
(2, 'ferrari', '1024GB'),
(3, 'razer', '1024GB');

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
(3, '2024-05-20 21:52:58', 1, 1),
(4, '2024-05-20 23:34:37', 3, 3),
(5, '2024-05-20 23:52:19', 2, 2),
(6, '2024-05-20 23:54:35', 4, 3),
(7, '2024-05-21 22:23:54', 3, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `docente`
--
ALTER TABLE `docente`
  ADD PRIMARY KEY (`cedula`);

--
-- Indexes for table `equipocomputo`
--
ALTER TABLE `equipocomputo`
  ADD PRIMARY KEY (`numeroInventario`);

--
-- Indexes for table `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`consecutivo`),
  ADD KEY `fk_docenteCedula` (`docenteCedula`),
  ADD KEY `fk_numeroEquipo` (`numeroEquipo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `reserva`
--
ALTER TABLE `reserva`
  MODIFY `consecutivo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

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
