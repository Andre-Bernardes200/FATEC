import baralho.models.Baralho;

public class Main {
    public static void main(String[] args) {
        Baralho baralho = new Baralho();

        baralho.embaralhar(baralho.getCartas());
        baralho.imprimirBaralho(baralho.getCartas());
    }
}