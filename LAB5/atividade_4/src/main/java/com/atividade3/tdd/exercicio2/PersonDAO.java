package com.atividade3.tdd.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class PersonDAO {

    public void save(Person p) {
        // implementação futura
    }

    public List<String> isValidToInclude(Person p) {
        List<String> errors = new ArrayList<>();

        // Validação do nome
        if (p.getName() == null || p.getName().trim().split("\\s+").length < 2) {
            errors.add("Nome deve conter pelo menos duas palavras com letras.");
        } else if (!p.getName().replaceAll("\\s+", "").matches("[a-zA-Z]+")) {
            errors.add("Nome deve conter apenas letras.");
        }

        // Validação da idade
        if (p.getAge() < 1 || p.getAge() > 200) {
            errors.add("Idade deve estar entre 1 e 200.");
        }

        // Validação dos e-mails
        List<Email> emails = p.getEmails();
        if (emails == null || emails.isEmpty()) {
            errors.add("Pessoa deve ter pelo menos um e-mail.");
        } else {
            for (Email email : emails) {
                String emailStr = email.getName();
                if (!emailStr.matches("^.+@.+\\..+$")) {
                    errors.add("Formato de e-mail inválido: " + emailStr);
                }
            }
        }

        return errors;
    }
}
