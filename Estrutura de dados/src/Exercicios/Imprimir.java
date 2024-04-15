public class Imprimir {

    public static int imprimir(int i){
        System.out.println(i);
        if(i == 1){
            System.out.println(i);
            return i+1;
        }else{
            imprimir(i-1);
            System.out.println(i);
            return i;
        }
    }

    public static void main(String[] args){

        imprimir(6);

    }

}
