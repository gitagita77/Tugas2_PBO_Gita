package gita_project_model;

import java.util.Date;

public class Permasalahan {
    private int idPermasalahan;
    private int idUser;
    private Date tglPermasalahan;
    private String permasalahan;
    private String solusi;

    public Permasalahan(int idPermasalahan, int idUser, Date tglPermasalahan, String permasalahan, String solusi) {
        this.idPermasalahan = idPermasalahan;
        this.idUser = idUser;
        this.tglPermasalahan = tglPermasalahan;
        this.permasalahan = permasalahan;
        this.solusi = solusi;
    }

    public int getIdPermasalahan() {
        return idPermasalahan;
    }

    public void setIdPermasalahan(int idPermasalahan) {
        this.idPermasalahan = idPermasalahan;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getTglPermasalahan() {
        return tglPermasalahan;
    }

    public void setTglPermasalahan(Date tglPermasalahan) {
        this.tglPermasalahan = tglPermasalahan;
    }

    public String getPermasalahan() {
        return permasalahan;
    }

    public void setPermasalahan(String permasalahan) {
        this.permasalahan = permasalahan;
    }

    public String getSolusi() {
        return solusi;
    }

    public void setSolusi(String solusi) {
        this.solusi = solusi;
    }

    @Override
    public String toString() {
        return "Permasalahan{" +
                "idPermasalahan=" + idPermasalahan +
                ", idUser=" + idUser +
                ", tglPermasalahan=" + tglPermasalahan +
                ", permasalahan='" + permasalahan + '\'' +
                ", solusi='" + solusi + '\'' +
                '}';
    }
}
