
package js5;

import java.util.Scanner;

public class JS5 {

      public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        DaftarMahasiswaBerprestasi data = new DaftarMahasiswaBerprestasi();
        int jumMhs = 5;
        
        for (int i = 0; i < jumMhs; i++) {
            System.out.println("Nama : ");
            String  nama = s1.next();
            System.out.println("Tahun Masuk : ");
            int thn = s.nextInt();
            System.out.println("Umur :  ");
            int umur = s.nextInt();
            System.out.println("IPK : ");
            double ipk = s.nextDouble();
            Mahasiswa m = new Mahasiswa(nama, thn, umur, ipk);
            data.tambah(m);
        }
        
        System.out.println("Data Mahasiswa sebelum sorting : ");
        data.tampil();
        
        System.out.println("Data Mahasiswa setelah sorting desc berdasarkan IPK :");
        data.bublesort();
        data.tampil();
        
          System.out.println("Data Mahasiswa setelah sorting asc berdasarkan IPK : ");
        data.selectionsort();
        data.tampil();
        
          System.out.println("Data Mahasiswa setelah di insertion sort berdasarkan IPK : ");
        data.isertionsort();
        data.tampil();
        
        
    }
    
}
