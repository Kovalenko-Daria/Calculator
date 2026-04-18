package calc.model;

import java.util.*;

public class Expression {
    private final String expression;
    private final ArrayList<ExpressionPart> calcQueue;

    public Expression(String expression, ArrayList<ExpressionPart> calcQueue) {
        this.expression = expression;
        this.calcQueue = calcQueue;
    }

    public String getExpression() {
        return this.expression;
    }

    public ArrayList<ExpressionPart> getCalcQueue() {
        return new ArrayList<ExpressionPart>(this.calcQueue);
    }

    public static boolean compare(Expression exp1, Expression exp2) {
        if (!exp1.getExpression().equals(exp2.getExpression()) || exp1.getCalcQueue().size() != exp2.getCalcQueue().size()) {
            return false;
        }
        for (int i = 0; i < exp1.getCalcQueue().size(); i++) {
            if (exp1.getCalcQueue().get(i).getClass() != exp2.getCalcQueue().get(i).getClass()) {
                return false;
            }
            if (!exp1.getCalcQueue().get(i).isEqual(exp2.getCalcQueue().get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void printExpression(Expression exp) {
        System.out.println(exp.getExpression());
        for (ExpressionPart part : exp.getCalcQueue()) {
            System.out.print(part.toString() + " ");
        }
        System.out.println();
    }

}
