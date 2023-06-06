import javax.swing.*;
import java.awt.*;
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
    private JButton tencarButton;
    private JButton consultarDadesButton;

    public String buttonPressed = "";

    public MainWindow(){
        setContentPane(panel1);
        setModal(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int posX = (screenSize.width - getWidth()) / 2 - 250;
        int posY = (screenSize.height - getHeight()) / 2 - 250;
        setLocation(posX, posY);

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

        tencarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        consultarDadesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = "consultarDadesButton";
                dispose();
            }
        });
        //setUndecorated(true);
    }

    public String getButtonPressed(){
        return buttonPressed;
    }
}
