package objetos;

public class Paciente implements Comparable<Paciente> {
    public int id;
    public int tiempo;
    public int urgencia;
    public int ingreso;

    public Paciente(int id, int tiempo, int urgencia, int ingreso) {
        this.id = id;
        this.tiempo = tiempo;
        this.urgencia = urgencia;
        this.ingreso = ingreso;
    }

    @Override
    public int compareTo(Paciente aux) {
        if(this.urgencia > aux.urgencia){
            return 1;
        } else if (this.urgencia < aux.urgencia){
            return -1;
        } else {
            if(this.tiempo < aux.tiempo){
                return 1;
            } else if (this.tiempo > aux.tiempo) {
                return -1;
            } else {
                if(this.ingreso < aux.ingreso){
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }
}
