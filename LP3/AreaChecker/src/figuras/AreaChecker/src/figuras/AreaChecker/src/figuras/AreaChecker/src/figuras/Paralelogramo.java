package figuras.AreaChecker.src.figuras.AreaChecker.src.figuras.AreaChecker.src.figuras;

import figuras.AreaChecker.src.figuras.AreaChecker.src.figuras.AreaChecker.src.inteface.Calculable;

public class Paralelogramo implements Calculable {

    private double base;
    private double altura;

    public Paralelogramo(double base, double altura){
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double calcularArea() {
        Retangulo paralelogramo = new Retangulo(this.base,this.altura);
        return paralelogramo.calcularArea();
    }
}
