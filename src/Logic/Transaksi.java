/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;



import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import koneksi.conn;

/**
 *
 * @author WINDOWS 10
 */
public class Transaksi {
    public int resultKode;
    public int getId;

   
   public String typeDate(){
        LocalDateTime myDateObj = LocalDateTime.now();  
//        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return formattedDate;
    } 
   public int kodeTransaksi(){
       try {
       Statement st = (Statement)conn.configDB().createStatement();
       ResultSet res = st.executeQuery("SELECT * FROM transaksi ORDER BY kode_transaksi DESC");
       
       if(res.next()){
           int kode = res.getInt("kode_transaksi");
           resultKode = kode + 1;
       }
       
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
       }
       return resultKode;
   }
   
   
   //Bagian Method untuk menangani laporan transaksi
        public boolean getData(){
        try{
        String sql = "SELECT * FROM transaksi JOIN transaksi ON detail_transaksi.kode_transaksi ";
        Connection koneksi = (Connection)conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
        return res.next();
    }catch(Exception e){
        return false;
    }
    }
        
     
//   public int getKode(String nama){
//         try {
//           Statement st = (Statement) conn.configDB().createStatement();
//            ResultSet res = st.executeQuery("SELECT * FROM obat WHERE nama = '"+ nama +"'");
//            while(res.next()){
//                getId = res.getInt("kode_obat");  
//            }
//            return getId;
//       } catch (Exception e) {
//           JOptionPane.showMessageDialog(null, e);
//       }
//       return getId;
//   }
   
}
