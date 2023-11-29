package com.mycompany.pboteori;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;

public class PBOTeori {

    public static void main(String[] args) {

        Admin admin = new Admin(1, "Zelvin");
        Scanner scanner = new Scanner(System.in);
        anggotaPerpustakaan agt = new anggotaPerpustakaan("nca", 2020, "Bandar Lampung", admin);


        while (true) {
            System.out.println("========Menu=======");
            System.out.println("1. Tambahkan Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Tambahkan Anggota");
            System.out.println("4. Lihat Anggota");
            System.out.println("5. Meminjam Buku");
            System.out.println("6. Mengembalikan Buku");
            System.out.println("7. Cari Buku");
            System.out.println("8. Lihat Riwayat Peminjaman");
            System.out.println("9. Tampilkan Notifikasi");
            System.out.println("10. Kirim Notifikasi");
            System.out.println("11. Keluar");
            System.out.print("Pilih menu (1-10): ");

            int menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    System.out.print("Masukkan judul buku: ");
                    String judulBuku = scanner.nextLine();
                    admin.addBuku(admin.daftarbuku.size() + 1, judulBuku, "ISBN" + (admin.daftarbuku.size() + 1), "Tersedia");
                    break;
                case 2:
                    System.out.print("Masukkan judul buku yang akan dihapus: ");
                    String judulHapus = scanner.nextLine();
                    admin.hapusBuku(judulHapus);
                    break;
                case 3:
                    System.out.print("Masukkan nama anggota: ");
                    String namaAnggota = scanner.nextLine();
                    System.out.print("Masukkan nomor anggota: ");
                    int nomorAnggota = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan alamat anggota: ");
                    String alamatAnggota = scanner.nextLine();
                    admin.addAnggota(namaAnggota, nomorAnggota, alamatAnggota);
                    break;
                case 4:
                    admin.lihatAnggota();
                    break;
                case 5:
                    System.out.print("Masukkan judul buku yang ingin dipinjam: ");
                    String judulPinjam = scanner.nextLine();

                    System.out.println("Pilih anggota untuk melakukan peminjaman:");
                    for (int i = 0; i < admin.daftarAnggota.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.daftarAnggota.get(i).getNama());
                    }

                    System.out.print("Pilih nomor anggota: ");
                    int nomorAnggotaPinjam = scanner.nextInt();
                    scanner.nextLine();

                    if (nomorAnggotaPinjam >= 1 && nomorAnggotaPinjam <= admin.daftarAnggota.size()) {
                        anggotaPerpustakaan anggota = admin.daftarAnggota.get(nomorAnggotaPinjam - 1);
                        anggota.pinjamBuku(judulPinjam);
                    } else {
                        System.out.println("Nomor anggota tidak valid.");
                    }
                    break;
                case 6:
                    System.out.print("Masukkan judul buku yang ingin dikembalikan: ");
                    String judulKembali = scanner.nextLine();

                    System.out.println("Pilih anggota untuk mengembalikan buku:");
                    for (int i = 0; i < admin.daftarAnggota.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.daftarAnggota.get(i).getNama());
                    }

                    System.out.print("Pilih nomor anggota: ");
                    int nomorAnggotaKembali = scanner.nextInt();
                    scanner.nextLine();

                    if (nomorAnggotaKembali >= 1 && nomorAnggotaKembali <= admin.daftarAnggota.size()) {
                        anggotaPerpustakaan anggotaKembali = admin.daftarAnggota.get(nomorAnggotaKembali - 1);
                        anggotaKembali.kembalikanBuku(judulKembali);
                    } else {
                        System.out.println("Nomor anggota tidak valid.");
                    }
                    break;
                case 7:
                    System.out.print("Masukkan judul buku yang ingin dicari: ");
                    String judulCari = scanner.nextLine();

                    System.out.println("Pilih anggota untuk melakukan pencarian:");
                    for (int i = 0; i < admin.daftarAnggota.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.daftarAnggota.get(i).getNama());
                    }
                    System.out.print("Pilih nomor anggota: ");
                    int nomorAnggotaCari = scanner.nextInt();
                    scanner.nextLine();

                    if (nomorAnggotaCari >= 1 && nomorAnggotaCari <= admin.daftarAnggota.size()) {
                        anggotaPerpustakaan anggotaCari = admin.daftarAnggota.get(nomorAnggotaCari - 1);
                        anggotaCari.cariBuku(judulCari);
                    } else {
                        System.out.println("Nomor anggota tidak valid.");
                    }
                    break;
                case 8:
                    System.out.println("Pilih anggota untuk melihat riwayat peminjaman:");
                    for (int i = 0; i < admin.daftarAnggota.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.daftarAnggota.get(i).getNama());
                    }
                    System.out.print("Pilih nomor anggota: ");
                    int nomorAnggotaRiwayat = scanner.nextInt();
                    scanner.nextLine();

                    if (nomorAnggotaRiwayat >= 1 && nomorAnggotaRiwayat <= admin.daftarAnggota.size()) {
                        anggotaPerpustakaan anggotaRiwayat = admin.daftarAnggota.get(nomorAnggotaRiwayat - 1);
                        anggotaRiwayat.VieRiwayatPeminjaman();
                    } else {
                        System.out.println("Nomor anggota tidak valid.");
                    }
                    break;
                case 9:
                    System.out.println("Pilih anggota untuk menampilkan notifikasi:");
                    for (int i = 0; i < admin.daftarAnggota.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.daftarAnggota.get(i).getNama());
                    }
                    System.out.print("Pilih nomor anggota: ");
                    int nomorAnggotaNotif = scanner.nextInt();
                    scanner.nextLine();

                    if (nomorAnggotaNotif >= 1 && nomorAnggotaNotif <= admin.daftarAnggota.size()) {
                        anggotaPerpustakaan anggotaNotif = admin.daftarAnggota.get(nomorAnggotaNotif - 1);
                        anggotaNotif.tampilkanNotifikasi();
                    } else {
                        System.out.println("Nomor anggota tidak valid.");
                    }
                    break;
                case 10:
                    System.out.print("Masukkan ID Notifikasi: ");
                    int idNotif = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Pesan Notifikasi: ");
                    String pesanNotif = scanner.nextLine();

                    System.out.println("Pilih anggota untuk mengirim notifikasi:");
                    for (int i = 0; i < admin.daftarAnggota.size(); i++) {
                        System.out.println((i + 1) + ". " + admin.daftarAnggota.get(i).getNama());
                    }
                    System.out.print("Pilih nomor anggota: ");
                    int nomorAnggotaKirimNotif = scanner.nextInt();
                    scanner.nextLine();

                    if (nomorAnggotaKirimNotif >= 1 && nomorAnggotaKirimNotif <= admin.daftarAnggota.size()) {
                        anggotaPerpustakaan anggotaKirimNotif = admin.daftarAnggota.get(nomorAnggotaKirimNotif - 1);
                        LocalDate timeStamp = LocalDate.now();
                        admin.kirimNotifikasi(anggotaKirimNotif, idNotif, anggotaKirimNotif.getNoAnggota(), pesanNotif, timeStamp);
                        System.out.println("Notifikasi berhasil dikirim.");
                    } else {
                        System.out.println("Nomor anggota tidak valid.");
                    }
                    break;

                case 11:
                    System.out.println("Terima Kasih");
                    System.exit(0);
                default:
                    System.out.println("Menu tidak valid. Pilih menu lain.");
                    break;
            }
        }
    }
}