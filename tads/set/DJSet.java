package tads.set;

public class DJSet {
    private int[] parent;
    private int[] rank;
    
    public DJSet(int expectedSize){
        this.parent = new int[expectedSize+1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        this.rank = new int[expectedSize+1];
        for (int i = 1; i < rank.length; i++) {
            rank[i] = 0;
        }
    }

    public int find(int x){
        if(parent[x] == x)return x;
        int aux = find(parent[x]);
        parent[x] = aux;
        return parent[x];
    }

    public void union(int a, int b){
        if(find(a) == find(b))return;
        int padreA = find(a);
        int padreB = find(b);
        if(rank[padreA] > rank[padreB]){
            parent[padreB] = padreA;
        } else if (rank[padreA] < rank[padreB]){
            parent[padreA] = padreB;
        } else {
            parent[padreB] = padreA;
            rank[padreA]++;
        }
    }


}
