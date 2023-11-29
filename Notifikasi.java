
package com.mycompany.pboteori;

import java.time.LocalDate;
import java.util.Date;


public class Notifikasi {
    private int idNotif;
    private int noAnggota;
    private String pesan;
    private LocalDate timeStamp;
    private transaksiPeminjaman transaksi;

    public Notifikasi(int idNotif, int noAnggota, String pesan, LocalDate timeStamp) {
        this.idNotif = idNotif;
        this.noAnggota = noAnggota;
        this.pesan = pesan;
        this.timeStamp = timeStamp;
        this.transaksi = transaksi;
    }
    

    public int getIdNotif() {
        return idNotif;
    }

    public void setIdNotif(int idNotif) {
        this.idNotif = idNotif;
    }

    public int getNoAnggota() {
        return noAnggota;
    }

    public void setNoAnggota(int noAnggota) {
        this.noAnggota = noAnggota;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }


    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public transaksiPeminjaman getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(transaksiPeminjaman transaksi) {
        this.transaksi = transaksi;
    }

    
}
