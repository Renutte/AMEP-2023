import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PropostaResposta extends JDialog{
    private JPanel panel1;
    public JTextField inputIdPregunta;
    public JTextField inputOrdinal;
    private JButton confirmButton;
    private JButton cancelButton;

    public String buttonPressed = "";

    public PropostaResposta() {
        setModal(true);
        setContentPane(panel1);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int posX = (screenSize.width - getWidth()) / 2 - 250;
        int posY = (screenSize.height - getHeight()) / 2 - 250;
        setLocation(posX, posY);
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
