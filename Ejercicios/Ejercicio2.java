package Ejercicios;

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
        Genero[] arrGeneros = new Genero[largoGenros + 1];
        for (int i = 0; i <= largoGenros; i++) {
            Genero newGenero = new Genero(in.nextLine());
            arrGeneros[i] = newGenero;
        }
        int cantPeliculas = in.nextInt();
        while (cantPeliculas != 0) {
            boolean encontrado = false;
            String[] datosFilm = in.nextLine().split(" ");
            Pelicula newPelicula = new Pelicula(Integer.parseInt(datosFilm[0]));
            for (int i = 0; i <= largoGenros && !encontrado; i++) {
                if ((arrGeneros[i].nombre).compareToIgnoreCase(datosFilm[1]) == 0) {
                    arrGeneros[i].peliculas.push(newPelicula, 0);
                    encontrado = true;
                }
            }
            cantPeliculas--;
        }
        int calificaciones = in.nextInt();
        while (calificaciones != 0) {
            String[] reseñaFilm = in.nextLine().split(" ");
            int id = Integer.parseInt(reseñaFilm[0]);
            MaxHeap<Pelicula, Integer> heapAux = new MaxHeap<Pelicula, Integer>(100);
            boolean cambio = false;
            for (int i = 0; i < arrGeneros.length && !cambio; i++) {
                Pelicula film = arrGeneros[i].peliculas.pop();
                if (film.id == id) {
                    film.calificaciones += Integer.parseInt(reseñaFilm[1]);
                    film.nroReseñas++;
                    arrGeneros[i].peliculas.push(film, film.calificaciones);
                    while (heapAux.size() != 0) { // warning
                        Pelicula peliculaAux = heapAux.pop();
                        arrGeneros[i].peliculas.push(peliculaAux, peliculaAux.calificaciones);
                    }
                    cambio = true;
                } else { // warning
                    heapAux.push(film, film.calificaciones);
                    if (arrGeneros[i].peliculas.size() == 0) {
                        arrGeneros[i].peliculas = heapAux;
                        heapAux = new MaxHeap<Pelicula, Integer>(100);
                    }
                }
            }
        }
        in.close();
        Pelicula[] peliculasMejorCalificadas = new Pelicula[largoGenros + 1];
        for (int j = 0; j < peliculasMejorCalificadas.length; j++) {
            peliculasMejorCalificadas[j] = null;
        }
        for (int i = 0; i < arrGeneros.length; i++) {
            while (arrGeneros[i].peliculas.size() != 0) {
                Pelicula film = arrGeneros[i].peliculas.pop();
                int ReseñaProm = film.calificaciones / film.nroReseñas;
                film.calificaciones = ReseñaProm;
                if (peliculasMejorCalificadas[i] == null
                        || peliculasMejorCalificadas[i].calificaciones < film.calificaciones) {
                    peliculasMejorCalificadas[i] = film;
                } else {
                    if (peliculasMejorCalificadas[i].calificaciones == film.calificaciones
                            && peliculasMejorCalificadas[i].id < film.id) {
                        peliculasMejorCalificadas[i] = film;
                    }
                }
            }
        }
        for (int i = 0; i < peliculasMejorCalificadas.length; i++) {
            System.out.println(peliculasMejorCalificadas[i].id);
        }
    }
}