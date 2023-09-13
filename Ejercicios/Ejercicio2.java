package Ejercicios;

import java.util.Scanner;
import objetos.Genero;
import objetos.Pelicula;

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
                if ((arrGeneros[i].nombre).compareToIgnoreCase(datosFilm[1])) {
                    arrGeneros[i].peliculas.push(newPelicula, 0);
                    encontrado = true;
                }
            }
            cantPeliculas--;
        }
        int calificaciones=in.nextInt();
        while(calificaciones!=0){
            String[] reseñaFilm = in.nextLine().split(" ");
            
        }

        THC<String, Plato> t = new THC<String, Plato>(hash, largo);
        for (int i = 0; i < largo; i++) {
            String entrada = in.nextLine();

        }
    }

}
