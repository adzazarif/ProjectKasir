/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Logic.Util;
import Logic.Dashboard;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.conn;

/**
 *
 * @author WINDOWS 10
 */
public class KeuntunganDanPemasukan extends javax.swing.JFrame {
    Util util = new Util();
    Dashboard db = new Dashboard();
    SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
    
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    public String dateFilterStart = "Default";
    public String dateFilterEnd = "Default";

    /**
     * Creates new form KeuntunganDanPemasukan
     */
    public KeuntunganDanPemasukan() {
        initComponents();
        load_table();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        this.setVisible(true);
    }
    
    public void load_table(){
            DefaultTableModel model = new DefaultTableModel();      
            model.addColumn("Kode Transaksi");
            model.addColumn("Tanggal Transaksi");
            model.addColumn("Nama");
            model.addColumn("Harga Jual");
            model.addColumn("Harga Beli");
            model.addColumn("Keuntungan");
        try{
            int no = 1;
        String sql = "SELECT detail_transaksi.kode_transaksi,tgl_transaksi,nama,(detail_obat.harga_jual*detail_transaksi.banyak_barang) AS HJ,(detail_obat.harga_beli*detail_transaksi.banyak_barang) AS HB,((harga_jual*banyak_barang)-(harga_beli*banyak_barang)) AS keuntungan FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi JOIN obat ON detail_transaksi.kode_obat = obat.kode_obat JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail ";
        Connection koneksi = (Connection)conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString("kode_transaksi"),
                    res.getString("tgl_transaksi"), 
                    res.getString("nama"),
                    res.getString("HJ"), 
                    res.getString("HB"), 
                    res.getString("keuntungan"),
                });
            }
            table.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        }
    
     public void load_table_waktu(String dateStart,String dateEnd){
         String sql;
            DefaultTableModel model = new DefaultTableModel();      
            model.addColumn("Kode Transaksi");
            model.addColumn("Tanggal Transaksi");
            model.addColumn("Nama");
            model.addColumn("Harga Jual");
            model.addColumn("Harga Beli");
            model.addColumn("Keuntungan");
        try{
            int no = 1;
        if(dateFilterEnd.equals("Default") && dateFilterStart.equals("default")){
             sql = "SELECT detail_transaksi.kode_transaksi,tgl_transaksi,nama,(detail_obat.harga_jual*detail_transaksi.banyak_barang) AS HJ,(detail_obat.harga_beli*detail_transaksi.banyak_barang) AS HB,((harga_jual*banyak_barang)-(harga_beli*banyak_barang)) AS keuntungan FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi  JOIN obat ON detail_transaksi.kode_obat = obat.kode_obat JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail ";
        }else{
             sql = "SELECT detail_transaksi.kode_transaksi,tgl_transaksi,nama,(detail_obat.harga_jual*detail_transaksi.banyak_barang) AS HJ,(detail_obat.harga_beli*detail_transaksi.banyak_barang) AS HB,((harga_jual*banyak_barang)-(harga_beli*banyak_barang)) AS keuntungan FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi  JOIN obat ON detail_transaksi.kode_obat = obat.kode_obat JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail WHERE tgl_transaksi BETWEEN '"+dateStart+"' AND '"+dateEnd+"'";
        }
        Connection koneksi = (Connection)conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString("kode_transaksi"),
                    res.getString("tgl_transaksi"), 
                    res.getString("nama"),
                    res.getString("HJ"), 
                    res.getString("HB"), 
                    res.getString("keuntungan"),
                });
            }
            table.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        }
    
     
    public void setData(String dateStart, String dateEnd){
        String pemasukan = String.valueOf(nf.format(db.Pemasukan(dateStart, dateEnd)));
        String keuntungan = String.valueOf(nf.format(db.labaBersih(dateStart, dateEnd)));
        lblKeuntungan.setText(keuntungan);
        lblPemasukan.setText(pemasukan);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDashboard = new javax.swing.JLabel();
        btnPengguna = new javax.swing.JLabel();
        btnObat = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JLabel();
        btnTransaksi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        cmbWaktu = new javax.swing.JComboBox<>();
        lblKeuntungan = new javax.swing.JLabel();
        lblPemasukan = new javax.swing.JLabel();
        btnCari = new javax.swing.JLabel();
        txtDateEnd = new com.toedter.calendar.JDateChooser();
        txtDateStart = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
        });
        getContentPane().add(btnDashboard);
        btnDashboard.setBounds(10, 150, 250, 50);

        btnPengguna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPenggunaMouseClicked(evt);
            }
        });
        getContentPane().add(btnPengguna);
        btnPengguna.setBounds(10, 370, 250, 60);

        btnObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnObatMouseClicked(evt);
            }
        });
        getContentPane().add(btnObat);
        btnObat.setBounds(10, 220, 250, 60);

        btnLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaporanMouseClicked(evt);
            }
        });
        getContentPane().add(btnLaporan);
        btnLaporan.setBounds(20, 450, 250, 60);

        btnTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseClicked(evt);
            }
        });
        getContentPane().add(btnTransaksi);
        btnTransaksi.setBounds(10, 300, 250, 50);

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
        jScrollPane1.setBounds(310, 252, 1010, 410);

        txtCari.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtCari.setBorder(null);
        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });
        getContentPane().add(txtCari);
        txtCari.setBounds(340, 170, 260, 30);

        cmbWaktu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------Pilih Waktu------", "Semua", "Hari", "Bulan" }));
        cmbWaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbWaktuActionPerformed(evt);
            }
        });
        getContentPane().add(cmbWaktu);
        cmbWaktu.setBounds(780, 120, 190, 40);

        lblKeuntungan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblKeuntungan);
        lblKeuntungan.setBounds(980, 690, 190, 40);

        lblPemasukan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblPemasukan);
        lblPemasukan.setBounds(490, 690, 190, 40);

        btnCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariMouseClicked(evt);
            }
        });
        getContentPane().add(btnCari);
        btnCari.setBounds(1220, 170, 80, 30);
        getContentPane().add(txtDateEnd);
        txtDateEnd.setBounds(1010, 165, 190, 40);
        getContentPane().add(txtDateStart);
        txtDateStart.setBounds(780, 165, 190, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pemasukan dan keuntungan.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1407, 768);

        setBounds(0, 0, 1554, 894);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbWaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbWaktuActionPerformed
        String waktu = String.valueOf(cmbWaktu.getSelectedItem());
        if(waktu.equals("Hari")){
            dateFilterStart = util.dateStart();
            dateFilterEnd = util.dateEnd();
            load_table_waktu(dateFilterStart, dateFilterEnd);
            setData(dateFilterStart, dateFilterEnd);
             try {
                 DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                 Date dateStart = format.parse(dateFilterStart);
                Date dateEnd = format.parse(dateFilterEnd);
                txtDateStart.setDate(dateStart);
                txtDateEnd.setDate(dateEnd);
            } catch (Exception e) {
            }
        }else if(waktu.equals("Bulan")){
            dateFilterStart = util.dateMonthAgo();
            dateFilterEnd = util.dateEnd();
            load_table_waktu(dateFilterStart, dateFilterEnd);
            setData(dateFilterStart, dateFilterEnd);
             try {
                 DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                 Date dateStart = format.parse(dateFilterStart);
                Date dateEnd = format.parse(dateFilterEnd);
                txtDateStart.setDate(dateStart);
                txtDateEnd.setDate(dateEnd);
            } catch (Exception e) {
            }
        }else if(waktu.equals("Semua")){
            load_table();
            dateFilterStart = "Default";
            dateFilterEnd = "Default";
            String pemasukan = String.valueOf(nf.format(db.Pemasukan(dateFilterStart, dateFilterEnd)));
            String keuntungan = String.valueOf(nf.format(db.labaBersih(dateFilterStart, dateFilterEnd)));
            lblKeuntungan.setText(keuntungan);
            lblPemasukan.setText(pemasukan);
            txtDateStart.setDate(null);
            txtDateEnd.setDate(null);
        }

    }//GEN-LAST:event_cmbWaktuActionPerformed

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        this.setVisible(false);
        this.dispose();
        new DashboardAdmin().setVisible(true);
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnPenggunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPenggunaMouseClicked
        this.setVisible(false);
        this.dispose();
        new PenggunaAdmin().setVisible(true);
    }//GEN-LAST:event_btnPenggunaMouseClicked

    private void btnObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnObatMouseClicked
        this.setVisible(false);
        this.dispose();
        new ObatAdmin().setVisible(true);
    }//GEN-LAST:event_btnObatMouseClicked

    private void btnLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseClicked
        this.setVisible(false);
        this.dispose();
        new LaporanAdmin().setVisible(true);
    }//GEN-LAST:event_btnLaporanMouseClicked

    private void btnTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseClicked
        this.setVisible(false);
        this.dispose();
        new TransaksiAdmin().setVisible(true);
    }//GEN-LAST:event_btnTransaksiMouseClicked

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        DefaultTableModel model = new DefaultTableModel();      
            model.addColumn("Kode Transaksi");
            model.addColumn("Tanggal Transaksi");
            model.addColumn("Nama");
            model.addColumn("Harga Jual");
            model.addColumn("Harga Beli");
            model.addColumn("Keuntungan");
        try{
            String sql;
            int no = 1;
         if(dateFilterEnd.equals("Default") && dateFilterStart.equals("Default")){
            sql = "SELECT detail_transaksi.kode_transaksi,tgl_transaksi,nama,(detail_obat.harga_jual*detail_transaksi.banyak_barang) AS HJ,(detail_obat.harga_beli*detail_transaksi.banyak_barang) AS HB,((harga_jual*banyak_barang)-(harga_beli*banyak_barang)) AS keuntungan FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi JOIN obat ON detail_transaksi.kode_obat = obat.kode_obat JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail WHERE nama LIKE '%"+txtCari.getText()+"%'";
        }else{
            sql = "SELECT detail_transaksi.kode_transaksi,tgl_transaksi,nama,(detail_obat.harga_jual*detail_transaksi.banyak_barang) AS HJ,(detail_obat.harga_beli*detail_transaksi.banyak_barang) AS HB,((harga_jual*banyak_barang)-(harga_beli*banyak_barang)) AS keuntungan FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi JOIN obat ON detail_transaksi.kode_obat = obat.kode_obat JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail WHERE tgl_transaksi BETWEEN '"+dateFilterStart+"' AND '"+dateFilterEnd+"' AND nama LIKE '%"+txtCari.getText()+"%'";
        }
        
        Connection koneksi = (Connection)conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString("kode_transaksi"),
                    res.getString("tgl_transaksi"), 
                    res.getString("nama"),
                    res.getString("HJ"), 
                    res.getString("HB"), 
                    res.getString("keuntungan"),
                });
            }
            table.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_txtCariKeyReleased

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
        dateFilterStart = dcn.format(txtDateStart.getDate());
        dateFilterEnd = dcn.format(txtDateEnd.getDate());
          setData(dateFilterStart, dateFilterEnd);
        DefaultTableModel model = new DefaultTableModel();      
            model.addColumn("Kode Transaksi");
            model.addColumn("Tanggal Transaksi");
            model.addColumn("Nama");
            model.addColumn("Harga Jual");
            model.addColumn("Harga Beli");
            model.addColumn("Keuntungan");
        try{
            int no = 1;
         
        String sql = "SELECT detail_transaksi.kode_transaksi,tgl_transaksi,nama,(detail_obat.harga_jual*detail_transaksi.banyak_barang) AS HJ,(detail_obat.harga_beli*detail_transaksi.banyak_barang) AS HB,((harga_jual*banyak_barang)-(harga_beli*banyak_barang)) AS keuntungan FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi JOIN obat ON detail_transaksi.kode_obat = obat.kode_obat JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail WHERE tgl_transaksi BETWEEN '"+dateFilterStart+"' AND '"+dateFilterEnd+"'";
        Connection koneksi = (Connection)conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString("kode_transaksi"),
                    res.getString("tgl_transaksi"), 
                    res.getString("nama"),
                    res.getString("HJ"), 
                    res.getString("HB"), 
                    res.getString("keuntungan"),
                });
            }
            table.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btnCariMouseClicked

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
            java.util.logging.Logger.getLogger(KeuntunganDanPemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KeuntunganDanPemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KeuntunganDanPemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeuntunganDanPemasukan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeuntunganDanPemasukan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCari;
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnLaporan;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnPengguna;
    private javax.swing.JLabel btnTransaksi;
    private javax.swing.JComboBox<String> cmbWaktu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKeuntungan;
    private javax.swing.JLabel lblPemasukan;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtCari;
    private com.toedter.calendar.JDateChooser txtDateEnd;
    private com.toedter.calendar.JDateChooser txtDateStart;
    // End of variables declaration//GEN-END:variables
}
