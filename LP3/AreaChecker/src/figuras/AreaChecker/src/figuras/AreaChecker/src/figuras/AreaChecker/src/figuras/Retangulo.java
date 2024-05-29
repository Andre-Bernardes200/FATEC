package figuras.AreaChecker.src.figuras.AreaChecker.src.figuras.AreaChecker.src.figuras;

import figuras.AreaChecker.src.figuras.AreaChecker.src.figuras.AreaChecker.src.inteface.Calculable;

public class  Retangulo implements Calculable {

    private double base;
    private double altura;

    public Retangulo (double base, double altura){
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double calcularArea(){
        return base * altura;
    }
}
