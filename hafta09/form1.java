package hafta09;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 extends JFrame {

    private JPanel panel;
    private JTextField textField1;
    private JButton button1;

    form1 () {
        add(panel);
        setSize(400,600);
        setTitle("Message Diolags"); // uyarı kutuları bir hata ollduğu zaman ya da istenmeyen
                                     // mesaj olduğunda açılan mesaj türleridir

        //JOptionPane.showMessageDialog(null,"form şu am oluştu","form oluşumu",JOptionPane.ERROR_MESSAGE);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a= Integer.parseInt(textField1.getText());
                if( a<0 || a>100){
                    JOptionPane.showMessageDialog(null,"Lütfen 0 ile 100 arasında sayı giriniz!","Hatalı sayı girişi",JOptionPane.ERROR_MESSAGE);
                }else{
                    //yapılacak işler
                }
            }
        });
    }
}
