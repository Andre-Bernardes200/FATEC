package br.edu.lab5.factory;

import br.edu.lab5.enums.FiguraType;
import br.edu.lab5.figuras.*;
import br.edu.lab5.integration.ErrorPerformCalcException;
import br.edu.lab5.integration.LogPerformedCalculation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

public class FiguraFactoryTest {
		private Factory<Calculable, FiguraType> cut;
		private Class<Calculable> expectedClass;
		private LogPerformedCalculation mockLog;

		@BeforeEach
		public void setUp(){
			mockLog = mock(LogPerformedCalculation.class);
			cut = new FiguraFactory(mockLog);
		}

		@ParameterizedTest
		@MethodSource("provideFigureTypeData")
		void testFiguraFactoryWithParameters(FiguraType type, Class<?> expectedClass ,double... args) throws ErrorPerformCalcException {
			when(mockLog.logResultValue(any())).thenReturn(true);
			Calculable fig = cut.create(type, args);
			assertTrue(expectedClass.isInstance(fig));
			verify(mockLog, times(1)).logResultValue(any(Calculable.class));
		}

        public static Stream<Arguments> provideFigureTypeData(){
			return Stream.of(
					Arguments.of(FiguraType.QUADRADO, Quadrado.class, new double[]{4.0}),
					Arguments.of(FiguraType.RETANGULO, Retangulo.class, new double[] {4.0, 4.0}),
					Arguments.of(FiguraType.CIRCULO, Circulo.class, new double[] {4.0}),
					Arguments.of(FiguraType.TRIANGULO, Triangulo.class, new double[] {4.0, 4.0}),
					Arguments.of(FiguraType.PARALELOGRAMA, Paralelograma.class, new double[] {4.0, 4.0}),
					Arguments.of(FiguraType.TRAPEZIO, Trapezio.class, new double[] {4.0, 4.0, 2.0}),
					Arguments.of(FiguraType.HEXAGONO, Hexagono.class, new double[] {4.0}),
					Arguments.of(FiguraType.LOSANGO, Losango.class, new double[] {4.0, 4.0}),
					Arguments.of(FiguraType.CUBO, Cubo.class, new double[] {4.0})
			);
		}

		@Test
		public void validaCriarQuadradoComExcecao() throws ErrorPerformCalcException {
			LogPerformedCalculation mockLog = mock(LogPerformedCalculation.class);
			when(mockLog.logResultValue(any())).thenThrow(new ErrorPerformCalcException());
			cut = new FiguraFactory(mockLog);
			assertThrows(ErrorPerformCalcException.class, () -> {
				cut.create(FiguraType.QUADRADO, 4.0);
			});
		}
}
