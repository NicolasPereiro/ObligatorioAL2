package tads.hash;

public class IntHash implements Hash<Integer>{

    @Override
    public int hash(Integer data) {
        return (int)data;
    }

    public IntHash(){}
    
}
