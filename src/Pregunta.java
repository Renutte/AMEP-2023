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
    private Resposta respostaActiva;

    public Pregunta(int idPregunta, String descripcio, String textPregunta) {
        /*this.id = idContador++;*/
        this.id = idPregunta;
        this.descripcio = descripcio;
        this.textPregunta = textPregunta;
        this.aparicions = 0;
        this.listResposta = new ArrayList<>();
        this.listCategoria = new ArrayList<>();
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

        if( (correcta == true && !findRespostaCorrecta()) || correcta == false){
            Resposta resposta;
            if (respostaActiva == null) resposta = new Resposta(text_resposta, correcta, 0,this);
            else resposta = new Resposta(text_resposta, correcta, respostaActiva.getOrdinal()+1,this);
            respostaActiva = resposta;
            this.listResposta.add(resposta);
        }
    }
    public void fiIntroduirPregunta(){
        respostaActiva = null;
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

    public Boolean findRespostaCorrecta(){
        for (Resposta r : listResposta) {
            if (r.getCorrecta() == true) return true;
        }
        return false;
    }


    public void PrintInfo(){
        System.out.println(" - Pregunta ID: " + this.id);
        System.out.println(" - Pregunta DESCRIPCIO: " + this.descripcio);
        System.out.println(" - Pregunta TEXT PREGUNTA: " + this.textPregunta);
        System.out.println(" - Pregunta APARICIONS: " + this.aparicions);
        for (Categoria aux : this.listCategoria) {
            System.out.println("\n - Pregunta "+ "[" + this.id + "]" +" LLISTA CATEGORIA: ");
            aux.PrintInfo();
        }
        for (Resposta aux : this.listResposta) {
            System.out.println("\n - Pregunta "+ "[" + this.id + "]" +" LLISTA RESPOSTA: ");
            aux.PrintInfo();
        }
    }
}
