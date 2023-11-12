import java.util.Scanner;

public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int capacidad = in.nextInt();
        int year = in.nextInt();
        int cantJuegos = in.nextInt();
        int[][] juegos = new int[cantJuegos][2];
        in.nextLine();
        for (int i = 0; i < cantJuegos; i++) {
            String[] entrada = in.nextLine().split(" ");
            int yeardif = year - Integer.parseInt(entrada[3]);
            int popularidad = Integer.parseInt(entrada[2]) - yeardif * 5;
            if (popularidad < 0) {
                popularidad = 0;
            }
            juegos[i][0] = Integer.parseInt(entrada[1]);
            juegos[i][1] = popularidad;
        }
        in.close();
        int res = tabSolucion(capacidad, juegos);
        System.out.println(res);
    }

    private static int tabSolucion(int capacidad, int[][] juegos) {
        int[][] tab = new int[juegos.length + 1][capacidad + 1];
        for (int c = 0; c <= capacidad; c++) {
            for (int i = 1; i < tab.length; i++) {
                if (juegos[i - 1][0] > c){
                    tab[i][c] = tab[i-1][c];
                } else {
                    tab[i][c] = max(tab[i-1][c], juegos[i-1][1] + tab[i-1][c - juegos[i-1][0]]);
                }
            }
        }
        return tab[juegos.length][capacidad];
    }

    private static int max(int a, int b) {
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }
}
