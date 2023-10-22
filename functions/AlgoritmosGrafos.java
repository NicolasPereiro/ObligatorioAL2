package functions;

import java.util.Iterator;

import objetos.Arista;
import objetos.Bomba;
import objetos.Printer;
import tads.colaPrioridad.Cola;
import tads.colaPrioridad.ColaPrioridad;
import tads.colaPrioridad.MaxHeap;
import tads.colaPrioridad.MinHeap;
import tads.graph.Graph;
import tads.graph.GraphList;
import tads.graph.GraphMatrix;
import tads.list.LinkedList;
import tads.set.DJSet;
import tads.table.THC;

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

    public static int[] dijkstra(GraphMatrix graph, int origin) { // IMPORTANTE: LA MATRIZ DE ADYACENCIA DEBE SER
                                                                 // MODIFICADA PARA SER EVALUADA MAS ABAJO
        int length = graph.vertices();
        boolean[] visitados = initVisitados(length);
        int[] costos = initCostos(length);
        costos[origin]=0;
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
        return costos;
    }

    private static int[] initAnterior(int length) {
        int[] anterior = new int[length+1];
        return anterior;
    }

    private static boolean[] initVisitados(int length) {
        boolean[] res = new boolean[length+1];
        for (int i = 0; i < length+1; i++)
            res[i] = false;
        return res;
    }

    private static int[] initCostos(int size) {
        int[] res = new int[size+1];
        for (int i = 0; i < size+1; i++)
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

    public static void topoSort(GraphList g, THC<String,Integer> table, int cantPedidos){
        int[] gradoEntrada = g.gradosEntrada;
        ColaPrioridad<String, String> cp = new MinHeap<>(g.vertices());
        Object[] vertice = g.vertices;
        int cont = 1;
        Printer p = new Printer();
        for(int v = 1; v <= g.vertices(); v++){
            if(gradoEntrada[v] == 0){
                cp.push((String)vertice[v], (String)vertice[v]);
            }
        }
        while(cp.size()>0){
            cont++;
            String aux = cp.pop();
            p.addPrint(aux);
            Iterator<Integer> it = g.adjacents(table.get(aux));
            while(it != null && it.hasNext()){
                int adyacente = it.next();
                if(--gradoEntrada[adyacente] == 0){
                    cp.push((String) vertice[adyacente], (String)vertice[adyacente]);
                }
            }
        }
        if(cont-1 < g.vertices()){
            System.out.println("CICLO DETECTADO");
        } else {
            p.imprimir();
        }
    }

    public static LinkedList<Arista> kruskal(GraphMatrix g){
        ColaPrioridad<Arista,Integer> cp = g.aristas;
        LinkedList<Arista> l =  new LinkedList<>();
        DJSet dSet = new DJSet(g.vertices());
        while(cp.size()>0){
            Arista arista = cp.pop();
            if(dSet.find(arista.origen) != dSet.find(arista.destino)){
                dSet.union(arista.origen, arista.destino);
                l.add(arista);
            }
        }
        return l;
    }

}
