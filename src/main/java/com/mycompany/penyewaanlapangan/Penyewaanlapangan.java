
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
    
   
    String namaLapangan;
    String jenisLapangan;
    int hargaSewa;

    
    Lapangan(String namaLapangan, String jenisLapangan, int hargaSewa) {
        this.namaLapangan = namaLapangan;
        this.jenisLapangan = jenisLapangan;
        this.hargaSewa = hargaSewa;
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
        
        System.out.println("DATA LAPANGAN");
        
        lapangan1.tampilkanInfo();

        System.out.println();

        lapangan2.tampilkanInfo();
    }
}
