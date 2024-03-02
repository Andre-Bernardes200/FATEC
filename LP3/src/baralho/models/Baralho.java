package baralho.models;

import java.util.*;

public class Baralho {

    private Carta[] cartas = new Carta[56];

    public Baralho(){
        Nome[] listaNomes = Nome.values();
        Naipe[] listaNaipes = Naipe.values();
        int i = 0;
        while (i < 56){
            for(int no = 0; no < listaNomes.length; no++){
                for(int na = 0; na < listaNaipes.length; na++){
                    if(listaNomes[no] != Nome.CORINGA && listaNaipes[na] != Naipe.CORINGA){
                        Carta carta = new Carta(listaNomes[no], listaNaipes[na]);
                        cartas[i] = carta;
                        i++;
                    }else if(listaNomes[no] == Nome.CORINGA && listaNaipes[na] == Naipe.CORINGA){
                        for(int c = 0; c < 4; c++){
                            Carta carta = new Carta(listaNomes[no], listaNaipes[na]);
                            cartas[i] = carta;
                            i++;
                        }
                    }
                }
            }
        }
    }

    public Carta[] getCartas (){
        return cartas;
    }

    public void embaralhar(Carta[] baralho){
        int carta1;
        int carta2;
        Carta cartaSeguranca; // onde guarda a carta 1 na troca

        for(int i =0; i < 100;i++){
            carta1 = (int) (Math.random() * baralho.length);
            carta2 = (int) (Math.random() * baralho.length);

            cartaSeguranca = baralho[carta1];


            baralho[carta1] = baralho[carta2];
            baralho[carta2] = cartaSeguranca;

        }
    }

    public void imprimirBaralho(Carta[] baralho){
        for(int i =0; i < baralho.length; i++){
            if(Objects.isNull(baralho[i])){
                System.out.println("null, null");
            }else {
                System.out.println(baralho[i].getNome() + ", " + baralho[i].getNaipe());
            }
        }
        System.out.println("\n\n");
    }

    public Carta distribuirCarta(Carta[] baralho){

        int i = 1;
        Carta carta = null;
        int tamanho = baralho.length;;

        while (true){
            if(baralho[tamanho -i] == null && i <= 56){
                i++;
            }else {
                carta = baralho[tamanho- i];
                baralho[tamanho-i] = null;
                return carta;
            }
            if(i > 56){
                return null;
            }
        }
    }

    public boolean hasCarta(Carta[] baralho){

        while (true){
            for(int i = 0; i < baralho.length; i++){
                if(!(baralho[i] == null)){
                    return true;
                }
                if(i == 55){
                    return false;
                }
            }
        }

    }
}
