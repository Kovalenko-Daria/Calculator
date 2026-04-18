package calc.exceptions;

public class UnknownOperationException extends CalculatorException{
    public UnknownOperationException(String message) {
        super(message);
    }
}
