import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageBox extends JDialog{
    private JButton acceptarButton;
    private JLabel labelText;
    private JPanel panel1;

    public MessageBox(String msgText) {
    setModal(true);
    setContentPane(panel1);
    labelText.setText(msgText);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int posX = (screenSize.width - getWidth()) / 2 - 250;
        int posY = (screenSize.height - getHeight()) / 2 - 250;
        setLocation(posX, posY);
    acceptarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    });
}
}
