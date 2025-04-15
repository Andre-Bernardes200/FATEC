package br.edu.lab5.figuras;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculableImplTest {
		private Calculable cut;
		private double expectedResult;

	@Test
	public void validaCalcularAreaQuadrado() {
		expectedResult = 16.0;
		cut = new Quadrado(4.0);
		double result = cut.calcularArea();
		assertEquals(expectedResult, result);
	}

	@Test
	public void validaCalcularAreaParalelograma(){
		expectedResult = 4.0;
		cut = new Paralelograma(4.0, 1.0);
		double result = cut.calcularArea();
		assertEquals(expectedResult, result);
	}

	@Test
	public void validaCalcularAreaCirculo(){
		expectedResult = 50.26548245743669;
		cut = new Circulo(4.0);
		double result = cut.calcularArea();
		assertEquals(expectedResult, result);
	}

	@Test
	public void validaCalcularAreaCubo(){
		expectedResult = 96.0;
		cut = new Cubo(4.0);
		double result = cut.calcularArea();
		assertEquals(expectedResult, result);
	}

	@Test
	public void validaCalcularAreaHexagono(){
		expectedResult = 41.569219381653056;
		cut = new Hexagono(4.0);
		double result = cut.calcularArea();
		assertEquals(expectedResult, result);
	}

	@Test
	public void validaCalcularAreaLosango(){
		expectedResult = 4.0;
		cut = new Losango(4.0,2.0);
		double result = cut.calcularArea();
		assertEquals(expectedResult, result);
	}

	@Test
	public void validaCalcularAreaTrapezio(){
		expectedResult = 3.0;
		cut = new Trapezio(4.0,2.0, 1.0);
		double result = cut.calcularArea();
		assertEquals(expectedResult, result);
	}

	@Test
	public void validaCalcularAreaTriangulo(){
		expectedResult = 4.0;
		cut = new Triangulo(4.0,2.0);
		double result = cut.calcularArea();
		assertEquals(expectedResult, result);
	}
}
