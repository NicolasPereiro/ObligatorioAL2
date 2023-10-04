package objetos;

public class Bomba implements Comparable<Bomba>{
    public String fst;
    public int snd;

    public Bomba(String s, int x){
        this.fst = s;
        this.snd = x;
    }

    @Override
    public int compareTo(Bomba b) {
        if(this.snd > b.snd)return 1;
        else if (this.snd < b.snd) return -1;
        else if (this.fst.compareTo(b.fst) > 0) return 1;
        else return -1;
    }
    
}
