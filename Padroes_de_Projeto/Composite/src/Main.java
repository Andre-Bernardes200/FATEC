import composite.Composite;
import composite.Motor;

public class Main {
    public static void main(String[] args) {

        Motor mt1 = new Motor("V8");
        Motor mt2 = new Motor("V9");
        Motor mt3 = new Motor("V10");
        Motor mt4 = new Motor("V11");


        Composite com1 = new Composite("GM");
        Composite com2 = new Composite ("Ford");

        com1.addComponent(mt1);
        com1.addComponent(mt3);

        com2.addComponent(mt2);
        com2.addComponent(mt4);

        com1.execute();
        com2.execute();


    }
}