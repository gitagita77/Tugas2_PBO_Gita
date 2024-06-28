-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 27, 2024 at 02:13 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gita_2210010187`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_jadwal`
--

CREATE TABLE `tb_jadwal` (
  `id_jadwal` int NOT NULL,
  `tanggal` date NOT NULL,
  `jam` time NOT NULL,
  `nama_kegiatan` varchar(150) NOT NULL,
  `id_pendataan` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_kecamatan`
--

CREATE TABLE `tb_kecamatan` (
  `id_kecamatan` int NOT NULL,
  `nm_kecamatan` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kecamatan`
--

INSERT INTO `tb_kecamatan` (`id_kecamatan`, `nm_kecamatan`) VALUES
(1, 'Kecamatan A'),
(2, 'Kecamatan B');

-- --------------------------------------------------------

--
-- Table structure for table `tb_kelurahan`
--

CREATE TABLE `tb_kelurahan` (
  `id_kelurahan` int NOT NULL,
  `id_kecamatan` int NOT NULL,
  `nm_kelurahan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kelurahan`
--

INSERT INTO `tb_kelurahan` (`id_kelurahan`, `id_kecamatan`, `nm_kelurahan`) VALUES
(1, 1, 'Kelurahan B'),
(2, 1, 'Kelurahan B');

-- --------------------------------------------------------

--
-- Table structure for table `tb_komoditas`
--

CREATE TABLE `tb_komoditas` (
  `id_komoditas` int NOT NULL,
  `kategori` varchar(150) NOT NULL,
  `jenis_ternak` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_pendataan`
--

CREATE TABLE `tb_pendataan` (
  `id` int NOT NULL,
  `id_komoditas` int NOT NULL,
  `tgl` date NOT NULL,
  `nik` bigint NOT NULL,
  `npwp` bigint NOT NULL,
  `nama` varchar(150) NOT NULL,
  `alamat` text NOT NULL,
  `asal` varchar(150) NOT NULL,
  `jumlah_ternak` int NOT NULL,
  `kec` varchar(150) NOT NULL,
  `kel` varchar(150) NOT NULL,
  `jalan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_pendataan`
--

INSERT INTO `tb_pendataan` (`id`, `id_komoditas`, `tgl`, `nik`, `npwp`, `nama`, `alamat`, `asal`, `jumlah_ternak`, `kec`, `kel`, `jalan`) VALUES
(1, 1, '2024-07-01', 22222, 292929, 'Gita', 'Jl. Sungai Miai', 'Batu Licin', 10, 'Dadahup', 'Kadatahu', 'jl. manggis'),
(2, 1, '2024-06-07', 123456789, 12345, 'John Doe', 'Jl. Kebon Jeruk', 'Kebumen', 50, 'Kebon', 'Jeruk', 'Jalan Jeruk');

-- --------------------------------------------------------

--
-- Table structure for table `tb_perkembangan`
--

CREATE TABLE `tb_perkembangan` (
  `id_perkembangan` int NOT NULL,
  `id_skala` int NOT NULL,
  `id_pendataan` int NOT NULL,
  `tgl_perkembangan` date NOT NULL,
  `jml_a_dws_jntn` int NOT NULL,
  `jml_a_dws_btn` int NOT NULL,
  `jml_a_dara_jntn` int NOT NULL,
  `jml_a_dara_btn` int NOT NULL,
  `jml_a_anak_jntn` int NOT NULL,
  `jml_a_anak_btn` int NOT NULL,
  `tujuan` varchar(150) NOT NULL,
  `jumlah_keluar` int NOT NULL,
  `ket_perkembangan` text NOT NULL,
  `id_user` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_permasalahan`
--

CREATE TABLE `tb_permasalahan` (
  `id_permasalahan` int NOT NULL,
  `id_user` int NOT NULL,
  `tgl_permasalahan` date NOT NULL,
  `permasalahan` text NOT NULL,
  `solusi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_permasalahan`
--

INSERT INTO `tb_permasalahan` (`id_permasalahan`, `id_user`, `tgl_permasalahan`, `permasalahan`, `solusi`) VALUES
(1, 1, '2024-06-06', 'kada', 'pg'),
(2, 2, '2024-06-06', 'Kada', 'jua'),
(3, 4, '2004-02-01', 'Kada tahu ', 'Solusi nya kadada');

-- --------------------------------------------------------

--
-- Table structure for table `tb_skala`
--

CREATE TABLE `tb_skala` (
  `id_skala` int NOT NULL,
  `id_komoditas` int NOT NULL,
  `jenis_usaha` varchar(150) NOT NULL,
  `skala_usaha` varchar(150) NOT NULL,
  `ket_skala` text NOT NULL,
  `masa_pendataan` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_tandabukti`
--

CREATE TABLE `tb_tandabukti` (
  `id_tandabukti` int NOT NULL,
  `id_pendataan` int NOT NULL,
  `nomor` varchar(150) NOT NULL,
  `tanggal` date NOT NULL,
  `jml_dws_jntn` int NOT NULL,
  `jml_dws_btn` int NOT NULL,
  `jml_dara_jntn` int NOT NULL,
  `jml_dara_btn` int NOT NULL,
  `jml_anak_jntn` int NOT NULL,
  `jml_anak_btn` int NOT NULL,
  `ket_tandabukti` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int NOT NULL,
  `username` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `level` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `uji`
--

CREATE TABLE `uji` (
  `nik` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `alamat` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_jadwal`
--
ALTER TABLE `tb_jadwal`
  ADD PRIMARY KEY (`id_jadwal`);

--
-- Indexes for table `tb_kecamatan`
--
ALTER TABLE `tb_kecamatan`
  ADD PRIMARY KEY (`id_kecamatan`);

--
-- Indexes for table `tb_kelurahan`
--
ALTER TABLE `tb_kelurahan`
  ADD PRIMARY KEY (`id_kelurahan`);

--
-- Indexes for table `tb_komoditas`
--
ALTER TABLE `tb_komoditas`
  ADD PRIMARY KEY (`id_komoditas`);

--
-- Indexes for table `tb_pendataan`
--
ALTER TABLE `tb_pendataan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tb_perkembangan`
--
ALTER TABLE `tb_perkembangan`
  ADD PRIMARY KEY (`id_perkembangan`);

--
-- Indexes for table `tb_permasalahan`
--
ALTER TABLE `tb_permasalahan`
  ADD PRIMARY KEY (`id_permasalahan`);

--
-- Indexes for table `tb_skala`
--
ALTER TABLE `tb_skala`
  ADD PRIMARY KEY (`id_skala`);

--
-- Indexes for table `tb_tandabukti`
--
ALTER TABLE `tb_tandabukti`
  ADD PRIMARY KEY (`id_tandabukti`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `uji`
--
ALTER TABLE `uji`
  ADD PRIMARY KEY (`nik`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_jadwal`
--
ALTER TABLE `tb_jadwal`
  MODIFY `id_jadwal` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_kecamatan`
--
ALTER TABLE `tb_kecamatan`
  MODIFY `id_kecamatan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tb_kelurahan`
--
ALTER TABLE `tb_kelurahan`
  MODIFY `id_kelurahan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tb_komoditas`
--
ALTER TABLE `tb_komoditas`
  MODIFY `id_komoditas` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tb_pendataan`
--
ALTER TABLE `tb_pendataan`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tb_permasalahan`
--
ALTER TABLE `tb_permasalahan`
  MODIFY `id_permasalahan` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
