import java.util.ArrayList;
import java.util.List;

public class K {
    private List<NivellEducatiu> listNivellEducatiu;
    private List<Professor> listProfessor;
    private List<Grup> listGrup;
    private List<Categoria> listCategoria;
    private List<Estudiant> listEstudiant;

    public void introduirPregunta(int idPregunta, String descripcio, String text_pregunta, int idNivell){
        // 1.1 Find
        NivellEducatiu n = findNivellEducatiu(idNivell);
        // 1.2

    }

    private NivellEducatiu findNivellEducatiu(int idNivell){
        for (NivellEducatiu n : listNivellEducatiu) {
            if (n.getId() == idNivell) return n;
        }
        return null;
    }

/*    List<Categoria> categories = new ArrayList<>();
    List<NivellEducatiu> nivellsEducatius = new ArrayList<>();*/
}
