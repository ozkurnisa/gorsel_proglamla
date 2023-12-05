package hafta04;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class form2 extends JFrame {
    private JPanel panel;
    private JSlider vs;
    private JSlider os;
    private JSlider fs;
    private JLabel vl;
    private JLabel fl;
    private JLabel ol;

    int v,f;
    float o ;

    form2 (){ // costrter method

        add(panel);
        setTitle(" VİZE FİNAL ");
        setSize(600,400);

        v=f=0;
        o=0;

        vs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                v = (int) vs.getValue();//değeri al
                f =(int)  fs.getValue();
                o=(float) ( (float )v*0.4+f*0.6);
                os.setValue(Math.round(0));// sayı 0,5 ten yukarı ise üste aşağı ise alta yuvarlar
                vl.setText("VİZE = " + Integer.toString(v));
                fl.setText("FİNAL = " + Integer.toString(f));
                ol.setText("ORTALAMA = " +Float.toString(o));

                if (o>=60 && o<=100 ) os.setBackground(Color.GREEN);
                else if (o>=55 && o <60) os.setBackground(Color.orange);
           else os.setBackground(Color.red);
            }
        });

        fs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                v = (int) vs.getValue();//değeri al
                f =(int)  fs.getValue();
                o=(float) ( (float )v*0.4+f*0.6);
                os.setValue(Math.round(0));// sayı 0,5 ten yukarı ise üste aşağı ise alta yuvarlar
                vl.setText("VİZE = " + Integer.toString(v));
                fl.setText("FİNAL = " + Integer.toString(f));
                ol.setText("ORTALAMA = " +Float.toString(o));

                if (o>=60 && o<=100 ) os.setBackground(Color.GREEN);
                else if (o>=55 && o <60) os.setBackground(Color.orange);
                else os.setBackground(Color.red);
            }
        });

    }
}
