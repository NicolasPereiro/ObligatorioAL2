import java.util.Scanner;

import objetos.Arista;
import tads.graph.GraphMatrix;
import tads.list.LinkedList;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.close();
        GraphMatrix g = new GraphMatrix(0, false);
        LinkedList<Arista> l = AlgoritmosGrafos.kruskal(null);
        int sum = 0;
        while(l.size() > 0){
            Arista a = l.getAt(0);
            sum += g.getEdge(a.origen, a.destino);
            l.removeAt(0);
        }
        System.out.println(sum);
    }
}
