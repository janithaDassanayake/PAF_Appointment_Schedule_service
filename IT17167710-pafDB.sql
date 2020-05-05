-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 05, 2020 at 11:24 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `health-system`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment_scheduling`
--

CREATE TABLE `appointment_scheduling` (
  `Schedule_id` int(11) NOT NULL,
  `Date` varchar(30) DEFAULT NULL,
  `Start_Time` varchar(20) NOT NULL,
  `End_Time` varchar(20) NOT NULL,
  `D_id` int(11) NOT NULL,
  `H_id` int(11) NOT NULL,
  `App_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointment_scheduling`
--

INSERT INTO `appointment_scheduling` (`Schedule_id`, `Date`, `Start_Time`, `End_Time`, `D_id`, `H_id`, `App_id`) VALUES
(25, 'Monday', '23:59', '00:59', 2, 2, 1),
(31, 'Wednesday', '23:59', '23:59', 1, 1, 1),
(33, 'Sunday', '23:59', '23:59', 1, 1, 1),
(34, 'Sunday', '23:59', '23:59', 1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `appointment_type`
--

CREATE TABLE `appointment_type` (
  `appointment_Id` int(11) NOT NULL,
  `Appointment_Type` varchar(15) NOT NULL,
  `Appointment_Name` varchar(80) DEFAULT NULL,
  `Appointment_Desc` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointment_type`
--

INSERT INTO `appointment_type` (`appointment_Id`, `Appointment_Type`, `Appointment_Name`, `Appointment_Desc`) VALUES
(1, 'ENT', 'Common Ear Nose Throat', ' specifically perform these types of procedures eg Sinus surgery tonsil removal breathing surgery');

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `Doctor_Id` int(11) NOT NULL,
  `DoctorName` varchar(255) DEFAULT NULL,
  `NIC` varchar(15) DEFAULT NULL,
  `Address` varchar(250) DEFAULT NULL,
  `MobileNo` int(11) DEFAULT NULL,
  `Email` varchar(200) DEFAULT NULL,
  `Specialization` varchar(250) DEFAULT NULL,
  `HospitalName` varchar(250) DEFAULT NULL,
  `DepartmentName` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`Doctor_Id`, `DoctorName`, `NIC`, `Address`, `MobileNo`, `Email`, `Specialization`, `HospitalName`, `DepartmentName`) VALUES
(1, 'Dr . janitha Dassanayake', '123445v', 'ragama', 717936280, 'j@yahoo.com', 'ENT	', 'ASIRI', 'OPD'),
(2, 'Dr. Thilini Dureksha', '234566v', 'malabe', 7156813, 't@gmail.com', 'physiotherapy', 'Browns', 'Clinic'),
(3, 'Dr. praba Jayalath', '123456v', 'gampaha', 71782345, 'p@gmail.com', 'Eye', 'ASIRI', 'OPD');

-- --------------------------------------------------------

--
-- Table structure for table `hostpital`
--

CREATE TABLE `hostpital` (
  `hospital_Id` int(11) NOT NULL,
  `Hospital_Name` varchar(255) DEFAULT NULL,
  `Hospital_Address` varchar(100) DEFAULT NULL,
  `Hospital_City` varchar(100) DEFAULT NULL,
  `Hospital_Phone` char(10) DEFAULT NULL,
  `Hospital_Email` varchar(100) DEFAULT NULL,
  `Hospital_Description` varchar(1000) DEFAULT NULL,
  `Open_Hours` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hostpital`
--

INSERT INTO `hostpital` (`hospital_Id`, `Hospital_Name`, `Hospital_Address`, `Hospital_City`, `Hospital_Phone`, `Hospital_Email`, `Hospital_Description`, `Open_Hours`) VALUES
(1, 'ASIRI ', 'Colombo,TownHall', 'colombo', '0112278963', 'Asiri@gmail.com', 'Asiri Hospital', 24),
(2, 'Browns', 'Ragama,Mahabage', 'Ragama', '0112753214', 'Browns@gmail.com', 'Browns Hospital', NULL),
(3, 'Hemas Hospital', 'Wattala,Negambo Road', 'Wattala', '0112345678', 'Hemas@gmail.com', 'Hemas Hospital', 24);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment_scheduling`
--
ALTER TABLE `appointment_scheduling`
  ADD PRIMARY KEY (`Schedule_id`),
  ADD KEY `D_id` (`D_id`),
  ADD KEY `H_id` (`H_id`),
  ADD KEY `App_id` (`App_id`);

--
-- Indexes for table `appointment_type`
--
ALTER TABLE `appointment_type`
  ADD PRIMARY KEY (`appointment_Id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`Doctor_Id`);

--
-- Indexes for table `hostpital`
--
ALTER TABLE `hostpital`
  ADD PRIMARY KEY (`hospital_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment_scheduling`
--
ALTER TABLE `appointment_scheduling`
  MODIFY `Schedule_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT for table `appointment_type`
--
ALTER TABLE `appointment_type`
  MODIFY `appointment_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `Doctor_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `hostpital`
--
ALTER TABLE `hostpital`
  MODIFY `hospital_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment_scheduling`
--
ALTER TABLE `appointment_scheduling`
  ADD CONSTRAINT `appointment_scheduling_ibfk_1` FOREIGN KEY (`D_id`) REFERENCES `doctor` (`Doctor_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `appointment_scheduling_ibfk_2` FOREIGN KEY (`H_id`) REFERENCES `hostpital` (`hospital_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `appointment_scheduling_ibfk_3` FOREIGN KEY (`App_id`) REFERENCES `appointment_type` (`appointment_Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
