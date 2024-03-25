package lab4.task2.Exceptions;

public abstract class CalculatorRuntimeException extends RuntimeException{
    public CalculatorRuntimeException(String message)
    {
        super(message);
    }
}
