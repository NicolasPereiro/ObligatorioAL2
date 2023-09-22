package objetos;

import tads.colaPrioridad.MaxHeap;

public class Genero {
    public String nombre;
    public MaxHeap<Pelicula, Pelicula> peliculas;

    public Genero(String nombre) {
        this.nombre = nombre;
    }
}
