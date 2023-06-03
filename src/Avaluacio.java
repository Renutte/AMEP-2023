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

    public void PrintInfo(){
        System.out.println(" === INFO Avaluacio === ");
        System.out.println(this.id);
        System.out.println(this.nota);
        System.out.println(this.respostesCorrectes);
        System.out.println(this.respostesIncorrectes);
        System.out.println(this.respostesEnBlanc);
        //this.test.PrintInfo();
        for (Proposta aux : this.listProposta) {
            aux.PrintInfo();
        }
    }

}
