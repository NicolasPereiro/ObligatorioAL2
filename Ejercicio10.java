import java.util.Scanner;

import tads.Pair;

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
        in.close();
        int k = largo / 3 * ancho / 3;
        int[][] res = sudoku(mat, k);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] sudoku(int[][] mat, int k) {
        Pair<Integer, Integer> lugarDe0 = buscarCero(mat);
        if (lugarDe0 == null) {
            return mat;
        }
        sudokuBT(mat, k, lugarDe0.fst, lugarDe0.snd);
        return mat;
    }

    private static Pair<Integer, Integer> buscarCero(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    Pair<Integer, Integer> lugar = new Pair<Integer, Integer>(i, j);
                    return lugar;
                }
            }
        }
        return null;
    } 

    private static boolean sudokuBT(int[][] mat, int k, int i, int j) {
        if (buscarCero(mat) == null) {
            return true;
        }
        for (int p = 1; p <= k; p++) {
            mat[i][j] = p;
            if (esViable(mat, k)) {
                Pair<Integer, Integer> lugarDe0 = buscarCero(mat);
                if(lugarDe0 == null){
                    return true;
                }
                if (sudokuBT(mat, k, lugarDe0.fst, lugarDe0.snd)) {
                    return true;
                }
            }
            mat[i][j]=0;
        }
        return false;
    }

    private static boolean esViable(int[][] mat, int k) {
        boolean[] usados = new boolean[k + 1];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    if (!usados[mat[i][j]]) {
                        usados[mat[i][j]] = true;
                    } else {
                        return false;
                    }
                }
            }
            for (int m = 0; m < usados.length; m++) {
                usados[m] = false;
            }
        }
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] != 0) {
                    if (!usados[mat[i][j]]) {
                        usados[mat[i][j]] = true;
                    } else {
                        return false;
                    }
                }
            }
            for (int m = 0; m < usados.length; m++) {
                usados[m] = false;
            }
        }

        int valFila = mat.length / 3;
        int valCol = mat[0].length / 3;
        for (int i = 0; i < mat.length; i += valFila) {
            for (int j = 0; j < mat[0].length; j += valCol) {
                int x = 0;
                int y = 0;
                while (x < valFila) {
                    y = 0;
                    while (y < valCol) {
                        if (mat[i + x][j + y] != 0) {
                            if (!usados[mat[i + x][j + y]]) {
                                usados[mat[i + x][j + y]] = true;
                            } else {
                                return false;
                            }
                        }
                        y++;
                    }
                    x++;
                }
                for (int m = 0; m < usados.length; m++) {
                    usados[m] = false;
                }
            }
        }
        return true;
    }
}
