package calc.controller;

import calc.exceptions.*;
import calc.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CalculateExpression {
    public static BigDecimal calculateExpression(Expression expression) throws UnknownOperationException, InvalidParseException {
        ArrayList<BigDecimal> calcStack = new ArrayList<BigDecimal>();
        ArrayList<ExpressionPart> calcQueue = expression.getCalcQueue();

        int i = -1;
        BigDecimal num1, num2;
        try {
            for (ExpressionPart part : calcQueue) {
                if (part instanceof NumberExpression) {
                    calcStack.add(part.getNumber());
                    i++;
                } else if (part.getIsBinary()) {
                    num2 = calcStack.remove(i);
                    i--;
                    num1 = calcStack.remove(i);
                    i--;
                    BigDecimal result = calculateBinary(num1, num2, (Operation) part);
                    calcStack.add(result);
                    i++;
                } else {
                    BigDecimal result = calculateUnary(calcStack.remove(i), (Operation) part);
                    i--;
                    calcStack.add(result);
                    i++;
                }
            }
        }
        catch (Exception e) {
            throw new InvalidParseException("Invalid expression");
        }
        if (calcStack.size() > 1) {
            throw new InvalidParseException("Invalid expression");
        }
        return calcStack.remove(0);
    }

    static BigDecimal calculateBinary(BigDecimal num1, BigDecimal num2, Operation operation) throws UnknownOperationException, DivisionByZeroException {
        switch (operation) {
            case Operation.ADDITION: {
                return num1.add(num2);
            }
            case Operation.SUBTRACTION: {
                return num1.subtract(num2);
            }
            case Operation.MULTIPLICATION: {
                return num1.multiply(num2);
            }
            case Operation.DIVISION: {
                if (num2.equals(BigDecimal.ZERO)) {
                    throw new DivisionByZeroException("Division by zero");
                }
                return num1.divide(num2);
            }
        }
        throw new UnknownOperationException("Unknown binary operation " + operation);
    }

    static BigDecimal calculateUnary(BigDecimal num, Operation operation) throws UnknownOperationException {
        if (operation == Operation.UNMIN) {
            return num.negate();
        }
        throw new UnknownOperationException("Unknown unary operation " + operation);
    }
}
