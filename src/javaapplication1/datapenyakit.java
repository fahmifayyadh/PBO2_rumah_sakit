/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import MODEL.koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EMIR
 */
public class datapenyakit extends javax.swing.JFrame {

    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    /**
     * Creates new form datapenyakit
     */
    public datapenyakit() {
        initComponents();
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        tabel();
        plus.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plus = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        person = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cari = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        akun = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 425));
        setUndecorated(true);
        getContentPane().setLayout(null);

        plus.setText("Tambah Penyakit");
        getContentPane().add(plus);
        plus.setBounds(140, 160, 110, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/search colom data penyakit.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(210, 200, 250, 30);

        search.setBackground(new java.awt.Color(218, 218, 255));
        search.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(search);
        search.setBounds(230, 200, 220, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bantuan/help.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(740, 50, 60, 50);

        person.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/plus.png"))); // NOI18N
        person.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                personMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                personMouseExited(evt);
            }
        });
        getContentPane().add(person);
        person.setBounds(90, 150, 50, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 250, 690, 160);

        cari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/cari data penyakit.png"))); // NOI18N
        cari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cariMouseClicked(evt);
            }
        });
        getContentPane().add(cari);
        cari.setBounds(490, 200, 70, 30);

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/Judul data penyakit.png"))); // NOI18N
        getContentPane().add(jLabel32);
        jLabel32.setBounds(240, 80, 380, 70);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/logo kecil.png"))); // NOI18N
        jLabel3.setText("jLabel2");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 10, 260, 60);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/BACK.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(310, -70, 60, 30);

        akun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/OPERATOR.png"))); // NOI18N
        akun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                akunMouseClicked(evt);
            }
        });
        getContentPane().add(akun);
        akun.setBounds(680, 20, 100, 30);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/BACK.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(50, 110, 60, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/BACKGROUND.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 800, 425);

        setSize(new java.awt.Dimension(792, 420));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void akunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_akunMouseClicked
        // TODO add your handling code here:
        new LoginAdmin().show();
        this.dispose();
    }//GEN-LAST:event_akunMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        new operator().show();
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        ImageIcon help = new ImageIcon ("src/bantuan/data penyakit t.png");
        JOptionPane.showMessageDialog(null, " ", " ", JOptionPane.INFORMATION_MESSAGE, help);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void personMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personMouseClicked
        // TODO add your handling code here:
        new EditPenyakit().show();
        this.dispose();
    }//GEN-LAST:event_personMouseClicked

    private void cariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariMouseClicked
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_cariMouseClicked

    private void personMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personMouseEntered
        // TODO add your handling code here:
        plus.setVisible(true);
    }//GEN-LAST:event_personMouseEntered

    private void personMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_personMouseExited
        // TODO add your handling code here:
        plus.setVisible(false);
    }//GEN-LAST:event_personMouseExited

    public void tabel(){
        DefaultTableModel tb= new DefaultTableModel();
        tb.addColumn("ID");
        tb.addColumn("Data penyakit");
        jTable1.setModel(tb);
        try {
            sql = "Select * from penyakit";
            stat = con.createStatement();
            rs = stat.executeQuery(sql);
            int i = 1;
            Object[] o = new Object[4];
            while(rs.next()){
                
                tb.addRow(new Object[]{
                rs.getString("ID_penyakit"),
                rs.getString("nama_penyakit")
});
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void cari(){
        DefaultTableModel tb= new DefaultTableModel();
        tb.addColumn("ID");
        tb.addColumn("Data penyakit");
        jTable1.setModel(tb);
        try {
            sql = "Select * from penyakit where nama_penyakit LIKE '%"+search.getText()+"%'";
            System.out.println(search.getText());
            stat = con.createStatement();
            rs = stat.executeQuery(sql);
            int i = 1;
            Object[] o = new Object[4];
            while(rs.next()){
                
                tb.addRow(new Object[]{
                rs.getString("ID_penyakit"),
                rs.getString("nama_penyakit")
});
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    
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
            java.util.logging.Logger.getLogger(datapenyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datapenyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datapenyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datapenyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datapenyakit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel akun;
    private javax.swing.JLabel back;
    private javax.swing.JLabel cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel person;
    private javax.swing.JLabel plus;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
