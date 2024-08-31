package strategy;

public class PagAVista implements PagamentoStrategy {

    @Override
    public double pagar(double valor){
        return valor * 0.85;
    }
}
