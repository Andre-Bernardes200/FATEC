package baralho.models;

public class Carta {

    private Nome nome;

    private Naipe naipe;

    public Carta(Nome nome, Naipe naipe) {
        this.nome = nome;
        this.naipe = naipe;
    }

    public Nome getNome(){
        return nome;
    }

    public Naipe getNaipe(){
        return naipe;
    }
}
