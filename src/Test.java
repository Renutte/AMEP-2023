import java.util.ArrayList;
import java.util.List;
public class Test {
    private static int idContador = 0;
    private int id;

    private int resolucions;
    private Boolean historic;
    private Professor professor;
    private NivellEducatiu nivellEducatiu;

    private List<Pregunta> listPregunta;

    public Test(Professor professor, NivellEducatiu nivellEducatiu) {
        this.id = idContador++;
        this.resolucions = 0;
        this.historic = false;
        this.professor = professor;
        this.nivellEducatiu = nivellEducatiu;
        this.listPregunta = new ArrayList<>();
    }

    public void addPregunta(Pregunta pregunta){
        this.listPregunta.add(pregunta);

    }
}
