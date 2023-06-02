import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroduirPregunta extends JFrame {
    private JTextField inputIdPregunta;
    private JPanel panel1;
    private JTextField inputDescripcio;
    private JTextField inputText_pregunta;
    private JTextField inputIdNivell;
    private JButton buttonDone;
    private JLabel Title;
public IntroduirPregunta(K k) {
    setContentPane(panel1);
    buttonDone.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            k.introduirPregunta(Integer.parseInt(inputIdPregunta.getText()), inputDescripcio.getText(), inputText_pregunta.getText(), Integer.parseInt(inputIdNivell.getText()));
        }
    });
}
}
