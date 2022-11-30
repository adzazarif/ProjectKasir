/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import com.sun.jdi.connect.spi.Connection;
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
public class Transaksi {
    public int resultKode;
    public int getId;

   public String date(){
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");  
    
        String formattedDate = myDateObj.format(myFormatObj);  
        System.out.println(formattedDate);
        return formattedDate;
    } 
   public int kodeTransaksi(){
       try {
       Statement st = (Statement)conn.configDB().createStatement();
       ResultSet res = st.executeQuery("SELECT * FROM obat ORDER BY kode_obat DESC");
       
       if(res.next()){
           int kode = res.getInt("kode_obat");
           resultKode = kode + 1;
       }
       
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);
       }
       return resultKode;
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
