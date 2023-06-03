import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfegirEstudiant extends JDialog {
    private JTextField inputIdEstudiant;
    private JButton buttonConfirm;
    private JButton cancelButton;
    private JPanel panel1;
    public String buttonPressed = "";

    public AfegirEstudiant() {
        setModal(true);
        setContentPane(panel1);
        buttonConfirm.addActionListener(new ActionListener() {
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
