import tads.hash.Hash;
import tads.hash.IntHash;
import tads.list.ListaEncadenada;
import tads.table.THC;

public class Prueba {
    public static void main(String[] args) {
        Hash<Integer> miHash = new IntHash();
        THC<Integer,String> t = new THC<Integer,String>(miHash, 6);
        t.add(4, "Pizza");
        t.add(4, "Hamburguesa");
        t.delete(4);
    }
    
}