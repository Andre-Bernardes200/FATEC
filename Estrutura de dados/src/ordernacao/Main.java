package ordernacao;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] fila = new int[]{50, 54, 82, 62, 74, 99, 61, 52, 64, 89, 58};

//        Ordenacao ordenacao = new Ordenacao();
//
//        System.out.print(Arrays.toString(ordenacao.ordena()));

        Insercao insercao = new Insercao();
        Shell shel = new Shell();

        System.out.print(Arrays.toString(shel.shellSort(fila)));
    }
}