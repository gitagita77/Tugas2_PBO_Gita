package DAO;

import Koneksi.Database;
import gita_project_model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KelurahanDAO {

    public void addKelurahan(Kelurahan kelurahan) throws SQLException {
        String query = "INSERT INTO tb_kelurahan (id_kecamatan, nm_kelurahan) VALUES (?, ?)";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, kelurahan.getIdKecamatan());
            stmt.setString(2, kelurahan.getNmKelurahan());
            stmt.executeUpdate();
        }
    }

    public List<Kelurahan> getAllKelurahan() throws SQLException {
        List<Kelurahan> kelurahanList = new ArrayList<>();
        String query = "SELECT * FROM tb_kelurahan";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Kelurahan kelurahan = new Kelurahan(rs.getInt("id_kelurahan"), rs.getInt("id_kecamatan"), rs.getString("nm_kelurahan"));
                kelurahanList.add(kelurahan);
            }
        }
        return kelurahanList;
    }

    public Kelurahan getKelurahanById(int id) throws SQLException {
        String query = "SELECT * FROM tb_kelurahan WHERE id_kelurahan = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Kelurahan(rs.getInt("id_kelurahan"), rs.getInt("id_kecamatan"), rs.getString("nm_kelurahan"));
            }
        }
        return null;
    }

    public void updateKelurahan(Kelurahan kelurahan) throws SQLException {
        String query = "UPDATE tb_kelurahan SET id_kecamatan = ?, nm_kelurahan = ? WHERE id_kelurahan = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, kelurahan.getIdKecamatan());
            stmt.setString(2, kelurahan.getNmKelurahan());
            stmt.setInt(3, kelurahan.getIdKelurahan());
            stmt.executeUpdate();
        }
    }

    public void deleteKelurahan(int id) throws SQLException {
        String query = "DELETE FROM tb_kelurahan WHERE id_kelurahan = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
