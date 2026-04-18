package calc.controller;

import calc.exceptions.DivisionByZeroException;
import calc.exceptions.UnknownOperationException;
import calc.model.Expression;
import calc.model.ExpressionPart;
import calc.model.NumberExpression;
import calc.model.Operation;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CalculateExpressionTest {

    @Test
    public void calculateBinaryAddTest() {
        BigDecimal num1 = new BigDecimal(16.5);
        BigDecimal num2 = new BigDecimal(16.5);
        BigDecimal expectedValue = num1.add(num2);
        BigDecimal actualValue = null;
        try {
            actualValue = CalculateExpression.calculateBinary(num1, num2, Operation.ADDITION);
        } catch(Exception e) {
            fail();
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateBinarySubTest() {
        BigDecimal num1 = new BigDecimal(16.5);
        BigDecimal num2 = new BigDecimal(7.635);
        BigDecimal expectedValue = num1.subtract(num2);
        BigDecimal actualValue = null;
        try {
            actualValue = CalculateExpression.calculateBinary(num1, num2, Operation.SUBTRACTION);
        } catch(Exception e) {
            fail();
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateBinaryMulTest() {
        BigDecimal num1 = new BigDecimal(1.5);
        BigDecimal num2 = new BigDecimal(7.90);
        BigDecimal expectedValue = num1.multiply(num2);
        BigDecimal actualValue = null;
        try {
            actualValue = CalculateExpression.calculateBinary(num1, num2, Operation.MULTIPLICATION);
        } catch(Exception e) {
            fail();
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateBinaryDivTest() {
        BigDecimal num1 = new BigDecimal(7.0);
        BigDecimal num2 = new BigDecimal(4.7);
        BigDecimal expectedValue = num1.divide(num2, 6, RoundingMode.HALF_UP);
        BigDecimal actualValue = null;
        try {
            actualValue = CalculateExpression.calculateBinary(num1, num2, Operation.DIVISION);
        } catch(Exception e) {
            fail();
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateBinaryDivZeroTest() {
        BigDecimal num1 = new BigDecimal(16.5);
        BigDecimal num2 = new BigDecimal(0.0);
        BigDecimal actualValue = null;
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
        BigDecimal num1 = new BigDecimal(16.5);
        BigDecimal num2 = new BigDecimal(16.5);
        BigDecimal actualValue = null;
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
        BigDecimal num1 = new BigDecimal(16.5);
        BigDecimal expectedValue = num1.multiply(BigDecimal.valueOf(-1));
        BigDecimal actualValue = null;
        try {
            actualValue = CalculateExpression.calculateUnary(num1, Operation.UNMIN);
        } catch(Exception e) {
            fail();
        }
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void calculateUnaryUnknownTest() {
        BigDecimal num1 = new BigDecimal(16.5);
        BigDecimal actualValue = null;
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
        BigDecimal expectedValue = new BigDecimal("3.5394");
        BigDecimal actualValue = null;
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
        BigDecimal expectedValue = new BigDecimal("12345.0");
        BigDecimal actualValue = null;
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
        BigDecimal expectedValue = new BigDecimal("7.1");
        BigDecimal actualValue = null;
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
        BigDecimal expectedValue = new BigDecimal("-50.0");
        BigDecimal actualValue = null;
        try {
            Expression expression = ExpressionParse.parseExpression("1 + 2 - 9 * 6 + 5 / 5");
            actualValue = CalculateExpression.calculateExpression(expression);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(0, expectedValue.compareTo(actualValue));
    }

    @Test
    public void calculateExpressionSimpleSkobTest() {
        BigDecimal expectedValue = new BigDecimal("-12");
        BigDecimal actualValue = null;
        try {
            Expression expression = ExpressionParse.parseExpression("7 + 8 - (1 + 2) * 9");
            actualValue = CalculateExpression.calculateExpression(expression);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(0, expectedValue.compareTo(actualValue));
    }

    @Test
    public void calculateExpressionComplSkobTest() {
        BigDecimal expectedValue = new BigDecimal("57.53");
        BigDecimal actualValue = null;
        try {
            Expression expression = ExpressionParse.parseExpression("7.56 + (8.89 - (1.23 + 2.4)) * 9.5");
            actualValue = CalculateExpression.calculateExpression(expression);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(0, expectedValue.compareTo(actualValue));
    }

    @Test
    public void calculateExpressionUnMinSimpleTest() {
        BigDecimal expectedValue = new BigDecimal(8.0);
        BigDecimal actualValue = null;
        try {
            Expression expression = ExpressionParse.parseExpression("-5+13");
            actualValue = CalculateExpression.calculateExpression(expression);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertEquals(0, expectedValue.compareTo(actualValue));
    }
}