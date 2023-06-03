import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropostaResposta extends JDialog{
    private JPanel panel1;
    private JTextField inputIdPregunta;
    private JTextField inputOrdinal;
    private JButton confirmButton;
    private JButton cancelButton;

    public String buttonPressed = "";

    public PropostaResposta() {
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
