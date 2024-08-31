package observer;

import javax.security.auth.Subject;

public class Itau implements BancObserver {

    private double valorAtual = 0;

    @Override
    public double deposito(double valor) {
        return valorAtual +=  valor;
    }
    @Override
    public double getValorAtual() {
        return valorAtual;
    }

    @Override
    public String getNome(){
        return "Itau";
    }
}
