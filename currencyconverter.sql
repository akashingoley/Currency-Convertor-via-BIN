-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 20, 2022 at 01:59 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `currencyconverter`
--

-- --------------------------------------------------------

--
-- Table structure for table `binlookup`
--

CREATE TABLE `binlookup` (
  `id` bigint(20) NOT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `card_number` bigint(20) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `currency` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `scheme` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `binlookup`
--

INSERT INTO `binlookup` (`id`, `brand`, `card_number`, `country`, `currency`, `date`, `scheme`, `type`) VALUES
(1, 'World', 51815903, 'India', 'INR', '2022-02-20', 'mastercard', 'credit'),
(31, 'World', 51815903, 'India', 'INR', '2022-02-20', 'mastercard', 'credit'),
(32, 'World', 51815903, 'India', 'INR', '2022-02-20', 'mastercard', 'credit'),
(39, 'World', 51815903, 'India', 'INR', '2022-02-20', 'mastercard', 'credit'),
(41, 'World', 51815901, 'India', 'INR', '2022-02-20', 'mastercard', 'credit');

-- --------------------------------------------------------

--
-- Table structure for table `conversion`
--

CREATE TABLE `conversion` (
  `id` bigint(20) NOT NULL,
  `card_number` bigint(20) DEFAULT NULL,
  `converted_amount` double DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `exchange_rate` double DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `from_currency` varchar(255) DEFAULT NULL,
  `to_currency` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `conversion`
--

INSERT INTO `conversion` (`id`, `card_number`, `converted_amount`, `country`, `date`, `exchange_rate`, `amount`, `from_currency`, `to_currency`) VALUES
(24, 51815903, 58820.9, 'India', '2022-02-20', 58.8209, 1000, 'CAD', 'INR'),
(25, 51815903, 58820.9, 'India', '2022-02-20', 58.8209, 1000, 'CAD', 'INR'),
(26, 51815903, 33938.24, 'India', '2022-02-20', 84.8456, 400, 'EUR', 'INR'),
(27, 51815903, 13764.09, 'India', '2022-02-20', 58.8209, 234, 'CAD', 'INR'),
(34, 51815903, 556.569, 'India', '2022-02-20', 55.657, 10, 'SGD', 'INR'),
(37, 51815903, 649.1, 'India', '2022-02-20', 0.6491, 1000, 'JPY', 'INR'),
(38, 51815903, 710593.8, 'India', '2022-02-20', 101.5134, 7000, 'GBP', 'INR'),
(40, 51815903, 74777.2, 'India', '2022-02-20', 74.7772, 1000, 'USD', 'INR');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(43);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `binlookup`
--
ALTER TABLE `binlookup`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `conversion`
--
ALTER TABLE `conversion`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
