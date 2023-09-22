package objetos;

import tads.colaPrioridad.MaxHeap;

public class Genero {
    public String nombre;
    public MaxHeap<Pelicula, Double> peliculas;

    public Genero(String nombre) {
        this.nombre = nombre;
    }
}
