/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import MODEL.koneksi;
import static java.lang.reflect.Array.set;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 *
 * @author fahmi
 */
public class LoginAdmin extends javax.swing.JFrame {

    /**
     * Creates new form LoginAdmin
     */
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
    public static String generatedPassword;
    
    public LoginAdmin() {
        initComponents();
        error.setVisible(false);
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;  
    }

    /**

     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_login = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        exit = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        btn_login.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/login.png"))); // NOI18N
        btn_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_loginMouseClicked(evt);
            }
        });
        getContentPane().add(btn_login);
        btn_login.setBounds(510, 310, 210, 50);

        error.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        error.setForeground(new java.awt.Color(204, 0, 0));
        error.setText("Inputan anda salah. silahkan periksa ulang ");
        getContentPane().add(error);
        error.setBounds(510, 270, 240, 20);

        password.setBackground(new java.awt.Color(73, 88, 134));
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.setText("Password");
        password.setBorder(null);
        getContentPane().add(password);
        password.setBounds(520, 230, 200, 14);

        username.setBackground(new java.awt.Color(73, 88, 134));
        username.setFont(new java.awt.Font("Lato Heavy", 0, 11)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        username.setText("Username");
        username.setBorder(null);
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameMouseClicked(evt);
            }
        });
        username.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                usernameInputMethodTextChanged(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        getContentPane().add(username);
        username.setBounds(520, 170, 200, 20);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/close.png"))); // NOI18N
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit);
        exit.setBounds(766, 0, 34, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/foto/LOGIN ADMIN.png"))); // NOI18N
        jLabel1.setText("bantuan ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 420);

        setSize(new java.awt.Dimension(800, 419));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_usernameActionPerformed

    private void usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    private void usernameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_usernameInputMethodTextChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_usernameInputMethodTextChanged

    private void btn_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_loginMouseClicked
        // TODO add your handling code here:
        encrypt();
    }//GEN-LAST:event_btn_loginMouseClicked

//    public void cek(){
//        String Username = username.getText();
//        String Password = password.getText();
//        System.out.println("Username :" +Username);
//        System.out.println("Password :"+ Password);
//        
//        if (Username.equalsIgnoreCase("admin") && Password.equalsIgnoreCase("123")) {
//            JOptionPane.showMessageDialog(null, "Login Berhasil");
//            new ADMIN().show();
//            dispose();
//        }
//        if (Username.equalsIgnoreCase("operator")&& Password.equalsIgnoreCase("123")) {
//            JOptionPane.showMessageDialog(null, "Login Berhasil");
//            new operator().show();
//            dispose();
//        }
//        if (Username.equalsIgnoreCase("") || Password.equalsIgnoreCase("")) {
//            JOptionPane.showMessageDialog(null, "Lengkapi form login");
//        }else{
//            error.setVisible(true);
//        }
//    }
    public void login(){
        int ID_jenis;
         try {
            sql = "SELECT * FROM login WHERE username='"+username.getText()+"' AND password='"+generatedPassword+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                String a = rs.getString("ID_jenis");
                if(username.getText().equals(rs.getString("username")) && generatedPassword.equals(rs.getString("password")) && a.equalsIgnoreCase("1")){
                    error.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Selamat datang Admin");
                    new ADMIN().show();
                    dispose();
                    
                }else if (username.getText().equals(rs.getString("username")) && generatedPassword.equals(rs.getString("password")) && a.equalsIgnoreCase("2")) {
                    error.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Selamat datang Operator");
                    new operator().show();
                    dispose();
                }
            }else{
                error.setVisible(true);
                JOptionPane.showMessageDialog(null, "username atau password salah");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    
    }
    public void encrypt(){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
         
            md.update(password.getText().getBytes());
        
            byte[] bytes = md.digest();
         
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
         
            generatedPassword = sb.toString();
            login();

        } catch (Exception e) {
        }
    }
    
//    public void masuk(){
//        try {
//            Statement statement = (Statement)koneksi.getConnection().createStatement();
//            ResultSet result=statement.executeQuery("select * from login where"+"username="+username.getText()+"");
//            if (result.next()) {
//                if (password.getText().equals(result.getString("password"))) {
//                    new ADMIN().show();
//                    dispose();
//                }else{
//                    JOptionPane.showMessageDialog(rootPane, "password salah");
//                    password.setText("");
//                    password.requestFocus();
//                }
//            }else{
//                JOptionPane.showMessageDialog(rootPane,"user tidak ditemukan");
//                username.setText("");
//                password.setText("");
//                username.requestFocus();
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "gagal login");
//        }
//    }
//    
//    private void tes2(){
//        // TODO add your handling code here:
//        koneksi();
//        try {
//            String sql = "SELECT * FROM users WHERE username = '" + username.getText() + "' AND password = '" + password.getText() + "'";
//            Statement statement = koneksi().createStatement();
//            ResultSet rsLogin = st.executeQuery(sql);
// 
//            rsLogin.next();
//            rsLogin.last(); //mengecek jumlah baris pada hasil query
//            if (rsLogin.getRow()==1){
//                JOptionPane.showMessageDialog(null, "Login Berhasil!");
//                // new FrmMenuUtama().setVisible(true); //<-- BILA MAU DIARAHKAN KE Frame Menu Utama
//                this.dispose();
//            } else {
//                JOptionPane.showMessageDialog(null, "Maaf, Username / Password salah!");
//                password.setText("");
//                password.requestFocus();
//            }
//        } catch (SQLException e) {
//        }
//    }
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
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_login;
    private javax.swing.JLabel error;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
