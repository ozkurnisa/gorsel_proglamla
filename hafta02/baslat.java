package hafta02;

import javax.swing.*;

public class baslat {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                form2 f2 = new form2();
                f2.setVisible(true);

            }
        });
    }
}
