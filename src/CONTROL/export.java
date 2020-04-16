/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROL;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import MODEL.koneksi;
/**
 *
 * @author user
 */
public class export {
    JTable tabel;        // gui jtabelnya takkasi nama variabel tabelmhs
    JButton close, print;          // gui jbutton takkasi nama variabel print

    public static void main(String[] args) {
        JTable tabel = null;
        // TODO code application logic here
        new export(tabel);         // inisialisasi kelas table biar isinya bisa di run nanti
    }

    public export(JTable tabel2) {
        this.tabel = tabel2;
        JFrame frame = new JFrame("Export to PDF");     // nama framenya
        JPanel panel = new JPanel();        // nama panelnya
//        String data[] = {"NIM", "Nama", "Asal"};    // nama kolom buat tabelnya
//        String isidata[][] = {{"172410102072", "velia aprita dewi", "jombang"}, {"172410102048", "aisyah candra", "banyuwangi"}, {"172410102041", "firzaq emir", "kediri"}};    // isi data tabelnya
        java.sql.Connection con = koneksi.getKoneksi();
        DefaultTableModel model = new DefaultTableModel(); // gabungkan antara nama kolom sama isinya biar jadi tabel
        model.addColumn("Nama Pasien");
        model.addColumn("ID Pasien");
        model.addColumn("Alamat");
        model.addColumn("Riwayat Penyakit");
        model.addColumn("Waktu");
        model.addColumn("Obat");
        model.addColumn("Hasil Analisis");
        tabel = new JTable(model);       // inisialisasi kalo isi variabel tabelmhs itu gabungan kolom sama isinya kolomnya
        JScrollPane pane = new JScrollPane(tabel);   // tabel itu kan punyaknya JScrollPane, nahh ini itu ngasi tau kalo JScrollPane itu punya tabel namanya tabelmhs
        try {
            String sql = "select * from ";
            //java.sql.Connection con = (Connection) con.getKoneksi();
            java.sql.Statement stm = con.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                model.addRow(new Object[]{
                    res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5) , res.getString(6) , res.getString(7)
                });
            }
            tabel.setModel(model);

        } catch (Exception e) {
            System.out.println("gagal");
        }
        close = new JButton ("close");
        close.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        print = new JButton("Convert To PDF");      // ini ngasih tau kalo print itu JButton yang tulisannya convert to pdf
        //System.out.println(data.length);
        print.addActionListener(new ActionListener() {      // ini ngasi action pas di klik nanti
            public void actionPerformed(ActionEvent ae) {
                try {            // ini logika buat ngambil data yang ada di tabelnya biar bisa di convert ke pdf
                    int count = tabel.getRowCount();       //variabel buat ngitung jumlah barisnya ada berapa
                    Document doc = new Document();        // buat document baru yang isi document nya nanti itu hasil convert nya
                    PdfWriter.getInstance(doc, new FileOutputStream("d:/data.pdf"));     // letak nyimpen file pdf nya
                    doc.open();     // ini buat kalo misal doc nya di buka itu ada isinya sesuai isi tabelnya
                    PdfPTable tab = new PdfPTable(5);     // nama variabel buat ngonvert tabel gui nya itu ke tabel pdf dengan jumlah 3 kolom

                    tab.addCell("Nama Pasien");
                    tab.addCell("ID Pasien");
                    tab.addCell("Alamat");
                    tab.addCell("Riwayat Penyakit");
                    tab.addCell("Waktu");
                    tab.addCell("Obat");
                    tab.addCell("Hasil Analisis");
                    for (int i = 0; i < count; i++) {       // looping buat ngecek data yabg ada di baris tabel gui
                        Object obj1 = getData(tabel, i, 0);
                        Object obj2 = getData(tabel, i, 1);
                        Object obj3 = getData(tabel, i, 2);
                        Object obj4 = getData(tabel, i, 3);
                        Object obj5 = getData(tabel, i, 4);
                        Object obj6 = getData(tabel, i, 5);
                        Object obj7 = getData(tabel, i, 6);
                        String value1 = obj1.toString();
                        String value2 = obj2.toString();
                        String value3 = obj3.toString();
                        String value4 = obj4.toString();
                        String value5 = obj5.toString();
                        String value6 = obj6.toString();
                        String value7 = obj7.toString();

                        tab.addCell(value1);
                        tab.addCell(value2);
                        tab.addCell(value3);
                        tab.addCell(value4);
                        tab.addCell(value5);
                        tab.addCell(value6);
                        tab.addCell(value7);
                    }
                    doc.add(tab);   // nambahkan data tab ke doc nya
                    doc.close();    // kalo suda selesai ngonvert nya doc di tutup
                } catch (Exception e) {
                }
            }

        });
        panel.add(pane);    // nambahkan panel pane buat tombol print nya
        panel.add(print);
        panel.add(close); 
        frame.add(panel);   // nambahkan frame panel
        frame.setSize(500, 500);     // ukuran frame nya
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);     // aku lupa yg ini buat apa tapi kalo di comment tombol print nya ilang
        frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
        frame.setVisible(true);     // biar muncul kalo di run
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // kalo di x nanti run nya selesai
    }

    public Object getData(JTable tabelmhs, int i, int i0) {     // biar ndak error
        return tabelmhs.getModel().getValueAt(i, i0);
    }
}
