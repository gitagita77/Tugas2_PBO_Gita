package Gita_peternakan;

import DAO.*;
import gita_project_model.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Pilih operasi (1. Create, 2. Read, 3. Update, 4. Delete, 5. Exit): ");
            int operasi = scanner.nextInt();

            if (operasi == 5) {
                running = false;
                break;
            }

            System.out.print("Pilih tabel (1. tb_kecamatan, 2. tb_kelurahan , 3. tb_komoditas, 4. tb_permasalahan): ");
            int tabel = scanner.nextInt();

            // Consume newline
            scanner.nextLine();

            try {
                switch (operasi) {
                    case 1:
                        createOperation(tabel, scanner);
                        break;
                    case 2:
                        readOperation(tabel);
                        break;
                    case 3:
                        updateOperation(tabel, scanner);
                        break;
                    case 4:
                        deleteOperation(tabel, scanner);
                        break;
                    default:
                        System.out.println("Operasi tidak valid");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    private static void createOperation(int tabel, Scanner scanner) throws SQLException {
        switch (tabel) {
            case 1:
                KecamatanDAO kecamatanDAO = new KecamatanDAO();
                System.out.print("Nama Kecamatan: ");
                String nmKecamatan = scanner.nextLine();
                Kecamatan kecamatan = new Kecamatan(0, nmKecamatan);
                kecamatanDAO.addKecamatan(kecamatan);
                break;
            case 2:
                KelurahanDAO kelurahanDAO = new KelurahanDAO();
                System.out.print("ID Kecamatan: ");
                int idKecamatan = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Nama Kelurahan: ");
                String nmKelurahan = scanner.nextLine();
                Kelurahan kelurahan = new Kelurahan(0, idKecamatan, nmKelurahan);
                kelurahanDAO.addKelurahan(kelurahan);
                break;
            case 3:
                KomoditasDAO komoditasDAO = new KomoditasDAO();
                System.out.print("Kategori: ");
                String kategori = scanner.nextLine();
                System.out.print("Jenis Ternak: ");
                String jenisTernak = scanner.nextLine();
                Komoditas komoditas = new Komoditas(0, kategori, jenisTernak);
                komoditasDAO.addKomoditas(komoditas);
                break;
            case 4:
                PermasalahanDAO permasalahanDAO = new PermasalahanDAO();
                System.out.print("ID User: ");
                int idUser = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Tanggal Permasalahan (YYYY-MM-DD): ");
                String tglPermasalahan = scanner.nextLine();
                System.out.print("Permasalahan: ");
                String permasalahan = scanner.nextLine();
                System.out.print("Solusi: ");
                String solusi = scanner.nextLine();
                Permasalahan masalah = new Permasalahan(0, idUser, java.sql.Date.valueOf(tglPermasalahan), permasalahan, solusi);
                permasalahanDAO.addPermasalahan(masalah);
                break;
            default:
                System.out.println("Tabel tidak valid");
        }
    }

    private static void readOperation(int tabel) throws SQLException {
        switch (tabel) {
            case 1:
                KecamatanDAO kecamatanDAO = new KecamatanDAO();
                List<Kecamatan> kecamatanList = kecamatanDAO.getAllKecamatan();
                for (Kecamatan k : kecamatanList) {
                    System.out.println(k);
                }
                break;
            case 2:
                KelurahanDAO kelurahanDAO = new KelurahanDAO();
                List<Kelurahan> kelurahanList = kelurahanDAO.getAllKelurahan();
                for (Kelurahan k : kelurahanList) {
                    System.out.println(k);
                }
                break;
            case 3:
                KomoditasDAO komoditasDAO = new KomoditasDAO();
                List<Komoditas> komoditasList = komoditasDAO.getAllKomoditas();
                for (Komoditas k : komoditasList) {
                    System.out.println(k);
                }
                break;
            case 4:
                PermasalahanDAO permasalahanDAO = new PermasalahanDAO();
                List<Permasalahan> permasalahanList = permasalahanDAO.getAllPermasalahan();
                for (Permasalahan p : permasalahanList) {
                    System.out.println(p);
                }
                break;
            default:
                System.out.println("Tabel tidak valid");
        }
    }

    private static void updateOperation(int tabel, Scanner scanner) throws SQLException {
        switch (tabel) {
            case 1:
                KecamatanDAO kecamatanDAO = new KecamatanDAO();
                System.out.print("ID Kecamatan: ");
                int idKecamatan = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Nama Kecamatan: ");
                String nmKecamatan = scanner.nextLine();
                Kecamatan kecamatan = new Kecamatan(idKecamatan, nmKecamatan);
                kecamatanDAO.updateKecamatan(kecamatan);
                break;
            case 2:
                KelurahanDAO kelurahanDAO = new KelurahanDAO();
                System.out.print("ID Kelurahan: ");
                int idKelurahan = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("ID Kecamatan: ");
                int idKec = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Nama Kelurahan: ");
                String nmKelurahan = scanner.nextLine();
                Kelurahan kelurahan = new Kelurahan(idKelurahan, idKec, nmKelurahan);
                kelurahanDAO.updateKelurahan(kelurahan);
                break;
            case 3:
                KomoditasDAO komoditasDAO = new KomoditasDAO();
                System.out.print("ID Komoditas: ");
                int idKomoditas = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Kategori: ");
                String kategori = scanner.nextLine();
                System.out.print("Jenis Ternak: ");
                String jenisTernak = scanner.nextLine();
                Komoditas komoditas = new Komoditas(idKomoditas, kategori, jenisTernak);
                komoditasDAO.updateKomoditas(komoditas);
                break;
            case 4:
                PermasalahanDAO permasalahanDAO = new PermasalahanDAO();
                System.out.print("ID Permasalahan: ");
                int idPermasalahan = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("ID User: ");
                int idUser = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Tanggal Permasalahan (YYYY-MM-DD): ");
                String tglPermasalahan = scanner.nextLine();
                System.out.print("Permasalahan: ");
                String permasalahan = scanner.nextLine();
                System.out.print("Solusi: ");
                String solusi = scanner.nextLine();
                Permasalahan masalah = new Permasalahan(idPermasalahan, idUser, java.sql.Date.valueOf(tglPermasalahan), permasalahan, solusi);
                permasalahanDAO.updatePermasalahan(masalah);
                break;
            default:
                System.out.println("Tabel tidak valid");
        }
    }

    private static void deleteOperation(int tabel, Scanner scanner) throws SQLException {
        switch (tabel) {
            case 1:
                KecamatanDAO kecamatanDAO = new KecamatanDAO();
                System.out.print("ID Kecamatan: ");
                int idKecamatan = scanner.nextInt();
                kecamatanDAO.deleteKecamatan(idKecamatan);
                break;
            case 2:
                KelurahanDAO kelurahanDAO = new KelurahanDAO();
                System.out.print("ID Kelurahan: ");
                int idKelurahan = scanner.nextInt();
                kelurahanDAO.deleteKelurahan(idKelurahan);
                break;
            case 3:
                KomoditasDAO komoditasDAO = new KomoditasDAO();
                System.out.print("ID Komoditas: ");
                int idKomoditas = scanner.nextInt();
                komoditasDAO.deleteKomoditas(idKomoditas);
                break;
            case 4:
                PermasalahanDAO permasalahanDAO = new PermasalahanDAO();
                System.out.print("ID Permasalahan: ");
                int idPermasalahan = scanner.nextInt();
                permasalahanDAO.deletePermasalahan(idPermasalahan);
                break;
            default:
                System.out.println("Tabel tidak valid");
        }
    }
}
