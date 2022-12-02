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
public class Pengguna {
    public boolean tambah (String nama,String username, String email, String level, String pass){
        try {
            Connection koneksi = (Connection)conn.configDB();
            String queryUser = "INSERT INTO user (`nama`, `username`, `email`,`level`,`password`) VALUES ('"
                                                             + nama + "','"
                                                             + username + "','"
                                                             + email + "','"
                                                             + level + "','"
                                                             + pass + "');";
            PreparedStatement pstUser = koneksi.prepareStatement(queryUser);
            pstUser.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean edit(int userId,String nama,String username, String email, String level, String pass){
        try {
            String query = "UPDATE user SET nama='"+nama
                    +"',username ='"+username+"',email='"+email+"',level= '"
                    +level+"',password= '"+pass
                    +"'WHERE id = '"+userId+"'";       
            Connection koneksi = (Connection)conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(query);
            pst.execute();
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
            String query = "DELETE FROM user WHERE id = '" + id + "'";
            PreparedStatement pstHapusDetail = koneksi.prepareStatement(query);
            pstHapusDetail.execute();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean getData(){
        try{
        String sql = "select * from user ";
        Connection koneksi = (Connection)conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
        return res.next();
    }catch(Exception e){
        return false;
    }
    }
}
