import static org.junit.Assert.*;

import org.junit.Test;

public class TestMathEvaluation {

	@Test
	public void testArmazenarToken() {
		String input = "3";
		MathEvaluation math1 = new MathEvaluation(input);
		assertEquals(3, math1.pop());
	}

}
