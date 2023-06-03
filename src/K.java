import javax.swing.*;
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

        // 2

        //Categoria c = findCategoria(nom_categoria);

    }


    private void afegirCategoria(String nom_categoria){
        afegirCategoria frame = new afegirCategoria();
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    // ==========

    private NivellEducatiu findNivellEducatiu(int idNivell){
        for (NivellEducatiu n : listNivellEducatiu) {
            if (n.getId() == idNivell) return n;
        }
        System.out.println("No s'ha trobat el nivell");
        return null;
    }

    private Categoria findCategoria(String nom_categoria){
        for (Categoria c : listCategoria) {
            if (c.getId() == nom_categoria) return c;
        }
        System.out.println("No s'ha trobat la Categoria");
        return null;
    }

/*    List<Categoria> categories = new ArrayList<>();
    List<NivellEducatiu> nivellsEducatius = new ArrayList<>();*/
}
