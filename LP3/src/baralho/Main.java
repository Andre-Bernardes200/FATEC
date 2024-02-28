package baralho;

import baralho.models.Baralho;
import baralho.models.Naipe;
import baralho.models.Nome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Baralho baralho = new Baralho();
        baralho.getCartas().stream()
                .forEach(c -> System.out.println(c.getNome() + "," + c.getNaipe()));
    }
}
