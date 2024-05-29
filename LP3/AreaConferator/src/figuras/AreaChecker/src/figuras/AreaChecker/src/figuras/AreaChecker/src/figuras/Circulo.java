package figuras.AreaChecker.src.figuras.AreaChecker.src.figuras.AreaChecker.src.figuras;

import figuras.AreaChecker.src.figuras.AreaChecker.src.figuras.AreaChecker.src.inteface.Calculable;

public class Circulo implements Calculable {

    private double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    @Override
    public double calcularArea(){
        return Math.PI * (raio * raio);
    }
}
