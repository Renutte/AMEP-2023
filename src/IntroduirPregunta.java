import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroduirPregunta extends JDialog {
    public JTextField inputIdPregunta;
    private JPanel panel1;
    public JTextField inputDescripcio;
    public JTextField inputText_pregunta;
    public JTextField inputIdNivell;
    private JButton buttonDone;
    private JLabel Title;
public IntroduirPregunta() {
    setModal(true);
    setContentPane(panel1);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int posX = (screenSize.width - getWidth()) / 2 - 250;
    int posY = (screenSize.height - getHeight()) / 2 - 250;
    setLocation(posX, posY);
    buttonDone.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            //k.introduirPregunta(Integer.parseInt(inputIdPregunta.getText()), inputDescripcio.getText(), inputText_pregunta.getText(), Integer.parseInt(inputIdNivell.getText()));
        }
    });
}
}
