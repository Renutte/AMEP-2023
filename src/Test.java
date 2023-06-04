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

    public void PrintInfo(){
        System.out.println(" === INFO Test === ");
        System.out.println(this.id);
        System.out.println(this.resolucions);
        System.out.println(this.historic);
        //this.professor.PrintInfo();
        //this.nivellEducatiu.PrintInfo();
        for (Pregunta aux : this.listPregunta) aux.PrintInfo();
    }
    public int getId(){
        return this.id;
    }
}
