package Exercicios;


public class NumInvertido {

    private static int[] vetor = {1,2,3,4,5};

    private static int soma = 0;
    private static int n = 0;


    public static int soma(int[] num){
        if(num.length == 1){
            return num[0];
        }else{
            soma = vetor[n] + soma(num);
            return soma;
        }
    }

    public static void main(String[] args){
        System.out.println(soma(vetor));
    }

}
