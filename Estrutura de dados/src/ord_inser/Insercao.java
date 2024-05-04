package ord_inser;

public class Insercao {
    public int[] insere(){
        int[] fila = new int[]{50, 54, 82, 62, 74, 99, 61, 52, 64, 89, 58};

        int qtdFila = fila.length - 1;

        for (int i = 0; i <= qtdFila ; i++) {
            int j;
            int troca = 0;
            int k = i;

            for (j = i-1; j >= 0; j--) {
                if (fila[k] < fila[j]) {
                    troca = fila[k];
                    fila[k] = fila[j];
                }if(troca > fila[j]){
                    fila[k] = troca;
                    troca = 0;
                }
                if(troca > 0){
                    fila[k] = fila[j];
                    k--;
                }
            }
        }
        return fila;
    }
}
