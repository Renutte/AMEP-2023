import javax.swing.plaf.synth.Region;
import java.util.ArrayList;
import java.util.List;

public class K {
    private List<NivellEducatiu> listNivellEducatiu;
    private List<Professor> listProfessor;
    private List<Grup> listGrup;
    private List<Categoria> listCategoria;
    private List<Estudiant> listEstudiant;

    public K() {
        this.listNivellEducatiu = new ArrayList<>();
        this.listProfessor = new ArrayList<>();
        this.listGrup = new ArrayList<>();
        this.listCategoria = new ArrayList<>();
        this.listEstudiant = new ArrayList<>();
        feedLists();
    }

    private void feedLists() {
        NivellEducatiu n = new NivellEducatiu();
        listNivellEducatiu.add(n);
    }

    // ========== Esdeveniments del sistema
    public void introduirPregunta(int idPregunta, String descripcio, String text_pregunta, int idNivell){
        // 1.1 Find
        NivellEducatiu n = findNivellEducatiu(idNivell);
        // 1.2
        n.introduirPregunta(idPregunta, descripcio, text_pregunta);
        //
        System.out.println("Introduir Pregunta");
    }




    // ==========

    private NivellEducatiu findNivellEducatiu(int idNivell){
        for (NivellEducatiu n : listNivellEducatiu) {
            if (n.getId() == idNivell) return n;
        }
        return null;
    }

/*    List<Categoria> categories = new ArrayList<>();
    List<NivellEducatiu> nivellsEducatius = new ArrayList<>();*/
}
