package tads.table;

import java.util.Iterator;

import tads.hash.Hash;
@SuppressWarnings("unchecked")
public class OpenHashTable<K,V> implements Table<K,V> {
    private Object[][] arr;
    private int bucketUsed;
    private int elements;
    private Hash<K> hashFunc;

    public OpenHashTable(Hash<K> hashFunc, int expectedSize){
        arr = new Object[expectedSize*2 + 1][2];
        elements = 0;
        this.hashFunc = hashFunc;
    }

    // @Override
    // public Iterator<Pair<K, V>> iterator() {
        
    // }

    @Override
    public void add(K key, V value) {
        int h = abs(hashFunc.hash(key));
        int pos =  h % length(arr);
        if(arr[pos] == null){
            arr[pos][0] = key;
            arr[pos][1] = (int)1;
            bucketUsed++;
        }else {
            arr[pos][1] = (int)(arr[pos][1]) + 1;
            elements++;
        }
        reFactor();
    }

    private void reFactor() {
        float lambda = (float)(bucketUsed) / (float)elements;
        if(lambda > 0.85){
            Object[][] newArr = new Object[length(arr) * 2 - 1][2];
            for(int i= 0; i < length(arr); i++){
                if(arr[i] != null){
                    int h = abs(hashFunc.hash((K) arr[i][0]));
                    int pos = h % (length(arr) * 2 - 1);
                    newArr[pos] = arr[i];
                }
            }
            arr = newArr;
        }
    }

    private int length(Object[] arr) {
        int size = 0;
        boolean finish = true;
        while(finish){
             try {
                Object aux = arr[size];
                size++;
            } catch (Exception ArrayIndexOutOfBoundsException) {
                finish = false;
            }
        }
        return size+1;
    }



    private int abs(int val) {
        if(val < 0)return val*(-1);
        return val;
    }

    @Override
    public void delete(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public boolean has(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'has'");
    }

    @Override
    public V get(K key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Iterable<K> keys() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keys'");
    }

    @Override
    public Iterable<V> values() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }
    
}