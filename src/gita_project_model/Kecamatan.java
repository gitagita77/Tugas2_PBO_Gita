package gita_project_model;

public class Kecamatan {
    private int idKecamatan;
    private String nmKecamatan;

    public Kecamatan(int idKecamatan, String nmKecamatan) {
        this.idKecamatan = idKecamatan;
        this.nmKecamatan = nmKecamatan;
    }

    public int getIdKecamatan() {
        return idKecamatan;
    }

    public void setIdKecamatan(int idKecamatan) {
        this.idKecamatan = idKecamatan;
    }

    public String getNmKecamatan() {
        return nmKecamatan;
    }

    public void setNmKecamatan(String nmKecamatan) {
        this.nmKecamatan = nmKecamatan;
    }

    @Override
    public String toString() {
        return "Kecamatan{" +
                "idKecamatan=" + idKecamatan +
                ", nmKecamatan='" + nmKecamatan + '\'' +
                '}';
    }
}
