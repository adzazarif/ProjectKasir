/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author WINDOWS 10
 */
public class DashboardAdmin extends javax.swing.JFrame {

    /**
     * Creates new form DashboardAdmin
     */
    public DashboardAdmin() {
        initComponents();
        sisaStockObat();
        danaPemasukan();
        barangTerjual();
    }
    public void sisaStockObat(){
        Logic.Dashboard ds = new Logic.Dashboard();
        int hasil = ds.stockObat();
        String result = String.valueOf(hasil);
        lblStokObat1.setText(result);
    }
    public void danaPemasukan(){
        Logic.Dashboard ds = new Logic.Dashboard();
        int hasil = ds.Pemasukan();
        String result = String.valueOf(hasil);
        lblDanaPemasukan1.setText(result);
    }
    public void barangTerjual(){
        Logic.Dashboard ds = new Logic.Dashboard();
        int hasil = ds.barangTerjual();
        String result = String.valueOf(hasil);
        lblBarangTerjual.setText(result);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBarangTerjual = new javax.swing.JLabel();
        lblStokObat1 = new javax.swing.JLabel();
        lblDanaPemasukan1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblBarangTerjual.setBackground(new java.awt.Color(255, 255, 255));
        lblBarangTerjual.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblBarangTerjual.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblBarangTerjual);
        lblBarangTerjual.setBounds(1100, 450, 80, 30);

        lblStokObat1.setBackground(new java.awt.Color(255, 255, 255));
        lblStokObat1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblStokObat1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblStokObat1);
        lblStokObat1.setBounds(590, 260, 80, 30);

        lblDanaPemasukan1.setBackground(new java.awt.Color(255, 255, 255));
        lblDanaPemasukan1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblDanaPemasukan1.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lblDanaPemasukan1);
        lblDanaPemasukan1.setBounds(600, 450, 80, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/fahmarevisi dashboard (1).jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(6, 0, 1366, 768);

        setBounds(0, 0, 1607, 873);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBarangTerjual;
    private javax.swing.JLabel lblDanaPemasukan1;
    private javax.swing.JLabel lblStokObat1;
    // End of variables declaration//GEN-END:variables
}
