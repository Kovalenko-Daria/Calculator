package calc.controller;

import calc.exceptions.DivisionByZeroException;
import calc.exceptions.UnknownOperationException;
import calc.model.Expression;
import calc.model.ExpressionPart;
import calc.model.NumberExpression;
import calc.model.Operation;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CalculateExpressionTest {

    @Test
    public void calculateBinaryAddTest() {
        Double num1 = 16.5;
        Double num2 = 16.5;
        Double expectedValue = num1 + num2;
        Double actualValue = null;
        try {
            actualValue = CalculateExpression.calculateBinary(num1, num2, Operation.ADDITION);
        } catch(Exception e) {
            fail();
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateBinarySubTest() {
        Double num1 = 16.5;
        Double num2 = 7.635;
        Double expectedValue = num1 - num2;
        Double actualValue = null;
        try {
            actualValue = CalculateExpression.calculateBinary(num1, num2, Operation.SUBTRACTION);
        } catch(Exception e) {
            fail();
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateBinaryMulTest() {
        Double num1 = 1.5;
        Double num2 = 7.90;
        Double expectedValue = num1 * num2;
        Double actualValue = null;
        try {
            actualValue = CalculateExpression.calculateBinary(num1, num2, Operation.MULTIPLICATION);
        } catch(Exception e) {
            fail();
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateBinaryDivTest() {
        Double num1 = 7.0;
        Double num2 = 4.7;
        Double expectedValue = num1 / num2;
        Double actualValue = null;
        try {
            actualValue = CalculateExpression.calculateBinary(num1, num2, Operation.DIVISION);
        } catch(Exception e) {
            fail();
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateBinaryDivZeroTest() {
        Double num1 = 16.5;
        Double num2 = 0.0;
        Double actualValue = null;
        try {
            actualValue = CalculateExpression.calculateBinary(num1, num2, Operation.DIVISION);
        } catch(DivisionByZeroException e) {
            return;
        }
        catch(Exception e) {
            fail();
        }
    }

    @Test
    public void calculateBinaryUnknownTest() {
        Double num1 = 16.5;
        Double num2 = 16.5;
        Double actualValue = null;
        try {
            actualValue = CalculateExpression.calculateBinary(num1, num2, Operation.UNMIN);
        } catch(UnknownOperationException e) {
            return;
        }catch(Exception e) {
            fail();
        }
    }

    @Test
    public void calculateUnaryTest() {
        Double num1 = 16.5;
        Double expectedValue = num1 * -1;
        Double actualValue = null;
        try {
            actualValue = CalculateExpression.calculateUnary(num1, Operation.UNMIN);
        } catch(Exception e) {
            fail();
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateUnaryUnknownTest() {
        Double num1 = 16.5;
        Double actualValue = null;
        try {
            actualValue = CalculateExpression.calculateUnary(num1, Operation.ADDITION);
        } catch(UnknownOperationException e) {
            return;
        }
        catch(Exception e) {
            fail();
        }
    }


    @Test
    public void calculateExpressionFloatNumTest() {
        Double expectedValue = 3.5394;
        Double actualValue = null;
        try {
            Expression expression = ExpressionParse.parseExpression("3.5394");
            actualValue = CalculateExpression.calculateExpression(expression);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateExpressionSimpleNumTest() {
        Double expectedValue = 12345.0;
        Double actualValue = null;
        try {
            Expression expression = ExpressionParse.parseExpression("12345");
            actualValue = CalculateExpression.calculateExpression(expression);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateExpressionSimpleExpTest() {
        Double expectedValue = 7.1;
        Double actualValue = null;
        try {
            Expression expression = ExpressionParse.parseExpression("3.8 + 12 - 8.7");
            actualValue = CalculateExpression.calculateExpression(expression);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateExpressionSimpleExpMultDivTest() {
        Double expectedValue = -50.0;
        Double actualValue = null;
        try {
            Expression expression = ExpressionParse.parseExpression("1 + 2 - 9 * 6 + 5 / 5");
            actualValue = CalculateExpression.calculateExpression(expression);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateExpressionSimpleSkobTest() {
        Double expectedValue = -12.0;
        Double actualValue = null;
        try {
            Expression expression = ExpressionParse.parseExpression("7 + 8 - (1 + 2) * 9");
            actualValue = CalculateExpression.calculateExpression(expression);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateExpressionComplSkobTest() {
        Double expectedValue = 57.53;
        Double actualValue = null;
        try {
            Expression expression = ExpressionParse.parseExpression("7.56 + (8.89 - (1.23 + 2.4)) * 9.5");
            actualValue = CalculateExpression.calculateExpression(expression);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateExpressionUnMinSimpleTest() {
        Double expectedValue = 8.0;
        Double actualValue = null;
        try {
            Expression expression = ExpressionParse.parseExpression("-5+13");
            actualValue = CalculateExpression.calculateExpression(expression);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(expectedValue, actualValue);
    }
}