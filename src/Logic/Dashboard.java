/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import koneksi.conn;
/**
 *
 * @author WINDOWS 10
 */
public class Dashboard {
    
    Util util = new Util();
    
    private int totalStock;
    private int totalPemasukan;
    private int totalBarangTerjual;
    private int labaBersih;
    private int totalObatHampirExp;
    private int totalObaSudahExp;
    private int dataObaSudahExp;

    public int stockObat(){
        
        try {
        String queryCek = "SELECT SUM(stok) AS jml FROM detail_obat";
        Connection koneksi = (Connection) conn.configDB();
        Statement pstCek = koneksi.createStatement();
        ResultSet res = pstCek.executeQuery(queryCek);
        if(res.next()){
            this.totalStock = res.getInt("jml");
        }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return this.totalStock;
    }
    
    public int Pemasukan(String dateStart ,String dateEnd ){
        try {
        String queryCek = "SELECT SUM(grand_total) AS jml FROM transaksi WHERE tgl_transaksi BETWEEN '"+dateStart+"' AND '"+dateEnd+"'";
        Connection koneksi = (Connection) conn.configDB();
        Statement pstCek = koneksi.createStatement();
        ResultSet res = pstCek.executeQuery(queryCek);
        if(res.next()){
            this.totalPemasukan = res.getInt("jml");
        }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return this.totalPemasukan;
    }
    
    public int labaBersih(String dateStart,String dateEnd){
        try {
        String queryCek = "SELECT SUM(detail_obat.harga_jual) AS hargaJual, SUM(detail_obat.harga_beli) AS hargaBeli FROM detail_transaksi JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi WHERE transaksi.tgl_transaksi BETWEEN '"+dateStart+"' AND '"+dateEnd+"'";
        Connection koneksi = (Connection) conn.configDB();
        Statement pstCek = koneksi.createStatement();
        ResultSet res = pstCek.executeQuery(queryCek);
        if(res.next()){
            int hargaJual = res.getInt("hargaJual");
            int hargaBeli = res.getInt("hargaBeli");
            labaBersih = hargaJual - hargaBeli;
        }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return labaBersih;
    }

    //Method untuk menghitung jumlah stok obat yang hampir exp
    public int obatHampirExp(){
         try {
        String queryCek = "SELECT SUM(detail_obat.stok) AS jml FROM detail_obat WHERE tgl_kadaluarsa BETWEEN '"+util.date()+"' AND '"+util.dateExp()+"'";
        Connection koneksi = (Connection) conn.configDB();
        Statement pstCek = koneksi.createStatement();
        ResultSet res = pstCek.executeQuery(queryCek);
        if(res.next()){
            totalObatHampirExp = res.getInt("jml");
        }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return totalObatHampirExp;
    }
    
    //Method untuk menghitung jumlah stok obat yang sudah exp
    public int obatSudahExp(){
          try {
        String queryCek = "SELECT SUM(detail_obat.stok) AS jml FROM detail_obat WHERE tgl_kadaluarsa <= '"+util.date()+"'";
        Connection koneksi = (Connection) conn.configDB();
        Statement pstCek = koneksi.createStatement();
        ResultSet res = pstCek.executeQuery(queryCek);
        if(res.next()){
            totalObaSudahExp = res.getInt("jml");
        }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return totalObaSudahExp;
    }
    
    //Method untuk menghitung jumlah berapa banyak data obat yang sudah exp
    public int dataObatSudahExp(){
          try {
        String queryCek = "SELECT COUNT(*) AS jml FROM detail_obat WHERE tgl_kadaluarsa <= '"+util.date()+"'";
        Connection koneksi = (Connection) conn.configDB();
        Statement pstCek = koneksi.createStatement();
        ResultSet res = pstCek.executeQuery(queryCek);
        if(res.next()){
            dataObaSudahExp = res.getInt("jml");
        }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return dataObaSudahExp;
    }
    
    public int barangTerjual(String dateStart, String dateEnd){
        try {
        String queryCek = "SELECT SUM(detail_transaksi.banyak_barang) AS jml FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi WHERE transaksi.tgl_transaksi BETWEEN '"+dateStart+"' AND '"+dateEnd+"'";
        Connection koneksi = (Connection) conn.configDB();
        Statement pstCek = koneksi.createStatement();
        ResultSet res = pstCek.executeQuery(queryCek);
        if(res.next()){
            this.totalBarangTerjual = res.getInt("jml");
        }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return this.totalBarangTerjual;
    }


    public static void main(String[] args) {
//        Dashboard db = new Dashboard();
//        System.out.println(db.obatExp());
//        System.out.println(db.dateExp());
//        System.out.println(db.labaBersih(db.dateMonthAgo(),db.dateEnd()));
//        System.out.println(db.labaBersih(db.dateStart(),db.dateEnd()));
//        System.out.println(db.dateStart());
//        System.out.println(db.dateEnd());
    }
    
    
}
