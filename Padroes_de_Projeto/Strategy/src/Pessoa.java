import strategy.PagAVista;
import strategy.PagamentoStrategy;

public class Pessoa {

    private PagamentoStrategy pag;

    public double efetuarPagamento(double valor) {
        return pag.pagar(valor);
    }

    public void setPagamento(PagamentoStrategy pagamento) {
        this.pag = pagamento;
    }

}
