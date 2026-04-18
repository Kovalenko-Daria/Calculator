package calc.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class OperationTest {

    @Test
    public void getSymbolAddTest() {
        char expectedValue = '+';
        char actualValue = Operation.ADDITION.getSymbol();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getSymbolSubTest() {
        char expectedValue = '-';
        char actualValue = Operation.SUBTRACTION.getSymbol();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getSymbolUnTest() {
        char expectedValue = '.';
        char actualValue = Operation.UNMIN.getSymbol();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getSymbolMultTest() {
        char expectedValue = '*';
        char actualValue = Operation.MULTIPLICATION.getSymbol();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getSymbolDivTest() {
        char expectedValue = '/';
        char actualValue = Operation.DIVISION.getSymbol();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getSymbolOpenTest() {
        char expectedValue = '(';
        char actualValue = Operation.OPEN.getSymbol();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getSymbolCloseTest() {
        char expectedValue = ')';
        char actualValue = Operation.CLOSE.getSymbol();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getPriorityAddTest() {
        int expectedValue = 0;
        int actualValue = Operation.ADDITION.getPriority();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getPrioritySubTest() {
        int expectedValue = 0;
        int actualValue = Operation.SUBTRACTION.getPriority();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getPriorityUnTest() {
        int expectedValue = 3;
        int actualValue = Operation.UNMIN.getPriority();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getPriorityMultTest() {
        int expectedValue = 1;
        int actualValue = Operation.MULTIPLICATION.getPriority();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getPriorityDivTest() {
        int expectedValue = 1;
        int actualValue = Operation.DIVISION.getPriority();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getPriorityOpenTest() {
        int expectedValue = 2;
        int actualValue = Operation.OPEN.getPriority();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getPriorityCloseTest() {
        int expectedValue = 2;
        int actualValue = Operation.CLOSE.getPriority();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getIsBinaryAddTest() {
        boolean expectedValue = true;
        boolean actualValue = Operation.ADDITION.getIsBinary();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getIsBinarySubTest() {
        boolean expectedValue = true;
        boolean actualValue = Operation.SUBTRACTION.getIsBinary();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getIsBinaryUnTest() {
        boolean expectedValue = false;
        boolean actualValue = Operation.UNMIN.getIsBinary();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getIsBinaryMultTest() {
        boolean expectedValue = true;
        boolean actualValue = Operation.MULTIPLICATION.getIsBinary();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getIsBinaryDivTest() {
        boolean expectedValue = true;
        boolean actualValue = Operation.DIVISION.getIsBinary();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getIsBinaryOpenTest() {
        boolean expectedValue = true;
        boolean actualValue = Operation.OPEN.getIsBinary();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getIsBinaryCloseTest() {
        boolean expectedValue = true;
        boolean actualValue = Operation.CLOSE.getIsBinary();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getOperationFromSymbolAddTest() {
        Operation expectedValue = Operation.ADDITION;
        Operation actualValue = Operation.getOperationFromSymbol('+');
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getOperationFromSymbolSubTest() {
        Operation expectedValue = Operation.SUBTRACTION;
        Operation actualValue = Operation.getOperationFromSymbol('-');
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getOperationFromSymbolUnTest() {
        Operation expectedValue = Operation.UNMIN;
        Operation actualValue = Operation.getOperationFromSymbol('.');
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getOperationFromSymbolMultTest() {
        Operation expectedValue = Operation.MULTIPLICATION;
        Operation actualValue = Operation.getOperationFromSymbol('*');
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getOperationFromSymbolDivTest() {
        Operation expectedValue = Operation.DIVISION;
        Operation actualValue = Operation.getOperationFromSymbol('/');
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getOperationFromSymbolOpenTest() {
        Operation expectedValue = Operation.OPEN;
        Operation actualValue = Operation.getOperationFromSymbol('(');
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getOperationFromSymbolCloseTest() {
        Operation expectedValue = Operation.CLOSE;
        Operation actualValue = Operation.getOperationFromSymbol(')');
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void toStringAddTest() {
        String expectedValue = "+";
        String actualValue = Operation.ADDITION.toString();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void toStringSubTest() {
        String expectedValue = "-";
        String actualValue = Operation.SUBTRACTION.toString();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void toStringUnTest() {
        String expectedValue = ".";
        String actualValue = Operation.UNMIN.toString();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void toStringMultTest() {
        String expectedValue = "*";
        String actualValue = Operation.MULTIPLICATION.toString();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void toStringDivTest() {
        String expectedValue = "/";
        String actualValue = Operation.DIVISION.toString();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void toStringOpenTest() {
        String expectedValue = "(";
        String actualValue = Operation.OPEN.toString();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void toStringCloseTest() {
        String expectedValue = ")";
        String actualValue = Operation.CLOSE.toString();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getNumberTest() {
        Double actualValue = Operation.ADDITION.getNumber();
        assertNull(actualValue);
    }

    @Test
    public void isEqualEqualTest() {
        boolean expectedValue = true;
        boolean actualValue = Operation.ADDITION.isEqual(Operation.ADDITION);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void isEqualNotEqualTest() {
        boolean expectedValue = false;
        boolean actualValue = Operation.SUBTRACTION.isEqual(Operation.UNMIN);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void isEqualNotEqualDiffTest() {
        boolean expectedValue = false;
        NumberExpression num = new NumberExpression(0.0);
        boolean actualValue = Operation.MULTIPLICATION.isEqual(num);
        assertEquals(expectedValue, actualValue);
    }
}