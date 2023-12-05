package hafta01;

import javax.swing.*;

public class baslat {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { //thread formun oluşmasını
            // ve basılmasını sağlar ekranla uyumlu şekilde
            @Override
            public void run() {

            }
        });
        form1 f1 = new form1();
        f1.setVisible(true);//kapalı durumdan açık hale
        // getiriyor oluşan formun ekranda görünmesini sağlıyor
    }
}
