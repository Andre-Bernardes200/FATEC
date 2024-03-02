import baralho.models.Baralho;
import baralho.models.Carta;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Baralho baralho = new Baralho();

        Carta[] cartas = baralho.getCartas();

        baralho.embaralhar(cartas);


        baralho.distribuirCarta(cartas);
        baralho.imprimirBaralho(cartas);

        System.out.println(baralho.hasCarta(cartas));
    }
}