import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static K k;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            // ===============================================
            // ====================== Main ===================
            // ===============================================
            @Override
            public void run() {
                k = new K();
                afegirDadesPerTestejar();
                while(true){
                    String buttonPressed = MainWindow();
                    if (buttonPressed == "buttonIntroduirPregunta") CU_IntroduirPregunta();
                    if (buttonPressed == "buttonConstruirTest") CU_ConstruirTest();
                    if (buttonPressed == "buttonDonarPermisTest") CU_DonarPermisTest();
                    if (buttonPressed == "buttonAvaluarseTest") CU_AvaluarseTest();
                    if (buttonPressed == "buttonNouCurs") CU_NouCurs();
                    if (buttonPressed == "consultarDadesButton") MostrarDades();
                }

            }


            // ===============================================
            // ================= Casos d'us ==================
            // ===============================================

            private void CU_AvaluarseTest(){
                // AT
                Boolean realizado = false;
                while(!realizado) {
                    AvaluarseTest av = AvaluarseTest();
                    k.avaluarseTest(Integer.parseInt(av.inputIdTest.getText()), Integer.parseInt(av.inputIdEstudiant.getText()));
                    realizado = true;
                }
                // PR
                String ac_buttonPressed = "buttonConfirm";
                while (ac_buttonPressed == "buttonConfirm"){
                    PropostaResposta pr = PropostaResposta();
                    ac_buttonPressed = pr.buttonPressed;
                    if (ac_buttonPressed == "buttonConfirm" && !pr.inputIdPregunta.getText().equals("") && !pr.inputOrdinal.getText().equals("")){
                        k.propostaResposta(Integer.parseInt(pr.inputIdPregunta.getText()), Integer.parseInt(pr.inputOrdinal.getText()));
                    }
                }
                // FAT
                try{
                    k.fiAvaluarseTest();
                }catch (Exception e) {
                    MessageBox("No s'ha pogut avaluar el test");
                }
            }

            private void CU_NouCurs(){
                try{
                    k.nouCurs();
                }catch (Exception e) {
                    MessageBox("No s'ha pogut iniciar un nou curs");
                }
            }

            private void CU_DonarPermisTest(){
                // DPT
                Boolean realizado = false;
                while(!realizado) {
                    DonarPermisTest cpt = DonarPermisTest();
                    k.donarPermisTest(Integer.parseInt(cpt.inputIdText.getText()), Integer.parseInt(cpt.inputIdProfessor.getText()));
                    realizado = true;
                }
                // AGOE
                String agoe_buttonPressed = "";
                while (agoe_buttonPressed != "confirmarButton") {
                    AfegirGrupOEstudiant afegirGrupOEstudiant = AfegirGrupOEstudiant();
                    agoe_buttonPressed = afegirGrupOEstudiant.buttonPressed;
                    if (agoe_buttonPressed == "afegirGrupButton"){
                        // AG
                        String ac_buttonPressed = "buttonConfirm";
                        while (ac_buttonPressed == "buttonConfirm") {
                            AfegirGrup ag = AfegirGrup();
                            ac_buttonPressed = ag.buttonPressed;
                            if (ac_buttonPressed == "buttonConfirm" && !ag.inputIdGrup.getText().equals("")) {
                                int idGrup = Integer.parseInt(ag.inputIdGrup.getText());
                                if (k.findGrup(idGrup) != null) {
                                    k.afegirGrup(idGrup);
                                }
                            }
                        }
                    }
                    if (agoe_buttonPressed == "afegirEstudiantButton"){
                        // AE
                        String ac_buttonPressed = "buttonConfirm";
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
                    }
                }

                // FDPT
                try{
                    k.fidonarPermisTest();
                }catch (Exception e) {
                    MessageBox("No s'ha pogut crear els permissos");
                }
            }

            private void CU_ConstruirTest(){
                // CT
                Boolean realizado = false;
                while(!realizado) {
                    try {
                        ConstruirTest ct = ConstruirTest();
                        Professor pro = k.findProfessor(Integer.parseInt(ct.inputIdProfessor.getText()));
                        NivellEducatiu n = k.findNivellEducatiu(Integer.parseInt(ct.inputIdNivell.getText()));
                        k.construirTest(Integer.parseInt(ct.inputIdNivell.getText()), Integer.parseInt(ct.inputIdProfessor.getText()));
                        realizado = true;
                    } catch (Exception e) {
                        MessageBox("No s'ha pogut construir el test");
                    }
                }
                // AP
                String ac_buttonPressed = "buttonConfirm";
                boolean introduidaUna = false;
                try{
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
                }catch (Exception e) {
                    MessageBox("No s'ha pogut afegir la pregunta");
                }
                // FCT
                try{
                    k.fiConstruirTest();
                }catch (Exception e) {
                    MessageBox("No s'ha crear el test");
                }
            }

            private void CU_IntroduirPregunta(){
                // IP
                Boolean realizado = false;
                while(!realizado){
                    try{
                        IntroduirPregunta ip = IntroduirPregunta();
                        int idPregunta = Integer.parseInt(ip.inputIdPregunta.getText());
                        String descripcio = ip.inputDescripcio.getText();
                        String text_pregunta = ip.inputText_pregunta.getText();
                        int idNivell = Integer.parseInt(ip.inputIdNivell.getText());
                        k.introduirPregunta(idPregunta, descripcio, text_pregunta, idNivell);
                        realizado = true;
                    }catch (Exception e){
                        MessageBox("No s'ha pogut crear la pregunta");
                    }
                }
                // AC
                boolean introduidaUna = false;
                String ac_buttonPressed = "buttonConfirm";
                while (ac_buttonPressed == "buttonConfirm" || introduidaUna == false){
                    try{
                        afegirCategoria ac = AfegirCategoria();
                        ac_buttonPressed = ac.buttonPressed;
                        String nom_categoria = ac.inputNomCategoria.getText();
                        if (ac_buttonPressed == "buttonConfirm" && !nom_categoria.equals("")){
                            if(k.findCategoria(nom_categoria) == null) throw new Exception("Categoria Null");
                            k.afegirCategoria(nom_categoria);
                            introduidaUna = true;
                        }
                    }catch (Exception e){
                        MessageBox("No s'ha pogut afegir la categoria");
                    }
                }
                // IR
                boolean introduidaCorrecta = false;
                String ir_buttonPressed = "buttonConfirm";
                while (ir_buttonPressed == "buttonConfirm" || introduidaCorrecta == false){
                    try{
                        IntroduirResposta ir = IntroduirResposta();
                        ir_buttonPressed = ir.buttonPressed;
                        // No permet introduir mes d'una correctaº
                        if (!(introduidaCorrecta == true && ir.inputCorrecta.isSelected())){
                            if (ir_buttonPressed == "buttonConfirm") {
                                k.introduirResposta(ir.inputText_Resposta.getText(), ir.inputCorrecta.isSelected());
                                if (ir.inputCorrecta.isSelected()) introduidaCorrecta = true;
                            } else if (introduidaCorrecta == false) ir_buttonPressed = "buttonConfirm";
                        } else throw new Exception("Duplicitat de resposta correcta");
                    }catch (Exception e) {
                        MessageBox("No s'ha pogut introduir la resposta");
                    }
                }
                // FIP
                try{
                    k.fiIntroduirPregunta();
                }catch (Exception e) {
                    MessageBox("No s'ha crear la pregunta");
                }
            }



            // ===============================================
            // ==== Funcions per testejar el funcionament ====
            // ===============================================

            private void MostrarDades(){
                ConsultarDades ConsultarDades = ConsultarDades();


            }

            private void afegirDadesPerTestejar(){

                // CATEGORIES
                Categoria c1 = new Categoria("Mates");
                Categoria c2 = new Categoria("Fisica");
                Categoria c3 = new Categoria("Catala");

                k.addCategoria(c1);
                k.addCategoria(c2);
                k.addCategoria(c3);

                // NIVELLS
                NivellEducatiu n1 = new NivellEducatiu();
                NivellEducatiu n2 = new NivellEducatiu();
                NivellEducatiu n3 = new NivellEducatiu();

                k.addNivellEducatiu(n1);
                k.addNivellEducatiu(n2);
                k.addNivellEducatiu(n3);

                //PREGUNTES
                k.introduirPregunta(0,"A","A",0);
                k.afegirCategoria("Mates");
                k.introduirResposta("a",true);
                k.introduirResposta("b",false);
                k.fiIntroduirPregunta();

                k.introduirPregunta(1,"A","A",0);
                k.afegirCategoria("Fisica");
                k.introduirResposta("c",true);
                k.introduirResposta("d",false);
                k.fiIntroduirPregunta();

                k.introduirPregunta(2,"A","A",1);
                k.afegirCategoria("Mates");
                k.introduirResposta("e",false);
                k.introduirResposta("f",true);
                k.fiIntroduirPregunta();

                k.introduirPregunta(3,"A","A",1);
                k.afegirCategoria("Catala");
                k.introduirResposta("g",true);
                k.introduirResposta("h",false);
                k.fiIntroduirPregunta();

                k.introduirPregunta(4,"A","A",2);
                k.afegirCategoria("Catala");
                k.introduirResposta("i",true);
                k.introduirResposta("j",false);
                k.fiIntroduirPregunta();

                //PROFESSORS
                Professor p1 = new Professor();
                Professor p2 = new Professor();
                k.addProfessor(p1);
                k.addProfessor(p2);

                //ESTUDIANTS
                Estudiant e1 = new Estudiant();
                Estudiant e2 = new Estudiant();
                Estudiant e3 = new Estudiant();
                k.addEstudiant(e1);
                k.addEstudiant(e2);
                k.addEstudiant(e3);

                //GRUPS
                Grup g1 = new Grup("2n","A");
                Grup g2 = new Grup("3r","B");
                Grup g3 = new Grup("4t","C");
                k.addGrup(g1);
                k.addGrup(g2);
                k.addGrup(g3);

                g1.addEstudiant(e1);
                g1.addEstudiant(e2);

                g2.addEstudiant(e2);
                g2.addEstudiant(e3);

                g3.addEstudiant(e3);
                g3.addEstudiant(e1);

                //TESTS

                //No Historic
                k.construirTest(0,0 );
                k.afegirPregunta(0);
                k.afegirPregunta(1);
                k.fiConstruirTest();

                //Historic
                k.construirTest(1,1 );
                k.afegirPregunta(2);
                k.afegirPregunta(3);
                k.fiConstruirTest();

                //PERMISOS AL TEST
                k.donarPermisTest(0,0);
                k.afegirGrup(0);
                k.afegirEstudiant(0);
                k.afegirEstudiant(1);

                //HISTORIALS
                e1.createHistorial(n1);
                e1.createHistorial(n2);
                e1.createHistorial(n3);
                e2.createHistorial(n1);
                e2.createHistorial(n2);
                e2.createHistorial(n3);
                e3.createHistorial(n1);
                e3.createHistorial(n2);
                e3.createHistorial(n3);
            }

            // ===============================================
            // ================== Finestres ==================
            // ===============================================

            public ConsultarDades ConsultarDades(){
                ConsultarDades frame = new ConsultarDades(k);
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
            }

            public AfegirGrupOEstudiant AfegirGrupOEstudiant(){
                AfegirGrupOEstudiant frame = new AfegirGrupOEstudiant();
                frame.setSize(500, 500);
                frame.setVisible(true);
                return frame;
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

            public void MessageBox(String msgText){
                MessageBox frame = new MessageBox(msgText);
                frame.setSize(500, 500);
                frame.setVisible(true);
            }

        });
    }
}