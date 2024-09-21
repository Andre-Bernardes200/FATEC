import singleton.ConexaoDB;

public class Main {
    public static void main(String[] args) {

        ConexaoDB con1 = ConexaoDB.getInstance();
        ConexaoDB con2 = ConexaoDB.getInstance();


        con1.getConexao();

        if(con1.equals(con2)){
            System.out.println("São as mesmas conexões");
        }else{
            System.out.println("São conexões diferentes");
        }
    }
}