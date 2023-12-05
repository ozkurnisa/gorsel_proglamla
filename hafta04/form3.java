package hafta04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class form3  extends JFrame  {
    private JPanel panel;
    private JCheckBox JAVACheckBox;
    private JCheckBox cCheckBox1;
    private JCheckBox JSCheckBox;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4; // bu buttonları tek bir gruba alıp sadece b
    //birinin seçilmesi gereçtiğini belirtmemiz gerkir yoksa çalışmaz chescbox a benzer


    form3 () {
        add(panel);
        setTitle(" CheckBox and RadioBUtton ");
        setSize(600,600);

        ButtonGroup bg = new ButtonGroup(); // gruplama
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);
        bg.add(radioButton4);


        JSCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               if (JSCheckBox.isSelected()) System.out.println("JS seçildi");
               else System.out.println("JS seçimi iptal edildi");
            }
        });
    }


}
