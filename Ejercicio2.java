import java.util.Scanner;
import objetos.Pelicula;
import tads.colaPrioridad.MaxHeap;
import tads.hash.Hash;
import tads.hash.IntHash;
import tads.hash.StringHash;
import tads.table.THC;
import tads.list.LinkedList;

public class Ejercicio2 {
    public Ejercicio2() {

    }

    public static void main(String args[]) {
        test();
    }

    public static void test() {
        Scanner in = new Scanner(System.in);
        int generos = in.nextInt();
        Hash<String> hashGen = new StringHash();
        THC<String, Integer> tGen = new THC<String, Integer>(hashGen, generos);
        for (int i = 0; i <= generos; i++) {
            String genero = in.nextLine();
            tGen.add(genero, i + 1);
        }
        int cantPeliculas = in.nextInt();
        in.nextLine();
        Hash<Integer> hash = new IntHash();
        THC<Integer, Pelicula> t = new THC<Integer, Pelicula>(hash, cantPeliculas);
        for (int i = 0; i < cantPeliculas; i++) {
            String[] pelicula = in.nextLine().split(" ");
            Pelicula p = new Pelicula(Integer.parseInt(pelicula[0]));
            p.setGenero(pelicula[1]);
            p.setCodGenero(tGen.get(pelicula[1]));// agrega el codigo de genero
            t.add(p.getId(), p);
        }
        int cal = in.nextInt();
        in.nextLine();
        for (int i = 0; i < cal; i++) {
            String[] cals = in.nextLine().split(" ");
            Pelicula aux = t.get(Integer.parseInt(cals[0]));
            aux.setSumCalificaciones(aux.getSumCalificaciones() + Integer.parseInt(cals[1]));
            aux.agregarReseña(); //cuenta de mas, la funcion esta mal no enceuntra la pelicula correcta
            t.delete(Integer.parseInt(cals[0]));
            t.add(aux.getId(), aux);
        } // fin lectura
        in.close();
        MaxHeap<Pelicula, Pelicula> heapAux = new MaxHeap<Pelicula, Pelicula>(cantPeliculas / 2);
        LinkedList<Integer> keys = t.keys();
        LinkedList<Integer>.ListIterator it = (LinkedList<Integer>.ListIterator) keys.iterator();
        while (it.hasNext()) {
            int key = it.next();
            Pelicula peli = t.get(key);
            peli.promedio();// se deberia de calcular el prom
            if (peli.getPromCalificaciones() != 0) {
                heapAux.push(peli, peli);
            }
        }
        Pelicula p1 = heapAux.pop();
        System.out.println(p1.getId());
        while (generos - 1 != 0) {
            Pelicula pAux = heapAux.pop();
            if (pAux.getGenero().compareTo(p1.getGenero()) != 0) {
                System.out.println(pAux.getId());
                p1 = pAux;
                generos--;
            }
        }

    }
}