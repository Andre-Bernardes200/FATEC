import enums.Figuras;
import figuras.Quadrado;
import inteface.Calculable;

public class Main {
    public static void main(String[] args) {

        Factory.factory(Figuras.QUADRADO,1);

    }
}