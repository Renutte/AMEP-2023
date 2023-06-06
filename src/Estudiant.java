import java.util.ArrayList;
import java.util.List;

public class Estudiant {
    private static int idContador = 0;
    private int id;
    private List<Historial> listHistorial;
    private List<Avaluacio> listAvaluacio;
    private List<Test> listTest;
    Test testActiu;
    Historial historialActiu;
    Avaluacio avaluacioActiva;

    public Estudiant() {
        this.id = idContador++;
        this.listHistorial = new ArrayList<>();
        this.listAvaluacio = new ArrayList<>();
        this.listTest = new ArrayList<>();
    }

    public int getId(){
        return this.id;
    }

    // ========== Donar Permis Test

    public void autoritzarEstudiant(Test test){
        listTest.add(test);
    }


    // ========== Avaluarse Test
    public void avaluarseTest(int idTest){
        testActiu = findTest(idTest);
        testActiu.avaluarseTest(this);
        createAvaluacio(testActiu);
    }
    public void avaluarseTest(NivellEducatiu nivellEducatiu){
        historialActiu = findHistorial(nivellEducatiu.getId());
    }

    public void createAvaluacio(Test test){
        avaluacioActiva = new Avaluacio(test);
        if(!test.isHistoric()){
           this.listAvaluacio.add(avaluacioActiva);
        }
    }

    public void propostaResposta(int idPregunta,int ordinal){
        testActiu.propostaResposta(idPregunta,ordinal, avaluacioActiva);

    }
    public void fiAvaluarseTest(){

        testActiu.fiAvaluarseTest(historialActiu, avaluacioActiva);
        testActiu = null;
        historialActiu = null;
        avaluacioActiva = null;
    }

    // ========== NouCurs

    public void nouCurs(){
        for (Avaluacio a : listAvaluacio) {
            a.nouCurs();
            a = null;
        }
        this.listAvaluacio = new ArrayList<>();
    }


    public void PrintInfo(){
        System.out.println(" === INFO Estudiant === ");
        System.out.println(this.id);
        for (Historial aux : this.listHistorial) aux.PrintInfo();
        for (Avaluacio aux : this.listAvaluacio) aux.PrintInfo();
        for (Test aux : this.listTest) aux.PrintInfo();
    }

    public Test findTest(int idTest){
        for (Test t : listTest) {
            if (t.getId() == idTest) return t;
        }
        System.out.println("No s'ha trobat el test");
        return null;
    }
    public Historial findHistorial(int idNivell){
        for (Historial h : listHistorial) {
            if (h.getNivellEducatiuId() == idNivell) return h;
        }
        System.out.println("No s'ha trobat el historial");
        return null;
    }

    public void createHistorial(NivellEducatiu nivellEducatiu){
        Historial historial = new Historial(nivellEducatiu);
        this.listHistorial.add(historial);
    }


}
