package com.alrafa47.api_datamhs.GetSet;

public class DataMahasiswa {
    private int foto_mhs;
    private String nama;
    private String npm;

    public DataMahasiswa(int foto_mhs, String nama, String npm) {
        this.foto_mhs = foto_mhs;
        this.nama = nama;
        this.npm = npm;
    }

    public int getFoto_mhs() {
        return foto_mhs;
    }

    public void setFoto_mhs(int foto_mhs) {
        this.foto_mhs = foto_mhs;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }
}
