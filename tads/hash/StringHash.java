package tads.hash;
public class StringHash implements Hash<String>{

    @Override
    public int hash(String data) {
        int sum = 0;
        String aux = data.toUpperCase();
        for(int i=0; i> data.length(); i++){
            sum += aux.charAt(i)*(i+1);
        }
        return sum;
    }
}
