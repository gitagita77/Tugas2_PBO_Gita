package DAO;

import Koneksi.Database;
import gita_project_model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KecamatanDAO {

    public void addKecamatan(Kecamatan kecamatan) throws SQLException {
        String query = "INSERT INTO tb_kecamatan (nm_kecamatan) VALUES (?)";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, kecamatan.getNmKecamatan());
            stmt.executeUpdate();
        }
    }

    public List<Kecamatan> getAllKecamatan() throws SQLException {
        List<Kecamatan> kecamatanList = new ArrayList<>();
        String query = "SELECT * FROM tb_kecamatan";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Kecamatan kecamatan = new Kecamatan(rs.getInt("id_kecamatan"), rs.getString("nm_kecamatan"));
                kecamatanList.add(kecamatan);
            }
        }
        return kecamatanList;
    }

    public Kecamatan getKecamatanById(int id) throws SQLException {
        String query = "SELECT * FROM tb_kecamatan WHERE id_kecamatan = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Kecamatan(rs.getInt("id_kecamatan"), rs.getString("nm_kecamatan"));
            }
        }
        return null;
    }

    public void updateKecamatan(Kecamatan kecamatan) throws SQLException {
        String query = "UPDATE tb_kecamatan SET nm_kecamatan = ? WHERE id_kecamatan = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, kecamatan.getNmKecamatan());
            stmt.setInt(2, kecamatan.getIdKecamatan());
            stmt.executeUpdate();
        }
    }

    public void deleteKecamatan(int id) throws SQLException {
        String query = "DELETE FROM tb_kecamatan WHERE id_kecamatan = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
