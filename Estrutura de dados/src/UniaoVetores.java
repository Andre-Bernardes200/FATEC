import java.util.Arrays;
import java.util.Objects;

public class UniaoVetores {

    private int[] a = {20,30,40,50,1000,1000,1000,1000};
    private int[] b = {25,35,45,55};
    private int menor;

    public void vetUnido(){
        for (int i = 0; i < a.length; i++){
            menor = a[i];
            for(int n = 0; n < b.length; n++){
                int comparacao = b[n];
                if(menor > comparacao){
                    b[n] = menor;
                    menor = comparacao;
                }
                else {
                    menor = menor;
                }
            }
            a[i] = menor;
        }
        System.out.println(Arrays.toString(a).toString());
    }

    public static void main(String[] args){
        UniaoVetores unido = new UniaoVetores();

        unido.vetUnido();
    }
}
