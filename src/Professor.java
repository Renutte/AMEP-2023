import java.util.ArrayList;
import java.util.List;
public class Professor {
    private static int idContador = 0;
    private int id;

    private List<Test> listTest;

    public Professor() {
        this.id = idContador++;
        this.listTest = new ArrayList<>();
    }
}
