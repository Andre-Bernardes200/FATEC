package singleton;

public class ConexaoDB {
    private static ConexaoDB con;

    private ConexaoDB (){}

    public static ConexaoDB getInstance(){
        if(con == null){
            con = new ConexaoDB();
        }
        return con;
    }

    public void getConexao(){
        System.out.println("Iniciando conexão com o banco de dados...");
    }

}
