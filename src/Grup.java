import java.util.ArrayList;
import java.util.List;
public class Grup {
    private static int idContador = 0;
    private int id;

    private String curs;
    private String classe;
    private List<Test> listTest;

    public Grup(String curs, String classe) {
        this.id = idContador++;
        this.curs = curs;
        this.classe = classe;
        this.listTest = new ArrayList<>();
    }
}
