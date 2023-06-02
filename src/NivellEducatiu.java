import java.util.ArrayList;
import java.util.List;
public class NivellEducatiu {
    private static int idContador = 0;
    private int id;

    private List<Pregunta> listPregunta;
    private List<Test> listTest;

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
        Pregunta p = createPregunta(idPregunta, descripcio, text_pregunta);
        // 1.2.2
        listPregunta.add(p);
    }

    public Pregunta createPregunta(int idPregunta, String descripcio, String text_pregunta){
        // 1.2.1.1 i 1.2.1.2
        return new Pregunta(idPregunta, descripcio, text_pregunta);
    }
}
