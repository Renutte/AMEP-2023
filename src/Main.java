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

                if (buttonPressed == "buttonIntroduirPregunta") CU_IntroduirPregunta();
                if (buttonPressed == "buttonConstruirTest") CU_ConstruirTest();
                if (buttonPressed == "buttonDonarPermisTest") CU_IntroduirPregunta();
                if (buttonPressed == "buttonAvaluarseTest") CU_IntroduirPregunta();
                if (buttonPressed == "buttonNouCurs") CU_IntroduirPregunta();

            }

            private void CU_ConstruirTest(){

            }

            private void CU_IntroduirPregunta(){
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
                String ir_buttonPressed = "buttonConfirm";
                boolean introduidaCorrecta = false;
                while (ir_buttonPressed == "buttonConfirm"){
                    IntroduirResposta ir = IntroduirResposta();
                    ir_buttonPressed = ir.buttonPressed;
                    // No permet introduir mes d'una correcta
                    if (!(introduidaCorrecta == true && ir.inputCorrecta.isSelected())){
                        if (ir_buttonPressed == "buttonConfirm"){
                            k.introduirResposta(ir.inputText_Resposta.getText(), ir.inputCorrecta.isSelected());
                            introduidaCorrecta = true;
                        }else{
                            if (introduidaCorrecta == false) ir_buttonPressed = "buttonConfirm";
                        }
                        if (ir.inputCorrecta.isSelected()) {
                            introduidaCorrecta = true;
                        }
                    }
                }
                // FIP
                k.fiIntroduirPregunta();
                k.PrintInfo();
            }

            public IntroduirResposta IntroduirResposta(){
                IntroduirResposta frame = new IntroduirResposta();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
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