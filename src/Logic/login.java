/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import static kasirapotek.Login.level;
import koneksi.conn;

/**
 *
 * @author WINDOWS 10
 */
public class login {
    public void log(String username, String pass){
        try {
            String query = "SELECT * FROM user WHERE email ='"+ username +"' AND password ='" + pass + "'";
            Connection koneksi = (Connection)conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            if(res.next()){
                admin.ViewDashboard db = new admin.ViewDashboard();
                String lvl = res.getString("level");
                if(lvl.equals("admin")){
                    new kasirapotek.Login().setVisible(false);
                    new admin.ViewDashboard().setVisible(true);
                }else{
                    new kasirapotek.Login().setVisible(false);
                    new kasir.dashboard().setVisible(true);
                    
                }
                level = lvl;
            }else{
                JOptionPane.showMessageDialog(null, "username dan password salah");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
