package tads.list;

public interface List<T> {
    void add(T data);
    void remove(int i);
    int size();
    boolean hasNext();
    T getAt(int i);
    T getFirst();
}
