 
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NotationTest {
	public String complexInfix = "(3+(((5*7)-(((8/2)-1)*4))*6))";
	public String complexPostfix =  "357*82/1-4*-6*+";
	public String easyInfix = "(5+4)";
	public String easyPostfix = "54+";
	public String intermediateInfix = "((3*(5+4))+2)";
	public String intermediatePostfix = "354+*2+";

	public String invalidPostfixExpression = "354+*-";
	public String invalidInfixExpression = "(3+5)*4)-2";
	
	public double evalComplexPostfix = 141.0;
	public double evalIntermediatePostfix = 29.0;
	public double evalEasyPostfix = 9.0;

	@BeforeEach	
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testComplexConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix​(complexInfix);
		assertEquals(complexPostfix, postfixResult);
	}
	
	@Test
	public void testIntermediateConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix​(intermediateInfix);
		assertEquals(intermediatePostfix, postfixResult);
	}
	
	@Test
	public void testEasyConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix​(easyInfix);
		assertEquals(easyPostfix, postfixResult);
	}
	
	@Test
	public void testInvalidInfixExpression() {
		try{
			Notation.convertInfixToPostfix​(invalidInfixExpression);
			assertTrue(false, "This should have thrown an InvalidNotationFormatException");
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue(true, "This should have thrown an InvalidNotationFormatException");
		}
	}
	
	@Test
	public void testComplexConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infixResult = Notation.convertPostFixToInfix(complexPostfix);
		assertEquals(complexInfix, infixResult);
	}
	
	@Test
	public void testIntermediateConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infixResult = Notation.convertPostFixToInfix(intermediatePostfix);
		assertEquals(intermediateInfix, infixResult);
	}
	
	@Test
	public void testEasyConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infixResult = Notation.convertPostFixToInfix(easyPostfix);
		assertEquals(easyInfix, infixResult);
	}

	@Test
	public void testInvalidPostfixExpressionB() {
		try{
			Notation.convertPostFixToInfix(invalidPostfixExpression);
			assertTrue(false, "This should have thrown an InvalidNotationFormatException");
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue(true, "This should have thrown an InvalidNotationFormatException");
		}
	}
	
	@Test
	public void testComplexEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostFix(complexPostfix);
		assertEquals(evalComplexPostfix, result, .001);
	}
	
	@Test
	public void testIntermediateEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostFix(intermediatePostfix);
		assertEquals(evalIntermediatePostfix, result, .001);
	}
	
	@Test
	public void testEasyEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostFix(easyPostfix);
		assertEquals(evalEasyPostfix, result, .001);
	}
	
	@Test
	public void testInvalidPostfixExpressionA() {
		try{
			Notation.evaluatePostFix(invalidPostfixExpression);
			assertTrue(false, "This should have thrown an InvalidNotationFormatException");
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue(true, "This should have thrown an InvalidNotationFormatException");
		}
	}
}
