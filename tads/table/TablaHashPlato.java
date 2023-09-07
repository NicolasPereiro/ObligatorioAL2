package tads.table;
import tads.hash.Hash;
import objetos.Plato;

@SuppressWarnings("unchecked")
public class TablaHashPlato {
    private Object[] arr;
    private int bucketUsed;
    private Hash<String> hashFunc;

    public TablaHashPlato(Hash<String> hash, int expectedSize){
        arr = new Object[expectedSize*2 + 1];
        bucketUsed = 0;
        hashFunc = hash;
    }

    public void add(String key, Plato value) {
        int h = abs(hashFunc.hash(key));
        int pos = h%arr.length;
        if(arr[pos] == null || ((Plato)arr[pos]).estaBorrado){ 
            arr[pos] = new Plato(key);
            bucketUsed++;
        } else if (mismoPlato(((Plato)arr[pos]), value)) {
            ((Plato)arr[pos]).cantidad++;
        } else {
            
        }
    }
    private boolean mismoPlato(Plato plato1, Plato plato2) {
        return plato1.nombre.equals(plato2.nombre);
    }

    private int abs(int x) {
        if(x<0)return -x;
        else return x;
    }

    public void delete(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    public Plato get(String key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }
  
}