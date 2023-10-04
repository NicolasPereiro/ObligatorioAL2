package tads.list;

import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> ini;
    private int elements;

    @SuppressWarnings("hiding")
    private class Node<T> {
        T data;
        Node<T> sig;

        Node(T data) {
            this.data = data;
        }
    }

    public class ListIterator implements Iterator<T> {
        Node<T> curr;

        ListIterator(Node<T> node) {
            curr = node;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T next() {
            T ret = curr.data;
            curr = curr.sig;
            return ret;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator(ini);
    }

    @Override
    public void add(T t) {
        if (ini == null) {
            ini = new Node<T>(t);
            elements++;
            return;
        }
        Node<T> aux = ini;
        ini = new Node<T>(t);
        ini.sig = aux;
        elements++;
    }

    @Override
    public T getAt(int i) {
        if (i < 0 || i >= elements)
            throw new RuntimeException("Parametro invalido");
        return getAt(i, ini);
    }

    private T getAt(int i, LinkedList<T>.Node<T> node) {
        if (node == null)
            return null;
        if (i == 0) {
            return node.data;
        } else {
            return getAt(i - 1, node.sig);
        }
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public void remove(T data) {
        ini = remove(data, ini);
    }

    private LinkedList<T>.Node<T> remove(T data, LinkedList<T>.Node<T> node) {
        if (node == null)
            return null;
        if ((node.data).compareTo(data) == 0) {
            node = node.sig;
            elements--;
            node = remove(data, node);
        } else {
            node.sig = remove(data, node.sig);
        }
        return node;
    }

    @Override
    public void removeAt(int i) {
        if (i < 0 || i >= elements)
            throw new RuntimeException("Parametro invalido");
        ini = removeAt(i, ini);
    }

    private LinkedList<T>.Node<T> removeAt(int i, LinkedList<T>.Node<T> node) {
        if (node == null)
            return null;
        if (i == 0) {
            node = node.sig;
            elements--;
        } else {
            node.sig = removeAt(i - 1, node.sig);
        }
        return node;
    }
}
