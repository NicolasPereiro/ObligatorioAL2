package tads.table;

public class ParBorrado<T1,T2>{
    public T1 fst;
    public T2 snd;
    public boolean borrado = false; 
    public ParBorrado() {
    }
  
    public ParBorrado(T1 fst) {
      this.fst = fst;
    }
  
    public ParBorrado(T1 fst, T2 snd) {
      this.fst = fst;
      this.snd = snd;
    }
}
