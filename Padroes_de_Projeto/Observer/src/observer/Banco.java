package observer;

import java.util.ArrayList;
import java.util.List;

public class Banco{

    private double valorDeposito;

    private List<BancObserver> listaObserver = new ArrayList();

    public void addOb(BancObserver ob){
        listaObserver.add(ob);
    }

    public void deposito(double valor){
        for(BancObserver ob : listaObserver){
            ob.deposito(valor);
        }
    }

    public void valorAtual(){
        for (BancObserver ob : listaObserver) {
            System.out.println("Saldo atual do " + ob.getNome() + " R$ " + ob.getValorAtual());
        }
    }
}
