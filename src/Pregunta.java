import java.util.ArrayList;
import java.util.List;
public class Pregunta {
    List<Resposta> respostes;
    List<Categoria> categories;
    private String descripcio;
    private String textPregunta;
    private int aparicions;

    public Pregunta(String descripcio, String textPregunta ){
        this.descripcio = descripcio;
        this.textPregunta = textPregunta;
        this.aparicions = 0;
        this.categories = new ArrayList<>();
        this.respostes = new ArrayList<>();
    }

    public void addCategoria(Categoria categoria){
        this.categories.add(categoria);
    }
    public Categoria getFirstCategoria(){
        return this.categories.get(0);
    }
    public void addResposta(Resposta resposta){
        this.respostes.add(resposta);
    }
}
