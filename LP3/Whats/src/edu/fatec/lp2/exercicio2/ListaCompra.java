package edu.fatec.lp2.exercicio2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaCompra implements Calculavel{

    private ItemCompra[] itensCompra;
    private int qtdMax;

    public ListaCompra(int qtdMax) {
        this.qtdMax = qtdMax;
    }

    public void incluir(ItemCompra item) {
        int qtd = itensCompra.length;
        if(qtd < qtdMax) {
            itensCompra[qtd] = item;
        }
        else {
            System.out.print("Erro ao incluir o item de compra, passou a quantidade máxima");
        }
    }

    @Override
    public double calcularPreco() {

        int qtd = itensCompra.length;
        double valor = 0;
        for (int i = 0; i < qtd; i++) {
            valor =+ itensCompra[i].getProduto().getPreco() * itensCompra[i].getQuantidade();
        }

        return valor;
    }

}
