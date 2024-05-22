package edu.fatec.lp2.exercicio1;

public class MsgFoto extends Mensagem{
    private int tamanho;

    public MsgFoto(Contatinho destinatario, String envio, String conteudo, int tamanho){
        super(destinatario,envio,conteudo);
        this.tamanho = tamanho;
    }

    @Override
    Mensagem sendMenssage(String mensagem) {
        return this;
    }
}
