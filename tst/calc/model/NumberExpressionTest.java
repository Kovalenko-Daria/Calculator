package calc.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberExpressionTest {

    @Test
    public void getNumberTest() {
        Double expectedValue = 1.86374;
        NumberExpression num = new NumberExpression(expectedValue);
        Double actualValue = num.getNumber();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testToStringTest() {
        Double expectedValueDouble = 0.86374;
        String expectedValue = "0.86374";
        NumberExpression num = new NumberExpression(expectedValueDouble);
        String actualValue = num.toString();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getIsBinaryTest() {
        Double numDouble = Math.random();
        NumberExpression num = new NumberExpression(numDouble);
        boolean actualValue = num.getIsBinary();
        assertFalse(actualValue);
    }

    @Test
    public void isEqualEqualTest() {
        Double numDouble = 723.45;
        NumberExpression num1 = new NumberExpression(numDouble);
        NumberExpression num2 = new NumberExpression(numDouble);
        boolean actualValue = num1.isEqual(num2);
        assertTrue(actualValue);
    }

    @Test
    public void isEqualNotEqualTest() {
        Double numDouble1 = 723.45;
        Double numDouble2 = 723.46;
        NumberExpression num1 = new NumberExpression(numDouble1);
        NumberExpression num2 = new NumberExpression(numDouble2);
        boolean actualValue = num1.isEqual(num2);
        assertFalse(actualValue);
    }

    @Test
    public void isEqualNotEqualDiffTest() {
        Double numDouble1 = 723.45;
        NumberExpression num1 = new NumberExpression(numDouble1);
        boolean actualValue = num1.isEqual(Operation.ADDITION);
        assertFalse(actualValue);
    }

    @Test
    public void getSymbolTest() {
        Double numDouble = Math.random();
        NumberExpression num = new NumberExpression(numDouble);
        char actualValue = num.getSymbol();
        assertEquals(' ', actualValue);
    }
}