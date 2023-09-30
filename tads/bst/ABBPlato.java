package tads.bst;

import objetos.Plato;

public class ABBPlato {
    @SuppressWarnings("hiding")
    private class Node<Plato> {
        Plato data;
        Node<Plato> izq;
        Node<Plato> der;

        Node(Plato p) {
            this.data = p;
        }
    }

    Node<Plato> ini;

    public void add(Plato p) {
        ini = insert(ini, p);
    }

    private Node<Plato> insert(Node<Plato> node, Plato p) {
        if (node == null) {
            node = new Node<Plato>(p);
            return node;
        } else {
            Plato aux = node.data;
            if (aux.getCantidad() > p.getCantidad()) {

                node.izq = insert(node.izq, p);
            } else if (aux.getCantidad() == p.getCantidad()) {
                if (aux.toString().compareTo(p.toString()) > 0) {
                    Plato swap = aux;
                    node.data = p;
                    p = swap;
                }
                node.izq = insert(node.izq, p);

            } else {
                node.der = insert(node.der, p);
            }
            return node;
        }
    }

    public void imprimirMayor() {
        while (ini != null) {
            String res = buscarMax(ini);
            System.out.println(res);
            ini = remove(ini, res);
        }
    }

    private Node<Plato> remove(Node<Plato> node, String data) {
        if (node == null)
            return null;
        if (node.data.toString().equals(data)) {
            node = node.izq;
        } else if (node.der != null) {
            node.der = remove(node.der, data);
        } else {
            node.izq = remove(node.izq, data);
        }
        return node;
    }

    private String buscarMax(Node<Plato> node) {
        Node<Plato> aux = node;
        while (aux.der != null) {
            aux = aux.der;
        }
        return aux.data.toString();
    }

}
