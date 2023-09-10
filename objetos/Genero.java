package objetos;

import tads.colaPrioridad.MaxHeap;

public class Genero {
    public String nombre;
    public MaxHeap<Pelicula, Integer> peliculas;

    public Genero(String nombre) {
        this.nombre = nombre;
        this.peliculas = new MaxHeap<Pelicula, Integer>(100);
    }
}
