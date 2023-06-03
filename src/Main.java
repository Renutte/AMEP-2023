import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static K k = new K();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                K k = new K();

                System.out.println("Crea maniwindow");
                String buttonPressed = MainWindow();
                System.out.println("Cierra maniwindow");

                if (buttonPressed == "buttonIntroduirPregunta"){
                    IntroduirPregunta form = IntroduirPregunta();
                    int idPregunta = Integer.parseInt(form.inputIdPregunta.getText());
                    String descripcio = form.inputDescripcio.getText();
                    String text_pregunta = form.inputText_pregunta.getText();
                    int idNivell = Integer.parseInt(form.inputIdNivell.getText());
                    System.out.println("Introduir Pregunta: " + idPregunta + " -- " + descripcio + " -- " + text_pregunta + " -- " + idNivell);
                }

            }

            public IntroduirPregunta IntroduirPregunta(){
                IntroduirPregunta frame = new IntroduirPregunta();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
            }

            public String MainWindow(){
                MainWindow frame = new MainWindow();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame.getButtonPressed();
            }

        });
    }
}