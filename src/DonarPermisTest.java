import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DonarPermisTest extends JDialog {
    private JPanel panel1;
    public JTextField inputIdText;
    public JTextField inputIdProfessor;
    private JButton buttonConfirm;
    private JButton buttonCancel;
    public String buttonPressed = "";

    public DonarPermisTest() {
        setModal(true);
        setContentPane(panel1);
        buttonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = "buttonConfirm";
                dispose();
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = "buttonCancel";
                dispose();
            }
        });
    }
}
