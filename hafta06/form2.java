package hafta06;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.zip.CheckedOutputStream;

public class form2 extends JFrame {
    private JPanel panel;
    private JTable table1;
    private JButton button1;

    DefaultTableModel model = new DefaultTableModel();

    form2 () {
        add(panel);
        setSize(400,400);
        setTitle("Tables ");


        model.setRowCount(3); //satır sayısı
        model.setColumnCount(3); // sutün sayısı

        table1.setModel(model);
        table1.setTableHeader(null);// header yok etmek


        table1.setValueAt(25,0,0);// değer.sutün.satır
        table1.setValueAt(12,0,1);
        table1.setValueAt(17,0,2);

       // System.out.println( table1.getValueAt(0,0));// 0 adresindeki veriyi alır
       // System.out.println(table1.getSelectedRow()+"-"+table1.getSelectedColumn()); //ivente atayıp üzerine tıklayınca çalışmasının sağlamalıyız
                                                                                    // seçilenin satır sütüun alma
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(table1.getSelectedRow()+"-"+table1.getSelectedColumn());
                System.out.println(table1.getValueAt(table1.getSelectedRow(),table1.getSelectedColumn()));
            }
        });
    };
    }

