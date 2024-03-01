import baralho.models.Baralho;
import baralho.models.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Baralho baralho = new Baralho();

        List<Carta> cartas = new ArrayList<>();

        cartas = baralho.getCartas();

        baralho.embaralhar(cartas);
        baralho.imprimirBaralho(cartas);

        for( int i = 0; i < cartas.size(); i++){
            baralho.embaralhar(cartas);
            baralho.distribuirCarta(cartas);
        }

        baralho.imprimirBaralho(cartas);
    }
}