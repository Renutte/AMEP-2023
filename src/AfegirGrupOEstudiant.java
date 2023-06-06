import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfegirGrupOEstudiant extends JDialog {
    private JPanel panel1;
    private JButton afegirGrupButton;
    private JButton afegirEstudiantButton;
    private JButton confirmarButton;
    public String buttonPressed = "";

public AfegirGrupOEstudiant() {
    setModal(true);
    setContentPane(panel1);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int posX = (screenSize.width - getWidth()) / 2 - 250;
    int posY = (screenSize.height - getHeight()) / 2 - 250;
    setLocation(posX, posY);
    afegirGrupButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPressed = "afegirGrupButton";
            dispose();
        }
    });
    afegirEstudiantButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPressed = "afegirEstudiantButton";
            dispose();
        }
    });
    confirmarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPressed = "confirmarButton";
            dispose();
        }
    });
}
}
