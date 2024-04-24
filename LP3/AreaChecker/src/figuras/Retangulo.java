package figuras;

import inteface.Calculable;

public class Retangulo implements Calculable {

    private double base;
    private double altura;

    public Retangulo (double base, double altura){
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double calcularArea(){
        return base * altura;
    }
}
