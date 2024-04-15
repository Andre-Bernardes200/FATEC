import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Primos {

    public static void main(String[] args){

        List<Integer> vetorNum = new ArrayList<>();

        List<Integer> vetorPrimos = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            vetorNum.add(i);
        }

        for(int n = 0; n < vetorNum.size(); n++){
            int qtd = 0;
            int divisao = 1;
            while(divisao <= vetorNum.get(n)){
                if(vetorNum.get(n) % divisao == 0){
                    qtd += 1;
                }
                divisao++;
            }
            if(qtd == 2 || qtd == 1){
                vetorPrimos.add(vetorNum.get(n));
            }
        }
        System.out.println(String.valueOf(vetorPrimos));
    }

}
