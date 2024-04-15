public class MaiorSequencia {

    public static void main(String[] args){

        int[] vet = {7,3,5,8,10,2,20,30,40,50,60,4,5};
        int maiorSequencia = 1;
        int sequencia = 1;

        for(int i =0; i < vet.length; i++){
            if(i+1 == vet.length){
                if(sequencia > maiorSequencia){
                    maiorSequencia = sequencia;
                }
                break;
            }
            if(vet[i] < vet[i+1]){
                sequencia += 1;
            }else{
                if(sequencia > maiorSequencia){
                    maiorSequencia = sequencia;
                    sequencia = 1;
                }
            }
        }
        System.out.println(maiorSequencia);
    }
}
