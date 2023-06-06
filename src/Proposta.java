import java.util.List;

public class Proposta {
    private static int idContador = 0;
    private int id;

    private Resposta resposta;
    private Pregunta pregunta;
    private Avaluacio avaluacio;

    public Proposta(Resposta resposta, Pregunta pregunta, Avaluacio avaluacio) {
        this.id = idContador++;
        this.resposta = resposta;
        this.pregunta = pregunta;
        this.avaluacio = avaluacio;
    }

    public void PrintInfo(){
        System.out.println(" - Proposta ID: " + this.id);
        //this.resposta.PrintInfo();
        //this.pregunta.PrintInfo();
        //this.avaluacio.PrintInfo();
    }
}
