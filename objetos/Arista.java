package objetos;

public class Arista implements Comparable<Arista>{
    public int origen;
    public int destino;
    public Arista(int origen, int destino){
        this.origen = origen;
        this.destino = destino;
    }
    @Override
    public int compareTo(Arista a) {
        if(a.origen == this.origen && a.destino == this.destino){
            return 0;
        } else {
            return 1;
        }
    }
}
