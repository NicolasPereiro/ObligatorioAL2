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
        int sum = 0;
        if (datos.length % 2 == 0) {
            for (int i = 0; i < datos.length - i; i++) {
                sum += datos[i] + datos[datos.length - 1 - i];
            }
        } else {
            for (int i = 0; i < datos.length - i; i++) {
                if (datos.length/2 != i) {
                    sum += Integer.parseInt(datos[i] + "" + datos[datos.length - 1 - i]);
                } else {
                    sum += datos[i];
                }
            }
        }

        System.out.println(sum);
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
        if (der < largo) {
            if (arr[index] < arr[izq]) {
                int aux = arr[index];
                arr[index] = arr[izq];
                arr[izq] = aux;
                huboSwap = izq;
            }
            if (arr[index] < arr[der]) {
                int aux = arr[index];
                arr[index] = arr[der];
                arr[der] = aux;
                huboSwap = der;
            }
        } else if (izq < largo) {
            if (arr[index] < arr[izq]) {
                int aux = arr[index];
                arr[index] = arr[izq];
                arr[izq] = aux;
                huboSwap = izq;
            }
        }
        if (huboSwap != index) {
            heapify(arr, largo, huboSwap);
        }

    }
}
