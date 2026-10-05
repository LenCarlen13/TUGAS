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


abstract class LapanganAbstrak {

    protected String nama;

    LapanganAbstrak(String nama) {
        this.nama = nama;
    }

    abstract void tampilkanJenis();

    void tampilkanNama() {
        System.out.println("Nama Lapangan : " + nama);
    }
}


class FutsalAbstrak extends LapanganAbstrak {

    FutsalAbstrak(String nama) {
        super(nama);
    }

    @Override
    void tampilkanJenis() {
        System.out.println("Jenis Lapangan : Futsal");
    }
}


class BadmintonAbstrak extends LapanganAbstrak {

    BadmintonAbstrak(String nama) {
        super(nama);
    }

    @Override
    void tampilkanJenis() {
        System.out.println("Jenis Lapangan : Badminton");
    }
}


interface BisaDisewa {

    void prosesSewa();

    default void tampilkanStatus() {
        System.out.println("Lapangan dapat disewa.");
    }
}


class LapanganSewa extends LapanganAbstrak implements BisaDisewa {

    LapanganSewa(String nama) {
        super(nama);
    }

    @Override
    void tampilkanJenis() {
        System.out.println("Jenis Lapangan : Lapangan Sewa");
    }

    @Override
    public void prosesSewa() {
        System.out.println("Lapangan sedang disewa.");
    }
}


class ProsesSewa {

    void sewa(String namaLapangan) {
        System.out.println("Menyewa " + namaLapangan);
    }

    void sewa(String namaLapangan, int lamaSewa) {
        System.out.println("Menyewa " + namaLapangan + " selama "
                + lamaSewa + " jam.");
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


        System.out.println("\nABSTRACT CLASS");

        LapanganAbstrak lapanganFutsal = new FutsalAbstrak(
                "Lapangan Futsal A"
        );

        LapanganAbstrak lapanganBadminton = new BadmintonAbstrak(
                "Lapangan Badminton A"
        );

        lapanganFutsal.tampilkanNama();
        lapanganFutsal.tampilkanJenis();

        System.out.println();

        lapanganBadminton.tampilkanNama();
        lapanganBadminton.tampilkanJenis();


        System.out.println("\nINTERFACE");

        LapanganSewa lapanganSewa = new LapanganSewa(
                "Lapangan Sewa A"
        );

        lapanganSewa.tampilkanNama();
        lapanganSewa.tampilkanJenis();
        lapanganSewa.prosesSewa();
        lapanganSewa.tampilkanStatus();


        System.out.println("\nPOLYMORPHISM");

        LapanganAbstrak[] daftarLapangan = {
            new FutsalAbstrak("Lapangan Futsal B"),
            new BadmintonAbstrak("Lapangan Badminton B")
        };

        for (LapanganAbstrak lapangan : daftarLapangan) {
            lapangan.tampilkanNama();
            lapangan.tampilkanJenis();
            System.out.println();
        }


        System.out.println("METHOD OVERLOADING");

        ProsesSewa proses = new ProsesSewa();

        proses.sewa("Lapangan Futsal");
        proses.sewa("Lapangan Badminton", 2);
    }
}