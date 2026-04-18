package calc.controller;

import calc.exceptions.*;
import calc.model.*;
import java.util.*;

public class ExpressionParse {
    private final static Character FLOAT_SEPARATOR = '.';

    public static Expression parseExpression(String inputExpression) throws InvalidExpressionException, InvalidNumberException {
        ArrayList<Operation> operationStack = new ArrayList<Operation>();
        ArrayList<ExpressionPart> calcQueue = new ArrayList<ExpressionPart>();

        StringBuilder number = new StringBuilder();

        String expression = inputExpression.replaceAll(" ", "");
        char[] expressionCharArray = expression.toCharArray();

        for (int i = 0; i < expressionCharArray.length; i++) {
            Character ch = expressionCharArray[i];
            if (Character.isDigit(ch) || (ch == FLOAT_SEPARATOR && !number.toString().contains(FLOAT_SEPARATOR.toString()) && !number.isEmpty())) {
                number.append(ch);
            }
            else {
                if (!number.isEmpty()) {
                    calcQueue.add(new NumberExpression(Double.parseDouble(number.toString())));
                    number.setLength(0);
                }
                if (ch == '-' && (i == 0 ||expressionCharArray[i - 1] == '(')) {
                    operationStack.add(Operation.UNMIN);
                }
                else if (Operation.getOperationFromSymbol(ch) != null) {
                    Operation operation = Operation.getOperationFromSymbol(ch);
                    if (i == 0 && ch != '(') {
                        throw new InvalidExpressionException("Expression can't start with operation which is not '-'");
                    }
                    else if (operation == Operation.OPEN) {
                        operationStack.add(operation);
                    }
                    else if (operation == Operation.CLOSE) {
                        for (int j = operationStack.size() - 1; j > 0 && operationStack.get(j) != Operation.OPEN; j--) {
                            calcQueue.add(operationStack.remove(j));
                        }
                        operationStack.remove(operationStack.size() - 1);
                    }
                    else if (i != 0 && expressionCharArray[i - 1] != '(' && expressionCharArray[i - 1] != ')'
                            && Operation.getOperationFromSymbol(expressionCharArray[i - 1]) != null) {
                        throw new InvalidExpressionException("More than 1 operation in a row");
                    }
                    else {
                        for (int j = operationStack.size() - 1; j >= 0 && operationStack.get(j).getPriority() >= operation.getPriority(); j--) {
                            calcQueue.add(operationStack.remove(j));
                        }
                        operationStack.add(operation);
                    }
                }
                else {
                    throw new InvalidExpressionException("Error symbol in expression");
                }
            }
        }
        if (!number.isEmpty()) {
            calcQueue.add(new NumberExpression(Double.parseDouble(number.toString())));
            number.setLength(0);
        }
        for (int j = operationStack.size() - 1; j >= 0; j--) {
            calcQueue.add(operationStack.remove(j));
        }
        return new Expression(inputExpression, calcQueue);
    }

    private static Integer addInteger(Integer num, Character ch) {
        if (num == null) {
            return Integer.parseInt(ch.toString());
        }
        return num * 10 + Integer.parseInt(ch.toString());
    }

}
