/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Logic.Dashboard;
import Logic.Util;
import Logic.login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.conn;

/**
 *
 * @author WINDOWS 10
 */
public class ObatExp extends javax.swing.JFrame {
    Dashboard db = new Dashboard();
    Util util = new Util();
    login lg = new login();
    private static int idObat;
    
    
    public ObatExp() {
        initComponents();
        load_table();
        loadDate();
        lblNama1.setText(lg.nama);
    }

    public void load_table(){
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("No");      
                model.addColumn("Kode Obat");
                model.addColumn("Nama");
                model.addColumn("Tanggal Kadaluarsa");
                model.addColumn("Kategori");
                model.addColumn("Jenis");
                model.addColumn("Stok");
                model.addColumn("Diskon");
                model.addColumn("Harga Jual");
            try{
                Dashboard db = new Dashboard();
                int no = 1;
                String sql = "SELECT * FROM obat JOIN detail_obat ON obat.kode_obat = detail_obat.kode_obat WHERE tgl_kadaluarsa BETWEEN '"+util.date()+"' AND '"+util.dateExp()+"' ";
                Connection conn = (Connection) koneksi.conn.configDB();
                Statement stm = conn.createStatement();
                ResultSet res = stm.executeQuery(sql);
                while(res.next()){
                    model.addRow(new Object[]{
                        no++,
                        res.getString("id_detail"),
                        res.getString("nama"),
                        res.getString("tgl_kadaluarsa"),
                        res.getString("kategori"),
                        res.getString("jenis"),
                        res.getString("stok"), 
                        res.getString("diskon"), 
                        res.getString("harga_jual"),
                    });
                }
                table.setModel(model);
            }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    
    public void loadTableFilter(String filter){
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("No");      
                model.addColumn("Kode Obat");
                model.addColumn("Nama");
                model.addColumn("Tanggal Kadaluarsa");
                model.addColumn("Kategori");
                model.addColumn("Jenis");
                model.addColumn("Stok");
                model.addColumn("Diskon");
                model.addColumn("Harga Jual");
            try{
                Dashboard db = new Dashboard();
                int no = 1;
                String sql = "SELECT * FROM obat JOIN detail_obat ON obat.kode_obat = detail_obat.kode_obat WHERE tgl_kadaluarsa BETWEEN '"+util.date()+"' AND '"+util.dateExp()+"' ORDER BY tgl_kadaluarsa "+filter+"";
                Connection conn = (Connection) koneksi.conn.configDB();
                Statement stm = conn.createStatement();
                ResultSet res = stm.executeQuery(sql);
                while(res.next()){
                    model.addRow(new Object[]{
                        no++,
                        res.getString("id_detail"),
                        res.getString("nama"),
                        res.getString("tgl_kadaluarsa"),
                        res.getString("kategori"),
                        res.getString("jenis"),
                        res.getString("stok"), 
                        res.getString("diskon"), 
                        res.getString("harga_jual"),
                    });
                }
                table.setModel(model);
            }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
    
    public void loadDate(){
        lblDateStart.setText(util.date());
        lblDateEnd.setText(util.dateExp());
        txtRentangWaktu.setText(String.valueOf(util.rentangWaktu));
    }
    
    public void bersih(){
        txtDiskon.setText("");
        lblHarga.setText("");
        lblNama.setText("");
        lblTotalDiskon.setText("");
        idObat = 0;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtAutoGenerate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        BtnAutoGenerate = new javax.swing.JLabel();
        txtRentangWaktu = new javax.swing.JTextField();
        lblTotalDiskon = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblDateEnd = new javax.swing.JLabel();
        lblDateStart = new javax.swing.JLabel();
        txtDiskon = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        cmbFilter = new javax.swing.JComboBox<>();
        btnTambah = new javax.swing.JLabel();
        btnBersih = new javax.swing.JLabel();
        cmbUser = new javax.swing.JComboBox<>();
        lblNama1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtAutoGenerate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAutoGenerate.setBorder(null);
        getContentPane().add(txtAutoGenerate);
        txtAutoGenerate.setBounds(1050, 260, 70, 20);

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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 460, 1030, 260);

        BtnAutoGenerate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnAutoGenerateMouseClicked(evt);
            }
        });
        getContentPane().add(BtnAutoGenerate);
        BtnAutoGenerate.setBounds(1190, 240, 120, 50);

        txtRentangWaktu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtRentangWaktu.setBorder(null);
        txtRentangWaktu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRentangWaktuKeyPressed(evt);
            }
        });
        getContentPane().add(txtRentangWaktu);
        txtRentangWaktu.setBounds(1140, 140, 70, 20);

        lblTotalDiskon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblTotalDiskon);
        lblTotalDiskon.setBounds(530, 370, 130, 20);

        lblHarga.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblHarga);
        lblHarga.setBounds(480, 260, 130, 30);

        lblNama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblNama);
        lblNama.setBounds(480, 210, 130, 30);

        lblDateEnd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblDateEnd);
        lblDateEnd.setBounds(610, 130, 130, 30);

        lblDateStart.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(lblDateStart);
        lblDateStart.setBounds(440, 130, 130, 30);

        txtDiskon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDiskon.setBorder(null);
        txtDiskon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDiskonKeyReleased(evt);
            }
        });
        getContentPane().add(txtDiskon);
        txtDiskon.setBounds(504, 310, 70, 30);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.setBorder(null);
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch);
        txtSearch.setBounds(890, 360, 180, 30);

        cmbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Order baru", "Tanggal Awal", "Tanggal Akhir" }));
        cmbFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFilterActionPerformed(evt);
            }
        });
        getContentPane().add(cmbFilter);
        cmbFilter.setBounds(1130, 360, 190, 40);

        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        getContentPane().add(btnTambah);
        btnTambah.setBounds(660, 230, 130, 50);

        btnBersih.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBersihMouseClicked(evt);
            }
        });
        getContentPane().add(btnBersih);
        btnBersih.setBounds(660, 300, 130, 50);

        cmbUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Menu----", "Profil", "Logout" }));
        cmbUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUserActionPerformed(evt);
            }
        });
        getContentPane().add(cmbUser);
        cmbUser.setBounds(1140, 50, 130, 26);

        lblNama1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNama1.setText("jLabel2");
        getContentPane().add(lblNama1);
        lblNama1.setBounds(1140, 10, 130, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/laporan obat exp.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1370, 770);

        setBounds(0, 0, 1591, 877);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAutoGenerateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnAutoGenerateMouseClicked
              int diskon = Integer.parseInt(txtAutoGenerate.getText());
        try {
            Dashboard db = new Dashboard();
             String sql = "SELECT * FROM obat JOIN detail_obat ON obat.kode_obat = detail_obat.kode_obat WHERE tgl_kadaluarsa BETWEEN '"+util.date()+"' AND '"+util.dateExp()+"' ";
                Connection conn = (Connection) koneksi.conn.configDB();
                Statement stm = conn.createStatement();
                ResultSet res = stm.executeQuery(sql);
                while (res.next()) {
                    if(res.getInt("diskon") == 0){
                    int harga = res.getInt("harga_jual");
                    int hasil = harga * diskon / 100;
                    String queryDiskon = "UPDATE detail_obat SET diskon = '" + hasil + "' WHERE id_detail ='" + res.getInt("id_detail") + "'";
                    PreparedStatement pstHapusDetail = conn.prepareStatement(queryDiskon);
                    pstHapusDetail.execute();
                      
                }  
                }
//                stm.close();
                JOptionPane.showMessageDialog(rootPane, "Data berhasil di Update");
                load_table();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_BtnAutoGenerateMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String search = txtSearch.getText();
        DefaultTableModel model = new DefaultTableModel();
                model.addColumn("No");      
                model.addColumn("Kode Obat");
                model.addColumn("Nama");
                model.addColumn("Tanggal kadaluarsa");
                model.addColumn("Kategori");
                model.addColumn("Jenis");
                model.addColumn("Stok");
                model.addColumn("Diskon");
                model.addColumn("Harga Jual");
            try{
                Dashboard db = new Dashboard();
                int no = 1;
                String sql = "SELECT * FROM obat JOIN detail_obat ON obat.kode_obat = detail_obat.kode_obat WHERE nama LIKE '%"+search+"%' AND tgl_kadaluarsa BETWEEN '"+util.date()+"' AND '"+util.dateExp()+"'";
                Connection conn = (Connection) koneksi.conn.configDB();
                Statement stm = conn.createStatement();
                ResultSet res = stm.executeQuery(sql);
                while(res.next()){
                    model.addRow(new Object[]{
                        no++,
                        res.getString("id_detail"),
                        res.getString("nama"),
                        res.getString("tgl_kadaluarsa"),
                        res.getString("kategori"),
                        res.getString("jenis"),
                        res.getString("stok"), 
                        res.getString("diskon"), 
                        res.getString("harga_jual"),
                    });
                }
                table.setModel(model);
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, e);
            }

    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtDiskonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiskonKeyReleased
        int diskon = Integer.parseInt(txtDiskon.getText());
        int harga = Integer.parseInt(lblHarga.getText());
        
        int result = harga * diskon / 100 ;
        lblTotalDiskon.setText(String.valueOf(result));
    }//GEN-LAST:event_txtDiskonKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int baris = table.rowAtPoint(evt.getPoint());
        String diskon = table.getValueAt(baris, 7).toString();
        String harga = table.getValueAt(baris, 8).toString();
        String idObat = table.getValueAt(baris, 1).toString();
        String nama = table.getValueAt(baris, 2).toString();
        ObatExp.idObat = Integer.parseInt(idObat);
        lblHarga.setText(harga);
        lblNama.setText(nama);
        if(!diskon.equals(0)){
            double persen = (Double.valueOf(diskon)/Double.valueOf(harga) )*100;
            int result = (int) persen;
            txtDiskon.setText(String.valueOf(result));
            lblTotalDiskon.setText(diskon);
        }else{
             txtDiskon.setText(String.valueOf(diskon));
        }

        
    }//GEN-LAST:event_tableMouseClicked

    private void txtRentangWaktuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRentangWaktuKeyPressed
        int rentangWaktu = Integer.parseInt(txtRentangWaktu.getText());
        util.rentangWaktu = rentangWaktu;
        lblDateStart.setText(util.date());
        lblDateEnd.setText(util.dateExp());
    }//GEN-LAST:event_txtRentangWaktuKeyPressed

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
           int diskon = Integer.parseInt(txtDiskon.getText());
           int harga = Integer.parseInt(lblHarga.getText());
           int hasil = Integer.parseInt(lblTotalDiskon.getText());
        try {
                Connection conn = (Connection) koneksi.conn.configDB();
                Statement stm = conn.createStatement();
//                    int hasil = harga * diskon / 100;
                    String queryDiskon = "UPDATE detail_obat SET diskon = '" + hasil + "' WHERE id_detail ='" + idObat + "'";
                    PreparedStatement pstDiskon = conn.prepareStatement(queryDiskon);
                    pstDiskon.execute();
                

                JOptionPane.showMessageDialog(rootPane, "Data berhasil di Update");
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        load_table();
        bersih();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnBersihMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBersihMouseClicked
        bersih();
    }//GEN-LAST:event_btnBersihMouseClicked

    private void cmbFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFilterActionPerformed
        String isi = String.valueOf(cmbFilter.getSelectedItem());
        
        switch(isi){
            case "Tanggal Awal":
                loadTableFilter("ASC");
            break;
            case"Tanggal Akhir":
                loadTableFilter("DESC");
            break;
        }
    }//GEN-LAST:event_cmbFilterActionPerformed

    private void cmbUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUserActionPerformed
        String menu = String.valueOf(cmbUser.getSelectedItem());
        switch(menu){
            case "Profil":
            this.setVisible(false);
            this.dispose();
            new ProfilUser().setVisible(true);
            break;
            case "Logout":
            this.setVisible(false);
            this.dispose();
            lg.logOut();
            break;
        }
    }//GEN-LAST:event_cmbUserActionPerformed
    
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
            java.util.logging.Logger.getLogger(ObatExp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ObatExp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ObatExp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ObatExp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ObatExp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BtnAutoGenerate;
    private javax.swing.JLabel btnBersih;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JComboBox<String> cmbFilter;
    private javax.swing.JComboBox<String> cmbUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDateEnd;
    private javax.swing.JLabel lblDateStart;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNama1;
    private javax.swing.JLabel lblTotalDiskon;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtAutoGenerate;
    private javax.swing.JTextField txtDiskon;
    private javax.swing.JTextField txtRentangWaktu;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
