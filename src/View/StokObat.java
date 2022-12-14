/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WINDOWS 10
 */
public class StokObat extends javax.swing.JFrame {

    /**
     * Creates new form StokObat
     */
    public StokObat() {
        initComponents();
        loadTable();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        this.setVisible(true);
    }
    
    public void loadTable(){
          DefaultTableModel model = new DefaultTableModel();      
            model.addColumn("kode");
            model.addColumn("Nama");
            model.addColumn("Kategori");
            model.addColumn("Jenis");
            model.addColumn("Stok");
        try{
            int no = 1;
            String sql = "SELECT * FROM obat JOIN detail_obat ON obat.kode_obat = detail_obat.kode_obat";
            Connection conn = (Connection) koneksi.conn.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString("kode_obat"),
                    res.getString("nama"),
                    res.getString("kategori"), 
                    res.getString("jenis"), 
                    res.getString("stok"),
                });
            }
            table.setModel(model);
        }catch(Exception e){
        }
    }
    
    public void loadTableFilter(String order){
          DefaultTableModel model = new DefaultTableModel();      
            model.addColumn("kode");
            model.addColumn("Nama");
            model.addColumn("Kategori");
            model.addColumn("Jenis");
            model.addColumn("Stok");
        try{
            int no = 1;
            String sql = "SELECT * FROM obat JOIN detail_obat ON obat.kode_obat = detail_obat.kode_obat ORDER BY stok "+order;
            Connection conn = (Connection) koneksi.conn.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString("kode_obat"),
                    res.getString("nama"),
                    res.getString("kategori"), 
                    res.getString("jenis"), 
                    res.getString("stok"),
                });
            }
            table.setModel(model);
        }catch(Exception e){
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        cmbOrder = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JLabel();
        btnObat = new javax.swing.JLabel();
        btnTransaksi = new javax.swing.JLabel();
        btnPengguna = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        table.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setRowHeight(40);
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 260, 1020, 460);

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtCari.setBorder(null);
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });
        getContentPane().add(txtCari);
        txtCari.setBounds(340, 170, 510, 30);

        cmbOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Urutkan Dari----", "Banyak", "Sedikit" }));
        cmbOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrderActionPerformed(evt);
            }
        });
        getContentPane().add(cmbOrder);
        cmbOrder.setBounds(910, 170, 200, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/stok obat.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1407, 768);

        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
        });
        getContentPane().add(btnDashboard);
        btnDashboard.setBounds(10, 150, 250, 50);

        btnObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObatMouseClicked(evt);
            }
        });
        getContentPane().add(btnObat);
        btnObat.setBounds(10, 220, 250, 60);

        btnTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseClicked(evt);
            }
        });
        getContentPane().add(btnTransaksi);
        btnTransaksi.setBounds(10, 300, 250, 50);

        btnPengguna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPenggunaMouseClicked(evt);
            }
        });
        getContentPane().add(btnPengguna);
        btnPengguna.setBounds(10, 370, 250, 60);

        btnLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaporanMouseClicked(evt);
            }
        });
        getContentPane().add(btnLaporan);
        btnLaporan.setBounds(20, 450, 250, 60);

        setBounds(0, 0, 1584, 923);
    }// </editor-fold>//GEN-END:initComponents

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        String cari = txtCari.getText();
        
        DefaultTableModel model = new DefaultTableModel();      
            model.addColumn("kode");
            model.addColumn("Nama");
            model.addColumn("Kategori");
            model.addColumn("Jenis");
            model.addColumn("Stok");
        try{
            int no = 1;
            String sql = "SELECT * FROM obat JOIN detail_obat ON obat.kode_obat = detail_obat.kode_obat WHERE nama LIKE '%"+cari+"%'";
            Connection conn = (Connection) koneksi.conn.configDB();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString("kode_obat"),
                    res.getString("nama"),
                    res.getString("kategori"), 
                    res.getString("jenis"), 
                    res.getString("stok"),
                });
            }
            table.setModel(model);
        }catch(Exception e){
        }
    }//GEN-LAST:event_txtCariKeyReleased

    private void cmbOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrderActionPerformed
        String order = String.valueOf(cmbOrder.getSelectedItem());
        if(order.equals("Banyak")){
            loadTableFilter("DESC");
        }else if(order.equals("Sedikit")){
            loadTableFilter("ASC");
        }
    }//GEN-LAST:event_cmbOrderActionPerformed

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        this.setVisible(false);
        this.dispose();
        new DashboardAdmin().setVisible(true);
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseClicked
        this.setVisible(false);
        this.dispose();
        new ObatAdmin().setVisible(true);
    }//GEN-LAST:event_btnObatMouseClicked

    private void btnTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseClicked
        this.setVisible(false);
        this.dispose();
        new TransaksiAdmin().setVisible(true);
    }//GEN-LAST:event_btnTransaksiMouseClicked

    private void btnPenggunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPenggunaMouseClicked
        this.setVisible(false);
        this.dispose();
        new PenggunaAdmin().setVisible(true);
    }//GEN-LAST:event_btnPenggunaMouseClicked

    private void btnLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseClicked
        this.setVisible(false);
        this.dispose();
        new LaporanAdmin().setVisible(true);
    }//GEN-LAST:event_btnLaporanMouseClicked

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
            java.util.logging.Logger.getLogger(StokObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StokObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StokObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StokObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StokObat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnLaporan;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnPengguna;
    private javax.swing.JLabel btnTransaksi;
    private javax.swing.JComboBox<String> cmbOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
