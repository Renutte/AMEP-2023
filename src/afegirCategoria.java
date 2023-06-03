import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class afegirCategoria extends JDialog {
    private JTextField inputNomCategoria;
    private JPanel panel1;
    private JLabel Title;
    private JButton buttonConfirm;
    private JButton buttonCancel;
public afegirCategoria() {
    setModal(true);
    setContentPane(panel1);
    buttonConfirm.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    });
}
}
