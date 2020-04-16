///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package CONTROL;
//
///**
// *
// * @author user
// */
//public class exportfile {
//    public class Main {
//    JTable tabelmhs;        // gui jtabelnya takkasi nama variabel tabelmhs
//    JButton print;          // gui jbutton takkasi nama variabel print
//    
//    public static void main(String[] args) {
//        // TODO code application logic here
//        new Main();         // inisialisasi kelas Main biar isinya bisa di run nanti
//    }
//    
//    public Main() {
//        JFrame frame = new JFrame("Export to PDF");     // nama framenya
//        JPanel panel = new JPanel();        // nama panelnya
//        String data[] = {"NIM", "Nama", "Asal"};    // nama kolom buat tabelnya
//        String isidata[][] = {{"172410102072", "velia aprita dewi", "jombang"}, {"172410102048", "aisyah candra", "banyuwangi"}, {"172410102041", "firzaq emir", "kediri"}};    // isi data tabelnya
//        DefaultTableModel model = new DefaultTableModel(isidata, data); // gabungkan antara nama kolom sama isinya biar jadi tabel
//        tabelmhs = new JTable(model);       // inisialisasi kalo isi variabel tabelmhs itu gabungan kolom sama isinya kolomnya
//        JScrollPane pane = new JScrollPane(tabelmhs);   // tabel itu kan punyaknya JScrollPane, nahh ini itu ngasi tau kalo JScrollPane itu punya tabel namanya tabelmhs
//        print = new JButton("Convert To PDF");      // ini ngasih tau kalo print itu JButton yang tulisannya convert to pdf
//        print.addActionListener(new ActionListener() {      // ini ngasi action pas di klik nanti
//            public void actionPerformed(ActionEvent ae) {
//                try{            // ini logika buat ngambil data yang ada di tabelnya biar bisa di convert ke pdf
//                    int count=tabelmhs.getRowCount();       //variabel buat ngitung jumlah barisnya ada berapa
//                    Document doc=new Document();        // buat document baru yang isi document nya nanti itu hasil convert nya
//                    PdfWriter.getInstance(doc,new FileOutputStream("d:/data.pdf"));     // letak nyimpen file pdf nya
//                    doc.open();     // ini buat kalo misal doc nya di buka itu ada isinya sesuai isi tabelnya
//                    PdfPTable tab=new PdfPTable(3);     // nama variabel buat ngonvert tabel gui nya itu ke tabel pdf dengan jumlah 3 kolom
//                    tab.addCell("NIM");     // membuat kolom NIM
//                    tab.addCell("Nama");    // membuat  kolom nama
//                    tab.addCell("Asal");    // membuat kolom asal
//                    for(int i=0;i<count;i++){       // looping buat ngecek data yabg ada di baris tabel gui
//                        Object obj1 = getData(tabelmhs, i, 0);
//                        Object obj2 = getData(tabelmhs, i, 1);
//                        Object obj3 = getData(tabelmhs, i, 2);
//                        String value1=obj1.toString();
//                        String value2=obj2.toString();
//                        String value3=obj3.toString();
//   
//                        tab.addCell(value1);
//                        tab.addCell(value2);
//                        tab.addCell(value3);
//                    }
//                doc.add(tab);   // nambahkan data tab ke doc nya
//                doc.close();    // kalo suda selesai ngonvert nya doc di tutup
//                }   
//            catch(Exception e){}
//            }
//        }
//            
//    
//}
