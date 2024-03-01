package baralho.models;

import java.util.*;

public class Baralho {

    private List<Carta> cartas = new ArrayList<>();

    public Baralho(){
        Nome[] listaNomes = Nome.values();
        Naipe[] listaNaipes = Naipe.values();
        for(int i = 0; i < 14; i++){
            for(int n = 0; n < 5; n++){
                if(listaNomes[i] != Nome.CORINGA && listaNaipes[n] != Naipe.CORINGA){
                    Carta carta = new Carta(listaNomes[i],listaNaipes[n]);
                    cartas.add(carta);
                }else if (listaNomes[i] == Nome.CORINGA && listaNaipes[n] == Naipe.CORINGA) {
                    for (int q = 0; q < 4; q ++){
                        Carta carta = new Carta(listaNomes[i],listaNaipes[n]);
                        cartas.add(carta);
                    }
                }
            }
        }
    }

    public List<Carta> getCartas (){
        return cartas;
    }

    public void embaralhar(List<Carta> baralho){
        int carta1;
        int carta2;
        Carta cartaSeguranca; // onde guarda a carta 1 na troca

        for(int i =0; i < 100;i++){
            carta1 = (int) (Math.random() * baralho.size());
            carta2 = (int) (Math.random() * baralho.size());

            cartaSeguranca = baralho.get(carta1);

            baralho.set(carta1,baralho.get(carta2));
            baralho.set(carta2,cartaSeguranca);

        }
    }

    public void imprimirBaralho(List<Carta> baralho){
        for(int i =0; i < baralho.size(); i++){
            if(Objects.isNull(baralho.get(i))){
                System.out.println("null, null");
            }else {
                System.out.println(baralho.get(i).getNome() + ", " + baralho.get(i).getNaipe());
            }
        }
        System.out.println("\n\n");
    }

    public Optional<Carta> distribuirCarta(List<Carta> baralho){

        int indiceTroca = baralho.size()-1;

        Optional<Carta> carta = Optional.of(baralho.get(indiceTroca));

        if (carta.isPresent()){
            baralho.set(indiceTroca,null);
            return carta;
        }else {
            return null;
        }
    }

    public boolean hasCarta(List<Carta> baralho){

        Optional<List<Carta>> cartas = Optional.of(baralho);

        if (cartas.isPresent()){
            return true;
        }else {
            return false;
        }
    }
}
