/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author WINDOWS 10
 */
public class listData {

    public int kode_obat;
    public int id_detail;
    public String nama;
    public int harga;
    public int banyak;
    public int total;
    public int stok;
    public int diskon;
    public int subDiskon;
    public String jenis;
    public int dosis;
    
    public listData(int kode_obat, int id_detail, String nama,int harga, int banyak, int total, int diskon,int subDiskon){
        this.kode_obat = kode_obat;
        this.id_detail = id_detail;
        this.nama = nama;
        this.harga = harga;
        this.banyak = banyak;
        this.total = total;
        this.diskon = diskon;
        this.subDiskon = subDiskon;
    }   
    public listData(int stok, String nama,String jenis,int dosis, int harga, int id_detail){
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.id_detail = id_detail;
        this.jenis = jenis;
        this.dosis = dosis;
    }
//    public int jumlah (){
//        int result = this.harga * this.banyak;
//        return result;
//    }
   

}
