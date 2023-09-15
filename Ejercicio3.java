import java.util.Scanner;

import objetos.Paciente;
import tads.colaPrioridad.ColaPrioridad;
import tads.colaPrioridad.MaxHeap;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        ColaPrioridad<Integer,Paciente> c = new MaxHeap<Integer, Paciente>(n);
        for(int i=0; i<n; i++){
            String linea = in.nextLine();
            String[] arr = linea.split(" ");
            Paciente p = new Paciente(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), i);
            c.push(Integer.parseInt(arr[0]), p);
        }
        in.close();
        while(c.size()>0){
            System.out.println(c.pop());
        }
    }
}
