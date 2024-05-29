package figuras;

import inteface.Calculable;

public class Prisma implements Calculable {

    private double altura;
    private double largura;
    private double base;

    public Prisma(double altura, double base, double lagura){
        this.altura = altura;
        this.base = base;
        this.largura = largura;
    }


    @Override
    public double calcularArea() {
        Retangulo retangulo = new Retangulo(largura, base);
        double areaRet = 2 * retangulo.calcularArea();

        retangulo = new Retangulo(altura, base);
        double areaRetFace1 = retangulo.calcularArea();

        retangulo = new Retangulo(altura, largura);
        double areaRetFace2 = retangulo.calcularArea();

        double areaDobrada = 2 * areaRetFace1 + 2 * areaRetFace2;

        double areaTotal = areaRet + areaDobrada;

        return areaTotal;
    }


}
