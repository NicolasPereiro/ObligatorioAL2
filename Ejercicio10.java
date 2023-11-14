import java.util.Scanner;

import tads.colaPrioridad.MinHeap;

public class Ejercicio10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] medidas = in.nextLine().split(" ");
        int largo = Integer.parseInt(medidas[0]);
        int ancho = Integer.parseInt(medidas[1]);
        int[][] mat = new int[largo][ancho];
        for (int i = 0; i < largo; i++) {
            String[] fila = in.nextLine().split(" ");
            for (int j = 0; j < ancho; j++) {
                mat[i][j] = Integer.parseInt(fila[j]);
            }
        }
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {
                if (mat[i][j] == 0) {
                    if (sudokuBT(mat, i, j)) {
                        System.out.print(mat[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static boolean sudokuBT(int[][] mat, int i, int j) {
        return false;

    }

    private static boolean esViable(int[][] mat) {
        MinHeap<Integer, Integer> HeapCol = new MinHeap<>(mat[0].length);
        for (int i = 0; i < mat.length; i++) {
            MinHeap<Integer, Integer> HeapFila = new MinHeap<>(mat[0].length);
            for (int j = 0; j < mat[0].length; j++) {
                if (j == i) {
                    HeapCol.push(mat[i][j], 1);
                }
                HeapFila.push(mat[i][j], 1);
            }
            int aux = HeapFila.pop();
            while (HeapFila.size() != 0) {
                int aux2=HeapFila.pop();
                if (aux2 == aux) {
                    return false;
                }
                aux=aux2;
            }
        }
        int aux = HeapCol.pop();
        while (HeapCol.size() != 0) {
            int aux2=HeapCol.pop();
            if (aux2 == aux) {
                return false;
            }
            aux=aux2;
        }
        return true;
    }
}
