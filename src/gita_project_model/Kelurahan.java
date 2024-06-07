package gita_project_model;

public class Kelurahan {
    private int idKelurahan;
    private int idKecamatan;
    private String nmKelurahan;

    public Kelurahan(int idKelurahan, int idKecamatan, String nmKelurahan) {
        this.idKelurahan = idKelurahan;
        this.idKecamatan = idKecamatan;
        this.nmKelurahan = nmKelurahan;
    }

    public int getIdKelurahan() {
        return idKelurahan;
    }

    public void setIdKelurahan(int idKelurahan) {
        this.idKelurahan = idKelurahan;
    }

    public int getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(int idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getNmKelurahan() {
        return nmKelurahan;
    }

    public void setNmKelurahan(String nmKelurahan) {
        this.nmKelurahan = nmKelurahan;
    }

    @Override
    public String toString() {
        return "Kelurahan{" +
                "idKelurahan=" + idKelurahan +
                ", idKecamatan=" + idKecamatan +
                ", nmKelurahan='" + nmKelurahan + '\'' +
                '}';
    }
}
