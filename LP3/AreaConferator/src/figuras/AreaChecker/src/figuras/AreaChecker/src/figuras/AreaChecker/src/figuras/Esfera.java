package figuras.AreaChecker.src.figuras.AreaChecker.src.figuras.AreaChecker.src.figuras;

import figuras.AreaChecker.src.figuras.AreaChecker.src.figuras.AreaChecker.src.inteface.Calculable;

public class Esfera implements Calculable {

    private double raio;

    public Esfera(double raio){
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        Circulo circulo = new Circulo(raio);
        double areaCirc = circulo.calcularArea();
        double area = 4 * areaCirc;
        return area;
    }
}