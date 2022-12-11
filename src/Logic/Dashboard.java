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
    private int totalStock;
    private int totalPemasukan;
    private int totalBarangTerjual;
    private int labaBersih;
    private int totalObatExp;
    public String date(){
        LocalDateTime myDateObj = LocalDateTime.now();   
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    }
    public String dateStart(){
        LocalDateTime myDateObj = LocalDateTime.now();   
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd 00-00-00");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    }
    public String dateEnd(){
        LocalDateTime myDateObj = LocalDateTime.now();   
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd 23-59-59");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    }
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
        String queryCek = "SELECT SUM(total_harga) AS jml FROM transaksi WHERE tgl_transaksi BETWEEN '"+dateStart+"' AND '"+dateEnd+"'";
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
    public int obatExp(){
         try {
        String queryCek = "SELECT COUNT(*) AS jml FROM detail_obat WHERE tgl_kadaluarsa BETWEEN '"+date()+"' AND '"+dateExp()+"'";
        Connection koneksi = (Connection) conn.configDB();
        Statement pstCek = koneksi.createStatement();
        ResultSet res = pstCek.executeQuery(queryCek);
        if(res.next()){
            totalObatExp = res.getInt("jml");
        }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         return totalObatExp;
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
    public String dateExp(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        c.add(Calendar.DATE, 30);
        dt = c.getTime();
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        String result = dt1.format(dt);
        return result;
    }
    public String dateMonthAgo(){
        LocalDate thirtyDaysAgo = LocalDate.parse(date()).minusDays(30);
        return String.valueOf(thirtyDaysAgo);
    }
    public static void main(String[] args) {
        Dashboard db = new Dashboard();
        System.out.println(db.obatExp());
        System.out.println(db.dateExp());
//        System.out.println(db.labaBersih(db.dateMonthAgo(),db.dateEnd()));
//        System.out.println(db.labaBersih(db.dateStart(),db.dateEnd()));
//        System.out.println(db.dateStart());
//        System.out.println(db.dateEnd());
    }
    
    
}
