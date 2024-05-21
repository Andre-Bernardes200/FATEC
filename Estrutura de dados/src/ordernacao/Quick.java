package ordernacao;

import java.util.List;

public class Quick {

    public int[] quickSort(int[] lista,int esquerda, int direita){
        if(lista.length > 1){
            int indiceAtual = particiona(lista,esquerda,direita);
            if(esquerda < indiceAtual -1){
                quickSort(lista,esquerda,indiceAtual -1);
            }
            if(indiceAtual < direita){
                quickSort(lista,indiceAtual,direita);
            }
        }
        return lista;
    }

    public int particiona (int[] lista, int esquerda, int direita){
        int pivo = lista[(Math.abs(esquerda + direita) /2)];
        int atualEsq = esquerda;
        int atualDir = direita;

        while (atualEsq <= atualDir) {
            if (lista[atualEsq] < pivo) {
                atualEsq++;
                continue;
            }
            if (lista[atualDir] > pivo) {
                atualDir--;
            }
            else {
                trocaLugar(lista, atualEsq, atualDir);
                atualEsq++;
                atualDir--;
            }
        }
        return atualEsq;
    }

    public void trocaLugar(int[] lista, int esquerda, int direita){
        int numEsq = lista[esquerda];
        int numDir = lista[direita];

        lista[direita] = numEsq;
        lista[esquerda] = numDir;
    }
}
