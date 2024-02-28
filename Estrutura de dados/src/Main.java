import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var palindrome = true;

        Scanner input = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String texto = input.nextLine();

        while (palindrome) {
            List<String> textoDigitado = List.of(texto.split(""));
            List<String> textoContrario = List.of(texto.split("")).reversed();


            for (int i = 0; i < textoContrario.size(); i++) {
                if(!textoDigitado.get(i).equalsIgnoreCase(textoContrario.get(i))){
                    palindrome = false;
                }
            }

            if(palindrome){
                System.out.println("É palíndrome");
                break;
            }
            else{
                System.out.println("Não é palíndrome");
                break;
            }
        }
    }
}