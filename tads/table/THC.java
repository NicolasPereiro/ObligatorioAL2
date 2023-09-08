package tads.table;

import java.util.Iterator;
import tads.list.ListaEncadenada;
import tads.table.ParBorrado;
import tads.hash.Hash;


@SuppressWarnings("unused")
public class THC<K, V> implements Table<K, V> {

    private Hash<K> hashFunc;
    /** ParBorrado{K,V}[] */
    private Object[] arr;
    private int elements = 0;

    public THC(Hash<K> hashFunc, int expectedSize) {
        this.hashFunc = hashFunc;
        this.arr = new Object[2 * expectedSize + 1];
    }

    @Override
    public void add(K key, V value) {
        int h = abs(hashFunc.hash(key));
        int collissions = 0;
        int pos = h % arr.length;
        while (arr[pos] != null && !((ParBorrado<K, V>) arr[pos]).borrado) {
            collissions++;
            pos = (h + collissions * collissions) % arr.length;
        }
        arr[pos] = new ParBorrado<K, V>(key, value);
        elements++;
        chargeFactor();
    }

    private void chargeFactor() {
        float lambda = (float) elements / (float) arr.length;
        if (lambda > 0.7) {
            THC<K, V> aux = new THC<>(hashFunc, arr.length - 1);
            for (int i = 0; i < arr.length; i++) {
                ParBorrado<K, V> elem = (ParBorrado<K, V>) arr[i];
                if (!elem.borrado && elem != null) {
                    aux.add(elem.fst, elem.snd);
                }
            }
            this.arr = aux.arr;
        }
    }

    private int abs(int x) {
        if (x < 0) {
            return -x;
        } else {
            return x;
        }
    }

    @Override
    public void delete(K key) {
        int h = abs(hashFunc.hash(key));
        int pos = h % arr.length;
        ParBorrado<K, V> aux = (ParBorrado<K, V>) arr[pos];
        if (aux == null || aux.borrado)
            return;
        else {
            int col = 1;
            int newPos = (h + col * col) % arr.length;
            while ((ParBorrado<K, V>) arr[newPos] != null && !((ParBorrado<K, V>) arr[pos]).borrado) {
                aux = (ParBorrado<K, V>) arr[newPos];
                col++;
                newPos = (h + col * col) % arr.length;
            }
            aux.borrado = true;
            elements--;
        }
    }

    @Override
    public int size() {
        return elements;
    }

    @Override
    public boolean has(K key) {
        int h = abs(hashFunc.hash(key));
        int pos = h % arr.length;
        ParBorrado<K, V> aux = (ParBorrado<K, V>) arr[pos];
        if (aux == null || aux.borrado)
            return false;
        else
            return true;
    }

    @Override
    public V get(K key) {
        int h = abs(hashFunc.hash(key));
        int pos = h % arr.length;
        ParBorrado<K, V> aux = (ParBorrado<K, V>) arr[pos];
        if (!aux.borrado && aux != null)
            return aux.snd;
        else
            return null;
    }

    @Override
    public ListaEncadenada<K> keys() {
        ListaEncadenada<K> l = new ListaEncadenada<K>();
        for (int i = 0; i < arr.length; i++) {
            ParBorrado<K, V> elem = (ParBorrado<K, V>) arr[i];
            if (elem != null && !elem.borrado) {
                l.add(elem.fst);
            }
        }
        return l;
    }

    @Override
    public ListaEncadenada<V> values() {
        ListaEncadenada<V> l = new ListaEncadenada<V>();
        for (int i = 0; i < arr.length; i++) {
            ParBorrado<K, V> elem = ((ParBorrado<K, V>) arr[i]);
            if (elem != null && !elem.borrado) {
                l.add(elem.snd);
            }
        }
        return l;
    }

    @Override
    public Iterator<Pair<K, V>> iterator() {
        ListaEncadenada<ParBorrado<K, V>> l = new ListaEncadenada<ParBorrado<K, V>>();
        for (int i = 0; i < arr.length; i++) {
            ParBorrado<K, V> elem = (ParBorrado<K, V>) arr[i];
            if (elem != null && !elem.borrado) {
                l.add(elem);
            }
        }
        return null;
    }

}
