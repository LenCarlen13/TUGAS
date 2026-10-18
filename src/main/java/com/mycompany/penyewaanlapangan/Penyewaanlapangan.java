package com.mycompany.Penyewaanlapangan;

import java.util.ArrayList;
import java.util.List;

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

// Custom Exception
class DurasiSewaTidakValidException extends Exception {
    DurasiSewaTidakValidException(String pesan) {
        super(pesan);
    }
}

class ValidasiSewa {
    static void validasiDurasi(int durasi)
            throws DurasiSewaTidakValidException {
        if (durasi <= 0 || durasi > 24) {
            throw new DurasiSewaTidakValidException(
                    "Durasi sewa harus antara 1 sampai 24 jam."
            );
        }

        System.out.println("Durasi sewa valid: " + durasi + " jam.");
    }
}

// Association
class Penyewa {
    private String nama;

    Penyewa(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
}

class Petugas {
    private String nama;

    Petugas(String nama) {
        this.nama = nama;
    }

    void layaniPenyewa(Penyewa penyewa) {
        System.out.println(nama + " melayani penyewa "
                + penyewa.getNama() + ".");
    }
}

// Aggregation
class PengelolaLapangan {
    private String nama;
    private List<Lapangan> daftarLapangan = new ArrayList<>();

    PengelolaLapangan(String nama) {
        this.nama = nama;
    }

    void tambahLapangan(Lapangan lapangan) {
        daftarLapangan.add(lapangan);
    }

    void tampilkanLapangan() {
        System.out.println("Pengelola: " + nama);
        for (Lapangan lapangan : daftarLapangan) {
            lapangan.tampilkanInfo();
            System.out.println();
        }
    }
}

// Composition
class DetailPenyewaan {
    private String namaLapangan;
    private int durasi;
    private int totalHarga;

    DetailPenyewaan(String namaLapangan, int durasi, int hargaPerJam) {
        this.namaLapangan = namaLapangan;
        this.durasi = durasi;
        this.totalHarga = durasi * hargaPerJam;
    }

    void tampilkanDetail() {
        System.out.println("Nama Lapangan : " + namaLapangan);
        System.out.println("Durasi        : " + durasi + " jam");
        System.out.println("Total Harga   : Rp" + totalHarga);
    }
}

class TransaksiPenyewaan {
    private String kodeTransaksi;
    private DetailPenyewaan detail;

    TransaksiPenyewaan(String kodeTransaksi, String namaLapangan,
            int durasi, int hargaPerJam) {
        this.kodeTransaksi = kodeTransaksi;
        this.detail = new DetailPenyewaan(
                namaLapangan, durasi, hargaPerJam
        );
    }

    void tampilkanTransaksi() {
        System.out.println("Kode Transaksi: " + kodeTransaksi);
        detail.tampilkanDetail();
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

        System.out.println("\nEXCEPTION HANDLING");

        try {
            ValidasiSewa.validasiDurasi(2);
            ValidasiSewa.validasiDurasi(0);
        } catch (DurasiSewaTidakValidException e) {
            System.out.println("Penyewaan gagal: " + e.getMessage());
        } finally {
            System.out.println("Proses validasi penyewaan selesai.");
        }

        System.out.println("\nMULTI-CATCH");

        try {
            int angka = Integer.parseInt("abc");
            System.out.println(100 / angka);
        } catch (NumberFormatException | ArithmeticException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }

        System.out.println("\nASSOCIATION");

        Penyewa penyewa = new Penyewa("Carlen");
        Petugas petugas = new Petugas("Asyam");
        petugas.layaniPenyewa(penyewa);

        System.out.println("\nAGGREGATION");

        PengelolaLapangan pengelola = new PengelolaLapangan("Pak Budi");
        pengelola.tambahLapangan(lapangan1);
        pengelola.tambahLapangan(lapangan2);
        pengelola.tampilkanLapangan();

        System.out.println("\nCOMPOSITION");

        TransaksiPenyewaan transaksi = new TransaksiPenyewaan(
                "TRX001", "Lapangan Futsal", 2, 100000
        );
        transaksi.tampilkanTransaksi();
    }
}