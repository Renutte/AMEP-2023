import java.util.ArrayList;
import java.util.List;
public class NivellEducatiu {
    private static int idContador = 0;
    private int id;

    private List<Pregunta> listPregunta;
    private List<Test> listTest;
    Pregunta preguntaActiva;

    public NivellEducatiu() {
        this.id = idContador++;
        this.listPregunta = new ArrayList<>();
        this.listTest = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void introduirPregunta(int idPregunta, String descripcio, String text_pregunta){
        //1.2.1
        preguntaActiva = new Pregunta(idPregunta, descripcio, text_pregunta);
        listPregunta.add(preguntaActiva);
    }
    public void afegirCategoria(Categoria nom_categoria){
        preguntaActiva.addCategoria(nom_categoria);
    }
    public void introduirResposta(String text_resposta, Boolean correcta, int ordinal){
        Resposta resposta = new Resposta(text_resposta, correcta, ordinal, preguntaActiva);
        preguntaActiva.addResposta(resposta);
    }
    public void fiIntroduirPregunta(){
        listPregunta.add(preguntaActiva);
        preguntaActiva = null;
    }
}
