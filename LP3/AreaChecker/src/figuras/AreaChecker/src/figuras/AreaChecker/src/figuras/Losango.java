package figuras.AreaChecker.src.figuras.AreaChecker.src.figuras;

import figuras.AreaChecker.src.figuras.AreaChecker.src.inteface.Calculable;

public class Losango implements Calculable {

    private double baseMaior;
    private double baseMenor;

    public Losango(double maior, double menor){
        this.baseMaior = maior;
        this.baseMenor = menor;
    }

    @Override
    public double calcularArea(){
        Triangulo losango = new Triangulo(baseMaior,baseMenor);
        return losango.calcularArea();
    }
}
