import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConstruirTest extends JDialog {
    private JPanel panel1;
    private JTextField inputIdNivell;
    private JTextField inputIdProfessor;
    private JButton buttonConfirm;
    private JLabel Title;


public ConstruirTest() {
    setModal(true);
    setContentPane(panel1);
    buttonConfirm.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
}
}
