public class Binario {

    public static String binario(int numero){
        if(numero == 0){
            return String.valueOf(0);
        }else{
            String x = "";
            x += binario((numero / 2));
            return x;
        }
    }

    public static void main(String [] args){
        System.out.println("1" + binario(39));
    }
}
