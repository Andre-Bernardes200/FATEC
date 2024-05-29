package figuras.AreaChecker.src.figuras.AreaChecker.src.figuras.AreaChecker.src.figuras;

import figuras.AreaChecker.src.figuras.AreaChecker.src.figuras.AreaChecker.src.inteface.Calculable;

public class Triangulo implements Calculable {

    private double base;
    private double altura;

    public Triangulo(double base, double altura){
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double calcularArea(){
        return (this.base * this.altura) / 2;
    }
}
