import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroduirResposta extends JDialog {
    private JPanel panel1;
    public JTextField inputText_Resposta;
    public JCheckBox inputCorrecta;
    private JButton buttonConfirm;
    private JButton buttonCancel;
    private JLabel Title;
    public String buttonPressed = "";
public IntroduirResposta() {
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
