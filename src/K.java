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

    public K() {
        this.listNivellEducatiu = new ArrayList<>();
        this.listProfessor = new ArrayList<>();
        this.listGrup = new ArrayList<>();
        this.listCategoria = new ArrayList<>();
        this.listEstudiant = new ArrayList<>();
    }
    public void feedLists() {
        listNivellEducatiu.add(new NivellEducatiu());
        listNivellEducatiu.add(new NivellEducatiu());
        listNivellEducatiu.add(new NivellEducatiu());
        for (NivellEducatiu aux : listNivellEducatiu) {
            System.out.println("Nivell: " + aux.getId());
        }

        listCategoria.add(new Categoria("Mates"));
        listCategoria.add(new Categoria("Fisica"));
        listCategoria.add(new Categoria("Catala"));
        for (Categoria aux : listCategoria) {
            System.out.println("Categoria: " + aux.getId());
        }
    }

    // ========== Introduir Pregunta
    public void introduirPregunta(int idPregunta, String descripcio, String text_pregunta, int idNivell){
        // 1.1 Find
        nivellEducatiuActiu = findNivellEducatiu(idNivell);
        // 1.2
        nivellEducatiuActiu.introduirPregunta(idPregunta, descripcio, text_pregunta);
        System.out.println("Introduir Pregunta: " + idPregunta + " -- " + descripcio + " -- " + text_pregunta + " -- " + idNivell);
    }
    public void afegirCategoria(String idCategoria){
        Categoria c = findCategoria(idCategoria);
        nivellEducatiuActiu.afegirCategoria(c);
    }
    public void introduirResposta(String text_resposta, Boolean correcta, int ordinal){
        nivellEducatiuActiu.introduirResposta(text_resposta,correcta);
    }
    public void fiIntroduirPregunta(){
        nivellEducatiuActiu.fiIntroduirPregunta();
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

    }
    // ==========

    private NivellEducatiu findNivellEducatiu(int idNivell){
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

    private Professor findProfessor(int idProfessor){
        for (Professor p : listProfessor) {
            if (p.getId() == idProfessor) return p;
        }
        System.out.println("No s'ha trobat el Professor");
        return null;
    }


}
