package tads.graph;

import java.util.Iterator;

public class GraphList implements Graph{
    int[] adjacencyLists;
    public GraphList(int vertices){

    }
    @Override
    public int vertices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vertices'");
    }

    @Override
    public Iterator<Integer> adjacents(int v) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adjacents'");
    }

    @Override
    public boolean hasEdge(int v, int w) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hasEdge'");
    }

    @Override
    public int getEdge(int v, int w) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEdge'");
    }

    @Override
    public int[][] adjecencyMatrix() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adjecencyMatrix'");
    }

    @Override
    public void addEdge(int v, int w) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
    }

    @Override
    public void addEdge(int v, int w, int weight) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
    }

    @Override
    public void removeEdge(int v, int w) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeEdge'");
    }
    
}
