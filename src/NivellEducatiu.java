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
}
