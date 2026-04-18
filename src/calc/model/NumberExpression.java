package calc.model;

import java.math.BigDecimal;

public class NumberExpression implements ExpressionPart{
    private final BigDecimal number;

    public NumberExpression(Double num) {
        this.number = BigDecimal.valueOf(num);
    }
@Override
    public BigDecimal getNumber() {
        return this.number;
    }

    @Override
    public String toString() {
        return this.number.toString();
    }

    @Override
    public boolean getIsBinary() {
        return false;
    }

    @Override
    public boolean isEqual(ExpressionPart expressionPart2) {
        if (expressionPart2 instanceof NumberExpression) {
            return this.getNumber().equals(expressionPart2.getNumber());
        }
        return false;
    }

    @Override
    public char getSymbol() {
        return ' ';
    }

}
