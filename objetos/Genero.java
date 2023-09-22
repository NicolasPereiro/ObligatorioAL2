package objetos;

import tads.colaPrioridad.MaxHeap;

public class Genero {
    public String nombre;
    public MaxHeap<Pelicula, Double> peliculas;

    public Genero(String nombre) {
        this.nombre = nombre;
        this.peliculas = new MaxHeap<Pelicula, Double>(100);
    }
}
