package figuras.AreaChecker.src.figuras;

import figuras.AreaChecker.src.inteface.Calculable;

public class Piramide implements Calculable {

    private double base;
    private double altura;
    private int qtdLados;

    public Piramide(double base, double altura, int qtdLados) {
        this.base = base;
        this.altura = altura;
        this.qtdLados = qtdLados;
    }

    @Override
    public double calcularArea() {
        Triangulo triangulo = new Triangulo(base, altura);
        double areaTriangulo = triangulo.calcularArea();
        double areaFaceTotal = areaTriangulo * qtdLados;

        Quadrado quadrado = new Quadrado(base);
        double areaQuadrado = quadrado.calcularArea();
        double area = areaQuadrado * areaFaceTotal;
        return area;
    }
}
