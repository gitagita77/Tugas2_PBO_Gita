package gita_project_model;

public class Komoditas {
    private int idKomoditas;
    private String kategori;
    private String jenisTernak;

    public Komoditas(int idKomoditas, String kategori, String jenisTernak) {
        this.idKomoditas = idKomoditas;
        this.kategori = kategori;
        this.jenisTernak = jenisTernak;
    }

    public int getIdKomoditas() {
        return idKomoditas;
    }

    public void setIdKomoditas(int idKomoditas) {
        this.idKomoditas = idKomoditas;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getJenisTernak() {
        return jenisTernak;
    }

    public void setJenisTernak(String jenisTernak) {
        this.jenisTernak = jenisTernak;
    }

    @Override
    public String toString() {
        return "Komoditas{" +
                "idKomoditas=" + idKomoditas +
                ", kategori='" + kategori + '\'' +
                ", jenisTernak='" + jenisTernak + '\'' +
                '}';
    }
}
