-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 06 Jun 2024 pada 07.15
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

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
-- Struktur dari tabel `tb_jadwal`
--

CREATE TABLE `tb_jadwal` (
  `id_jadwal` int(30) NOT NULL,
  `tanggal` date NOT NULL,
  `jam` time NOT NULL,
  `nama_kegiatan` varchar(150) NOT NULL,
  `id_pendataan` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kecamatan`
--

CREATE TABLE `tb_kecamatan` (
  `id_kecamatan` int(20) NOT NULL,
  `nm_kecamatan` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tb_kecamatan`
--

INSERT INTO `tb_kecamatan` (`id_kecamatan`, `nm_kecamatan`) VALUES
(1, 'Kecamatan B'),
(2, 'Kecamatan B');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_kelurahan`
--

CREATE TABLE `tb_kelurahan` (
  `id_kelurahan` int(30) NOT NULL,
  `id_kecamatan` int(30) NOT NULL,
  `nm_kelurahan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tb_kelurahan`
--

INSERT INTO `tb_kelurahan` (`id_kelurahan`, `id_kecamatan`, `nm_kelurahan`) VALUES
(1, 1, 'Kelurahan B'),
(2, 1, 'Kelurahan B');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_komoditas`
--

CREATE TABLE `tb_komoditas` (
  `id_komoditas` int(30) NOT NULL,
  `kategori` varchar(150) NOT NULL,
  `jenis_ternak` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_pendataan`
--

CREATE TABLE `tb_pendataan` (
  `id` int(20) NOT NULL,
  `id_komoditas` int(20) NOT NULL,
  `tgl` date NOT NULL,
  `nik` bigint(20) NOT NULL,
  `npwp` bigint(20) NOT NULL,
  `nama` varchar(150) NOT NULL,
  `alamat` text NOT NULL,
  `asal` varchar(150) NOT NULL,
  `jumlah_ternak` int(30) NOT NULL,
  `kec` varchar(150) NOT NULL,
  `kel` varchar(150) NOT NULL,
  `jalan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tb_pendataan`
--

INSERT INTO `tb_pendataan` (`id`, `id_komoditas`, `tgl`, `nik`, `npwp`, `nama`, `alamat`, `asal`, `jumlah_ternak`, `kec`, `kel`, `jalan`) VALUES
(2, 1, '2024-06-07', 123456789, 12345, 'John Doe', 'Jl. Kebon Jeruk', 'Kebumen', 50, 'Kebon', 'Jeruk', 'Jalan Jeruk');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_perkembangan`
--

CREATE TABLE `tb_perkembangan` (
  `id_perkembangan` int(20) NOT NULL,
  `id_skala` int(20) NOT NULL,
  `id_pendataan` int(20) NOT NULL,
  `tgl_perkembangan` date NOT NULL,
  `jml_a_dws_jntn` int(30) NOT NULL,
  `jml_a_dws_btn` int(30) NOT NULL,
  `jml_a_dara_jntn` int(30) NOT NULL,
  `jml_a_dara_btn` int(30) NOT NULL,
  `jml_a_anak_jntn` int(30) NOT NULL,
  `jml_a_anak_btn` int(30) NOT NULL,
  `tujuan` varchar(150) NOT NULL,
  `jumlah_keluar` int(30) NOT NULL,
  `ket_perkembangan` text NOT NULL,
  `id_user` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_permasalahan`
--

CREATE TABLE `tb_permasalahan` (
  `id_permasalahan` int(20) NOT NULL,
  `id_user` int(20) NOT NULL,
  `tgl_permasalahan` date NOT NULL,
  `permasalahan` text NOT NULL,
  `solusi` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `tb_permasalahan`
--

INSERT INTO `tb_permasalahan` (`id_permasalahan`, `id_user`, `tgl_permasalahan`, `permasalahan`, `solusi`) VALUES
(1, 1, '2024-06-06', 'kada', 'pg'),
(2, 2, '2024-06-06', 'Kada', 'jua'),
(3, 4, '2004-02-01', 'Kada tahu ', 'Solusi nya kadada');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_skala`
--

CREATE TABLE `tb_skala` (
  `id_skala` int(20) NOT NULL,
  `id_komoditas` int(20) NOT NULL,
  `jenis_usaha` varchar(150) NOT NULL,
  `skala_usaha` varchar(150) NOT NULL,
  `ket_skala` text NOT NULL,
  `masa_pendataan` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_tandabukti`
--

CREATE TABLE `tb_tandabukti` (
  `id_tandabukti` int(20) NOT NULL,
  `id_pendataan` int(20) NOT NULL,
  `nomor` varchar(150) NOT NULL,
  `tanggal` date NOT NULL,
  `jml_dws_jntn` int(30) NOT NULL,
  `jml_dws_btn` int(30) NOT NULL,
  `jml_dara_jntn` int(30) NOT NULL,
  `jml_dara_btn` int(30) NOT NULL,
  `jml_anak_jntn` int(30) NOT NULL,
  `jml_anak_btn` int(30) NOT NULL,
  `ket_tandabukti` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(20) NOT NULL,
  `username` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `level` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Struktur dari tabel `uji`
--

CREATE TABLE `uji` (
  `nik` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `alamat` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_jadwal`
--
ALTER TABLE `tb_jadwal`
  ADD PRIMARY KEY (`id_jadwal`);

--
-- Indeks untuk tabel `tb_kecamatan`
--
ALTER TABLE `tb_kecamatan`
  ADD PRIMARY KEY (`id_kecamatan`);

--
-- Indeks untuk tabel `tb_kelurahan`
--
ALTER TABLE `tb_kelurahan`
  ADD PRIMARY KEY (`id_kelurahan`);

--
-- Indeks untuk tabel `tb_komoditas`
--
ALTER TABLE `tb_komoditas`
  ADD PRIMARY KEY (`id_komoditas`);

--
-- Indeks untuk tabel `tb_pendataan`
--
ALTER TABLE `tb_pendataan`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `tb_perkembangan`
--
ALTER TABLE `tb_perkembangan`
  ADD PRIMARY KEY (`id_perkembangan`);

--
-- Indeks untuk tabel `tb_permasalahan`
--
ALTER TABLE `tb_permasalahan`
  ADD PRIMARY KEY (`id_permasalahan`);

--
-- Indeks untuk tabel `tb_skala`
--
ALTER TABLE `tb_skala`
  ADD PRIMARY KEY (`id_skala`);

--
-- Indeks untuk tabel `tb_tandabukti`
--
ALTER TABLE `tb_tandabukti`
  ADD PRIMARY KEY (`id_tandabukti`);

--
-- Indeks untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indeks untuk tabel `uji`
--
ALTER TABLE `uji`
  ADD PRIMARY KEY (`nik`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_jadwal`
--
ALTER TABLE `tb_jadwal`
  MODIFY `id_jadwal` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tb_kecamatan`
--
ALTER TABLE `tb_kecamatan`
  MODIFY `id_kecamatan` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `tb_kelurahan`
--
ALTER TABLE `tb_kelurahan`
  MODIFY `id_kelurahan` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `tb_komoditas`
--
ALTER TABLE `tb_komoditas`
  MODIFY `id_komoditas` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT untuk tabel `tb_pendataan`
--
ALTER TABLE `tb_pendataan`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `tb_permasalahan`
--
ALTER TABLE `tb_permasalahan`
  MODIFY `id_permasalahan` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
