package hafta05;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;

public class form2 extends  JFrame {
    private JPanel panel;
    private JPasswordField passwordField1;
    private JButton button1;
    private JFormattedTextField formattedTextField1;



    form2 (){
        add(panel);
        setTitle("password  ve formatted text "); // get ile şifre alınmalıdır
        setSize(600,400);



        try {
            MaskFormatter mf = new MaskFormatter("(05#) LLL UU AA ## ");
            mf.install(formattedTextField1); // atama yaptığımız kısım
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //    #    işareti sadece sayısal veri girmemizi ister
        //    L    lower sadece küçük harf
        //    U    sadece büyük harf
        //    A    alpha sayı ve harf girişi ister


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //string veri alamayız karakater olmalı,

                char[]  ps= passwordField1.getPassword();// gettext yazar isek ram e ulaşan programlarla verimiz çalınabilir
                button1.setText(ps.toString());// karakter olduğu için strginge çevirdik

            }
        });
    }
}
