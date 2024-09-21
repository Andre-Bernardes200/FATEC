package composite;

public class Motor implements Component {
    private String name;

    public Motor (String name){
        this.name = name;
    }

    @Override
    public void execute (){
        System.out.println("Nome: " + name);
    }
}
