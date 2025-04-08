package com.atividade3.tdd.exercicio1;

public class Triangulo {
    public static boolean formaTriangulo(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0 &&
                a + b > c && a + c > b && b + c > a;
    }

    public static String tipoTriangulo(int a, int b, int c) {
        if (!formaTriangulo(a, b, c)) {
            return "Não é um triângulo";
        }
        if (a == b && b == c) {
            return "Equilátero";
        } else if (a == b || b == c || a == c) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }
}
