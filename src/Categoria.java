import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private String nom_categoria;

    public Categoria(String nom_categoria)  {
        this.nom_categoria = nom_categoria;
    }

    public String getId(){
        return this.nom_categoria;
    }

    public void PrintInfo(){
        System.out.println(" - Categoria ID: " + this.nom_categoria);
    }
}
