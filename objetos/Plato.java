<<<<<<< HEAD
package objetos;
public class Plato {
    private int cantidad;
    private String nombre;

    public Plato(String nombre){
        this.nombre = nombre;
        this.cantidad = 1;
    }

    public int getCantidad(){
        return this.cantidad;
    }

    public void setCantidad(int cant){
        this.cantidad = cant;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
=======
package objetos;
public class Plato {
    public int cantidad;
    public String nombre;

    public Plato(String nombre){
        this.nombre = nombre;
        this.cantidad = 1;
    }

}
>>>>>>> ejercicio2
