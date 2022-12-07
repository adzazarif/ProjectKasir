/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
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
    public String dateAwal(){
        LocalDateTime myDateObj = LocalDateTime.now();   
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd 00-01-00");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    }
    public String dateAkhir(){
        LocalDateTime myDateObj = LocalDateTime.now();   
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd 23-59-00");  
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
    
    public int Pemasukan(){
        try {
        String queryCek = "SELECT SUM(total_harga) AS jml FROM transaksi WHERE tgl_transaksi BETWEEN '"+dateAwal()+"' AND '"+dateAkhir()+"'";
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
    
    public static void a(){
    Date dt = new Date();
    Calendar c = Calendar.getInstance(); 
    c.setTime(dt); 
    c.add(Calendar.DATE, 1);
    dt = c.getTime();
    SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
    System.out.println(dt1.format(dt));
//        System.out.println(dt);
    }
//    public int barangTerjual(){
//        try {
//        String queryCek = "SELECT SUM(detail_transaksi.banyak_barang) AS jml FROM detail_transaksi JOIN transaksi"
//                + "ON detail_transaksi.kode_transasksi = transaksi.kode_transaksi WHERE transai.tgl_transaksi = '"+date()+"'";
//        Connection koneksi = (Connection) conn.configDB();
//        Statement pstCek = koneksi.createStatement();
//        ResultSet res = pstCek.executeQuery(queryCek);
//        if(res.next()){
//            this.totalBarangTerjual = res.getInt("jml");
//        }    
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
//        return this.totalBarangTerjual;
//    }
    public static void main(String[] args) {
//        Dashboard db = new Dashboard();
//        System.out.println(db.Pemasukan());
        a();
    }
    
    
}
