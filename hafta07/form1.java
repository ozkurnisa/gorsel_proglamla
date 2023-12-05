package hafta07;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.concurrent.TimeUnit;

public class form1 extends JFrame {
    private JPanel panel;
    private JProgressBar progressBar1;
    private JButton button1;

    form1(){
        add(panel);
        setTitle("Progress Bar "); // durum ilerleme çubuğu
        //bir dosya dowloand edilirken - bir işlem devam ederken ne kadar ilerlemiş ne kadar kalmış onları
        // gösteren durum çubuğudur
        setSize(600,400);



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new Thread(new Runnable() {
                  @Override
                  public void run() {
                      for ( int i =0; i<100;i++){
                          try {
                              TimeUnit.MILLISECONDS.sleep(40); // thread ı 40 mili saniye uyutuyoruz
                          } catch (InterruptedException ex) {
                              throw new RuntimeException(ex); // her adımı 40 ms yavaşlattık her adımı görmek için
                          }
                          progressBar1.setValue(i); // i ye atadık

                      }
                  }
              }).start();
            }
        });
    }
}
