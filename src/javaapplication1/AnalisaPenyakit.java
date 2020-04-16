/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import MODEL.koneksi;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import CONTROL.PasienControl;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fahmi
 */
public class AnalisaPenyakit extends javax.swing.JFrame {

    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    PasienControl pasien;

    /**
     * Creates new form AnalisaPenyakit
     */
    public AnalisaPenyakit() {
        initComponents();
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
//        setId_pasien(pasien.getUser());
        ketHelp.setVisible(false);
        int id = new PasienInput().id;
        DataDiri();
        penyakit();
        
        System.out.println(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
     * @param JTextField
     */
    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        
       // penyakitPasienList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : penyakitPasienQuery.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        Data = new javax.swing.JTable();
        ketHelp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        akun = new javax.swing.JLabel();
        tambahdata = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        id_pasien = new javax.swing.JTextField();
        nama_pasien = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        analisa = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 425));
        getContentPane().setLayout(null);

        Data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "penyakit", "waktu", "obat"
            }
        ));
        jScrollPane1.setViewportView(Data);
        if (Data.getColumnModel().getColumnCount() > 0) {
            Data.getColumnModel().getColumn(0).setResizable(false);
            Data.getColumnModel().getColumn(1).setResizable(false);
            Data.getColumnModel().getColumn(2).setResizable(false);
            Data.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(80, 290, 630, 90);

        ketHelp.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        ketHelp.setForeground(new java.awt.Color(0, 153, 255));
        ketHelp.setText("Bantuan");
        getContentPane().add(ketHelp);
        ketHelp.setBounds(650, 40, 50, 13);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bantuan/help.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(660, 0, 40, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/analisa penyakit ref.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 90, 370, 50);

        akun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/admin.png"))); // NOI18N
        akun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                akunMouseClicked(evt);
            }
        });
        getContentPane().add(akun);
        akun.setBounds(700, 10, 85, 30);

        tambahdata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/tambah data.png"))); // NOI18N
        tambahdata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tambahdataMouseClicked(evt);
            }
        });
        getContentPane().add(tambahdata);
        tambahdata.setBounds(560, 380, 190, 40);

        alamat.setEditable(false);
        alamat.setBackground(new java.awt.Color(73, 88, 134));
        alamat.setFont(new java.awt.Font("Lato Heavy", 0, 11)); // NOI18N
        alamat.setForeground(new java.awt.Color(255, 255, 255));
        alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatActionPerformed(evt);
            }
        });
        getContentPane().add(alamat);
        alamat.setBounds(200, 210, 250, 30);

        id_pasien.setEditable(false);
        id_pasien.setBackground(new java.awt.Color(73, 88, 134));
        id_pasien.setFont(new java.awt.Font("Lato Heavy", 0, 11)); // NOI18N
        id_pasien.setForeground(new java.awt.Color(255, 255, 255));
        id_pasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_pasienActionPerformed(evt);
            }
        });
        getContentPane().add(id_pasien);
        id_pasien.setBounds(200, 180, 250, 30);

        nama_pasien.setEditable(false);
        nama_pasien.setBackground(new java.awt.Color(73, 88, 134));
        nama_pasien.setFont(new java.awt.Font("Lato Heavy", 0, 11)); // NOI18N
        nama_pasien.setForeground(new java.awt.Color(255, 255, 255));
        nama_pasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_pasienActionPerformed(evt);
            }
        });
        getContentPane().add(nama_pasien);
        nama_pasien.setBounds(200, 150, 250, 30);

        jLabel10.setFont(new java.awt.Font("Lato Heavy", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(73, 88, 134));
        jLabel10.setText("ALAMAT          :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(80, 210, 110, 30);

        jLabel9.setFont(new java.awt.Font("Lato Heavy", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(73, 88, 134));
        jLabel9.setText("ID PASIEN        :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(80, 180, 110, 30);

        jLabel8.setFont(new java.awt.Font("Lato Heavy", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(73, 88, 134));
        jLabel8.setText("NAMA PASIEN :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(80, 160, 110, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/data penyakit.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 250, 690, 40);

        analisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/analisa.png"))); // NOI18N
        analisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                analisaMouseClicked(evt);
            }
        });
        getContentPane().add(analisa);
        analisa.setBounds(580, 170, 120, 40);

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/BACK.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(50, 110, 60, 20);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/logo kecil.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 20, 290, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/BACKGROUND.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 425);

        setSize(new java.awt.Dimension(800, 425));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tambahdataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahdataMouseClicked
        // TODO add your handling code here:
        new TambahPenyakit().show();
        this.dispose();
    }//GEN-LAST:event_tambahdataMouseClicked

    private void analisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analisaMouseClicked
        // TODO add your handling code here:
        new cetakanalisa().show();
        this.dispose();
    }//GEN-LAST:event_analisaMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
        new PasienInput().show();
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void akunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_akunMouseClicked
        // TODO add your handling code here:
        new LoginAdmin().show();
        this.dispose();
    }//GEN-LAST:event_akunMouseClicked

    private void nama_pasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_pasienActionPerformed
        // TODO add your handling code here:
        DataDiri();
    }//GEN-LAST:event_nama_pasienActionPerformed

    private void alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatActionPerformed
        // TODO add your handling code here:
        DataDiri();
    }//GEN-LAST:event_alamatActionPerformed

    private void id_pasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_pasienActionPerformed
        // TODO add your handling code here:
//        PasienInput Pasien = new PasienInput();
//        id_pasien.setText(Pasien.getId_user().getText());
//        System.out.println(Pasien.getId_user().getText());
        DataDiri();
    }//GEN-LAST:event_id_pasienActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        ImageIcon help = new ImageIcon("src/bantuan/analisa penyakit t.png");
        JOptionPane.showMessageDialog(null, " ", " ", JOptionPane.INFORMATION_MESSAGE, help);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        ketHelp.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        ketHelp.setVisible(false);
    }//GEN-LAST:event_jLabel3MouseExited

//    public void setNama_pasien(String nama_pasien) {
//        this.nama_pasien.setText(nama_pasien);
//    }
    public void setId_pasien(String id_pasien) {
        this.id_pasien.setText(id_pasien);
    }

    public JTextField getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(JTextField id_pasien) {
        this.id_pasien = id_pasien;
    }

    public void id(int id) {

    }

    private void DataDiri() { // menampilkan data dari database
        //PasienInput in = new PasienInput();
        int id = new PasienInput().id;

        try {
//            System.out.println(data);
            sql = "select * from pasien where ID_pasien='" + id + "'";
            stat = con.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                nama_pasien.setText(rs.getString("username"));
                id_pasien.setText(rs.getString("ID_pasien"));
                alamat.setText(rs.getString("alamat"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data diri error");
        }

    }

//private DefaultTableModel Data;

    public void penyakit() {
        int id = new PasienInput().id;
        System.out.println("tabel");
        System.out.println("id : "+id);
        DefaultTableModel tb= new DefaultTableModel();
        tb.addColumn("Penyakit");
        tb.addColumn("Waktu");
        tb.addColumn("Obat");
        Data.setModel(tb);
        try {
            sql = "select * from penyakit_pasien pp"
                    + " join penyakit a"
                    + " on pp.ID_penyakit = a.ID_penyakit where pp.ID_pasien='" + id + "'";
            stat = con.createStatement();
            rs = stat.executeQuery(sql);
            int i = 1;
            Object[] o = new Object[4];
            while(rs.next()){
//                System.out.println("input");
//                o[0]=rs.getString(i);
//                o[1]=rs.getString("a.nama_penyakit");
//                System.out.println(rs.getString("a.nama_penyakit"));
//                o[2]=rs.getString("pp.waktu");
//                System.out.println(rs.getString("pp.waktu"));
//                o[3]=rs.getString("a.riwayat_obat");
//                Data.addRowSelectionInterval(i, i   );
                
                tb.addRow(new Object[]{
                rs.getString("a.nama_penyakit"),
                rs.getDate("pp.waktu"),
                rs.getString("a.riwayat_obat")
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
            java.util.logging.Logger.getLogger(AnalisaPenyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnalisaPenyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnalisaPenyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnalisaPenyakit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnalisaPenyakit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Data;
    private javax.swing.JLabel akun;
    private javax.swing.JTextField alamat;
    private javax.swing.JLabel analisa;
    private javax.swing.JLabel back;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JTextField id_pasien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel ketHelp;
    private javax.swing.JTextField nama_pasien;
    private javax.swing.JLabel tambahdata;
    // End of variables declaration//GEN-END:variables

}
