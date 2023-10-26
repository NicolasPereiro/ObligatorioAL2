import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String entrada = in.nextLine();
        int[] datos = new int[entrada.length()];
        for (int i = 0; i < datos.length; i++) {
            datos[i] = Integer.parseInt("" + entrada.charAt(i));
        }
        in.close();
        int largo = datos.length;
        heapSort(datos, largo);
        String num1 = "";
        String num2 = "";
        for (int i = 0; i < datos.length; i++) {
            if (i % 2 == 0) {
                num1 += datos[i];
            } else
                num2 += datos[i];
        }

        System.out.println(Integer.parseInt(num1) + Integer.parseInt(num2));
    }

    public static void heapSort(int[] arr, int largo) {
        for (int i = largo / 2 - 1; i >= 0; i--) {
            heapify(arr, largo, i);
        }
        for (int i = largo - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int largo, int index) {
        int izq = index * 2 + 1;
        int der = index * 2 + 2;
        int huboSwap = index;

        if (izq < largo && arr[izq] > arr[huboSwap]) {
            huboSwap = izq;
        }
        if (der < largo && arr[der] > arr[huboSwap]) {
            huboSwap = der;
        }
        if (huboSwap != index) {
            int aux = arr[index];
            arr[index] = arr[huboSwap];
            arr[huboSwap] = aux;
            heapify(arr, largo, huboSwap);
        } /*
           * if (der < largo) {
           * if (arr[index] < arr[izq]) {
           * int aux = arr[index];
           * arr[index] = arr[izq];
           * arr[izq] = aux;
           * huboSwap = izq;
           * }
           * if (arr[index] < arr[der]) {
           * int aux = arr[index];
           * arr[index] = arr[der];
           * arr[der] = aux;
           * huboSwap = der;
           * }
           * } else if (izq < largo) {
           * if (arr[index] < arr[izq]) {
           * int aux = arr[index];
           * arr[index] = arr[izq];
           * arr[izq] = aux;
           * huboSwap = izq;
           * }
           * }
           * if (huboSwap != index) {
           * heapify(arr, largo, huboSwap);
           * }¨
           */
        

    }
}
