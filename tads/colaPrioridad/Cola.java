package tads.colaPrioridad;

public class Cola<T> {
    @SuppressWarnings("hiding")
    private class Node<T> {
        T data;
        Node<T> sig;
        Node(T data){
            this.data = data;
        }
    }
    private Node<T> ini;
    private Node<T> last;
    private int largo;
    
    public Cola(){
        ini = last = null;
        largo = 0;
    }
    
    public void insertar(T t){
        if(ini == null){
            ini = new Node<T>(t);
            largo++;
            last = ini;
            return;
        }
        last.sig = new Node<T>(t);
        last = last.sig;
        largo++;
    }

    public T vaciar(){
        T top = principio();
        if(ini == null)throw new RuntimeException("Cola vacia");
        ini = ini.sig;
        largo--;
        return top;
    }

    public T principio(){
        return ini.data;
    }

    public int size(){
        return largo;
    }

    public boolean isEmpty(){
        return largo == 0;
    }
}
