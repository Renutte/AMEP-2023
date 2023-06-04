import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static K k;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                k = new K();
                k.feedLists();

                while(true){
                    k.PrintInfo();

                    String buttonPressed = MainWindow();

                    if (buttonPressed == "buttonIntroduirPregunta") CU_IntroduirPregunta();
                    if (buttonPressed == "buttonConstruirTest") CU_ConstruirTest();
                    if (buttonPressed == "buttonDonarPermisTest") CU_DonarPermisTest();
                    if (buttonPressed == "buttonAvaluarseTest") CU_AvaluarseTest();
                    if (buttonPressed == "buttonNouCurs") CU_NouCurs();
                }

            }

            private void CU_AvaluarseTest(){

            }

            private void CU_NouCurs(){

            }

            private void CU_DonarPermisTest(){
                // DPT
                DonarPermisTest cpt = DonarPermisTest();
                k.donarPermisTest(Integer.parseInt(cpt.inputIdText.getText()), Integer.parseInt(cpt.inputIdProfessor.getText()));

                // AG
                String ac_buttonPressed = "buttonConfirm";
                while (ac_buttonPressed == "buttonConfirm"){
                    AfegirGrup ag = AfegirGrup();
                    ac_buttonPressed = ag.buttonPressed;
                    if (ac_buttonPressed == "buttonConfirm" && !ag.inputIdGrup.getText().equals("")){
                        int idGrup = Integer.parseInt(ag.inputIdGrup.getText());
                        if (k.findGrup(idGrup) != null){
                            k.afegirGrup(idGrup);
                        }
                    }
                }

                // AE
                ac_buttonPressed = "buttonConfirm";
                while (ac_buttonPressed == "buttonConfirm"){
                    AfegirEstudiant ae = AfegirEstudiant();
                    ac_buttonPressed = ae.buttonPressed;
                    if (ac_buttonPressed == "buttonConfirm" && !ae.inputIdEstudiant.getText().equals("")){
                        int idEstudiant = Integer.parseInt(ae.inputIdEstudiant.getText());
                        if (k.findEstudiant(idEstudiant) != null){
                            k.afegirEstudiant(idEstudiant);
                        }
                    }
                }

                // FDPT
                k.fidonarPermisTest();
            }

            private void CU_ConstruirTest(){
                // CT
                ConstruirTest ct = ConstruirTest();
                // Es null?
                Professor pro = k.findProfessor(Integer.parseInt(ct.inputIdProfessor.getText()));
                NivellEducatiu n = k.findNivellEducatiu(Integer.parseInt(ct.inputIdNivell.getText()));
                //
                k.construirTest(Integer.parseInt(ct.inputIdNivell.getText()), Integer.parseInt(ct.inputIdProfessor.getText()));

                // AP
                String ac_buttonPressed = "buttonConfirm";
                boolean introduidaUna = false;
                while (ac_buttonPressed == "buttonConfirm" || introduidaUna == false){
                    AfegirPregunta ap = AfegirPregunta();
                    ac_buttonPressed = ap.buttonPressed;
                    if (ac_buttonPressed == "buttonConfirm" && !ap.inputIdPregunta.getText().equals("")){
                        int idPregunta = Integer.parseInt(ap.inputIdPregunta.getText());
                        if (k.nivellEducatiuActiu.findPregunta(idPregunta) != null){
                            k.afegirPregunta(idPregunta);
                            introduidaUna = true;
                        }
                    }
                }

                // FCT
                k.fiConstruirTest();
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

            }



            public PropostaResposta PropostaResposta(){
                PropostaResposta frame = new PropostaResposta();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
            }

            public AvaluarseTest AvaluarseTest(){
                AvaluarseTest frame = new AvaluarseTest();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
            }

            public AfegirEstudiant AfegirEstudiant(){
                AfegirEstudiant frame = new AfegirEstudiant();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
            }

            public AfegirGrup AfegirGrup(){
                AfegirGrup frame = new AfegirGrup();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
            }

            public DonarPermisTest DonarPermisTest(){
                DonarPermisTest frame = new DonarPermisTest();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
            }

            public AfegirPregunta AfegirPregunta(){
                AfegirPregunta frame = new AfegirPregunta();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
            }

            public ConstruirTest ConstruirTest(){
                ConstruirTest frame = new ConstruirTest();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
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