//Aclaracion sobre pruebas: En los casos de prueba distintos a 50.in.txt los txt tienen una una linea de mas vacia,
 //en el 50in.txt esta no existe

import java.util.Scanner;
import functions.AlgoritmosGrafos;
import tads.graph.GraphMatrix;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[]cant = in.nextLine().split(" ");
        int vert = Integer.parseInt(cant[0]);
        GraphMatrix g = new GraphMatrix(vert, true);
        int cantAristas = Integer.parseInt(cant[1]);
        for(int i=0; i< cantAristas; i++){
            String[] arista = in.nextLine().split(" ");
            int v = Integer.parseInt(arista[0]);
            int w = Integer.parseInt(arista[1]);
            int costo = Integer.parseInt(arista[2]);
            g.addEdge(v, w, costo);
        }
        String[] camino = in.nextLine().split(" ");
        int origen = Integer.parseInt(camino[0]);
        int[] costos = AlgoritmosGrafos.dijkstra(g, origen);
        if(costos[Integer.parseInt(camino[1])] == Integer.MAX_VALUE){
            System.out.print(-1);
        } else {
            System.out.print(costos[Integer.parseInt(camino[1])]);
        }
        in.close();
    }
}
