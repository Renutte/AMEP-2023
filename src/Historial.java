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

    public void fiAvaluarseTest(Test test, Avaluacio avaluacio){
        if(!test.isHistoric()){
            this.mitjana = (this.mitjana*this.quantsNoHistorics+avaluacio.getNota())/(this.quantsNoHistorics +1);
            this.quantsNoHistorics = this.quantsNoHistorics +1;
        }
        else{
            this.quantsHistorics = this.quantsHistorics +1;
        }
        avaluacio.fiAvaluarseTest(
                test);
    }

    public int getNivellEducatiuId(){
        return this.nivellEducatiu.getId();
    }

    public void PrintInfo(){
        System.out.println(" - Historial ID: " + this.id);
        System.out.println(" - Historial QUANTS HISTORIS: " + this.quantsHistorics);
        System.out.println(" - Historial QUANTS NO HISTORICS: " + this.quantsNoHistorics);
        System.out.println(" - Historial MITJANA: " + this.mitjana);
        //nivellEducatiu.PrintInfo();
    }
}
