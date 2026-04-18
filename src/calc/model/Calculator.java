package calc.model;

import java.util.ArrayList;

public class Calculator {
    private final ArrayList<CalculatedAnswer> calculatorHistory;

    public Calculator() {
        this.calculatorHistory = new ArrayList<CalculatedAnswer>();
    }

    public void addCalculation(CalculatedAnswer calculatedAnswer) {
        calculatorHistory.add(calculatedAnswer);
    }
}
