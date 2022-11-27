/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.conn;

/**
 *
 * @author WINDOWS 10
 */
public class Obat {
    public boolean tambah(String nama,String jenis,String kategori,int stok, int dosis, int harga_beli, int harga_jual, String tgl_exp, String ket){
          try {
            Connection koneksi = (Connection)conn.configDB();
            String queryObat = "INSERT INTO obat (`nama`, `jenis`, `kategori`) VALUES ('"
                                                             + nama + "','"
                                                             + jenis + "','"
                                                             + kategori + "');";
            PreparedStatement pstObat = koneksi.prepareStatement(queryObat);
            pstObat.execute();
            String queryCek = "SELECT * FROM obat WHERE nama = '" + nama +"' ORDER BY kode_obat DESC";
            Statement pstCek = koneksi.createStatement();
            ResultSet res = pstCek.executeQuery(queryCek);
            
            if(!res.next()){
                return false;
            }
            int kode_obat = res.getInt("kode_obat");
            String queryDetail = "INSERT INTO detail_obat (`kode_obat`, `stok`, `dosis`,`harga_beli`, `harga_jual`, `tgl_kadaluarsa`, `keterangan`) VALUES ('"
                                                             + kode_obat + "','"
                                                             + stok + "','"
                                                             + dosis + "','"
                                                             + harga_beli + "','"
                                                             + harga_jual + "','"
                                                             + tgl_exp + "','"
                                                             + ket + "');";
            PreparedStatement pstDetail = koneksi.prepareStatement(queryDetail);
            pstDetail.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean hapus(int id){
        try {
            Statement st = (Statement) conn.configDB().createStatement();
            Connection koneksi = (Connection)conn.configDB();
            //delete di tabel detail_obat
            String queryHapusDetail = "DELETE FROM detail_obat WHERE kode_obat = '" + id + "'";
            PreparedStatement pstHapusDetail = koneksi.prepareStatement(queryHapusDetail);
            pstHapusDetail.execute();
            //delete di tabel obat
            String queryHapusObat = "DELETE FROM obat WHERE kode_obat = '" + id + "'";
            PreparedStatement pstHapusObat = koneksi.prepareStatement(queryHapusObat);
            pstHapusObat.execute();
            
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void main(String[] args) {
        Obat obat = new Obat();
         obat.hapus(14);
//        if(hapus){
//            JOptionPane.showMessageDialog(null, "data behasil di hapus");
//        }else{
//            JOptionPane.showMessageDialog(null, "data gagal di hapus");
//        }
    }
}
