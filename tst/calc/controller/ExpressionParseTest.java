package calc.controller;

import calc.model.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class ExpressionParseTest {

    @Test
    public void parseExpressionFloatNumTest() {
        String expression = "3.5394";
        ArrayList<ExpressionPart> calcQueue = new ArrayList<ExpressionPart>();
        calcQueue.add(new NumberExpression(3.5394));
        Expression expectedValue = new Expression(expression, calcQueue);
        boolean compare = false;
        try {
            Expression actualValue = ExpressionParse.parseExpression(expression);
            compare = Expression.compare(expectedValue, actualValue);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertTrue(compare);
    }

    @Test
    public void parseExpressionSimpleNumTest() {
        String expression = "12345";
        ArrayList<ExpressionPart> calcQueue = new ArrayList<ExpressionPart>();
        calcQueue.add(new NumberExpression(12345.0));
        Expression expectedValue = new Expression(expression, calcQueue);
        boolean compare = false;
        try {
            Expression actualValue = ExpressionParse.parseExpression(expression);
            compare = Expression.compare(expectedValue, actualValue);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertTrue(compare);
    }

    @Test
    public void parseExpressionSimpleExpTest() {
        String expression = "3.8 + 12 - 8.7";
        ArrayList<ExpressionPart> calcQueue = new ArrayList<ExpressionPart>();
        calcQueue.add(new NumberExpression(3.8));
        calcQueue.add(new NumberExpression(12.0));
        calcQueue.add(Operation.ADDITION);
        calcQueue.add(new NumberExpression(8.7));
        calcQueue.add(Operation.SUBTRACTION);
        Expression expectedValue = new Expression(expression, calcQueue);
        boolean compare = false;
        try {
            Expression actualValue = ExpressionParse.parseExpression(expression);
            compare = Expression.compare(expectedValue, actualValue);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertTrue(compare);
    }

    @Test
    public void parseExpressionSimpleExpMultDivTest() {
        String expression = "1 + 2 - 9 * 6 + 5 / 5";
        ArrayList<ExpressionPart> calcQueue = new ArrayList<ExpressionPart>();
        calcQueue.add(new NumberExpression(1.0));
        calcQueue.add(new NumberExpression(2.0));
        calcQueue.add(Operation.ADDITION);
        calcQueue.add(new NumberExpression(9.0));
        calcQueue.add(new NumberExpression(6.0));
        calcQueue.add(Operation.MULTIPLICATION);
        calcQueue.add(Operation.SUBTRACTION);
        calcQueue.add(new NumberExpression(5.0));
        calcQueue.add(new NumberExpression(5.0));
        calcQueue.add(Operation.DIVISION);
        calcQueue.add(Operation.ADDITION);
        Expression expectedValue = new Expression(expression, calcQueue);
        boolean compare = false;
        try {
            Expression actualValue = ExpressionParse.parseExpression(expression);
            compare = Expression.compare(expectedValue, actualValue);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertTrue(compare);
    }

    @Test
    public void parseExpressionSimpleSkobTest() {
        String expression = "7 + 8 - (1 + 2) * 9";
        ArrayList<ExpressionPart> calcQueue = new ArrayList<ExpressionPart>();
        calcQueue.add(new NumberExpression(7.0));
        calcQueue.add(new NumberExpression(8.0));
        calcQueue.add(Operation.ADDITION);
        calcQueue.add(new NumberExpression(1.0));
        calcQueue.add(new NumberExpression(2.0));
        calcQueue.add(Operation.ADDITION);
        calcQueue.add(new NumberExpression(9.0));
        calcQueue.add(Operation.MULTIPLICATION);
        calcQueue.add(Operation.SUBTRACTION);
        Expression expectedValue = new Expression(expression, calcQueue);
        boolean compare = false;
        try {
            Expression actualValue = ExpressionParse.parseExpression(expression);
            compare = Expression.compare(expectedValue, actualValue);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertTrue(compare);
    }

    @Test
    public void parseExpressionComplSkobTest() {
        String expression = "7.56 + (8.89 - (1.23 + 2.4)) * 9.5";
        ArrayList<ExpressionPart> calcQueue = new ArrayList<ExpressionPart>();
        calcQueue.add(new NumberExpression(7.56));
        calcQueue.add(new NumberExpression(8.89));
        calcQueue.add(new NumberExpression(1.23));
        calcQueue.add(new NumberExpression(2.4));
        calcQueue.add(Operation.ADDITION);
        calcQueue.add(Operation.SUBTRACTION);
        calcQueue.add(new NumberExpression(9.5));
        calcQueue.add(Operation.MULTIPLICATION);
        calcQueue.add(Operation.ADDITION);
        Expression expectedValue = new Expression(expression, calcQueue);
        boolean compare = false;
        try {
            Expression actualValue = ExpressionParse.parseExpression(expression);
            compare = Expression.compare(expectedValue, actualValue);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertTrue(compare);
    }

    @Test
    public void parseExpressionUnMinSimpleTest() {
        String expression = "-5 + 13";
        ArrayList<ExpressionPart> calcQueue = new ArrayList<ExpressionPart>();
        calcQueue.add(new NumberExpression(5.0));
        calcQueue.add(Operation.UNMIN);
        calcQueue.add(new NumberExpression(13.0));
        calcQueue.add(Operation.ADDITION);
        Expression expectedValue = new Expression(expression, calcQueue);
        boolean compare = false;
        try {
            Expression actualValue = ExpressionParse.parseExpression(expression);
            compare = Expression.compare(expectedValue, actualValue);
        } catch (Exception e) {
            fail("Exception thrown");
        }
        assertTrue(compare);
    }


}