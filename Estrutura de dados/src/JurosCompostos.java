import java.util.Scanner;

public class JurosCompostos {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        double valorFinal;

        System.out.print("Digite o valor do investimento: ");
        double investimento = input.nextDouble();

        System.out.print("Por quanto tempo em meses: ");
        int tempo = input.nextInt();

        System.out.print("Juros em %: ");
        double juros = input.nextDouble();

        valorFinal = investimento + (investimento*((Math.pow(1+ (juros/100),tempo))));

        System.out.print("Valor final : " + valorFinal);

    }
}
