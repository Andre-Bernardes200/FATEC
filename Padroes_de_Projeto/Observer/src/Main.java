import observer.Banco;
import observer.Itau;
import observer.Santander;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();

        banco.addOb(new Itau());

        banco.deposito(100);

        banco.addOb(new Santander());

        banco.deposito(200);

        banco.valorAtual();
    }
}