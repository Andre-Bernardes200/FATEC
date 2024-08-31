package observer;

import java.util.Observable;
import java.util.Observer;

public class Santander implements BancObserver {

    private double valorAtual = 0;

    @Override
    public double deposito(double valor) {
        return valorAtual += valor;
    }

    @Override
    public double getValorAtual() {
        return valorAtual;
    }

    @Override
    public String getNome(){
        return "Santander";
    }
}
