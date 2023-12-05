package hafta03;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class form1  extends JFrame {


    private JPanel panel;
    private JComboBox comboBox1;
    private JLabel lbl1;
    private JLabel lbl2;

    form1( ) {
        add(panel);
        setTitle("comboBox");
        setSize(600,400);

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
             int secilen = (int) comboBox1.getSelectedIndex();
             lbl1.setText(Integer.toString(secilen));

             lbl2.setText(comboBox1.getSelectedItem().toString()); // to string ekliyorz çünkü obje türünü strginge çeviriyoruz

              if((int)comboBox1.getSelectedIndex()==0)
              {
                  System.out.println(" ELMA SEÇİLDİ");
              }
              if (comboBox1.getSelectedItem().toString().equals("ARMUT")){
                  System.out.println(" ARMUT SEÇİLDİ");
              }
            }

        });
    }




}
