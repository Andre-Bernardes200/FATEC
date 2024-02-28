package baralho.models;

import java.util.ArrayList;
import java.util.List;

public class Baralho {

    private List<Carta> cartas = new ArrayList<>();

    public Baralho(){
        Nome[] listaNomes = Nome.values();
        Naipe[] listaNaipes = Naipe.values();
        for(int i = 0; i < 14; i++){
            for(int n = 0; n < 5; n++){
                if(listaNomes[i] != Nome.CORINGA && listaNaipes[n] != Naipe.CORINGA){
                    Carta carta = new Carta(listaNomes[n],listaNaipes[i]);
                    cartas.add(carta);
                }else if (listaNomes[i] == Nome.CORINGA && listaNaipes[n] == Naipe.CORINGA) {
                    Carta carta = new Carta(listaNomes[i],listaNaipes[n]);

                    cartas.add(carta);
                }
            }
        }
    }

    public List<Carta> getCartas (){
        return cartas;
    }
}
