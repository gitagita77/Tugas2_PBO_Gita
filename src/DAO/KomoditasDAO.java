package DAO;

import Koneksi.Database;
import gita_project_model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KomoditasDAO {

    public void addKomoditas(Komoditas komoditas) throws SQLException {
        String query = "INSERT INTO tb_komoditas (kategori, jenis_ternak) VALUES (?, ?)";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, komoditas.getKategori());
            stmt.setString(2, komoditas.getJenisTernak());
            stmt.executeUpdate();
        }
    }

    public List<Komoditas> getAllKomoditas() throws SQLException {
        List<Komoditas> komoditasList = new ArrayList<>();
        String query = "SELECT * FROM tb_komoditas";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Komoditas komoditas = new Komoditas(rs.getInt("id_komoditas"), rs.getString("kategori"), rs.getString("jenis_ternak"));
                komoditasList.add(komoditas);
            }
        }
        return komoditasList;
    }

    public Komoditas getKomoditasById(int id) throws SQLException {
        String query = "SELECT * FROM tb_komoditas WHERE id_komoditas = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Komoditas(rs.getInt("id_komoditas"), rs.getString("kategori"), rs.getString("jenis_ternak"));
            }
        }
        return null;
    }

    public void updateKomoditas(Komoditas komoditas) throws SQLException {
        String query = "UPDATE tb_komoditas SET kategori = ?, jenis_ternak = ? WHERE id_komoditas = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, komoditas.getKategori());
            stmt.setString(2, komoditas.getJenisTernak());
            stmt.setInt(3, komoditas.getIdKomoditas());
            stmt.executeUpdate();
        }
    }

    public void deleteKomoditas(int id) throws SQLException {
        String query = "DELETE FROM tb_komoditas WHERE id_komoditas = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
