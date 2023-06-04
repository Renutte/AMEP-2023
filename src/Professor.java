import java.util.ArrayList;
import java.util.List;
public class Professor {
    private static int idContador = 0;
    private int id;
    Test testActiu;

    private List<Test> listTest;

    public Professor() {
        this.id = idContador++;
        this.listTest = new ArrayList<>();
    }

    public int getId(){
        return this.id;
    }

    // ========== Construir Test
    public void construirTest(NivellEducatiu nivellEducatiu){
        Test test = new Test(this,nivellEducatiu);
        listTest.add(test);
        nivellEducatiu.addTest(test);
    }

    // ========== Donar Permis Test
    public void donarPermisTest(int idTest){
        testActiu = findTest(idTest);
    }
    public void afegirGrup(Grup grup){
        grup.afegirGrup(testActiu);
    }

    public Test findTest(int idTest){
        for (Test t : listTest) {
            if (t.getId() == idTest) return t;
        }
        System.out.println("No s'ha trobat el test");
        return null;
    }

    public void PrintInfo(){
        System.out.println(" === INFO Professor === ");
        System.out.println(this.id);
        for (Test aux : this.listTest) aux.PrintInfo();
    }
}
