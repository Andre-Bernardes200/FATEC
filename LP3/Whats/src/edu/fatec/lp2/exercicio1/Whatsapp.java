package edu.fatec.lp2.exercicio1;

import java.util.List;

public class Whatsapp {

    List<Contatinho> contatos;
    List<Mensagem> mensagens;

    public Whatsapp(List<Contatinho> contatos, List<Mensagem> mensagens) {
        this.contatos = contatos;
        this.mensagens = mensagens;
    }

    public void listarContatos() {
        int qtdContatos = contatos.size();
        for(int i = 0; i < qtdContatos; i++) {
            System.out.println(contatos.get(i).toString());
        }
    }

    public void listarMensagens() {
        int qtdMensagens = mensagens.size();
        for(int i = 0; i < qtdMensagens; i++) {
            System.out.println(mensagens.get(i).toString());
        }
    }


}
