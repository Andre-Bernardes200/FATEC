package figuras;

import inteface.Calculable;

public class Hexagono implements Calculable {

    private double lado;

    public Hexagono(double lado){
        this.lado = lado;
    }

    @Override
    public double calcularArea(){
        return (3 * Math.sqrt(3)*(lado * lado))/2;
    }
}
