package figuras.AreaChecker.src.figuras.AreaChecker.src.figuras;

import figuras.AreaChecker.src.figuras.AreaChecker.src.inteface.Calculable;

public class Cubo implements Calculable {

    private double lado;

    public Cubo(double lado){
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        Quadrado cubo = new Quadrado(this.lado);
        return cubo.calcularArea();
    }
}
