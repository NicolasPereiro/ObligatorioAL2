package tads.table;

import tads.list.LinkedList;
import tads.par.Pair;

@SuppressWarnings("hiding")
public interface Table<K extends Comparable<K>,V extends Comparable<V>> extends Iterable<Pair<K,V>>{
    void add(K key, V value);

    void delete(K key);
  
    int size();
  
    boolean has(K key);
  
    V get(K key);
  
    LinkedList<K> keys();
  
    LinkedList<V> values();  
}