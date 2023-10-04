package tads.graph;

import java.util.Iterator;

import tads.list.LinkedList;

@SuppressWarnings("unchecked")
public class GraphList implements Graph {
    public Object[] adjacencyLists;
    public Object[] vertices;
    public int[] gradosEntrada;
    boolean isDirected;

    public GraphList(int vertices, boolean isDirected) {
        this.adjacencyLists = new Object[vertices + 1];
        this.isDirected = isDirected;
        this.gradosEntrada = new int[vertices + 1];
        this.vertices = new Object[vertices + 1];
    }

    @Override
    public int vertices() {
        return this.adjacencyLists.length - 1;
    }

    @Override
    public Iterator<Integer> adjacents(int v) {
        if(adjacencyLists[v] == null)return null;
        return ((LinkedList<Integer>) adjacencyLists[v]).iterator();
    }

    public Iterator<String> adjacentsString(int v){
        return ((LinkedList<String>) adjacencyLists[v]).iterator();
    }

    @Override
    public boolean hasEdge(int v, int w) {
        Iterator<Integer> it = ((LinkedList<Integer>) adjacencyLists[v]).iterator();
        while (it.hasNext()) {
            if (w == it.next()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getEdge(int v, int w) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("NO ESTA PONDERADO");
    }

    @Override
    public int[][] adjecencyMatrix() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("No tiene matriz de adyacencia");
    }

    @Override
    public void addEdge(int v, int w) {
        gradosEntrada[w]++;
        if (adjacencyLists[v] == null) {
            LinkedList<Integer> l = new LinkedList<>();
            l.add(w);
            adjacencyLists[v] = l;
        } else {
            ((LinkedList<Integer>) adjacencyLists[v]).add(w);
        }
        if (!isDirected) {
            if (adjacencyLists[w] == null) {
                LinkedList<Integer> l = new LinkedList<>();
                l.add(v);
                adjacencyLists[w] = l;
            } else {
                ((LinkedList<Integer>) adjacencyLists[w]).add(v);
            }
        }
    }

    @Override
    public void addEdge(int v, int w, int weight) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
    }

    @Override
    public void removeEdge(int v, int w) {
        if (adjacencyLists[v] == null)
            return;
        gradosEntrada[w]--;
        ((LinkedList<Integer>) adjacencyLists[v]).remove(w);
    }

}