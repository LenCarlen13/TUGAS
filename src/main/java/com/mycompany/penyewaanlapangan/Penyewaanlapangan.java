
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Penyewaanlapangan;

/**
*
*  @author user
*
*/

class Lapangan {

    // Field private
    private String namaLapangan;
    private String jenisLapangan;
    private int hargaSewa;

    // Constructor
    Lapangan(String namaLapangan, String jenisLapangan, int hargaSewa) {
        this.namaLapangan = namaLapangan;
        this.jenisLapangan = jenisLapangan;
        this.hargaSewa = hargaSewa;
    }

    // Getter namaLapangan
    public String getNamaLapangan() {
        return namaLapangan;
    }

    // Setter namaLapangan
    public void setNamaLapangan(String namaLapangan) {
        this.namaLapangan = namaLapangan;
    }

    // Getter jenisLapangan
    public String getJenisLapangan() {
        return jenisLapangan;
    }

    // Setter jenisLapangan
    public void setJenisLapangan(String jenisLapangan) {
        this.jenisLapangan = jenisLapangan;
    }

    // Getter hargaSewa
    public int getHargaSewa() {
        return hargaSewa;
    }

    // Setter hargaSewa dengan validasi
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

public class Penyewaanlapangan {

    public static void main(String[] args) {

        
        Lapangan lapangan1 = new Lapangan(
                "Lapangan A", "Futsal", 100000
        );

        Lapangan lapangan2 = new Lapangan(
                "Lapangan B", "Badminton", 50000
        );

        System.out.println("=== DATA AWAL LAPANGAN ===");
        lapangan1.tampilkanInfo();

        System.out.println();

        
        System.out.println("Nama lapangan: " + lapangan1.getNamaLapangan());
        System.out.println("Jenis lapangan: " + lapangan1.getJenisLapangan());
        System.out.println("Harga sewa: Rp" + lapangan1.getHargaSewa());

        
        System.out.println("\n=== PERUBAHAN DATA ===");

        
        lapangan1.setHargaSewa(120000);
        System.out.println("Harga sewa setelah diubah: Rp"
                + lapangan1.getHargaSewa());

        
        lapangan1.setHargaSewa(-50000);

        System.out.println("\n=== DATA AKHIR ===");
        lapangan1.tampilkanInfo();
    }
}