package figuras;

import inteface.Calculable;

public class Quadrado implements Calculable {

    private double lado;

    public Quadrado(double lado){
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return this.lado * this.lado;
    }
}
