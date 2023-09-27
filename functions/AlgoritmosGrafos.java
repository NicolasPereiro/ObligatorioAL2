import tads.colaPrioridad.ColaPrioridad;
import tads.colaPrioridad.MinHeap;
import tads.graph.GraphMatrix;
import tads.list.LinkedList;

public class AlgoritmosGrafos {
    public AlgoritmosGrafos() {
    }

    public static void floyd(GraphMatrix g) {
        int[][] matriz = g.adjecencyMatrix();
        int v = g.vertices();
        for (int i = 0; i < v; i++)
            matriz[i][i] = 0; // borramos la diagonal
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (matriz[i][j] > matriz[i][k] + matriz[k][j])
                        matriz[i][j] = matriz[i][k] + matriz[k][j];
                }
            }
        }
    }

    public static void dijkstra(GraphMatrix graph, int origin) { // IMPORTANTE: LA MATRIZ DE ADYACENCIA DEBE SER
                                                                 // MODIFICADA PARA SER EVALUADA MAS ABAJO
        int length = graph.vertices();
        boolean[] visitados = initVisitados(length);
        int[] costos = initCostos(length);
        int[] anterior = initAnterior(length);
        ColaPrioridad<Integer, Integer> cp = new MinHeap<>(length);
        cp.push(origin, 0);
        while (cp.size() > 0) {
            int v = cp.pop();
            visitados[v] = true;
            LinkedList<Integer>.ListIterator it = (LinkedList<Integer>.ListIterator) graph.adjacents(v);
            while (it.hasNext()) {
                int w = it.next();
                int nuevoCosto = costos[v] + graph.getEdge(v, w);
                if (!visitados[w] && costos[w] > nuevoCosto) {
                    costos[w] = nuevoCosto;
                    anterior[w] = v;
                    cp.push(w, nuevoCosto);
                }
            }
        }
    }

    private static int[] initAnterior(int length) {
        int[] anterior = new int[length];
        return anterior;
    }

    private static boolean[] initVisitados(int length) {
        boolean[] res = new boolean[length];
        for (int i = 0; i < length; i++)
            res[i] = false;
        return res;
    }

    private static int[] initCostos(int size) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++)
            res[i] = Integer.MAX_VALUE;
        return res;
    }

    public static void caminoMasCortoConNegativos(GraphMatrix g, int origin) {
        int length = g.vertices();
        int[] costo = initCostos(length);
        int[] anterior = initAnterior(length);
        ColaPrioridad<Integer, Integer> cp = new MinHeap<>(length);
        cp.push(origin, 0);
        while (cp.size() > 0) {
            int v = cp.pop();
            LinkedList<Integer>.ListIterator it = (LinkedList<Integer>.ListIterator) g.adjacents(v);
            while (it.hasNext()) {
                int w = cp.pop();
                int nuevoCosto = costo[v] + g.getEdge(v, w);
                if (costo[w] > nuevoCosto) {
                    costo[w] = nuevoCosto;
                    anterior[w] = v;
                    cp.push(w, nuevoCosto);
                }
            }
        }
    }

    public static void bellmanFord(GraphMatrix g, int origin) {
        int length = g.vertices();
        int[] costo = initCostos(length);
        int[] anterior = initAnterior(length); //arreglaar : (cantVertices,origen)
        for (int v = 1; v < length; v++) {
            if(costo[v] != Integer.MAX_VALUE){
                //TODO Terminar el algoritmo de Bellman - Ford
            }
        }
    }

}
