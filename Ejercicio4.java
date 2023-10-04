import java.util.Scanner;

import tads.graph.GraphList;
import tads.hash.Hash;
import tads.hash.StringHash;
import tads.table.THC;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] platos = in.nextLine().split(" ");
        int cantPlatos = Integer.parseInt(platos[0]);
        int cantPedidos = Integer.parseInt(platos[1]);
        Hash<String> hashFunc = new StringHash();
        THC<String, Integer> t = new THC<String, Integer>(hashFunc, cantPlatos);
        GraphList g = new GraphList(cantPlatos, true);
        for (int i = 0; i < cantPlatos; i++) {
            String platito = in.nextLine();
            t.add(platito, i + 1);
            g.vertices[i + 1] = platito;
        }
        for (int j = 0; j < cantPedidos; j++) {
            String[] arr = in.nextLine().split(" ");
            int v = t.get(arr[0]);
            int w = t.get(arr[1]);
            g.addEdge(v, w);
        }
        AlgoritmosGrafos.topoSort(g, t, cantPedidos);
        in.close();
    }

}
