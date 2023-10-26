import java.util.Scanner;

import functions.AlgoritmosGrafos;
import objetos.Arista;
import tads.graph.GraphMatrix;
import tads.list.LinkedList;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ciudades = in.nextInt();
        int aristas = in.nextInt();
        GraphMatrix g = new GraphMatrix(ciudades, true);
        g.setAristas(aristas);
        in.nextLine();
        for(int i = 0; i < aristas; i++){
            String[] entrada = in.nextLine().split(" ");
            g.addEdge(Integer.parseInt(entrada[0]), Integer.parseInt(entrada[1]), Integer.parseInt(entrada[2]));
        }
        LinkedList<Arista> l = AlgoritmosGrafos.kruskal(g);
        int sum = 0;
        in.close();
        while(l.size() > 0){
            Arista a = l.getAt(0);
            sum += g.getEdge(a.origen, a.destino);
            l.removeAt(0);
        }
        System.out.println(sum);
    }
}
