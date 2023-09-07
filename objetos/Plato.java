package objetos;
public class Plato {
    public int cantidad;
    public String nombre;
    public boolean estaBorrado = true;

    public Plato(String nombre){
        this.nombre = nombre;
        this.cantidad = 1;
    }

}
