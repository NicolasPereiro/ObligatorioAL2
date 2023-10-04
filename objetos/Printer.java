package objetos;

import tads.colaPrioridad.Cola;

public class Printer {
    private Cola<String> out;
    public Printer(){
        this.out = new Cola<>();
    }

    public void addPrint(String s){
        out.insertar(s);
    }
    
    public void imprimir(){
        while(out.size()>0){
            System.out.println(out.vaciar());
        }
    }
}
