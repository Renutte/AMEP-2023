import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AvaluarseTest extends JDialog {
    private JTextField inputIdTest;
    private JTextField inputIdEstudiant;
    private JButton confirmButton;
    private JButton cancelButton;
    private JPanel panel1;

    public String buttonPressed = "";

    public AvaluarseTest() {
        setModal(true);
        setContentPane(panel1);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = "buttonConfirm";
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed = "buttonCancel";
                dispose();
            }
        });
    }
}
