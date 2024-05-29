package figuras;

import inteface.Calculable;

import java.awt.*;

public class Cilindro implements Calculable {

    private double raio;
    private double altura;

    public Cilindro (double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        Retangulo retangulo = new Retangulo (raio, altura);
        Circulo circulo = new Circulo(raio);
        double areaRet = retangulo.calcularArea();
        double areaCir= circulo.calcularArea();
        double area = areaRet * areaCir;

        return area;
    }

}
