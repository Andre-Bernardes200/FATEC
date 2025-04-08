package com.atividade3.tdd.exercicio2.test;

import com.atividade3.tdd.exercicio2.Email;
import com.atividade3.tdd.exercicio2.Person;
import com.atividade3.tdd.exercicio2.PersonDAO;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonaDAOTest {

    private final PersonDAO dao = new PersonDAO();

    @Test
    public void testNomeInvalidoComUmaPalavra() {
        Person p = new Person(1, "Joao", 30, Arrays.asList(new Email(1, "joao@email.com")));
        List<String> errors = dao.isValidToInclude(p);
        assertTrue(errors.contains("Nome deve conter pelo menos duas palavras com letras."));
    }

    @Test
    public void testNomeInvalidoComCaracteresInvalidos() {
        Person p = new Person(1, "Joao 123", 30, Arrays.asList(new Email(1, "joao@email.com")));
        List<String> errors = dao.isValidToInclude(p);
        assertTrue(errors.contains("Nome deve conter apenas letras."));
    }

    @Test
    public void testIdadeForaDoIntervalo() {
        Person p = new Person(1, "Joao Silva", 0, Arrays.asList(new Email(1, "joao@email.com")));
        List<String> errors = dao.isValidToInclude(p);
        assertTrue(errors.contains("Idade deve estar entre 1 e 200."));
    }

    @Test
    public void testSemEmailAssociado() {
        Person p = new Person(1, "Joao Silva", 30, Collections.emptyList());
        List<String> errors = dao.isValidToInclude(p);
        assertTrue(errors.contains("Pessoa deve ter pelo menos um e-mail."));
    }

    @Test
    public void testEmailComFormatoInvalido() {
        Person p = new Person(1, "Joao Silva", 30, Arrays.asList(new Email(1, "emailinvalido")));
        List<String> errors = dao.isValidToInclude(p);
        assertTrue(errors.contains("Formato de e-mail inválido: emailinvalido"));
    }

    @Test
    public void testPessoaValida() {
        Person p = new Person(1, "Joao Silva", 30, Arrays.asList(new Email(1, "joao@teste.com")));
        List<String> errors = dao.isValidToInclude(p);
        assertTrue(errors.isEmpty());
    }
}
