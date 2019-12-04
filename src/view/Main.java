package view;

import controller.daoMahasiswa;
import java.util.List;
import java.util.Scanner;
import model.TbMahasiswa;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        int pilihan, nim;
        do {
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.print("1.Read Data\n ");
        System.out.print("2.Insert Data\n ");
        System.out.print("3.Update Data\n");
        System.out.print("4.Delete Data\n");
        System.out.print("(untuk berhenti tekan nomor lain selain yang tertera)\n");
        System.out.print("________________________\n");
        System.out.print("masukan pilihan: ");
        pilihan = input.nextInt();
        System.out.print("\n________________________\n");
        

          switch(pilihan){
            
 case 1:
             //SELECT
     daoMahasiswa dm = new daoMahasiswa();
        List<TbMahasiswa> listMhs = dm.getAllMahasiswa();
        for (int i = 0; i < listMhs.size(); i++) {
            System.out.println("Mahasiswa ke-" + (i + 1));
            System.out.println("NIM : " + listMhs.get(i).getNim());
            System.out.println("Nama : " + listMhs.get(i).getNama());
            System.out.println("Progdi : " + listMhs.get(i).getProgdi());
            System.out.println("");
        }
        break;
 case 2:
      //INSERT
        TbMahasiswa mhs = new TbMahasiswa();
        System.out.println("Nim : ");
        mhs.setNim(input.nextInt());
        System.out.println("Nama : ");
        mhs.setNama(text.nextLine());
        System.out.println("Progdi: ");
        mhs.setProgdi(text.nextLine());
        daoMahasiswa in = new daoMahasiswa();
        in.insertMahasiswa(mhs);
        
        System.out.println("Data berhasil di-input");
     break;
 case 3:
     //UPDATE
     daoMahasiswa up = new daoMahasiswa();
         List<TbMahasiswa> listMhsw = up.getAllMahasiswa();
         System.out.println("masukan NIM:");
         int NIM = input.nextInt();
       
             for (int i = 0; i < listMhsw.size(); i++)
             if (NIM == listMhsw.get(i).getNim()){
            System.out.println("Mahasiswa ke-" + (i + 1));
            System.out.println("NIM : " + listMhsw.get(i).getNim());
            System.out.println("Nama : " + listMhsw.get(i).getNama());
            System.out.println("Progdi : " + listMhsw.get(i).getProgdi());
            System.out.println("");
        }
        TbMahasiswa mhsw = new TbMahasiswa();
        System.out.println("UPDATE");
        System.out.println("masukan NIM:");
        mhsw.setNim(input.nextInt());
        System.out.println("Nama : ");
        mhsw.setNama(text.nextLine());
        System.out.println("Progdi: ");
        mhsw.setProgdi(text.nextLine());
//        mhsw.setNim(702015001);
//        mhsw.setNama("Santi");
//        mhsw.setProgdi("PTIK");
        
        up.updateMahasiswa(mhsw);
break;
 case 4:
     //DELETE
        daoMahasiswa dl = new daoMahasiswa();
        List<TbMahasiswa> listMhswa = dl.getAllMahasiswa();
       System.out.println("masukan NIM mahasiswa yang ingin dihapus:");
        nim = input.nextInt();
       
             for (int i = 0; i < listMhswa.size(); i++)
             if (nim == listMhswa.get(i).getNim()){
            System.out.println("Mahasiswa ke-" + (i + 1));
            System.out.println("NIM : " + listMhswa.get(i).getNim());
            System.out.println("Nama : " + listMhswa.get(i).getNama());
            System.out.println("Progdi : " + listMhswa.get(i).getProgdi());
            System.out.println("");
        }
 
        TbMahasiswa mhswa = dl.getMahasiswa(nim);
        
        
        System.out.println("ingin hapus?");
        System.out.println("1.ya");
        System.out.println("2.tidak");
        int pilih =input.nextInt();
        if (pilih == 1){
         dl.deleteMahasiswa(mhswa);
            System.out.println("Data telah dihapus");
        } else{
            return;
        }
        
     break;
          } 
        }while(0 < pilihan && pilihan <=4);
    }
}
