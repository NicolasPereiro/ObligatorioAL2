
package tads.table;
import tads.list.ListaEncadenada;
import tads.par.ParBorrado;
import tads.hash.Hash;
import objetos.Plato;
@SuppressWarnings({"unchecked"})
public class THCPlato {

    private Hash<String> hashFunc;
    /** ParBorrado{K,V}[] */
    private Object[] arr;
    private int elements = 0;

    public THCPlato(Hash<String> hashFunc, int expectedSize) {
        this.hashFunc = hashFunc;
        this.arr = new Object[expectedSize + 1];
    }

    public void add(String key, Plato value) {
        int h = abs(hashFunc.hash(key));
        int collissions = 0;
        int pos = h % arr.length;
        boolean repetido = false;
        while (arr[pos] != null && !((ParBorrado<String, Plato>) arr[pos]).borrado && !repetido) {
            Plato p = ((ParBorrado<String,Plato>)arr[pos]).snd;
            if(p.toString().equals(value.toString())){
                p.setCantidad(p.getCantidad() + 1);
                repetido = true;
            }
            collissions++;
            pos = abs(h + collissions) % arr.length;
        }
        if(!repetido){
            arr[pos] = new ParBorrado<String,Plato>(key, value);
            elements++;
        }
        chargeFactor();
    }

    private void chargeFactor() {
        float lambda = (float) elements / (float) arr.length;
        if (lambda > 0.7) {
            THCPlato aux = new THCPlato(hashFunc, arr.length - 1);
            for (int i = 0; i < arr.length; i++) {
                ParBorrado<String,Plato> elem = (ParBorrado<String,Plato>) arr[i];
                if (!elem.borrado && elem != null) {
                    aux.add(elem.fst, elem.snd);
                }
            }
            this.arr = aux.arr;
        }
    }

    private int abs(int x) {
        if (x < 0) {
            return x*(-1);
        } else {
            return x;
        }
    }

    public void delete(String key) {
        int h = abs(hashFunc.hash(key));
        int pos = h % arr.length;
        ParBorrado<String,Plato> aux = (ParBorrado<String,Plato>) arr[pos];
        if (aux == null || aux.borrado)
            return;
        else {
            int col = 1;
            int newPos = abs((h + col * col)) % arr.length;
            while ((ParBorrado<String,Plato>) arr[newPos] != null && !((ParBorrado<String,Plato>) arr[pos]).borrado) {
                aux = (ParBorrado<String,Plato>) arr[newPos];
                col++;
                newPos = abs((h + col * col)) % arr.length;
            }
            aux.borrado = true;
            elements--;
        }
    }

    public int size() {
        return elements;
    }

    public boolean has(String key) {
        int h = abs(hashFunc.hash(key));
        int pos = h % arr.length;
        ParBorrado<String,Plato> aux = (ParBorrado<String,Plato>) arr[pos];
        if (aux == null || aux.borrado)
            return false;
        else
            return true;
    }

    public Plato get(String key) {
        int h = abs(hashFunc.hash(key));
        int pos = h % arr.length;
        ParBorrado<String,Plato> aux = (ParBorrado<String,Plato>) arr[pos];
        if (!aux.borrado && aux != null)
            return aux.snd;
        else
            return null;
    }

    public ListaEncadenada<String> keys() {
        ListaEncadenada<String> l = new ListaEncadenada<String>();
        for (int i = 0; i < arr.length; i++) {
            ParBorrado<String,Plato> elem = (ParBorrado<String,Plato>) arr[i];
            if (elem != null && !elem.borrado) {
                l.add(elem.fst);
            }
        }
        return l;
    }

    public ListaEncadenada<Plato> values() {
        ListaEncadenada<Plato> l = new ListaEncadenada<Plato>();
        for (int i = 0; i < arr.length; i++) {
            ParBorrado<String,Plato> elem = ((ParBorrado<String,Plato>) arr[i]);
            if (elem != null && !elem.borrado) {
                l.add(elem.snd);
            }
        }
        return l;
    }
}
