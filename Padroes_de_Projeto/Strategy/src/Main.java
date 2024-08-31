import strategy.PagAPrazo;
import strategy.PagAVista;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Pessoa pessoaPagAVista = new Pessoa(new PagAVista());

        System.out.println("Valor final com desconto R$ " + pessoaPagAVista.efetuarPagamento(1000));

        Pessoa pessoaPagAPrazo= new Pessoa(new PagAPrazo());

        System.out.println("Valor final com juros R$ " + pessoaPagAPrazo.efetuarPagamento(1000));

        }
    }
