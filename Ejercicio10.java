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
        int k = largo / 3 * ancho / 3;
        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++) {
                if (mat[i][j] == 0) {
                    sudokuBT(mat, i, j, k);
                }
            }
            System.out.println();
        }
    }
    

    private static boolean sudokuBT(int[][] mat, int i, int j, int k) {
        // if (esSol(mat, i, j, k)) {
        //     return true;
        // }
        for (int p = 1; p <= k; p++) {
            mat[i][j] = p;
            if (esViable(mat, k)) {
                for (int f = i; f < mat.length; f++) {
                    for (int c = 0; c < mat[0].length; c++) {
                        if (mat[f][c] == 0) {
                            if (sudokuBT(mat, f, c, k)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean esViable(int[][] mat, int k) {
        boolean[] usados = new boolean[k + 1];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (!usados[mat[i][j]]) {
                    usados[mat[i][j]] = true;
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < usados.length; i++) {
            usados[i] = false;
        }
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (!usados[mat[j][i]]) {
                    usados[mat[j][i]] = true;
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < usados.length; i++) {
            usados[i] = false;
        }
        int valFila = mat.length / 3;
        int valCol = mat[0].length / 3;
        for (int i = 0; i < mat.length; i += valFila) {
            for (int j = 0; j < mat[0].length; j += valCol) {
                int x = 0;
                int y = 0;
                while (x < valFila) {
                    y=0;
                    while (y < valCol) {
                        if (!usados[mat[i + x][j + y]]) {
                            usados[mat[i + x][j + y]] = true;
                        } else {
                            return false;
                        }
                        y++;
                    }
                    x++;
                }

            }
        }
        return true;
    }

}
