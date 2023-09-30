 import java.util.Scanner;
import objetos.Pelicula;
import tads.colaPrioridad.MaxHeap;

public class Ejercicio2 {
    public Ejercicio2() {

    }

    public static void main(String args[]) {
        test();
    }

    public static void test() {
        Scanner in = new Scanner(System.in);
        int generos=in.nextInt();
        in.nextLine();
        for(int i=0; i<=generos;i++){
            in.nextLine();
        }
        int cantPeliculas=in.nextInt();
        in.nextLine();
        for(int i=0;i<=cantPeliculas;i++){
            String[] pelicula= in.nextLine().split(" ");
            Pelicula p = new Pelicula(Integer.parseInt(pelicula[0]));
            p.setGenero(pelicula[1]);
            //agregar al hash
        }
    }
}