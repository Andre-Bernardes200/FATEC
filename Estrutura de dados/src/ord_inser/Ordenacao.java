package ord_inser;

public class Ordenacao {

    public int[] ordena(){
        int[] fila = new int[]{50, 54, 82, 62, 74, 99, 61, 52, 64, 89, 58};

        int maior = 0;
        int qtdFila = fila.length - 1;

        for (int i = qtdFila; i > 0 ; i--) {
            int j;
            for (j = 0; j <= i; j++) {
                if (fila[j] > fila[maior]) {
                    maior = j;
                }
            }
                int troca = fila[maior];
                fila[maior] = fila[j-1];
                fila[j-1] = troca;
                maior = 0;
        }
        return fila;
    }

}
