package calc.model;

import java.math.BigDecimal;

public interface ExpressionPart {
    public BigDecimal getNumber();

    public char getSymbol();

    public boolean getIsBinary();

    public boolean isEqual(ExpressionPart expressionPart2);
}
