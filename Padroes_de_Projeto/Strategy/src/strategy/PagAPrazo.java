package strategy;

public class PagAPrazo implements PagamentoStrategy {

    @Override
    public double pagar(double pagar){
        return pagar * 1.15;
    }
}
