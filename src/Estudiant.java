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
}
