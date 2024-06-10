package ordernacao;

public class Merge {

    public int[] mergeSort(int comeco, int fim, int[] lista) {
        if (comeco < fim-1) {
            int meio = (comeco + fim) / 2;
            mergeSort(comeco, meio, lista);
            mergeSort(meio, fim, lista);
            intercala(comeco, meio, fim, lista);
        }
        return lista;
    }

    private int[] intercala (int comeco,int meio, int fim, int[] lista){
        int i = comeco;
        int j = meio;

        if(lista[meio-1]<=lista[meio]){
            return lista;
        }

        while(i < meio && j <fim){
            if(lista[i]<lista[j]){
                i++;
            }else{
                int temp = lista[j];
                for(int k = j; k > i; k--){
                    lista[k]=lista[k-1];
                }
                lista[i]=temp;

                i++;
                j++;
                meio++;
            }
        }
        return lista;
    }

}
