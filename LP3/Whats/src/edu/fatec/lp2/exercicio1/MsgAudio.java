package edu.fatec.lp2.exercicio1;

public class MsgAudio extends Mensagem{
    private int duracao;

    public MsgAudio(Contatinho destinatario, String envio, String conteudo,int duracao){
        super(destinatario,envio,conteudo);
        this.duracao = duracao;
    }
}
