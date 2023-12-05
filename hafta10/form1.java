package hafta10;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class form1 extends JFrame {
    private JPanel panel;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton EKLEButton;
    private JButton GÜNCELLEButton;
    private JButton SİLButton;
    private JButton TABLOOLUŞTURButton;

    DefaultTableModel modelim = new DefaultTableModel();
    Object [] kolonlar = { "Numarası","Ad","Soyad","Telefonu"};
    Object[] satirlar = new Object[4];


    form1(){

        add(panel);
        setSize(400,600);
        setTitle("CRUD");
        veritabani.baglan();
        String sorgu = " select * from ogrenci";
        ResultSet rs = veritabani.listele(sorgu);//sorguyu liste halinde bize gönderir

        modelim.setColumnCount(0);// colonu sıfırladık
        modelim.setRowCount(0);//satır sasyısını sıfrıladık
        modelim.setColumnIdentifiers(kolonlar);

        try {
            while (rs.next()){
                satirlar[0] = rs.getString("ogrencino");
                satirlar[1] = rs.getString("ad");
                satirlar[2] = rs.getString("soyad");
                satirlar[3] = rs.getString("tel");
                modelim.addRow((satirlar));
            }
            table1.setModel(modelim);
        }catch (SQLException e ){
            e.printStackTrace();//hata olursa hatayı bize kodla yazdırır
        }


        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int s = table1.getSelectedRow();
                textField1.setText(table1.getValueAt(s,0).toString());//seçilen satırın 0. hücresini tostringe dönüştürüp yazıcaz
                textField2.setText(table1.getValueAt(s,1).toString());
                textField3.setText(table1.getValueAt(s,2).toString());
                textField4.setText(table1.getValueAt(s,3).toString());
            }
        });
        EKLEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sorgu = " insert into ogrenci (ogrencino,ad,soyad,tel)"+
                        "values( '" +textField1.getText()+ "',' " +textField2.getText()+ "','" +textField3.getText()+"',' " +textField4.getText()+ "  ' )";// veritabanına  veri ekliyoruz
                //+textField1.getText()+ilk numara verisi şeklinde sırayla aldık


                veritabani.ekle(sorgu);



            }
        });
        GÜNCELLEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sorgu = "update ogrenci " +
                "set   ogrencino= '"+textField1.getText()+"'  , ad='"+textField2.getText()+"', soyad='"+textField3.getText()+"', tel='"+textField4.getText()+"' "+
                        "where ogrencino='"+textField1.getText()+"'";

                veritabani.guncelle(sorgu);
            }
        });
        SİLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sorgu = " delete from ogrenci where ogrencino='"+textField1.getText()+"'";

                veritabani.sil(sorgu);
            }
        });


        TABLOOLUŞTURButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sorgu = "CREATE TABLE IF NOT EXISTS stoklar(id varchar(10) NOT NULL," + //CREATE TABLE IF NOT EXISTS yani tablo yoksa tablo olştur
                        "urunadi varchar(20), urunadedi integer, urunturu varchar(10)," +
                        "CONSTRAINT stoklar_pkey PRIMARY KEY (id))";// pr atamasını yaptık


                System.out.println(sorgu);
                veritabani.olustur(sorgu);
            }
        });

    }


}
