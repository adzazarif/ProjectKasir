/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.conn; 
//import net.sf.jasperreports.engine.JasperCompileManager;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author WINDOWS 10
 */

public class TransaksiAdmin extends javax.swing.JFrame {
    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("in", "ID"));
    private List<listData> trns = new ArrayList<>();
    private List<listData> keywoard = new ArrayList<>();
    private listData selectData;
    private DefaultListModel mod;
    private int grandTotal;
    private int grandDiskon;
    private int totalBelanja;
    /**
     * Creates new form TransaksiAdmin
     */
    public TransaksiAdmin() {
        initComponents();
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//        this.setUndecorated(true);
//        this.setVisible(true);
        menu.add(panel);
        mod = new DefaultListModel();
        list.setModel(mod);
        setDateAndKode();
        datatable();
        loadResult();
    }
    //menampilkan grand total dan diskon ke layar
    public void loadResult(){
      
        lblGrandTotal.setText(nf.format(grandTotal));

        lblTotalDiskon.setText(nf.format(grandDiskon));

        lblTotalBelanja.setText(nf.format(totalBelanja));
    }
    //menampilkan ke dalma tabel
    public void datatable(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("kode obat");
        tbl.addColumn("nama");
        tbl.addColumn("harga");
        tbl.addColumn("diskon");
        tbl.addColumn("banyak");
        tbl.addColumn("total");
        table.setModel(tbl);
        try {
            for(listData ls:trns){
                 tbl.addRow(new Object[]{
                    ls.kode_obat,
                    ls.nama,
                    ls.harga,
                    ls.diskon,
                    ls.banyak,
                    ls.total
                });
                 
            }
            table.setModel(tbl);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Salah");
        }
    }
    
    //method untuk menampilkan kode dan tanggal
    public void setDateAndKode(){
        Logic.Transaksi ts = new Logic.Transaksi();
        String date = ts.date();
        int kode = ts.kodeTransaksi();
        lblKode.setText(String.valueOf(kode));
        lblTanggal.setText(date);
    }
    
    //method untuk query ke database dan di tampilkan ke list
    public List<listData> searchEngine(String query){
        List<listData> data = new ArrayList<>();
            keywoard = new ArrayList<>();
            try {
            Statement st = (Statement) conn.configDB().createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM obat JOIN detail_obat ON obat.kode_obat = detail_obat.kode_obat WHERE nama LIKE '%"+ query +"%'");
            while(res.next()){
                data.add(new listData(res.getInt("stok"),res.getString("nama"),res.getString("jenis"),res.getInt("dosis"),res.getInt("harga_jual"),res.getInt("id_detail")));      
            }
            return data;
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
        }
            return data;
    }
    
//    public void tampilStruk(){
//        
////            Logic.Transaksi ts = new Logic.Transaksi();
////            int kode = ts.kodeTransaksi() - 1;
//    String kode = "70";
//            
//            java.sql.Connection con = null;
//            try{
//                String jdbcDriver = "com.mysql.jdbc.Driver";
//                Class.forName(jdbcDriver);
//                
//                String url = "jdbc:mysql://localhost:3306/db_apotek";
//                String user = "root";
//                String pass = "";
//                
//                con = DriverManager.getConnection(url, user, pass);
//                Statement stm = (Statement) con.createStatement();
//                try{
////                    Connection con = (Connection) conn.configDB();
//                    String report = ("E:\\kuliah\\code\\semester 1\\pengembangan rekayasa perangkat lunak\\kasirApotek\\src\\View\\report1.jrxml");
//                    HashMap hash = new HashMap();
//                    hash.put("kode", "56");
//                    JasperReport JRpt = JasperCompileManager.compileReport(report);
//                    JasperPrint JPrint = JasperFillManager.fillReport(JRpt, hash, con);
//                    JasperViewer.viewReport(JPrint, false);
//                } catch (Exception rptexcpt){
//                    JOptionPane.showMessageDialog(rootPane, rptexcpt);
//                }
//                } catch (Exception e){
//                    JOptionPane.showMessageDialog(rootPane, e);
//            }
//            
//           
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        menu = new javax.swing.JPopupMenu();
        lblKode = new javax.swing.JLabel();
        lblTanggal = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        txtBanyak = new javax.swing.JTextField();
        btnTambah = new javax.swing.JLabel();
        lblGrandTotal = new javax.swing.JLabel();
        lblTotalDiskon = new javax.swing.JLabel();
        lblTotalBelanja = new javax.swing.JLabel();
        txtTunai = new javax.swing.JTextField();
        lblKembalian = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JLabel();
        btnHapus = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        list.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(list);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        menu.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblKode.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        getContentPane().add(lblKode);
        lblKode.setBounds(480, 130, 110, 40);

        lblTanggal.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        getContentPane().add(lblTanggal);
        lblTanggal.setBounds(750, 130, 460, 40);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearch.setBorder(null);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch);
        txtSearch.setBounds(320, 190, 500, 50);

        txtBanyak.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtBanyak.setBorder(null);
        getContentPane().add(txtBanyak);
        txtBanyak.setBounds(980, 190, 140, 40);

        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        getContentPane().add(btnTambah);
        btnTambah.setBounds(1170, 190, 160, 50);

        lblGrandTotal.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        getContentPane().add(lblGrandTotal);
        lblGrandTotal.setBounds(480, 560, 210, 30);

        lblTotalDiskon.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        getContentPane().add(lblTotalDiskon);
        lblTotalDiskon.setBounds(480, 620, 210, 40);

        lblTotalBelanja.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        getContentPane().add(lblTotalBelanja);
        lblTotalBelanja.setBounds(480, 680, 210, 40);

        txtTunai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTunai.setBorder(null);
        txtTunai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTunaiKeyReleased(evt);
            }
        });
        getContentPane().add(txtTunai);
        txtTunai.setBounds(900, 560, 230, 40);

        lblKembalian.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        getContentPane().add(lblKembalian);
        lblKembalian.setBounds(890, 620, 250, 40);

        btnSimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSimpanMouseClicked(evt);
            }
        });
        getContentPane().add(btnSimpan);
        btnSimpan.setBounds(1170, 560, 150, 40);

        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(1170, 630, 160, 50);

        table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
        table.setRowHeight(30);
        jScrollPane2.setViewportView(table);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(312, 270, 1010, 260);

        jLabel2.setText("jLabel2");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 40, 100, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/transaksifix.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1407, 768);

        setBounds(0, 0, 1570, 889);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            String search = txtSearch.getText().trim();
            if(!search.equals("")){
                mod.removeAllElements();
                for(listData item:searchEngine(search)){
                    mod.addElement(item.nama+ " | Stok = " + item.stok + " | Jenis = "+item.jenis + " | Dosis = "+item.dosis);
                    keywoard.add(item);
                }
                //            System.out.println(search);
                menu.show(txtSearch, 0, txtSearch.getHeight());
            }

            if(search.equals("")){
                menu.setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        try {

            int dtotal = 0 ;
            int subDiskon = 0;
            Statement st = (Statement) conn.configDB().createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM obat right JOIN detail_obat ON obat.kode_obat = detail_obat.kode_obat WHERE obat.nama = '"+ txtSearch.getText() +"' AND detail_obat.id_detail = '" + selectData.id_detail + "'");
            while(res.next()){
                if(res.getInt("stok") < Integer.parseInt(txtBanyak.getText())){
                    JOptionPane.showMessageDialog(rootPane, "Stok tidak cukup");
                    return ;
                }
                trns.add(new listData(res.getInt("kode_obat"), res.getInt("id_detail"), res.getString("nama"),res.getInt("harga_jual"),
                    Integer.parseInt(txtBanyak.getText()), (res.getInt("harga_jual")*Integer.parseInt(txtBanyak.getText())),
                    (res.getInt("diskon")*Integer.parseInt(txtBanyak.getText()))
                ));
            }
            for(listData i:trns){
                dtotal = i.total;
                subDiskon = i.diskon;
            }
            grandDiskon = grandDiskon + subDiskon;
            grandTotal = grandTotal + dtotal;
            totalBelanja = grandTotal - grandDiskon;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        txtSearch.setText(null);
        txtBanyak.setText(null);
        datatable();
        loadResult();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void txtTunaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTunaiKeyReleased
        String StrTunai = txtTunai.getText();
        int tunai = Integer.parseInt(StrTunai);
        int result = tunai - totalBelanja ;
        if(result >= 0){
            lblKembalian.setText(String.valueOf(result));
        }else{
            lblKembalian.setText("Uang nya tidak memenuhi");
        }

    }//GEN-LAST:event_txtTunaiKeyReleased

    private void btnSimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSimpanMouseClicked
        try {
            Logic.Transaksi ts = new Logic.Transaksi();
            String date = ts.typeDate();
            String queryTransaksi = "INSERT INTO transaksi (`tgl_transaksi`, `grand_total`) VALUES ('"
            + date + "','"
            + grandTotal + "');";
            Connection koneksi = (Connection)conn.configDB();
            PreparedStatement pstDetail = koneksi.prepareStatement(queryTransaksi);
            pstDetail.execute();

            String queryCek = "SELECT * FROM transaksi WHERE tgl_transaksi = '" + date +"'";
            Statement pstCek = koneksi.createStatement();
            ResultSet res = pstCek.executeQuery(queryCek);
            if(res.next()){
                int kd_transaksi = res.getInt("kode_transaksi");
                for(listData i:trns){
                    String queryStok = "SELECT * FROM detail_obat WHERE id_detail = '" + i.id_detail +"'";
                    Statement pststok = koneksi.createStatement();
                    ResultSet resStok = pststok.executeQuery(queryStok);
                    if(resStok.next()){
                        int stok = resStok.getInt("stok");
                        int resultStok = stok - i.banyak;
                        String sql = "UPDATE detail_obat SET stok='"+resultStok+"'WHERE id_detail = '"+i.id_detail+"'";
                        PreparedStatement pstStok=koneksi.prepareStatement(sql);
                        pstStok.execute();
                    }
                    String queryDetailTransaksi = "INSERT INTO detail_transaksi(`kode_transaksi`,`kode_obat`,`id_detail_obat`,`banyak_barang`,`total_harga`) VALUES ('"
                    + kd_transaksi + "','"
                    + i.kode_obat + "','"
                    + i.id_detail + "','"
                    + i.banyak + "','"
                    + i.total + "');";
                    PreparedStatement pstObat = koneksi.prepareStatement(queryDetailTransaksi);
                    pstObat.execute();
                }
            }
            int jawab =  JOptionPane.showConfirmDialog(this, "Ingin mencetak struk?", "Print Struk",JOptionPane.YES_NO_OPTION);
        if(jawab == JOptionPane.YES_OPTION){
//            tampilStruk();
        }
            trns.clear();
            datatable();
            setDateAndKode();
            grandTotal = 0;
            grandDiskon = 0;
            totalBelanja = 0;
            lblGrandTotal.setText(null);
            loadResult();
            JOptionPane.showMessageDialog(rootPane, "Transaksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_btnSimpanMouseClicked

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        trns.clear();
        grandTotal = 0;
        grandDiskon = 0;
        totalBelanja = 0;
        loadResult();
        datatable();
    }//GEN-LAST:event_btnHapusMouseClicked

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        int index = list.getSelectedIndex();
        txtSearch.setText(keywoard.get(index).nama);
        selectData = keywoard.get(index);
    }//GEN-LAST:event_listMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
//        tampilStruk();
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
            java.util.logging.Logger.getLogger(TransaksiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransaksiAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnHapus;
    private javax.swing.JLabel btnSimpan;
    private javax.swing.JLabel btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblKembalian;
    private javax.swing.JLabel lblKode;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTotalBelanja;
    private javax.swing.JLabel lblTotalDiskon;
    private javax.swing.JList<String> list;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPanel panel;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBanyak;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTunai;
    // End of variables declaration//GEN-END:variables
}
class listData{
    public int kode_obat;
    public int id_detail;
    public String nama;
    public int harga;
    public int banyak;
    public int total;
    public int stok;
    public int diskon;
    public String jenis;
    public int dosis;
    
    public listData(int kode_obat, int id_detail, String nama,int harga, int banyak, int total, int diskon){
        this.kode_obat = kode_obat;
        this.id_detail = id_detail;
        this.nama = nama;
        this.harga = harga;
        this.banyak = banyak;
        this.total = total;
        this.diskon = diskon;
    }   
    public listData(int stok, String nama,String jenis,int dosis, int harga, int id_detail){
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.id_detail = id_detail;
        this.jenis = jenis;
        this.dosis = dosis;
    }
    public int jumlah (){
        int result = this.harga * this.banyak;
        return result;
    }
   
}