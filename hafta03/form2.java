package hafta03;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class form2 extends JFrame {
    private JComboBox comboBox1;
    private JPanel panel;
    DefaultComboBoxModel model = new DefaultComboBoxModel<>();


    form2 (){
        add(panel);
        setTitle(" DİNAMİK COMBOBOX");
        setSize(600,400);
        // model.addElement(" Ankara"); // tek tek eleman ekleme
        //model.addElement(" İstanbul");
        //model.addElement(" Konya");

/*
        for( int i=0; i<256;i++){
            model.addElement(Integer.toString(i));
        }*/

        ArrayList<String> isimler = new ArrayList<>(Arrays.asList("ali","ayşe","betül","cihan"));
        model.addAll(isimler);
        comboBox1.setModel(model);
    }
}
