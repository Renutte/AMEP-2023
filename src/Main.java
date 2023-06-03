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
                k.feedLists();

                String buttonPressed = MainWindow();

                if (buttonPressed == "buttonIntroduirPregunta"){
                    // IP
                    IntroduirPregunta ip = IntroduirPregunta();
                    int idPregunta = Integer.parseInt(ip.inputIdPregunta.getText());
                    String descripcio = ip.inputDescripcio.getText();
                    String text_pregunta = ip.inputText_pregunta.getText();
                    int idNivell = Integer.parseInt(ip.inputIdNivell.getText());
                    k.introduirPregunta(idPregunta, descripcio, text_pregunta, idNivell);
                    // AC
                    String ac_buttonPressed = "buttonConfirm";
                    boolean introduidaUna = false;
                    while (ac_buttonPressed == "buttonConfirm" || introduidaUna == false){
                        afegirCategoria ac = AfegirCategoria();
                        ac_buttonPressed = ac.buttonPressed;
                        String nom_categoria = ac.inputNomCategoria.getText();
                        if (ac_buttonPressed == "buttonConfirm" && !nom_categoria.equals("") && k.findCategoria(nom_categoria) != null){
                            k.afegirCategoria(nom_categoria);
                            introduidaUna = true;
                        }
                    }
                    // IR
                    /*String ac_buttonPressed = "buttonConfirm";
                    boolean introduidaUna = false;
                    while (ac_buttonPressed == "buttonConfirm" || introduidaUna == false){
                        afegirCategoria ac = AfegirCategoria();
                        ac_buttonPressed = ac.buttonPressed;
                        String nom_categoria = ac.inputNomCategoria.getText();
                        if (ac_buttonPressed == "buttonConfirm" && !nom_categoria.equals("") && k.findCategoria(nom_categoria) != null){
                            k.afegirCategoria(nom_categoria);
                            introduidaUna = true;
                        }
                    }*/

                    //System.out.println("Introduir Pregunta: " + idPregunta + " -- " + descripcio + " -- " + text_pregunta + " -- " + idNivell);
                }

            }

            public afegirCategoria AfegirCategoria(){
                afegirCategoria frame = new afegirCategoria();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
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