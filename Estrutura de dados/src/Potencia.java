public class Potencia {

    public static int potencia (int base, int elevar){
        if(elevar == 0){
            return 1;
        }else{
            return potencia(base, elevar-1) * base;
        }
    }

    public static void main(String[] args){
        System.out.println(potencia(2,5));
    }

}
