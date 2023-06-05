import java.util.ArrayList;
import java.util.List;
public class Grup {
    private static int idContador = 0;
    private int id;

    private String curs;
    private String classe;
    private List<Test> listTest;
    private List<Estudiant> listEstudiant;

    public Grup(String curs, String classe) {
        this.id = idContador++;
        this.curs = curs;
        this.classe = classe;
        this.listTest = new ArrayList<>();
        this.listEstudiant = new ArrayList<>();
    }

    public void afegirGrup(Test test){
        listTest.add(test);
        for (Estudiant e : listEstudiant){
            e.autoritzarEstudiant(test);
        }
    }

    public void addEstudiant(Estudiant estudiant){
        this.listEstudiant.add(estudiant);
    }

    public void PrintInfo(){
        System.out.println(" === INFO Grup === ");
        System.out.println(this.id);
        System.out.println(this.curs);
        System.out.println(this.classe);
        for (Test aux : this.listTest) aux.PrintInfo();
    }
    public int getId(){
        return this.id;
    }

    public void setListEstudiant(List<Estudiant> listEstudiant){
        this.listEstudiant = listEstudiant;
    }

}
