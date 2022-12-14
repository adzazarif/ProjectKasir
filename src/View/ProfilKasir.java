/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import koneksi.conn;

/**
 *
 * @author WINDOWS 10
 */
public class ProfilKasir extends javax.swing.JFrame {
 Logic.login lg = new Logic.login();
    /**
     * Creates new form ProfilKasir
     */
    public ProfilKasir() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        this.setVisible(true);
        loadData();
    }

    public void loadData(){
        lblNama1.setText(lg.nama);
        try {
         
            String sql = "SELECT * FROM user WHERE id = '"+lg.userId+"'";
            Connection koneksi = (Connection)conn.configDB();
            Statement stm = koneksi.createStatement();
            ResultSet res = stm.executeQuery(sql);
            if(res.next()){
                String password = res.getString("password");
                password = "*".repeat(password.length());
                lblNama.setText(res.getString("nama"));
                lblUsername.setText(hash(res.getString("username")));
                lblEmail.setText(hash(res.getString("email")));
                lblLevel.setText(res.getString("level"));
                lblPass.setText(password);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    public String hash(String kata){
        String awalan = kata.substring(0,2);
        String star = "*".repeat(kata.length()-4);
        String akhir = kata.substring(kata.length()-2,kata.length());
        String result = awalan+star+akhir;
        return result;
    }
    
    public void bersih(){
        txtEmail.setText("");
        txtUsername.setText("");
        txtPass.setText("");
        txtUlangiPass.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNama1 = new javax.swing.JLabel();
        btnTransaksi = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        cmbUser = new javax.swing.JComboBox<>();
        txtUlangiPass = new javax.swing.JPasswordField();
        btnUbah = new javax.swing.JLabel();
        btnKonfirmasi = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblNama1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNama1.setText("jLabel2");
        getContentPane().add(lblNama1);
        lblNama1.setBounds(1140, 10, 130, 30);

        btnTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseClicked(evt);
            }
        });
        getContentPane().add(btnTransaksi);
        btnTransaksi.setBounds(10, 220, 250, 50);

        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
        });
        getContentPane().add(btnDashboard);
        btnDashboard.setBounds(10, 150, 250, 50);

        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPass.setBorder(null);
        txtPass.setEnabled(false);
        getContentPane().add(txtPass);
        txtPass.setBounds(880, 550, 390, 30);

        cmbUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Menu----", "Profil", "Logout" }));
        cmbUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUserActionPerformed(evt);
            }
        });
        getContentPane().add(cmbUser);
        cmbUser.setBounds(1140, 50, 130, 26);

        txtUlangiPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUlangiPass.setBorder(null);
        txtUlangiPass.setEnabled(false);
        getContentPane().add(txtUlangiPass);
        txtUlangiPass.setBounds(880, 630, 390, 30);

        btnUbah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUbahMouseClicked(evt);
            }
        });
        getContentPane().add(btnUbah);
        btnUbah.setBounds(1000, 680, 150, 50);

        btnKonfirmasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKonfirmasiMouseClicked(evt);
            }
        });
        getContentPane().add(btnKonfirmasi);
        btnKonfirmasi.setBounds(470, 680, 160, 50);

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUsername.setBorder(null);
        getContentPane().add(txtUsername);
        txtUsername.setBounds(360, 550, 390, 30);

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmail.setBorder(null);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(360, 630, 390, 30);

        lblNama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblNama);
        lblNama.setBounds(460, 130, 360, 30);

        lblUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblUsername);
        lblUsername.setBounds(460, 180, 360, 30);

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblEmail);
        lblEmail.setBounds(460, 230, 360, 30);

        lblPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblPass);
        lblPass.setBounds(460, 330, 360, 30);

        lblLevel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblLevel);
        lblLevel.setBounds(460, 270, 360, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profil kasir.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1407, 768);

        setBounds(0, 0, 1560, 905);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseClicked
        this.setVisible(false);
        this.dispose();
        new TransaksiKasir().setVisible(true);
    }//GEN-LAST:event_btnTransaksiMouseClicked

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        this.setVisible(false);
        this.dispose();
        new DashboardKasir().setVisible(true);
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void cmbUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUserActionPerformed
        String menu = String.valueOf(cmbUser.getSelectedItem());
        switch(menu){
            case "Profil":
            this.setVisible(false);
            this.dispose();
            new ProfilKasir().setVisible(true);
            break;
            case "Logout":
            this.setVisible(false);
            this.dispose();
            lg.logOut();
            break;
        }
    }//GEN-LAST:event_cmbUserActionPerformed

    private void btnUbahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUbahMouseClicked
        String pass = txtPass.getText();
        String ulangiPass =txtUlangiPass.getText();
        if(pass.equals(ulangiPass)){
            if(lg.gantiPass(pass)){
                JOptionPane.showMessageDialog(rootPane, "Password berhasil diganti yang baru");
                bersih();
            }else{
                JOptionPane.showMessageDialog(rootPane, "password gagal di diganti");
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Password tidak sama");
        }
    }//GEN-LAST:event_btnUbahMouseClicked

    private void btnKonfirmasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKonfirmasiMouseClicked
        String email = txtEmail.getText();
        String username = txtUsername.getText();
        if(lg.konfirmasiLupaPasswordUser(username, email)){
            JOptionPane.showMessageDialog(rootPane, "konfimasi berhasil.Silahkan mengganti password baru");
            txtUlangiPass.enable();
            txtPass.enable();
        }else{
            JOptionPane.showMessageDialog(rootPane, "konfimasi tidak berhasil. Cek kembali username dan email anda");
        }
    }//GEN-LAST:event_btnKonfirmasiMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProfilKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfilKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfilKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfilKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfilKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnKonfirmasi;
    private javax.swing.JLabel btnTransaksi;
    private javax.swing.JLabel btnUbah;
    private javax.swing.JComboBox<String> cmbUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNama1;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtUlangiPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
