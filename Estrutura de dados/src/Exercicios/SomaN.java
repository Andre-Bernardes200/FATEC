public class SomaN {

    private static int num;

    public static int somaN(int n) {
        if (n == 0){
            return n;
        }else{
            num = n + somaN(n-1);
            return num;
        }
    }

    public static void main(String[] args){
        System.out.println(somaN(5));
    }
}
