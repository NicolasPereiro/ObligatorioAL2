package Ejercicios;

import java.util.Scanner;

import objetos.Plato;
import tads.hash.Hash;
import tads.hash.StringHash;
import tads.table.THC;

public class Ejercicio1 {
    public Ejercicio1() {
        prueba();
    }

    public void prueba() {
        Scanner in = new Scanner(System.in);
        int largo = in.nextInt();
        Hash<String> hash = new StringHash();
        THC<String, Plato> t = new THC<String, Plato>(hash, largo);
        for (int i = 0; i < largo; i++) {
            String entrada = in.nextLine();

        }
    }

}
