import java.util.Scanner;

import tads.colaPrioridad.MinHeap;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String entrada = in.nextLine();
         MinHeap<Character,Integer>heap=new MinHeap<>(entrada.length());
        for (int i = 0; i < entrada.length(); i++) {
            char num=entrada.charAt(i);
            heap.push(num,Character.getNumericValue(num));
        }
        in.close();     
        String num1 = "";
        String num2 = "";
        while (heap.size()>0) {
            num1+=heap.pop();
            if(heap.size()>0){
                num2+=heap.pop();
            }
        }
        System.out.println(Integer.parseInt(num1) + Integer.parseInt(num2));
    }
}
