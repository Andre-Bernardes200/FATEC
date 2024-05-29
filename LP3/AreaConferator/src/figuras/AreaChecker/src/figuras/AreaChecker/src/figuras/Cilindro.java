package figuras.AreaChecker.src.figuras.AreaChecker.src.figuras;

import figuras.AreaChecker.src.figuras.AreaChecker.src.inteface.Calculable;

public class Cilindro implements Calculable {

    private double raio;
    private double altura;

    public Cilindro (double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        Retangulo retangulo = new Retangulo(raio, altura);
        Circulo circulo = new Circulo(raio);
        double areaRet = retangulo.calcularArea();
        double areaCir= circulo.calcularArea();
        double area = areaRet * areaCir;

        return area;
    }

}
