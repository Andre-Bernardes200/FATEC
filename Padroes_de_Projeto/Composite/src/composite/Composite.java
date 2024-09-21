package composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component{
    private String nome;

    private List<Component> components = new ArrayList<>();

    public Composite (String nome){
        this.nome = nome;
    }

    public void addComponent (Component component){
        components.add(component);
        System.out.println("Componente adicionado");
    }

    public void removeComponent (Component component){
        components.remove(component);
        System.out.println("Component removido");
    }

    @Override
    public void execute(){
        System.out.println("Composite: " + nome);
        for (Component com : components){
            com.execute();
        }
    }
}
