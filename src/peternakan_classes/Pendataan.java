package peternakan_classes;

import java.util.Date;

public class Pendataan {
     int id;
     int idKomoditas;
     Date tgl;
     long nik;
     long npwp;
     String nama;
     String alamat;
     String asal;
     int jumlahTernak;
     String kec;
     String kel;
     String jalan;

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIdKomoditas(int idKomoditas) {
        this.idKomoditas = idKomoditas;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public void setNik(long nik) {
        this.nik = nik;
    }

    public void setNpwp(long npwp) {
        this.npwp = npwp;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public void setJumlahTernak(int jumlahTernak) {
        this.jumlahTernak = jumlahTernak;
    }

    public void setKec(String kec) {
        this.kec = kec;
    }

    public void setKel(String kel) {
        this.kel = kel;
    }

    public void setJalan(String jalan) {
        this.jalan = jalan;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getIdKomoditas() {
        return idKomoditas;
    }

    public Date getTgl() {
        return tgl;
    }

    public long getNik() {
        return nik;
    }

    public long getNpwp() {
        return npwp;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getAsal() {
        return asal;
    }

    public int getJumlahTernak() {
        return jumlahTernak;
    }

    public String getKec() {
        return kec;
    }

    public String getKel() {
        return kel;
    }

    public String getJalan() {
        return jalan;
    }
}
