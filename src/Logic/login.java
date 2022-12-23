/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import View.Login;
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

public class login {
    public static String level;
    public static int userId;
    public static String nama;
    
    public boolean log(String username, String pass){
        try {
            String query = "SELECT * FROM user WHERE username ='"+ username +"' AND password ='" + pass + "'";
            Connection koneksi = (Connection)conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            if(res.next()){
                String lvl = res.getString("level");
                this.level = lvl;
                this.userId = res.getInt("id");
                this.nama = res.getString("nama");
                return true;
            }else{
                  return false;
            }
        } catch (Exception e) {
                return false;
        }
    }
    
    public boolean konfirmasiLupaPassword(String username, String email){
        try {
            String query = "SELECT * FROM user WHERE username ='"+ username +"' AND email ='" + email + "'";
            Connection koneksi = (Connection)conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            
            if(res.next()){
               this.userId = res.getInt("id");
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean gantiPass(String pass){
        try {
            String query = "UPDATE user SET  password = '" + pass + "' WHERE id ='" + userId + "'";
            Statement st = (Statement) conn.configDB().createStatement();
            st.executeUpdate(query);
          return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    
    public boolean konfirmasiLupaPasswordUser(String username, String email){
        try {
            String query = "SELECT * FROM user WHERE username ='"+ username +"' AND email ='" + email + "' AND id = '"+userId+"'";
            Connection koneksi = (Connection)conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            
            if(res.next()){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
    
        
 
    //method untuk logout
    public void logOut(){
        level = "";
        userId = 0;
        nama = "";
        new Login().setVisible(true);
    }
}
