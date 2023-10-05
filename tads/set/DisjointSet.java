package tads.set;

public class DisjointSet {
    int[] conjunto;
    int[] rank;

    public DisjointSet(int size){
        conjunto = new int[size];
        rank = new int[size];
        for(int i = 0; i < size; i++){
            conjunto[i] = i;
        }
    }

    public int buscar(int x){
        if(conjunto[x] == x)return x;
        int padre = buscar(x);
        conjunto[x] = padre;
        return padre;
    }

    public void unir(int x, int y){
        int repX = buscar(x);
        int repY = buscar(y);
        if(repX != repY){
            int rankX = rank[repX];
            int rankY = rank[repY];
            if(rankX < rankY){
                conjunto[repX] = repY;
            } else if (rankX > rankY){
                conjunto[repY] = repX;
            } else {
                conjunto[repY] = repX;
                rank[repX]++;
            }
        }
    }
}
