import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JDialog {
    private JPanel panel1;
    private JLabel title;
    private JButton buttonIntroduirPregunta;
    private JButton buttonConstruirTest;
    private JButton buttonDonarPermisTest;
    private JButton buttonAvaluarseTest;
    private JButton buttonNouCurs;

    private String buttonPressed = "";

    public MainWindow(){
        setContentPane(panel1);
        setModal(true);
        buttonIntroduirPregunta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = "buttonIntroduirPregunta";
                dispose();
            }
        });
        buttonConstruirTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = "buttonConstruirTest";
                dispose();
            }
        });
        buttonDonarPermisTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = "buttonDonarPermisTest";
                dispose();
            }
        });
        buttonAvaluarseTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = "buttonAvaluarseTest";
                dispose();
            }
        });
        buttonNouCurs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = "buttonNouCurs";
                dispose();
            }
        });

    }

    public String getButtonPressed(){
        return buttonPressed;
    }
}
