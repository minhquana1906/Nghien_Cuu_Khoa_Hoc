-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 07, 2024 at 04:04 PM
-- Server version: 8.0.36
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `onlinelearningdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `studentlist`
--

CREATE TABLE `studentlist` (
  `id` int NOT NULL,
  `username` varchar(100) NOT NULL,
  `classname` varchar(20) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `imagepath` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `studentlist`
--

INSERT INTO `studentlist` (`id`, `username`, `classname`, `password`, `imagepath`) VALUES
(111111111, 'New Student', 'CNTT', '$2a$12$.mvAO37r7EAdZ3QRoJP1s.ULIDRCXwd3GDNsmObzK.I1xqoRRB36i', NULL),
(222611080, 'Trần Tiến Dũng', 'CNTT VA2', '$2a$12$7qeNnD7BFxV8X7qqdaxXtOFniUxWQoW3djE3/Aje9pch1D0E81gra', 'TranTienDung_222611080.png'),
(222631105, 'Vũ Quang Huy', 'CNTT VA1', '$2a$12$XKy8EjNxL0pj0SNgT.NRyeyq2LfxY0vo3MJpFEcICiswXDhu5A8cy', 'VuQuangHuy_222631105.png'),
(222631124, 'Nguyễn Minh', 'CNTT VA2', '$2a$12$6d7lmgB/e6rTiUzHAvXb4.v94ag8YLG5pHVZI31SIz0ls7oURmJRu', 'NguyenMinh_222631124.png'),
(222631132, 'Nguyễn Minh Quân', 'CNTT VA1', '$2a$12$zam/9xwvdEl8THdEegA17eb9.bO/AjhdEHRm2JU2Ahq0jSfz6y./G', 'NguyenMinhQuan_222631132.png'),
(222631141, 'Nguyễn Mai Thanh', 'CNTT VA2', '$2a$12$XsXsAxo4xgDCw8.pIcu1p.y7Ia/mSbzXOQDoGIExrQ3Eh.1dsO5pm', 'NguyenMaiThanh_222631141.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `studentlist`
--
ALTER TABLE `studentlist`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
