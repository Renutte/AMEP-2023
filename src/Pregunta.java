import java.util.ArrayList;
import java.util.List;
public class Pregunta {
    /*private static int idContador = 0;*/
    private static int ordinalContador = 0;
    private int id;

    private String descripcio;
    private String textPregunta;
    private int aparicions;
    private List<Resposta> listResposta;
    private List<Categoria> listCategoria;

    private int contadorOrdinal;

    public Pregunta(int idPregunta, String descripcio, String textPregunta) {
        /*this.id = idContador++;*/
        this.id = idPregunta;
        this.descripcio = descripcio;
        this.textPregunta = textPregunta;
        this.aparicions = 0;
        this.listResposta = new ArrayList<>();
        this.listCategoria = new ArrayList<>();
        this.contadorOrdinal = 0;
    }
    public void addCategoria(Categoria categoria){
        this.listCategoria.add(categoria);
    }

    public void addResposta(Resposta resposta){
        this.listResposta.add(resposta);
    }

    public void propostaResposta(Integer ordinal, Pregunta pregunta, Avaluacio avaluacio){
        Resposta r;
        if(ordinal != null){
             r = findResposta(ordinal);
        }
        else{
             r = null;
        }

        avaluacio.propostaResposta(pregunta, r);

    }

    public void augmentarAparicions(){
        this.aparicions = this.aparicions +1;
    }

    public void createResposta(String text_resposta, Boolean correcta){
        Resposta resposta = new Resposta(text_resposta, correcta,contadorOrdinal++,this);
        this.listResposta.add(resposta);
    }

    public int getId(){
        return this.id;
    }

    public Resposta findResposta(int ordinal){
        for (Resposta r : listResposta) {
            if (r.getOrdinal() == ordinal) return r;
        }
        System.out.println("No s'ha trobat la Resposta");
        return null;
    }


    public void PrintInfo(){
        System.out.println(" === INFO Pregunta === ");
        System.out.println(this.id);
        System.out.println(this.descripcio);
        System.out.println(this.textPregunta);
        System.out.println(this.aparicions);
        for (Categoria aux : this.listCategoria) aux.PrintInfo();
        for (Resposta aux : this.listResposta) aux.PrintInfo();
    }
}
