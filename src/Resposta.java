import java.util.ArrayList;
import java.util.List;
public class Resposta {
    private static int idContador = 0;
    private int id;

    private String text_resposta;
    private Boolean correcta;
    private Integer ordinal;
    private Pregunta pregunta;

    private List<Proposta> listProposta;

    public Resposta(String text_resposta, Boolean correcta, Integer ordinal, Pregunta pregunta) {
        this.id = idContador++;
        this.text_resposta = text_resposta;
        this.correcta = correcta;
        this.ordinal = ordinal;
        this.pregunta = pregunta;
        this.listProposta = new ArrayList<>();
    }

    public void propostaResposta(Proposta proposta){
        this.listProposta.add(proposta);
    }
    public int getOrdinal(){
        return this.ordinal;
    }

    public Boolean getCorrecta(){
        return this.correcta;
    }




    public void PrintInfo(){
        System.out.println(" === INFO Resposta === ");
        System.out.println(this.id);
        System.out.println(this.text_resposta);
        System.out.println(this.correcta);
        System.out.println(this.ordinal);
        //this.pregunta.PrintInfo();
        for (Proposta aux : this.listProposta) aux.PrintInfo();
    }
}
