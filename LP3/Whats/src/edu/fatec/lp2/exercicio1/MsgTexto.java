package edu.fatec.lp2.exercicio1;

public class MsgTexto extends Mensagem {

    private int numChar;

    public MsgTexto (Contatinho destinatario,String envio, String conteudo, int numChar){
        super(destinatario,envio,conteudo);
        this.numChar = numChar;
    }
}
