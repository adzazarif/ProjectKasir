/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Logic.Dashboard;
import javax.swing.JFrame;
import Logic.Util;
import Logic.login;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.JOptionPane;
import koneksi.conn;
/**
 *
 * @author WINDOWS 10
 */
public class DashboardKasir extends javax.swing.JFrame {
     Dashboard db = new Dashboard();
     Util util = new Util();
     login lg = new login();
     
     NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    /**
     * Creates new form DashboardKasir
     */
    public String filter = "Hari";
    public DashboardKasir() {
        initComponents();
          load_data();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        this.setVisible(true);
    }
    
    public void User(){
        
        int id = lg.userId;
         try {
            String queryCek = "SELECT * FROM user WHERE id = '"+id+"'";
            Connection koneksi = (Connection) conn.configDB();
            Statement pstCek = koneksi.createStatement();
            ResultSet res = pstCek.executeQuery(queryCek);
            if(res.next()){
                lblNama.setText(res.getString("nama"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
     public void load_data(){
         lblNama.setText(lg.nama);
            hari();
            if(filter.equals("hari")){
                hari();
            }else if(filter.equals("Bulan")){
                bulan();
            }
    }
     public void hari(){
       
            String date = util.date();
            String sisaStock = String.valueOf(db.stockObat());
            String obatExp = String.valueOf(db.obatHampirExp());
            String danaPemasukan = String.valueOf(nf.format(db.Pemasukan(util.dateStart(), util.dateEnd())));
            String keuntungan = String.valueOf(nf.format(db.labaBersih(util.dateStart(), util.dateEnd())));
            String barangTerjual = String.valueOf(db.barangTerjual(util.dateStart(), util.dateEnd()));
            String obatSudahExp = String.valueOf(db.obatSudahExp());
            lblDate.setText(date);
            lblStokObat.setText(sisaStock);
            lblObatHampirExp.setText(obatExp);
            lblObatSudahExp.setText(obatSudahExp);
            lblDanaPemasukan.setText(danaPemasukan);
            lblKeuntungan.setText(keuntungan);
            lblBarangTerjual.setText(barangTerjual);

    }
    public void bulan(){
       String dateEnd = util.dateEnd();
            String dateStart = util.dateMonthAgo();
            String sisaStock = String.valueOf(db.stockObat());
            String obatExp = String.valueOf(db.obatHampirExp());
            String danaPemasukan = String.valueOf(nf.format(db.Pemasukan(dateStart, dateEnd)));
            String keuntungan = String.valueOf(nf.format(db.labaBersih(dateStart, dateEnd)));
            String barangTerjual = String.valueOf(db.barangTerjual(dateStart, dateEnd));
            String obatSudahExp = String.valueOf(db.obatSudahExp());
            lblDate.setText(dateStart+" Sampai " +util.date());
            lblStokObat.setText(sisaStock);
            lblObatHampirExp.setText(obatExp);
            lblObatSudahExp.setText(obatSudahExp);
            lblDanaPemasukan.setText(danaPemasukan);
            lblKeuntungan.setText(keuntungan);
            lblBarangTerjual.setText(barangTerjual);
     
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        cmbFilter = new javax.swing.JComboBox<>();
        cmbUser = new javax.swing.JComboBox<>();
        lblNama = new javax.swing.JLabel();
        btnObatSudahExp = new javax.swing.JLabel();
        btnObatHampirExp = new javax.swing.JLabel();
        lblObatSudahExp = new javax.swing.JLabel();
        lblObatHampirExp = new javax.swing.JLabel();
        lblKeuntungan = new javax.swing.JLabel();
        lblBarangTerjual = new javax.swing.JLabel();
        lblDanaPemasukan = new javax.swing.JLabel();
        lblStokObat = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JLabel();
        btnTransaksi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Filter :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(870, 140, 60, 30);

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblDate);
        lblDate.setBounds(410, 130, 380, 50);

        cmbFilter.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hari", "Bulan" }));
        cmbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFilterActionPerformed(evt);
            }
        });
        getContentPane().add(cmbFilter);
        cmbFilter.setBounds(950, 140, 200, 30);

        cmbUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Menu----", "Profil", "Logout" }));
        cmbUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUserActionPerformed(evt);
            }
        });
        getContentPane().add(cmbUser);
        cmbUser.setBounds(1140, 50, 130, 26);

        lblNama.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNama.setText("jLabel2");
        getContentPane().add(lblNama);
        lblNama.setBounds(1140, 10, 130, 30);

        btnObatSudahExp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObatSudahExpMouseClicked(evt);
            }
        });
        getContentPane().add(btnObatSudahExp);
        btnObatSudahExp.setBounds(660, 360, 320, 120);

        btnObatHampirExp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObatHampirExpMouseClicked(evt);
            }
        });
        getContentPane().add(btnObatHampirExp);
        btnObatHampirExp.setBounds(320, 370, 310, 120);

        lblObatSudahExp.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblObatSudahExp.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblObatSudahExp);
        lblObatSudahExp.setBounds(780, 430, 150, 40);

        lblObatHampirExp.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblObatHampirExp.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblObatHampirExp);
        lblObatHampirExp.setBounds(430, 430, 150, 40);

        lblKeuntungan.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblKeuntungan.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblKeuntungan);
        lblKeuntungan.setBounds(1120, 260, 150, 40);

        lblBarangTerjual.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblBarangTerjual.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblBarangTerjual);
        lblBarangTerjual.setBounds(780, 260, 150, 40);

        lblDanaPemasukan.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblDanaPemasukan.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblDanaPemasukan);
        lblDanaPemasukan.setBounds(430, 260, 150, 40);

        lblStokObat.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblStokObat.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblStokObat);
        lblStokObat.setBounds(1120, 430, 150, 40);

        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
        });
        getContentPane().add(btnDashboard);
        btnDashboard.setBounds(20, 140, 240, 70);

        btnTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseClicked(evt);
            }
        });
        getContentPane().add(btnTransaksi);
        btnTransaksi.setBounds(20, 220, 240, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dashboard kasir.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1360, 770);

        setBounds(0, 0, 1607, 903);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFilterActionPerformed
        String flt = String.valueOf(cmbFilter.getSelectedItem());
        if(flt.equals("Hari")){
            filter = "Hari";
            load_data();
        }else if(flt.equals("Bulan")){
            filter = "Bulan";
            load_data();
        }
    }//GEN-LAST:event_cmbFilterActionPerformed

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

    private void btnObatSudahExpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatSudahExpMouseClicked
        this.setVisible(false);
        this.dispose();
        new obatSudahExp().setVisible(true);
    }//GEN-LAST:event_btnObatSudahExpMouseClicked

    private void btnObatHampirExpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatHampirExpMouseClicked
        this.setVisible(false);
        this.dispose();
        new ObatExp().setVisible(true);
    }//GEN-LAST:event_btnObatHampirExpMouseClicked

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
            java.util.logging.Logger.getLogger(DashboardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardKasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardKasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnObatHampirExp;
    private javax.swing.JLabel btnObatSudahExp;
    private javax.swing.JLabel btnTransaksi;
    private javax.swing.JComboBox<String> cmbFilter;
    private javax.swing.JComboBox<String> cmbUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblBarangTerjual;
    private javax.swing.JLabel lblDanaPemasukan;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblKeuntungan;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblObatHampirExp;
    private javax.swing.JLabel lblObatSudahExp;
    private javax.swing.JLabel lblStokObat;
    // End of variables declaration//GEN-END:variables
}
