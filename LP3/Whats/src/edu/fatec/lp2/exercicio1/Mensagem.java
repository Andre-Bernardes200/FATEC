package edu.fatec.lp2.exercicio1;

import java.util.List;

public abstract class Mensagem{

    private Contatinho destinatario;
    private String horaEnvio;
    private String conteudo;

    public Mensagem (Contatinho destinatario, String envio, String conteudo){
        this.destinatario = destinatario;
        this.horaEnvio = envio;
        this.conteudo = conteudo;
    }

    @Override
    public String toString(){
        String mensagem =  """
                Destinatário: %s
                Hora do envio: %s
                Conteúdo: %s""".formatted(destinatario,horaEnvio,conteudo);
        return mensagem;
    }

    abstract Mensagem sendMenssage(String mensagem);
}
