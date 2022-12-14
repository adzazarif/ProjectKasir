/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Logic.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.conn;

/**
 *
 * @author WINDOWS 10
 */
public class LaporanAdmin extends javax.swing.JFrame {
Util util = new Util();
public String dateFilterStart = "2022-12-20";
public String dateFilterEnd = "2022-12-20";
SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    /**
     * Creates new form LaporanAdmin
     */
    public LaporanAdmin() {
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
            model.addColumn("Jenis");
            model.addColumn("Harga");
            model.addColumn("Banyak");
            model.addColumn("Total");
            model.addColumn("Grand Total");
        try{
            int no = 1;        

        String sql = "SELECT * FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail JOIN obat ON detail_obat.kode_obat = obat.kode_obat  ORDER BY detail_transaksi.kode_transaksi ASC" ;
        Connection koneksi = (Connection)conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{
              res.getString("kode_transaksi"),
                    res.getString("tgl_transaksi"), 
                    res.getString("nama"),
                    res.getString("jenis"), 
                    nf.format(res.getInt("harga_jual")), 
                    res.getString("banyak_barang"),
                    nf.format(res.getInt("detail_transaksi.total_harga")),
                    nf.format(res.getInt("grand_total"))
                });
            }
            table.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
        }
    
     public void load_table_waktu(String dateStart , String dateEnd){
            DefaultTableModel model = new DefaultTableModel();      
            model.addColumn("Kode Transaksi");
            model.addColumn("Tanggal Transaksi");
            model.addColumn("Nama");
            model.addColumn("Jenis");
            model.addColumn("Harga");
            model.addColumn("Banyak");
            model.addColumn("Total");
            model.addColumn("Grand Total");
        try{
            int no = 1;
        String sql = "SELECT * FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail JOIN obat ON detail_obat.kode_obat = obat.kode_obat  WHERE transaksi.tgl_transaksi BETWEEN '"+dateStart+"' AND '"+dateEnd+"'ORDER BY detail_transaksi.kode_transaksi ASC";
        Connection koneksi = (Connection)conn.configDB();
        Statement stm = koneksi.createStatement();
        ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{
                    res.getString("kode_transaksi"),
                    res.getString("tgl_transaksi"), 
                    res.getString("nama"),
                    res.getString("jenis"), 
                    nf.format(res.getInt("harga_jual")), 
                    res.getString("banyak_barang"),
                    nf.format(res.getInt("detail_transaksi.total_harga")),
                    nf.format(res.getInt("grand_total"))
                });
            }
            table.setModel(model);
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
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

        txtSearcb = new javax.swing.JTextField();
        cmbWaktu = new javax.swing.JComboBox<>();
        btnSearch = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnDashboard = new javax.swing.JLabel();
        btnObat = new javax.swing.JLabel();
        btnTransaksi = new javax.swing.JLabel();
        btnPengguna = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JLabel();
        txtDateEnd = new com.toedter.calendar.JDateChooser();
        txtDateStart = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtSearcb.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearcb.setBorder(null);
        txtSearcb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearcbKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearcb);
        txtSearcb.setBounds(340, 170, 320, 30);

        cmbWaktu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------Pilih Waktu------", "Semua", "Hari", "Bulan" }));
        cmbWaktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbWaktuActionPerformed(evt);
            }
        });
        getContentPane().add(cmbWaktu);
        cmbWaktu.setBounds(820, 120, 170, 40);

        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(1240, 170, 80, 40);

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
        table.setRowHeight(50);
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(340, 260, 970, 470);

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
        getContentPane().add(txtDateEnd);
        txtDateEnd.setBounds(1030, 165, 190, 40);
        getContentPane().add(txtDateStart);
        txtDateStart.setBounds(810, 165, 190, 40);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1240, 120, 70, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/laporan penjulan.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1407, 768);

        setBounds(0, 0, 1589, 902);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        String dateStart= dcn.format(txtDateStart.getDate());
        String dateEnd= dcn.format(txtDateEnd.getDate());
        dateFilterStart = dateStart;
        dateFilterEnd = dateEnd;
        DefaultTableModel model = new DefaultTableModel();
             model.addColumn("Kode Transaksi");
            model.addColumn("Tanggal Transaksi");
            model.addColumn("Nama");
            model.addColumn("Jenis");
            model.addColumn("Harga");
            model.addColumn("Banyak");
            model.addColumn("Total");
            model.addColumn("Grand Total");
    try{
        int no = 1;
        String sql = "SELECT * FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail JOIN obat ON detail_obat.kode_obat = obat.kode_obat  WHERE tgl_transaksi BETWEEN '"+dateStart+"' AND '"+dateEnd+"'";
        Connection conn = (Connection) koneksi.conn.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while(res.next()){
            model.addRow(new Object[]{
                    res.getString("kode_transaksi"),
                    res.getString("tgl_transaksi"), 
                    res.getString("nama"),
                    res.getString("jenis"), 
                    nf.format(res.getInt("harga_jual")), 
                    res.getString("banyak_barang"),
                    nf.format(res.getInt("detail_transaksi.total_harga")),
                    nf.format(res.getInt("grand_total"))
            });
        }
        table.setModel(model);
    }catch(Exception e){
        JOptionPane.showMessageDialog(rootPane, e);
    }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void txtSearcbKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearcbKeyReleased
        String cari = txtSearcb.getText();
        DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Kode Transaksi");
            model.addColumn("Tanggal Transaksi");
            model.addColumn("Nama");
            model.addColumn("Jenis");
            model.addColumn("Harga");
            model.addColumn("Banyak");
            model.addColumn("Total");
            model.addColumn("Grand Total");
    try{
        int no = 1;
        String sql;
        if(dateFilterStart.equals("default")&& dateFilterEnd.equals("default")){
            sql = "SELECT * FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail JOIN obat ON detail_obat.kode_obat = obat.kode_obat WHERE nama LIKE '%"+cari+"%'";
        }else{
            sql = "SELECT * FROM detail_transaksi JOIN transaksi ON detail_transaksi.kode_transaksi = transaksi.kode_transaksi JOIN detail_obat ON detail_transaksi.id_detail_obat = detail_obat.id_detail JOIN obat ON detail_obat.kode_obat = obat.kode_obat WHERE nama LIKE '%"+cari+"%' AND tgl_transaksi BETWEEN '"+dateFilterStart+"' AND '"+dateFilterEnd+"'";
        }
        
        Connection conn = (Connection) koneksi.conn.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while(res.next()){
            model.addRow(new Object[]{
                    res.getString("kode_transaksi"),
                    res.getString("tgl_transaksi"), 
                    res.getString("nama"),
                    res.getString("jenis"), 
                    nf.format(res.getInt("harga_jual")), 
                    res.getString("banyak_barang"),
                    nf.format(res.getInt("detail_transaksi.total_harga")),
                    nf.format(res.getInt("grand_total"))
            });
        }
        table.setModel(model);
    }catch(Exception e){
        JOptionPane.showMessageDialog(rootPane, e);
    }
    }//GEN-LAST:event_txtSearcbKeyReleased

    private void cmbWaktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbWaktuActionPerformed
        String waktu = String.valueOf(cmbWaktu.getSelectedItem());
        if(waktu.equals("Hari")){
            
            dateFilterStart = util.dateStart();
            dateFilterEnd = util.dateEnd();
            load_table_waktu(dateFilterStart, dateFilterEnd);
           
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
            dateFilterStart = "default";
            dateFilterEnd = "default";
            txtDateStart.setDate(null);
            txtDateEnd.setDate(null);
        }
        
    }//GEN-LAST:event_cmbWaktuActionPerformed

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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        MessageFormat header = new MessageFormat("Laporan Pengeluaran");
        MessageFormat footer = new MessageFormat("");
        
        try {
            PrintRequestAttributeSet set = new HashPrintRequestAttributeSet();
            set.add(OrientationRequested.PORTRAIT);
            table.print(JTable.PrintMode.FIT_WIDTH,header,footer,true,set,true);
            JOptionPane.showMessageDialog(null, "sukses","berhasil mencetak Laporan",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Salah",e.getMessage(),JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(LaporanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LaporanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LaporanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LaporanAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaporanAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnLaporan;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnPengguna;
    private javax.swing.JLabel btnSearch;
    private javax.swing.JLabel btnTransaksi;
    private javax.swing.JComboBox<String> cmbWaktu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private com.toedter.calendar.JDateChooser txtDateEnd;
    private com.toedter.calendar.JDateChooser txtDateStart;
    private javax.swing.JTextField txtSearcb;
    // End of variables declaration//GEN-END:variables
}
