package com.atividade3.tdd.exercicio3.test;

import com.atividade3.tdd.exercicio3.CalculaSalario;
import com.atividade3.tdd.exercicio3.Cargo;
import com.atividade3.tdd.exercicio3.Funcionario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculaSalarioTest {
    @Test
    public void testDesenvolvedorComSalarioMaiorOuIgual3000() {
        Funcionario f = new Funcionario("João", "joao@empresa.com", 3000.0, Cargo.DESENVOLVEDOR);
        double salarioLiquido = CalculaSalario.calcular(f);
        assertEquals(2400.0, salarioLiquido);
    }

    @Test
    public void testDesenvolvedorComSalarioMenorQue3000() {
        Funcionario f = new Funcionario("Maria", "maria@empresa.com", 2500.0, Cargo.DESENVOLVEDOR);
        double salarioLiquido = CalculaSalario.calcular(f);
        assertEquals(2250.0, salarioLiquido);
    }

    @Test
    public void testDBAComSalarioMaiorOuIgual2000() {
        Funcionario f = new Funcionario("Carlos", "carlos@empresa.com", 2500.0, Cargo.DBA);
        double salarioLiquido = CalculaSalario.calcular(f);
        assertEquals(1875.0, salarioLiquido);
    }

    @Test
    public void testDBAComSalarioMenorQue2000() {
        Funcionario f = new Funcionario("Paula", "paula@empresa.com", 1800.0, Cargo.DBA);
        double salarioLiquido = CalculaSalario.calcular(f);
        assertEquals(1530.0, salarioLiquido);
    }

    @Test
    public void testTestadorComSalarioMaiorOuIgual2000() {
        Funcionario f = new Funcionario("Ana", "ana@empresa.com", 2200.0, Cargo.TESTADOR);
        double salarioLiquido = CalculaSalario.calcular(f);
        assertEquals(1650.0, salarioLiquido);
    }

    @Test
    public void testTestadorComSalarioMenorQue2000() {
        Funcionario f = new Funcionario("Rafael", "rafael@empresa.com", 1900.0, Cargo.TESTADOR);
        double salarioLiquido = CalculaSalario.calcular(f);
        assertEquals(1615.0, salarioLiquido);
    }

    @Test
    public void testGerenteComSalarioMaiorOuIgual5000() {
        Funcionario f = new Funcionario("Luiza", "luiza@empresa.com", 6000.0, Cargo.GERENTE);
        double salarioLiquido = CalculaSalario.calcular(f);
        assertEquals(4200.0, salarioLiquido);
    }

    @Test
    public void testGerenteComSalarioMenorQue5000() {
        Funcionario f = new Funcionario("Marcos", "marcos@empresa.com", 4000.0, Cargo.GERENTE);
        double salarioLiquido = CalculaSalario.calcular(f);
        assertEquals(3200.0, salarioLiquido);
    }
}
