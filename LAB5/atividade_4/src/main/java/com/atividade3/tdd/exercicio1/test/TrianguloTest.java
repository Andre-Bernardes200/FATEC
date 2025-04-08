package com.atividade3.tdd.exercicio1.test;
import static org.junit.jupiter.api.Assertions.*;

import com.atividade3.tdd.exercicio1.Triangulo;
import org.junit.jupiter.api.Test;

public class TrianguloTest {

    // Triângulo escaleno válido
    @Test
    public void testTrianguloEscaleno() {
        assertEquals("Escaleno", Triangulo.tipoTriangulo(3, 4, 5));
    }

    // Triângulo isósceles válido
    @Test
    public void testTrianguloIsosceles() {
        assertEquals("Isósceles", Triangulo.tipoTriangulo(5, 5, 3));
    }

    // Permutações do triângulo isósceles
    @Test
    public void testTrianguloIsoscelesPermutacoes() {
        assertEquals("Isósceles", Triangulo.tipoTriangulo(5, 3, 5));
        assertEquals("Isósceles", Triangulo.tipoTriangulo(3, 5, 5));
    }

    // Triângulo equilátero válido
    @Test
    public void testTrianguloEquilatero() {
        assertEquals("Equilátero", Triangulo.tipoTriangulo(6, 6, 6));
    }

    // Um valor zero
    @Test
    public void testValorZero() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(0, 4, 5));
    }

    // Um valor negativo
    @Test
    public void testValorNegativo() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(-3, 4, 5));
    }

    // Soma de dois lados igual ao terceiro (não forma triângulo)
    @Test
    public void testSomaDoisLadosIgualTerceiro() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(2, 2, 4));
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(2, 4, 2));
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(4, 2, 2));
    }

    // Soma de dois lados menor que o terceiro (não forma triângulo)
    @Test
    public void testSomaDoisLadosMenorTerceiro() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(2, 2, 5));
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(2, 5, 2));
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(5, 2, 2));
    }

    // Três valores iguais a zero
    @Test
    public void testTodosValoresZero() {
        assertEquals("Não é um triângulo", Triangulo.tipoTriangulo(0, 0, 0));
    }
}
