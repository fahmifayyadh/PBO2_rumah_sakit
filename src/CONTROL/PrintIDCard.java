/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;

import MODEL.koneksi;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication1.BIODATA;
import jdk.nashorn.internal.ir.TryNode;
import sun.applet.Main;

/**
 *
 * @author user
 */
public class PrintIDCard {

    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;

    public static void main(String[] args) {
  
        new Main();
    }
    public void print(){
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        Document document = new Document();
        BIODATA bio = new BIODATA();
        Long Nik = new BIODATA().Nik;
        System.out.println(Nik);
        try {
            sql = "select * from pasien where nik='" + Nik + "'";
            stat = con.createStatement();
            rs = stat.executeQuery(sql);
            System.out.println("try");
            while (rs.next()) {
                System.out.println("while");
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("d:/"+rs.getString("username")+".pdf"));
                document.open();
                document.add(new Paragraph("==================================="));
                document.add(new Paragraph("|        ID CARD PASIEN            |"));
                document.add(new Paragraph("==================================="));
                document.add(new Paragraph("|                                  |"));
                document.add(new Paragraph("| ID Pasien    : "+rs.getString("ID_pasien")));
                document.add(new Paragraph("| Nama Pasien  : "+rs.getString("username")));
                document.add(new Paragraph("| Alamat       : "+rs.getString("alamat")));
                document.add(new Paragraph("==================================="));
                document.close();
                writer.close();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(PrintIDCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
