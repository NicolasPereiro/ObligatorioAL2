import java.util.Scanner;

import objetos.Paciente;
import tads.colaPrioridad.ColaPrioridad;
import tads.colaPrioridad.MaxHeap;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ColaPrioridad<Paciente,Integer> c = new MaxHeap<Paciente, Integer>(n);
        for(int i=0; i<n; i++){
            String[] arr = in.nextLine().split(" ");
            Paciente p = new Paciente(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), i);
            int prioridad = Integer.parseInt(arr[2]);
            c.push(p, prioridad);
        }
        in.close();
    }
}
