import java.util.ArrayList;
import java.util.List;
public class Avaluacio {
    private static int idContador = 0;
    private int id;
    private float nota;
    private int respostesCorrectes;
    private int respostesIncorrectes;
    private int respostesEnBlanc;
    private Test test;
    private List<Proposta> listProposta;

    public Avaluacio(Test test) {
        this.id = idContador++;
        this.nota = 0;
        this.respostesCorrectes = 0;
        this.respostesIncorrectes = 0;
        this.respostesEnBlanc = 0;
        this.test = test;
        this.listProposta = new ArrayList<>();
    }

    public void propostaResposta(Pregunta pregunta, Resposta resposta){
        Proposta pro = createProposta(resposta,pregunta,this);
        addProposta(pro);
        if(resposta != null){
            resposta.propostaResposta(pro);
        }
    }
    public Proposta createProposta(Resposta resposta, Pregunta pregunta, Avaluacio avaluacio){
        Proposta pro = new Proposta(resposta,pregunta,this);
        return pro;
    }
    public void addProposta(Proposta pro){
        this.listProposta.add(pro);
    }

    public void fiAvaluarseTest(Test test){
        this.nota = calcularNota();
    }

    public float calcularNota(){
        return 0;
    }


    // ========== NouCurs

    public void nouCurs(){
        for (Proposta p : listProposta) {
            p = null;
        }
        this.listProposta = new ArrayList<>();
    }

    public float getNota(){
        return this.nota;
    }

    public void PrintInfo(){
        System.out.println(" - Avaluacio ID: " + this.id);
        System.out.println(" - Avaluacio NOTA: " + this.nota);
        System.out.println(" - Avaluacio RESPOSTES CORRECTES: " + this.respostesCorrectes);
        System.out.println(" - Avaluacio RESPOSTES INCORRECTES: " + this.respostesIncorrectes);
        System.out.println(" - Avaluacio RESPOSTES EN BLANC: " + this.respostesEnBlanc);
        //this.test.PrintInfo();
        for (Proposta aux : this.listProposta) {
            System.out.println("\n - Avaluacio "+ "[" + this.id + "]" +" LLISTA DE PROPOSTES: ");
            aux.PrintInfo();
        }
    }

}
