/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class koneksi {
    private static Connection koneksi;
    public static Connection getConnection()throws SQLException{
        if (koneksi==null) {
            new Driver() {
                @Override
                public Connection connect(String string, Properties prprts) throws SQLException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean acceptsURL(String string) throws SQLException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public DriverPropertyInfo[] getPropertyInfo(String string, Properties prprts) throws SQLException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int getMajorVersion() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int getMinorVersion() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean jdbcCompliant() {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
            
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/rekammedis","root","");
            
        }
        return koneksi;
    }

    public static Connection getKoneksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public Connection con;
    public Statement stm;

    public void config() {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/rekammedis","root","");
            stm = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
        } //To change body of generated methods, choose Tools | Templates.
    }
    
}
