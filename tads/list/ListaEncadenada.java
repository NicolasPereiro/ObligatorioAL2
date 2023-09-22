package tads.list;

public class ListaEncadenada<T> implements List<T> {
    @SuppressWarnings("hiding")
    private class Node<T> {
        T data;
        Node<T> sig;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> ini;
    private int elements;

    @Override
    public void add(T t) {
        if (ini == null) {
            ini = new Node<T>(t);
            elements++;
            return;
        }
        Node<T> aux = ini;
        while (aux.sig != null) {
            aux = aux.sig;
        }
        aux.sig = new Node<T>(t);
        elements++;
    }

    @Override
    public T getFirst() {
        if (ini == null)
            throw new RuntimeException("Lista vacia");
        else
            return ini.data;
    }

    @Override
    public T getAt(int i) {
        if (ini == null)
            throw new RuntimeException("Lista vacia");
        else if (i < 0)
            throw new RuntimeException("Parametro invalido");
        else {
            Node<T> aux = ini;
            while (aux.sig != null && i != 0) {
                aux = aux.sig;
                i--;
            }
            return aux.data;
        }
    }

    @Override
    public int size() {
        return elements;
    }

    public void remove(int i) {
        if (ini == null)
            throw new RuntimeException("Lista vacia");
        else if (i < 0 || i >= elements)
            throw new RuntimeException("Parametro invalido");
        else {
            ListaEncadenada<T> l = new ListaEncadenada<T>();
            Node<T> aux = ini;
            for(int j=0; j< elements; j++){
                if(j!=i){
                l.add(aux.data);
                }
                aux = aux.sig;
            }
            this.ini = l.ini;
            elements--;
        }
    }

    @Override
    public boolean hasNext() {
        return elements>0;
    }
}