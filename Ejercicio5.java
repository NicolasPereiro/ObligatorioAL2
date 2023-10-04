import java.util.Scanner;

import tads.graph.GraphList;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[]cant = in.nextLine().split(" ");
        int vert = Integer.parseInt(cant[0]);
        GraphList g = new GraphList(vert, true);
        int cantAristas = Integer.parseInt(cant[1]);
        for(int i=0; i< cantAristas; i++){
            String[] arista = in.nextLine().split(" ");
            int v = Integer.parseInt(arista[0]);
            int w = Integer.parseInt(arista[1]);
            int costo = Integer.parseInt(arista[2]);
            g.addEdge(v, w, costo);
        }
    }
}
