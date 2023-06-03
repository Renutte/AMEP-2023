import java.util.ArrayList;
import java.util.List;
public class Historial {
    private static int idContador = 0;
    private int id;

    private int quantsHistorics;
    private int quantsNoHistorics;
    private float mitjana;
    private NivellEducatiu nivellEducatiu;

    public Historial(NivellEducatiu nivellEducatiu) {
        this.id = idContador++;
        this.quantsHistorics = 0;
        this.quantsNoHistorics = 0;
        this.mitjana = 0;
        this.nivellEducatiu = nivellEducatiu;
    }

    public void PrintInfo(){
        System.out.println(" === INFO Historial === ");
        System.out.println(this.id);
        System.out.println(this.quantsHistorics);
        System.out.println(this.quantsNoHistorics);
        System.out.println(this.mitjana);
        //nivellEducatiu.PrintInfo();
    }
}
