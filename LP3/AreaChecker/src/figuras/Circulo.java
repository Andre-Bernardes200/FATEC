package figuras;

import inteface.Calculable;

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