<<<<<<< HEAD
package tads.table;

import tads.list.ListaEncadenada;
import tads.par.Pair;

@SuppressWarnings("hiding")
public interface Table<K,V> extends Iterable<Pair<K,V>>{
    void add(K key, V value);

    void delete(K key);
  
    int size();
  
    boolean has(K key);
  
    V get(K key);
  
    ListaEncadenada<K> keys();
  
    ListaEncadenada<V> values();  
=======
package tads.table;

import tads.list.ListaEncadenada;

@SuppressWarnings("hiding")
public interface Table<K,V> extends Iterable<Pair<K,V>>{
    void add(K key, V value);

    void delete(K key);
  
    int size();
  
    boolean has(K key);
  
    V get(K key);
  
    ListaEncadenada<K> keys();
  
    ListaEncadenada<V> values();  
>>>>>>> ejercicio2
}