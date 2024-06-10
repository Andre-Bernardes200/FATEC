package ordernacao;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] fila = new int[]{50, 54, 82, 62, 74, 58, 61, 52, 64, 89, 44};

//        Ordenacao ordenacao = new Ordenacao();
//
//        System.out.print(Arrays.toString(ordenacao.ordena()));

        Insercao insercao = new Insercao();
        Shell shel = new Shell();
        Quick quick = new Quick();
        Merge merge = new Merge();

        System.out.print(Arrays.toString(merge.mergeSort(0,fila.length,fila)));
    }
}