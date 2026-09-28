/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Penyewaanlapangan;


class Lapangan {

    
    private String namaLapangan;
    private String jenisLapangan;
    private int hargaSewa;

    
    Lapangan(String namaLapangan, String jenisLapangan, int hargaSewa) {
        this.namaLapangan = namaLapangan;
        this.jenisLapangan = jenisLapangan;
        this.hargaSewa = hargaSewa;
    }

    
    public String getNamaLapangan() {
        return namaLapangan;
    }

    
    public void setNamaLapangan(String namaLapangan) {
        this.namaLapangan = namaLapangan;
    }

    
    public String getJenisLapangan() {
        return jenisLapangan;
    }

    
    public void setJenisLapangan(String jenisLapangan) {
        this.jenisLapangan = jenisLapangan;
    }

    
    public int getHargaSewa() {
        return hargaSewa;
    }

    
    public void setHargaSewa(int hargaSewa) {
        if (hargaSewa > 0) {
            this.hargaSewa = hargaSewa;
        } else {
            System.out.println("Harga sewa tidak boleh 0 atau negatif.");
        }
    }

    void tampilkanInfo() {
        System.out.println("Nama Lapangan : " + namaLapangan);
        System.out.println("Jenis         : " + jenisLapangan);
        System.out.println("Harga Sewa    : Rp" + hargaSewa);
    }
}

class LapanganFutsal extends Lapangan {

    LapanganFutsal(String namaLapangan, String jenisLapangan, int hargaSewa) {
        super(namaLapangan, jenisLapangan, hargaSewa);
    }
}

class LapanganBadminton extends Lapangan {

    LapanganBadminton(String namaLapangan, String jenisLapangan, int hargaSewa) {
        super(namaLapangan, jenisLapangan, hargaSewa);
    }
}

public class Penyewaanlapangan {

    public static void main(String[] args) {

        
        Lapangan lapangan1 = new Lapangan(
                "Lapangan A", "Futsal", 100000
        );

        Lapangan lapangan2 = new Lapangan(
                "Lapangan B", "Badminton", 50000
        );

        System.out.println("DATA AWAL LAPANGAN");
        lapangan1.tampilkanInfo();

        System.out.println();

        
        System.out.println("Nama lapangan: " + lapangan1.getNamaLapangan());
        System.out.println("Jenis lapangan: " + lapangan1.getJenisLapangan());
        System.out.println("Harga sewa: Rp" + lapangan1.getHargaSewa());

        
        System.out.println("\nPERUBAHAN DATA");

        
        lapangan1.setHargaSewa(120000);
        System.out.println("Harga sewa setelah diubah: Rp"
                + lapangan1.getHargaSewa());

        
        lapangan1.setHargaSewa(-50000);

        System.out.println("\nDATA AKHIR");
        lapangan1.tampilkanInfo();

        System.out.println("\nINHERITANCE");

        LapanganFutsal futsal = new LapanganFutsal(
                "Lapangan Futsal", "Futsal", 100000
        );

        LapanganBadminton badminton = new LapanganBadminton(
                "Lapangan Badminton", "Badminton", 50000
        );

        futsal.tampilkanInfo();

        System.out.println();

        badminton.tampilkanInfo();
    }
}