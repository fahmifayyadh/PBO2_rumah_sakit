-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2019 at 11:15 PM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rekammedis`
--

-- --------------------------------------------------------

--
-- Table structure for table `golongan_darah`
--

CREATE TABLE `golongan_darah` (
  `ID_goldar` int(100) NOT NULL,
  `jenis_darah` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `golongan_darah`
--

INSERT INTO `golongan_darah` (`ID_goldar`, `jenis_darah`) VALUES
(1, 'a'),
(2, 'b');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_kelamin`
--

CREATE TABLE `jenis_kelamin` (
  `ID_jk` int(100) NOT NULL,
  `jenis` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis_kelamin`
--

INSERT INTO `jenis_kelamin` (`ID_jk`, `jenis`) VALUES
(1, 'laki-laki'),
(2, 'perempuan');

-- --------------------------------------------------------

--
-- Table structure for table `jenis_user`
--

CREATE TABLE `jenis_user` (
  `ID_jenis` int(100) NOT NULL,
  `jenis` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis_user`
--

INSERT INTO `jenis_user` (`ID_jenis`, `jenis`) VALUES
(1, 'admin'),
(2, 'operator');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `ID_User` int(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(20) NOT NULL,
  `ID_jenis` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID_User`, `username`, `password`, `ID_jenis`) VALUES
(1, 'fahmi', '123', 1),
(2, 'fayyadh', '123', 2);

-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE `obat` (
  `ID_obat` int(100) NOT NULL,
  `obat` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `ID_pasien` int(100) NOT NULL,
  `ID_jk` int(100) NOT NULL,
  `ID_goldar` int(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `nik` varchar(50) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `umur` varchar(10) NOT NULL,
  `noTelp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `penyakit`
--

CREATE TABLE `penyakit` (
  `ID_penyakit` int(100) NOT NULL,
  `nama_penyakit` varchar(100) NOT NULL,
  `Gejala` varchar(100) NOT NULL,
  `Riwayat` varchar(100) NOT NULL,
  `Pantangan` varchar(100) NOT NULL,
  `riwayat_obat` varchar(100) NOT NULL,
  `ID_obat` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `penyakit_pasien`
--

CREATE TABLE `penyakit_pasien` (
  `ID_penyakitpasien` int(100) NOT NULL,
  `ID_pasien` int(100) NOT NULL,
  `ID_penyakit` int(100) NOT NULL,
  `waktu` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `golongan_darah`
--
ALTER TABLE `golongan_darah`
  ADD PRIMARY KEY (`ID_goldar`);

--
-- Indexes for table `jenis_kelamin`
--
ALTER TABLE `jenis_kelamin`
  ADD PRIMARY KEY (`ID_jk`);

--
-- Indexes for table `jenis_user`
--
ALTER TABLE `jenis_user`
  ADD PRIMARY KEY (`ID_jenis`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`ID_User`),
  ADD KEY `ID_jenis` (`ID_jenis`);

--
-- Indexes for table `obat`
--
ALTER TABLE `obat`
  ADD PRIMARY KEY (`ID_obat`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`ID_pasien`),
  ADD KEY `ID_jk` (`ID_jk`),
  ADD KEY `ID_goldar` (`ID_goldar`);

--
-- Indexes for table `penyakit`
--
ALTER TABLE `penyakit`
  ADD PRIMARY KEY (`ID_penyakit`),
  ADD KEY `ID_obat` (`ID_obat`);

--
-- Indexes for table `penyakit_pasien`
--
ALTER TABLE `penyakit_pasien`
  ADD PRIMARY KEY (`ID_penyakitpasien`),
  ADD KEY `ID_pasien` (`ID_pasien`),
  ADD KEY `ID_penyakit` (`ID_penyakit`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `golongan_darah`
--
ALTER TABLE `golongan_darah`
  MODIFY `ID_goldar` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `jenis_kelamin`
--
ALTER TABLE `jenis_kelamin`
  MODIFY `ID_jk` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `jenis_user`
--
ALTER TABLE `jenis_user`
  MODIFY `ID_jenis` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `ID_User` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `obat`
--
ALTER TABLE `obat`
  MODIFY `ID_obat` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `penyakit`
--
ALTER TABLE `penyakit`
  MODIFY `ID_penyakit` int(100) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `penyakit_pasien`
--
ALTER TABLE `penyakit_pasien`
  MODIFY `ID_penyakitpasien` int(100) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `login_ibfk_1` FOREIGN KEY (`ID_jenis`) REFERENCES `jenis_user` (`ID_jenis`);

--
-- Constraints for table `pasien`
--
ALTER TABLE `pasien`
  ADD CONSTRAINT `pasien_ibfk_1` FOREIGN KEY (`ID_jk`) REFERENCES `jenis_kelamin` (`ID_jk`),
  ADD CONSTRAINT `pasien_ibfk_2` FOREIGN KEY (`ID_goldar`) REFERENCES `golongan_darah` (`ID_goldar`);

--
-- Constraints for table `penyakit`
--
ALTER TABLE `penyakit`
  ADD CONSTRAINT `penyakit_ibfk_1` FOREIGN KEY (`ID_obat`) REFERENCES `obat` (`ID_obat`);

--
-- Constraints for table `penyakit_pasien`
--
ALTER TABLE `penyakit_pasien`
  ADD CONSTRAINT `penyakit_pasien_ibfk_1` FOREIGN KEY (`ID_pasien`) REFERENCES `pasien` (`ID_pasien`),
  ADD CONSTRAINT `penyakit_pasien_ibfk_2` FOREIGN KEY (`ID_penyakit`) REFERENCES `penyakit` (`ID_penyakit`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
