/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import View.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import koneksi.conn;

/**
 *
 * @author WINDOWS 10
 */

public class login {
    public static String level;
    public boolean log(String username, String pass){
        try {
            String query = "SELECT * FROM user WHERE email ='"+ username +"' AND password ='" + pass + "'";
            Connection koneksi = (Connection)conn.configDB();
            PreparedStatement pst = koneksi.prepareStatement(query);
            ResultSet res = pst.executeQuery();
            if(res.next()){
                String lvl = res.getString("level");
                this.level = lvl;
                if(lvl.equals("admin")){
//                    new View.Login().setVisible(false);
//                    new View.DashboarAdmin().setVisible(true);
                      return true;
                }else{
                    return true;
//                    new View.Login().setVisible(false);
//                    new View.DashboardKasir().setVisible(true);
                    
                }

                
            }else{
//                JOptionPane.showMessageDialog(null, "username dan password salah");
                  return false;
            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
return false;
        }
    }
}
