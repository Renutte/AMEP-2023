import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class afegirCategoria extends JDialog {
    public JTextField inputNomCategoria;
    private JPanel panel1;
    private JButton buttonConfirm;
    private JButton buttonCancel;

    public String buttonPressed = "";
public afegirCategoria() {
    setModal(true);
    setContentPane(panel1);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int posX = (screenSize.width - getWidth()) / 2 - 250;
    int posY = (screenSize.height - getHeight()) / 2 - 250;
    setLocation(posX, posY);
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
