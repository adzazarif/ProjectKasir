/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import koneksi.conn;

/**
 *
 * @author WINDOWS 10
 */
public class Obat {
       public String date(){
        LocalDateTime myDateObj = LocalDateTime.now();   
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    } 
       
    public boolean tambah(String nama,String jenis,String kategori,String stok, String dosis, String harga_beli, String harga_jual, String tgl_exp, String ket){
          try {
            Connection koneksi = (Connection)conn.configDB();
            String queryObat = "INSERT INTO obat (`nama`, `kategori`) VALUES ('"
                                                             + nama + "','"
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
            String queryDetail = "INSERT INTO detail_obat (`kode_obat`,`jenis`,`stok`, `dosis`,`harga_beli`, `harga_jual`, `tgl_kadaluarsa`, `tgl_masuk`,`keterangan`) VALUES ('"
                                                             + kode_obat + "','"
                                                             + jenis + "','"
                                                             + stok + "','"
                                                             + dosis + "','"
                                                             + harga_beli + "','"
                                                             + harga_jual + "','"
                                                             + tgl_exp + "','"
                                                             + date() + "','"
                                                             + ket + "');";
            PreparedStatement pstDetail = koneksi.prepareStatement(queryDetail);
            pstDetail.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean edit(int kode_obat, String nama,String jenis,String kategori,String stok, String dosis, String harga_beli, String harga_jual, String tgl_exp, String ket){
        try {
            Statement st = (Statement) conn.configDB().createStatement();
            st.executeUpdate("UPDATE obat SET "
                                                            + "nama = '" + nama + "',"
                                                            + "kategori = '" + kategori + "' WHERE kode_obat ='" + kode_obat + "'" );
            
            st.executeUpdate("UPDATE detail_obat SET "
                                                            + "stok = '" + stok + "',"
                                                            + "jenis = '" + jenis + "',"
                                                            + "dosis = '" + dosis + "',"
                                                            + "harga_beli = '" + harga_beli + "',"
                                                            + "harga_jual = '" + harga_jual + "',"
                                                            + "tgl_kadaluarsa = '" + tgl_exp + "',"
                                                            + "keterangan = '" + ket + "' WHERE kode_obat ='" + kode_obat + "'" );
            return true;
//            JOptionPane.showMessageDialog(null, "data behasil di update");
        } catch (Exception e) {
            return false;
//            JOptionPane.showMessageDialog(null, "data gagal di update");
        }
    }
    
    public boolean hapus(int id){
        try {
            Statement st = (Statement) conn.configDB().createStatement();
            Connection koneksi = (Connection)conn.configDB();
            //delete di tabel detail_obat
            String queryHapusTransaksi = "DELETE FROM detail_transaksi WHERE kode_obat = '" + id + "'";
            PreparedStatement pstHapusTransaksi = koneksi.prepareStatement(queryHapusTransaksi);
            pstHapusTransaksi.execute();
            
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
    //method untuk menambahkan detail obat
    public boolean tambahDetail(String kode_obat,String jenis, String dosis, String stok, String harga_jual, String harga_beli, String tgl_exp,String ket){
        try {
            Connection koneksi = (Connection)conn.configDB();
              String queryDetail = "INSERT INTO detail_obat (`kode_obat`,`jenis`,`stok`, `dosis`,`harga_beli`, `harga_jual`, `tgl_kadaluarsa`,`tgl_masuk`, `keterangan`) VALUES ('"
                                                             + kode_obat + "','"
                                                             + jenis + "','"
                                                             + stok + "','"
                                                             + dosis + "','"
                                                             + harga_beli + "','"
                                                             + harga_jual + "','"
                                                             + tgl_exp + "','"
                                                             + date() + "','"
                                                             + ket + "');";
            PreparedStatement pstDetail = koneksi.prepareStatement(queryDetail);
            pstDetail.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean hapusObatExp(int id){
        try {
            Statement st = (Statement) conn.configDB().createStatement();
            Connection koneksi = (Connection)conn.configDB();
            //delete di tabel detail_obat
            String queryHapusDetail = "DELETE FROM detail_obat WHERE id_detail = '" + id + "'";
            PreparedStatement pstHapusDetail = koneksi.prepareStatement(queryHapusDetail);
            pstHapusDetail.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean hapusSemuaObatExp(String tanggal){
        try {
            Statement st = (Statement) conn.configDB().createStatement();
            Connection koneksi = (Connection)conn.configDB();
            //delete di tabel detail_obat
            String queryHapusDetail = "DELETE FROM detail_obat WHERE tgl_kadaluarsa <= '" + tanggal + "'";
            PreparedStatement pstHapusDetail = koneksi.prepareStatement(queryHapusDetail);
            pstHapusDetail.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
         
     public boolean filter(String nama, String jenis, String kategori){
        try{
        String sql = "SELECT * FROM obat JOIN detail_transaksi ON obat.kode_obat = detail_obat = kode_obat WHERE "
                + "nama ='"+ nama+"' OR jenis = '"+jenis+ "' OR kategori = "+kategori+"'";
        Connection koneksi = (Connection)conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
        return res.next();
    }catch(Exception e){
        return false;
    }
    }
     public static void main(String[] args) {
//        Obat o = new Obat();
//        o.tam
    }
}