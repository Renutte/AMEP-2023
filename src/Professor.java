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
    public void afegirEstudiant(Estudiant estudiant){
        estudiant.autoritzarEstudiant(testActiu);
    }
    public void fiDonarPermisTest(){
        testActiu = null;
    }

    // ========== Nou Curs

    public void nouCurs(){
        for (Test t : listTest) {
            t.testHistoric();
        }
    }

    public Test findTest(int idTest){
        for (Test t : listTest) {
            if (t.getId() == idTest) return t;
        }
        System.out.println("No s'ha trobat el test");
        return null;
    }

    public void PrintInfo(){
        System.out.println(" - Professor ID: " + this.id);
        for (Test aux : this.listTest) {
            System.out.println("\n - Professor " + "[" + this.id + "]" + " LLISTA TEST: ");
            aux.PrintInfo();
        }
    }
}
