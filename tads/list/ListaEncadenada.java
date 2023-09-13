package tads.list;


@SuppressWarnings("hiding")
public class ListaEncadenada<T> implements List<T>{

    private class Node<T> {
        T data;
        Node<T> sig;
        Node(T data){
            this.data = data;
        }
    }
    private Node<T> ini;
    private int elem;

    public ListaEncadenada(){
        elem = 0;
    }

    @Override
    public void add(T data) {
        if(ini == null){
            ini = new Node<T>(data);
            elem++;
        } else {
            Node<T> aux = ini;
            while(aux.sig != null){
                aux = aux.sig;
            }
            aux.sig = new Node<T>(data);
            elem++;
        }
    }

    @Override
    public void remove(int i) {
        if(ini == null || i<0 || i>elem)return;
        ListaEncadenada<T> l = new ListaEncadenada<>();
        Node<T> aux = ini;
        int largo = elem;
        while(largo > 0){
            if(i!=0){
                l.add(aux.data);
            }
            aux = aux.sig;
            i--;
            largo--;
        }
        this.ini = l.ini;
        elem--;    
    }

    @Override
    public int size() {
        return elem;
    }

    @Override
    public boolean hasNext() {
        if(ini.sig != null){
            return true;
        }
        return false;
    }

    @Override
    public T getAt(int i) {
        if(i<0 || i>= elem)throw new RuntimeException("Parametro invalido");
        Node<T> aux = ini;
        while(i>0){
            aux = aux.sig;
            i--;
        }
        return aux.data;
    }

    @Override
    public T getFirst() {
        if(ini == null)throw new RuntimeException("Lista vacia");
        else return ini.data;
    }
    
}
