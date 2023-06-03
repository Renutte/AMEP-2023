import java.util.ArrayList;
import java.util.List;
public class NivellEducatiu {
    private static int idContador = 0;
    private int id;

    private List<Pregunta> listPregunta;
    private List<Test> listTest;
    Pregunta preguntaActiva;

    Test testActiu;

    public NivellEducatiu() {
        this.id = idContador++;
        this.listPregunta = new ArrayList<>();
        this.listTest = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void introduirPregunta(int idPregunta, String descripcio, String text_pregunta){
        //1.2.1
        preguntaActiva = new Pregunta(idPregunta, descripcio, text_pregunta);
        listPregunta.add(preguntaActiva);
    }
    public void afegirCategoria(Categoria nom_categoria){
        preguntaActiva.addCategoria(nom_categoria);
    }
    public void introduirResposta(String text_resposta, Boolean correcta){
        preguntaActiva.createResposta(text_resposta,correcta);
    }
    public void fiIntroduirPregunta(){
        listPregunta.add(preguntaActiva);
        preguntaActiva = null;
    }

    // Construir Test
    public void addTest(Test test){
        listTest.add(test);
        testActiu = test;
    }

    public void afegirPregunta(int idPregunta){
        Pregunta pregunta = findPregunta(idPregunta);
        testActiu.addPregunta(pregunta);
        pregunta.augmentarAparicions();
    }

    public void fiConstruirTest(){
        testActiu = null;
    }
    private Pregunta findPregunta(int idPregunta){
        for (Pregunta p : listPregunta) {
            if (p.getId() == idPregunta) return p;
        }
        System.out.println("No s'ha trobat la pregunta");
        return null;
    }


    public void PrintInfo(){
        System.out.println(" === INFO NivellEducatiu === ");
        System.out.println(this.id);
        for (Pregunta aux : this.listPregunta) aux.PrintInfo();
        for (Test aux : this.listTest) aux.PrintInfo();
    }
}
