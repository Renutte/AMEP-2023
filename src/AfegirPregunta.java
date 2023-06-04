import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AfegirPregunta extends JDialog {
    private JPanel panel1;
    public JTextField inputIdPregunta;
    private JButton buttonConfirm;
    private JButton buttonCancel;
    public String buttonPressed = "";
public AfegirPregunta() {
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
