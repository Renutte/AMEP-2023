import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfegirGrup  extends JDialog {
    public JTextField inputIdGrup;
    private JButton buttonConfirm;
    private JButton buttonCancel;
    private JPanel panel1;
    public String buttonPressed = "";

    public AfegirGrup() {
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
