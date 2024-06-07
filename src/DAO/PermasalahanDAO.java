package DAO;

import Koneksi.Database;
import gita_project_model.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PermasalahanDAO {

    public void addPermasalahan(Permasalahan permasalahan) throws SQLException {
        String query = "INSERT INTO tb_permasalahan (id_user, tgl_permasalahan, permasalahan, solusi) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, permasalahan.getIdUser());
            stmt.setDate(2, new Date(permasalahan.getTglPermasalahan().getTime()));
            stmt.setString(3, permasalahan.getPermasalahan());
            stmt.setString(4, permasalahan.getSolusi());
            stmt.executeUpdate();
        }
    }

    public List<Permasalahan> getAllPermasalahan() throws SQLException {
        List<Permasalahan> permasalahanList = new ArrayList<>();
        String query = "SELECT * FROM tb_permasalahan";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Permasalahan permasalahan = new Permasalahan(
                        rs.getInt("id_permasalahan"),
                        rs.getInt("id_user"),
                        rs.getDate("tgl_permasalahan"),
                        rs.getString("permasalahan"),
                        rs.getString("solusi")
                );
                permasalahanList.add(permasalahan);
            }
        }
        return permasalahanList;
    }

    public Permasalahan getPermasalahanById(int id) throws SQLException {
        String query = "SELECT * FROM tb_permasalahan WHERE id_permasalahan = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Permasalahan(
                        rs.getInt("id_permasalahan"),
                        rs.getInt("id_user"),
                        rs.getDate("tgl_permasalahan"),
                        rs.getString("permasalahan"),
                        rs.getString("solusi")
                );
            }
        }
        return null;
    }

    public void updatePermasalahan(Permasalahan permasalahan) throws SQLException {
        String query = "UPDATE tb_permasalahan SET id_user = ?, tgl_permasalahan = ?, permasalahan = ?, solusi = ? WHERE id_permasalahan = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, permasalahan.getIdUser());
            stmt.setDate(2, new Date(permasalahan.getTglPermasalahan().getTime()));
            stmt.setString(3, permasalahan.getPermasalahan());
            stmt.setString(4, permasalahan.getSolusi());
            stmt.setInt(5, permasalahan.getIdPermasalahan());
            stmt.executeUpdate();
        }
    }

    public void deletePermasalahan(int id) throws SQLException {
        String query = "DELETE FROM tb_permasalahan WHERE id_permasalahan = ?";
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
