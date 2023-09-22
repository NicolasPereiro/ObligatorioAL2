package objetos;

public class Pelicula implements Comparable {
    public int id;
    public int sumCalificaciones;
    public double promCalificaciones;
    public int nroReseñas;

    public Pelicula(int id) {
        this.id = id;
        this.sumCalificaciones = 0;
        this.promCalificaciones = 0;
        this.nroReseñas = 0;
    }

    @Override
    public int compareTo(Object p) {
        Pelicula aux = (Pelicula) p;
        if (this.promCalificaciones > aux.promCalificaciones) {
            return 1;
        } else if (this.promCalificaciones < aux.promCalificaciones) {
            return -1;
        } else {
            if (this.id < aux.id) {
                return 1;
            } else if (this.id > aux.id) {
                return -1;
            }
        }
        return id;
    }
}