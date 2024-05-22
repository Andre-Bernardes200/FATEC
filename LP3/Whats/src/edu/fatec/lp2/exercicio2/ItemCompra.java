package edu.fatec.lp2.exercicio2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemCompra implements Calculavel {

    private int quantidade;
    private Produto produto;
    private double desconto;

    public ItemCompra(Produto produto, double desconto) {
        this.produto = produto;
        this.desconto = desconto;
    }


    @Override
    public double calcularPreco(){
        double valor = (quantidade * produto.getPreco()) - desconto ;
        return valor;
    }
}
