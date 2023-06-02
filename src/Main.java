import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static K k = new K();
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                K k = new K();

                JFrame frame = new MainWindow(k);
                frame.setSize(500, 500);
                frame.setVisible(true);



                /*
                Categoria cat = new Categoria();
                cat.nom = "Dificil";
                k.categories.add(cat);
                System.out.println(k.categories.get(0).nom);

                NivellEducatiu niv = new NivellEducatiu();
                k.nivellsEducatius.add(niv);
                Pregunta pre = new Pregunta("Desc", "Text");
                k.nivellsEducatius.get(0).preguntes.add(pre);
                k.nivellsEducatius.get(0).preguntes.get(0).addCategoria(k.categories.get(0));
                *//*k.nivellsEducatius.get(0).preguntes.get(0).categories.add(k.categories.get(0));*//*
                System.out.println(k.nivellsEducatius.get(0).preguntes.get(0).getFirstCategoria().nom);

                cat.nom = "Normal";
                System.out.println(k.categories.get(0).nom);
                System.out.println(k.nivellsEducatius.get(0).preguntes.get(0).getFirstCategoria().nom);
                *//*System.out.println(k.nivellsEducatius.get(0).preguntes.get(0).categories.get(0).nom);*//*

                if (k.categories == null) System.out.println("Es null");*/
            }
        });
    }
}