package tads.list;

public interface List<T> extends Iterable<T>{
    void add(T t);
    void remove(T data);
    void removeAt(int i);
    T getAt(int i);
    int size();
}