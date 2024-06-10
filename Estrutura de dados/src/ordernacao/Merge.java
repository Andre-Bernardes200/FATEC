package ordernacao;

public class Merge {

    public int[] mergeSort(int comeco, int fim, int[] lista) {
        if (comeco < fim -1) {
            int meio = (comeco + fim) / 2;
            mergeSort(comeco, meio, lista);
            mergeSort(meio, fim, lista);
            intercala(comeco, meio, fim, lista);
        }
        return lista;
    }

    private int[] intercala(int comeco, int meio, int fim, int[] lista) {
        int i = comeco;
        int j = meio;

        // Criar uma lista temporária para armazenar a intercalação
        int[] temp = new int[fim - comeco];
        int k = 0;

        // Verificar se as duas partes a serem intercaladas estão ordenadas
        if (lista[meio - 1] <= lista[meio]) {
            return lista;
        }

        // Intercalar os elementos das duas partes
        while (i < meio && j < fim) {
            if (lista[i] < lista[j]) {
                temp[k++] = lista[i++];
            } else {
                temp[k++] = lista[j++];
            }
        }

        // Copiar os elementos restantes da primeira parte, se houver
        while (i < meio) {
            temp[k++] = lista[i++];
        }

        // Copiar os elementos restantes da segunda parte, se houver
        while (j < fim) {
            temp[k++] = lista[j++];
        }

        // Copiar os elementos intercalados de volta para a lista original
        for (int index = 0; index < k; index++) {
            lista[comeco + index] = temp[index];
        }

        return lista;
    }

}
