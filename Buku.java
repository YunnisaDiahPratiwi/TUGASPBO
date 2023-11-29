package com.mycompany.pboteori;



public class Buku {
    private int idBuku;
    private String judul;
    private String noISBN;
    private String statusKetersediaan;

    public Buku(int idBuku, String judul, String noISBN, String statusKetersediaan) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.noISBN = noISBN;
        this.statusKetersediaan = statusKetersediaan;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(int idBuku) {
        this.idBuku = idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getNoISBN() {
        return noISBN;
    }

    public void setNoISBN(String noISBN) {
        this.noISBN = noISBN;
    }

    public String getStatusKetersediaan() {
        return statusKetersediaan;
    }

    public void setStatusKetersediaan(String statusKetersediaan) {
        this.statusKetersediaan = statusKetersediaan;
    }
}