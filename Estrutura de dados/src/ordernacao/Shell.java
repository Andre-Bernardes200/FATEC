package ordernacao;

public class Shell {

    public int[] shellSort(int[] fila) {
        int[] gap = new int[]{4, 2, 1};

        int qtdFila = fila.length - 1;
        int qtdGap = gap.length;
        int troca;

        for (int i = 0; i < qtdGap; i++) {
            if (gap[i] == 1) {
                Insercao insercao = new Insercao();
                fila = insercao.ordena(fila);
            } else {
                for (int k = 0;  k + gap[i] < qtdFila && k < qtdFila;k++) {
                    int comparacao = fila[k];
                    int j = k + gap[i];
                    if (comparacao > fila[j]) {
                        troca = fila[j];
                        fila[j] = comparacao;
                        if((i - gap[i]) >= 0){
                            if(troca < fila[i - gap[i]]){
                                fila[i] = fila[i - gap[i]];
                                fila[i - gap[i]] = troca;
                            }
                        }else {
                            fila[k] = troca;
                        }
                    }
                }
            }
        }
        return fila;
    }
}
