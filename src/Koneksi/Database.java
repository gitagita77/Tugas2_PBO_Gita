/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Koneksi;

import java.sql.Connection; // mendapatkan koneksi
import java.sql.Date;
import java.sql.DriverManager; // menghubungkan database
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
//import javax.swing.JOptionPane;
import java.sql.SQLException; // menampilkan kesalahan error pada sql

public class Database {
    private String databaseName = "gita_2210010187";
    private String username = "root";
    private String pass = "";
    private String lokasi = "jdbc:mysql://localhost:3306/" + databaseName;
    public static Connection KoneksiDB;

    public Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            KoneksiDB = DriverManager.getConnection(lokasi, username, pass);
//            JOptionPane.showMessageDialog(null, "Koneksi ke database berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Database Terkoneksi!");
            
        } catch (Exception e) {
            System.err.println(e.toString());
//            JOptionPane.showMessageDialog(null, "Koneksi ke database gagal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // tb_pendataan
    public void simpanPendataan(int paramId, int paramIdKomo, String paramDate, long paramNik, long paramNpwp, String ParamNama, String paramAlamat, String paramAsal, int paramJumlahTernak, String paramKec, String paramKel, String paramJalan) {
        try {
            String SQL = "INSERT INTO tb_pendataan (id, id_komoditas, tgl, nik, npwp, nama, alamat, asal, jumlah_ternak, kec, kel, jalan) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.setInt(2, paramIdKomo);
//          perintah.setDate(3, paramDate);
            perintah.setString(3, paramDate);
            perintah.setLong(4, paramNik);
            perintah.setLong(5, paramNpwp);
            perintah.setString(6, ParamNama);
            perintah.setString(7, paramAlamat);
            perintah.setString(8, paramAsal);
            perintah.setInt(9, paramJumlahTernak);
            perintah.setString(10, paramKec);
            perintah.setString(11, paramKel);
            perintah.setString(12, paramJalan);
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePendataan(int paramId, int paramIdKomo, String paramDate, long paramNik, long paramNpwp, String paramNama, String paramAlamat, String paramAsal, int paramJumlahTernak, String paramKec, String paramKel, String paramJalan) {
        try {
            String SQL = "UPDATE tb_pendataan SET id_komoditas =?, date =?, nik=?, npwp=?, nama=?, alamat=?, asal=?, jumlah_ternak=?, kec=?, kel=?, jalan=? WHERE id=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramIdKomo);
//            perintah.setDate(2, Date.valueOf(paramTanggal));
            perintah.setString(2, paramDate);
            perintah.setLong(3, paramNik);
            perintah.setLong(4, paramNpwp);
            perintah.setString(5, paramNama);
            perintah.setString(6, paramAlamat);
            perintah.setString(7, paramAsal);
            perintah.setInt(8, paramJumlahTernak);
            perintah.setString(9, paramKec);
            perintah.setString(10, paramKel);
            perintah.setString(11, paramJalan);
            perintah.setInt(12, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void hapusPendataan(int paramId) {
        try {
            String SQL = "DELETE FROM tb_pendataan WHERE id=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

//    public void cariPendataan(String paramId){
//        try {
//            String SQL = "SELECT * FROM tb_pendataan WHERE id=?";
//            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
//            perintah.setString(1, paramId);
//            ResultSet data = perintah.executeQuery();
//            while(data.next()){
//                System.out.println("id :"+data.getString("id"));
//                System.out.println("Date :"+data.getString("date"));
//                System.out.println("Material :"+data.getString("material"));
//                System.out.println("qty :"+data.getString("qty"));
//                System.out.println("Type :"+data.getString("type"));
//                System.out.println("Pit :"+data.getString("pit"));
//            }
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//    }
//
//    public void dataPendataan(){
//        try {
//            Statement stmt = KoneksiDB.createStatement();
//            ResultSet baris = stmt.executeQuery("SELECT * FROM tb_pendataan ORDER BY id ASC");
//            while (baris.next()){
//                System.out.println(baris.getString("id")+" | "+
//                        baris.getString("date")+" | "+
//                        baris.getString("material")+" | "+
//                        baris.getString("qty")+" | "+
//                        baris.getString("type")+" | "+
//                        baris.getString("pit"));
//            }
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//    }
    
   // tb_permasalahan
    public void simpanPermasalahan(int paramId, int paramIdUser, String paramDate, String paramPermasalahan, String paramSolusi) {
        try {
            String SQL = "INSERT INTO tb_permasalahan (id_permasalahan, id_user, tgl_permasalahan, permasalahan, solusi) VALUES(?,?,?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.setInt(2, paramIdUser);
//          perintah.setDate(3, paramDate);
            perintah.setString(3, paramDate);
            perintah.setString(4, paramPermasalahan);
            perintah.setString(5, paramSolusi);
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updatePermasalahan(int paramId, int paramIdUser, String paramDate, String paramPermasalahan, String paramSolusi) {
        try {
            String SQL = "UPDATE tb_permasalahan SET id_user =?, tgl_permasalahan=?, permasalahan=?, solusi=? WHERE id_permasalahan=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramIdUser);
//            perintah.setDate(2, Date.valueOf(paramTanggal));
            perintah.setString(2, paramDate);
            perintah.setString(3, paramPermasalahan);
            perintah.setString(4, paramSolusi);
            perintah.setInt(5, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusPermasalahan(int paramId) {
        try {
            String SQL = "DELETE FROM tb_permasalahan WHERE id_permasalahan = ?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    // tb_komoditas
    public void simpanKomoditas(int paramId, String paramKategori, String paramJenisTernak) {
        try {
            String SQL = "INSERT INTO tb_komoditas (id_komoditas, kategori, jenis_ternak) VALUES(?,?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.setString(2, paramKategori);
            perintah.setString(3, paramJenisTernak);
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateKomoditas(int paramId, String paramKategori, String paramJenisTernak) {
        try {
            String SQL = "UPDATE tb_komoditas SET kategori =?, jenis_ternak=? WHERE id_komoditas=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramKategori);
            perintah.setString(2, paramJenisTernak);
            perintah.setInt(3, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusKomoditas(int paramId) {
        try {
            String SQL = "DELETE FROM tb_komoditas WHERE id_komoditas=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    // tb_kecamatan
    public void simpanKecamatan(int paramId, String paramKecamatan) {
        try {
            String SQL = "INSERT INTO tb_kecamatan (id_kecamatan, nm_kecamatan) VALUES(?,?)";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.setString(2, paramKecamatan);
            perintah.executeUpdate();
            System.out.println("Data Berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateKecamatan(int paramId, String paramKecamatan) {
        try {
            String SQL = "UPDATE tb_kecamatan SET nm_kecamatan =? WHERE id_kecamatan=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setString(1, paramKecamatan);
            perintah.setInt(2, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil diupdate!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void hapusKecamatan(int paramId) {
        try {
            String SQL = "DELETE FROM tb_kecamatan WHERE id_kecamatan=?";
            PreparedStatement perintah = KoneksiDB.prepareStatement(SQL);
            perintah.setInt(1, paramId);
            perintah.executeUpdate();
            System.out.println("Data Berhasil dihapus!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
