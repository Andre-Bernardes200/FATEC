package ordernacao;

public class Insercao {
    public int[] ordena(int[] fila){
        int qtdFila = fila.length - 1;

        for (int i = 0; i <= qtdFila ; i++) {
            int comparacao = fila[i];
            int j = i -1;

            while (j >=0 && fila[j] > comparacao){
                fila[j+1] = fila[j];
                j--;
            }
            fila[j+1] = comparacao;
        }
        return fila;
    }

}
