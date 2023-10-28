import java.util.Scanner;

import objetos.Pico;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int largo = in.nextInt();
        Object[] datos = new Object[largo];
        for (int i = 0; i < datos.length; i++) {
            int val = in.nextInt();
            Pico p = new Pico(val);
            datos[i] = p;
        }
        in.close();
        encontrarPicos(datos, 0, largo - 1);
        boolean print = false;
        for (int i = 0; i < datos.length; i++) {
            if (((Pico) datos[i]).esPico == true) {
                System.out.println(((Pico) datos[i]).valor);
                print = true;
            }
        }
        if (!print) {
            System.out.println("No se encontraron picos");
        }
    }

    private static void encontrarPicos(Object[] arr, int ini, int fin) {
        if (fin - ini <= 1) {// en el 4 queda ini=2 overflow, cuando hay iguales seguidos boom
            if (ini == fin) {
                ((Pico) arr[ini]).esPico = true;
            } else if (((Pico) arr[ini]).valor > ((Pico) arr[fin]).valor) {
                ((Pico) arr[ini]).esPico = true;
            } else if (((Pico) arr[ini]).valor < ((Pico) arr[fin]).valor) {
                ((Pico) arr[fin]).esPico = true;
            }
            return;
        }
        int mitad = (fin - ini) / 2;
        mitad = ini + mitad;
        encontrarPicos(arr, ini, mitad);
        encontrarPicos(arr, mitad + 1, fin);
        if (((Pico) arr[mitad]).valor > ((Pico) arr[mitad + 1]).valor) {
            ((Pico) arr[mitad + 1]).esPico = false;
        } else if (((Pico) arr[mitad]).valor < ((Pico) arr[mitad + 1]).valor) {
            ((Pico) arr[mitad]).esPico = false;
        } else {
            ((Pico) arr[mitad]).esPico = false;
            ((Pico) arr[mitad + 1]).esPico = false;
        }
    }
}
