import javax.swing.*;
import java.awt.*;
import java.io.OutputStream;
import java.io.PrintStream;

public class ConsultarDades extends JDialog {
    private JTextArea consoleTextArea;
    private JPanel panel1;

    public ConsultarDades(K k) {
        setModal(true);
        setContentPane(panel1);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int posX = (screenSize.width - 500) / 2;
        int posY = (screenSize.height - 500) / 2;
        setLocation(posX, posY);
        setTitle("Consola en Formulario");

        consoleTextArea = new JTextArea();
        consoleTextArea.setEditable(false);

        PrintStream printStream = new PrintStream(new ConsoleOutputStream(consoleTextArea));
        System.setOut(printStream);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(consoleTextArea), BorderLayout.CENTER);

        k.PrintInfo();

        JButton closeButton = new JButton("Cerrar");
        getContentPane().add(closeButton, BorderLayout.SOUTH);
        closeButton.addActionListener(e -> dispose());
    }

    private class ConsoleOutputStream extends OutputStream {
        private JTextArea textArea;

        public ConsoleOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) {
            textArea.append(String.valueOf((char) b));
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
}
