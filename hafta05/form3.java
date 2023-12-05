package hafta05;

import javax.swing.*;

public class form3 extends JFrame {
    private JPanel panel;
    private JTextArea textArea1;

    form3 (){
        add(panel);
        setSize(400,600);
        setTitle(" multiline text "); // çok satırlı text fieldler


        String s = " bugün hava yağmurlu geçiyordu. \n  ders online olarak işlendi"; //n alt satıra geçer
        textArea1.setText(s);
    }
}
