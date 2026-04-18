package calc.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ExpressionTest {

    @Test
    public void getExpressionSimpleNumTest() {
        String expectedValue = "12.6";
        ArrayList<ExpressionPart> calcQueue = new ArrayList<ExpressionPart>();
        calcQueue.add(new NumberExpression(12.6));
        Expression expression = new Expression(expectedValue, calcQueue);
        String actualValue = expression.getExpression();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getExpressionExpTest() {
        String expectedValue = "12.6 + 18 - 9 * 7";
        ArrayList<ExpressionPart> calcQueue = new ArrayList<ExpressionPart>();
        calcQueue.add(new NumberExpression(12.6));
        calcQueue.add(new NumberExpression(18.0));
        calcQueue.add(Operation.ADDITION);
        calcQueue.add(new NumberExpression(9.0));
        calcQueue.add(new NumberExpression(7.0));
        calcQueue.add(Operation.MULTIPLICATION);
        calcQueue.add(Operation.SUBTRACTION);
        Expression expression = new Expression(expectedValue, calcQueue);
        String actualValue = expression.getExpression();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void compareFalseTest() {
        String num1 = "12.6";
        ArrayList<ExpressionPart> calcQueue1 = new ArrayList<ExpressionPart>();
        calcQueue1.add(new NumberExpression(12.6));
        Expression exp1 = new Expression(num1, calcQueue1);
        String num2 = "12.6 + 18 - 9 * 7";
        ArrayList<ExpressionPart> calcQueue2 = new ArrayList<ExpressionPart>();
        calcQueue2.add(new NumberExpression(12.6));
        calcQueue2.add(new NumberExpression(18.0));
        calcQueue2.add(Operation.ADDITION);
        calcQueue2.add(new NumberExpression(9.0));
        calcQueue2.add(new NumberExpression(7.0));
        calcQueue2.add(Operation.MULTIPLICATION);
        calcQueue2.add(Operation.SUBTRACTION);
        Expression exp2 = new Expression(num2, calcQueue2);
        boolean actualValue = Expression.compare(exp1, exp2);
        boolean expectedValue = false;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void compareTrueTest() {
        String num1 = "12.6";
        ArrayList<ExpressionPart> calcQueue1 = new ArrayList<ExpressionPart>();
        calcQueue1.add(new NumberExpression(12.6));
        Expression exp1 = new Expression(num1, calcQueue1);
        String num2 = "12.6";
        ArrayList<ExpressionPart> calcQueue2 = new ArrayList<ExpressionPart>();
        calcQueue2.add(new NumberExpression(12.6));
        Expression exp2 = new Expression(num2, calcQueue2);
        boolean actualValue = Expression.compare(exp1, exp2);
        boolean expectedValue = true;
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void getCalcQueueSimpleNumTest() {
        String num1 = "12.6";
        ArrayList<ExpressionPart> calcQueue1 = new ArrayList<ExpressionPart>();
        calcQueue1.add(new NumberExpression(12.6));
        Expression exp1 = new Expression(num1, calcQueue1);
        ArrayList<ExpressionPart> calcQueue2 = exp1.getCalcQueue();
        Expression exp2 = new Expression(num1, calcQueue2);
        boolean actualValue = Expression.compare(exp1, exp2);
        assertTrue(actualValue);
    }

    @Test
    public void getCalcQueueExpTest() {
        String num1 = "12.6 + 18 - 9 * 7";
        ArrayList<ExpressionPart> calcQueue1 = new ArrayList<ExpressionPart>();
        calcQueue1.add(new NumberExpression(12.6));
        calcQueue1.add(new NumberExpression(18.0));
        calcQueue1.add(Operation.ADDITION);
        calcQueue1.add(new NumberExpression(9.0));
        calcQueue1.add(new NumberExpression(7.0));
        calcQueue1.add(Operation.MULTIPLICATION);
        calcQueue1.add(Operation.SUBTRACTION);
        Expression exp1 = new Expression(num1, calcQueue1);
        ArrayList<ExpressionPart> calcQueue2 = exp1.getCalcQueue();
        Expression exp2 = new Expression(num1, calcQueue2);
        boolean actualValue = Expression.compare(exp1, exp2);
        assertTrue(actualValue);
    }
}