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
public class Dashboard {
    private int totalStock;
    private int totalPemasukan;
    private int totalBarangTerjual;
    
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
        String queryCek = "SELECT SUM(total_harga) AS jml FROM transaksi";
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
    
    public int barangTerjual(){
        try {
        String queryCek = "SELECT SUM(banyak_barang) AS jml FROM detail_transaksi";
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
        Dashboard db = new Dashboard();
        System.out.println(db.Pemasukan());
    }
    
    
}
