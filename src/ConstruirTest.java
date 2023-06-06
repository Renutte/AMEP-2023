import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConstruirTest extends JDialog {
    private JPanel panel1;
    public JTextField inputIdNivell;
    public JTextField inputIdProfessor;
    private JButton buttonConfirm;
    private JLabel Title;


public ConstruirTest() {
    setModal(true);
    setContentPane(panel1);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int posX = (screenSize.width - getWidth()) / 2 - 250;
    int posY = (screenSize.height - getHeight()) / 2 - 250;
    setLocation(posX, posY);
    buttonConfirm.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
}
}
