package objetos;
public class Plato implements Comparable<Plato>{
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

    @Override
    public int compareTo(Plato arg0) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

}
