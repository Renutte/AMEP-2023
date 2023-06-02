import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JPanel panel1;
    private JLabel title;
    private JButton buttonIntroduirPregunta;
    private JButton buttonConstruirTest;
    private JButton buttonDonarPermisTest;
    private JButton buttonAvaluarseTest;
    private JButton buttonNouCurs;

    public MainWindow(K k){
        setContentPane(panel1);
        buttonIntroduirPregunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new IntroduirPregunta(k);
                frame.setSize(500, 500);
                frame.setVisible(true);
            }
        });
    }
}
