import java.util.Scanner;
import objetos.Genero;
import objetos.Pelicula;
import tads.colaPrioridad.MaxHeap;

public class Ejercicio2 {
    public Ejercicio2() {
        test();
    }

    public void test() {
        Scanner in = new Scanner(System.in);
        int largoGenros = in.nextInt();
        in.nextLine();
        Genero[] arrGeneros = new Genero[largoGenros + 1];
        for (int i = 0; i <= largoGenros; i++) {
            Genero newGenero = new Genero(in.nextLine());
            arrGeneros[i] = newGenero;
        }
        int cantPeliculas = in.nextInt();
        in.nextLine();
        while (cantPeliculas != 0) {
            boolean encontrado = false;
            String[] datosFilm = in.nextLine().split(" ");
            Pelicula newPelicula = new Pelicula(Integer.parseInt(datosFilm[0]));
            for (int i = 0; i <= largoGenros && !encontrado; i++) {
                if ((arrGeneros[i].nombre).compareToIgnoreCase(datosFilm[1]) == 0) {
                    arrGeneros[i].peliculas.push(newPelicula, (double)0);
                    encontrado = true;
                }
            }
            cantPeliculas--;
        }
        int calificaciones = in.nextInt();
        in.nextLine();
        while (calificaciones != 0) {
            String[] reseñaFilm = in.nextLine().split(" ");
            int id = Integer.parseInt(reseñaFilm[0]);
            MaxHeap<Pelicula, Double> heapAux = new MaxHeap<Pelicula, Double>(100);
            boolean cambio = false;
            for (int i = 0; i < arrGeneros.length && !cambio; i++) {
                Pelicula film = arrGeneros[i].peliculas.pop();
                if (film.id == id) {
                    film.sumCalificaciones += Integer.parseInt(reseñaFilm[1]);
                    film.nroReseñas++;
                    film.promCalificaciones=film.sumCalificaciones/film.nroReseñas;
                    arrGeneros[i].peliculas.push(film, film.promCalificaciones);
                    while (heapAux.size() != 0) { // warning
                        Pelicula peliculaAux = heapAux.pop();
                        arrGeneros[i].peliculas.push(peliculaAux, peliculaAux.promCalificaciones);
                    }
                    cambio = true;
                } else { // warning
                    heapAux.push(film, film.promCalificaciones);
                    if (arrGeneros[i].peliculas.size() == 0) {
                        arrGeneros[i].peliculas = heapAux;
                        heapAux = new MaxHeap<Pelicula, Double>(100);
                    }
                }
            }
        }
        in.close();
        for (int i=0;i<arrGeneros.length;i++){
            System.out.println(arrGeneros[i].peliculas.pop());
        }
    }
}