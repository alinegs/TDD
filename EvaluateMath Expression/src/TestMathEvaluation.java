import static org.junit.Assert.*;

import org.junit.Test;

public class TestMathEvaluation {

	@Test
	public void testArmazenarUmToken() {
		String input = "3";
		MathEvaluation math1 = new MathEvaluation(input);
		assertEquals(3, math1.pop());
	}
	
	@Test
	public void testArmazenarMaisDeUmToken() {
		String input = "3 + 2 * 1 / 0 ( ) -";
		MathEvaluation math1 = new MathEvaluation(input);
		assertEquals('-', math1.pop());
		assertEquals(')', math1.pop());
		assertEquals('(', math1.pop());
		assertEquals(0, math1.pop());
		assertEquals('/', math1.pop());
		assertEquals(1, math1.pop());
		assertEquals('*', math1.pop());
		assertEquals(2, math1.pop());
		assertEquals('+', math1.pop());
		assertEquals(3, math1.pop());
	}
	
	@Test
	public void testVerificarPrecedenciaDeOperadores(){
		String input =  "3 + 2 * 1 / 0 ( )";
		MathEvaluation math1 = new MathEvaluation(input);
		assertEquals('/', math1.popPostFix());
		assertEquals('*', math1.popPostFix());
		assertEquals('+', math1.popPostFix());
	}
	
	@Test
	public void testVerificarPrecedenciaDeOperadoresComParenteses(){
		String input =  "3 + 2 * 1 / 4 - ( 2 - 1 )";
		MathEvaluation math1 = new MathEvaluation(input);
		assertEquals('-', math1.popPostFix());
		assertEquals('/', math1.popPostFix());
		assertEquals('*', math1.popPostFix());
		assertEquals('+', math1.popPostFix());
		assertEquals('-', math1.popPostFix());
		// 3 2 1 4 2 5 + / * - +
		// - / * + -  
	}
}
