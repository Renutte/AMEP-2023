import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.List;

public class K {
    private List<NivellEducatiu> listNivellEducatiu;
    private List<Professor> listProfessor;
    private List<Grup> listGrup;
    private List<Categoria> listCategoria;
    private List<Estudiant> listEstudiant;
    NivellEducatiu nivellEducatiuActiu;
    Professor professorActiu;
    Estudiant estudiantActiu;

    public K() {
        this.listNivellEducatiu = new ArrayList<>();
        this.listProfessor = new ArrayList<>();
        this.listGrup = new ArrayList<>();
        this.listCategoria = new ArrayList<>();
        this.listEstudiant = new ArrayList<>();
    }

    // ========== Introduir Pregunta
    public void introduirPregunta(int idPregunta, String descripcio, String text_pregunta, int idNivell){
        // 1.1 Find
        nivellEducatiuActiu = findNivellEducatiu(idNivell);
        // 1.2
        nivellEducatiuActiu.introduirPregunta(idPregunta, descripcio, text_pregunta);
    }
    public void afegirCategoria(String idCategoria){
        Categoria c = findCategoria(idCategoria);
        nivellEducatiuActiu.afegirCategoria(c);
    }
    public void introduirResposta(String text_resposta, Boolean correcta){
        nivellEducatiuActiu.introduirResposta(text_resposta,correcta);
    }
    public void fiIntroduirPregunta(){
        nivellEducatiuActiu.fiIntroduirPregunta();
        nivellEducatiuActiu = null;
    }


    // ========== Construir Test

    public void construirTest(int idNivell, int idProfessor){
        Professor p = findProfessor(idProfessor);
        nivellEducatiuActiu = findNivellEducatiu(idNivell);

        p.construirTest(nivellEducatiuActiu);
    }

    public void afegirPregunta(int idPregunta){
        nivellEducatiuActiu.afegirPregunta(idPregunta);
    }

    public void fiConstruirTest(){
        nivellEducatiuActiu.fiConstruirTest();
        nivellEducatiuActiu = null;
    }

    // ========== Donar Permis Test

    public void donarPermisTest(int idTest, int idProfessor){
        professorActiu = findProfessor(idProfessor);
        professorActiu.donarPermisTest(idTest);
    }
    public void afegirGrup(int idGrup){
        Grup g = findGrup(idGrup);
        professorActiu.afegirGrup(g);

    }
    public void afegirEstudiant(int idEstudiant){
        Estudiant e = findEstudiant(idEstudiant);
        professorActiu.afegirEstudiant(e);


    }
    public void fidonarPermisTest(){
        professorActiu.fiDonarPermisTest();
        professorActiu = null;
    }

    // ========== Avaluarse Test

    public void avaluarseTest(int idTest,int idEstudiant){
        estudiantActiu = findEstudiant(idEstudiant);
        estudiantActiu.avaluarseTest(idTest);
    }

    public void propostaResposta(int idPregunta,int ordinal){
        estudiantActiu.propostaResposta(idPregunta,ordinal);

    }

    public void fiAvaluarseTest(){

        estudiantActiu.fiAvaluarseTest();
        estudiantActiu = null;

    }

    // ========== NouCurs

    public void nouCurs(){
        for (Estudiant e : listEstudiant) {
            e.nouCurs();
        }
        for(Professor p : listProfessor){
            p.nouCurs();
        }
    }


    public NivellEducatiu findNivellEducatiu(int idNivell){
        for (NivellEducatiu n : listNivellEducatiu) {
            if (n.getId() == idNivell) return n;
        }
        System.out.println("No s'ha trobat el nivell");
        return null;
    }

    public Categoria findCategoria(String nom_categoria){
        for (Categoria c : listCategoria) {
            if (c.getId().equals(nom_categoria)) return c;
        }
        System.out.println("No s'ha trobat la Categoria");
        return null;
    }

    public Professor findProfessor(int idProfessor){
        for (Professor p : listProfessor) {
            if (p.getId() == idProfessor) return p;
        }
        System.out.println("No s'ha trobat el Professor");
        return null;
    }

    public Grup findGrup(int idGrup){
        for (Grup g : listGrup) {
            if (g.getId() == idGrup) return g;
        }
        System.out.println("No s'ha trobat el Grup");
        return null;
    }

    public Estudiant findEstudiant(int idEstudiant){
        for (Estudiant e : listEstudiant) {
            if (e.getId() == idEstudiant) return e;
        }
        System.out.println("No s'ha trobat el Estudiant");
        return null;
    }

    public void addCategoria(Categoria categoria){
        this.listCategoria.add(categoria);
    }

    public void addNivellEducatiu(NivellEducatiu nivellEducatiu){
        this.listNivellEducatiu.add(nivellEducatiu);
    }

    public void addProfessor(Professor professor){
        this.listProfessor.add(professor);
    }
    public void addEstudiant(Estudiant estudiant){
            this.listEstudiant.add(estudiant);
    }
    public void addGrup(Grup grup){
                this.listGrup.add(grup);
        }


    // Funció per a debug
    public void PrintInfo(){
        System.out.println("\n << === INFO Categoria === >> ");
        for (Categoria aux : this.listCategoria) aux.PrintInfo();
        System.out.println("\n << === INFO Estudiant === >> ");
        for (Estudiant aux : this.listEstudiant) aux.PrintInfo();
        System.out.println("\n << === INFO Grup === >> ");
        for (Grup aux : this.listGrup) aux.PrintInfo();
        System.out.println("\n << === INFO Professor === >> ");
        for (Professor aux : this.listProfessor) aux.PrintInfo();
        System.out.println("\n << === INFO Nivell Educatiu === >> ");
        for (NivellEducatiu aux : this.listNivellEducatiu) aux.PrintInfo();
    }

}
