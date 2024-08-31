import strategy.PagAVista;
import strategy.PagamentoStrategy;

public class Pessoa {

    private PagamentoStrategy pag;

    public Pessoa(PagamentoStrategy pagamentoStrategy) {
        this.pag = pagamentoStrategy;
    }

    public double efetuarPagamento(double valor) {
        return pag.pagar(valor);
    }

}
