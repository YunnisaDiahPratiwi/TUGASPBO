package com.mycompany.pboteori;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class anggotaPerpustakaan extends PBOTeori{
   private String nama;
        private int noAnggota;
        private String alamat;
        ArrayList<Buku> riwayatPeminjaman = new ArrayList<>();
        private Admin adm;
        ArrayList<Notifikasi> notif = new ArrayList<>();
        
    public anggotaPerpustakaan(String nama, int noAnggota, String alamat, Admin adm) {
        this.nama = nama;
        this.noAnggota = noAnggota;
        this.alamat = alamat;
        this.adm = adm;
        adm.daftarAnggota.add(this);
    }

    public anggotaPerpustakaan(String nama, int noAnggota, String alamat) {
        this.nama = nama;
        this.noAnggota = noAnggota;
        this.alamat = alamat;
    }

    public anggotaPerpustakaan() {
    }

    public void pinjamBuku(String judul) {
    boolean bisaPinjam = false;
    for (Buku v : adm.daftarbuku) {
        if (v.getJudul().contains(judul) && v.getStatusKetersediaan().equals("Tersedia")) {
            riwayatPeminjaman.add(v);
            System.out.println("Sukses meminjam buku");
            v.setStatusKetersediaan("Tidak Ada");
            bisaPinjam = true;

            // Panggil metode kembalikanBuku untuk menambahkan logik pengembalian
            kembalikanBuku(v.getJudul());

            break; // Keluar dari loop setelah buku ditemukan dan dipinjam
        }
    }
    if (!bisaPinjam) {
        System.out.println("Buku tidak dapat dipinjam");
    }
}

    
    public void kembalikanBuku(String judul) {
        boolean berhasil = false;
        for (Buku buku : riwayatPeminjaman) {
            if (buku.getJudul().contains(judul)) {
                buku.setStatusKetersediaan("Tersedia");
                System.out.println("Buku berhasil dikembalikan: " + judul);
                berhasil = true;
                break; // Keluar dari loop setelah menemukan dan mengembalikan buku
            }
        }
        if (!berhasil) {
            System.out.println("Buku tidak ditemukan dalam riwayat peminjaman: " + judul);
        }
    }

    public void cariBuku(String Judul){
        boolean ditemukan =false;
        for(Buku v : adm.daftarbuku){
            if(v.getJudul().contains(Judul)){
                System.out.println("Buku " + v.getJudul() +" " + v.getStatusKetersediaan());
                ditemukan = true;
            }
        }
        if(!ditemukan){
            System.out.println(Judul + " Buku Tidak Ditemukan\n");
            ditemukan = false;
        }
    }
    
    public void VieRiwayatPeminjaman(){
        StringBuilder daftarP = new StringBuilder();
        System.out.println("\nDaftar Peminjaman Buku Anggota " + this.nama);
        daftarP.append("Buku : ");
        for(Buku v : riwayatPeminjaman){
            daftarP.append(v.getJudul() + ", ");
        }
        System.out.println(daftarP.toString());
    }

    public void tampilkanNotifikasi(){
        System.out.println("Berikut Keterangan Peminjaman : ");
        for (Notifikasi notifikasi : notif) {
            System.out.println(notifikasi.getPesan());

            transaksiPeminjaman transaksi = notifikasi.getTransaksi();
            if (transaksi != null) {
                transaksi.catatanPeminjaman();
            }
        }

    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoAnggota(int noAnggota) {
        this.noAnggota = noAnggota;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public int getNoAnggota() {
        return noAnggota;
    }

    public String getAlamat() {
        return alamat;
    }

    
    
    
        
}       