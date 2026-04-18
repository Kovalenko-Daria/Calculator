package calc.model;

import java.math.BigDecimal;

public class CalculatedAnswer {
    private final Expression expression;
    private final BigDecimal answer;

    public CalculatedAnswer(Expression expression, BigDecimal answer) {
        this.expression = expression;
        this.answer = answer;
    }

    public Expression getExpression() {
        return this.expression;
    }

    public BigDecimal getAnswer() {
        return this.answer;
    }
}
