/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Logic.Pengguna;
import Logic.login;
import static View.ObatAdmin.id_detail;
import static View.ObatAdmin.kd_obat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.conn;

/**
 *
 * @author WINDOWS 10
 */
public class PenggunaAdmin extends javax.swing.JFrame {
login lg = new login();
    /**
     * Creates new form PenggunaAdmin
     */
    public static int idUser;
    public PenggunaAdmin() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        this.setVisible(true);
        load_table();
        setDataEdit();
        lblNama.setText(lg.nama);
    }
public void load_table(){
        DefaultTableModel model = new DefaultTableModel();  
        model.addColumn("Kode Pengguna");
        model.addColumn("Nama");
        model.addColumn("Username");
        model.addColumn("Email");
        model.addColumn("Level");
    try{
        int no = 1;
        String sql = "SELECT * FROM user";
        Connection conn = (Connection) koneksi.conn.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        while(res.next()){
            model.addRow(new Object[]{
                res.getString("id"),
                res.getString("nama"),
                res.getString("username"),
                res.getString("email"), 
                res.getString("level")
            });
        }
        table.setModel(model);
    }catch(Exception e){
    }
    }
    public void setDataEdit(){
        try {
            Connection koneksi = (Connection)conn.configDB();
            String queryCek = "SELECT * FROM user WHERE id = '" + idUser +"'";
            Statement pstCek = koneksi.createStatement();
            ResultSet res = pstCek.executeQuery(queryCek);
            if(res.next()){
              txtNama.setText(res.getString("nama"));
              txtUsername.setText(res.getString("username"));
              txtEmail.setText(res.getString("email"));
              cmblevel.setSelectedItem(res.getString("level"));
              if(idUser != 0){
                  String pass = "*".repeat(res.getString("password").length());
                  txtPass.disable();
                  txtPass.setText(pass);
              }
              
            }
        } catch (Exception e) {
        }
    }
    public void bersih(){
        txtUsername.setText(null);
        txtNama.setText(null);
        txtEmail.setText(null);
        txtPass.setText(null);
        cmblevel.setSelectedItem(this);
        idUser = 0;
    }

    
    public boolean validateRequired(){
        if(txtNama.getText().length() < 1 || txtUsername.getText().length() < 1 || txtEmail.getText().length() < 1 || txtPass.getText().length() < 1 ){
            JOptionPane.showMessageDialog(rootPane, "Input harus di isi semua");
            return false;
        }else{
                    return true;

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

        btnTambah = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        cmblevel = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnHapus = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        cmbUser = new javax.swing.JComboBox<>();
        btnTransaksi = new javax.swing.JLabel();
        btnLaporan = new javax.swing.JLabel();
        btnPengguna = new javax.swing.JLabel();
        btnDashboard = new javax.swing.JLabel();
        btnObat = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        getContentPane().add(btnTambah);
        btnTambah.setBounds(950, 130, 150, 50);

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmail.setBorder(null);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(470, 240, 390, 40);

        txtNama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNama.setBorder(null);
        txtNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNamaKeyReleased(evt);
            }
        });
        getContentPane().add(txtNama);
        txtNama.setBounds(470, 130, 390, 40);

        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtUsername.setBorder(null);
        getContentPane().add(txtUsername);
        txtUsername.setBounds(470, 190, 390, 30);

        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPass.setBorder(null);
        getContentPane().add(txtPass);
        txtPass.setBounds(470, 350, 390, 40);

        cmblevel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmblevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "kasir" }));
        getContentPane().add(cmblevel);
        cmblevel.setBounds(460, 300, 150, 30);

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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 420, 1020, 290);

        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(1150, 130, 150, 50);

        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        getContentPane().add(btnEdit);
        btnEdit.setBounds(950, 210, 150, 50);

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1150, 210, 150, 40);

        lblNama.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblNama.setText("jLabel2");
        getContentPane().add(lblNama);
        lblNama.setBounds(1140, 10, 130, 30);

        cmbUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cmbUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----Menu----", "Profil", "Logout" }));
        cmbUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUserActionPerformed(evt);
            }
        });
        getContentPane().add(cmbUser);
        cmbUser.setBounds(1140, 50, 130, 26);

        btnTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTransaksiMouseClicked(evt);
            }
        });
        getContentPane().add(btnTransaksi);
        btnTransaksi.setBounds(10, 300, 250, 50);

        btnLaporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLaporanMouseClicked(evt);
            }
        });
        getContentPane().add(btnLaporan);
        btnLaporan.setBounds(20, 450, 250, 60);

        btnPengguna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPenggunaMouseClicked(evt);
            }
        });
        getContentPane().add(btnPengguna);
        btnPengguna.setBounds(10, 370, 250, 60);

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pengguna.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1370, 770);

        setBounds(0, 0, 1606, 892);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        String nama = txtNama.getText();
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String pass = txtPass.getText();
        String level = String.valueOf(cmblevel.getSelectedItem());
        Pengguna p = new Pengguna();
        if(validateRequired()){
            if(pass.length() >= 8){
             boolean result = p.tambah(nama, username, email, level, pass);
        if(result){
            JOptionPane.showMessageDialog(rootPane, "Data berhasil ditambbahkan");
             load_table();
        bersih();
        }else{
            JOptionPane.showMessageDialog(rootPane, "Data gagal ditambbahkan");
        }
        }else{
            JOptionPane.showMessageDialog(rootPane, "password harus lebih dari 8 kata");
        }
        }
       
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        Pengguna p = new Pengguna();
        boolean result = p.hapus(idUser);
        if(result){
            JOptionPane.showMessageDialog(rootPane, "Data berhasil Di hapus");
        }else{
            JOptionPane.showMessageDialog(rootPane, "Data gagal Di hapus");
        }
        bersih();
    }//GEN-LAST:event_btnHapusMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int baris = table.rowAtPoint(evt.getPoint());
        String id_user = table.getValueAt(baris, 0).toString();
        int result = Integer.parseInt(id_user);  
        idUser = result;
        setDataEdit();
    }//GEN-LAST:event_tableMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        String nama = txtNama.getText();
        String username = txtUsername.getText();
        String email = txtEmail.getText();
        String pass = txtPass.getText();
        String level = String.valueOf(cmblevel.getSelectedItem());
        Pengguna p = new Pengguna();
        boolean edit = p.edit(idUser, nama, username, email, level, pass);
        if(edit){
            JOptionPane.showMessageDialog(rootPane, "Data berhasil di Update");
        }else{
            JOptionPane.showMessageDialog(rootPane, "Data Gagal di Update");
        }
        load_table();
    }//GEN-LAST:event_btnEditMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        bersih();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void txtNamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaKeyReleased
        String nama = txtNama.getText();
        nama = nama.replaceAll("\\s", "");
        String result = nama+"@gmail.com";
        txtEmail.setText(result);
    }//GEN-LAST:event_txtNamaKeyReleased

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

    private void btnTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTransaksiMouseClicked
        this.setVisible(false);
        this.dispose();
        new TransaksiAdmin().setVisible(true);
    }//GEN-LAST:event_btnTransaksiMouseClicked

    private void btnLaporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLaporanMouseClicked
        this.setVisible(false);
        this.dispose();
        new LaporanAdmin().setVisible(true);
    }//GEN-LAST:event_btnLaporanMouseClicked

    private void btnPenggunaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPenggunaMouseClicked
        this.setVisible(false);
        this.dispose();
        new PenggunaAdmin().setVisible(true);
    }//GEN-LAST:event_btnPenggunaMouseClicked

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
            java.util.logging.Logger.getLogger(PenggunaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenggunaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenggunaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenggunaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PenggunaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnLaporan;
    private javax.swing.JLabel btnObat;
    private javax.swing.JLabel btnPengguna;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel btnTransaksi;
    private javax.swing.JComboBox<String> cmbUser;
    private javax.swing.JComboBox<String> cmblevel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNama;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
