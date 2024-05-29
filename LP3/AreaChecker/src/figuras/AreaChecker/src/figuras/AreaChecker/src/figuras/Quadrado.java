package figuras.AreaChecker.src.figuras.AreaChecker.src.figuras;

import figuras.AreaChecker.src.figuras.AreaChecker.src.inteface.Calculable;

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
