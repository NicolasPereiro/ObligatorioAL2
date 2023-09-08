
import java.util.Scanner;

import objetos.Plato;
import tads.hash.Hash;
import tads.hash.StringHash;
import tads.list.ListaEncadenada;
import tads.table.THC;
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
        ListaEncadenada<Plato> l = t.values();
    }
}
