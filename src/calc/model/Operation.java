package calc.model;

import java.math.BigDecimal;

public enum Operation implements ExpressionPart {
    OPEN('(', 0, true),
    CLOSE(')', 0, true),
    ADDITION('+', 1, true),
    SUBTRACTION('-', 1, true),
    MULTIPLICATION('*', 2, true),
    DIVISION('/', 2, true),
    UNMIN('.', 3, false);

    private final char symbol;
    private final int priority;
    private boolean isBinary;

    private Operation(char symbol, int priority, boolean isBinary) {
        this.symbol = symbol;
        this.priority = priority;
        this.isBinary = isBinary;
    }

    @Override
    public char getSymbol() {
        return this.symbol;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean getIsBinary() {
        return this.isBinary;
    }

    public static Operation getOperationFromSymbol(char symbol) {
        for (Operation operation : Operation.values()) {
            if (operation.getSymbol() == symbol) {
                return operation;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.symbol + "";
    }

    @Override
    public BigDecimal getNumber() {
        return null;
    }

    @Override
    public boolean isEqual(ExpressionPart expressionPart2) {
        if (expressionPart2 instanceof Operation) {
            return this.getSymbol() == expressionPart2.getSymbol();
        }
        return false;
    }
}
