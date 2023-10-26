package tads.graph;

import java.util.Iterator;

import objetos.Arista;
import tads.colaPrioridad.ColaPrioridad;
import tads.colaPrioridad.MinHeap;
import tads.list.LinkedList;

public class GraphMatrix implements Graph {
  int[][] mat;
  boolean isDirected;
  public int[] gradosEntrada;
  public ColaPrioridad<Arista, Integer> aristas = null;

  public GraphMatrix(int vertices, boolean isDirected) {
    this.isDirected = isDirected;
    this.mat = new int[vertices + 1][vertices + 1];
    this.gradosEntrada = new int[vertices + 1];
  }

  public void setAristas(int cantAristas) {
    aristas = new MinHeap<>(cantAristas);
  }

  @Override
  public int vertices() {
    return this.mat.length - 1;
  }

  @Override
  public Iterator<Integer> adjacents(int v) {
    LinkedList<Integer> l = new LinkedList<Integer>();
    for (int i = 0; i < mat.length; i++) {
      if (hasEdge(v, i)) {
        l.add(i);
      }
    }
    return l.iterator();
  }

  @Override
  public boolean hasEdge(int v, int w) {
    return this.mat[v][w] != 0;
  }

  @Override
  public int getEdge(int v, int w) {
    if (!hasEdge(v, w)) {
      throw new RuntimeException("Edge does not exist");
    }
    return this.mat[v][w];
  }

  @Override
  public int[][] adjecencyMatrix() {
    return clone(this.mat);
  }

  private int[][] clone(int[][] matrix) {
    int[][] clone = new int[matrix.length][matrix.length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        clone[i][j] = matrix[i][j];
      }
    }
    return clone;
  }

  @Override
  public void addEdge(int v, int w) {
    this.mat[v][w] = 1;
    this.gradosEntrada[w]++;
    if (!this.isDirected) {
      this.mat[w][v] = 1;
    }
  }

  @Override
  public void addEdge(int v, int w, int weight) {
    this.mat[v][w] = weight;
    if (aristas != null) {
      Arista ari = new Arista(v, w);
      aristas.push(ari, weight);
    }
    this.gradosEntrada[w]++;
    if (!this.isDirected) {
      this.mat[w][v] = weight;
    }
  }

  @Override
  public void removeEdge(int v, int w) {
    this.mat[v][w] = 0;
    this.gradosEntrada[w]--;
    if (!this.isDirected) {
      this.mat[w][v] = 0;
    }
  }

}
