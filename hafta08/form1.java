package hafta08;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class form1 extends JFrame {
    private JPanel panel;
    private JTable table1;
    private JComboBox comboBox1;
    private JButton button1;

    DefaultTableModel modelim = new DefaultTableModel();
    Object[] kolonlar = { "Plaka","Marka","Model","Tür"};
    Object[] satirlar = new Object[4];//satır aslında bizim aldığımız her bir verinin kolon sayısıdır

    DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel<>();



    form1() {
        add(panel);
        setSize(400, 600);
        setTitle("veritabanı");
        veritabani.baglan();

        String sorgu = "select * from arac";
        ResultSet rs = veritabani.listele(sorgu); /*veritabanına bağlandık ardından bir sorgu yazdık
                                                   bu soruguyu veritabanı sıfındaki listele methoduna gönderdik
                                                    sonuç return edilecek ve sonucu rs değişkeni içerisinde saklaya*/



        modelim.setColumnCount(0);//tabloyu sıfılarfık
        modelim.setRowCount(0);
        modelim.setColumnIdentifiers(kolonlar);

      //  while(rs.next())next ile satır satır gelen verilerin hepsini almasını sağlarız


        try {
            while (rs.next()){
                satirlar[0] = rs.getString("plaka");
                satirlar[1] = rs.getString("marka");
                satirlar[2] = rs.getString("model");
                satirlar[3] = rs.getString("tur");
                comboBoxModel.addElement(satirlar[0]);
                modelim.addRow((satirlar));
            }
            table1.setModel(modelim);
            comboBox1.setModel(comboBoxModel);

        }catch (SQLException e ){
            e.printStackTrace();//hata olursa hatayı bize kodla yazdırır

        }


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = comboBox1.getSelectedItem().toString();
                String sorgu = "select arac.plaka,aracmarka.marka,arac.model,aractur.tur from arac,aracmarka,aractur where arac.plaka='"+ s +"' AND arac.marka=aracmarka.id AND arac.tur=aractur.id";
                ResultSet rs = veritabani.listele(sorgu);


                modelim.setColumnCount(0);//tabloyu sıfılarfık sıfırlamazsak üzerine yazar
                modelim.setRowCount(0);
                modelim.setColumnIdentifiers(kolonlar);

                try {
                    while (rs.next()){
                        satirlar[0] = rs.getString("plaka");
                        satirlar[1] = rs.getString("marka");
                        satirlar[2] = rs.getString("model");
                        satirlar[3] = rs.getString("tur");

                        modelim.addRow((satirlar));
                    }
                    table1.setModel(modelim);

                }catch (SQLException e2 ){
                    e2.printStackTrace();
                }

            }
        });
    }
}