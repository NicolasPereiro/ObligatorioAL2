package objetos;

public class Pelicula implements Comparable<Pelicula> {
    private int id;
    private String genero;
    private int codGenero;
    private int sumCalificaciones;
    private double nroReseñas;
    private double promCalificaciones;

    public Pelicula(int id) {
        this.id = id;
        this.sumCalificaciones = 0;
        this.nroReseñas = 0;
        this.promCalificaciones = 0;
        this.genero = "";
    }

    public int getCodGenero() {
        return codGenero;
    }

    public void setCodGenero(int codGenero) {
        this.codGenero = codGenero;
    }

    public double getNroReseñas() {
        return nroReseñas;
    }

    public void setNroReseñas(double nroReseñas) {
        this.nroReseñas = nroReseñas;
    }

    public int getSumCalificaciones() {
        return sumCalificaciones;
    }

    public void setSumCalificaciones(int sumCalificaciones) {
        this.sumCalificaciones = sumCalificaciones;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPromCalificaciones() {
        return promCalificaciones;
    }

    public void promedio() {
        if (this.nroReseñas == 0) {
            this.promCalificaciones = 0;
        } else
            this.promCalificaciones = sumCalificaciones / nroReseñas;
    }

    public void agregarReseña() {
        this.nroReseñas++;
    }

    @Override
    public int compareTo(Pelicula p) {
        Pelicula Pelicula2 = p;
        if (this.codGenero > p.codGenero) {
            return -1;
        } else if (this.codGenero < p.codGenero) {
            return 1;
        } else { // si son iguales
            if (this.promCalificaciones > Pelicula2.promCalificaciones) {
                return 1;
            } else if (this.promCalificaciones < Pelicula2.promCalificaciones) {
                return -1;
            } else {
                if (this.id < Pelicula2.id) {
                    return 1;
                } else if (this.id > Pelicula2.id) {
                    return -1;
                }
            }
            return id;
        }
    }
}
