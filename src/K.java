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

    public K() {
        this.listNivellEducatiu = new ArrayList<>();
        this.listProfessor = new ArrayList<>();
        this.listGrup = new ArrayList<>();
        this.listCategoria = new ArrayList<>();
        this.listEstudiant = new ArrayList<>();
    }
    public void feedLists() {
        listCategoria.add(new Categoria("Mates"));
        listCategoria.add(new Categoria("Fisica"));
        listCategoria.add(new Categoria("Catala"));
        for (Categoria aux : listCategoria) {
            System.out.println("Categoria: " + aux.getId());
        }

        listNivellEducatiu.add(new NivellEducatiu());
        listNivellEducatiu.add(new NivellEducatiu());
        listNivellEducatiu.add(new NivellEducatiu());
        int preguntaId = 0;
        for (NivellEducatiu aux : listNivellEducatiu) {
            System.out.println("Nivell: " + aux.getId());
            aux.introduirPregunta(preguntaId++, "DescTest", "TextPregTest");
            aux.findPregunta(preguntaId-1).addCategoria(findCategoria("Mates"));
            aux.findPregunta(preguntaId-1).addResposta(new Resposta("Correcta", true, 0, aux.findPregunta(preguntaId)));
            aux.findPregunta(preguntaId-1).addResposta(new Resposta("InCorrecta", false, 1, aux.findPregunta(preguntaId)));
        }

        listProfessor.add(new Professor());
        listProfessor.add(new Professor());
        listProfessor.add(new Professor());
        for (Professor aux : listProfessor) {
            System.out.println("Professor: " + aux.getId());
        }

        listEstudiant.add(new Estudiant());
        listEstudiant.add(new Estudiant());
        listEstudiant.add(new Estudiant());
        for (Estudiant aux : listEstudiant) {
            System.out.println("Estudiant: " + aux.getId());
        }

        listGrup.add(new Grup("Curs", "Classe"));
        listGrup.add(new Grup("Curs", "Classe"));
        listGrup.add(new Grup("Curs", "Classe"));
        for (Grup aux : listGrup) {
            if (aux.getId() == 0) aux.setListEstudiant(listEstudiant);
            System.out.println("Grup: " + aux.getId());
        }

    }

    // ========== Introduir Pregunta
    public void introduirPregunta(int idPregunta, String descripcio, String text_pregunta, int idNivell){
        // 1.1 Find
        nivellEducatiuActiu = findNivellEducatiu(idNivell);
        // 1.2
        nivellEducatiuActiu.introduirPregunta(idPregunta, descripcio, text_pregunta);
        /*System.out.println("Introduir Pregunta: " + idPregunta + " -- " + descripcio + " -- " + text_pregunta + " -- " + idNivell);*/
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
    // ==========

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

    // ==========
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

    public void PrintInfo(){
        System.out.println(" === INFO K === ");
        for (Categoria aux : this.listCategoria) aux.PrintInfo();
        for (Estudiant aux : this.listEstudiant) aux.PrintInfo();
        for (Grup aux : this.listGrup) aux.PrintInfo();
        for (Professor aux : this.listProfessor) aux.PrintInfo();
        for (NivellEducatiu aux : this.listNivellEducatiu) aux.PrintInfo();
    }

}
