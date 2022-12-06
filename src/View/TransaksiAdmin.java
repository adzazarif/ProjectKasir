package View;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.conn;
/**
 *
 * @author WINDOWS 10
 */
public class TransaksiAdmin extends javax.swing.JFrame {

    /**
     * Creates new form TransaksiAdming
     */
    private List<listData> trns = new ArrayList<>();
    private List<listData> keywoard = new ArrayList<>();
    private listData selectData;
    private DefaultListModel mod;
    private int grandTotal;
    private int grandDiskon;
    public TransaksiAdmin() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
        this.setVisible(true);
        menu.add(panel);
        mod = new DefaultListModel();
        list.setModel(mod);
        setDateAndKode();
        datatable();
        GrandTotal();
    }
    
    public void GrandTotal(){
        String result = String.valueOf(grandTotal);
        lblGrandtotal.setText(result);
        String a = String.valueOf(grandDiskon);
        lblDiskon.setText(a);
    }
    public void datatable(){
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("kode obat");
        tbl.addColumn("nama");
        tbl.addColumn("harga");
        tbl.addColumn("diskon");
        tbl.addColumn("banyak");
        tbl.addColumn("total");
        tblTransaksi.setModel(tbl);
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
            tblTransaksi.setModel(tbl);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Salah");
        }
    }
    
    public void setDateAndKode(){
        Logic.Transaksi ts = new Logic.Transaksi();
        String date = ts.date();
        int kode = ts.kodeTransaksi();
        lblKode.setText(String.valueOf(kode));
        lblDate.setText(date);
    }
    
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
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblKode = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtBanyak = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        lblGrandtotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTunai = new javax.swing.JTextField();
        lblKembalian = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtDetail = new javax.swing.JTextField();
        lblDiskon = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        list.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        menu.setFocusable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearch);
        txtSearch.setBounds(340, 180, 330, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Kode Transaksi :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(390, 130, 140, 22);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Tanggal :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(690, 128, 70, 22);

        lblKode.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(lblKode);
        lblKode.setBounds(510, 130, 90, 20);

        lblDate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        getContentPane().add(lblDate);
        lblDate.setBounds(760, 130, 220, 20);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Banyak");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(970, 180, 50, 20);

        txtBanyak.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(txtBanyak);
        txtBanyak.setBounds(1050, 180, 110, 30);

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1200, 180, 80, 30);

        tblTransaksi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "kode obat", "nama", "harga", "banyak", "total"
            }
        ));
        jScrollPane2.setViewportView(tblTransaksi);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(340, 250, 700, 250);

        lblGrandtotal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(lblGrandtotal);
        lblGrandtotal.setBounds(490, 520, 180, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Kembalian");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(340, 640, 140, 40);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Grand Total");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(340, 520, 140, 40);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Tunai");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(340, 580, 140, 40);

        txtTunai.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        txtTunai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTunaiKeyReleased(evt);
            }
        });
        getContentPane().add(txtTunai);
        txtTunai.setBounds(490, 580, 180, 40);

        lblKembalian.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        getContentPane().add(lblKembalian);
        lblKembalian.setBounds(490, 640, 250, 40);

        jButton2.setText("Tambah");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(770, 622, 140, 40);

        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(560, 380, 37, 16);
        getContentPane().add(txtDetail);
        txtDetail.setBounds(710, 180, 170, 22);
        getContentPane().add(lblDiskon);
        lblDiskon.setBounds(480, 700, 100, 40);

        jLabel10.setText("Dsikon");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(340, 700, 70, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/transaksirevisi .jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1370, 768);

        setBounds(0, 0, 1641, 936);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        try {
            String search = txtSearch.getText().trim();
        if(!search.equals("")){
            mod.removeAllElements();
            for(listData item:searchEngine(search)){
                mod.addElement(item.nama+ " ->Stok = " + item.stok + " " + item.id_detail);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e); 
        }
        txtSearch.setText(null);
        txtBanyak.setText(null);
        datatable();
        GrandTotal();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTunaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTunaiKeyReleased
        String StrTunai = txtTunai.getText();
        int tunai = Integer.parseInt(StrTunai);
        int result = tunai - grandTotal ;
        if(result >= 0){
            lblKembalian.setText(String.valueOf(result));
        }else{
            lblKembalian.setText("Uang nya tidak memenuhi");
        }
        
    }//GEN-LAST:event_txtTunaiKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try {
        Logic.Transaksi ts = new Logic.Transaksi();
        String date = ts.typeDate();
        String queryTransaksi = "INSERT INTO transaksi (`tgl_transaksi`, `total_harga`) VALUES ('"
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
                    String queryStok = "SELECT * FROM id_detail WHERE kode_obat = '" + i.kode_obat +"'";
                    Statement pststok = koneksi.createStatement();
                    ResultSet resStok = pststok.executeQuery(queryStok);
                    if(resStok.next()){
                        int stok = resStok.getInt("stok");
                        int resultStok = stok - i.banyak;
                        String sql = "UPDATE detail_obat SET stok='"+resultStok+"'WHERE id_detail = '"+i.kode_obat+"'";       
                        PreparedStatement pstStok=koneksi.prepareStatement(sql);
                        pstStok.execute();
                    }
                    String queryDetailTransaksi = "INSERT INTO detail_transaksi VALUES ('"
                                                            + kd_transaksi + "','"
                                                            + i.kode_obat + "','"
                                                            + i.banyak + "','"
                                                            + i.total + "');";
                    PreparedStatement pstObat = koneksi.prepareStatement(queryDetailTransaksi);
                    pstObat.execute();
                }
            }
         trns.clear();
         datatable();
         setDateAndKode();
         grandTotal = 0;
         lblGrandtotal.setText(null);
        JOptionPane.showMessageDialog(rootPane, "Transaksi berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        int index = list.getSelectedIndex();
        txtSearch.setText(keywoard.get(index).nama);
        selectData = keywoard.get(index);
    }//GEN-LAST:event_listMouseClicked

    public List<listData> searchEngine(String query){
        List<listData> data = new ArrayList<>();
            keywoard = new ArrayList<>();
            try {
            Statement st = (Statement) conn.configDB().createStatement();
            ResultSet res = st.executeQuery("SELECT * FROM obat JOIN detail_obat ON obat.kode_obat = detail_obat.kode_obat WHERE nama LIKE '%"+ query +"%'");
            while(res.next()){
                data.add(new listData(res.getInt("stok"),res.getString("nama"),res.getInt("harga_jual"),res.getInt("id_detail")));      
            }
            return data;
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, e);
        }
            return data;
    }
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDiskon;
    private javax.swing.JLabel lblGrandtotal;
    private javax.swing.JLabel lblKembalian;
    private javax.swing.JLabel lblKode;
    private javax.swing.JList<String> list;
    private javax.swing.JPopupMenu menu;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField txtBanyak;
    private javax.swing.JTextField txtDetail;
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
    
    public listData(int kode_obat, int id_detail, String nama,int harga, int banyak, int total, int diskon){
        this.kode_obat = kode_obat;
        this.id_detail = id_detail;
        this.nama = nama;
        this.harga = harga;
        this.banyak = banyak;
        this.total = total;
        this.diskon = diskon;
    }   
    public listData(int stok, String nama, int harga, int id_detail){
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
        this.id_detail = id_detail;
    }
    public int jumlah (){
        int result = this.harga * this.banyak;
        return result;
    }
   
}