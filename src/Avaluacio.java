import java.util.ArrayList;
import java.util.List;
public class Avaluacio {
    private static int idContador = 0;
    private int id;
    private float nota;
    private int respostesCorrectes;
    private int respostesIncorrectes;
    private int respostesEnBlanc;
    private Test test;
    private List<Proposta> listProposta;

    public Avaluacio(Test test) {
        this.id = idContador++;
        this.nota = 0;
        this.respostesCorrectes = 0;
        this.respostesIncorrectes = 0;
        this.respostesEnBlanc = 0;
        this.test = test;
        this.listProposta = new ArrayList<>();
    }



}
