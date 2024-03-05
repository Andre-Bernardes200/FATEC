public class rec {

    public static int rec(int x){
        if ((x == 0) || (x == 1)) return x;
        else return rec(x - 1) * x + rec(x - 2);
    }

    public static void main (String[] args){
        System.out.println(rec(6));
    }
}
