import java.util.ArrayList;
import java.util.List;

public class Estudiant {
    private static int idContador = 0;
    private int id;
    private List<Historial> listHistorial;
    private List<Avaluacio> listAvaluacio;
    private List<Test> listTest;

    public Estudiant() {
        this.id = idContador++;
        this.listHistorial = new ArrayList<>();
        this.listAvaluacio = new ArrayList<>();
        this.listTest = new ArrayList<>();
    }

    public void autoritzarEstudiant(Test test){
        listTest.add(test);
    }

    public void PrintInfo(){
        System.out.println(" === INFO Estudiant === ");
        System.out.println(this.id);
        for (Historial aux : this.listHistorial) aux.PrintInfo();
        for (Avaluacio aux : this.listAvaluacio) aux.PrintInfo();
        for (Test aux : this.listTest) aux.PrintInfo();
    }
}
