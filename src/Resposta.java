import java.util.ArrayList;
import java.util.List;
public class Resposta {
    private static int idContador = 0;
    private int id;

    private String text_resposta;
    private Boolean correcta;
    private int ordinal;
    private Pregunta pregunta;

    private List<Proposta> listProposta;

    public Resposta(String text_resposta, Boolean correcta, int ordinal, Pregunta pregunta) {
        this.id = idContador++;
        this.text_resposta = text_resposta;
        this.correcta = correcta;
        this.ordinal = ordinal;
        this.pregunta = pregunta;
        this.listProposta = new ArrayList<>();
    }
}
