
import java.util.Scanner;

import objetos.Plato;
import tads.bst.ABBPlato;
import tads.hash.Hash;
import tads.hash.StringHash;
import tads.list.ListaEncadenada;
import tads.table.THCPlato;

public class Ejercicio1 {
    public static void main(String[] args) {
        prueba();
    }

    public static void prueba() {
        Scanner in = new Scanner(System.in);
        int largo = in.nextInt();
        Hash<String> hash = new StringHash();
        THCPlato t = new THCPlato(hash, largo);
        for (int i = 0; i < largo+ 1; i++) {
            String entrada = in.nextLine();
            if (entrada != "") {
                Plato p = new Plato(entrada);
                t.add(entrada, p);
            }
        }
        in.close();
        ListaEncadenada<Plato> l = t.values();
        ABBPlato p = new ABBPlato();
        while(l.size()>0){
            p.add(l.getAt(0));
            l.remove(0);
        }
        p.imprimirMayor();
        
    }
}